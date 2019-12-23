package com.company.service;

import com.company.operations.*;
import com.company.model.Cat;

import java.sql.SQLException;
import java.util.Scanner;

public class Service {
    private static String nameCat = "";
    private static String Gender = "";
    private static int idDad = 0, idMam = 0, idcat = 0;
    static Scanner in = new Scanner(System.in);


    public static void menucall() {
        System.out.println("Вывод всех данных->1");
        System.out.println("Ввод даных->2");
        System.out.println("поиск->3");
        System.out.println("Вывод родителей->4");
        System.out.println("Удаление записи->5");
        System.out.println("обновление записей->6");
        System.out.println("Завершение программы->7");
    }

    public static void addCat() {
        try {
            Cat cat = new Cat();
            System.out.println("Ввведите имя кота");
            nameCat = in.nextLine();

            System.out.println("Ввведите ид отца или '00'");
            idDad = in.nextInt();

            System.out.println("Ввведите ид матери или '00'");
            idMam = in.nextInt();


            System.out.println("Выберите пол 1-Мужской или 2-Женский");
            int o = in.nextInt();
            in.nextLine();
            if (o == 1) {
                Gender = "М";
            } else {
                Gender = "Ж";
            }
            cat.setNameCat(nameCat);
            cat.setIdMam(idDad);
            cat.setIdDad(idMam);
            cat.setGender(Gender);

            AddCats.AddRecords(cat);

            System.out.println("Запись добавлена");
            System.out.println("////////////////////////////");
        } catch (Exception e) {
            System.out.println("Сломался");
        }
    }

    public static void Dataoutput() {
        DataOutput wrclass = new DataOutput();
        try {
            wrclass.DataOutput();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println();
    }


    public static void SearchCatsById() throws SQLException, ClassNotFoundException {
        int a11 = 0;
        while (true) {
            System.out.println("Ввведите id кота");
            int id1 = in.nextInt();
            SearchCats.SearchCatsByid(id1);
            System.out.println("Желаете продолжить/1-da||2-net");
            a11 = in.nextInt();
            if (a11 == 2) {
                System.out.println("Поиск окончен\n");
                break;
            } else {
                System.out.println("Поиск продолжен");
            }
        }
    }

    public static void FamilySearch() {
        int id = 0;
        Cat cat = new Cat();
        System.out.println("Введите id кота для поиска родителей");
        id = in.nextInt();
        in.nextLine();
        System.out.println("Сын");
        try {
            SearchfamilybyID.SearchfamilyBYID(id, cat);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("Отец");
        try {
            SearchfamilybyID.SearchParents(cat.getIdDad(), cat);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("Мать");
        try {
            SearchfamilybyID.SearchParents(cat.getIdMam(), cat);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println();
    }

    public static void DeleteCats() throws SQLException, ClassNotFoundException {
        int id = 0;
        System.out.println("Введите id для удаления записи");
        id = in.nextInt();
        in.nextLine();
        DeleteCats.DeleteRecord(id);
    }

    public static void UpdateRecords() {

        Cat cat = new Cat();

        System.out.println("Выберите id для обновления записи");
        idcat = in.nextInt();
        in.nextLine();

        System.out.println("Ввведите имя кота");
        cat.setNameCat(in.nextLine());

        System.out.println("Ввведите ид отца или '00'");
        cat.setIdDad(in.nextInt());

        System.out.println("Ввведите ид матери или '00'");
        cat.setIdMam(in.nextInt());

        System.out.println("Выберите пол 1-Мужской или 2-Женский");
        int o = in.nextInt();
        in.nextLine();
        if (o == 1) {
            cat.setGender("М");
        } else {
            cat.setGender("Ж");
        }

        try {
            UpdateRecords.UpdataCats(cat, idcat);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void ExitApplication() {
        System.out.println("Канец программы");
        in.close();
        System.exit(0);
    }

    public static boolean checkString(String string) {
        try {
            Integer.parseInt(string);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
