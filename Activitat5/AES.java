import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AES {
    public static final String ALGORISME_XIFRAT = "AES";
    public static final String ALGORISME_HASH = "SHA-256";
    public static final String FORMAT_AES = "AES/CBC/PKCS5Padding";

    private static final int MIDA_IV = 16;
    private static byte[] iv = new byte[MIDA_IV];
    private static final String CLAU = "123456789";

    public static byte[] xifraAES(String msg, String clau) throws Exception {
        // Obtenir els bytes de l’String
        byte[] mensajes = msg.getBytes("UTF-8");

        SecureRandom random = new SecureRandom();
        // omple en array amb bytes aleatoris
        random.nextBytes(iv);

        // Genera IvParameterSpec
        IvParameterSpec ips = new IvParameterSpec(iv);
        // Genera hash
        MessageDigest sha = MessageDigest.getInstance(ALGORISME_HASH);
        byte[] clave = sha.digest(clau.getBytes("UTF-8"));
        clave = Arrays.copyOf(clave, 16); // realitza iuna copia del arry peor nomes
        // amb el 16 primer bytes
        SecretKeySpec secretKey = new SecretKeySpec(clave, ALGORISME_XIFRAT);
        // iniclaitzcio dle cifrador
        Cipher xifrador = Cipher.getInstance(FORMAT_AES);
        // Encrypt.
        xifrador.init(xifrador.ENCRYPT_MODE, secretKey, ips);

        byte[] misatgeEncriptat = xifrador.doFinal(mensajes);
        // Combinar IV i part xifrada.
        byte[] combinat = new byte[iv.length + misatgeEncriptat.length];
        System.arraycopy(iv, 0, combinat, 0, MIDA_IV);
        System.arraycopy(misatgeEncriptat, 0, combinat, MIDA_IV, misatgeEncriptat.length);
        // return iv+msgxifrat
        return combinat;
    }

    public static String desxifraAES(byte[] bIvIMsgXifrat, String clau) throws Exception {
        // Extreure l'IV.
        byte[] vector = Arrays.copyOfRange(bIvIMsgXifrat, 0, MIDA_IV); // Los primeros 16 bytes son el IV
        IvParameterSpec ips = new IvParameterSpec(vector);
        // Extreure la part xifrada.
        byte[] msgxifrat = Arrays.copyOfRange(bIvIMsgXifrat, MIDA_IV, bIvIMsgXifrat.length); // Corregir aquí
        // Fer hash de la clau
        MessageDigest sha = MessageDigest.getInstance(ALGORISME_HASH);
        byte[] cDexifratge = sha.digest(clau.getBytes("UTF-8"));
        cDexifratge = Arrays.copyOf(cDexifratge, 16);

        SecretKeySpec secretKey = new SecretKeySpec(cDexifratge, ALGORISME_XIFRAT);
        // Desxifrar.
        Cipher xifrador = Cipher.getInstance(FORMAT_AES);
        xifrador.init(Cipher.DECRYPT_MODE, secretKey, ips);

        byte[] desxifrat = xifrador.doFinal(msgxifrat);
        // return String desxifrat
        return new String(desxifrat, "UTF-8");
    }

    public static void main(String[] args) {
        String msgs[] = { "Lorem ipsum dicet", "Hola Andrés cómo está tu cuñado", "Àgora ïlla Ôtto" };
        for (String msg : msgs) {
            byte[] bXifrats = null;
            String desxifrat = "";
            try {
                bXifrats = xifraAES(msg, CLAU);
                desxifrat = desxifraAES(bXifrats, CLAU);
            } catch (Exception e) {
                System.err.println("Error de xifrat: "
                        + e.getLocalizedMessage());

            }
            System.out.println("--------------------");
            System.out.println("Msg: " + msg);
            System.out.println("Enc: " + new String(bXifrats));
            System.out.println("DEC: " + desxifrat);
        }
    }

}
