import com.example.jmp.dto.User;
import com.example.jmp.dto.BankCard;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

public class BankCardTest {

    private BankCard bankCard;
    private User userMichael;
    private String cardNumber;

    @BeforeEach
    void setUp() {
        cardNumber = "4444-4444-4444-4444";
        userMichael = new User("Michael", "Jackson", LocalDate.of(1958, 8, 29));
        bankCard = new BankCard(cardNumber, userMichael);
    }

    @Test
    void testGetNumber() {
        assertEquals(cardNumber, bankCard.getNumber(), "The card number should match the expected value");
    }

    @Test
    void testSetNumber() {
        String newCardNumber = "4242-4242-4242-4242";
        bankCard.setNumber(newCardNumber);
        assertEquals(newCardNumber, bankCard.getNumber(), "The card number should be updated to the new value");
    }

    @Test
    void testGetUser() {
        User expectedUser = bankCard.getUser();
        assertNotNull(expectedUser, "User should not be null");
        assertEquals(userMichael, expectedUser, "The user should match the expected user");
    }

    @Test
    void testSetUser() {
        User newUser = new User("Elvis", "Presley", LocalDate.of(1935, 1, 8));
        bankCard.setUser(newUser);
        assertEquals(newUser, bankCard.getUser(), "The user should be updated to the new user object");
    }

}
