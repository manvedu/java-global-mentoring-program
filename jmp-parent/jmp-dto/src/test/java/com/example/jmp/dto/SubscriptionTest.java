import com.example.jmp.dto.Subscription;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

public class SubscriptionTest {

    private String cardNumber;
    private LocalDate subscriptionStartDate;
    private Subscription newSubscription;

    @BeforeEach
    void setUp() {
        cardNumber = "4444-4444-4444-4444";
        subscriptionStartDate = LocalDate.of(2023, 7, 29);
        newSubscription = new Subscription(cardNumber, subscriptionStartDate);
    }

    @Test
    void testGetBankcardNumber() {
        assertEquals(cardNumber, newSubscription.getBankcardNumber(), "The card number should match the expected value");
    }

    @Test
    void testSetBankcardNumber() {
        String newCardNumber = "4242-4242-4242-4242";
        newSubscription.setBankcardNumber(newCardNumber);
        assertEquals(newCardNumber, newSubscription.getBankcardNumber(), "The card number should be updated to the new value");
    }

    @Test
    void testGetStartDate() {
        assertEquals(subscriptionStartDate, newSubscription.getStartDate(), "The card number should match the expected value");
    }

    @Test
    void testSetStartDate() {
        LocalDate newSubscriptionStartDate = LocalDate.of(2024, 8, 29);
        newSubscription.setStartDate(newSubscriptionStartDate);
        assertEquals(newSubscriptionStartDate, newSubscription.getStartDate(), "The card number should be updated to the new value");
    }



}