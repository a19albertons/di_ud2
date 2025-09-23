package com.example;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;

public class Ejercicio9 {
    public static void main(String[] args) {
        JFrame ventana = new JFrame("Ejercicio 9");
        ventana.setSize(400, 400);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLayout(new FlowLayout());
        JCheckBox boton1 = new JCheckBox("Queso Extra");
        JCheckBox boton2 = new JCheckBox("Pepperoni");
        JCheckBox boton3 = new JCheckBox("Aceitunas");
        boton1.setName("Queso Extra");
        boton2.setName("Pepperoni");
        boton3.setName("Aceitunas");
        JButton ordenar = new JButton("Ordenar");

        ordenar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.print("Estos son los siguientes topppings ordenados: ");
                if (boton1.isSelected()) {
                    System.out.print(boton1.getName()+" ");
                }
                if (boton2.isSelected()) {
                    System.out.print(boton2.getName()+" ");
                }
                if (boton3.isSelected()) {
                    System.out.print(boton3.getName());
                }
                System.out.println();
            }
        });




        ventana.add(boton1);
        ventana.add(boton2);
        ventana.add(boton3);
        ventana.add(ordenar);


        ventana.setVisible(true);
    }
}
