package com.example.callback_vk;

import com.example.callback_vk.dao.RandomIdDaoJdbc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.File;
import java.util.HashMap;

@SpringBootApplication
public class CallBackVkApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(CallBackVkApplication.class, args);
        run.getBean(RandomIdDaoJdbc.class).getRandomId();
        System.out.println("___________________________");
        System.out.println("___________________________");
        System.out.println("___________________________");
        System.out.println("___________________________");
        System.out.println("___________________________");
        String folderPath = "./app/";

        // Создайте объект File для представления этой папки
        File folder = new File(folderPath);

        // Проверьте, существует ли папка
        if (folder.exists() && folder.isDirectory()) {
            // Получите список файлов в папке
            File[] files = folder.listFiles();

            // Выведите имена файлов
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        System.out.println("Имя файла: " + file.getName());
                    }
                }
            }
        } else {
            System.err.println("Указанная папка не существует или не является директорией.");
        }
        System.out.println("___________________________");
        System.out.println("___________________________");
        System.out.println("___________________________");
        System.out.println("___________________________");
        System.out.println("___________________________");
    }

}
