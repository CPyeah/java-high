package org.cp;

/**
 * create by CP on 2019/7/26 0026.
 */
public class BankSimpleTest {
    public static void main(String[] args) {
        Account account = new Account();
        Customer customer1 = new Customer(account);
        Customer customer2 = new Customer(account);
        customer1.setName("客户1");
        customer2.setName("客户2");
        customer1.start();
        customer2.start();
    }
}
class Account {
    private Double balance=0.0;//余额
    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

}
class Customer extends Thread{

    Account account;

    public Customer(Account account) {
        this.account = account;
    }

    public void deposit(Double amount) {
        synchronized (account) {//锁定操作同步数据的代码块，让一次只能一个客户进来操作
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
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            deposit(1000.0);
        }
    }
}
