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
public class deco16 {
    public deco16(){
        
    }
    /*String salida []= {
                    "0000000000000001",
                    "0000000000000010",
                    "0000000000000100",
                    "0000000000001000",
                    "0000000000010000",
                    "0000000000100000",
                    "0000000001000000",
                    "0000000010000000",
                    "0000000100000000",
                    "0000001000000000",
                    "0000010000000000",
                    "0000100000000000",
                    "0001000000000000",
                    "0010000000000000",
                    "0100000000000000",
                    "1000000000000000"};*/
    String salida []= {
                    "0001",
                    "0010",
                    "0011",
                    "0100",
                    "0101",
                    "0110",
                    "0111",
                    "1000",
                    "1001",
                    "1010",
                    "1011",
                    "1100",
                    "1101",
                    "1110",
                    "1111",
                    "10000"};
    
    public String asinSalida(String Reg){
        int reg = Integer.parseInt(Reg,2);
        return salida[reg];
    }
}
