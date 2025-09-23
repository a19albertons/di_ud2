package com.example;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Ejercicio7 {
    public static void main(String[] args) {
        JFrame ventana = new JFrame("Ejercicio 7");
        ventana.setSize(400, 400);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLayout(new FlowLayout());

        JLabel nombreEtiqueta = new JLabel("nombre");
        JTextField nombre = new JTextField(5);
        JLabel contrasenaEtiqueta = new JLabel("contraseña");
        JPasswordField contrasena = new JPasswordField(5);
        JButton sesion = new JButton("Iniciar sesion") ;
        sesion.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("El usuario dado es: "+nombre.getText()+" y la contraseña es: "+contrasena.getText());
            }
            
        });

        ventana.add(nombreEtiqueta);
        ventana.add(nombre);
        ventana.add(contrasenaEtiqueta);
        ventana.add(contrasena);
        ventana.add(sesion);

        ventana.setVisible(true);
    }
}
