public class VAM_02 {

    // var-arg method
    private static void varArgMethod(int normalParameter, String... varArgParameters) {
        System.out.println("Value of Normal Parameter: " + normalParameter);
        System.out.println("Number of var-arg Parameters: " + varArgParameters.length);
    }

    public static void main(String[] args) {
        varArgMethod(1);
        varArgMethod(3, "First", "Second");
    }
}
