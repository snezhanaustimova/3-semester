package filter;

import java.util.Arrays;

public class Main {
    public static Object[] filter(Object[] array, Filter filter) {
        int offset = 0;
        for (int i = 0; i < array.length; i++) {
            if(!filter.apply(array[i])){
                offset ++;
            } else {
                array[i - offset] = array[i];
            }
        }
        return Arrays.copyOf(array, array.length - offset);
    }
    public static void main(String[] args) {
        String array[] = new String[] {"hfakh", "jakfaj", null};
        String newArray[] = filter(array, new Filter() {
            @Override
            public boolean apply(Object o) {
                return o != null;
            }
        });
    }
}
