/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.pmp.fx101;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Button;
import com.pmp.dao.Categoria;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author ERLIN
 */
public class CategoriaController implements Initializable {

    
    @FXML
    private Label lblTitulo;
    @FXML
    private TextField txtId;
    @FXML
    private TextField txtNombre;
    @FXML
    private RadioButton rdbActivo;
    @FXML
    private ToggleGroup grpEstado;
    @FXML
    private RadioButton rdbInactivo;
    @FXML
    private Button btnConfirmar;
    @FXML
    private Button btnCancelar;
    @FXML
    private TextField txtLiderCorreo;
    @FXML
    private TextField txtDuracionMeses;
    @FXML
    private TextField txtArea;
    @FXML
    private TextField txtPais;
    
    private Categoria selectedCategoria;
    private boolean isConfirmed = false;
    private String mode;
    //private TextField txtCategoria;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    public void setCategoria( Categoria catego){
      this.selectedCategoria = catego;
      txtId.setText(String.valueOf(this.selectedCategoria.getId()));
      txtNombre.setText(this.selectedCategoria.getNombre());
      
      if(this.selectedCategoria.getEstado().contentEquals("ACT")) {
        rdbActivo.setSelected(true);
      } else {
        rdbInactivo.setSelected(true);
      }
      txtLiderCorreo.setText(this.selectedCategoria.getLiderCorreo());
      txtDuracionMeses.setText(this.selectedCategoria.getDuracionMeses());
      txtArea.setText(this.selectedCategoria.getArea());
      txtPais.setText(this.selectedCategoria.getPais());
    }
    public void setMode(String mode_select) {
      this.mode = mode_select;
      txtId.setDisable(true);
      switch(this.mode){
        case "DSP":
          lblTitulo.setText("Mostrando detalle de:");
          btnConfirmar.setDisable(true);
          //txtCategoria.setDisable(true);
          txtNombre.setDisable(true);
          txtLiderCorreo.setDisable(true);
          txtDuracionMeses.setDisable(true);
          txtArea.setDisable(true);
          txtPais.setDisable(true);
          rdbActivo.setDisable(true);
          rdbInactivo.setDisable(true);
          break;
        case "DEL":
          lblTitulo.setText("Eliminando:");
          //txtCategoria.setDisable(true);
          txtNombre.setDisable(true);
          txtLiderCorreo.setDisable(true);
          txtDuracionMeses.setDisable(true);
          txtArea.setDisable(true);
          txtPais.setDisable(true);
          rdbActivo.setDisable(true);
          rdbInactivo.setDisable(true);
          break;
        case "UPD":
          lblTitulo.setText("Editando:");
          break;
      }
    }

    @FXML
    private void btnConfirmar_onclicked(ActionEvent event) {
        this.selectedCategoria.setNombre(txtNombre.getText());
        
        
        if (rdbActivo.isSelected()) {
            this.selectedCategoria.setEstado("ACT");
        } else {
            this.selectedCategoria.setEstado("INA");
        }
        this.selectedCategoria.setLiderCorreo(txtLiderCorreo.getText());
        this.selectedCategoria.setDuracionMeses(txtDuracionMeses.getText());
        this.selectedCategoria.setArea(txtArea.getText());
        this.selectedCategoria.setPais(txtPais.getText());
        this.isConfirmed = true;
        App.closeModal(event);
    }

    @FXML
    private void btnCancelar_onclicked(ActionEvent event) {
        App.closeModal(event);
    }

    public boolean getIsConfirmed(){
        return this.isConfirmed;
    }
    
    public Categoria getCategoria() {
        return this.selectedCategoria;
    }
}
