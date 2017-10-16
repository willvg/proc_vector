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
public class muxdt {
    public muxdt(){
        
    }
    
    public String [] seleccioDt(String inmediato [], String reg [],boolean Sel_op){
        String [] retorno = new String [8];
        if(Sel_op==false){
            retorno = reg;
        }
        else{
            retorno = inmediato;
        } 
        return retorno;
    }
}
