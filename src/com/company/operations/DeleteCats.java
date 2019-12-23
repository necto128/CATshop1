package com.company.operations;

import com.company.consts.Const;
import com.company.dao.ConnectionDb;

import java.sql.*;

public class DeleteCats {

    public static void DeleteRecord(int iD) throws SQLException, ClassNotFoundException {

        try (Statement prSt = ConnectionDb.getDbConnection().createStatement();) {
            String delete = "DELETE FROM " + Const.USER_TABLE + " WHERE id=" + iD;
            prSt.executeUpdate(delete);
            System.out.println("///////////////////////////////////");
            System.out.println("Запись удалена\n");
        } catch (Exception e) {
        }

    }
}
