package observer;

public class ObservableStringBuilder {

    private OnStringBuilderChangeListener onChangeListener;

    private StringBuilder stringBuilder;

    public void  setOnChangeListener(OnStringBuilderChangeListener stringBuilderChangeListener) {
        this.onChangeListener = stringBuilderChangeListener;
    }

    public ObservableStringBuilder() {
        stringBuilder = new StringBuilder();
    }

    private void notifyOnStringBuilderChangeListener() {
        if (onChangeListener != null) {
            onChangeListener.onChange(this);
        }
    }

    public ObservableStringBuilder append(Object obj) {
        stringBuilder.append(obj);
        notifyOnStringBuilderChangeListener();
        return this;
    }

    public ObservableStringBuilder delete(int start, int end) {
        stringBuilder.delete(start, end);
        notifyOnStringBuilderChangeListener();
        return this;
    }

    public ObservableStringBuilder insert(int offset, Object obj) {
        stringBuilder.insert(offset, obj);
        notifyOnStringBuilderChangeListener();
        return this;
    }

    public ObservableStringBuilder reverse() {
        stringBuilder.reverse();
        notifyOnStringBuilderChangeListener();
        return this;
    }

    public ObservableStringBuilder insert(int index, String str) {
        stringBuilder.insert(index, str);
        notifyOnStringBuilderChangeListener();
        return this;
    }

    public ObservableStringBuilder substring(int start) {
        stringBuilder.substring(start);
        notifyOnStringBuilderChangeListener();
        return this;
    }

    public ObservableStringBuilder setLength(int len) {
        stringBuilder.setLength(len);
        notifyOnStringBuilderChangeListener();
        return this;
    }

    public String toString() {
        return stringBuilder.toString();
    }

}
