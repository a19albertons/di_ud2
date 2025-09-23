package com.example;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Ejercicio10 {
    public static void main(String[] args) {
        JFrame ventana = new JFrame("Ejercicio 10");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(400, 400);
        ventana.setLayout(new FlowLayout());
        JMenuBar superior = new JMenuBar();
        JMenu archivo = new JMenu("Archivo");
        JMenu edicion = new JMenu("Edicion");
        superior.add(archivo);
        superior.add(edicion);

        JMenuItem abrir = new JMenuItem("Abrir");
        JMenuItem guardar = new JMenuItem("Guardar");
        archivo.add(abrir);
        archivo.add(guardar);

        abrir.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Abrir");
            }
            
        });
        guardar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Guardar");
            }
            
        });


        ventana.add(superior);

        ventana.setVisible(true);
    }
}
