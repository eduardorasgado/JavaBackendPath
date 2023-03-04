package com.eduardocode.objectorienteddesign.designpatterns.behavioral.mediator.javafxui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/*
	All the classes of this package have to be copied and pasted on a java fx generated project
	in order to run the project as a whole
 */
public class Ui2Demo extends Application {

    public static void main(String[] args) {
		launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        UiMediator mediator = new UiMediator();

		CustomSlider slider = new CustomSlider(mediator);
		TextBox box = new TextBox(mediator);
		CustomLabel label = new CustomLabel(mediator);

		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setVgap(20);
		grid.setPadding(new Insets(25, 25, 25, 25));
		grid.add(label, 0, 0);
		grid.add(slider, 0, 1);
		grid.add(box, 0, 2);

        Scene scene = new Scene(grid, 500, 500);
		primaryStage.setTitle("Mediator Pattern");
		primaryStage.setScene(scene);
		primaryStage.show();
    }
}
