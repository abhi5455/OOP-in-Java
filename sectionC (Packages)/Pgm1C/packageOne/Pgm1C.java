package Pgm1C.packageOne;

import Pgm1C.packageOne.ClassA;
import Pgm1C.packageOne.packageTwo.ClassB;

public class Pgm1C {
    public static void main(String[] args) {

        ClassA a = new ClassA();
        ClassB b = new ClassB();

        a.methodClassOne();
        b.methodClassTwo();
    }
}