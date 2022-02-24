import java.util.*;

public class C1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = 0;
        int count = 0;
        while (input != -1) {
            input = sc.nextInt();
            if (input % 4 == 0) {
                count++;
            }

        }
        System.out.println(count);

    }
}
