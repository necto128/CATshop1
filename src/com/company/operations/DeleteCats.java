package com.company.operations;

import com.company.consts.Const;
import com.company.dao.ConnectionDb;
import com.company.model.Cat;

import java.sql.*;

public class DeleteCats {

    public static void deleteRecord(Cat cat) {

        try (Statement prSt = ConnectionDb.getDbConnection().createStatement();) {
            String delete = "DELETE FROM " + Const.USER_TABLE + " WHERE id=" +cat.getIdCat();
            prSt.executeUpdate(delete);
            System.out.println("///////////////////////////////////");
            System.out.println("Запись удалена\n");
        } catch (Exception e) {
        }

    }
}
