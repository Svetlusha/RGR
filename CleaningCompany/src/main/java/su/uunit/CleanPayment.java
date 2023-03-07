package su.uunit;

//импортируем библиотеки
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.embed.swing.SwingFXUtils;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Objects;
import java.util.function.UnaryOperator;
import java.awt.image.BufferedImage;

/**
* Класс, отвечающий за отрисовку графического интерфейса главного окна
* 
*/
public class CleanPayment extends Application {
	//Поля константы нужны для соблюдения одного шрифта и стиля на всех окнах.
    /** поле задает размер шрифта */
    private static final Font NORMAL_FONT = new Font(14);
    
    /** поле задает ширину шрифта */
    private static final double NORMAL_WIDTH = 160; 
    
    /** поле задает меж.символьное растояние шрифта */
    private static final double NORMAL_SPACING = 10; 
    
    /**  Поле-константа для строк выпадающего списка. */
    private static final String[] monthActions = {"нет дополнений","есть сетка","есть решётка","есть сетка и решётка"};//массив строк 

    //Приватные поля.
    /**  Кол-во окон */
    private TextField okonTextField;
    
    /** Высота  */
    private TextField visotaTextField;
    
    /** Ширина */
    private TextField shirinaTextField;
    
    /** Дополненительная плата */
    private TextField dopolnenieTextField;
    
    /** Дополнение(решетка, сетка) */
    private ChoiceBox<String> dopolnenieChoiceBox;
    
    /** Конечная стоимость */
    private Label stoimostResLabel;
    
    /** Площадь 1 окна */
    private Label areaResLabel;
    
    /** Стоимость чистки 1 окна */
    private Label oknoResLabel;

    /**
     * Метод запускает программу.
     */
    public void launcher(){
        Application.launch();//метод launch запускает отдельное приложение
    }
 
    /**
     * Метод служит для запуска графического окна.

     */
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Калькулятор клининговых услуг");//Название окна программы
        primaryStage.setWidth(400);//Ширина окна

        //HBox с кнопками 
        Button infoButton = new Button("О разработчиках"); //Создаем объект кнопки типа Button 
        Button generationPdf = new Button("Генерация PDF");
        HBox infoButtonsBox = new HBox(generationPdf, infoButton);// добавляем в Hbox 2 кнопки
        infoButtonsBox.setPadding(new Insets(5,0,10,0));// добавяем отступы для данного Hbox
        infoButtonsBox.setSpacing(20);// добавляем пробелы между кнопками 
        infoButtonsBox.setAlignment(Pos.CENTER);// центрируем Hbox по середине окна 

        //Добавляем тектовое поле класса Label с полем для ввода текста класса TextField
        Label okonLabel = new Label("Количество окон");// создаем текстовое поле 
        okonLabel.setPrefWidth(NORMAL_WIDTH);// применяем ширину шрифта как ширину поля
        okonLabel.setFont(NORMAL_FONT);// применяем размер шрифта для текста 
        okonTextField = new TextField();// создаем поле для ввода данных 
        onlyNumberTextField(okonTextField);// вызвываем метод onlyNumberTextField позволяющий вводить в окно только цифры
        okonLabel.setTextAlignment(TextAlignment.RIGHT);// выровнять текст по правой стороне окна 
        okonTextField.setPrefColumnCount(10);// ширина бокса для ввода данных 
        HBox okonBox = new HBox(okonLabel, okonTextField);//добавляем в Hbox Label и поле ввода TextField
        okonBox.setSpacing(NORMAL_SPACING);// автоматические пробелы между элементами 

        Label visotaLabel = new Label("Высота окон");// создаем текстовое поле 
        visotaLabel.setPrefWidth(NORMAL_WIDTH);// применяем ширину шрифта как ширину поля
        visotaLabel.setFont(NORMAL_FONT);// применяем размер шрифта для текста
        visotaTextField = new TextField();// создаем поле для ввода данных 
        onlyNumberWithPointTextField(visotaTextField);// вызвываем метод onlyNumberTextField позволяющий вводить в окно только цифры
        visotaTextField.setPrefColumnCount(10);// ширина бокса для ввода данных 
        visotaTextField.setPromptText("метры");// комментаий для поля ввода 
        HBox visotaBox = new HBox(visotaLabel, visotaTextField);//добавляем в Hbox Label и поле ввода TextField
        visotaBox.setSpacing(NORMAL_SPACING);// автоматические пробелы между элементами

