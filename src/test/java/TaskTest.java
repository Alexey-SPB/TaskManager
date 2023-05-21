import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TaskTest {
    @Test
    public void EpicResultMatches() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);
        Epic epic1 = new Epic(55, new String[]{});
        Assertions.assertTrue(epic.matches("Молоко"));
        Assertions.assertTrue(epic.matches("Яйца"));
        Assertions.assertTrue(epic.matches("Хлеб"));
        Assertions.assertFalse(epic1.matches("Хлеб"));
    }

    @Test
    public void SimpleTaskResultMatches() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        Assertions.assertTrue(simpleTask.matches("Позвонить"));
        Assertions.assertTrue(simpleTask.matches("родителям"));
        Assertions.assertTrue(simpleTask.matches("Позвонить родителям"));
        Assertions.assertFalse(simpleTask.matches("Позвонить мне"));
    }

    @Test
    public void MeetingResultMatches() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        Assertions.assertFalse(meeting.matches("Во вторник после обеда"));
        Assertions.assertTrue(meeting.matches("Выкатка 3й версии приложения"));
        Assertions.assertTrue(meeting.matches("Приложение НетоБанка"));

    }

}
