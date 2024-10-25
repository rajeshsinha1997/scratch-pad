public class Literal_07 {
    public static void main(String[] args) {
        char characterValue1 = 'c';
        char characterValue2 = 99;
        char characterValue3 = 0xFace;
        char characterValue4 = 65535;
        // char characterValue5 = 65536; --> compile time error
        char characterValue6 = '\u0061';
        char characterValue7 = '\u0062';
        char escapeCharacter1 = '\t';

        System.out.println("Character Value: " + characterValue1);
        System.out.println("Character Value: " + characterValue2);
        System.out.println("Character Value: " + characterValue3);
        System.out.println("Character Value: " + characterValue4);
        System.out.println("Character Value: " + characterValue6);
        System.out.println("Character Value: " + characterValue7);
        System.out.println("Escape Character: " + escapeCharacter1);
    }
}