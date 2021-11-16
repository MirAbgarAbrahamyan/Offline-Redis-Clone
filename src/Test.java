import database.DataBase;
import helper.UserService;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        // Server.start();
        UserService.greetUser();

        DataBase.db.put("String-Key", "StringValue");
        DataBase.db.put("List-Key", new ArrayList<String>());
        ArrayList<String> tempList;
        if (DataBase.db.get("List-Key") instanceof ArrayList) {
            tempList = (ArrayList<String>) DataBase.db.get("List-Key");
            tempList.add("List-Item1");
            tempList.add("List-Item2");
            tempList.add("List-Item3");
        }
        while (true) {
            UserService.enterCommand();
        }
//        database.DataBase.showDB();
    }
}
