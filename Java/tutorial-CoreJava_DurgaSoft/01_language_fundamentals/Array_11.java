public class Array_11 {
    public static void main(String[] args) {
        Runnable[] runnableArray = new Runnable[1];

        // For 'Interface' type arrays as array elements, its implementation class
        // objects are allowed.

        runnableArray[0] = new Thread();
        // runnableArray[0] = new String("Rajesh"); --> compile time error
    }
}
