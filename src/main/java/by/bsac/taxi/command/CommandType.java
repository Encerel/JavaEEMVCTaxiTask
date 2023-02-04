package by.bsac.taxi.command;

import by.bsac.taxi.command.impl.*;

import java.util.HashMap;
import java.util.Map;

public class CommandType {

    private static final Map<String, Command> commands = new HashMap<>();;

    static {
        commands.put("sign_in", new SignInCommand());
        commands.put("to_sign_in", new ToSignInCommand());
        commands.put("sign_up", new SignUpCommand());
        commands.put("to_sign_up", new ToSignUpCommand());
        commands.put("change_user_role", new ChangeUserRoleCommand());
        commands.put("unknown_command", new UnknownCommand());
        commands.put("log_out", new LogOutCommand());
        commands.put("find_all_users", new FindAllUsersCommand());
        commands.put("cost_taxis", new CalculateCostTaxisCommand());
        commands.put("sort_by_fuel_consumption", new SortByFuelConsumptionCommand());
        commands.put("sort_by_speed_range", new SortByTaxiSpeedCommand());
        commands.put("to_admin_page", new ToAdminPageCommand());
    }


    public static Command getCurrentCommand(String command) {
        return commands.get(command);
    }

}
