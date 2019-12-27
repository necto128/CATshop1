package com.company.operations;

import com.company.consts.Const;
import com.company.dao.ConnectionDb;
import com.company.model.Cat;

import java.sql.*;

public class SearchCats {
    private static  Statement st;
    private static ResultSet rs;

    ConnectionDb connDb = new ConnectionDb();
    public static void SearchCatsByid(int iD) throws SQLException, ClassNotFoundException {
        Cat cat = new Cat();

        try {
            st = ConnectionDb.getDbConnection().createStatement();
            String Select = "SELECT *FROM " + Const.USER_TABLE + " WHERE id=" + iD;

            rs = st.executeQuery(Select);

            while (rs.next()) {
                int id = rs.getInt("id");
                String name_cat = rs.getString("name_cat");
                int iddad = rs.getInt("id_dad");
                int idmam = rs.getInt("id_mam");
                String Gender = rs.getString("gender");

                cat.setIdCat(id);
                cat.setNameCat(name_cat);
                cat.setIdDad(iddad);
                cat.setIdMam(idmam);
                cat.setGender(Gender);

                System.out.println(cat.toString());
            }
            System.out.println("///////////////////////////////////");
        } catch (Exception e) {st.close();
        } finally {
            st.close();
        }


    }


}
