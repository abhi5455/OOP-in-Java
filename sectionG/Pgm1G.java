import java.util.Scanner;

class DataNode {
    public DataNode left;
    public DataNode right;
    public int data;

    public DataNode(DataNode left, DataNode right, int data) {
        this.left = left;
        this.right = right;
        this.data = data;
    }
}
class DoublyLinkedList {
    public final static int ERROR = -999999;
    private final DataNode header = new DataNode(null, null, -1);

    public void addFront(int data) {
        DataNode temp = new DataNode(header, header.right, data);
        if(header.right != null) {
            header.right.left = temp;
        }
        header.right = temp;
    }

    public void addRear(int data) {
        DataNode nd = new DataNode(null, null, data);
        DataNode temp = header;

        while(temp.right != null) {
            temp = temp.right;
        }

        nd.left = temp;
        temp.right = nd;
    }

    public void addAt(int data, int key) {
        DataNode temp = header.right;
        while(temp != null) {
            if(temp.data == key) {
                DataNode nd = new DataNode(temp, temp.right, data);
                if(temp.right != null) {
                    temp.right.left = nd;
                }
            }
            temp = temp.right;
        }
    }

    public int deleteAt(int key) {
        DataNode temp = header.right;
        while(temp != null && temp.data != key) {
            temp = temp.right;
        }

        if(temp == null) {
            System.out.println("Item not found");
            return ERROR;
        }

        temp.left.right = temp.right;
        if(temp.right != null) {
            temp.right.left = temp.left;
        }
        System.out.println("Deleted: " + temp.data);
        return temp.data;
    }

    public int deleteFront() {
        if(header.right == null) {
            return ERROR;
        }
        header.right.left = header;
        header.right = header.right.right;
        header.right.left = header;
        return header.right.data;
    }

    public int deleteRear() {
        if(header.right == null) {
            return ERROR;
        }

        DataNode temp = header;
        while(temp.right != null) {
            temp = temp.right;
        }
        temp.left.right = null;
        return temp.data;
    }

    public void display() {
        DataNode temp = header.right;

        while(temp != null) {
            System.out.println("Data: " + temp.data);
            temp = temp.right;
        }
    }
}


public class Pgm1G {
    private static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        DoublyLinkedList dl = new DoublyLinkedList();
        System.out.println("Choices:\n1 - Insert front\n2 - Insert rear\n3 - Insert at\n4 - Delete front\n5 - Delete rear\n6 - Delete at\n7 - Display\n8 - Exit");

        while(true) {
            System.out.print("Choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    dl.addFront(getInput("Enter element: "));
                    break;
                case 2:
                    dl.addRear(getInput("Enter element: "));
                    break;
                case 3:
                    dl.addAt(getInput("Enter element: "), getInput("Key: "));
                    break;
                case 4:
                    System.out.println("Deleted: " + dl.deleteFront());
                    break;
                case 5:
                    System.out.println("Deleted: " + dl.deleteRear());
                    break;
                case 6:
                    System.out.println("Deleted: " + dl.deleteAt(getInput("Key: ")));
                    break;
                case 7:
                    dl.display();
                    break;
                case 8:
                    System.exit(0);
                    break;
            }
        }
    }
    static int getInput(String txt) {
        System.out.print(txt);
        return sc.nextInt();
    }
}
