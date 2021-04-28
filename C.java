import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class C {
    Scanner sc;

    public static void main(String[] args) {
        new C().run();
    }

    private void run() {
        sc = new Scanner(System.in);
        while (caso())
            ;
    }

    private boolean caso() {
        int dias = sc.nextInt();
        if (dias == 0) {
            return false;
        }
        List<List<Integer>> posibilidades = new ArrayList<>();
        List<List<Integer>> toAdd = new ArrayList<>();
        posibilidades.add(new ArrayList<>());
        List<Integer> newList;
        int valorDia;

        for (int i = 0; i < dias; i++) {
            valorDia = sc.nextInt();
            for (List<Integer> list : posibilidades) {
                if (list.size() > 0) {
                    if (list.get(list.size() - 1) < valorDia) {
                        list.add(valorDia);
                    } else {
                        if (list.size() > 1) {
                            if (list.get(list.size() - 2) < valorDia) {
                                newList = new ArrayList<>();
                                Collections.copy(list, newList);
                                newList.add(valorDia);
                                toAdd.add(newList);
                            }
                        } else {
                            list.add(valorDia);
                        }
                    }
                } else {
                    list.add(valorDia);
                }
            }
            for (List<Integer> list : toAdd) {
                posibilidades.add(list);
            }
            toAdd.clear();
        }
        int max = 0;
        int tamanno;
        for (List<Integer> list : posibilidades) {
            tamanno = list.size();
            if (tamanno > max) {
                max = tamanno;
            }
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
        System.out.println(max);
        return true;
    }
}
// 8 1 3 2 9 4 5