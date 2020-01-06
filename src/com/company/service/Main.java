package com.company.service;

import java.sql.*;
import java.util.Scanner;


public class Main {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        while (true) {
            Service.callMenu();
            String write = in.nextLine();
            switch (write) {
                case "1":
                    Service.dataOutPut();
                    break;
                case "2":
                    Service.addCat();
                    break;
                case "3":
                    Service.searchCatsById();
                    break;
                case "4":
                    Service.familySearch();
                    break;
                case "5":
                    Service.deleteCats();
                    break;
                case "6":
                    Service.updateRecords();
                    break;
                case "7":
                    Service.exitApplication();
                    break;
                default:
                    System.out.println("");
                    System.out.println("Вы ввели неподходящее значение ");
                    System.out.println("");
                    break;
            }
        }
    }
}
