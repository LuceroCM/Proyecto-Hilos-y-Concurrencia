/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//Programa de un traga monedas
//Integrantes: 
//Baizabal acosta Ismael
//Cruz Mendoza Lucero
package com.mycompany.maquina;

import javax.swing.*;
import java.util.List;

public class Controller_Maquiina {
    private final Model_Maquiina model;
    private final View_Maquiina view;

    public Controller_Maquiina(Model_Maquiina model, View_Maquiina view) {
        this.model = model;
        this.view = view;
        
        // Asigna la acción del botón "Girar" definida en la vista
        view.setSpinButtonAction(e -> handleSpinButton());
    }
    
    // Método que maneja la acción del botón "Girar"
    private void handleSpinButton() {
        try {
            int apuesta = view.getBetAmount();
            if (apuesta <= 0) {
                JOptionPane.showMessageDialog(view, "Ingrese una apuesta válida.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            // Realiza el giro solicitando la acción al modelo
            List<Simbolos> resultados = model.spin();
            
            // Actualiza la vista con los resultados obtenidos
            view.updateReels(resultados);
            
            // Calcula y muestra el pago correspondiente
            int pago = model.calcularPago(apuesta, resultados);
            view.displayPayout(pago);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(view, "Ingrese un número válido para la apuesta.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
