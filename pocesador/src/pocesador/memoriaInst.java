/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pocesador;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author will
 */
public class memoriaInst {
    
    memoriaInst(){
        
    }
    
    private String[] memoria = new String[1024*1024];
    private int contador = 0;
    
    public void leerArchivo() throws FileNotFoundException, IOException {
        String cadena;
        FileReader f = new FileReader("/home/will/NetBeansProjects/pocesador/src/pocesador/memoriaInstr.txt");
        BufferedReader b = new BufferedReader(f);
        while((cadena = b.readLine())!=null) {
            //System.out.println(cadena);
            if (cadena.equals("")) {
               
            }
            else{
                cargar_memoria(cadena);
            }
            
        }
        b.close();
    }
    
    private void cargar_memoria(String linea){
        memoria[contador] = linea;
        //System.out.println(linea);
        contador++;
    }
    
    public void imprimir(){
        for (int i = 0; i < contador; i++) {
            System.out.println(memoria[i]);
        }
    }
    
    public String getInst(int pos){
        return memoria[pos];
    }
    
}
