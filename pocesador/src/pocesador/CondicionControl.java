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
public class CondicionControl {
    
    String cond;
    boolean n; 
    boolean z; 
    boolean We_caux; 
    boolean comp;
    public boolean endradas(String Cond, boolean N, boolean Z, boolean We_cAux, boolean compara){   
        cond = Cond;
        We_caux = We_cAux;
        comp = compara;
        boolean retornar = false;
        boolean pos0 = false;
        boolean pos1 = false;
        
        if(comp == true ){
           z =Z;
           n =N; 
        }
        else {
            z = z;
            n = n;
        }
        
        if(cond.equals("11")){
            retornar = true;
        }
        else {
            if(cond.substring(0,1).equals("1")){
                pos1 = true;
            }
            else{
                pos1 = false;
            }
            if(cond.substring(1,2).equals("1")){
                pos0 = true;
            }
            else{
                pos0 = false;
            }
            
            
            if(n==pos1 && z==pos0){
                retornar = true;
            }
            else{
                retornar = false;
            }
        }
        
        return retornar;
    }
    
    public boolean validaN(String arreglo []){
        boolean r = false;
        if(arreglo.toString().equals("11111111")){
            r =true;
        }
        else{
            r = false;
        }
        
        return r;
    }
    public boolean validaZ(String arreglo []){
        boolean r = false;
        if(arreglo.toString().equals("00000000")){
            r =true;
        }
        else{
            r = false;
        }
        return r;
    }
}
