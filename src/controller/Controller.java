package controller;

import access.userDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import model.usersModel;
import org.apache.commons.validator.routines.EmailValidator;

import javax.swing.*;
import java.util.Arrays;


public class Controller {

    private final usersModel user = new usersModel();

    private Label welcomeText;


    private Button addButton;

    @FXML
    private Button loginButton;

    @FXML
    private TextField txtUser, txtPassword, txtEmail;

    @FXML
    private void addButtonClick(ActionEvent event) throws InterruptedException {
        String username = this.txtUser.getText();
        String password = this.txtPassword.getText();
        String email = this.txtEmail.getText();
        EmailValidator emailValidator = EmailValidator.getInstance();


//        String capability = this.controlsPanel.getTxtCapability().getText();
//        float difficulty = Float.parseFloat(this.controlsPanel.getTxtDifficulty().getText());

        if (username.equals("")) {
            username = null;
        }
        if (password.equals("")) {
            password = null;
        }
        if (email.equals("")) {
            email = null;
        }

        if (emailValidator.isValid(email)) {
            usersModel user = new usersModel(username, password, email);
//
//        //System.out.println(idMuseum + " " + idPresentation + " " + datePresentation + " " + artPieceName);
            userDAO UserDAO = new userDAO();

            UserDAO.addUser(user);

        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Email Inválido");
            alert.show();
//            JOptionPane.showMessageDialog(null, "Email Inválido");
        }

    }

//    @FXML
//    protected void onHelloButtonClick() {
//        welcomeText.setText("Welcome to JavaFX Application!");
//    }

    public void onAddButtonClicked(MouseEvent mouseEvent) {
//        String name = this.controlsPanel.getTxtName().getText();
//        int capacity = Integer.parseInt((this.controlsPanel.getTxtCapacity().getText()));
//        String capability = this.controlsPanel.getTxtCapability().getText();
//        float difficulty = Float.parseFloat(this.controlsPanel.getTxtDifficulty().getText());
//
//        carrerasModel carrera = new carrerasModel(name, capacity, capability, difficulty);
//
//        //System.out.println(idMuseum + " " + idPresentation + " " + datePresentation + " " + artPieceName);
//        carrerasDAO CarrerasDAO = new carrerasDAO();
//        CarrerasDAO.addCarrera(carrera);
//
//        InitialData initialData = new InitialData();
//        this.controlsPanel.setTblResults(initialData.getCarreras());
    }

    public void onLoginButtonClicked(MouseEvent mouseEvent) {
        String username = this.txtUser.getText();
        String password = this.txtPassword.getText();

        usersModel user = new usersModel(username, password);
        userDAO UserDAO = new userDAO();

        try {
            UserDAO.loginUser(user);

//            Alert alert = new Alert(Alert.AlertType.INFORMATION);
//            alert.setHeaderText(null);
//            alert.setTitle("Información");
//            alert.setContentText("Usuario Correcto, Bienvenido" + " " + username);
//            alert.showAndWait();
//             JOptionPane.showMessageDialog(null, "Email Inválido");
        }
        catch (Exception io){
            System.out.println(io.getMessage());
        }

    }

}