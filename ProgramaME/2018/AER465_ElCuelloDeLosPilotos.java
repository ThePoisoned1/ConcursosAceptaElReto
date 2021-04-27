import java.util.Scanner;

public class AER465_ElCuelloDeLosPilotos {
    class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    Scanner sc;
    int derechas;
    int izquierdas;
    char direccion;
    StringBuilder[] circuito;

    public static void main(String[] args) {
        new AER465_ElCuelloDeLosPilotos().run();
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
        int[] dimensiones = new int[] { sc.nextInt(), sc.nextInt() };
        circuito = new StringBuilder[dimensiones[1]];
        for (int i = 0; i < dimensiones[1]; i++) {
            circuito[i] = new StringBuilder(sc.next());
        }
        Point pos = getPos0(circuito);
        derechas = 0;
        izquierdas = 0;
        direccion = 'p';
        Point aux = new Point(pos.x, pos.y);
        pos = firstMove(pos);
        while (!(pos.x == aux.x && pos.y == aux.y)) {
            aux.x = pos.x;
            aux.y = pos.y;
            pos = move(pos);
            // printCricuito();
        }
        System.out.println(Math.min(izquierdas, derechas) + " " + Math.max(izquierdas, derechas));
        return true;
    }

    private Point firstMove(Point pos) {
        circuito[(int) pos.y].replace(pos.x, pos.x + 1, "#");
        if (pos.y != 0 && circuito[pos.y - 1].charAt(pos.x) == '#') {

            direccion = 's';
            if (pos.x != 0 && circuito[pos.y].charAt(pos.x - 1) == '#') {
                izquierdas++;
            } else if (pos.x < circuito[pos.y].length() - 1 && circuito[pos.y].charAt(pos.x + 1) == '#') {
                derechas++;
            }
            pos.y--;
            return pos;
        }
        if (pos.x < circuito[pos.y].length() - 1 && circuito[pos.y].charAt(pos.x + 1) == '#') {

            direccion = 'd';
            if (pos.y != 0 && circuito[pos.y - 1].charAt(pos.x) == '#') {
                izquierdas++;
            } else if (pos.y < circuito.length - 1 && circuito[pos.y + 1].charAt(pos.x) == '#') {
                derechas++;
            }
            pos.x++;
            return pos;
        }
        if (pos.y < circuito.length - 1 && circuito[pos.y + 1].charAt(pos.x) == '#') {

            direccion = 'b';
            if (pos.x != 0 && circuito[pos.y].charAt(pos.x - 1) == '#') {
                derechas++;
            } else if (pos.x < circuito[pos.y].length() - 1 && circuito[pos.y].charAt(pos.x + 1) == '#') {
                izquierdas++;
            }
            pos.y++;
            return pos;
        }

        direccion = 'i';
        if (pos.y != 0 && circuito[pos.y - 1].charAt(pos.x) == '#') {
            izquierdas++;
        } else if (pos.y < circuito.length - 1 && circuito[pos.y + 1].charAt(pos.x) == '#') {
            derechas++;
        }
        pos.x--;
        return pos;
    }

    private Point move(Point pos) {
        if ((direccion != 'b') && (pos.y != 0 && circuito[pos.y - 1].charAt(pos.x) == '#')) {
            circuito[pos.y].replace(pos.x, pos.x + 1, "X");
            pos.y--;
            if (direccion == 'd') {
                izquierdas++;
            } else if (direccion == 'i') {
                derechas++;
            }
            direccion = 's';
            return pos;
        }
        if ((direccion != 'i') && (pos.x < circuito[pos.y].length() - 1 && circuito[pos.y].charAt(pos.x + 1) == '#')) {
            circuito[pos.y].replace(pos.x, pos.x + 1, "X");
            pos.x++;
            if (direccion == 's') {
                derechas++;
            } else if (direccion == 'b') {
                izquierdas++;
            }
            direccion = 'd';
            return pos;
        }
        if ((direccion != 's') && (pos.y < circuito.length - 1 && circuito[pos.y + 1].charAt(pos.x) == '#')) {
            circuito[pos.y].replace(pos.x, pos.x + 1, "X");
            pos.y++;
            if (direccion == 'd') {
                derechas++;
            } else if (direccion == 'i') {
                izquierdas++;
            }
            direccion = 'b';
            return pos;
        }
        if ((direccion != 'd') && (pos.x != 0 && circuito[pos.y].charAt(pos.x - 1) == '#')) {
            circuito[pos.y].replace(pos.x, pos.x + 1, "X");
            pos.x--;
            if (direccion == 's') {
                izquierdas++;
            } else if (direccion == 'b') {
                derechas++;
            }
            direccion = 'i';
            return pos;
        }
        return pos;
    }

    private Point getPos0(StringBuilder[] circuito) {
        for (int i = 0; i < circuito.length; i++) {
            if (circuito[i].indexOf("O") >= 0) {
                return new Point(circuito[i].indexOf("O"), i);
            }
        }
        return new Point(0, 0);
    }

    void printCricuito() {
        for (StringBuilder stringBuilder : circuito) {
            System.out.println(stringBuilder);
        }
    }
}
