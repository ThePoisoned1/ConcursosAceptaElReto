import java.util.Scanner;

public class PlantillaIndefinido {
    Scanner sc;

    public static void main(String[] args) {
        new PlantillaIndefinido().run();
    }

    private void run() {
        sc = new Scanner(System.in);
        while (caso())
            ;
    }

    private boolean caso() {
        if (!sc.hasNext()) {
            return false;
        }
        // code
        return true;
    }
}
