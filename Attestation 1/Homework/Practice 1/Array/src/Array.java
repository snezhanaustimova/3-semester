public class Array {

    private int[] value;
    private int[] weight;
    private double length;

    public String makeALine(int[] value, int[] weight) {

        this.value = value;
        this.weight = weight;
        String line = "";

        for (int i = 0; i < value.length; i++) {
            int k = 0;
            while (k < weight[i]) {
                line += value[i];
                k++;
            }
        }
        return line;
    }

    public static void main(String[] args) {
        int[] value = {1,2,3};
        int[] weight = {1,2,10};
        String a = "";
        Array array = new Array();
        a = array.makeALine(value, weight);
        int n = (int) (Math.random() * a.length());
        char symbol = a.charAt(n);
        int number = Character.getNumericValue(symbol);
        for (int i = 0; i < value.length; i++) {
            if (value[i] == number) {
                System.out.println("Случайное число: " + value[i]);
            }
        }
    }
}