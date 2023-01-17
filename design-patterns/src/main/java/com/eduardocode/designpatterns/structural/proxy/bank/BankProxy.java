package com.eduardocode.designpatterns.structural.proxy.bank;

public class BankProxy implements Bank {

    private Bank bank;
    private boolean admin;

    public BankProxy(String user, String pass) {
        if(checkAccess(user, pass)) {
            bank = new CapitalOne();
            setAdmin(true);
        }
    }

    private boolean checkAccess(String user, String pass) {
        return user.equals("root") && pass.equals("admin");
    }

    @Override
    public void withdraw(String account, int amount) {
        if(isAdmin()) {
            bank.withdraw(account, amount);
        } else {
            System.out.println("You dont have access to withdraw money");
        }
    }

    @Override
    public void deposit(String account, int amount) {
        if(isAdmin()) {
            bank.deposit(account, amount);
        } else {
            System.out.println("You dont have access to deposit money");
        }
    }

    private void setAdmin(boolean admin) {
        this.admin = admin;
    }

    private boolean isAdmin() {
        return admin;
    }
}
