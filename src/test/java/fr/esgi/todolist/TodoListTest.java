package fr.esgi.todolist;

import fr.esgi.todolist.models.Item;
import fr.esgi.todolist.models.TodoList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TodoListTest {

    private TodoList todoList;

    private Item item;

    @BeforeEach
    public void init() {
        item = Item.builder()
                .name("item_x")
                .content("content")
                .created(LocalDateTime.now().plusMinutes(35))
                .build();

        final List<Item> itemList = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            final var item = Item.builder()
                    .name("item_" + i)
                    .content("content")
                    .created(LocalDateTime.now())
                    .build();

            itemList.add(item);
        }
        todoList = TodoList.builder()
                .items(itemList)
                .build();
    }

    @Test
    public void testCanAddItemShouldReturnItem() {
        assertEquals(item, this.todoList.canAddItem(item));
    }

    @Test
    public void testCanAddItemShouldReturnNullIfTodoListIsFull() {
        todoList.getItems().add(item);
        assertNull(todoList.canAddItem(item));
    }

    @Test
    public void testCanAddItemShouldReturnNullIfItemNameAlreadyExists() {
        item.setName("item_0");
        assertNull(todoList.canAddItem(item));
    }

    @Test
    public void testCanAddItemShouldReturnNullIfItemIsAddedBeforeWaiting30Minutes() {
        final var lastItemDate = todoList.getItems()
                .get(todoList.getItems().size() - 1).getCreated();

        item.setCreated(lastItemDate.plusMinutes(15));
        assertNull(todoList.canAddItem(item));
    }

    @Test
    public void testCanAddItemShouldReturnNullIfItemContentLengthIsGreaterThan1000() {
        final var content = new String(new char[1001]).replace('\0', 'a');
        item.setContent(content);
        assertNull(todoList.canAddItem(item));
    }

}
