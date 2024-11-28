package org.ies.bank.model;

import java.util.Objects;

public class Customer {
    private String nif;
    private String name;
    private String lastname;

    public Customer(String nif, String name, String lastname) {
        this.nif = nif;
        this.name = name;
        this.lastname = lastname;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(nif, customer.nif) && Objects.equals(name, customer.name) && Objects.equals(lastname, customer.lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nif, name, lastname);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "nif='" + nif + '\'' +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}
