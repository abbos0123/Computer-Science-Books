package uz.uniquecode;

public class DemoApplication {

    private static Dialog dialog;
    public static void main(String[] args) {
        System.out.println("Hello world!");
        configure();
        runBusiness();
    }

    private static void configure(){
        if(System.getProperty("os.name").equals("Windows 11")){
            dialog = new WindowsDialog();
        }else {
            dialog = new HtmlDialog();
        }
    }

    private static void runBusiness(){
        dialog.renderWindows();
    }
}