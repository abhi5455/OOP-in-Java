class Data {
    private int num;
    private boolean hasnum = false;
    public synchronized void setnum(int num) {
        this.num = num;
    }
    public synchronized int getnum() {
        return this.num;
    }
    public synchronized void sethasnum(boolean n) {
        hasnum = n;
    }
    public synchronized boolean gethasnum() {
        return this.hasnum;
    }
}

class RandomThread extends Thread {
    Data d;
    public RandomThread(Data d) {
        this.d = d;
    }
    public void run() {
        while (true) {
            if (d.gethasnum() == false) {
                d.setnum((int) (Math.random() * 100));
                d.sethasnum(true);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}

class Even extends Thread {
    Data d;
    public Even(Data d) {
        this.d = d;
    }
    public void run() {
        while (true) {
            if (d.gethasnum() && d.getnum() % 2 == 0) {
                System.out.println(d.getnum() + " Even");
                d.sethasnum(false);
            }
        }
    }
}

class Odd extends Thread {
    Data d;
    public Odd(Data d) {
        this.d = d;
    }
    public void run() {
        while (true) {
            if (d.gethasnum() && d.getnum() % 2 == 1) {
                System.out.println(d.getnum() + " Odd");
                d.sethasnum(false);
            }
        }
    }
}

public class Pgm2E {
    public static void main(String[] args) {
        Data d = new Data();
        RandomThread rt = new RandomThread(d);
        Even e = new Even(d);
        Odd o = new Odd(d);
        rt.start();
        e.start();
        o.start();
    }
}