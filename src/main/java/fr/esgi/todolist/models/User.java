package fr.esgi.todolist.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.regex.Pattern;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue
    private int id;

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private LocalDate birthday;


    public boolean isValid() {
        return this.hasValidFirstNameAndLastName() && hasValidEmail() && hasValidBirthday();
    }

    public boolean hasValidFirstNameAndLastName() {
        return !firstName.isEmpty() && !firstName.isBlank()
                && !lastName.isEmpty() && !lastName.isBlank();
    }

    public boolean hasValidBirthday() {
        return this.birthday != null
                && (LocalDate.now().minusYears(13).isAfter(this.birthday)
                || LocalDate.now().minusYears(13).isEqual(this.birthday));
    }

    public boolean hasValidEmail() {
        final String emailRegex = "^(([^<>()\\[\\]\\\\.,;:\\s@\"]+(\\.[^<>()\\[\\]\\\\.,;:\\s@\"]+)*)|(\".+\"))@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        return Pattern.matches(emailRegex, this.email);
    }

    public boolean hasValidPassword() {
        return password.length() >= 8 && password.length() <= 40;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
