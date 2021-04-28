import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class H {
    Scanner sc;

    public static void main(String[] args) {
        new H().run();
    }

    private void run() {
        sc = new Scanner(System.in);
        while (caso())
            ;
    }

    private boolean caso() {
        if (!sc.hasNextLine()) {
            return false;
        }
        int annoAutor = sc.nextInt();
        sc.nextLine();
        int libros = sc.nextInt();
        boolean pasan = false;
        int minDiff = Integer.MAX_VALUE;
        int anno;
        int cantLibros = 0;
        String libro = "";
        for (int i = 0; i < libros; i++) {
            anno = sc.nextInt();
            if (anno < annoAutor) {
                sc.nextLine();
            } else {
                cantLibros++;
                pasan = true;
                if (anno - annoAutor < minDiff) {
                    minDiff = anno - annoAutor;
                    libro = sc.nextLine();
                } else {
                    sc.nextLine();
                }
            }
        }
        if (pasan && cantLibros > 1) {
            System.out.println(libro.substring(1));
            return true;
        }
        if (pasan) {
            System.out.println("TODAS");
            return true;
        } else {
            System.out.println("NINGUNA");
            return true;
        }

    }
}
