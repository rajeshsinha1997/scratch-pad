public class Array_08 {
    private static int sum(int[] integerArray) {
        int result = 0;

        for (int value : integerArray) {
            result += value;
        }

        return result;
    }

    public static void main(String[] args) {

        // anonymous array
        System.out.println("Sum: " + sum(new int[] { 10, 20, 30 }));
    }
}
