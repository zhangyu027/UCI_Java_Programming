package Assignment.module02;

// Starter code: this is a checked exception.
// TODO for students: explain why extending Exception makes it checked,
// and use it from Account.deposit()/withdraw().
public class InvalidAmountException extends Exception {

    public InvalidAmountException(String message) {
        super(message);
    }
}
