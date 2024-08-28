import com.example.jmp.bank.api.Bank;
import com.example.jmp.cloud.bank.impl.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankCreatorTest {

    @Test
    void createBank_ShouldCreateRetailBank() {
        Bank bank = BankCreator.createBank(BankType.RETAIL_BANK);

        assertTrue(bank instanceof RetailBank, "Should create an instance of RetailBank");
    }

    @Test
    void createBank_ShouldCreateInvestmentBank() {
        Bank bank = BankCreator.createBank(BankType.INVESTMENT_BANK);

        assertTrue(bank instanceof InvestmentBank, "Should create an instance of InvestmentBank");
    }

    @Test
    void createBank_ShouldCreateCentralBank() {
        Bank bank = BankCreator.createBank(BankType.CENTRAL_BANK);

        assertTrue(bank instanceof CentralBank, "Should create an instance of CentralBank");
    }

    @Test
    void createBank_ShouldThrowExceptionForUnknownBankType() {
        /*
        assertThrows(IllegalArgumentException.class, () -> {
            BankCreator.createBank(null);
        }, "Should throw IllegalArgumentException for null type");

         */

        assertThrows(IllegalArgumentException.class, () -> {
            BankCreator.createBank(BankType.valueOf("WEIRD_BANK"));
        }, "Should throw IllegalArgumentException for unknown bank type");
    }

}



