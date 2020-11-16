public class Vector {

    public double x;
    public double y;
    public double z;

    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public String printVector() {
        return (x + "  " + y + "  " + z);
    }

    public double vectorLenght() {
        return Math.sqrt( x * x + y * y + z * z);
    }

    public double scalarProduct(Vector vector) {
        double x2 = vector.x;
        double y2 = vector.y;
        double z2 = vector.z;
        return x * x2 + y * y2 + z * z2;
    }

    public Vector vectorProduct(Vector vector) {
        double newX, newY, newZ;
        double x2 = vector.x;
        double y2 = vector.y;
        double z2 = vector.z;
        newX = y * z2 - z * y2;
        newY = z * x2 - x * z2;
        newZ = x * y2 - y * x2;
        return new Vector(newX, newY, newZ);
    }

    public double cosine(Vector vector) {
        double cos;
        cos = scalarProduct(vector) / (Math.abs(vectorLenght()) * Math.abs(vector.vectorLenght()));
        return cos;
    }

    public Vector sum(Vector vector) {
        double newX, newY, newZ;
        double x2 = vector.x;
        double y2 = vector.y;
        double z2 = vector.z;
        newX = x + x2;
        newY = y + y2;
        newZ = z + z2;
        return new Vector(newX, newY, newZ);
    }

    public Vector difference(Vector vector) {
        double newX, newY, newZ;
        double x2 = vector.x;
        double y2 = vector.y;
        double z2 = vector.z;
        newX = x - x2;
        newY = y - y2;
        newZ = z - z2;
        return new Vector(newX, newY, newZ);
    }

    public static Vector[] create(int N){
        Vector[] vectorList = new Vector[N];
        for(int i =0; i < N; i++){
            vectorList[i] = new Vector(Math.random() * 10, Math.random() * 10, Math.random() * 10);
        }
        return vectorList;
    }

    public static void main(String[] args) {
        Vector[] vectorList = Vector.create(2);
        System.out.println("Первый вектор:");
        System.out.println(vectorList[0].printVector());
        System.out.println("Второй вектор:");
        System.out.println(vectorList[1].printVector());
        System.out.println("Длина вектора:");
        System.out.println(vectorList[0].vectorLenght());
        System.out.println("Скалярное произведение 2-х векторов:");
        System.out.println(vectorList[0].scalarProduct(vectorList[1]));
        System.out.println("Векторное произведение:");
        System.out.println(vectorList[0].vectorProduct(vectorList[1]).printVector());
        System.out.println("Косинус угла между векторами:");
        System.out.println(vectorList[0].cosine(vectorList[1]));
        System.out.println("Сумма векторов:");
        System.out.println(vectorList[0].sum(vectorList[1]).printVector());
        System.out.println("Разность векторов:");
        System.out.println(vectorList[0].difference(vectorList[1]).printVector());
    }
}
