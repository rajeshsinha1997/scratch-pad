public class VAM_03 {

    // var-arg method
    private static void method(int... parameters) {
        System.out.println("var-arg Method");
    }

    // normal method
    private static void method(int parameter) {
        System.out.println("Normal Method");
    }

    public static void main(String[] args) {
        method();
        method(10);
        method(10, 20);
    }
}
