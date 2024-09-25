import java.util.Scanner;

public class rot13 {
    public static final char[] lMin = { 'a', 'á', 'b', 'c', 'd', 'e', 'é', 'f', 'g', 'h', 'i', 'í', 'j', 'k', 'l', 'm',
            'n', 'ñ', 'o', 'ó', 'p', 'q', 'r', 's', 't', 'u', 'ú', 'v', 'x', 'y', 'z' };

    public static final char[] lMay = { 'A', 'Á', 'B', 'C', 'D', 'E', 'É', 'F', 'G', 'H', 'I', 'Í', 'J', 'K', 'L', 'M',
            'N', 'Ñ', 'O', 'Ó', 'P', 'Q', 'R', 'S', 'T', 'U', 'Ú', 'V', 'X', 'Y', 'Z' };

    public static String xifraRot13(String cadena) {
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
                for (int c = 0; c < lMay.length; c++) {
                    if (cadena.charAt(l) == lMay[c]) {
                        posicio = c + 13;
                        if (posicio >= lMay.length) {
                            posicio = posicio - lMay.length;
                        }
                        nCadena = nCadena + lMay[posicio];
                        break;
                    }
                }
            } else {
                for (int c = 0; c < lMin.length; c++) {
                    if (cadena.charAt(l) == lMin[c]) {
                        posicio = c + 13;
                        if (posicio >= lMin.length) {
                            posicio = posicio - lMin.length;
                        }
                        nCadena = nCadena + lMin[posicio];
                        break;
                    }
                }
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
                for (int c = 0; c < lMay.length; c++) {
                    if (cadena.charAt(l) == lMay[c]) {
                        posicio = c + -13;
                        if (posicio < 0) {
                            posicio = posicio + lMay.length;
                        }
                        nCadena = nCadena + lMay[posicio];
                        break;
                    }
                }
            } else {
                for (int c = 0; c < lMin.length; c++) {
                    if (cadena.charAt(l) == lMin[c]) {
                        posicio = c + -13;
                        if (posicio < 0) {
                            posicio = posicio + lMin.length;
                        }
                        nCadena = nCadena + lMin[posicio];
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

            }
            System.out.println("No té entès, torna-ho a escriure.");
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