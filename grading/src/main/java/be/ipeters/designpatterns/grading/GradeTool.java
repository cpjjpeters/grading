package be.ipeters.designpatterns.grading;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GradeTool extends Application{

	// STRATEGY DESIGN pattern
	// https://www.youtube.com/watch?v=o5kePFuwfig&list=PLL4s8QTahRc1riPx84f4kohi81jhfGpwY&index=34
	
	private static final ConventionalGrading CONVENTIONAL = new ConventionalGrading();
	private static final TriageGrading TRIAGE = new TriageGrading();
	private static final SpecificationsGrading SPECIFICATIONS = new SpecificationsGrading(0.9f);
	
	private ComboBox<GradingScheme> combo;
	private TextField inputField;
	private TextField outputField;
	
	public static void main(String[] args) {
		launch(args);

	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		initializeWidgets();
		VBox vbox = new VBox();
		vbox.getChildren().addAll(
				new Label("Choose a grading scheme"),
				combo,
				new Label("Enter a grade (%)"),
				inputField,
				new Label("Converted to a letter it is"),
				outputField);
				
		primaryStage.setScene(new Scene(vbox));
		primaryStage.show();
		
	}

	private void initializeWidgets() {
		combo = new ComboBox<>(FXCollections.observableArrayList(CONVENTIONAL, TRIAGE, SPECIFICATIONS));
//		combo = new ComboBox<String>(FXCollections.observableArrayList("Conventional", "Triage","Specifications (90%"));
		combo.getSelectionModel().selectFirst();
		combo.valueProperty().addListener((observable, oldvalue, newvalue)->updateGrade()); 
		inputField = new TextField();
		inputField.textProperty().addListener((observable, oldvalue, newvalue)->updateGrade()); 
		outputField = new TextField();
		outputField.setEditable(false);;
		
	}

	private void updateGrade() {

		try {
			float input = Float.parseFloat(inputField.getText()) / 100f;
			GradingScheme scheme = combo.getSelectionModel().getSelectedItem();
			LetterGrade grade = scheme.convert(input);
			outputField.setText(grade.name());
		} catch (NumberFormatException e) {
			outputField.setText("-");
			e.printStackTrace();
		}
//		switch(combo.getSelectionModel().getSelectedIndex()) {
//		case 0:
//			grade = CONVENTIONAL.convert(input);
//			break;
//		case 1:
//			grade = TRIAGE.convert(input);
//			break;
//		case 2:
//			grade = SPECIFICATIONS.convert(input);
//			break;
//			default:
//				throw new IllegalStateException();
//		}
		
		
		
	}

}
