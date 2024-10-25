public class Array_09 {
    public static void main(String[] args) {
        int[] integerArray = new int[5];

        integerArray[0] = 10;

        integerArray[1] = 'a';

        byte b = 20;
        integerArray[2] = b;

        short s = 30;
        integerArray[3] = s;

        // integerArray[4] = 40L; --> compile time error

        for (int value : integerArray) {
            System.out.println("Array Value: " + value);
        }
    }
}
