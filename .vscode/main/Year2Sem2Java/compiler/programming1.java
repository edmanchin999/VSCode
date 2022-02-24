package compiler;

import java.util.*;

public class programming1 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);

        String exampleInput[] = { "420", "5.1E6", "7.1E+6", "9.", "-1" };
        for (int a = 0; a < exampleInput.length; a++) {
            String input1 = (exampleInput[a] + "/").toUpperCase();
            boolean condition = true;
            int state = 0;

            for (int i = 0; i < input1.length() && condition; i++) {
                switch (state) {

                case 0:
                    char c = input1.charAt(i);
                    if (Character.isDigit(c)) {
                        state = 1;
                    } else {
                        System.out.println("\"" + exampleInput[a] + "\"" + ", Rejected! Not an unsigned number\n");
                        condition = false;
                        break;
                    }
                    break;
                case 1:
                    c = input1.charAt(i);
                    if (Character.isDigit(c)) {
                        state = 1;
                    } else if (c == '.') {
                        state = 3;
                    } else if (c == 'E') {
                        state = 6;
                    } else if (c == '/') {
                        state = 11;
                    } else {
                        state = 2;
                    }
                    break;
                case 2:
                    System.out.println("\"" + exampleInput[a] + "\"" + ", It is an unsigned number\n");
                    break;
                case 3:
                    c = input1.charAt(i);
                    if (Character.isDigit(c)) {
                        state = 4;
                    } else {
                        System.out.println("\"" + exampleInput[a] + "\"" + ", Rejected! Not an unsigned number\n");
                        condition = false;
                        break;
                    }
                    break;
                case 4:
                    c = input1.charAt(i);
                    if (Character.isDigit(c)) {
                        state = 4;
                    } else if (c == 'E') {
                        state = 6;
                    } else if (c == '/') {
                        state = 11;
                    } else {
                        state = 5;
                    }
                    break;
                case 5:
                    System.out.println("\"" + exampleInput[a] + "\"" + ", It is an unsigned number\n");
                    break;
                case 6:
                    c = input1.charAt(i);
                    if (c == '+' || c == '-') {
                        state = 7;
                    } else if (Character.isDigit(c)) {
                        state = 8;
                    } else {
                        System.out.println("\"" + exampleInput[a] + "\"" + ", Rejected ! Not an unsigned number\n");
                        condition = false;
                        break;
                    }
                    break;
                case 7:
                    c = input1.charAt(i);
                    if (Character.isDigit(c)) {
                        state = 8;
                    } else {
                        System.out.println("\"" + exampleInput[a] + "\"" + ", Rejected ! Not an unsigned number\n");
                        condition = false;
                        break;
                    }
                    break;
                case 8:
                    c = input1.charAt(i);
                    if (Character.isDigit(c)) {
                        state = 8;
                    } else if (c == '/') {
                        state = 11;
                    } else {
                        state = 9;
                    }
                    break;
                case 9:
                    System.out.println("\"" + exampleInput[a] + "\"" + ", It is an unsigned number\n");
                    break;
                }

            }
            if (state == 11) {
                System.out.println("\"" + exampleInput[a] + "\"" + ", It is an unsigned number\n");
            }
        }
    }

}