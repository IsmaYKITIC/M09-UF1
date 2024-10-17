import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Random;

public class Polialfabetic {
    public static final char[] LMAY = {
            'A', 'Á', 'À', 'B', 'C', 'Ç', 'D', 'E', 'É', 'È', 'F', 'G', 'H', 'I', 'Í', 'Ì', 'Ï', 'J', 'K', 'L', 'M',
            'N', 'Ñ', 'O', 'Ó', 'Ò', 'Ö', 'P', 'Q', 'R', 'S', 'T', 'U', 'Ú', 'Ù', 'Ü', 'V', 'X', 'Y', 'Z'
    };
    public static final String[] X_STRINGS = { "hola soc en Pera!", "El Zorro dorm zzzz", "M9 es molt divertit :)" };

    private static Random random;

    public static char[] permutaAlfabet() {
        List<Character> lletresList = new ArrayList<>();
        for (char c : LMAY) {
            lletresList.add(c);
        }
        Collections.shuffle(lletresList, random);
        char[] lletresPermutades = new char[lletresList.size()];
        for (int i = 0; i < lletresList.size(); i++) {
            lletresPermutades[i] = lletresList.get(i);
        }
        return lletresPermutades;
    }

    public static String xifraPoliAlfa(String cadena, int clau) {
        random = new Random(clau);
        StringBuilder nCadena = new StringBuilder();
        for (int l = 0; l < cadena.length(); l++) {
            char[] alfabetNou = permutaAlfabet();
            char c = cadena.charAt(l);
            if (Character.isLetter(c)) {
                if (Character.isUpperCase(c)) {
                    for (int i = 0; i < LMAY.length; i++) {
                        if (c == LMAY[i]) {
                            nCadena.append(alfabetNou[i]);
                            break;
                        }
                    }
                } else {
                    for (int i = 0; i < LMAY.length; i++) {
                        if (Character.toUpperCase(c) == LMAY[i]) {
                            nCadena.append(Character.toLowerCase(alfabetNou[i]));
                            break;
                        }
                    }
                }
            } else {
                nCadena.append(c);
            }
        }
        return nCadena.toString();
    }

    public static String desxifraPoliAlfa(String cadena, int clau) {
        random = new Random(clau);
        StringBuilder nCadena = new StringBuilder();
        for (int l = 0; l < cadena.length(); l++) {
            char[] alfabetNou = permutaAlfabet();
            char c = cadena.charAt(l);
            if (Character.isLetter(c)) {
                if (Character.isUpperCase(c)) {
                    for (int i = 0; i < alfabetNou.length; i++) {
                        if (c == alfabetNou[i]) {
                            nCadena.append(LMAY[i]);
                            break;
                        }
                    }
                } else {
                    for (int i = 0; i < alfabetNou.length; i++) {
                        if (Character.toUpperCase(c) == alfabetNou[i]) {
                            nCadena.append(Character.toLowerCase(LMAY[i]));
                            break;
                        }
                    }
                }
            } else {
                nCadena.append(c);
            }
        }
        return nCadena.toString();
    }

    public static void main(String[] args) {
        int clau = 12345;
        System.out.println("PER XIFRAR: ");
        for (String cadena : X_STRINGS) {
            String xifrat = xifraPoliAlfa(cadena, clau);
            System.out.println(cadena + " --> " + xifrat);
        }
        System.out.println("\nPER DESXIFRAR: ");
        for (String cadena : X_STRINGS) {
            String xifrat = xifraPoliAlfa(cadena, clau);
            String desxifrat = desxifraPoliAlfa(xifrat, clau);
            System.out.println(xifrat + " --> " + desxifrat);
        }
    }
}
