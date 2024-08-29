import com.example.jmp.cloud.service.impl.ServiceImplementation;
import com.example.jmp.dto.*;
import com.example.jmp.service.api.Service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.Optional;
import java.util.List;
import java.lang.reflect.Field;

public class ServiceImplementationTest {

    private Service service;
    private User userMichael;
    private User userElvis;
    private CreditBankCard creditBankCard;
    private DebitBankCard debitBankCard;
    private String creditCardNumber;
    private String debitCardNumber;

    @BeforeEach
    void setUp() {
        service = new ServiceImplementation();
        userMichael = new User("Michael", "Jackson", LocalDate.of(1991, 3, 14));
        userElvis = new User("Elvis", "Presley", LocalDate.of(2000, 3, 14));
        creditCardNumber = "4444-4444-4444-4444";
        creditBankCard = new CreditBankCard(creditCardNumber, userMichael);
        debitCardNumber = "1111-1111-1111-1111";
        debitBankCard = new DebitBankCard(debitCardNumber, userMichael);
    }

    @Test
    void testSubscribe() {
        Optional<Subscription> subscription1 = service.getSubscriptionByBankCardNumber(creditCardNumber);
        //Why cant I use null, how to validate Optional.empty?
        assertFalse(subscription1.isPresent(), "Subscription should be present for the given bank card number");

        service.subscribe(creditBankCard);
        Optional<Subscription> subscription = service.getSubscriptionByBankCardNumber(creditCardNumber);

        assertTrue(subscription.isPresent(), "Subscription should be present for the given bank card number");
        assertEquals(creditCardNumber, subscription.get().getBankcardNumber(), "The subscription bank card number should match");
    }

    @Test
    void testGetSubscriptionByBankCardNumberWhenExists() {
        service.subscribe(creditBankCard);
        Optional<Subscription> subscription = service.getSubscriptionByBankCardNumber(creditCardNumber);

        assertNotNull(subscription, "Subscription object should not be null");
        assertTrue(subscription.isPresent(), "Subscription should be found for the given bank card number");
        assertEquals(creditCardNumber, subscription.get().getBankcardNumber(), "The subscription bank card number should match");
    }

    @Test
    void testGetSubscriptionByBankCardNumberWhenNotExists() {
        Optional<Subscription> subscription = service.getSubscriptionByBankCardNumber(creditCardNumber);

        assertFalse(subscription.isPresent(), "Subscription should not be found for the given bank card number");
    }

    @Test
    void testGetAllUsers() throws NoSuchFieldException, IllegalAccessException {
        List<User> usersList = service.getAllUsers();

        assertTrue(usersList.isEmpty(), "User list should be empty");
        assertEquals(0, usersList.size(), "User list should contain any user");

        //Logic to be able to add users to the list ln 72-78
        Field usersField = ServiceImplementation.class.getDeclaredField("users");
        usersField.setAccessible(true);
        List<User> users = (List<User>) usersField.get(service);

        users.add(userMichael);
        users.add(userElvis);

        List<User> usersListUpdated = service.getAllUsers();

        assertEquals(2, usersListUpdated.size(), "User list should contain two users");
        assertEquals(userMichael, usersListUpdated.get(0), "The user should match the michael user");
        assertEquals(userElvis, usersListUpdated.get(1), "The user should match the elvis user");
    }

    @Test
    void testGetAllSubscriptions() {
        List<Subscription> subscriptionList = service.getAllSubscriptions();

        assertTrue(subscriptionList.isEmpty(), "User list should be empty");
        assertEquals(0, subscriptionList.size(), "User list should contain any user");

        service.subscribe(creditBankCard);
        service.subscribe(debitBankCard);

        List<Subscription> subscriptions = service.getAllSubscriptions();

        assertFalse(subscriptionList.isEmpty(), "User list should no be empty");
        assertEquals(2, subscriptions.size(), "Subscriptions list should contain two subscriptions");

    }

    @Test
    void testCreateCreditBankCard() {
        BankCard bankCard = service.createBankCard(userMichael, BankCardType.CREDIT);

        assertTrue(bankCard instanceof CreditBankCard, "BankCard should be an instance of CreditBankCard");
        assertTrue(bankCard instanceof BankCard, "BankCard should be an instance of BankCard");
        assertEquals(userMichael, bankCard.getUser(), "BankCard user should match the user");
    }

    @Test
    void testCreateDebitBankCard() {
        BankCard bankCard = service.createBankCard(userElvis, BankCardType.DEBIT);

        assertTrue(bankCard instanceof DebitBankCard, "BankCard should be an instance of DebitBankCard");
        assertTrue(bankCard instanceof BankCard, "BankCard should be an instance of BankCard");
        assertEquals(userElvis, bankCard.getUser(), "BankCard user should match the user");
    }

}
