package com.company.operations;

import com.company.consts.Const;
import com.company.dao.ConnectionDb;
import com.company.model.Cat;

import java.sql.*;
import java.util.ArrayList;


public class DataOutput {


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


}


