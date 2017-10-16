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
public class decode {

    public decode() {

    }
    private String Alu_ctr;
    private String Cond;
    private String Opcode;
    private boolean Sel_b = false;
    private boolean Sel_dt;
    private boolean We_c = false;
    private boolean We_mem = false;
    private boolean Compara = false;
    
    private String DirA[] = new String[8];
    private String DirB[] = new String[8];

    private String Rr;
    private String Ext;

    public void ingresar(String alu_ctr, boolean sel_b, boolean sel_dt,
            boolean we_c, boolean we_mem, String dirA[], String dirB[],
            String rr, String ext, String opcode, String cond, boolean compara) {
         Alu_ctr = alu_ctr;

         Sel_b = sel_b;
         Sel_dt = sel_dt;
         We_c = we_c;
         We_mem = we_mem;

         DirA = dirA;
         DirB = dirB;

         Rr = rr;
         Ext = ext;
         
         Opcode = opcode;
         Cond = cond;
         Compara = compara;
    }
    
    public String getAlu_ctr(){
        return Alu_ctr;
    }
    public String getOpcode() {
        return Opcode;
    }
    public String getCond() {
        return Cond;
    }
    public String getRr(){
        return Rr;
    }
    public String getExt(){
        return Ext;
    }
    public boolean getSel_b(){
        return Sel_b;
    }
    public boolean getCompara(){
        return Compara;
    }
    public boolean getSel_dt(){
        return Sel_dt;
    }
    public boolean getWe_c(){
        return We_c;
    }
    public boolean getWe_mem(){
        return We_mem;
    }
    public String [] getDo_A(){
        return DirA;
    }
    public String [] getDo_B(){
        return DirB;
    }
}
