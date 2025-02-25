package main;

import DataBase.DataUpdater;
import DataBase.tableCreator;

public class test {
	public static void main(String[] args) {
        tableCreator.createUsersTable();
        //DataUpdater.addResident("Nguyen Van A", "aaa@example.com", "1101A1", 4, 70.0);
        //DataUpdater.deleteUserByBlockName("1101A1");
    }
}
