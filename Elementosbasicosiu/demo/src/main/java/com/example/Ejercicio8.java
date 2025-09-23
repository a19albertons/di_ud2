package com.example;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ejercicio8 {
    public static void main(String[] args) {
        JFrame ventana = new JFrame("Ejercicio 8");
        ventana.setSize(400,400);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLayout(new FlowLayout());
        
        JRadioButton boton1 = new JRadioButton("Tarjeta de Credito");
        JRadioButton boton2 = new JRadioButton("Paypal");
        JRadioButton boton3 = new JRadioButton("Transferencia bancaria");
        boton1.setActionCommand("Tarjeta de Credito");
        boton2.setActionCommand("Paypal");
        boton3.setActionCommand("Transferencia bancaria");
        JButton confirmar = new JButton("Confirmar");
        ButtonGroup grupo = new ButtonGroup();
        grupo.add(boton1);
        grupo.add(boton2);
        grupo.add(boton3);

        confirmar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(grupo.getSelection().getActionCommand());
            }
            
        });

        ventana.add(boton1);
        ventana.add(boton2);
        ventana.add(boton3);
        ventana.add(confirmar);


        ventana.setVisible(true);
    }
}
