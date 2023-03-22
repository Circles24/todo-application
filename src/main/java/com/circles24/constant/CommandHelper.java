package com.circles24.constant;

import java.util.HashMap;
import java.util.Map;

public class CommandHelper {
    public final static Map<Command, Integer> commandArgsMap = new HashMap<>(){{
        put(Command.ADD, 2);
        put(Command.DELETE, 2);
        put(Command.UPDATE, 3);
        put(Command.GET, 2);
        put(Command.GET_ALL, 1);
        put(Command.HELP, 1);
    }};
}
