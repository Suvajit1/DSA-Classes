package OOPs;

class TestStatic {
    int x;
    private static int y;

    TestStatic(int x, int y){
        this.x = x;
        TestStatic.y = y;
    }

    public int getX() {
        return x;
    }

    public static int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public static void setY(int y) {
        TestStatic.y = y;
    }
}

public class StaticDemo {
    public static void main(String[] args) {
        TestStatic t1 = new TestStatic(10, 20);

        System.out.println(t1.getX());
        // System.out.println(t1.getY());


        TestStatic t2 = new TestStatic(5, 10);
        
        System.out.println(t2.getX());
        // System.out.println(t2.getY());

        // System.out.println(t1.getY());


        // System.out.println(TestStatic.y);

        // TestStatic.y = 30;
        // System.out.println(TestStatic.y);
        
        TestStatic.setY(20);
        System.out.println(TestStatic.getY());

    }
}
