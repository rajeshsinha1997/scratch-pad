public class Array_05 {
    public static void main(String[] args) {
        int[] integerArray = new int[6];

        // valid array indices
        integerArray[0] = 10;
        integerArray[1] = 10;
        integerArray[2] = 10;
        integerArray[3] = 10;
        integerArray[4] = 10;
        integerArray[5] = 10;
        integerArray[6] = 10;

        // invalid array indices
        integerArray[8] = 10; // ArrayIndexOutOfBoundsException
        integerArray[-8] = 10; // ArrayIndexOutOfBoundsException
        // integerArray[2.5] = 10; --> compile time error
    }
}
