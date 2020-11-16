public abstract class Shape {

    private double volume;

    public Shape (double volume){
        this.volume = volume;
    }

    public double getVolume() {
        return volume;
    }
}

class Pyramid extends Shape {

    private double s;
    private double h;

    public Pyramid(double s, double h) {
        super((s * h) / 3);
        this.s = s;
        this.h = h;
    }
}

abstract class SolidOfRevoluton extends Shape {

    private double radius;

    public SolidOfRevoluton (double volume, double radius ) {
        super(volume);
        this.radius = radius;
    }
}

class Cylinder extends SolidOfRevoluton {

    private double height;

    public Cylinder (double radius, double height) {
        super(Math.PI * radius * radius * height, radius);
        this.height = height;
    }
}

class Ball extends SolidOfRevoluton {
    public Ball (double radius) {
        super(4 / 3 * Math.PI * radius * radius * radius, radius);
    }
}

class Box extends Shape {
    private double possibility;
    public double shapeVolume;

    public Box(double possibility) {
        super(possibility);
        this.possibility = possibility;
    }

    public boolean add(Shape shape) {
        shapeVolume = shape.getVolume();
        System.out.println("Объем фигуры равен " + shapeVolume);
        System.out.println("Свободного места в ящике: " + possibility);
        if (shapeVolume <= possibility) {
            possibility -= shapeVolume;
            return true;
        } else {
            possibility -= shapeVolume;
            System.out.println("К сожалению, свободного места больше нет.");
            return false;
        }
    }
}

class Main {

    public static void main(String[] args) {
        Pyramid pyramid1 = new Pyramid(30.0, 9.0);
        Cylinder cylinder = new Cylinder(2 * Math.sqrt(2.0), 3.0);
        Ball ball1 = new Ball(1.0);
        Ball ball2 = new Ball(3.0);
        Pyramid pyramid2 = new Pyramid(3.0, 100.0);

        Box box = new Box(250.0);

        System.out.println(box.add(pyramid1));
        System.out.println();
        System.out.println(box.add(cylinder));
        System.out.println();
        System.out.println(box.add(ball1));
        System.out.println();
        System.out.println(box.add(ball2));
        System.out.println();
        System.out.println(box.add(pyramid2));
    }
}
