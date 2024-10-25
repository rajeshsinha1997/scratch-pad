public class Literal_09 {
    public static void main(String[] args) {
        double doubleValue1 = 1_23_456.7_8_9;
        double doubleValue2 = 123_456.7_8_9;
        double doubleValue3 = 1_2__3___456.7_8_9;

        // double doubleValue4 = _1_2__3___456.7_8_9; --> compile time error
        // double doubleValue5 = 1_2__3___456_.7_8_9; --> compile time error
        // double doubleValue6 = 1_2__3___456.7_8_9_; --> compile time error

        System.out.println("Double Value: " + doubleValue1);
        System.out.println("Double Value: " + doubleValue2);
        System.out.println("Double Value: " + doubleValue3);
    }
}
