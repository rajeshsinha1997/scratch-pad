public class TOV_03 {
    // static variable
    static int integerStaticVariable = 0;

    // instance method
    private void privateInstanceMethod() {
        System.out.println("Static Variable Value: " + TOV_03.integerStaticVariable);
    }

    public static void main(String[] args) {
        // create instance
        TOV_03 instance = new TOV_03();

        // call instance method
        instance.privateInstanceMethod();

        System.out.println("Static Variable Value: " + TOV_03.integerStaticVariable);
    }
}
