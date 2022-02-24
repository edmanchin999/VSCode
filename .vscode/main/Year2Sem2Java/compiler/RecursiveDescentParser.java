package compiler;

import java.util.*;

class ResursiveDescentPaser {
    static int number;
    static char[] input;

    public static void main(String[] args) {
        System.out.println("Enter the input string:");
        String s = new Scanner(System.in).nextLine();
        input = s.toCharArray();
        if (input.length < 2) {
            System.out.println("The input string is invalid.");
            System.exit(0);
        }
        number = 0;
        boolean Valid = E();
        if ((Valid) & (number == input.length)) {
            System.out.println("The input string is valid");
        } else {
            System.err.println("The input string is not valid");
        }
    }

    static boolean E() {
        int Fallback = number;
        if (input[number++] != 'x') {
            number = Fallback;
            return false;
        }
        if (input[number++] != '+') {
            number = Fallback;
            return false;
        }
        if (T() == false) {
            number = Fallback;
            return false;
        }
        return true;

    }

    static boolean T() {
        int Fallback = number;
        if (input[number++] == 'x') {
            number++;
            return true;
        } else {
            if (input[number++] != '(') {
                number = Fallback;
                return false;
            }
            if (E() == false) {
                number = Fallback;
                return false;
            }
            if (input[number++] != ')') {
                number = Fallback;
                return false;
            }
            return true;
        }
    }
}
