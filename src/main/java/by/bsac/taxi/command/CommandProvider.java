package by.bsac.taxi.command;

import by.bsac.taxi.command.impl.UnknownCommand;

public class CommandProvider {


    public static Command defineCommand(String command) {
        Command current = null;

        if (command == null || command.isEmpty()) {
            current = new UnknownCommand();
        }

        try {

            current = CommandType.getCurrentCommand(command);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            current = new UnknownCommand();
        }

        return current;
    }
}
