package helper;

import database.Commands;
import database.DataBase;
import utils.Utility;

import java.util.*;

import static database.Commands.*;
import static database.Commands.ADD_LIST;

public class UserService {
    private static final Scanner scan = new Scanner(System.in);

    public static void greetUser() {
        System.out.println("*******************************************************************");
        System.out.println("*             Hello and welcome to Redis Clone Server             *");
        System.out.println("*   ### addString     -> asks you to add a string in db           *");
        System.out.println("*   ### addList       -> asks you to add a list in db             *");
        System.out.println("*        | | |           | | | | | | | | | | | | | |              *");
        System.out.println("*     ## insert       -> asks you to add an item to the list      *");
        System.out.println("*     ## delete       -> asks you to remove an item from the list *");
        System.out.println("*     ## exit         -> returns to the main command window       *");
        System.out.println("*   ### addMap        -> asks you to add a map in db              *");
        System.out.println("*        | | |           | | | | | | | | | | | | | |              *");
        System.out.println("*     ## insert       -> asks you to add an item to the map       *");
        System.out.println("*     ## delete       -> asks you to remove an item from the map  *");
        System.out.println("*     ## exit         -> returns to the main command window       *");
        System.out.println("*   ### addSet        -> asks you to add a set in db              *");
        System.out.println("*        | | |           | | | | | | | | | | | | | |              *");
        System.out.println("*     ## insert       -> asks you to add an item to the set       *");
        System.out.println("*     ## delete       -> asks you to remove an item from the set  *");
        System.out.println("*     ## exit         -> returns to the main command window       *");
        System.out.println("*******************************************************************");
    }

    private static boolean userAgrees(String key) {
        if (DataBase.db.containsKey(key)) {
            System.out.print("Are you sure you want to delete the " + key + "'s information(y/n): ");
            while (true) {
                char ans = scan.nextLine().charAt(0);
                if (ans == 'y' || ans == 'Y') {
                    return true;
                } else if (ans == 'n' || ans  == 'N') {
                    return false;
                }
            }
        }
        return true;
    }

    public static void enterCommand() {
        String commandName = null;
        while (commandName == null || !Utility.isCommand(commandName)) {
            System.out.print("Enter the command: ");
            commandName = scan.nextLine();
        }
        Commands command = valueOf(Utility.toEnumValue(commandName));
//        System.out.println(command);
        /**
         * We have to warn the user when he is trying to change something which is existing
         */
        String key;
        switch (command) {
            case ADD_STRING:
                key = DataAdder.askForKey();
                if (Utility.isString(key)) {
                    if (userAgrees(key)) {
                        String value = DataAdder.askForString();
                        DataBase.addString(key, value);
                    }
                    break;
                }
                System.out.println("Cannot change the structure");
                break;
            case ADD_LIST:
                key = DataAdder.askForKey();
                if (Utility.isList(key)) {
                    if (userAgrees(key)) {
                        List<String> value = DataAdder.askForList();
                        DataBase.addList(key, value);
                    }
                    break;
                }
                System.out.println("Cannot change the structure");
                break;
            case ADD_MAP:
                key = DataAdder.askForKey();
                if (Utility.isMap(key)) {
                    if (userAgrees(key)) {
                        Map<String, String> value = DataAdder.askForMap();
                        DataBase.addMap(key, value);
                    }
                    break;
                }
                System.out.println("Cannot change the structure");
                break;
            case ADD_SET:
                key = DataAdder.askForKey();
                if (Utility.isSet(key)) {
                    if (userAgrees(key)) {
                        Set<String> value = DataAdder.askForSet();
                        DataBase.addSet(key, value);
                    }
                    break;
                }
                System.out.println("Cannot change the structure");
                break;
            case SHOW_DB:
                DataBase.showDB();
                break;
            default:
                break;
        }
    }
}
