package access;

import java.util.ArrayList;

import javafx.scene.control.Alert;
import model.usersModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import utils.ConnectionDB;
import java.sql.ResultSet;
import javax.swing.JOptionPane;


public class userDAO {

    //CONEXION A LA BASE DE DATOS

    private Connection conn = null;

//    public ArrayList<carrerasModel> getAllCarreras(){
//        ArrayList<carrerasModel> carreras = new ArrayList();
//
//        try{
//            if(conn == null)
//                conn = ConnectionDB.getConnection();
//
//            String sql = "SELECT name, capacity, capability, difficulty FROM carreras";
//            Statement statament = conn.createStatement();
//            ResultSet result = statament.executeQuery(sql);  //error statement
//            while(result.next()){
//                carrerasModel carrera = new carrerasModel(result.getString(1),result.getInt(2), result.getString(3), result.getFloat(4));
//                carreras.add(carrera);
//            }
//        }
//        catch(SQLException ex){
//            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
//                    + "\nError :" + ex.getMessage());
//        }
//        return carreras;
//    }

//    public ArrayList<carrerasModel> searchCarreras(String name){
//        ArrayList<carrerasModel> carreras = new ArrayList();
//
//        try{
//            if(conn == null)
//                conn = ConnectionDB.getConnection();
//
//            String sql = "SELECT name, capacity, capability, difficulty FROM carreras where UPPER(name) LIKE ?;";
//            PreparedStatement statement = conn.prepareStatement(sql);
//            statement.setString(1, "%" + name.toUpperCase() + "%");
//            ResultSet result = statement.executeQuery();
//            while(result.next()){
//                carrerasModel carrera = new carrerasModel(result.getString(1),result.getInt(2), result.getString(3), result.getFloat(4));
//                carreras.add(carrera);
//            }
//        }
//        catch(SQLException ex){
//            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
//                    + "\nError :" + ex.getMessage());
//        }
//        return carreras;
//    }

    public void addUser(usersModel user){
        try{
            if (conn == null)
                conn = ConnectionDB.getConnection();

            if (user.getUsername() != null && user.getPassword() != null && user.getEmail() != null) {

                String sql = "INSERT INTO user(username, password, email)"
                        + "VALUES(?, ?, ?);";

                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setString(1, user.getUsername());
                statement.setString(2, user.getPassword());
                statement.setString(3, user.getEmail());
                int rowsInserted = statement.executeUpdate();

                if (rowsInserted > 0) {
//                JOptionPane.showMessageDialog(null, "Usuario Creado");
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setTitle("Información");
                    alert.setContentText("Usuario Creado Exitosamente");
                    alert.showAndWait();
//                System.out.println("Se inserto");
                } else {
                    System.out.println("No funciono");
                    conn.close();
                }
            }
            else {
                System.out.println("error");
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setTitle("Información");
                alert.setContentText("N/A");
                alert.showAndWait();
            }
        }
        catch(SQLException ex) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Código: " + ex.getErrorCode()
                    + "\nError: " + ex.getMessage());
            alert.showAndWait();

//            String sql = "SET @num:=0;" +
//                    "UPDATE user SET id = @num:=(@num + 1);" +
//                    "ALTER TABLE user AUTO_INCREMENT = 1;";
//
//            try {
//                conn.prepareStatement(sql);
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//            statement.setString(1, user.getUsername());
//            statement.setString(2, user.getPassword());
//            statement.setString(3, user.getEmail());
//            int rowsInserted = statement.executeUpdate();

//            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode()
//                    + "\nError :" + ex.getMessage());

//            ex.printStackTrace();
        }
    }

//    public void updateCarrera(carrerasModel carrera){
//
//        try {
//            if(conn == null)
//                conn = ConnectionDB.getConnection();
//            String sql = "UPDATE carreras SET capacity = ?, capability = ?, difficulty = ? WHERE name = ? ;";
//            PreparedStatement statement = conn.prepareStatement(sql);
//            statement.setInt(1, carrera.getCapacity());
//            statement.setString(2, carrera.getCapability());
//            statement.setFloat(3, carrera.getDifficulty());
//            statement.setString(4, carrera.getName());
//
//            int rowsUpdated = statement.executeUpdate();
//            if (rowsUpdated > 0)
//                JOptionPane.showMessageDialog(null, "El registro fue actualizado exitosamente !");
//        }
//
//        catch(SQLException ex){
//            JOptionPane.showMessageDialog(null, "Carrera : " + ex.getErrorCode()
//                    + "\nError :" + ex.getMessage());
//        }
//    }

//    public void deleteCarrera(carrerasModel name){
//        System.out.println("entre");
//        try {
//            if(conn == null)
//                conn = ConnectionDB.getConnection();
//            String sql = "DELETE FROM carreras WHERE name=?;";
//            PreparedStatement statement = conn.prepareStatement(sql);
//            statement.setString(1, name.getName());
//            int rowsDeleted = statement.executeUpdate();
//            if (rowsDeleted > 0) {
//                JOptionPane.showMessageDialog(null, "El registro fue borrado exitosamente !");
//            }
//        }
//        catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Código : "
//                    + ex.getErrorCode() + "\nError :" + ex.getMessage());
//        }
//
//    }

}

