package observer;

public class Main {

    public static void main(String[] args) {
        ObservableStringBuilder sb = new ObservableStringBuilder();
        sb.setOnChangeListener(new MyListener());
        sb.append("I want to sleeeeeeeeep. ");
        sb.delete(12, 19);
    }
}
