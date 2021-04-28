import java.util.Scanner;

public class G {
    Scanner sc;

    public static void main(String[] args) {
        new G().run();
    }

    private void run() {
        sc = new Scanner(System.in);
        int veces = sc.nextInt();
        for (int i = 0; i < veces; i++) {
            caso();
        }
    }

    private void caso() {
        int poblacion = sc.nextInt();
        int starkPos = sc.nextInt();
        int peterPos = sc.nextInt();
        int salto =sc.nextInt();
    }
}
