package com.example;

import java.awt.BorderLayout;
import java.awt.RenderingHints.Key;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Hello world!
 *
 */
public class editorTexto 
{
    static File ficheroActual;
    public static void main( String[] args )
    {
        // Ventana base
        JFrame ventana = new JFrame("editor texto v1");
        ventana.setSize(400, 400);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLayout(new BorderLayout());

        // Botones y similares
        JTextArea escribible = new JTextArea();
        JScrollPane espandible = new JScrollPane(escribible);
        JMenuBar barraSuperior = new JMenuBar();
        JMenu archivo = new JMenu("Archivo");
        JMenuItem abrir = new JMenuItem("Abrir");
        JMenuItem guardar = new JMenuItem("Guardar");
        JMenuItem salir = new JMenuItem("Salir");

        // Atajos
        int menuMask = Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx();
        abrir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, menuMask));
        guardar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, menuMask));
        salir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, menuMask));

        // Barra superior
        barraSuperior.add(archivo);
        archivo.add(abrir);
        archivo.add(guardar);
        archivo.add(salir);


        // Abrir fichero
        abrir.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fichero = new JFileChooser();
                FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos de Texto (.txt)", "txt");
                fichero.setFileFilter(filtro);
                int salida = fichero.showOpenDialog(ventana);
                if (salida == JFileChooser.APPROVE_OPTION) {
                    File archivo = fichero.getSelectedFile();
                    String contenido;
                    try {
                        contenido = Files.readString(archivo.toPath());
                        escribible.setText(contenido);
                        ficheroActual=archivo;
                    } catch (IOException e1) {
                        JOptionPane.showMessageDialog(ventana, "lo más probable falta de permisos");
                    }
                    
                }
                else {
                    JOptionPane.showMessageDialog(ventana,  "probablemente haya cerrado la ventana");
                }
            }
            
        });

        guardar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fichero = new JFileChooser();
                FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos de Texto (.txt)", "txt");
                fichero.setFileFilter(filtro);
                int salida = fichero.showOpenDialog(ventana);
                if (salida == JFileChooser.APPROVE_OPTION) {
                    File archivo = fichero.getSelectedFile();
                    String contenido = escribible.getText();
                    try {
                        if (archivo.getAbsolutePath().endsWith(".txt")) {
                            Files.write(archivo.toPath(), contenido.getBytes());
                        }
                        else {
                            File archivoConExt = new File(archivo.getParentFile(), archivo.getName() + ".txt");
                            Files.write(archivoConExt.toPath(), contenido.getBytes());
                        }
                        ficheroActual=archivo;
                    } catch (IOException e1) {
                        JOptionPane.showMessageDialog(ventana, "lo más probable falta de permisos");
                    }
                }
                else {
                    JOptionPane.showMessageDialog(ventana, "probablemente haya cerrado la ventana");
                }
            }
            
        });

        salir.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String contenido;
                try {
                    contenido = Files.readString(ficheroActual.toPath());
                    if (!contenido.equals(escribible.getText())) {
                        int opcion = JOptionPane.showConfirmDialog(ventana, "el cotenido no coindice esta seguro que desea salir?");
                        switch (opcion) {
                            case JOptionPane.YES_OPTION:
                                Files.write(ficheroActual.toPath(), escribible.getText().getBytes());
                                System.exit(0);
                                break;
                            case JOptionPane.NO_OPTION:
                                System.exit(0);
                        
                            default:

                                break;
                        }
                    }

                } catch (IOException e1) {
                    JOptionPane.showMessageDialog(ventana, "Ha habido algun problema potencialmente de permisos sobre el fichero");
                    System.exit(0);
                }
                catch (NullPointerException e1) {
                    // No se hace nada se espera este fallo si
                    // tu abres el programa y lo cierras desde salir
                    // porque la primera instrucion del try no tiene
                    // un fichero que leer

                    // Nota requiere añadir un System.exit(0)
                    System.exit(0);
                }


                
            }
            
        });

        // Añadir elementos a la ventana
        ventana.add(barraSuperior,BorderLayout.NORTH);
        ventana.add(espandible,BorderLayout.CENTER);

        // Hacer visible la ventana
        ventana.setVisible(true);
    }
}
