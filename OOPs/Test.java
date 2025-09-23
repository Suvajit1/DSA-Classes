package OOPs;

class Circle {
    private int r;

    Circle(){
        r=0;
        System.out.println("Circle");
    }

    Circle (int r){
        this.r = r;
        System.out.println("Circle Super");

    }

    public double area(){
        return Math.PI*r*r;
    }

    public double perimeter(){
        return 2*Math.PI*r;
    }
}

class Cylinder extends Circle{
    private int h;

    Cylinder(){
        h=0;
        System.out.println("Cylinder");
    }

    Cylinder(int r, int h){
        super(r);
        this.h = h;
        System.out.println("Cylinder parameterised");

    }

    public double volume(){
        return area()*h;
    }
    
}

public class Test {
    public static void main(String[] args) {

        // Circle c1 = new Circle(); // circle

        // Cylinder c2 = new Cylinder(); // circle
        //                               // cylinder


        // Cylinder c = new Cylinder(5,10);

    }
}
