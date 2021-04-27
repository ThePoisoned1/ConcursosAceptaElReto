import java.util.Scanner;

public class AER466_MultiplicandoMal {
    Scanner sc;

    public static void main(String[] args) {
        new AER466_MultiplicandoMal().run();
    }

    private void run() {
        sc = new Scanner(System.in);
        int veces = sc.nextInt();
        for (int i = 0; i < veces; i++) {
            caso();
        }
    }

    private void caso() {
        String num1 = sc.next();
        String num2 = sc.next();
        String aux = "";
        if (num1.length() < num2.length()) {
            aux = num2;
            num2 = num1;
            num1 = aux;
        }
        while (num2.length() < num1.length()) {
            num2 = 0 + num2;
        }
        int accarreo = 0;
        int resultado;
        String resultadoStr;
        StringBuilder out = new StringBuilder();
        for (int i = num2.length() - 1; i >= 0; i--) {
            resultado = Character.getNumericValue(num2.charAt(i)) * Character.getNumericValue(num1.charAt(i));
            if (accarreo > 0) {
                resultado += accarreo;
                accarreo = 0;
            }

            if (resultado >= 10) {
                resultadoStr = "" + resultado;
                out.insert(0, resultadoStr.charAt(resultadoStr.length() - 1));
                accarreo = Integer.parseInt(resultadoStr.substring(0, resultadoStr.length() - 1));
            } else {
                out.insert(0, resultado);
            }
        }
        if (accarreo > 0) {
        out.insert(0, accarreo);
        }
        System.out.println(out.toString());
    }
}
