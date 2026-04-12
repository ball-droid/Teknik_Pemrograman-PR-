class Account {
    private int balance;

    public Account(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void withdraw(int amount) {
        balance -= amount;
    }

    public void deposit(int amount) {
        balance += amount;
    }
}

class TransferService {
    public static void transfer(Account from, Account to, int amount) {
        synchronized (from) {
            synchronized (to) {
                if (from.getBalance() >= amount) {
                    from.withdraw(amount);
                    to.deposit(amount);
                    System.out.println("Transfer berhasil: " + amount);
                } else {
                    System.out.println("Saldo tidak cukup!");
                }
            }
        }
    }
}

public class TransferFulus {
    public static void main(String[] args) throws InterruptedException {
        Account acc1 = new Account(150);
        Account acc2 = new Account(150);

        Thread t1 = new Thread(() -> {
            TransferService.transfer(acc1, acc2, 50);
        });

        Thread t2 = new Thread(() -> {
            TransferService.transfer(acc2, acc1, 70);
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Saldo acc1: " + acc1.getBalance());
        System.out.println("Saldo acc2: " + acc2.getBalance());
    }
}