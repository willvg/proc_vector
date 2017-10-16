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
public class Memory {
    
    
    public Memory(){
        
    }
    String Union [];
    String vector [];
    boolean Sel_dt;
    boolean We_c;
    String Rr;
    public void ingresar(String union [], String vectorF [], boolean sel_dt, boolean we_c, String rr){
        Union = union;
        vector= vectorF;
        Sel_dt = sel_dt;
        We_c = we_c;
        Rr = rr;
    }
    
    public String [] getUnion(){
        return Union;
    }
    
    public String [] getVector(){
        return vector;
    }
    public boolean getSel_dt(){
        return Sel_dt;
    }
    public boolean getWe_c(){
        return We_c;
    }
    
    public String getRr(){
        return Rr;
    }
}
