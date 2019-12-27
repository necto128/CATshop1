package com.company.service;

import com.company.operations.*;
import com.company.model.Cat;

import java.sql.SQLException;
import java.util.Scanner;

public class Service {

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
        String nameCat = "";
        String Gender = "";
        int idDad = 0, idMam = 0;
        try {

            System.out.println("Ввведите имя кота");
            nameCat = in.nextLine();

            System.out.println("Ввведите ид отца или '00'");
            idDad = in.nextInt();

            System.out.println("Ввведите ид матери или '00'");
            idMam = in.nextInt();


            System.out.println("Выберите пол 1-Мужской или 2-Женский");
            int write = in.nextInt();
            in.nextLine();
            if (write == 1) {
                Gender = "М";
            } else {
                Gender = "Ж";
            }
            Cat cat = new Cat(nameCat, idDad, idMam, Gender);

            AddCats.addRecords(cat);

            System.out.println("Запись добавлена");
            System.out.println("////////////////////////////");
        } catch (Exception e) {
            System.out.println("Сломался");
        }
    }

    public static void dataoutput() throws SQLException, ClassNotFoundException {
        DataOutput.dataOutput();
        System.out.println();
    }


    public static void searchCatsById() throws SQLException {
        while (true) {
            int write = 0;
            System.out.println("Ввведите id кота");
            int id1 = in.nextInt();
            SearchCats.searchCatsByid(id1);
            System.out.println("Желаете продолжить/1-da||2-net");
            write = in.nextInt();
            if (write == 2) {
                System.out.println("Поиск окончен\n");
                break;
            } else {
                System.out.println("Поиск продолжен");
            }
        }
    }

    public static void familySearch() throws SQLException, ClassNotFoundException {
        int id = 0;
        Cat cat = new Cat();
        System.out.println("Введите id кота для поиска родителей");
        id = in.nextInt();
        in.nextLine();

        System.out.println("Сын");
        SearchfamilybyID.searchfamilyBYID(id, cat);

        System.out.println("Отец");
        SearchfamilybyID.searchParents(cat.getIdDad(), cat);

        System.out.println("Мать");
        SearchfamilybyID.searchParents(cat.getIdMam(), cat);


        System.out.println();
    }

    public static void deleteCats() {
        Cat cat = new Cat();
        System.out.println("Введите id для удаления записи");
        cat.setIdCat(in.nextInt());
        in.nextLine();
        DeleteCats.deleteRecord(cat);
    }

    public static void updateRecords() {
        String nameCat = "";
        String Gender = "";
        int idDad = 0, idMam = 0, idcat = 0;

        System.out.println("Выберите id для обновления записи");
        idcat = in.nextInt();
        in.nextLine();

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
        Cat cat = new Cat(idcat, nameCat, idDad, idMam, Gender);
        UpdateRecords.updataCats(cat);


    }

    public static void exitApplication() {
        System.out.println("Канец программы");
        in.close();
        System.exit(0);
    }

}
