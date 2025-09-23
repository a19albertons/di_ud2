package com.example;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * Hello world!
 *
 */
public class Ejercicio1
{
    public static void main( String[] args )
    {
        JFrame ventana = new JFrame("ejercicio 1");
        ventana.setSize(400, 400);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLayout(new FlowLayout());
        JButton boton = new JButton("Pulsa aqui");
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("hola mundo");
            }
        });

        ventana.add(boton);
        ventana.setVisible(true);
        
    }
}
