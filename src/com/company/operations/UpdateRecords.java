package com.company.operations;
import com.company.consts.Const;
import com.company.dao.ConnectionDb;
import com.company.model.Cat;

import java.sql.*;
public class UpdateRecords  {

    public static void updataCats(Cat cat) {
        ConnectionDb connDb = new ConnectionDb();
   try(Statement st=connDb.getDbConnection().createStatement();){


      String updata = "UPDATE "+ Const.USER_TABLE+" set name_cat='"+cat.getNameCat()+"',id_dad='"+cat.getIdDad()+"',id_mam='"+cat.getIdMam()+"',gender='"+cat.getGender()+"' WHERE id="+cat.getIdCat();
        st.executeUpdate(updata);

        System.out.println("///////////////////////////////////\n");
       }catch (Exception e){ System.out.println("ошибка 6(внутрянняя)");} System.out.println("Запись изменена\n");
        }

}
