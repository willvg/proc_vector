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
public class fetch {
    
    private String Rp = "0000";
    private String Rs = "0000";
    private String Rr = "0000";
    private String opcode = "0000";
    private String cond = "00";
    private String F = "00";
    private String inmec= "00000000000000000000";
    private String inmeo= "0000000000000000";
    
    public fetch(){
        
    }
    public void guarda(String inst){
        opcode =  inst.substring(0, 4);
        cond =  inst.substring(4, 6);
        F = inst.substring(6, 8);
        Rr =  inst.substring(8, 12);
        if(F.equals("00")){
            Rp =  inst.substring(12, 16);
            Rs =  inst.substring(16, 20);
        }
        else if(F.equals("01")){
            Rp =  inst.substring(12, 16);
            inmeo =  inst.substring(16, 32);
        }
        else if(F.equals("10")){
            inmec =  inst.substring(12, 32);
        }
        
        
        
    }
    
    
    public String getRp(){
        return Rp;
    }
    
    public String getRs(){
        return Rs;
    }
    
    public String getOpcode() {
        return opcode;
    }

    public String getCond() {
        return cond;
    }
    
    public String getRr(){
        return Rr;
    }
    
    public String getF(){
        return F;
    }
    
    public String getInmediato(){
        String temporal = null;
        if(F.equals("01")){
            temporal = inmeo;
        }
        else if(F.equals("10")){
            temporal = inmec;
        }
        else{
            temporal = "0000000000000000";
        } 
        
        return temporal;
    }
    
}
