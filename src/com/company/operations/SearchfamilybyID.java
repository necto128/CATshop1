package com.company.operations;

import com.company.consts.Const;
import com.company.dao.ConnectionDb;
import com.company.model.Cat;

import java.sql.*;

public class SearchfamilybyID {

    Connection dbConnection;
    private static ResultSet rs;
    private static Statement st;


    public static void SearchfamilyBYID(int iD, Cat cat) throws SQLException, ClassNotFoundException {

        st = ConnectionDb.getDbConnection().createStatement();
        String Select = "SELECT *FROM " + Const.USER_TABLE + " WHERE id=" + iD;
        try {

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
            System.out.println("ошибка 4");st.close();
        }
    }


    public static void SearchParents(int iD, Cat cat) throws SQLException, ClassNotFoundException {
        String Select = "SELECT *FROM " + Const.USER_TABLE + " WHERE id=" + iD;
        try {
        st = ConnectionDb.getDbConnection().createStatement();
            rs = st.executeQuery(Select);

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
          System.out.println("ошибка 4.5");st.close();
        }finally {st.close();}

    }

}
