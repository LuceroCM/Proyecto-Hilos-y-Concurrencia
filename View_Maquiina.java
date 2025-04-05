/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
//Programa de un traga monedas
//Integrantes: 
//Baizabal acosta Ismael
//Cruz Mendoza Lucero
package com.mycompany.maquina;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

public class View_Maquiina extends JFrame {
    private final JLabel[] reelLabels;
    private final JButton spinButton;
    private final JTextField betField;
    private final JLabel resultLabel;
    
    public View_Maquiina(int numReels) {
        setTitle("Tragamonedas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        // Configura el tamaño y color de fondo de la ventana
        setSize(800, 600);
        getContentPane().setBackground(Color.LIGHT_GRAY);
        
        // Panel para mostrar los carretes
        JPanel reelsPanel = new JPanel(new GridLayout(1, numReels));
        reelsPanel.setBackground(Color.WHITE);
        reelLabels = new JLabel[numReels];
        for (int i = 0; i < numReels; i++) {
            reelLabels[i] = new JLabel("?", SwingConstants.CENTER);
            reelLabels[i].setFont(new Font("Arial", Font.BOLD, 36));
            reelsPanel.add(reelLabels[i]);
        }
        add(reelsPanel, BorderLayout.CENTER);
        
        // Panel de controles
        JPanel controlPanel = new JPanel();
        controlPanel.setBackground(Color.CYAN);
        betField = new JTextField(5);
        spinButton = new JButton("Girar");
        resultLabel = new JLabel("Ingrese su apuesta y gire", SwingConstants.CENTER);
        controlPanel.add(new JLabel("Apuesta: "));
        controlPanel.add(betField);
        controlPanel.add(spinButton);
        
        add(resultLabel, BorderLayout.NORTH);
        add(controlPanel, BorderLayout.SOUTH);
        
        pack();
        setLocationRelativeTo(null);
    }
    
    // Permite asignar una acción al botón "Girar"
    public void setSpinButtonAction(ActionListener actionListener) {
        spinButton.addActionListener(actionListener);
    }
    
    // Retorna la apuesta ingresada por el usuario
    public int getBetAmount() {
        return Integer.parseInt(betField.getText().trim());
    }
    
    // Actualiza la visualización de los carretes con los símbolos obtenidos
    public void updateReels(List<Simbolos> resultados) {
        for (int i = 0; i < resultados.size(); i++) {
            reelLabels[i].setText(resultados.get(i).getName());
        }
    }
    
    // Muestra el pago en la interfaz
    public void displayPayout(int payout) {
        resultLabel.setText(payout > 0 ? "¡Ganaste " + payout + " monedas!" : "No ganaste. ¡Inténtalo de nuevo!");
    }
    
    // Método principal para iniciar la aplicación
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Definir la lista de símbolos (puede ser modificada o cargada de otra fuente)
            List<Simbolos> simbolos = List.of(
                    new Simbolos("* ", 10),
                    new Simbolos("?", 5),
                    new Simbolos("°", 15)
            );
            int numCarretes = 3;
            
            // Inicializa el modelo, la vista y el controlador
            Model_Maquiina model = new Model_Maquiina(simbolos, numCarretes);
            View_Maquiina view = new View_Maquiina(numCarretes);
            new Controller_Maquiina(model, view);
            
            view.setVisible(true);
        });
    }
}
