package org.ies.bank;

import org.ies.bank.components.*;
import org.ies.bank.model.Bank;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomerReader customerReader= new CustomerReader(scanner);
        AccountReader accountReader= new AccountReader(scanner, customerReader);
        BankReader bankReader = new BankReader(scanner, accountReader);

        BankApp2 bankApp2 = new BankApp2();
        bankApp2.run(bankReader);
    }
}