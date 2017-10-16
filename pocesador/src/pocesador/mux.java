/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pocesador;

/**
 *
 * @author will
 */
public class mux {
    
    public mux(){
        
    }
    
    public String [] seleccion(String inmediato, String reg [],boolean Sel_op){
        //System.out.println("in "+ inmediato);
        String [] retorno = new String [8];
        if(Sel_op==false){
            retorno = reg;
        }
        else{
            retorno[0] = inmediato.substring(0, 8);
            retorno[1] = inmediato.substring(8, 16);
            retorno[2] = inmediato.substring(16, 24);
            retorno[3] = inmediato.substring(24, 32);
            retorno[4] = inmediato.substring(32, 40);
            retorno[5] = inmediato.substring(40, 48);
            retorno[6] = inmediato.substring(48, 56);
            retorno[7] = inmediato.substring(56, 64);
            
        } 
        return retorno;
    }
}
