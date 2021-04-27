package AceptaElReto;

import java.util.Scanner;

public class AER471_BuscandoElPinchazo {
    Scanner sc;

    public static void main(String[] args) {
        new AER471_BuscandoElPinchazo().run();
    }

    private void run() {
        sc = new Scanner(System.in);
        int veces = sc.nextInt();
        for (int i = 0; i < veces; i++) {
            caso();
        }
    }

    private void caso() {
        int start = 0;
        int pichazo = sc.nextInt() - sc.nextInt();
        int distancia = start + pichazo;
        if (distancia == 180 || distancia == -180 || distancia == 0) {
            System.out.println("DA IGUAL");
        } else if ((distancia < 180 && distancia > 0) || (distancia < -180)) {
            System.out.println("DESCENDENTE");
        } else {
            System.out.println("ASCENDENTE");
        }
    }
}
