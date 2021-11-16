package database;

public enum Commands {
    ADD_STRING("addString"), ADD_LIST("addList"), ADD_MAP("addMap"),
    ADD_SET("addSet"), SHOW_DB("showDB");
    public String value;

    Commands(String value) {
        this.value = value;
    }
}
