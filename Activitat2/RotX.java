public class RotX {

    public static final char[] LMIN = { 'a', 'á', 'à', 'b', 'c', 'ç', 'd', 'e', 'é', 'è', 'f', 'g', 'h', 'i', 'í', 'ì',
            'j', 'k', 'l', 'm', 'n', 'ñ', 'o', 'ó', 'ò', 'p', 'q', 'r', 's', 't', 'u', 'ú', 'ù', 'v', 'x', 'y', 'z' };

    public static final char[] LMAY = { 'A', 'Á', 'À', 'B', 'C', 'Ç', 'D', 'E', 'É', 'È', 'F', 'G', 'H', 'I', 'Í', 'Ì',
            'J', 'K', 'L', 'M', 'N', 'Ñ', 'O', 'Ó', 'Ò', 'P', 'Q', 'R', 'S', 'T', 'U', 'Ú', 'Ù', 'V', 'X', 'Y', 'Z' };

    public static void main(String[] args) {

    }

    public static String xifraRotX(String cadena, int desplaçament) {
        // L= lletra C= Caracter
        String nCadena = "";
        boolean esMajuscula = false;
        int posicio = 0;

        for (int l = 0; l < cadena.length(); l++) {
            if (Character.isUpperCase(cadena.charAt(l)) && Character.isLetter(cadena.charAt(l))) {
                esMajuscula = true;
            } else if (Character.isLowerCase(cadena.charAt(l)) && Character.isLetter(cadena.charAt(l))) {
                esMajuscula = false;
            }
            if (Character.isLetter(cadena.charAt(l))) {
                if (esMajuscula) {
                    for (int c = 0; c < LMAY.length; c++) {
                        if (cadena.charAt(l) == LMAY[c]) {
                            posicio = c + desplaçament;
                            if (posicio >= LMAY.length) {
                                posicio = posicio % LMAY.length;
                            }
                            nCadena = nCadena + LMAY[posicio];
                            break;
                        }
                    }
                } else {
                    for (int c = 0; c < LMIN.length; c++) {
                        if (cadena.charAt(l) == LMIN[c]) {
                            posicio = c + desplaçament;
                            if (posicio >= LMIN.length) {
                                posicio = posicio % LMIN.length;
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
        boolean esMajuscula = false;
        int posicio = 0;

        for (int l = 0; l < cadena.length(); l++) {
            if (Character.isUpperCase(cadena.charAt(l)) && Character.isLetter(cadena.charAt(l))) {
                esMajuscula = true;
            } else if (Character.isLowerCase(cadena.charAt(l)) && Character.isLetter(cadena.charAt(l))) {
                esMajuscula = false;
            }
            if (Character.isLetter(cadena.charAt(l))) {
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
            } else {
                nCadena = nCadena + cadena.charAt(l);
            }
        }
        return nCadena;
    }
}
