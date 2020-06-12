package fr.esgi.todolist.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Item {

    public final static int CONTENT_LIMIT = 1000;

    @Id
    @GeneratedValue
    private int id;

    private String name;
    private String content;
    private LocalDateTime created;

}
