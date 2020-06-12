package fr.esgi.todolist.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TodoList {

    @Id
    @GeneratedValue
    private int id;

    @OneToMany
    private List<Item> items;

    public final static int ITEM_LIMIT = 10;
    public final static int MINUTES_DIFF = 30;

    public Item canAddItem(final Item item) {
        if (items.size() == ITEM_LIMIT || itemNameExists(item)
                || !checkItemCreationTime(item)
                || item.getContent().length() > Item.CONTENT_LIMIT) {
            return null;
        }

        return item;
    }

    private boolean itemNameExists(final Item item) {
        final var itemsName = items.stream()
                .map(Item::getName)
                .collect(Collectors.toList());

        return itemsName.contains(item.getName());
    }

    private boolean checkItemCreationTime(final Item item) {
        final var lastItem = items.get(items.size() - 1);

        return lastItem.getCreated()
                .plusMinutes(MINUTES_DIFF)
                .isBefore(item.getCreated());
    }

}
