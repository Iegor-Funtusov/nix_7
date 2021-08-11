package ua.com.alevel;

import ua.com.alevel.controller.UserController;

public class CrudLookupMain {

    public static void main(String[] args) {
        System.out.println("CrudLookupMain.main");
        new UserController().start();
    }
}
