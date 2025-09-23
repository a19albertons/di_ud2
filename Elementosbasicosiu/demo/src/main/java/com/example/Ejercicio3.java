package com.example;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class Ejercicio3 {
    public static void main(String[] args) {
        JFrame ventana = new JFrame("Ejercicio 3");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(400, 400);
        ventana.setLayout(new FlowLayout());
        JTextArea escribir = new JTextArea(1, 5);
        JButton accion = new JButton("Enviar");
        accion.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(escribir.getText());
            }
            
        });

        ventana.add(escribir);
        ventana.add(accion);





        ventana.setVisible(true);
    }
}
