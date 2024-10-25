public class Literal_01 {
    public static void main(String[] args) {
        int decimalValue = 10;
        int octalValue = 010;
        int hexadecimalValue = 0X10;

        System.out.println("Decimal Value: " + decimalValue);
        System.out.println("Octal Value: " + octalValue);
        System.out.println("Hexadecimal Value: " + hexadecimalValue);

        // the programmer having the choice to specify the value in either decimal octal
        // or hexadecimal form, but JVM will always provide the value only in
        // hexadecimal form.
    }
}