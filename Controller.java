/*
 * Copyright (c) Voloshin Denis
 */

package Calc;


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBoxBuilder;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

//Перечисляем построенное в Scene Buildere
public class Controller {
    @FXML
    private MenuItem close;

    @FXML
    private TextArea viewResultArea;

    @FXML
    private Button ZERO;

    @FXML
    private Button SEVEN;

    @FXML
    private Button FOUR;

    @FXML
    private Button ONE;

    @FXML
    private Button EIGHT;

    @FXML
    private Button FIVE;

    @FXML
    private Button TWO;

    @FXML
    private Button DOT;

    @FXML
    private Button NINE;

    @FXML
    private Button plus;

    @FXML
    private Button SIX;

    @FXML
    private Button subtraction;

    @FXML
    private Button THREE;

    @FXML
    private Button multiplyer;

    @FXML
    private Button calculator;

    @FXML
    private Button divider;

    //Menu-Close. Для джентельменов
    @FXML
    void closeProgram(ActionEvent event) {
        Platform.exit();
        System.exit(0);
    }

    //Переменные для арифметических операций

    @FXML
    private static String bufer = "";
    @FXML
    private double a = 0d;
    @FXML
    private double b = 0d;
    @FXML
    private double result = 0d;
    @FXML
    private char action = '0';

    //Эвенты нажатия на кнопки
    //Записываем значения в строку пока не будет ввден арифметический оператор
    //Обновляем введенное в поле вывода

    @FXML
    void getZERO(ActionEvent event) {
        bufer += "0";
        viewResultArea.setPromptText(bufer);
    }

    @FXML
    void getONE(ActionEvent event) {
        bufer += "1";
        viewResultArea.setPromptText(bufer);
    }

    @FXML
    void getTWO(ActionEvent event) {
        bufer += "2";
        viewResultArea.setPromptText(bufer);
    }

    @FXML
    void getTHREE(ActionEvent event) {
        bufer += "3";
        viewResultArea.setPromptText(bufer);
    }

    @FXML
    void getFOUR(ActionEvent event) {
        bufer += "4";
        viewResultArea.setPromptText(bufer);
    }

    @FXML
    void getFIVE(ActionEvent event) {
        bufer += "5";
        viewResultArea.setPromptText(bufer);
    }

    @FXML
    void getSIX(ActionEvent event) {
        bufer += "6";
        viewResultArea.setPromptText(bufer);
    }

    @FXML
    void getSEVEN(ActionEvent event) {
        bufer += "7";
        viewResultArea.setPromptText(bufer);
    }

    @FXML
    void getEIGHT(ActionEvent event) {
        bufer += "8";
        viewResultArea.setPromptText(bufer);
    }

    @FXML
    void getNINE(ActionEvent event) {
        bufer += "9";
        viewResultArea.setPromptText(bufer);
    }

    @FXML
    void getDOT(ActionEvent event) {
        bufer += '.';
        viewResultArea.setPromptText(bufer);
    }

    //Кнопка вычисления на 4 кейсах

    @FXML
    void calculate(ActionEvent event) {
        b = Double.parseDouble(bufer);
        switch (action) {
            case '+': {
                result = a + b;
                bufer = "";
                viewResultArea.setPromptText(String.valueOf(result));
            }
            break;
            case '-': {
                result = a - b;
                bufer = "";
                viewResultArea.setPromptText(String.valueOf(result));
            }
            break;
            case '*': {
                result = a * b;
                bufer = "";
                viewResultArea.setPromptText(String.valueOf(result));
            }
            break;
            //Этот работает не так, как задумывалось, но работает. Почему - без понятия.
            case '/': {
                try {
                    result = a / b;
                    bufer = "";
                    viewResultArea.setPromptText(String.valueOf(result));
                } catch (ArithmeticException e) {
                    viewResultArea.setPromptText("Попытка деления на 0");
                }
            }
        }

    }

    //Эвенты для ловли конца числа и определения кейса.
    @FXML
    void deduct(ActionEvent event) {
        a = Double.parseDouble(bufer);
        action = '-';
        bufer = "";
    }

    @FXML
    void divide(ActionEvent event) {
        a = Double.parseDouble(bufer);
        action = '/';
        bufer = "";
    }

    @FXML
    void multiply(ActionEvent event) {
        a = Double.parseDouble(bufer);
        action = '*';
        bufer = "";
    }

    @FXML
    void summ(ActionEvent event) {
        a = Double.parseDouble(bufer);
        action = '+';
        bufer = "";
    }

    //Этот кусок был взят из гугла по ссылке на java-buddy.blogspot.ru
    //Внедрен для общего понимания создания всплывающих окон и указания авторства.

    public void showAbout(ActionEvent actionEvent) {
        final Stage popup = new Stage();
        popup.setWidth(300);
        popup.setHeight(200);
        popup.initModality(Modality.NONE);
        popup.setTitle("About");
        Button okButt = new Button("OK");
        okButt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                popup.close();
            }
        });

        Scene about = new Scene(VBoxBuilder.create()
                .children(new Text("Мой первый калькулятор на JavaFX\n Волошин Денис,\n при помощи гугла и какой-то матери." ), okButt)
                .alignment(Pos.CENTER)
                .padding(new Insets(10,10,10,10))
                .build());
        popup.setScene(about);
        popup.show();
    }
}
