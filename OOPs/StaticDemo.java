package OOPs;

class StaticTest {
    private static int x;
    private int y;

    StaticTest(int y){
        this.y = y;
    }

    public static int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public static void setX(int x) {
        StaticTest.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}

public class StaticDemo {
    public static void main(String[] args) {
        StaticTest t1 = new StaticTest(10);
        StaticTest t2 = new StaticTest(30);


        t1.setX(10);
        t2.setX(5);
        System.out.println(t1.getX());
        System.out.println(StaticTest.getX());

    }
}
