import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testing Bank Account class")
public class BankAccountTest
{

    @Test
    @DisplayName("Withdraw successfully")
    public void testWithdraw(){
        BankAccount bankAccount = new BankAccount(500, -1000);
        bankAccount.withdraw(300);

        assertEquals(200, bankAccount.getBalance());
    }

    @Test
    @DisplayName("Diposit successfully")
    public void testDeposit(){
        BankAccount bankAccount=new BankAccount(500, 0);
        bankAccount.deposit(500);
        assertEquals(1000, bankAccount.getBalance());
    }

    @Test
    @DisplayName("Withdraw will become negative")
    public void testWithdrawNotStuckAtZero(){
        BankAccount bankAccount = new BankAccount(500, -1000);
        bankAccount.withdraw(1000);
        assertNotEquals(0, bankAccount.getBalance());
    }

    @Test
    @DisplayName("Test check is account is active")
    public void testActive(){
        BankAccount bankAccount = new BankAccount(500, 0 );
        assertTrue(bankAccount.isActive());
    }

    @Test
    @DisplayName("Test set holder name")
    public void testHolderNameSet(){
        BankAccount bankAccount = new BankAccount(1000, 0 );
        bankAccount.setBankHolderName("Nachiket");
        assertNotNull(bankAccount.getBankHolderName());

    }

    @Test
    @DisplayName("Test that we can't withdrow below minus")
    public void testNoWithdrowBelowMinimum(){
        BankAccount bankAccount = new BankAccount(500, -1000);
        assertThrows(RuntimeException.class, ()->bankAccount.withdraw(2000));
    }

    @Test
    @DisplayName("Test no exception for withdraw and deposit")
    public void testWithdrawAndDepositWithoutExceptions(){
        BankAccount bankAccount = new BankAccount(500, -1000);
        assertAll(()-> bankAccount.deposit(200), ()->bankAccount.withdraw(440));
    }

}
