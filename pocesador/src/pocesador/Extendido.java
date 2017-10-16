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
public class Extendido {
    
    public Extendido(){
        
    }
    
    public String extender(String f, String inmediato){
        String v16 = "000000000000000000000000000000000000000000000000";
        String v20 = "00000000000000000000000000000000000000000000";
        String re = null;
        if(f.equals("01")){
            re = v16 + inmediato;
        }
        else if(f.equals("10")){
            re = v20 + inmediato;
        }
        
        return re;
    }
    
}
