import com.example.jmp.dto.CreditBankCard;
import com.example.jmp.dto.DebitBankCard;
import com.example.jmp.dto.User;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

public class DebitBankCardTest {

    private DebitBankCard debitBankCard;
    private User userMichael;
    private String cardNumber;

    @BeforeEach
    void setUp() {
        cardNumber = "4444-4444-4444-4444";
        userMichael = new User("Michael", "Jackson", LocalDate.of(1958, 8, 29));
        debitBankCard = new DebitBankCard(cardNumber, userMichael);
    }

    @Test
    void testGetNumber() {
        assertEquals(cardNumber, debitBankCard.getNumber(), "The card number should match the expected value");
    }

    @Test
    void testSetNumber() {
        String newCardNumber = "4242-4242-4242-4242";
        debitBankCard.setNumber(newCardNumber);
        assertEquals(newCardNumber, debitBankCard.getNumber(), "The card number should be updated to the new value");
    }

    @Test
    void testGetUser() {
        User expectedUser = debitBankCard.getUser();
        assertNotNull(expectedUser, "User should not be null");
        assertEquals(userMichael, expectedUser, "The user should match the expected user");
    }

    @Test
    void testSetUser() {
        User newUser = new User("Elvis", "Presley", LocalDate.of(1935, 1, 8));
        debitBankCard.setUser(newUser);
        assertEquals(newUser, debitBankCard.getUser(), "The user should be updated to the new user object");
    }

}
