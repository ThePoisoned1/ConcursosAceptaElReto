import java.util.Scanner;

public class AER470_MontandoSemaforos {
    Scanner sc;
    StringBuilder bombillas;

    public static void main(String[] args) {
        new AER470_MontandoSemaforos().run();
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
        String linea = sc.next();
        int semaforos = 0;
        int bombillasSem = 0;
        bombillas = new StringBuilder();
        for (char letra : linea.toCharArray()) {
            switch (letra) {
            case 'R':
                bombillas.append('R');
                bombillasSem = 1;
                break;
            case 'A':
                bombillas.append('A');
                switch (bombillasSem) { // si la anterior es roja el semáforo sigue construyendose
                case 1:
                    bombillasSem = 2;
                    break;
                default:
                    bombillasSem = 0;
                    break;
                }
                break;
            case 'V':
                bombillas.append('V');
                if (bombillasSem == 2) { // si las ateriores dos fueron roja,amarilla; se construye el semáforo
                    semaforos++;
                    bombillasSem = 0; // empezamos un semaforo de 0 y borramos las 3 bombillas
                    bombillas.deleteCharAt(bombillas.length() - 1);
                    bombillas.deleteCharAt(bombillas.length() - 1);
                    bombillas.deleteCharAt(bombillas.length() - 1);
                    bombillasSem = checkAnteriores(); // comprobamos si las bombillas anteriores a este semaforo son
                                                      // roja,amarilla o roja
                } else {
                    bombillasSem = 0;
                }
                break;
            default:
                break;
            }

        }
        System.out.println(semaforos);
        return true;
    }

    int checkAnteriores() {
        if (bombillas.length() >= 1 && bombillas.charAt(bombillas.length() - 1) == 'R') {
            return 1;
        }
        if (bombillas.length() >= 2 && (bombillas.charAt(bombillas.length() - 2) == 'R'
                && bombillas.charAt(bombillas.length() - 1) == 'A')) {
            return 2;
        }
        return 0;
    }
}
