package com.company.operations;

import com.company.consts.Const;
import com.company.dao.ConnectionDb;
import com.company.model.Cat;

import java.sql.*;

public class SearchCats {


    public static void searchCatsByid(int iD) throws SQLException {
        Cat cat = new Cat();ResultSet rs;

        try(Statement st= ConnectionDb.getDbConnection().createStatement();) {
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
        } catch (Exception e) {}



    }


}
