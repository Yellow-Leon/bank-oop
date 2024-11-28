package org.ies.bank.components;

import org.ies.bank.model.Account;

import java.util.Scanner;

public class AccountReader {
    private final Scanner scanner;
    private final CustomerReader reader;

    public AccountReader(Scanner scanner, CustomerReader reader) {
        this.scanner = scanner;
        this.reader = reader;
    }

//    public Account accountReader() {
//        System.out.println();
//        return new Account();
//    }
}
