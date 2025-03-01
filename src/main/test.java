package main;

import DataBase.DataUpdater;
import DataBase.TableCreator;

public class test {
	public static void main(String[] args) {
        TableCreator.createUsersTable();
        DataUpdater.addResident("Nguyen Van A", "aaa@example.com", "1101A1", 4, 70.0);
        //DataUpdater.deleteUserByBlockName("1101A1");
    }
}
