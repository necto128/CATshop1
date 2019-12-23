package com.company.operations;

import com.company.consts.Const;
import com.company.dao.ConnectionDb;
import com.company.model.Cat;

import java.sql.*;


public class AddCats {

    public static void AddRecords(Cat cat) throws SQLException {

        String insert = "INSERT INTO " + Const.USER_TABLE + "(" + Const.NAME_CAT + "," + Const.ID_DAD + "," + Const.ID_MAM + "," + Const.GENDER + ") VALUES(?,?,?,?)";

        try ( PreparedStatement prSt = ConnectionDb.getDbConnection().prepareStatement(insert) ) {
            prSt.setString(1, cat.getNameCat());
            prSt.setInt(2, cat.getIdDad());
            prSt.setInt(3, cat.getIdMam());
            prSt.setString(4, cat.getGender());
            prSt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }


}
