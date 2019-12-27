package com.company.operations;

import com.company.consts.Const;
import com.company.dao.ConnectionDb;
import com.company.model.Cat;

import java.sql.*;

public class SearchfamilybyID {




    public static void searchfamilyBYID(int iD, Cat cat) throws SQLException, ClassNotFoundException {
        ResultSet rs;
        try(Statement st = ConnectionDb.getDbConnection().createStatement();) {
        String Select = "SELECT *FROM " + Const.USER_TABLE + " WHERE id=" + iD;


            rs = st.executeQuery(Select);

            while (rs.next()) {
                cat.setIdCat(rs.getInt("id"));
                cat.setNameCat(rs.getString("name_cat"));
                cat.setIdMam(rs.getInt("id_dad"));
                cat.setIdDad(rs.getInt("id_mam"));
                cat.setGender(rs.getString("gender"));
                System.out.println(cat.toString());
            }
        } catch (Exception e) {
            System.out.println("ошибка 4");
        }
    }


    public static void searchParents(int iD, Cat cat) throws SQLException {
        ResultSet rs;
        String select = "SELECT * FROM " + Const.USER_TABLE + " WHERE id=" + iD;
        try(Statement st= ConnectionDb.getDbConnection().createStatement();) {

            rs = st.executeQuery(select);

            while (rs.next()) {
                String write="Cat{ " +
                        "Id Кота=" + rs.getInt("id") +
                        ", Имя='" + rs.getString("name_cat") + '\'' +
                        ", Id Отца=" + rs.getInt("id_dad") +
                        ", Id Матери=" + rs.getInt("id_mam") +
                        ", пол='" + rs.getString("gender") + '\'' +
                        " }";;
                System.out.println(write);
            }
       } catch (Exception e) {
          System.out.println("ошибка 4.5");
        }

    }

}
