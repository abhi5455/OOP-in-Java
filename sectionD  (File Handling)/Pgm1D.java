import java.io.*;

public class Pgm1D {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.print("Enter file name: ");
            String fileName = br.readLine();
            System.out.print("Enter file content: ");
            String writeText = br.readLine();

            FileWriter fw = new FileWriter(fileName);
            FileReader fr = new FileReader(fileName);

            System.out.println("Writing to file: " + fileName);
            fw.write(writeText);
            fw.close();

            System.out.println("Reading from file: " + fileName);
            int unit;
            while((unit = fr.read()) != -1) {
                System.out.print((char) unit);
            }
            System.out.println("\nFile read");
            fr.close();
        } catch (IOException e) {

            throw new RuntimeException(e);
        }
    }
}
