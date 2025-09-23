package com.example;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Ejercicio5 {
    public static void main(String[] args) {
        JFrame ventana = new JFrame("ejercicio 5");
        ventana.setSize(400, 400);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLayout(new FlowLayout());


        JButton pedirEdad = new JButton("Pulsar");
        pedirEdad.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String texto = JOptionPane.showInputDialog(pedirEdad, "Introduce una edad", null, 0);
                JOptionPane.showMessageDialog(pedirEdad, "Has ingresado "+texto+" años");
            }
            
        });




        ventana.add(pedirEdad);

        ventana.setVisible(true);
    }
}
