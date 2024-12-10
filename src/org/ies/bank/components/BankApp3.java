package org.ies.bank.components;

import org.ies.bank.model.Account;
import org.ies.bank.model.Bank;

public class BankApp3 {

    public void run(BankReader bankReader) {
        Bank bank = bankReader.bankReader();
        Account account = bank.findAccount("ES0001");
        boolean protocol = false;

        if (account.getIban().equals("ES0001")) {
            protocol = true;

        } else if (account.getIban() == null) {
            System.out.println("No existe la cuenta emisora");
        }

        Account account1 = bank.findAccount("ES0002");
        boolean protocol2 = false;

        if (account1.getIban().equals("ES0002")) {
            protocol2 = true;
        } else if (account1.getIban() == null) {
            System.out.println("No existe la cuenta destinataria");
        }

        if (protocol == protocol2) {
            bank.changeBalance("ES0001", 500);
            bank.changeBalance("ES0002", -30);
        }
        bank.showAccount("ES0001", bank.getAccounts());
        bank.showAccount("ES0002", bank.getAccounts());

        bank.transferency(bank.getAccounts());
    }
}
