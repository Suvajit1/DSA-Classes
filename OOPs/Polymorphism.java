package OOPs;

class Test{
    public int sum(int x, int y){
        return x+y;
    }

    public int sum(int x, int y, int z){
        return x+y+z;
    }
}


class Super{
    public void diaplay1(){
        System.out.println("Super display1");
    }

    public void diaplay2(){
        System.out.println("Super diaplay2");
    }
}

class Sub extends Super{
    public void diaplay2(){
        System.out.println("Sub display2");
    }

    public void display3(){
        System.out.println("sub display3");
    }
}



public class Polymorphism {
    public static void main(String[] args) {
        Test t = new Test();

        // System.out.println(t.sum(1,2));
        // System.out.println(t.sum(1,3,5));


        Super su = new Super();
        Sub sb = new Sub();

        su.diaplay1();
        su.diaplay2();

        sb.diaplay1();
        sb.diaplay2();
        sb.display3();


        // dynamic method dispatch
        Super s = new Sub();

        s.diaplay1();
        s.diaplay2();

    }
}
