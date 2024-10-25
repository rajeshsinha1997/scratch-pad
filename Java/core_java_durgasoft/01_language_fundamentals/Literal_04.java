public class Literal_04 {
    public static void main(String[] args) {
        double doubleValue1 = 123.456;
        double doubleValue2 = 0123.456;
        // double doubleValue3 = 0x123.456; --> compile time error

        System.out.println("Double value: " + doubleValue1);
        System.out.println("Double Value: " + doubleValue2);
    }
}
