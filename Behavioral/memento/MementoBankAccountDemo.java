// Step 1: Memento Class
class AccountMemento {
    private final int balance;

    public AccountMemento(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }
}

// Step 2: Originator Class
class BankAccount {
    private int balance;

    public BankAccount(int initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(int amount) {
        balance += amount;
        System.out.println("Deposited: " + amount + ", Current Balance: " + balance);
    }

    public void withdraw(int amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds! Withdrawal denied.");
        } else {
            balance -= amount;
            System.out.println("Withdrawn: " + amount + ", Current Balance: " + balance);
        }
    }

    // Save current state to a memento
    public AccountMemento save() {
        return new AccountMemento(balance);
    }

    // Restore state from a memento
    public void restore(AccountMemento memento) {
        this.balance = memento.getBalance();
        System.out.println("Restored Balance: " + balance);
    }
}

// Step 3: Caretaker Class
class AccountHistory {
    private final List<AccountMemento> history = new ArrayList<>();

    public void addMemento(AccountMemento memento) {
        history.add(memento);
    }

    public AccountMemento getMemento(int index) {
        return history.get(index);
    }
}

// Step 4: Client
public class MementoBankAccountDemo {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(5000);
        AccountHistory history = new AccountHistory();

        // Save initial state
        history.addMemento(account.save());

        // Perform transactions
        account.deposit(2000);
        history.addMemento(account.save()); // Save after deposit

        account.withdraw(1000);
        history.addMemento(account.save()); // Save after withdrawal

        account.withdraw(7000); // Exceeds balance
        account.deposit(500);

        // Restore to previous states
        account.restore(history.getMemento(1)); // Restore to after deposit
        account.restore(history.getMemento(0)); // Restore to initial state
    }
}
