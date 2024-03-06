package ru.vsuet.bank;

import ru.vsuet.bank.domain.Command;

import java.util.ArrayList;
import java.util.List;

public class ExecuteManager {
    List<Command> commands = new ArrayList<>();

    public void addCommands(Command command) {
        commands.add(command);
    }

    public void execute() {
        commands.forEach(Command::execute);
        commands.forEach(Command::loggir);
    }
}



