package org.cp;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * create by CP on 2019/7/26 0026.
 */
public class BankSimpleTestByLock {
    public static void main(String[] args) {
        AccountB account = new AccountB();
        CustomerB customer1 = new CustomerB(account);
        CustomerB customer2 = new CustomerB(account);
        customer1.setName("客户1");
        customer2.setName("客户2");
        customer1.start();
        customer2.start();
    }
}

class AccountB {
    private Double balance=0.0;//余额

    private Lock lock = new ReentrantLock();//锁

    Double getBalance() {
        return balance;
    }

    void setBalance(Double balance) {
        this.balance = balance;
    }

    Lock getLock() {
        return lock;
    }

}

class CustomerB extends Thread{

    private AccountB account;

    CustomerB(AccountB account) {
        this.account = account;
    }

    private void deposit(Double amount) {
        try {
            account.getLock().lock();
            Double balance = account.getBalance();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Double newBalance = balance+amount;
            account.setBalance(newBalance);
            System.out.println(Thread.currentThread().getName()+"存入 "+amount
            +" 元, 现在余额为： "+newBalance +" 元");
        } finally {
            account.getLock().unlock();
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            deposit(1000.0);
        }
    }
}
