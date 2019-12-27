package com.company.operations;

import com.company.consts.Const;
import com.company.dao.ConnectionDb;
import com.company.model.Cat;

import java.sql.*;

public class DataOutput {


    public static void dataOutput(){
        Cat catClass = new Cat();ResultSet rs;
        try(Statement st = ConnectionDb.getDbConnection().createStatement();) {


            String Select = "SELECT *FROM " + Const.USER_TABLE;

            rs = st.executeQuery(Select);

            while (rs.next()) {
                int id = rs.getInt("id");
                String name_cat = rs.getString("name_cat");
                int iddad = rs.getInt("id_dad");
                int idmam = rs.getInt("id_mam");
                String Gender = rs.getString("gender");

                catClass.setIdCat(id);
                catClass.setNameCat(name_cat);
                catClass.setIdMam(iddad);
                catClass.setIdDad(idmam);
               catClass.setGender(Gender);
               System.out.println(catClass.toString());
            }
        } catch (Exception e) {
        }

    }
}


