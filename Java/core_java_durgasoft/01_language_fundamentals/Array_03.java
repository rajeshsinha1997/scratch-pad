public class Array_03 {
    public static void main(String[] args) {
        int[][] integerArray = new int[2][3];

        /*
         * Whenever we are trying to print any reference variable in Java, internally
         * 'toString()' method will be called, which is implemented by default to return
         * the String in the following form:
         * 
         * classname@hash_code_in_hexadecimal_form
         */

        System.out.println(integerArray);
        System.out.println(integerArray[0]);
        System.out.println(integerArray[0][0]);
    }
}