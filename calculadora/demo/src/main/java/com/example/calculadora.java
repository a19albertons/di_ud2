package com.example;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Hello world!
 *
 */
public class calculadora 
{
    static int original;
    static char operacion = ' ';
    public static void main( String[] args )
    {
        // Ventana y subventanas
        JFrame ventana = new JFrame("calculadora v1");
        ventana.setSize(400, 400);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLayout(new GridBagLayout());
        JPanel superior = new JPanel();
        superior.setLayout(new GridLayout(1,1));
        JPanel inferior = new JPanel();
        inferior.setLayout(new GridLayout(4,3));
        
        // Memoria
        

        // Todos los botones y campos de mierda
        JTextField escribible= new JTextField("",5);
        escribible.setEditable(false);
        JButton cero = new JButton("0");
        JButton uno = new JButton("1");
        JButton dos = new JButton("2");
        JButton tres = new JButton("3");
        JButton cuatro = new JButton("4");
        JButton cinco = new JButton("5");
        JButton seis = new JButton("6");
        JButton siete = new JButton("7");
        JButton ocho = new JButton("8");
        JButton nueve = new JButton("9");
        JButton sumar = new JButton("+");
        JButton restar = new JButton("-");
        JButton multiplicar = new JButton("*");
        JButton division = new JButton("/");
        JButton resultado = new JButton("=");
        JButton limpiar = new JButton("C");

        // Los numeros hacen su mierda
        siete.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (operacion=='n') {
                    escribible.setText("7");
                    operacion=' ';
                }
                else {
                    escribible.setText(escribible.getText()+"7");
                }
            }
            
        });
        ocho.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (operacion=='n') {
                    escribible.setText("8");
                    operacion=' ';
                }
                else {
                    escribible.setText(escribible.getText()+"8");
                }
            }
            
        });
        nueve.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (operacion=='n') {
                    escribible.setText("9");
                    operacion=' ';
                }
                else {
                    escribible.setText(escribible.getText()+"9");
                }
            }

        });
        cuatro.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (operacion=='n') {
                    escribible.setText("4");
                    operacion=' ';
                }
                else {
                    escribible.setText(escribible.getText()+"4");
                }
            }
            
        });
        cinco.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (operacion=='n') {
                    escribible.setText("5");
                    operacion=' ';
                }
                else {
                    escribible.setText(escribible.getText()+"5");
                }
            }
            
        });
        seis.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (operacion=='n') {
                    escribible.setText("6");
                    operacion=' ';
                }
                else {
                    escribible.setText(escribible.getText()+"6");
                }
            }
            
        });
        uno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (operacion=='n') {
                    escribible.setText("1");
                    operacion=' ';
                }
                else {
                    escribible.setText(escribible.getText()+"1");
                }
            }
        });
        dos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (operacion=='n') {
                    escribible.setText("2");
                    operacion=' ';
                }
                else {
                    escribible.setText(escribible.getText()+"2");
                }
            }
        });
        tres.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (operacion=='n') {
                    escribible.setText("3");
                    operacion=' ';
                }
                else {
                    escribible.setText(escribible.getText()+"3");
                }
            }
        });
        cero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (operacion=='n') {
                    escribible.setText("0");
                    operacion=' ';
                }
                else {
                    escribible.setText(escribible.getText()+"0");
                }
            }
        });

        //Operaciones
        sumar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                original=Integer.parseInt(escribible.getText());
                escribible.setText("");
                operacion='+';
            }
            
        });
        restar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                original=Integer.parseInt(escribible.getText());
                escribible.setText("");
                operacion='-';
            }
            
        });
        multiplicar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                original=Integer.parseInt(escribible.getText());
                escribible.setText("");
                operacion='*';
            }
            
        });
        division.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                original=Integer.parseInt(escribible.getText());
                escribible.setText("");
                operacion='/';
            }
            
        });


        //Operaciones avanzadas
        resultado.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int actual;
                int viejo;
                if (operacion!=' ') {
                    actual=Integer.parseInt(escribible.getText());
                    viejo=original;
                    switch (operacion) {
                        case '+':
                            escribible.setText(""+(viejo+actual));
                            operacion='n';
                            break;
                        case '-':
                            escribible.setText(""+(viejo-actual));
                            operacion='n';
                            break;
                        case '*':
                            escribible.setText(""+(viejo*actual));
                            operacion='n';
                            break;
                        case '/':
                            if (actual != 0) {
                                escribible.setText(""+(viejo/actual));
                                operacion='n';
                            }
                            else {
                                escribible.setText("0");
                                operacion='n';
                                JOptionPane.showMessageDialog(ventana, "0 no es un valor divisible valido");
                            }
                            break;
                        default:
                            break;
                    }
                }
                
                
                
            }
            
        });

        limpiar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                original=0;
                escribible.setText("");
                operacion=' ';
            }
            
        });




        // Añadir pantalla
        superior.add(escribible);
        inferior.add(siete);
        inferior.add(ocho);
        inferior.add(nueve);
        inferior.add(division);
        inferior.add(cuatro);
        inferior.add(cinco);
        inferior.add(seis);
        inferior.add(multiplicar);
        inferior.add(uno);
        inferior.add(dos);
        inferior.add(tres);
        inferior.add(restar);
        inferior.add(cero);
        inferior.add(limpiar);
        inferior.add(resultado);
        inferior.add(sumar);
        
        GridBagConstraints c = new GridBagConstraints();

        c.gridx = 0;
        c.gridy = 0;
        c.fill  = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = 1.0;   // 1 parte de 4 (1+3)
        ventana.add(superior, c);

        c.gridy = 1;
        c.weighty = 4.0;   // 3 partes de 4
        ventana.add(inferior, c);

        ventana.setVisible(true);
    }
}
