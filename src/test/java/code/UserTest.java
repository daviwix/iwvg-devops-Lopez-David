package code;

import es.upm.miw.iwvg_devops.code.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserTest {
    private User user;
    @BeforeEach
    void before() {
        user = new User("0", "david", "lopez", new ArrayList<>());
    }
    @Test
    void testUserFull() {
        assertEquals("0", user.getId());
        assertEquals("david", user.getName());
        assertEquals("lopez", user.getFamilyName());
        assertEquals("david lopez", user.fullName());
        assertEquals("d.", user.initials());
        assertNotNull(user.getFractions());
    }
    @Test
    void testUser() {
        user = new User();
        assertNotNull(user.getFractions());
    }
    @Test
    void testUserSets() {
        user = new User();
        user.setName("miguel");
        user.setFamilyName("perez");
        user.setFractions(new ArrayList<>());
        assertEquals("miguel", user.getName());
        assertEquals("perez", user.getFamilyName());
        assertNotNull(user.getFractions());
    }
}
