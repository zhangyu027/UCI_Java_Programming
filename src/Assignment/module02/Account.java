package Assignment.module02;

public class Account {

    protected double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    // TODO 1:
    // Create a non-static inner class named Statement.
    //
    // Add a method:
    // String line()
    //
    // It should return the balance formatted as:
    // "Balance 125.00"


    public void deposit(double amount)
            throws InvalidAmountException {

        // TODO 2:
        // If amount <= 0:
        // throw InvalidAmountException
        //
        // Otherwise add amount to balance.

    }


    public void withdraw(double amount)
            throws InvalidAmountException {

        // TODO 3:
        // Throw InvalidAmountException when:
        // - amount <= 0
        // OR
        // - amount > balance
        //
        // Otherwise subtract amount from balance.

    }
}