import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class D {
    Scanner sc;
    Double[] potencias = new Double[30];

    public static void main(String[] args) {
        new D().run();
    }

    private void run() {
        calcularPotencias2();
        sc = new Scanner(System.in);
        int veces = sc.nextInt();
        for (int i = 0; i < veces; i++) {
            caso();
        }
    }

    private void calcularPotencias2() {
        double num = 0;
        long max = Long.parseLong("1000000000");
        int index = 1;
        while (num < max) {
            num = Math.pow(2, index);
            potencias[index - 1] = num;
            index++;
        }
    }

    private void caso() {
        long numero = sc.nextLong();
        if (numero == 1) {
            System.out.println("0");
            return;
        }
        int pos = Arrays.binarySearch(potencias, (double) numero);
        System.out.println(pos < 0 ? -pos : pos + 1);
    }
}
