public class pyramid {
    public static void main(String args[]) {
        int i, j, pyr = 5;

        for (i = 0; i < pyr; i++) {

            for (j = pyr - i; j > 1; j--) {
                System.out.print(" ");
            }

            for (j = 0; j <= i; j++) {
                System.out.print("* ");
            }

            System.out.println(" ");
        }
    }
}