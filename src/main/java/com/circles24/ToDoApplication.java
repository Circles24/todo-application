package com.circles24;

import com.circles24.constant.Command;
import com.circles24.constant.CommandHelper;
import com.circles24.di.Builder;
import com.circles24.parser.CommandParser;
import com.circles24.service.TaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
public class ToDoApplication {
    private final CommandParser commandParser;

    private final TaskService taskService;

    private void help() {
        log.info("todo application help section");
        log.info("command to run the application : java todo <command> <args>");

        log.info("commands : add, delete, update, get, get_all");

        help(Command.ADD);
        help(Command.DELETE);
        help(Command.UPDATE);
        help(Command.GET);
        help(Command.GET_ALL);
        help(Command.HELP);
    }

    private void help(Command command) {
        switch (command) {
            case ADD -> {
                log.info("add : creates new todo entry and requires description of the task as argument");
                log.info("eg : java -jar target/todo-application-1.0-SNAPSHOT-jar-with-dependencies.jar add get groceries for tomorrow");
            }

            case DELETE -> {
                log.info("delete : marks a task entry as INACTIVE, it takes task id as argument");
                log.info("eg : java target/todo-application-1.0-SNAPSHOT-jar-with-dependencies.jar delete ae4dd423-115f-4f4d-8d6a-d9dd1d1af35f");
            }

            case UPDATE -> {
                log.info("update : updates the description of a task, it takes task id and new description as argument");
                log.info("eg : java target/todo-application-1.0-SNAPSHOT-jar-with-dependencies.jar update ae4dd423-115f-4f4d-8d6a-d9dd1d1af35f get groceries for today");
            }

            case GET -> {
                log.info("get : fetches a task entry, it takes task id as argument");
                log.info("eg : java target/todo-application-1.0-SNAPSHOT-jar-with-dependencies.jar get ae4dd423-115f-4f4d-8d6a-d9dd1d1af35f");
            }

            case GET_ALL -> {
                log.info("get_all : fetches all the tasks");
                log.info("eg : java target/todo-application-1.0-SNAPSHOT-jar-with-dependencies.jar get_all");
            }

            case HELP -> {
                log.info("help : renders the help section");
                log.info("eg : java target/todo-application-1.0-SNAPSHOT-jar-with-dependencies.jar help");
            }
        }
    }

    public static void main(String []args) {
        ToDoApplication toDoApplication = Builder.wire();
        toDoApplication.runCommand(args);
    }

    public void runCommand(String []args) {
        log.info("args : {}", Arrays.stream(args).toList());

        if (args.length < 1) {
            log.error("expected at least one cli argument");
            help();
            return;
        }

        Optional<Command> command = commandParser.parseCommand(args[0]);
        if (command.isEmpty()) {
            log.error("invalid command : {}", args[0]);
            help();
            return;
        }

        if (!validateArguments(command.get(), args)) {
            log.error("invalid args");
            help();
            return;
        }

        executeCommand(command.get(), args);
    }

    private boolean validateArguments(Command command, String args[]) {
        if (args.length < CommandHelper.commandArgsMap.get(command)) {
            help(command);
            return false;
        }

        return true;
    }

    private void executeCommand(Command command, String args[]) {
        switch (command) {
            case ADD -> {
                String[] strippedArgs = Arrays.stream(args, 1, args.length).toArray(String[]::new);
                String description = StringUtils.join(strippedArgs, " ");
                taskService.addTask(description);
            }
            case DELETE -> taskService.deleteTask(args[1]);
            case UPDATE -> {
                String[] strippedArgs = Arrays.stream(args, 2, args.length).toArray(String[]::new);
                String description = StringUtils.join(strippedArgs, " ");
                taskService.updateTask(args[1], description);
            }
            case GET -> taskService.getById(args[1]);
            case GET_ALL -> taskService.getAll();
        }
    }
}