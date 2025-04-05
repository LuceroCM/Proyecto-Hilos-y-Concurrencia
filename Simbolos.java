/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.maquina;

import java.util.ArrayList;
import java.util.List;

public class Simbolos{
    private final String name;
    private final int value;

    public Simbolos(String name, int value) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del símbolo no puede estar vacío o nulo.");
        }
        if (value < 0) {
            throw new IllegalArgumentException("El valor del símbolo no puede ser negativo.");
        }
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.format("Symbol{name='%s', value=%d}", name, value);
    }
}