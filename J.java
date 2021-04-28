import java.util.Scanner;

public class J {
    Scanner sc;

    public static void main(String[] args) {
        new J().run();
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
        // https://stackoverflow.com/questions/31413626/how-to-calculate-smallest-multiple-formed-only-of-the-digit-1
        int n = sc.nextInt();
        int number_of_ones = 1;
        int remainder = 1 % n;
        System.out.println("first = " + remainder);
        while (remainder != 0) {
            number_of_ones++;
            remainder = (remainder * 10 + 1) % n;
            System.out.println("remainder = " + remainder);
        }

        System.out.println(number_of_ones);
        return true;
    }
}
