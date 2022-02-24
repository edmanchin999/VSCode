import java.util.*;
/*思路 ：
create input for sample input and count to count the total amount of input that is more than 10
use for loop to iterate or loop the sample input 
within the loop there is a if statement to count the input that is more than 10 
*/

public class A1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        for (int i = 0; i < 15; i++) { // 15 because constant integer intput
            int input = sc.nextInt();
            if (input > 10) {
                count++;
            }
        }
        System.out.println(count);
    }

}
