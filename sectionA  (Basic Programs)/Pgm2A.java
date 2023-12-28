import java.util.Scanner;

class Characters {
    private String str;
    public Characters(String c) {
        this.str = c;
    }
    public int getFreq(char key) {
        int count = 0;
        for(int i = 0; i < str.length(); i++) {
            if(this.str.charAt(i) == key) {
                count++;
            }
        }
        return count;
    }
}

public class Pgm2A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str;
        char key;
        System.out.print("String: ");
        str = sc.next();
        System.out.print("Key: ");
        key = sc.next().charAt(0);
        Characters chr = new Characters(str);
        System.out.println("Frequency of '"+key+ "' is " + chr.getFreq(key));
    }
}