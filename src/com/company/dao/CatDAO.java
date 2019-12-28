package com.company.dao;

import com.company.consts.Const;
import com.company.model.Cat;

import java.sql.*;
import java.util.ArrayList;


public class CatDAO {
    //////////////////ДОБАВЛЕНИЕ ЗАПИСИ
    public static void addRecords(Cat cat) {

        String insert = "INSERT INTO " + Const.USER_TABLE + "(" + Const.NAME_CAT + "," + Const.ID_DAD + "," + Const.ID_MAM + "," + Const.GENDER + ") VALUES(?,?,?,?)";

        try ( PreparedStatement prSt = ConnectionDb.getDbConnection().prepareStatement(insert) ) {
            prSt.setString(1, cat.getNameCat());
            prSt.setInt(2, cat.getIdDad());
            prSt.setInt(3, cat.getIdMam());
            prSt.setString(4, cat.getGender());
            prSt.executeUpdate();

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Ошибка 2");
            ex.printStackTrace();
        }
    }

    ///////////////////////////////ВЫВОД ЗАПИСЕЙ

    public static void dataOutput() throws SQLException, ClassNotFoundException {
        ResultSet rs;
        try ( Statement st = ConnectionDb.getDbConnection().createStatement(); ) {

            String Select = "SELECT *FROM " + Const.USER_TABLE;

            rs = st.executeQuery(Select);
            ArrayList<String> cats = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("id");
                String namecat = rs.getString("name_cat");
                int iddad = rs.getInt("id_dad");
                int idmam = rs.getInt("id_mam");
                String gender = rs.getString("gender");
                Cat cat = new Cat(id, namecat, iddad, idmam, gender);
                dataOutput(cat, cats);
            }
            printCats(cats);
        }

    }

    public static void dataOutput(Cat cat, ArrayList<String> cats) {
        cats.add("Cat{ " +
                "Id Кота=" + cat.getIdCat() +
                ", Имя='" + cat.getNameCat() + '\'' +
                ", Id Отца=" + cat.getIdDad() +
                ", Id Матери=" + cat.getIdMam() +
                ", пол='" + cat.getGender() + '\'' +
                " }");
    }

    public static void printCats(ArrayList<String> cats) {
        for (String s : cats) {
            System.out.println(s);
        }
    }

    /////////////////////////////////УДАЛЕНИЕ ЗАПИСИ

    public static void deleteRecord(Cat cat) {

        try ( Statement prSt = ConnectionDb.getDbConnection().createStatement(); ) {
            String delete = "DELETE FROM " + Const.USER_TABLE + " WHERE id=" + cat.getIdCat();
            prSt.executeUpdate(delete);
            System.out.println("///////////////////////////////////");
            System.out.println("Запись удалена\n");
        } catch (Exception e) {
        }

    }
/////////////////////////////////ПОИСК ЗАПИСИ

    public static void searchCatsByid(Cat cat) {
        ResultSet rs;
        int id = 0;

        try ( Statement st = ConnectionDb.getDbConnection().createStatement(); ) {
            String Select = "SELECT *FROM " + Const.USER_TABLE + " WHERE id=" + cat.getIdCat();

            rs = st.executeQuery(Select);
            ArrayList<String> cats = new ArrayList<>();
            while (rs.next()) {
                id = rs.getInt("id");
                String namecat = rs.getString("name_cat");
                int iddad = rs.getInt("id_dad");
                int idmam = rs.getInt("id_mam");
                String gender = rs.getString("gender");
                Cat cat1 = new Cat(id, namecat, iddad, idmam, gender);
                dataOutput(cat1, cats);

            }
            if (id == 0) {
                System.out.println("Запись не найдена");
            } else {
                printCats(cats);
            }
            System.out.println("///////////////////////////////////");
        } catch (Exception e) {
            System.out.println("ошибка 3.1");
        }
    }
//////////////////////////////////////////////ПОИСК СЕМЬИ

    public static void searchfamilyBYID(Cat cat) {
        ResultSet rs;
        try ( Statement st = ConnectionDb.getDbConnection().createStatement(); ) {
            String Select = "SELECT *FROM " + Const.USER_TABLE + " WHERE id=" + cat.getIdCat();


            rs = st.executeQuery(Select);
            ArrayList<String> cats = new ArrayList<>();
            while (rs.next()) {
                cat.setIdCat(rs.getInt("id"));
                cat.setNameCat(rs.getString("name_cat"));
                cat.setIdMam(rs.getInt("id_dad"));
                cat.setIdDad(rs.getInt("id_mam"));
                cat.setGender(rs.getString("gender"));
                dataOutput(cat, cats);
            }
            printCats(cats);
        } catch (Exception e) {
            System.out.println("ошибка 4.1");
        }
    }

    public static void searchParents(int iD) {
        ResultSet rs;
        String select = "SELECT * FROM " + Const.USER_TABLE + " WHERE id=" + iD;
        try ( Statement st = ConnectionDb.getDbConnection().createStatement(); ) {

            rs = st.executeQuery(select);
            while (rs.next()) {
                String write = "Cat{ " +
                        "Id Кота=" + rs.getInt("id") +
                        ", Имя='" + rs.getString("name_cat") + '\'' +
                        ", Id Отца=" + rs.getInt("id_dad") +
                        ", Id Матери=" + rs.getInt("id_mam") +
                        ", пол='" + rs.getString("gender") + '\'' +
                        " }";
                System.out.println(write);
            }
        } catch (Exception e) {
            System.out.println("ошибка 4.2 и 4.3");
        }

    }
    ////////////////////////////////////////ОБНОВЛЕНИЕ ЗАПИСИ

    public static void updataCats(Cat cat) {

        try ( Statement st = ConnectionDb.getDbConnection().createStatement(); ) {


            String updata = "UPDATE " + Const.USER_TABLE + " set name_cat='" + cat.getNameCat() + "',id_dad='" + cat.getIdDad() + "',id_mam='" + cat.getIdMam() + "' WHERE id=" + cat.getIdCat();
            st.executeUpdate(updata);

            System.out.println("///////////////////////////////////\n");
        } catch (Exception e) {
            System.out.println("ошибка 6(внутрянняя)");
        }
        System.out.println("Запись изменена\n");
    }
}
