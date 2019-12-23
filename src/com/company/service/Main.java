package com.company.service;

import java.io.IOException;
import java.sql.*;
import java.util.Scanner;


public class Main {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        while (true) {
            Service.menucall();
            String X1 = in.nextLine();
            switch (X1) {
                case "1":
                    Service.Dataoutput();
                    break;
                case "2":
                    Service.addCat();
                    break;
                case "3":
                    Service.SearchCatsById();
                    break;
                case "4":
                    Service.FamilySearch();
                    break;
                case "5":
                    Service.DeleteCats();
                    break;
                case "6":
                    Service.UpdateRecords();
                    break;
                case "7":
                    Service.ExitApplication();
                    break;
                default:
                    System.out.println("");
                    System.out.println("Вы ввели неподходящее значение");
                    System.out.println("");
                    break;
            }
        }
    }
}
