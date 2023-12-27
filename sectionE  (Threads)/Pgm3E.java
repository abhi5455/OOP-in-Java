class SharedData {
    int counter = 1;
    static int N;
}

class OddNumberPrinter extends Thread {
    SharedData sharedData;
    public OddNumberPrinter(SharedData sharedData) {
        this.sharedData = sharedData;
    }
    public void run() {
        synchronized (sharedData) {
            while (sharedData.counter < SharedData.N) {
                while (sharedData.counter % 2 == 0) {
                    try {
                        sharedData.wait();
                    } catch (InterruptedException e) {}
                }
                System.out.println("Odd thread: " + sharedData.counter);
                sharedData.counter++;
                sharedData.notify();
            }
        }
    }
}
class EvenNumberPrinter extends Thread {
    SharedData sharedData;
    public EvenNumberPrinter(SharedData sharedData) {
        this.sharedData = sharedData;
    }
    public void run() {
        synchronized (sharedData) {
            while (sharedData.counter < SharedData.N) {
                while (sharedData.counter % 2 == 1) {
                    try {
                        sharedData.wait();
                    } catch (InterruptedException e) {}
                }
                System.out.println("Even thread: " + sharedData.counter);
                sharedData.counter++;
                sharedData.notify();
            }
        }
    }
}

public class Pgm3E {
    public static void main(String[] args) {
        SharedData sharedData = new SharedData();
        SharedData.N = 10;
        OddNumberPrinter oddPrinter = new OddNumberPrinter(sharedData);
        EvenNumberPrinter evenPrinter = new EvenNumberPrinter(sharedData);
        oddPrinter.start();
        evenPrinter.start();
        try {
            oddPrinter.join();
            evenPrinter.join();
        } catch (InterruptedException e) {}
    }
}