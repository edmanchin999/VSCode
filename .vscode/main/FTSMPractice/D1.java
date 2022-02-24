import java.util.*;

public class D1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input1 = sc.nextInt();
        int second = 0;
        int minute = 0;
        int hour = 0;
        for (int i = 0; i < input1; i++) {
            int input2 = sc.nextInt();
            if (input2 < 60) {
                second = input2; // just take the input since it is less than a minute
            }
            if (input2 >= 60) { // need to divide by 60 since it more than a minute
                minute = input2 / 60; // convert second to minute
                second = (input2 % 60); // use % take the remainder of the input which is the seconds
                if (input2 >= 180) { // need to follow the formula because it is more than an hour
                    hour = input2 / 3600; // convert seconds to hour
                    minute = (input2 % 3600) / 60; // take the remainder of the input and convert to minute
                    second = input2 % 60; // just take the remainder
                }

            }
            System.out.println("Case #" + (i + 1) + ": " + hour + ":" + minute + ":" + second);
        }
    }
}