import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.Collections;

public class Monoalfabetic {
    public static final char[] LMAY = {
        'A', 'Á', 'À', 'B', 'C', 'Ç', 'D', 'E', 'É', 'È', 'F', 'G', 'H', 'I', 'Í', 'Ì', 'Ï', 'J', 'K', 'L', 'M',
        'N', 'Ñ', 'O', 'Ó', 'Ò', 'Ö', 'P', 'Q', 'R', 'S', 'T', 'U', 'Ú', 'Ù', 'Ü', 'V', 'X', 'Y', 'Z'
    };
    public static final String[] X_STRINGS = { "hola soc en Pera!", "El Zorro dorm zzzz", "M9 es molt divertit :)" };

    
    public static char[] alfabetNou;

    public static char[] permutaAlfabet(char[] abecedari){
        List <Character> lletresList = new ArrayList<>();
            
        for (int i = 0; i < abecedari.length; i++) {
            lletresList.add(abecedari[i]);    
        }
        Collections.shuffle(lletresList);

        char[] lletresPermutades = new char[lletresList.size()];

        for (int i = 0; i < lletresList.size(); i++) {
            lletresPermutades[i]=lletresList.get(i);
        }
        return lletresPermutades;
    }

    public static String xifraMonoAlfa(String cadena){
        boolean esMajuscula= false;
        String nCadena="";

        for (int l = 0; l < cadena.length(); l++) {
            //Bloc de saparacio de majusulas i minusucles
            if (Character.isUpperCase(cadena.charAt(l)) && Character.isLetter(cadena.charAt(l))) {
                esMajuscula = true;
            } else if (Character.isLowerCase(cadena.charAt(l)) && Character.isLetter(cadena.charAt(l))) {
                esMajuscula = false;
            }
            //Bloc iteració
            if (Character.isLetter(cadena.charAt(l))) {
                if (esMajuscula) {
                    for (int i = 0; i < alfabetNou.length; i++) {
                        if (cadena.charAt(l) == LMAY[i]){
                            nCadena=nCadena+alfabetNou[i];
                            break;
                        }
                    }
                }else{
                    for (int i = 0; i < alfabetNou.length; i++) {
                        if (Character.toUpperCase(cadena.charAt(l)) == LMAY[i]){
                            nCadena=nCadena+Character.toLowerCase(alfabetNou[i]);
                            break;
                        }
                    }
                }
            }else{
                nCadena= nCadena+ cadena.charAt(l);
            }
        }
        return nCadena;  
    }

    public static String deixifraMonoAlfa(String cadena){
        boolean esMajuscula= false;
        String nCadena="";

        for (int l = 0; l < cadena.length(); l++) {
            //Bloc de saparacio de majusulas i minusucles
            if (Character.isUpperCase(cadena.charAt(l)) && Character.isLetter(cadena.charAt(l))) {
                esMajuscula = true;
            } else if (Character.isLowerCase(cadena.charAt(l)) && Character.isLetter(cadena.charAt(l))) {
                esMajuscula = false;
            }
            //Bloc iteració
            if (Character.isLetter(cadena.charAt(l))) {
                if (esMajuscula) {
                    for (int i = 0; i < alfabetNou.length; i++) {
                        if (cadena.charAt(l) == alfabetNou[i]){
                            nCadena=nCadena+LMAY[i];
                            break;
                        }
                    }
                }else{
                    for (int i = 0; i < alfabetNou.length; i++) {
                        if (Character.toUpperCase(cadena.charAt(l)) == alfabetNou[i]){
                            nCadena=nCadena+Character.toLowerCase(LMAY[i]);
                            break;
                        }
                    }
                }
            }else{
                nCadena= nCadena+ cadena.charAt(l);
            }
        }
        return nCadena;
    }
    public static void main(String[] args) {

        alfabetNou=permutaAlfabet(LMAY);

        System.out.println("PER XIFRA: ");
        for (int i = 0; i < X_STRINGS.length; i++) {
            System.out.println(X_STRINGS[i]+ " --> "+ xifraMonoAlfa(X_STRINGS[i]));
            System.out.println();
        }
        System.out.println("PER DEXIFRA: ");
        for (int i = 0; i < X_STRINGS.length; i++) {
            System.out.println(xifraMonoAlfa(X_STRINGS[i])+ " --> "+ deixifraMonoAlfa(xifraMonoAlfa(X_STRINGS[i])) );
            System.out.println();
        }

            
    }
    
}