package org.ies.bank.components;

import org.ies.bank.model.Account;
import org.ies.bank.model.Customer;

import java.util.Scanner;

public class AccountReader {
    private final Scanner scanner;
    private final CustomerReader customerReader;

    public AccountReader(Scanner scanner, CustomerReader reader) {
        this.scanner = scanner;
        this.customerReader = reader;
    }

    public Account reader (){
        System.out.println("Introduce los datos de la cuenta");
        System.out.println("Introduce el IBAN");
        String iban = scanner.nextLine();
        System.out.println("Introduce el saldo");
        double saldo = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Introduce cliente");
        Customer customer = customerReader.reader();

        return new Account(
                iban,
                saldo,
                customer
        );
    }
}
