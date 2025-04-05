/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//Programa de un traga monedas
//Integrantes: 
//Baizabal acosta Ismael
//Cruz Mendoza Lucero
package com.mycompany.maquina;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Model_Maquiina {
    private final List<List<Simbolos>> carretes;
    private final Random random;

    public Model_Maquiina(List<Simbolos> simbolos, int numCarretes) {
        if (numCarretes <= 0) {
            throw new IllegalArgumentException("El número de carretes debe ser mayor que cero.");
        }
        if (simbolos == null || simbolos.isEmpty()) {
            throw new IllegalArgumentException("La lista de símbolos no puede estar vacía.");
        }
        
        this.carretes = new ArrayList<>();
        this.random = new Random();

        // Cada carrete recibe una copia de la lista de símbolos
        for (int i = 0; i < numCarretes; i++) {
            this.carretes.add(new ArrayList<>(simbolos));
        }
    }
    
    // Simula un giro y retorna una lista de símbolos resultantes
    public List<Simbolos> spin() {
        List<Simbolos> resultados = new ArrayList<>();
        for (List<Simbolos> carrete : carretes) {
            int index = random.nextInt(carrete.size());
            resultados.add(carrete.get(index));
        }
        return resultados;
    }
    
    // Calcula el pago según la apuesta y el resultado del giro.
    public int calcularPago(int apuesta, List<Simbolos> resultados) {
        if (apuesta <= 0) {
            throw new IllegalArgumentException("La apuesta debe ser mayor que cero.");
        }
        if (resultados == null || resultados.isEmpty()) {
            throw new IllegalArgumentException("No hay resultados para calcular el pago.");
        }
        
        String simboloBase = resultados.get(0).getName();
        boolean todosIguales = resultados.stream()
                .allMatch(simbolo -> simbolo.getName().equals(simboloBase));
        
        return todosIguales ? apuesta * resultados.get(0).getValue() : 0;
    }
}
