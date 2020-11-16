package observer;

public class MyListener implements OnStringBuilderChangeListener{

    @Override
    public void onChange(ObservableStringBuilder stringBuilder) {
        System.out.println("ИЗМЕНЕНО: " + stringBuilder.toString());
    }
}