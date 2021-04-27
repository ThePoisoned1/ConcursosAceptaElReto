import java.util.Scanner;

public class PlantillaNumeroCasos {
    Scanner sc;

    public static void main(String[] args) {
        new PlantillaNumeroCasos().run();
    }

    private void run() {
        sc = new Scanner(System.in);
        int veces = sc.nextInt();
        for (int i = 0; i < veces; i++) {
            caso();
        }
    }

    private void caso() {

        // code

    }
}
