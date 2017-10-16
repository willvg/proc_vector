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
public class UnidadControl {
    
    
    public UnidadControl(){
        
    }
    
    String f;
    String opcode;
    
    public void ingresar_valores(String Opcode, String F){
        opcode = Opcode;
        f =F;
    }
    
    public boolean getWe_c(){
        boolean retornar = false;
        if(opcode.equals("1111")){ // para comparar
            retornar=true;
        }
        else if(f.equals("11")){ //para escribir
            retornar=true;
        }
        else{
            retornar = false;
        }
        return retornar;
    }
    
    public String getExten(){
        String retornar = null;
        if(f.equals("10")){
            retornar = "10";
        }
        else{
            retornar = "01";
        }
        return retornar;
    }
    
    public String getAlu_ctrl(){
       String retornar = null;
        if(opcode.equals("0000")){ //suma
            retornar="0000";
        }
        else if(opcode.equals("0001")){ //suma e
            retornar="0001";
        }
        else if(opcode.equals("0010")){ //resta
            retornar="0010";
        }
        else if(opcode.equals("0011")){ //resta e
            retornar="0011";
        }
        else if(opcode.equals("1111")){ //compara
            retornar="1111";
        }
        else if(opcode.equals("0100")){ //xor
            retornar="0100";
        }
        else if(opcode.equals("1001")){ //lsl
            retornar="1001";
        }
        else if(opcode.equals("1010")){ //lsr
            retornar="1010";
        }
        else if(opcode.equals("1011")){ //rls
            retornar="1011";
        }
        else if(opcode.equals("1100")){ //rsr
            retornar="1100";
        }
        else if(opcode.equals("1110")){ //multiplicar
            retornar="1110";
        }
        else{
            retornar="0000";
        }
        return retornar;
    }
    
    ///para inmediatos o banco
    public boolean getSel_b(){
        boolean retornar = false;
        if(opcode.equals("0001")){ //suma
            retornar=true;
        }
        else if(opcode.equals("0011")){ //resta e
            retornar=true;
        }
        else if(opcode.equals("0101")){ //guarda v
            retornar=true;
        }
        else if(opcode.equals("0110")){ //guarda e 
            retornar=true;
        }
        else if(opcode.equals("0111")){ //carga v
            retornar=true;
        }
        else if(opcode.equals("1000")){ //carga e
            retornar=true;
        }
        else if(opcode.equals("1101")){ //mover
            retornar=true;
        }
        else{
            retornar= false;
        }
        return retornar;
    }
    
    public boolean getWe_mem(){
        boolean retornar = false;
        if(opcode.equals("0101")){ //guarda v
            retornar=true;
        }
        else if(opcode.equals("0110")){ //guarda e
            retornar=true;
        }
        else{
            retornar = false;
        }
        return retornar;
    }
    
    //para escribir
    public boolean getSel_dt(){
       boolean retornar = false;
        if(opcode.equals("0111")){ //para sacar de memoria 
            retornar=false;
        }
        else if(opcode.equals("0011")){ //suma e
            retornar=false;
        }
        else if(opcode.equals("1000")){ //suma e
            retornar=false;
        }
        else{
            retornar = true;
        }
        return retornar;
    }
    
    public boolean compara(){
        boolean retornar = false;
        if(opcode.equals("1111")){
            retornar = true;
        }
        else{
            retornar = false;
        }
        
        return retornar;
    }
    
}
