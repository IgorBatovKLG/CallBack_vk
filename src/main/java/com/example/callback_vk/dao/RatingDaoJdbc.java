package com.example.callback_vk.dao;

import com.example.callback_vk.DBConnection;
import com.example.callback_vk.models.Penis.PenisModel;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class RatingDaoJdbc {

    public void addRating(int user_id, double rating) {
        Connection connection = DBConnection.connection;
        try (PreparedStatement statement = connection.prepareStatement("INSERT INTO rating (id, id_user, rating) VALUES (?, ?, ?)")) {
            statement.setInt(2, user_id);
            statement.setDouble(3, rating);
            statement.executeUpdate();
        } catch (Exception e){
            e.getStackTrace();
        }
    }

    public double getRating(int user_id) {
        Connection connection = DBConnection.connection;
        double rating = 0;
        try (PreparedStatement statement = connection.prepareStatement("SELECT rating FROM rating WHERE id_user = ?")) {
            statement.setInt(1, user_id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                rating = resultSet.getDouble("rating");
            }
        } catch (Exception e){
            e.getStackTrace();
            return 0;
        }
        return rating;
    }

    public List<PenisModel> getAllRaring(){
        Connection connection = DBConnection.connection;
        List<PenisModel> rating= new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM rating order by rating DESC")) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                rating.add(new PenisModel(resultSet.getInt("id_user"),
                        resultSet.getDouble("rating")));
            }
        } catch (Exception e){
            e.getStackTrace();
            return rating;
        }
        return rating;
    }
}
