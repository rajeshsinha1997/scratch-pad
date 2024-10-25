public class TOV_05 {
    // static variables
    static int integerStaticVariable = 10;

    // instance variable
    int integerInstanceVariable = 20;

    public static void main(String[] args) {
        // create instance
        TOV_05 instance1 = new TOV_05();

        instance1.integerStaticVariable = 888;
        instance1.integerInstanceVariable = 999;

        // create instance
        TOV_05 instance2 = new TOV_05();

        System.out.println("Static Variable Value: " + instance2.integerStaticVariable);
        System.out.println("Instance Variable Value: " + instance2.integerInstanceVariable);
    }
}
