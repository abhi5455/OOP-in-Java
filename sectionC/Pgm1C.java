package packageone;
public class ClassA {
    public void methodClassOne() {
        System.out.println("Printed from Class A");
    }
}


package packagetwo;
public class ClassB {
    public void methodClassTwo() {
        System.out.println("Printed from Class B");
    }
}



import packageone.ClassA;
import packagetwo.ClassB;
public class Pgm1C {
    public static void main(String[] args) {
        ClassA a = new ClassA();
        ClassB b = new ClassB();
        a.methodClassOne();
        b.methodClassTwo();
    }
}
