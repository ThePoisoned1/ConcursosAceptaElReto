package AceptaElReto;

import java.util.Scanner;

public class AER467_PolisilabaEsPolisilaba {
    Scanner sc;
    public static void main(String[] args) {
        new AER467_PolisilabaEsPolisilaba().run();
    }

    private void run() {
        sc = new Scanner(System.in);
        int veces = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < veces; i++) {
            caso();
        }
    }

    private void caso() {
        String[] linea = sc.nextLine().split(" ");
        System.out.println(linea[0].equalsIgnoreCase(linea[2]) ? "TAUTOLOGIA" : "NO TAUTOLOGIA");
    }
}
