package com.example;

import java.awt.FlowLayout;

import javax.swing.JComboBox;
import javax.swing.JFrame;

public class Ejercicio6 {
    public static void main(String[] args) {
        JFrame ventana = new JFrame("Ejercicio 6");
        ventana.setSize(400, 400);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLayout(new FlowLayout());
        String[] colores = {"rojo","verde","azul"};
        JComboBox<String> selector = new JComboBox<>(colores);
        selector.addActionListener(e -> {
            System.out.println("Color seleccionado: "+ selector.getSelectedItem());
        });


        ventana.add(selector);
        ventana.setVisible(true);
    }
}
