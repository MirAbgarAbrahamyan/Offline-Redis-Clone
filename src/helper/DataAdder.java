package helper;

import java.util.*;

public class DataAdder {
    private static final Scanner scan = new Scanner(System.in);

    static String askForKey() {
        System.out.print("Enter the key: ");
        return scan.nextLine();
    }

    static String askForString() {
        System.out.print("Enter the value(String): ");
        return scan.nextLine();
    }

    static List<String> askForList() {
        List<String> list = new ArrayList<>();
        String commandName = "initialValue";
        while (!commandName.equalsIgnoreCase("exit")) {
            System.out.print("Enter the command(insert/delete/exit): ");
            commandName = scan.nextLine();
            if (commandName.equals("insert")) {
                System.out.println("Enter the member: ");
                String item = scan.nextLine();
                list.add(item);
            } else if (commandName.equals("delete")) {
                System.out.println("Enter the member name to delete:");
                String item = scan.nextLine();
                list.remove(item);
            }
        }
        return list;
    }

    static Map<String, String> askForMap() {
        Map<String, String> map = new HashMap<>();
        String commandName = "initialValue";
        while (!commandName.equalsIgnoreCase("exit")) {
            System.out.print("Enter the command(insert/delete/exit): ");
            commandName = scan.nextLine();
            if (commandName.equals("insert")) {
                System.out.println("Enter the memberKey:");
                String memberKey = scan.nextLine();
                System.out.println("Enter the memberValue:");
                String memberValue = scan.nextLine();
                map.put(memberKey, memberValue);
            } else if (commandName.equals("delete")) {
                System.out.println("Enter the memberKey name to delete:");
                String memberKey = scan.nextLine();
                map.remove(memberKey);
            }
        }
        return map;
    }

    static Set<String> askForSet() {
        Set<String> set = new HashSet<>();
        String commandName = "initialValue";
        while (!commandName.equalsIgnoreCase("exit")) {
            System.out.print("Enter the command(insert/delete/exit): ");
            commandName = scan.nextLine();
            if (commandName.equals("insert")) {
                System.out.println("Enter the member:");
                String member = scan.nextLine();
                set.add(member);
            } else if (commandName.equals("delete")) {
                System.out.println("Enter the member name to delete:");
                String member = scan.nextLine();
                set.remove(member);
            }
        }
        return set;
    }
}
