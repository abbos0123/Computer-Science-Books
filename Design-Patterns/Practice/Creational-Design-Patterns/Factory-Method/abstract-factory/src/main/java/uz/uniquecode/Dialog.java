package uz.uniquecode;

public abstract class Dialog {
    public void renderWindows(){
        Button okButton = createButton();
        okButton.render();
    }

    public abstract Button createButton();
}
