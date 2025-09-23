package OOPs;

interface Test1{
    public void method1();
    public void method2();
}

class Test2 implements Test1{
    public void method1(){
        System.out.println("method 1");
    }

    public void method2(){
        System.out.println("method 2");
    }
}

public class InterfaceDemo {
    public static void main(String[] args) {
        Test2 t = new Test2();
        t.method1();
        t.method2();
    }
}
