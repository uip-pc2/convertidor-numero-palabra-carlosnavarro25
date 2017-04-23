package sample;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class FXMLDocumentController implements Initializable {


    @FXML
    private TextField tf;
    @FXML
    private TextArea rtf;

    @FXML
    private void handleButtonAction1(ActionEvent event) {
        int numero = Integer.valueOf(tf.getText());
        NumberToLetters ntl = new NumberToLetters(numero);
        rtf.setText(ntl.obtenerLetras());
    }

    @FXML
    private void handleButtonAction2(ActionEvent event) {
        rtf.setText("");
        tf.setText("");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
