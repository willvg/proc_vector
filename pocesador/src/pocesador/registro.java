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
public class registro {
    String[] r = new String[8];
    public registro(String R []){
        r = R;
    }
    
    
    public void escriba(String reg [], boolean We_c){
        if (We_c == true){
            r = reg;
        }
        else{
            r = r;
        }
    }
    
    public String[] getValor(){
        return r;
    }
    
}
