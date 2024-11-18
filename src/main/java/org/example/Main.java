package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.File;
import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


public class Main {
    public static void main(String[] args) throws IOException {
        File keys = new File("C:\\Users\\Пользователь_Asus\\IdeaProjects\\Examination\\src\\main\\resources\\keys");
        File answers = new File("C:\\Users\\Пользователь_Asus\\IdeaProjects\\Examination\\src\\main\\resources\\answers");
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ResultsProcessorConfig.class);
        FileReader fileReader = applicationContext.getBean(FileReader.class);

        ResultsProcessor result = applicationContext.getBean(ResultsProcessor.class);
        result.result(keys, answers);

    }
}