package main.src3;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {

    public static void main(String[] args) {

        // normal method
        Customer maria = new Customer("Maria", "0080");
        greetCustomer(maria);
        greetCustomerV2(maria, false);

        // Consumer function method
        greetCustomerConsumer.accept(maria);

        // Bifunction method
        greetCustomerConsumerV2.accept(maria, false);

    }

    // version 2 by using Bifunction
    static BiConsumer<Customer, Boolean> greetCustomerConsumerV2 = (customer, showPhoneNumber) -> System.out
            .println("Hello " + customer.customerName + ", thanks for registering phone number "
                    + (showPhoneNumber ? customer.customerPhoneNumber : "****"));

    // new Consumer method
    static Consumer<Customer> greetCustomerConsumer = customer -> System.out.println(
            "Hello " + customer.customerName + ", thanks for registering phone number " + customer.customerPhoneNumber);

    // normal method
    static void greetCustomer(Customer customer) {
        System.out.println("Hello " + customer.customerName + ", thanks for registering phone number "
                + customer.customerPhoneNumber);
    }

    // veriosn 2 of the Bifucntion normal java method
    static void greetCustomerV2(Customer customer, boolean showPhoneNumber) {
        System.out.println("Hello " + customer.customerName + ", thanks for registering phone number "
                + (showPhoneNumber ? customer.customerPhoneNumber : "****"));
    }

    static class Customer {
        private final String customerName;
        private final String customerPhoneNumber;

        Customer(String customerName, String customerPhoneNumber) {
            this.customerName = customerName;
            this.customerPhoneNumber = customerPhoneNumber;
        }
    }

}
