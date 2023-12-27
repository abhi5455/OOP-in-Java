import java.util.Scanner;

class Matrix {
    int[][] arr;
    int m, n;
    public Matrix(int[][] arr, int m, int n) {
        this.arr = arr;
        this.m = m;
        this.n = n;
    }

    public void display() {
        for(int i=0; i<this.m; i++) {
            for(int j=0; j<this.n; j++) {
                System.out.print(this.arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    static Matrix mult(Matrix A, Matrix B) {
        int[][] arr = new int[A.m][B.n];

        for(int i=0; i<A.m; i++) {
            for(int j=0; j<B.n; j++) {
                arr[i][j] = 0;
                for(int k=0; k<A.n; k++) {
                    arr[i][j] += A.arr[i][k] * B.arr[k][j];
                }
            }
        }
        return new Matrix(arr, A.m, B.n);
    }

    static Matrix read() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter m n: ");
        int m = sc.nextInt(), n = sc.nextInt();
        int[][] arr = new int[m][n];
        System.out.println("Enter matrix: ");
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        return new Matrix(arr, m, n);
    }
}

public class Pgm3A {
    public static void main(String[] args) {
        Matrix A = Matrix.read(),
                B = Matrix.read();

        Matrix C = Matrix.mult(A, B);
        System.out.println("Result: ");
        C.display();
    }
}
