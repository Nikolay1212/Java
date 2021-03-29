import java.util.Scanner;

public class Input {
    Scanner scanner = new Scanner(System.in);

    public int getNum() {
        return scanner.nextInt();
    }
    public String getBase() {
        scanner.nextLine();
        return scanner.nextLine();
    }
}
