package OOPs;

class Rectangle {
    private int length;
    private int breadth;

    Rectangle(){
        this.length = 10;
        this.breadth = 10;
    }

    Rectangle(int l, int b){
        this.length = l;
        this.breadth = b;
    }

    // getter
    public String getInfo(){
        return this.length+" "+this.breadth;
    }
    // setter
    public void setLength(int l){
        this.length = l;
    }

    public void setBreadth(int b){
        this.breadth = b;
    }

    // property method
    public int area(){
        return this.length*this.breadth;
    }
    
}

public class OOPs {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(10, 20);
        Rectangle r2 = new Rectangle();

        System.out.println(r2.getInfo());  
        System.out.println(r1.area());  
        
        r2.setLength(5);
        System.out.println(r2.area());
    }
}
