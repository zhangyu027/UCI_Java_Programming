# Teaching and grading guide

## Assignments
- M1 Password Verifier: emphasize boolean conditions, character inspection, Scanner input, and clear validation messages.
- M1 Weekly Sales: emphasize file input, parsing comma-separated doubles, per-week totals/averages, and high/low tracking.
- M2 Task Tracker: demonstrate JFrame/JPanel/JButton/JTextField/JList, event handlers, validation, and persistence between executions.
- M3 Classes & Objects: Student + School, constructors, methods, arrays of objects, highest/lowest average.
- M3 Exception Control: Calculator, ArithmeticException, two custom checked exceptions, user input, throw/catch.
- M4 Swing + MariaDB: CRUD on Students with JDBC prepared statements and informative exception handling.
- M5 Recursion: combinations with a clear base case and two recursive branches.

## In-class practice
Use the reference program only after students attempt the skeleton. Ask students to identify the base case / event listener / inheritance relationship / SQL statement before showing the answer.

## Database demonstrations
Prefer PreparedStatement over string concatenation. Explain that the MariaDB JDBC driver is runtime infrastructure, while Connection/Statement/ResultSet are Java SQL APIs. Never put real classroom passwords in source control.

## Answer-key policy
Keep this entire project in an instructor-only location. Student distributions should contain compile-ready skeletons and TODOs, not these solutions.
