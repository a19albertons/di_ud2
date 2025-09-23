package com.example;

import javax.swing.*;
import java.awt.*;

public class base {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame ventana = new JFrame("Selector de Ejercicios");
            ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            ventana.setSize(420, 140);
            ventana.setLayout(new FlowLayout());

            String[] items = {"Ejercicio 1", "Ejercicio 2", "Ejercicio 3", "Ejercicio 4", "Ejercicio 5", "Ejercicio 6", "Ejercicio 7", "Ejercicio 8", "Ejercicio 9", "Ejercicio 10"};
            JComboBox<String> selector = new JComboBox<>(items);
            JButton ejecutar = new JButton("Ejecutar");

            ejecutar.addActionListener(e -> {
                String sel = (String) selector.getSelectedItem();
                String className = "com.example." + sel.replace(" ", "");

                // Ejecutar el main de la clase seleccionada en un hilo aparte para no bloquear el EDT
                new Thread(() -> {
                    try {
                        Class<?> cls = Class.forName(className);
                        java.lang.reflect.Method m = cls.getMethod("main", String[].class);
                        m.invoke(null, (Object) new String[] {});
                    } catch (Exception ex) {
                        SwingUtilities.invokeLater(() -> JOptionPane.showMessageDialog(ventana, "Error al ejecutar " + className + ": " + ex.getMessage()));
                    }
                }).start();
            });

            ventana.add(new JLabel("Selecciona un ejercicio:"));
            ventana.add(selector);
            ventana.add(ejecutar);

            ventana.setLocationRelativeTo(null);
            ventana.setVisible(true);
        });
    }
}
