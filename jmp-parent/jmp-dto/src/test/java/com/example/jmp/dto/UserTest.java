import com.example.jmp.dto.User;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

public class UserTest {

    private String name;
    private String surname;
    private LocalDate birthday;
    private User userMichael;

    @BeforeEach
    void setUp() {
        name = "Michael";
        surname = "Jackson";
        birthday = LocalDate.of(1990, 1, 1);
        userMichael = new User(name, surname, birthday);
    }

    @Test
    void testGetName() {
        assertEquals(name, userMichael.getName(), "The user's name should match the expected value");
    }

    @Test
    void testSetName() {
        String newName = "Elvis";
        userMichael.setName(newName);
        assertEquals(newName, userMichael.getName(), "The user's name should be updated to the new value");
    }

    @Test
    void testGetSurname() {
        assertEquals(surname, userMichael.getSurname(), "The user's name should match the expected value");
    }

    @Test
    void testSetSurname() {
        String newSurname = "Presley";
        userMichael.setSurname(newSurname);
        assertEquals(newSurname, userMichael.getSurname(), "The user's name should be updated to the new value");
    }

    @Test
    void testGetBirthday() {
        assertEquals(birthday, userMichael.getBirthday(), "The user's birthday should match the expected value");
    }

    @Test
    void testSetBirthday() {
        LocalDate newBirthday = LocalDate.of(2000, 10, 16);
        userMichael.setBirthday(newBirthday);
        assertEquals(newBirthday, userMichael.getBirthday(), "The user's birthday should be updated to the new value");
    }

}
