package com.company.operations;

import com.company.consts.Const;
import com.company.dao.ConnectionDb;
import com.company.model.Cat;

import java.sql.*;

public class DataOutput {
    private static Statement st;
    private static ResultSet rs;

    public static void DataOutput() throws SQLException, ClassNotFoundException {
        Cat catClass = new Cat();
        try {
            st = ConnectionDb.getDbConnection().createStatement();

            String Select = "SELECT *FROM " + Const.USER_TABLE;

            rs = st.executeQuery(Select);

            while (rs.next()) {
                int id = rs.getInt("id");
                String name_cat = rs.getString("name_cat");
                int id_dad = rs.getInt("id_dad");
                int id_mam = rs.getInt("id_mam");
                String Gender = rs.getString("gender");

                catClass.setIdCat(id);
                catClass.setNameCat(name_cat);
                catClass.setIdMam(id_dad);
                catClass.setIdDad(id_mam);
               catClass.setGender(Gender);
               System.out.println(catClass.toString());
            }
        } catch (Exception e) {st.close();
        }
        finally{
            rs.close();
        }
    }
}


