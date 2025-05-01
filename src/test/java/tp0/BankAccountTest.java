package tp0;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {
    private BlackJack.BankAccount account;
    private BlackJack.BankAccount account2;

    @BeforeEach
    void setUp() {
        account = new BlackJack.BankAccount(100.0);
        account2 = new BlackJack.BankAccount(50.0);
    }

    @Test
    void testDeposit() {
        account.deposit(50.0);
        assertEquals(150.0, account.getBalance());

        account.deposit(0);
        assertEquals(150.0, account.getBalance());

        assertThrows(IllegalArgumentException.class, () -> account.deposit(-10.0));
    }

    @Test
    void testWithdraw() {
        account.withdraw(30.0);
        assertEquals(70.0, account.getBalance());

        account.withdraw(0);
        assertEquals(70.0, account.getBalance());

        assertThrows(IllegalArgumentException.class, () -> account.withdraw(1000.0));
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(-10.0));
    }

    @Test
    void testTransfer() {
        account.transfer(30.0, account2);
        assertEquals(70.0, account.getBalance());
        assertEquals(80.0, account2.getBalance());

        assertThrows(IllegalArgumentException.class, () -> account.transfer(-10.0, account2));
        assertThrows(NullPointerException.class, () -> account.transfer(10.0, null));
    }

    @Test
    void testAddInterest() {
        account.addInterest();
        assertEquals(105.0, account.getBalance(), 0.01);
    }
}
