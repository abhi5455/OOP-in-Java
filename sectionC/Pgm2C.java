package animalpackage;
public interface Animal {
    void get_cries();
    void get_eating_type();
}




package animalpackage.herbivorous;
import animalpackage.Animal;

public class Elephant implements Animal {
    public void get_cries() {
        System.out.println("Elephant: Trumpet!");
    }
    public void get_eating_type() {
        System.out.println("Elephant: Herbivorous");
    }
}




package animalpackage.herbivorous;
import animalpackage.Animal;
public class Cow implements Animal {
    public void get_cries() {
        System.out.println("Cow: Moo!");
    }
    public void get_eating_type() {
        System.out.println("Cow: Herbivorous");
    }
}




package animalpackage.carnivourous;
import animalpackage.Animal;

public class Lion implements Animal {
    public void get_cries() {
        System.out.println("Lion: Roar!");
    }
    public void get_eating_type() {
        System.out.println("Lion: Carnivourous");
    }
}




package animalpackage.carnivourous;
import animalpackage.Animal;
public class Bear implements Animal {
    public void get_cries() {
        System.out.println("Bear: Roar!");
    }
    public void get_eating_type() {
        System.out.println("Bear: Carnivourous");
    }
}




import animalpackage.carnivourous.*;
import animalpackage.herbivorous.*;

public class Main1 {
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
