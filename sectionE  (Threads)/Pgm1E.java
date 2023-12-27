import java.util.Scanner;

class EvenException extends Exception {
    public String toString() {
        return "Even number";
    }
}

class OddException extends Exception {
    public String toString() {
        return "Odd number";
    }
}

class Number {
    public static void isEvenOrOdd(int n) throws EvenException, OddException {
        if(n % 2 == 0) {
            throw new EvenException();
        }
        throw new OddException();
    }
}

public class Pgm1E {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter n: ");
            Number.isEvenOrOdd(sc.nextInt());
        } catch (EvenException e) {
            System.out.println(e);
        } catch (OddException e) {
            System.out.println(e);
        }
    }
}
