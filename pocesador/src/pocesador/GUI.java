/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pocesador;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

/**
 *
 * @author will
 */
public class GUI {

    JFrame Ventana = null;
    JButton boton;
    JButton pausa;
    JButton original;
    JButton filtrada;
    JButton modificada;
    JButton Boriginal;
    JLabel texto;

    JLabel pc;
    JLabel pc1;
    JLabel pc2;
    JLabel pc3;
    JTextArea fetch = new JTextArea("pc_in");
    JTextArea decode = new JTextArea("decode");
    JTextArea execute = new JTextArea("execute");
    JTextArea memory = new JTextArea("memory");
    JTextArea write = new JTextArea("write");

    JLabel cambio;
    

    String ProCou;
    String inst;

    boolean bandera = true;
    boolean wait = false;
    boolean banMosFinal = false;

    public GUI() {

        Dimension d = new Dimension();
        d.height = 900;
        d.width = 1800;
        Ventana = new JFrame("Control");
        Ventana.setPreferredSize(d);
        Ventana.pack();
        Ventana.setLocationRelativeTo(null);	//Centrar el JFrame

        boton = new JButton("Cambiar estado");
        boton.setBounds(50, 20, 200, 30);
        boton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cambiar();
                // Aquí está accesible unaVariable
                //System.out.println(bandera);
            }
        });
        
        pausa = new JButton("Pausa (desactivada)");
        pausa.setBounds(1300, 20, 250, 30);
        pausa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                activar();
            }
        });
        
        original = new JButton("Imagen Original");
        original.setBounds(1100, 800, 250, 30);
        original.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                original();
            }
        });
        
        filtrada = new JButton("Imagen Filtrada");
        filtrada.setBounds(1400, 800, 250, 30);
        filtrada.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                filtrada();
            }
        });

        texto = new JLabel();
        texto.setText("Estado");
        texto.setBounds(275, 20, 100, 30);

        cambio = new JLabel();
        cambio.setText("Corriendo por pasos");
        cambio.setBounds(400, 20, 300, 30);

        dibujar_Figuras();
        fetch();
        
        filtrada.setEnabled(false);
        
        Ventana.add(cambio);
        Ventana.add(texto);
        Ventana.add(boton);
        Ventana.add(pausa);
        Ventana.add(original);
        Ventana.add(filtrada);
        Ventana.setLayout(null);
        Ventana.setVisible(true);
    }
    
    public void original(){
         JFrame Ventana1 = null;
         JLabel im = new JLabel("imagen");
         String path = "/home/will/NetBeansProjects/pocesador/src/pocesador/lena256gris.jpg";
        //URL url = this.getClass().getResource(path);
        ImageIcon icon = new ImageIcon(path);
         
        Dimension d = new Dimension();
        d.height = icon.getIconHeight();
        d.width = icon.getIconWidth();
        Ventana1 = new JFrame("Imagen original");
        Ventana1.setPreferredSize(d);
        Ventana1.pack();
        Ventana1.setLocationRelativeTo(null);	//Centrar el JFrame
        
        
        
        im = new JLabel("PC");
        im.setBounds(5, 5, icon.getIconWidth(), icon.getIconHeight());
        im.setIcon(icon);
        Ventana1.add(im);
        
        Ventana1.setLayout(null);
        Ventana1.setVisible(true);
    }
    
        public void filtrada(){
         JFrame Ventana2 = null;
         JLabel im = new JLabel("imagen");
         String path = "/home/will/NetBeansProjects/pocesador/src/pocesador/saved.png";
        //URL url = this.getClass().getResource(path);
        ImageIcon icon = new ImageIcon(path);
         
        Dimension d = new Dimension();
        d.height = icon.getIconHeight();
        d.width = icon.getIconWidth();
        Ventana2 = new JFrame("Imagen Filtrada");
        Ventana2.setPreferredSize(d);
        Ventana2.pack();
        Ventana2.setLocationRelativeTo(null);	//Centrar el JFrame
        
        
        
        im = new JLabel("PC");
        im.setBounds(5, 5, icon.getIconWidth(), icon.getIconHeight());
        im.setIcon(icon);
        Ventana2.add(im);
        
        Ventana2.setLayout(null);
        Ventana2.setVisible(true);
    }

    public void cambiar() {
        if (bandera) {
            bandera = false;
            cambio.setText("Corriendo seguido");
        } else {
            bandera = true;
            cambio.setText("Corriendo por pasos");
        }
    }
    
    public void activar() {
        
        if (wait) {
            wait = false;
            pausa.setText("Pausa (desactivada)");
        } else {
            wait = true;
            pausa.setText("Pausa (activada)");
        }
    }

    public void escribir(boolean band) {
        bandera = band;
    }

    public boolean getControl() {
        return bandera;
    }
    
    public boolean getPausa() {
        return wait;
    }

    public void varFetch(String proCou, String Inst) {
        ProCou = proCou;
        inst = Inst;
        fetch();
    }

    public void varExecute(String Rr, String mux[], String rsul[], String We_c,
            String We_men, String Dob[]) {

        String Mux = "\n";
        for (int i = 0; i < 8; i++) {
            Mux = Mux + mux[i] + "\n";
        }
        String re = "\n";
        for (int i = 0; i < 8; i++) {
            re = re + rsul[i] + "\n";
        }
        String drb = "\n";
        for (int i = 0; i < 8; i++) {
            drb = drb + Dob[i] + "\n";
        }
        String text = "El registro Rr es: " + Rr + "\n"
                + "La salida del mux es: " + Mux + "\n"
                + "DoB es: " + drb + "\n"
                + "El resultado de la Alus es: " + re + "\n"
                + "We_c es: " + We_c + "\n"
                + "We_ mem es: " + We_men + "\n";
        execute.setText(text);
        execute.setBounds(730, 100, 275, 505);
        Ventana.add(execute);
        Ventana.repaint();
    }

    public void varDecode(String Rr, String Rp, String Rs, String Opcode,
            String DirA[], String DirB[], String We_c, String We_men, String Se_B,
            String Se_dt, String inmediato) {

        String drA = "\n";
        for (int i = 0; i < 8; i++) {
            drA = drA + DirA[i] + "\n";
        }
        String drb = "\n";
        for (int i = 0; i < 8; i++) {
            drb = drb + DirB[i] + "\n";
        }
        String text = "El registro Rr es: " + Rr + "\n"
                + "El registro Rp es: " + Rp + "\n"
                + "El registro Rs es: " + Rs + "\n"
                + "El Opcode es: " + Opcode + "\n \n"
                + "DoA es: " + drA + "\n"
                + "DoB es: " + drb + "\n"
                + "We_c es: " + We_c + "\n"
                + "We_ mem es: " + We_men + "\n"
                + "Sel_B es: " + Se_B + "\n"
                + "Sel_data es: " + Se_dt + "\n"
                + "El inmediato es: " + inmediato + "\n";
        decode.setText(text);
        decode.setBounds(390, 100, 275, 500);
        Ventana.add(decode);
        Ventana.repaint();
    }

    public void dibujar_Figuras() {
        String path = "/home/will/NetBeansProjects/pocesador/src/pocesador/pipeline.png";
        //URL url = this.getClass().getResource(path);
        ImageIcon icon = new ImageIcon(path);
        pc = new JLabel("PC");
        pc.setBounds(350, 75, 20, 650);
        pc.setIcon(icon);
        Ventana.add(pc);

        pc1 = new JLabel("PC");
        pc1.setBounds(700, 75, 20, 650);
        pc1.setIcon(icon);
        Ventana.add(pc1);

        pc2 = new JLabel("PC");
        pc2.setBounds(1050, 75, 20, 650);
        pc2.setIcon(icon);
        Ventana.add(pc2);

        pc3 = new JLabel("PC");
        pc3.setBounds(1420, 75, 20, 650);
        pc3.setIcon(icon);
        Ventana.add(pc3);
    }

    public void fetch() {
        fetch.setText("");
        String text = "La instruccion es: \n" + inst
                + "\n\n" + "El pc es: \n" + ProCou;
        fetch.setText(text);
        fetch.setBounds(25, 100, 275, 200);
        Ventana.add(fetch);
        Ventana.repaint();
    }

    public void varMemory(String Rr, String rsul[], String vector[], String We_c, String Sel_dt) {

        String vec = "\n";
        for (int i = 0; i < 8; i++) {
            vec = vec + vector[i] + "\n";
        }
        String re = "\n";
        for (int i = 0; i < 8; i++) {
            re = re + rsul[i] + "\n";
        }

        String text = "El registro Rr es: " + Rr + "\n"
                + "El vector que sele de memoria es: " + vec + "\n"
                + "El resultado de las Alus es: " + re + "\n"
                + "We_c es: " + We_c + "\n"
                + "Sel_dt es: " + Sel_dt + "\n";
        memory.setText(text);
        memory.setBounds(1080, 100, 275, 500);
        Ventana.add(memory);
        Ventana.repaint();
    }

    public void varWrite(String Rr, String Salida[], String We_c, String Sel_dt) {
        if(Rr.endsWith("1000")){
            filtrada.setEnabled(true);
        }
        else{
            filtrada.setEnabled(false);
        }
        String salida = "\n";
        for (int i = 0; i < 8; i++) {
            salida = salida + Salida[i] + "\n";
        }

        String text = "El registro Rr es: " + Rr + "\n"
                + "Posible a escribir es: " + salida + "\n"
                + "We_c es: " + We_c + "\n"
                + "Sel_dt es: " + Sel_dt + "\n";
        write.setText(text);
        write.setBounds(1450, 100, 275, 500);
        Ventana.add(write);
        Ventana.repaint();
    }

}
