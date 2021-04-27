import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AER469_PesandoPatatas {
    // pesos y sumas(todos hasta él sin incluir) precalculados
    Long[] pesos = { (long) 1, (long) 3, (long) 9, (long) 27, (long) 81, (long) 243, (long) 729, (long) 2187,
            (long) 6561, (long) 19683, (long) 59049, (long) 177147, (long) 531441, (long) 1594323, (long) 4782969,
            (long) 14348907, (long) 43046721, (long) 129140163, (long) 387420489, (long) 1162261467,
            Long.parseLong("3486784401") };
    Long[] sumas = { (long) 0, (long) 1, (long) 4, (long) 13, (long) 40, (long) 121, (long) 364, (long) 1093,
            (long) 3280, (long) 9841, (long) 29524, (long) 88573, (long) 265720, (long) 797161, (long) 2391484,
            (long) 7174453, (long) 21523360, (long) 64570081, (long) 193710244, (long) 581130733, (long) 1743392200 };
    List<Long> pesosRestantes;
    Scanner sc;
    String der, izq;

    public static void main(String[] args) {
        new AER469_PesandoPatatas().run();
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
        long peso = sc.nextLong();

        if (Arrays.binarySearch(pesos, peso) >= 0) { // es una potencia de 3, simplemente ponemos su mismo valor al otro
                                                     // lado de la balanza
            System.out.println(peso + " ==X== patatas");
            return true;
        }
        pesosRestantes = new ArrayList<>();
        for (int i = 0; i < sumas.length; i++) { // añadimos las pesas que vayamos a necesitar. Tenemos que evitar
                                                 // generar déficits que no podamos rellenar con el resto de balanzas
            if (peso > sumas[i])
                pesosRestantes.add(pesos[i]);
            else
                break;

        }
        long pesa = pesosRestantes.remove(pesosRestantes.size() - 1);
        long pesoIzq = pesa; // usamos la pesa más grande en el lado opuesto
        izq = String.valueOf(pesa); // las pesas se guradarán en orden en el string correspondiente a su parte
        long pesoDer = peso;
        der = "patatas";
        while (pesoIzq != pesoDer) { // intentamos igualar ambos lados hasta que sean iguales. Si no se puede
                                     // igualar, se sobrepasará lo más alto que se pueda sin hacerlo imposible de
                                     // resolver
            pesoDer = igualar(pesoDer, pesoIzq, true);
            if (pesoDer != pesoIzq) {
                pesoIzq = igualar(pesoIzq, pesoDer, false);
            }
        }
        System.out.println(izq + " ==X== " + der);
        return true;

    }

    long igualar(long peso, long pesoOpuesto, boolean reverse) {
        long pesoInicial = peso;
        ArrayList<Integer> aBorrar = new ArrayList<>();
        String lado = reverse ? der : izq; // añadimos pesas en el lado derecho o el izquierdo
        long pesa = 0;
        for (int i = pesosRestantes.size() - 1; i >= 0; i--) { // intentamos colocar las pesas de mayor a menor
            pesa = pesosRestantes.get(i);
            // si la pesa se puede colocar sin sobrepasar o sobrepasa pero el exceso es
            // menor o igual que el valor de la siguiente pesa
            if (peso + pesa <= pesoOpuesto || (i > 0 && (peso + pesa - pesoOpuesto) <= pesosRestantes.get(i - 1))) {
                peso += pesa;
                lado = pesa + " " + lado;
                aBorrar.add(i); // hemos usado el peso
            }
            if (peso >= pesoOpuesto) // si nos hemos pasado nos vamos
                break;
        }
        if (peso < pesoOpuesto) { // no hemos excedido el peso, y debemos hacerlo
            // conseguimos la pesa más alta que nos permita superar el peso opuesto pero sin
            // hacer imposible su recuperación. Utilizando los valores iniciales
            for (int i = pesosRestantes.size() - 1; i >= 0; i--) {
                pesa = pesosRestantes.remove(i);
                // si el valor no va a imposibilitar equilibrar(la diferencia que resultaría no
                // seria solventable con las pesas restantes) de vuelta nos lo quedamos y
                // nos vamos. El resto se descartan ya que imposibilitan la resolución
                if (pesoInicial + pesa - pesoOpuesto <= sumas[Arrays.binarySearch(pesos, pesa)])
                    break;
            }
            // sobreescribimos los datos generados por el primer for del metodo ya que no
            // sirvieron
            peso = pesoInicial + pesa;
            lado = reverse ? pesa + " " + der : pesa + " " + izq;

        } else {// hemos superado o igualado el peso necesario
            for (Integer integer : aBorrar) { // borramos las pesas utilizadas
                pesosRestantes.remove(pesosRestantes.get(integer));
            }
        }
        // Actualizamos el lado de la balanza correspondiente
        if (reverse)
            der = lado;
        else
            izq = lado;
        //devolvemos el nuevo peso
        return peso;
    }
}