        Label shirinaLabel = new Label("Ширина окон");// создаем текстовое поле 
        shirinaLabel.setPrefWidth(NORMAL_WIDTH);//применяем ширину шрифта как ширину поля
        shirinaLabel.setFont(NORMAL_FONT);// применяем размер шрифта для текста
        shirinaTextField = new TextField();// создаем поле для ввода данных 
        onlyNumberWithPointTextField(shirinaTextField);// вызвываем метод onlyNumberTextField позволяющий вводить в окно только цифры
        shirinaTextField.setPrefColumnCount(10);// ширина бокса для ввода данных 
        shirinaTextField.setPromptText("метры");// комментаий для поля ввода 
        HBox shirinaBox = new HBox(shirinaLabel, shirinaTextField); //добавляем в Hbox Label и поле ввода TextField
        shirinaBox.setSpacing(NORMAL_SPACING);// автоматические пробелы между элементами

        Label dopolnenieLabel = new Label("Дополнения");// создаем текстовое поле 
        dopolnenieLabel.setPrefWidth(100);//выстовляем ширину поля
        dopolnenieLabel.setFont(NORMAL_FONT);// применяем размер шрифта для текста
        dopolnenieChoiceBox = new ChoiceBox<>(FXCollections.observableArrayList(monthActions));
        dopolnenieChoiceBox.setValue(monthActions[0]);// выбираем начальное положение пункта в списке
        HBox dopolnenieActionBox = new HBox(dopolnenieLabel, dopolnenieChoiceBox); //Создаем и добавляем в Hbox выше указанные объекты 
        dopolnenieActionBox.setSpacing(NORMAL_SPACING);// автоматические пробелы между элементами

        Label resultsLabel = new Label("Результаты расчета: ");// создаем текстовое поле 
        HBox resultsBox = new HBox(resultsLabel);//добавляем в Hbox выше указанные объекты
        resultsBox.setPadding(new Insets(10,0,0,0));// добавляем отступы для Hbox
        resultsBox.setAlignment(Pos.CENTER);// центрируем Hbox по середине окна

        stoimostResLabel = new Label("Стоимость услуги: ");// создаем текстовое поле 
        areaResLabel = new Label("Площадь всех окон: ");
        oknoResLabel = new Label("Стоимость за 1 окно: ");
        VBox resultsLabelsBox = new VBox(stoimostResLabel,areaResLabel,oknoResLabel);//создаем Vbox и и добавляем в него выше указанные объекты 
        resultsLabelsBox.setSpacing(10);//выставляем пробелы между элементами Vbox
        resultsLabelsBox.setPadding(new Insets(0,0,10,0));// добавляем отступы для Vbox
        resultsLabelsBox.setAlignment(Pos.TOP_LEFT);// центрируем Vbox слева окна

        Button calculateButton = new Button("Расчитать"); //Создаем объект кнопки типа Button
        Button resetButton = new Button("Сбросить");
        Button exitButton = new Button("Выход");
        HBox buttonsBox = new HBox(calculateButton, resetButton, exitButton); //добавляем в Hbox выше указанные объекты
        buttonsBox.setSpacing(30);//выставляем пробелы между элементами Hbox
        buttonsBox.setPadding(new Insets(10,0,0,0));// добавляем отступы для Hbox
        buttonsBox.setAlignment(Pos.CENTER);// центрируем Hbox по середине окна

        //активации кнопкок, при нажатии будет запущена лямда выражение
        infoButton.setOnAction((e) -> { //создание нового окна 
            primaryStage.close();// закрыть главное окно 
            InfoDevelopers primaryStageNew = new InfoDevelopers();
            primaryStageNew.developerShow();//метод для отображения окна InfoDevelopers
            primaryStageNew.show();//показать окно, установив для видимости значение true
        });

        calculateButton.setOnAction(e -> buttonCalc());//кнопка активации метода buttonCalc()

        generationPdf.setOnAction(e -> buttonGenerPDF());//кнопка активации метода buttonGenerPDF()

        resetButton.setOnAction(e -> resetCalc());//кнопка активации метода buttonGenerPDF()

        exitButton.setOnAction(e -> System.exit(0));
        
        //Создаем VBox помещяя в него высе вышеуказанные Box-ы
        VBox vBox = new VBox(okonBox, visotaBox, shirinaBox, dopolnenieActionBox,buttonsBox, resultsBox,resultsLabelsBox, infoButtonsBox);
        vBox.setSpacing(10);//выставляем пробелы между элементами Vbox
        vBox.setPadding(new Insets(10, 20, 10, 20));// добавляем отступы для Vbox

