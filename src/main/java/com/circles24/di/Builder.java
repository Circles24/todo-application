package com.circles24.di;

import com.circles24.ToDoApplication;
import com.circles24.parser.CommandParser;
import com.circles24.repository.TaskRepository;
import com.circles24.service.TaskService;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;

import java.util.Properties;


// since the application is small doing the wiring manually we can switch to di tool for complex wiring logic
public class Builder {
    private static final String DB_USERNAME = "root";

    private static final String DB_PASSWORD = "Yahoofinland@123";

    private static final String DB_URL = "jdbc:mysql://localhost:3306/todo_db?user=root&password=Yahoofinland%40123";

    public static ToDoApplication wire() {
        CommandParser commandParser = getCommandParser();
        Jdbi jdbi = getJdbi();
        TaskRepository taskRepository = getTaskRepository(jdbi);
        TaskService taskService = getTaskService(taskRepository);
        return getToDoApplication(commandParser, taskService);
    }

    private static ToDoApplication getToDoApplication(CommandParser commandParser, TaskService taskService) {
        return new ToDoApplication(commandParser, taskService);
    }

    private static TaskService getTaskService(TaskRepository taskRepository) {
        return new TaskService(taskRepository);
    }

    private static Jdbi getJdbi() {
//        Properties properties = new Properties();
//        properties.setProperty("user", DB_USERNAME);
//        properties.setProperty("password", DB_USERNAME);

        Jdbi jdbi = Jdbi.create(DB_URL);
        jdbi.installPlugin(new SqlObjectPlugin());
        return jdbi;
    }

    private static TaskRepository getTaskRepository(Jdbi jdbi) {
        return new TaskRepository(jdbi);
    }

    private static CommandParser getCommandParser() {
        return new CommandParser();
    }
}
