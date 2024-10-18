public class Literal_05 {
    public static void main(String[] args) {
        // double doubleValue = 0786; --> compile time error
        double doubleValue = 0xFace;

        System.out.println("Double Value: " + doubleValue);
    }
}
