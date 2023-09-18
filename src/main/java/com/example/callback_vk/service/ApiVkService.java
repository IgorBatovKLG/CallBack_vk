package com.example.callback_vk.service;

import com.example.callback_vk.dao.RandomIdDaoJdbc;
import com.example.callback_vk.models.user_info.Example_user;
import com.google.gson.Gson;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class ApiVkService {

    public void vk(String message) {
        RandomIdDaoJdbc randomIdDaoJdbc = new RandomIdDaoJdbc();
        int random_id = randomIdDaoJdbc.getRandomId();
        randomIdDaoJdbc.updateRandomId(random_id+2);

        String accessToken = "vk1.a.xllEn-z5jugtfoemB9eugacR2y0E7J0R388Z6OpDBn7j7tyww62CsF_GCydkKuky-vmBHZmDahbno7qS0frMKJeIsV1LaxMbTnRGtPMbZXWJ_9EKDEi7FHZJ7qn6yWHBM9mfAFFDVx15-Gk7-0maL6lugPuO4VuW3ynzfDIhwEkns3jHIx5VHl6uOs-fXyamxYxhC7cpCqBRNxiTcIrNNQ"; // Замените на ваш токен доступа
        int peer_ids = 2000000002; // Замените на ID беседы, в которую вы хотите отправить сообщение



        try {
            URL url = new URL("https://api.vk.com/method/messages.send");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);

            String postData = "access_token=" + accessToken +
                    "&peer_ids=" + peer_ids +
                    "&message=" + message +
                    "&random_id=" + random_id +
                    "&v=5.131";

            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = postData.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }



            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                InputStream inputStream = connection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder response = new StringBuilder();
                String line;

                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }

                reader.close();

                // Теперь у вас есть JSON-строка response.toString() с ответом от сервера VK API.
                // Разберите эту JSON-строку, чтобы получить информацию о результате запроса.
                System.out.println(random_id + " Ответ от сервера VK API: " + response.toString());
            } else {
                // Обработка ошибок
                System.out.println("Ошибка при отправке запроса: " + responseCode);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public Example_user getUserInfo(Integer id) {
        Gson gson = new Gson();
        try {


            URL url = new URL("https://api.vk.com/method/users.get");
            String accessToken = "vk1.a.xllEn-z5jugtfoemB9eugacR2y0E7J0R388Z6OpDBn7j7tyww62CsF_GCydkKuky-vmBHZmDahbno7qS0frMKJeIsV1LaxMbTnRGtPMbZXWJ_9EKDEi7FHZJ7qn6yWHBM9mfAFFDVx15-Gk7-0maL6lugPuO4VuW3ynzfDIhwEkns3jHIx5VHl6uOs-fXyamxYxhC7cpCqBRNxiTcIrNNQ"; // Замените на ваш токен доступа
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);

            String postData = "access_token=" + accessToken +
                    "&user_ids=" + id +
                    "&v=5.131";

            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = postData.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }

            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                InputStream inputStream = connection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder response = new StringBuilder();
                String line;

                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }

                reader.close();

                // Теперь у вас есть JSON-строка response.toString() с ответом от сервера VK API.
                // Разберите эту JSON-строку, чтобы получить информацию о результате запроса.

                return gson.fromJson(response.toString(), Example_user.class);

            } else {
                // Обработка ошибок
                System.out.println("Ошибка при отправке запроса: " + responseCode);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
