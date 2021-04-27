package AceptaElReto;

import java.util.Scanner;

public class AER468_ElMejorPeorDiaDeTuVida {
    Scanner sc;

    public static void main(String[] args) {
        new AER468_ElMejorPeorDiaDeTuVida().run();
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
        int dias = sc.nextInt();
        int peor = sc.nextInt();
        int dif = 0;
        int actual;
        int aux;
        for (int i = 1; i < dias; i++) {
            actual = sc.nextInt();
            if (actual <= peor) {
                peor = actual;
            } else {
                aux = actual - peor;
                if (aux > dif) {
                    dif = aux;
                }
            }
        }
        System.out.println(dif);
        return true;
    }
}

