package su.uunit;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.awt.image.BufferedImage;
import java.util.Objects;

/**
 * Класс, отвечающий за отрисовку графического интерфейса окна с информацией о разработчиках
 */
public class InfoDevelopers extends Stage {//Под класс InfoDevelopers наследует супер класс Stage

  /**
   * Данный метод служит для запуска графического окна с информацией о разработчиках.
   */
  public void developerShow() {
		setTitle("Информация о разработчиках:");
	    setWidth(300);

	    Label moder = new Label("Модератор - Шаяхметова С.Д.");
	    Label razrab1Label = new Label("Разработчик 1 - Шакирзянов А.Д.");
	    Label razrab2Label = new Label("Разработчик 2 - Романова Д.И.");
	    Label razrab3Label = new Label("Разработчик 3 - Сабирьянова Э.Р.");
	    VBox infoBox = new VBox(moder,razrab1Label,razrab2Label,razrab3Label);
	    infoBox.setPadding(new Insets(10, 0, 10, 0));//отступы 
	    infoBox.setAlignment(Pos.TOP_LEFT);
	    infoBox.setSpacing(20);
	
	    Button exitButton = new Button("Назад");
	    HBox exitButtonsBox = new HBox(exitButton);
	    exitButtonsBox.setPadding(new Insets(10, 0, 0, 0));
	    exitButtonsBox.setAlignment(Pos.CENTER);
	
	    VBox vBox2 = new VBox(infoBox, exitButtonsBox);
	    vBox2.setSpacing(10);
	    vBox2.setPadding(new Insets(10, 20, 10, 20));
	
	    Scene sc = new Scene(vBox2);// данный класс является контейнером для всего содержимого сцены
	    setResizable(true);
	    setScene(sc);//указываем сцену которая будет сейчас запущена 
	    show();
	
	    exitButton.setOnAction(e -> {
	      close();//закрытие окна
	      Stage primaryStageNew = new Stage();
	      CleanPayment mainShow = new CleanPayment();
	      mainShow.start(primaryStageNew);
	    });
  }
}

