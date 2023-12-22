import java.util.Scanner;

class PalinCharacters {
    private String str;
    public PalinCharacters(String  c) {
        this.str = c;
    }
    public int isPalindrome() {
        int left = 0, right = this.str.length() - 1;
        while (left < right) {
            if (this.str.charAt(left) != this.str.charAt(right)) {
                return 0;
            }
            ++left;
            --right;
        }
        return 1;
    }
}

public class Pgm1A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str;
        System.out.print("String: ");
        str = sc.next();
        PalinCharacters pln = new PalinCharacters(str);
        if (pln.isPalindrome() == 1)
            System.out.println("The string is a palindrome");
        else
            System.out.println("The string is not a palindrome");
    }
}