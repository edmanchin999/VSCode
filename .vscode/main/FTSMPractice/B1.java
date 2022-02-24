import java.text.DecimalFormat;
import java.util.*;

/*
This need to import decimal format to convert int to 0.00
then import scanner for input 
next ,using for loop to iterate the sample input 
then implement input * 278.82 which the arithmetic function
then print 

*/
public class B1 {

    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("0.00");
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        for (int i = 0; i < input; i++) {
            double input2 = sc.nextDouble();
            input2 = input2 * 278.82;
            System.out.println("Case #" + (i + 1) + ": " + df.format(input2));
        }

    }

}
