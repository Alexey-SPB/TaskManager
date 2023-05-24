import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TodosTest {


    SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям после обеда");

    String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
    Epic epic = new Epic(55, subtasks);

    Meeting meeting = new Meeting(
            555,
            "Выкатка 3й версии приложения",
            "Приложение НетоБанка сделать родителям",
            "Во вторник после обеда"
    );

    Todos todos = new Todos();

    @BeforeEach
    public void set() {
        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);
    }

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void SearchTaskEpic() {
        Task[] expected = {epic};
        Task[] actual = todos.search("Молоко");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void SearchTaskMeeting() {
        Task[] expected = {meeting};
        Task[] actual = todos.search("НетоБанка");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void SearchTaskSimple() {
        Task[] expected = {simpleTask};
        Task[] actual = todos.search("Позвонить");
        Assertions.assertArrayEquals(expected, actual);
    }

    //Находится одна задача
    @Test
    public void SearchTaskOneTask() {
        Task[] expected = {simpleTask};
        Task[] actual = todos.search("Позвонить родителям");
        Assertions.assertArrayEquals(expected, actual);
    }

    // не находится ни одной
    @Test
    public void SearchTaskNoTask() {
        Task[] expected = {};
        Task[] actual = todos.search("Сходить в бар");
        Assertions.assertArrayEquals(expected, actual);
    }

    // находится несколько задач
    @Test
    public void SearchTaskSeveralTask() {
        Task[] expected = {simpleTask, meeting};
        Task[] actual = todos.search("родителям");
        Assertions.assertArrayEquals(expected, actual);
    }
}
