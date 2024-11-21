import java.security.MessageDigest;
import java.security.spec.KeySpec;
import java.util.HexFormat;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class Hashes {
    private int npass = 0;

    public String getSHA512AmbSalt(String pw, String salt) {
        String hash = null;
        try {
            String input = pw + salt;
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            byte[] abHash = md.digest(input.getBytes(java.nio.charset.StandardCharsets.UTF_8));
            java.util.HexFormat hex = java.util.HexFormat.of();
            hash = hex.formatHex(abHash);
        } catch (java.security.NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return hash;
    }

    public String getPBKDF2AmbSalt(String pw, String salt) {
        String hash = null;
        try {
            byte[] abSalt = salt.getBytes(java.nio.charset.StandardCharsets.UTF_8);
            KeySpec spec = new PBEKeySpec(pw.toCharArray(), abSalt, 65536, 128);
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            byte[] abHash = factory.generateSecret(spec).getEncoded();
            java.util.HexFormat hex = java.util.HexFormat.of();
            hash = hex.formatHex(abHash);
        } catch (java.security.NoSuchAlgorithmException | java.security.spec.InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return hash;
    }

    public String forcaBruta(String alg, String hash, String salt) throws Exception {
        String charset = "abcdefABCDEF1234567890!";
        int charsetLength = charset.length();
        npass = 0;

        for (int i1 = 0; i1 < charsetLength; i1++) {
            for (int i2 = 0; i2 < charsetLength; i2++) {
                for (int i3 = 0; i3 < charsetLength; i3++) {
                    for (int i4 = 0; i4 < charsetLength; i4++) {
                        for (int i5 = 0; i5 < charsetLength; i5++) {
                            for (int i6 = 0; i6 < charsetLength; i6++) {
                                npass++;

                                // Crear la contraseña
                                String candidate = "" +
                                        charset.charAt(i1) +
                                        charset.charAt(i2) +
                                        charset.charAt(i3) +
                                        charset.charAt(i4) +
                                        charset.charAt(i5) +
                                        charset.charAt(i6);

                                // Generar hash del candidato
                                String candidateHash = switch (alg) {
                                    case "SHA-512" -> getSHA512AmbSalt(candidate, salt);
                                    case "PBKDF2" -> getPBKDF2AmbSalt(candidate, salt);
                                    default -> throw new IllegalArgumentException("Algoritmo no soportado");
                                };

                                // Comparar hash
                                if (candidateHash.equals(hash)) {
                                    return candidate;
                                }
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    public String getInterval(long t1, long t2) {
        long diff = t2 - t1;
        long millis = diff % 1000;
        long seconds = (diff / 1000) % 60;
        long minutes = (diff / (1000 * 60)) % 60;
        long hours = (diff / (1000 * 60 * 60)) % 24;
        long days = diff / (1000 * 60 * 60 * 24);

        return String.format("%d dies / %d hores / %d minuts / %d segons / %d millis",
                days, hours, minutes, seconds, millis);
    }

    public static void main(String[] args) throws Exception {
        String salt = "qpoweiruañslkdfjz";
        String pw = "aaabF!";
        Hashes h = new Hashes();

        String[] aHashes = { h.getSHA512AmbSalt(pw, salt), h.getPBKDF2AmbSalt(pw, salt) };
        String[] algorismes = { "SHA-512", "PBKDF2" };

        for (int i = 0; i < aHashes.length; i++) {
            System.out.printf("===========================\n");
            System.out.printf("Algorisme: %s\n", algorismes[i]);
            System.out.printf("Hash: %s\n", aHashes[i]);
            System.out.printf("---------------------------\n");
            System.out.printf("-- Inici de força bruta ---\n");

            long t1 = System.currentTimeMillis();
            String pwTrobat = h.forcaBruta(algorismes[i], aHashes[i], salt);
            long t2 = System.currentTimeMillis();

            System.out.printf("Pass   : %s\n", pwTrobat);
            System.out.printf("Provats: %d\n", h.npass);
            System.out.printf("Temps  : %s\n", h.getInterval(t1, t2));
            System.out.printf("---------------------------\n\n");
        }
    }
}
