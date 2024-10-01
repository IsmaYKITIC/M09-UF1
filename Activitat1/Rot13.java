import java.util.Scanner;

public class Rot13 {
    public static final char[] LMIN = { 'a', 'á', 'b', 'c', 'd', 'e', 'é', 'f', 'g', 'h', 'i', 'í', 'j', 'k', 'l', 'm',
            'n', 'ñ', 'o', 'ó', 'p', 'q', 'r', 's', 't', 'u', 'ú', 'v', 'x', 'y', 'z' };

    public static final char[] LMAY = { 'A', 'Á', 'B', 'C', 'D', 'E', 'É', 'F', 'G', 'H', 'I', 'Í', 'J', 'K', 'L', 'M',
            'N', 'Ñ', 'O', 'Ó', 'P', 'Q', 'R', 'S', 'T', 'U', 'Ú', 'V', 'X', 'Y', 'Z' };

    public static String xifraRot13(String cadena) {
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

    public static void main(String[] args) {

        String[] senseXifra = { "hola soc en Pera!", "El Zoro dorm zzzz", "M9 es molt divertit :)" };
        String[] xifrat = { xifraRot13(senseXifra[0]), xifraRot13(senseXifra[1]), xifraRot13(senseXifra[2]) };
        System.out.println("XIFRAT");
        System.out.println(senseXifra[0] + " --> " + xifraRot13(senseXifra[0]));
        System.out.println(senseXifra[1] + " --> " + xifraRot13(senseXifra[1]));
        System.out.println(senseXifra[2] + " --> " + xifraRot13(senseXifra[2]));
        System.out.println();
        System.out.println("DEXIFRAT");
        System.out.println(xifrat[0] + " --> " + desxifraRot13(xifrat[0]));
        System.out.println(xifrat[1] + " --> " + desxifraRot13(xifrat[1]));
        System.out.println(xifrat[2] + " --> " + desxifraRot13(xifrat[2]));

    }
}