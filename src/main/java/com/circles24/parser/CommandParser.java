package com.circles24.parser;

import com.circles24.constant.Command;

import java.util.List;
import java.util.Optional;

public class CommandParser {
    private final List<Command> commandList = List.of(
            Command.ADD,
            Command.DELETE,
            Command.UPDATE,
            Command.GET_ALL,
            Command.GET,
            Command.HELP
    );

    public Optional<Command> parseCommand(String commandStr) {
        for (Command command : commandList) {
            if (command.name().equalsIgnoreCase(commandStr)) {
                return Optional.of(command);
            }
        }

        return Optional.empty();
    }
}
