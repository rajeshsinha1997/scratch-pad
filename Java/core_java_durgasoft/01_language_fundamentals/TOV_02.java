public class TOV_02 {

    // static variable
    static int integerStaticVariable = 0;

    public static void main(String[] args) {
        // create instance
        TOV_02 instance = new TOV_02();

        System.out.println("Static Variable Value: " + TOV_02.integerStaticVariable);
        System.out.println("Static Variable Value: " + instance.integerStaticVariable);
        System.out.println("Static Variable Value: " + integerStaticVariable);
    }
}
