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
public class execute {
    
    public execute(){
        
    }
    
    String Union [] = new String [8];
    String Do_B [] = new String [8];
    boolean We_mem = false;
    boolean Sel_dt = false;
    boolean We_c;
    String Rr;
    
    public void ingresar(String union [], String Do_b [], boolean we_mem, boolean sel_dt, boolean we_c, String rr){
        Union = union;
        Do_B = Do_b;
        We_mem = we_mem;
        We_c = we_c;
        Sel_dt = sel_dt;
        Rr = rr;
    }
    
    public String [] getUnion(){
        return Union;
    }
    
    public String [] getDo_B(){
        return Do_B;
    }
    
    public boolean getWe_mem(){
        return We_mem;
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
