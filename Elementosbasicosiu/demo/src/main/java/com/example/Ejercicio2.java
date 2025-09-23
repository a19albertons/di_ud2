package com.example;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Ejercicio2 {
    public static void main(String[] args) {
        JFrame ventana = new JFrame("ejercicio 2");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(400, 400);
        ventana.setLayout(new FlowLayout());
        JButton aceptar = new JButton("aceptar");
        aceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(ventana,"aceptar");
            }
        });
        JButton cancelar = new JButton("cancelar");
        cancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(ventana,"cancelar");
            }
        });
        ventana.add(aceptar);
        ventana.add(cancelar);




        ventana.setVisible(true);
    }
}
