import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AER473_AlMundialEnElTransatlantico {
    Scanner sc;

    public static void main(String[] args) {
        new AER473_AlMundialEnElTransatlantico().run();
    }

    private void run() {
        sc = new Scanner(System.in);
        while (caso())
            ;
    }

    private boolean caso() {
        int numbolas = sc.nextInt();
        int fallaLa = sc.nextInt();
        if (numbolas == 0 && fallaLa == 0) {
            return false;

        }
        int pos = 0;
        List<Integer> bolas = new ArrayList<Integer>();
        for (int i = 1; i <= numbolas; i++) {
            bolas.add(i);
        }
        while (numbolas > 1) {
            pos = (pos + fallaLa - 1) % numbolas;
            bolas.remove(pos);
            numbolas--;
        }
        System.out.println(bolas.get(0));
        return true;
    }
}
