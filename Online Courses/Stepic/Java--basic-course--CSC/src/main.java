import java.util.function.*;

public class main {
    public static void main(String[] args) {
        A myA = new A();
        B myB = new B();

        myA.a = 3;
        System.out.println(myA.a);
    }
    static class A{
        private int a;
        public int getA(){
            return this.a;
        }
    }

}


