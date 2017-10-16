/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pocesador;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author will
 */
public class memoriaDatos {

    private String[] memoria = new String[1024 * 1024];
    private int contador = 0;
    private int alto = 0;
    private int ancho = 0;

    public void leerArchivo() throws FileNotFoundException, IOException {
        String cadena;
        FileReader f = new FileReader("/home/will/NetBeansProjects/pocesador/src/pocesador/memoriaData.txt");
        BufferedReader b = new BufferedReader(f);
        while ((cadena = b.readLine()) != null) {
            //System.out.println(cadena);
            if (cadena.equals("")) {

            } else {
                cargar_memoria(cadena);
            }

        }
        b.close();
        ///home/will/NetBeansProjects/pocesador/src/pocesador/saved.png
        ///home/will/Documentos/Arqui/proyecto 2/imagenes proyecto 1/lena256gris.jpg
        //frutas512gris.jpg
        File archivo = new File("/home/will/NetBeansProjects/pocesador/src/pocesador/saved.png");
        BufferedImage imagen = ImageIO.read(archivo);
        alto = imagen.getHeight();
        ancho = imagen.getWidth();
        
        String temporal[] = new String[1024 * 1024];
        int contador = 24;

        

        for (int i = 0; i < imagen.getHeight(); i++) {
            for (int j = 0; j < imagen.getWidth(); j++) {
                int rgb = imagen.getRGB(i, j);
                //imagen_encriptada.setRGB(i, j, rgb);
                Color col = new Color(rgb);
                int fina = col.getRed();
                String retornar = null;
                if (fina <= 1) {
                    retornar = "0000000" + Integer.toBinaryString(fina);
                } else if (fina > 1 && fina <= 3) {
                    retornar = "000000" + Integer.toBinaryString(fina);
                } else if (fina > 3 && fina <= 7) {
                    retornar = "00000" + Integer.toBinaryString(fina);

                } else if (fina > 7 && fina <= 15) {
                    retornar = "0000" + Integer.toBinaryString(fina);
                } else if (fina > 15 && fina <= 31) {
                    retornar = "000" + Integer.toBinaryString(fina);
                } else if (fina > 31 && fina <= 63) {
                    retornar = "00" + Integer.toBinaryString(fina);
                } else if (fina > 63 && fina <= 127) {
                    retornar = "0" + Integer.toBinaryString(fina);
                } else {
                    retornar = Integer.toBinaryString(fina);
                }
                memoria[contador] = retornar;
                contador++;
            }
        }
    }

    private void cargar_memoria(String linea) {

        int result = Integer.parseInt(linea, 16);
        //System.out.println(result);
        //System.out.println("contador: " +contador);
        String retornar = null;
        if (result <= 1) {
            retornar = "0000000" + Integer.toBinaryString(result);
        } else if (result > 1 && result <= 3) {
            retornar = "000000" + Integer.toBinaryString(result);
        } else if (result > 3 && result <= 7) {
            retornar = "00000" + Integer.toBinaryString(result);

        } else if (result > 7 && result <= 15) {
            retornar = "0000" + Integer.toBinaryString(result);
        } else if (result > 15 && result <= 31) {
            retornar = "000" + Integer.toBinaryString(result);
        } else if (result > 31 && result <= 63) {
            retornar = "00" + Integer.toBinaryString(result);
        } else if (result > 63 && result <= 127) {
            retornar = "0" + Integer.toBinaryString(result);
        } else {
            retornar = Integer.toBinaryString(result);
        }
        //System.out.println("retornar "+retornar);
        memoria[contador] = retornar;
        //System.out.println(lvinea);
        contador++;
    }

    public void imprimir() {
        for (int i = 0; i < contador; i++) {
            System.out.println(memoria[i]);
        }
    }

    //public String getInst(int pos){
    //    return memoria[pos];
    //}
    public String[] getVector(String direccion) {
        int direc = Integer.parseInt(direccion, 2);
        //System.out.println("***"+direc);
        String retorna[] = new String[8];
        for (int i = direc; i < direc + 8; i++) {
            retorna[i - direc] = memoria[i];
        }
        return retorna;
    }

    public void escribir(String direccion, String dato[], boolean We_mem) {
        int direc = Integer.parseInt(direccion, 2);
        //System.out.println("Dirrecion: " + direccion);
        if (We_mem == true) {
            for (int i = direc; i < direc + 8; i++) {
                memoria[i] = dato[i - direc];
            }
        }
    }

    public String[] getMemoria() {
        String memoria_aux[] = new String[1024 * 1024];
        for (int i = 24; i < contador; i++) {
            memoria_aux[i - 24] = memoria[i];
            //System.out.println(memoria_aux[i - 24]);
        }

        return memoria_aux;
    }
    
    public int getAlto(){
        return alto;
    }
    public int getAncho(){
        return ancho;
    }
}
