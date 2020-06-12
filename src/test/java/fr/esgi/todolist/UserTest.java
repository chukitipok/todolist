package fr.esgi.todolist;

import fr.esgi.todolist.models.User;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    private User user;

    @BeforeEach
    public void init() {
        this.user = User.builder()
                .firstName("fname")
                .lastName("lname")
                .email("test@test.fr")
                .password("mypasswordissecure")
                .birthday(LocalDate.now().minusYears(20))
                .build();
    }

    @Test
    public void testUserIsValidShouldReturnTrue() {
        assertTrue(user.isValid());
    }

    @Test
    public void testUserIsValidShouldReturnFalseIfAnyErrorOccurs() {
        user.setEmail("");
        assertFalse(user.isValid());
    }

    @Test
    public void testUserHasValidPropertiesShouldReturnTrue() {
        assertTrue(user.hasValidFirstNameAndLastName());
    }

    @Test
    public void testUserHasValidPropertiesShouldReturnFalseIfFirstNameIsEmpty() {
        user.setFirstName("");
        assertFalse(user.hasValidFirstNameAndLastName());
    }

    @Test
    public void testUserHasValidPropertiesShouldReturnFalseIfFirstNameIsBlank() {
        user.setFirstName(" ");
        assertFalse(user.hasValidFirstNameAndLastName());
    }

    @Test
    public void testUserHasValidPropertiesShouldReturnFalseIfLastNameIsEmpty() {
        user.setLastName("");
        assertFalse(user.hasValidFirstNameAndLastName());
    }

    @Test
    public void testUserHasValidPropertiesShouldReturnFalseIfLastNameIsBlank() {
        user.setLastName(" ");
        assertFalse(user.hasValidFirstNameAndLastName());
    }

    @Test
    public void testUserHasValidEmailShouldReturnTrue() {
        assertTrue(user.hasValidEmail());
    }

    @Test
    public void testUserHasValidEmailShouldReturnFalseIfEmailIsEmpty() {
        user.setEmail("");
        assertFalse(user.hasValidEmail());
    }

    @Test
    public void testUserHasValidEmailShouldReturnFalseIfEmailIsBlank() {
        user.setEmail(" ");
        assertFalse(user.hasValidEmail());
    }

    @Test
    public void testUserHasValidEmailShouldReturnFalseIfMissingAt() {
        user.setEmail("testtest.fr");
        assertFalse(user.hasValidEmail());
    }

    @Test
    public void testUserHasValidEmailShouldReturnFalseIfMissingDomainName() {
        user.setEmail("test@testfr");
        assertFalse(user.hasValidEmail());
    }

    @Test
    public void testUserHasValidBirthdayShouldReturnTrue() {
        assertTrue(user.hasValidBirthday());
    }

    @Test
    public void testUserHasValidBirthdayShouldReturnFalseIfYoungerThan13YearsOld() {
        user.setBirthday(LocalDate.now().minusYears(2));
        assertFalse(user.hasValidBirthday());
    }

    @Test
    public void testUserHasValidBirthdayShouldReturnTrueIf13YearsOld() {
        user.setBirthday(LocalDate.now().minusYears(13));
        assertTrue(user.hasValidBirthday());
    }

    @Test
    public void testUserHasValidPasswordShouldReturnTrue() {
        assertTrue(user.hasValidPassword());
    }

    @Test
    public void testUserHasValidPasswordShouldReturnFalseIfPasswordLengthIsLowerThan8() {
        user.setPassword("rooooot"); // 7 characters
        assertFalse(user.hasValidPassword());
    }

    @Test
    public void testUserHasValidPasswordShouldReturnFalseIfPasswordLengthIsGreaterThan40() {
        user.setPassword("rooooooooooooooooooooooooooooooooooooooot"); // 41 characters
        assertFalse(user.hasValidPassword());
    }

}
