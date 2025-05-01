package tp0;

public class BlackJack {

    public int play(int left, int right) {
        if (left > 21) left = 0;
        if (right > 21) right = 0;
        return Math.max(left, right);
    }

    public static class BankAccount {
        private double balance;
        private static final double INTEREST_RATE = 0.05; // 5% d'intérêt

        public BankAccount(double initialBalance) {
            if (initialBalance < 0) {
                throw new IllegalArgumentException("Le solde initial ne peut pas être négatif.");
            }
            this.balance = initialBalance;
        }

        public void deposit(double amount) {
            if (amount < 0) {
                throw new IllegalArgumentException("Le montant du dépôt ne peut pas être négatif.");
            }
            balance += amount;
        }

        public void withdraw(double amount) {
            if (amount < 0) {
                throw new IllegalArgumentException("Le montant du retrait ne peut pas être négatif.");
            }
            if (amount > balance) {
                throw new IllegalArgumentException("Solde insuffisant.");
            }
            balance -= amount;
        }

        public void transfer(double amount, BankAccount other) {
            if (other == null) {
                throw new NullPointerException("Le compte destinataire ne peut pas être null.");
            }
            if (amount < 0) {
                throw new IllegalArgumentException("Le montant du transfert ne peut pas être négatif.");
            }
            this.withdraw(amount);
            other.deposit(amount);
        }

        public void addInterest() {
            balance += balance * INTEREST_RATE;
        }

        public double getBalance() {
            return balance;
        }
    }
}
