import java.util.Scanner;

public class Rot13 {
    public static final char[] LMIN = { 'a', 'á', 'b', 'c', 'd', 'e', 'é', 'f', 'g', 'h', 'i', 'í', 'j', 'k', 'l', 'm',
            'n', 'ñ', 'o', 'ó', 'p', 'q', 'r', 's', 't', 'u', 'ú', 'v', 'x', 'y', 'z' };

    public static final char[] LMAY = { 'A', 'Á', 'B', 'C', 'D', 'E', 'É', 'F', 'G', 'H', 'I', 'Í', 'J', 'K', 'L', 'M',
            'N', 'Ñ', 'O', 'Ó', 'P', 'Q', 'R', 'S', 'T', 'U', 'Ú', 'V', 'X', 'Y', 'Z' };

    public static String xifraRot13(String cadena) {
        // L= lletra C= Caracter
        String nCadena = "";
        boolean esMajuscula;
        int posicio = 0;

        for (int l = 0; l < cadena.length(); l++) {
            if (Character.isUpperCase(cadena.charAt(l)) && Character.isLetter(cadena.charAt(l))) {
                esMajuscula = true;
            } else if (Character.isLoWerCase(cadena.charAt(l)) && Character.isLetter(cadena.charAt(l))) {
                esMajuscula = false;
            }
            if (Character.isLetter(cadena.charAt(l))) {
                if (esMajuscula) {
                    for (int c = 0; c < LMAY.length; c++) {
                        if (cadena.charAt(l) == LMAY[c]) {
                            posicio = c + 13;
                            if (posicio >= LMAY.length) {
                                posicio = posicio - LMAY.length;
                            }
                            nCadena = nCadena + LMAY[posicio];
                            break;
                        }
                    }
                } else {
                    for (int c = 0; c < LMIN.length; c++) {
                        if (cadena.charAt(l) == LMIN[c]) {
                            posicio = c + 13;
                            if (posicio >= LMIN.length) {
                                posicio = posicio - LMIN.length;
                            }
                            nCadena = nCadena + LMIN[posicio];
                            break;
                        }
                    }
                }
            } else {
                nCadena = nCadena + cadena.charAt(l);
            }
        }
        return nCadena;
    }

    public static String desxifraRot13(String cadena) {
        // L= lletra C= Caracter
        String nCadena = "";
        boolean esMajuscula;
        int posicio = 0;

        for (int l = 0; l < cadena.length(); l++) {
            if (Character.isUpperCase(cadena.charAt(l))) {
                esMajuscula = true;
            } else {
                esMajuscula = false;
            }

            if (esMajuscula) {
                for (int c = 0; c < LMAY.length; c++) {
                    if (cadena.charAt(l) == LMAY[c]) {
                        posicio = c + -13;
                        if (posicio < 0) {
                            posicio = posicio + LMAY.length;
                        }
                        nCadena = nCadena + LMAY[posicio];
                        break;
                    }
                }
            } else {
                for (int c = 0; c < LMIN.length; c++) {
                    if (cadena.charAt(l) == LMIN[c]) {
                        posicio = c + -13;
                        if (posicio < 0) {
                            posicio = posicio + LMIN.length;
                        }
                        nCadena = nCadena + LMIN[posicio];
                        break;
                    }
                }
            }
        }
        return nCadena;
    }

    public static String confirmador() {
        Scanner scanner = new Scanner(System.in);
        String text;
        System.out.println("Vols xifra o desxifra?");
        while (true) {
            text = scanner.nextLine();
            if (text.equals("xifra") || text.equals("Xifra") || text.equals("XIFRA")) {
                return text.toLowerCase();
            } else if (text.equals("desxifra") || text.equals("Desxifra") || text.equals("DESXIFRA")) {
                return text.toLowerCase();
            } else {
                System.out.println("No té entès, torna-ho a escriure.");
            }

        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String funcio = confirmador();

        System.out.println("Ingresa un text per codificar:");
        String cadena = scanner.nextLine();
        if (cadena.isBlank()) {
            return;
        }
        if (funcio.equals("xifra")) {
            System.out.println(xifraRot13(cadena));
        } else {
            System.out.println(desxifraRot13(cadena));
        }
    }
}