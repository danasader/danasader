
// Dana Sader

public class DecimalToDual {

    public static String transformDual (int dec){
        
        String transformDual= "";  /* An empty string should be used. If you enter a number in the
string, you will get the number next to the binary number in the output. */

        int b;

        while (dec != 0) {       // b is the remainder, dec is the decimal number, transformDual is the next remainder
            b = dec % 2;
            transformDual= b + transformDual ;
            dec = dec / 2;
        }
        return transformDual;
    }

    public static void main(String[] args) {
        
        System.out.print(transformDual(19));
        System.out.println("\n");
        System.out.println(transformDual(15));
        System.out.println("\n");
        System.out.println(transformDual(72));
        System.out.println("\n");
        System.out.println(transformDual(98));
        System.out.println(transformDual(13));
        System.out.println(transformDual(65));
    }
}



