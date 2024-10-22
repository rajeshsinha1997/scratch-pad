public class Array_10 {
    public static void main(String[] args) {
        Object[] objectArray = new Object[3];

        // as array elements either declared type objects or it's child
        // class objects are allowed

        objectArray[0] = new Object();
        objectArray[1] = new String("Rajesh");
        objectArray[2] = new Thread();

        for (Object value : objectArray) {
            System.out.println("Array Element: " + value);
        }
    }
}
