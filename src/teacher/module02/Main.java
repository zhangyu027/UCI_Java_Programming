package teacher.module02;
class InvalidAmountException extends Exception { InvalidAmountException(String m){super(m);} }
class Account {
    protected double balance; Account(double b){balance=b;}
    class Statement { String line(){ return String.format("Balance %.2f", balance); } }
    void deposit(double a) throws InvalidAmountException { if(a<=0) throw new InvalidAmountException("Amount must be positive"); balance+=a; }
    void withdraw(double a) throws InvalidAmountException { if(a<=0||a>balance) throw new InvalidAmountException("Invalid withdrawal"); balance-=a; }
}
class Checking extends Account { Checking(double b){super(b);} }
class Savings extends Account { Savings(double b){super(b);} }
public class Main {
    public static void main(String[] args){
        Account a=new Checking(100); Runnable audit=new Runnable(){ public void run(){System.out.println("Audit complete");}};
        try { a.deposit(25); a.withdraw(200); } catch(InvalidAmountException e){ System.out.println("Handled: "+e.getMessage()); } finally { System.out.println(a.new Statement().line()); }
        audit.run();
    }
}


//InvalidAmountException
//│
//└── custom checked exception
//
//Account
//├── balance
//├── deposit()
//├── withdraw()
//└── Statement
//└── non-static inner class
//
//Checking ──extends──> Account
//Savings  ──extends──> Account
//
//Runnable audit
//│
//└── anonymous class
//
//main()
//└── try
//├── deposit
//├── withdraw → exception
//├── catch
//└── finally