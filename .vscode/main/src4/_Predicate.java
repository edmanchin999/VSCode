package main.src4;

import java.util.function.Predicate;

public class _Predicate {
    public static void main(String[] args) {
        // normal java method
        System.out.println("Without Predicate :");
        System.out.println(isPhoneNumberValid("07000000000"));
        System.out.println(isPhoneNumberValid("0700000000"));
        System.out.println(isPhoneNumberValid("09001230000"));

        // Predicate call out method
        System.out.println("With Predicate :");
        System.out.println(isPhoneNumberValidPredicate.test("07000000000"));
        System.out.println(isPhoneNumberValidPredicate.test("0700000000"));
        System.out.println(isPhoneNumberValidPredicate.test("09000123000"));

        System.out.println("Is phone number valid and contains number 3 =");
        System.out.println(isPhoneNumberValidPredicate.and(containsNumber3).test("09000123000"));

        System.out.println("Is phone number valid and contains number 3 =");
        System.out.println(isPhoneNumberValidPredicate.and(containsNumber3).test("07000000003"));
    }

    // Predicate method
    static Predicate<String> isPhoneNumberValidPredicate = phoneNumber -> phoneNumber.startsWith("07")
            && phoneNumber.length() == 11;

    // normal java method
    static boolean isPhoneNumberValid(String phoneNumber) {
        return phoneNumber.startsWith("07") && phoneNumber.length() == 11;
    }

    static Predicate<String> containsNumber3 = phoneNumber -> phoneNumber.contains("3");
}