        Scene sc = new Scene(vBox);// данный класс является контейнером для всего содержимого сцены

        primaryStage.setResizable(true);//возможность менять размер окна 
        primaryStage.setScene(sc);//указываем сцену которая будет сейчас запущена 
        primaryStage.show();//показать окно, установив для видимости значение true
    }

    /**
     * Этот метод который будет запущен при нажатии кнопки "Рассчитать". Метод берет данные с полей ввода и отправяет их в класс Calc
     * 
     */
    private void buttonCalc(){
        try {
            NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(); //Возвращает формат валюты
            currencyFormat.setMaximumFractionDigits(2);//оставляет две цифры после запятой
            int okon = Integer.parseInt(okonTextField.getText());
            double visota = Double.parseDouble(visotaTextField.getText());
            double shirina = Double.parseDouble(shirinaTextField.getText());
            
            int dopolnenieRUB = 0;
            //Определяем доп. плату
            if (dopolnenieChoiceBox.getValue().equals(monthActions[1])) {
                dopolnenieRUB = 400;
            }
            else if (dopolnenieChoiceBox.getValue().equals(monthActions[2])) {
                dopolnenieRUB = 800;
            }
            else if (dopolnenieChoiceBox.getValue().equals(monthActions[3])) {
                dopolnenieRUB = 1000;
            }
            OknoData dto = new OknoData(okon,visota,shirina,dopolnenieRUB);
            Calc call = new Calc(dto);
            call.ras();
            stoimostResLabel.setText("Стоимость услуги: "+ currencyFormat.format(call.getStoimost()));
            areaResLabel.setText("Площадь 1 окна: "+ call.getArea());  
            oknoResLabel.setText("Стоимость за 1 окно: " +  currencyFormat.format(call.getOkno()));
        }catch(NumberFormatException ignored){}//если какое-либо окажется пустым, программа ничего не сделает 
    }

    /**
     * Этот метод который будет запущен при нажатии кнопки "Генерация PDF". Метод берет данные с полей ввода
     */
    private void buttonGenerPDF(){
        try {
        	int okon = Integer.parseInt(okonTextField.getText());
            double visota = Double.parseDouble(visotaTextField.getText());
            double shirina = Double.parseDouble(shirinaTextField.getText());
            int dopolnenieRUB = 0;

            if (dopolnenieChoiceBox.getValue().equals(monthActions[1])) {
                dopolnenieRUB = 400;
            }
            else if (dopolnenieChoiceBox.getValue().equals(monthActions[2])) {
                dopolnenieRUB = 800;
            }
            else if (dopolnenieChoiceBox.getValue().equals(monthActions[3])) {
                dopolnenieRUB = 1000;
            }
            
            OknoData data = new OknoData(okon,visota,shirina,dopolnenieRUB);
            Calc call = new Calc(data);
            call.generationPdf();
        }catch(NumberFormatException ignored){}
    }
    
    /**
     *  Этот метод который будет запущен при нажатии кнопки "Сброс". Метод очищает поля ввода и лейблы 
     */
    public void resetCalc(){
        okonTextField.setText("");
        shirinaTextField.setText("");
        visotaTextField.setText("");
        dopolnenieTextField.setText("");
        stoimostResLabel.setText("Стоимость услуги: ");
        areaResLabel.setText("Площадь 1 окна: ");
        oknoResLabel.setText("Стоимость за 1 окно: ");
    }


    /**
     * Этот метод проверяет поля ввода на то, чтобы там были только числа
     */
    public static void onlyNumberTextField(TextField tf){
        if (tf==null) return;
        UnaryOperator<TextFormatter.Change> integerFilter = change -> {
            String newText = change.getControlNewText();
            if (newText.matches("([1-9][0-9]*)?")) {
                return change;
            }
            return null;
        };
        tf.setTextFormatter(new TextFormatter<>(new IntegerStringConverter(), null, integerFilter));
    }

    /**
     * Этот метод проверяет поля ввода на то, чтобы там были только числа и точку
     *
     */
    private static void onlyNumberWithPointTextField(TextField tf){
        if (tf==null) return;
        UnaryOperator<TextFormatter.Change> integerFilter = change -> {
            String newText = change.getControlNewText();
            if (newText.matches("([1-9][0-9]*)?")) {
                return change;
            }
            return null;
        };
        tf.setTextFormatter(new TextFormatter<>(new IntegerStringConverter(), null, integerFilter));
    }
}
