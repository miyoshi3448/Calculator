package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class CalculatorController {
    CalculatorSystem system = new CalculatorSystem();
    @FXML Label text_number;
    @FXML Label answer;
    
    @FXML
    protected void click_num(ActionEvent event) {
        Button button = (Button)event.getSource();
        system.addNumber(button.getId());
        text_number.setText(text_number.getText() + button.getId());
    }
    
    @FXML
    protected void click_operator(ActionEvent event) {
        Button button = (Button)event.getSource();
        system.addOperator(button.getId());
        text_number.setText(text_number.getText() + " " + button.getText() + " ");
        
    }
    
    @FXML
    protected void click_equal(ActionEvent event) {
        answer.setText(system.calculator());
        text_number.setText("");
    }
    
    @FXML
    protected void click_ac(ActionEvent event) {
        answer.setText("");
        text_number.setText("");
    }
}
