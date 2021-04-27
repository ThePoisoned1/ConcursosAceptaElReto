package AceptaElReto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class AER464_EntrandoEnPeloton {
    Scanner sc;

    class Corredor {
        Integer llegada;
        Integer pos;
        Integer orden;

        Corredor(int llegada, int orden) {
            this.llegada = llegada;
            this.orden = orden;
        }

    }

    class ordenarPorLlegada implements Comparator<Corredor> {
        @Override
        public int compare(Corredor c, Corredor c2) {
            return c.llegada.compareTo(c2.llegada);
        }
    }

    class ordenarPorOrden implements Comparator<Corredor> {
        @Override
        public int compare(Corredor c, Corredor c2) {
            return c.orden.compareTo(c2.orden);
        }
    }

    public static void main(String[] args) {
        new AER464_EntrandoEnPeloton().run();
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
        int numCorredores = sc.nextInt();
        List<Corredor> llegadas = new ArrayList<>();
        String[] tiempo;
        for (int i = 0; i < numCorredores; i++) {
            tiempo = sc.next().split(":");
            llegadas.add(new Corredor(
                    Integer.parseInt(tiempo[0]) * 3600 + Integer.parseInt(tiempo[1]) * 60 + Integer.parseInt(tiempo[2]),
                    i));

        }
        int tiempoAnt = 0;
        boolean primero = true;
        int pos = 1;
        int aSumar=1;
        Collections.sort(llegadas, new ordenarPorLlegada());
        for (Corredor corredor : llegadas) {
            if (primero) {
                primero = false;
            } else {
                if (corredor.llegada - tiempoAnt > 1) {
                    pos+=aSumar;
                    aSumar=1;
                }else{
                    aSumar++;
                }
            }
            corredor.pos = pos;
            tiempoAnt = corredor.llegada;
        }
        Collections.sort(llegadas, new ordenarPorOrden());
        for (Corredor corredor : llegadas) {
            System.out.println(corredor.pos);
        }
        System.out.println("---");
        return true;
    }

}
