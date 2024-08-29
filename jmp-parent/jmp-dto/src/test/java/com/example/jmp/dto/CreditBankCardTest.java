import com.example.jmp.dto.CreditBankCard;
import com.example.jmp.dto.User;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

public class CreditBankCardTest {

    private CreditBankCard creditBankCard;
    private User userMichael;
    private String cardNumber;

    @BeforeEach
    void setUp() {
        cardNumber = "4444-4444-4444-4444";
        userMichael = new User("Michael", "Jackson", LocalDate.of(1958, 8, 29));
        creditBankCard = new CreditBankCard(cardNumber, userMichael);
    }

    @Test
    void testGetNumber() {
        assertEquals(cardNumber, creditBankCard.getNumber(), "The card number should match the expected value");
    }

    @Test
    void testSetNumber() {
        String newCardNumber = "4242-4242-4242-4242";
        creditBankCard.setNumber(newCardNumber);
        assertEquals(newCardNumber, creditBankCard.getNumber(), "The card number should be updated to the new value");
    }

    @Test
    void testGetUser() {
        User expectedUser = creditBankCard.getUser();
        assertNotNull(expectedUser, "User should not be null");
        assertEquals(userMichael, expectedUser, "The user should match the expected user");
    }

    @Test
    void testSetUser() {
        User newUser = new User("Elvis", "Presley", LocalDate.of(1935, 1, 8));
        creditBankCard.setUser(newUser);
        assertEquals(newUser, creditBankCard.getUser(), "The user should be updated to the new user object");
    }

}
