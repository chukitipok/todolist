package fr.esgi.todolist;

import fr.esgi.todolist.models.Item;
import fr.esgi.todolist.services.TodoListService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TodoListServiceTest {

    @Mock
    private TodoListService todoListService;

    @BeforeEach
    public void init() {
        todoListService = Mockito.mock(TodoListService.class);
        when(todoListService.addNewItem(Mockito.any(Item.class))).thenReturn(true);
    }


}
