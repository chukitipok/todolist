package fr.esgi.todolist.services;

import fr.esgi.todolist.models.User;

import java.time.LocalDate;

import static jdk.jshell.spi.ExecutionControl.*;

public class EmailService {

    private boolean isOfAge(final User user) {
        return LocalDate.now().minusYears(18).isEqual(user.getBirthday())
                || LocalDate.now().minusYears(18).isAfter(user.getBirthday());
    }

    public void send(final User user) throws NotImplementedException {
        if (isOfAge(user)) {
            throw new NotImplementedException("To do");
        }
    }
}
