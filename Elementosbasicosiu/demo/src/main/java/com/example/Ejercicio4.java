package com.example;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class Ejercicio4 {
    public static void main(String[] args) {
        JFrame ventana = new JFrame("ejercicio 4");
        ventana.setSize(400, 400);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLayout(new FlowLayout());
        JLabel nombreEtiqueta = new JLabel("nombre:");
        JTextArea nombre = new JTextArea(1, 5);
        JLabel apellidoEtiqueta = new JLabel("apellido:");
        JTextArea apellido = new JTextArea(1, 5);
        
        JButton accion = new JButton("Enviar");
        accion.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Hola, "+nombre.getText()+" "+apellido.getText());
            }
            
        });

        ventana.add(nombreEtiqueta);
        ventana.add(nombre);
        ventana.add(apellidoEtiqueta);
        ventana.add(apellido);
        ventana.add(accion);


        ventana.setVisible(true);
    }
}
