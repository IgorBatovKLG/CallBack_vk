package com.example.callback_vk.dao;

import com.example.callback_vk.DBConnection;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
@Repository
public class RandomIdDaoJdbc {

    public int getRandomId(){
        Connection connection = DBConnection.connection;
        try (PreparedStatement statement = connection.prepareStatement("select random_id FROM ids where id = 1")) {
            return statement.executeQuery().getInt("random_id");
        } catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    public void updateRandomId(int id){
        Connection connection = DBConnection.connection;
        try (PreparedStatement statement = connection.prepareStatement("update ids set random_id = ? where id = 1")) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

