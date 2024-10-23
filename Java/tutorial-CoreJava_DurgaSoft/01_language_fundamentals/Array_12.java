public class Array_12 {
    public static void main(String[] args) {
        String[] argh = { "X", "Y", "Z" };

        args = argh;

        for (String value : args) {
            System.out.println("Array Element: " + value);
        }
    }
}