import java.util.Scanner;

public class PlantillaHastaQue {
    Scanner sc;

    public static void main(String[] args) {
        new PlantillaHastaQue().run();
    }

    private void run() {
        sc = new Scanner(System.in);
        while (caso())
            ;
    }

    private boolean caso() {
        int num = sc.nextInt();
        if (num == 0) {
            return false;
        }
        // code
        return true;
    }
}
