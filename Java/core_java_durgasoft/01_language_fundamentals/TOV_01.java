public class TOV_01 {

    // instance variables
    int integerInstanceVariable;
    double doubleInstanceVariable;
    boolean booleanInstanceVariable;
    String stringInstanceVariable;

    public static void main(String[] args) {
        // creating object
        TOV_01 instance = new TOV_01();

        System.out.println("Integer Instance Variable Default Value: " + instance.integerInstanceVariable);
        System.out.println("Double Instance Variable Default Value: " + instance.doubleInstanceVariable);
        System.out.println("Boolean Instance Variable Default Value: " + instance.booleanInstanceVariable);
        System.out.println("String Instance Variable Default Value: " + instance.stringInstanceVariable);
    }
}