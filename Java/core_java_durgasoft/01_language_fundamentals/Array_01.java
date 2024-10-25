/**
 * Array_01
 */
public class Array_01 {
    public static void main(String[] args) {
        int[] integerArray1D = new int[3];
        int[][] integerArray2D = new int[3][3];
        double[] doubleArray = new double[3];
        short[] shortArray = new short[3];
        byte[] byteArray = new byte[3];
        boolean[] booleanArray = new boolean[3];

        System.out.println("1D Integer Array Class: " + integerArray1D.getClass().getName());
        System.out.println("2D Integer Array Class: " + integerArray2D.getClass().getName());
        System.out.println("Double Array Class: " + doubleArray.getClass().getName());
        System.out.println("Short Array Class: " + shortArray.getClass().getName());
        System.out.println("Byte Array Class: " + byteArray.getClass().getName());
        System.out.println("Boolean Array Class: " + booleanArray.getClass().getName());
    }
}