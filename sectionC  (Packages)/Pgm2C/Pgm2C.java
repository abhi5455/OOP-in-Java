package Pgm2C;

import Pgm2C.animalpackage.Carnivores.*;
import Pgm2C.animalpackage.Herbivores.*;

public class Pgm2C {
    public static void main(String[] args) {
        Cow c = new Cow();
        Elephant e = new Elephant();

        Lion l = new Lion();
        Bear b = new Bear();

        c.get_cries();
        c.get_eating_type();
        e.get_cries();
        e.get_eating_type();
        l.get_cries();
        l.get_eating_type();
        b.get_cries();
        b.get_eating_type();
    }
}