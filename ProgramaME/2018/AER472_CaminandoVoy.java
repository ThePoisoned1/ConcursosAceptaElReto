package AceptaElReto;

import java.util.Scanner;

public class AER472_CaminandoVoy {
    Scanner sc;

    public static void main(String[] args) {
        new AER472_CaminandoVoy().run();
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
        int pendienteMax = sc.nextInt();
        int numDatos = sc.nextInt();
        int anterior = sc.nextInt();
        int cuesta = 0;
        int actual;
        for (int i = 1; i < numDatos; i++) {
            actual = sc.nextInt();
            if (actual > anterior) {
                cuesta += actual - anterior;
            } else {
                cuesta = 0;
            }
            if (cuesta > pendienteMax) {
                sc.nextLine();
                System.out.println("NO APTA");
                return true;
            }
            anterior = actual;
        }
        System.out.println("APTA");
        return true;
    }
}
