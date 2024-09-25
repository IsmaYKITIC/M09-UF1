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
                        posicio = ((posicio + 13) - lMay.length);
                        nCadena = nCadena + lMay[posicio];
                    }
                    posicio = 0;
                }
            } else {
                for (int c = 0; c < lMin.length; c++) {
                    if (cadena.charAt(l) == lMay[c]) {
                        posicio = ((posicio + 13) - lMin.length);
                        nCadena = nCadena + lMin[posicio];
                    }
                    posicio = 0;
                }
            }

        }
        return nCadena;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa un text per codificar.");
        String cadena = scanner.nextLine();
        if (cadena.isBlank()) {
            return;
        }
        String Text = xifraRot13(cadena);
        System.out.println(Text);
    }
}