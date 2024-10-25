public class Array_04 {
    public static void main(String[] args) {
        int[][] integerArray = new int[2][];

        System.out.println(integerArray);
        System.out.println(integerArray[0]);
        System.out.println(integerArray[0][0]); // NullPointerException

        /*
         * If we are trying to perform any operation on 'NULL', then we will get
         * RuntimeException saying 'NullPointerException'.
         */
    }
}
