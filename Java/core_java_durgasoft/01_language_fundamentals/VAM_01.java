public class VAM_01 {

    // var-arg method
    private static void varArgMethod(int... parameters) {
        System.out.println("Number of Parameters Received: " + parameters.length);
    }

    public static void main(String[] args) {
        varArgMethod();
        varArgMethod(10);
        varArgMethod(10, 20);
        varArgMethod(10, 20, 30);
        varArgMethod(10, 20, 30, 40);
    }
}
