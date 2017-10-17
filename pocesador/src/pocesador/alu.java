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
public class alu {
    
    public alu(){
        
    }
    boolean z = false;
    boolean n = false;
    
    public String operacion (String a, String b, String operando){
        //System.out.println("a :" + a);
        //System.out.println("b :" + b);
        //System.out.println("operando :" + operando);
        String retornar = null;
        String temporal = null;
        int val1  = Integer.parseInt(a,2);
        int val2  = Integer.parseInt(b,2);
        
        //System.out.println("a int :" + val1);
        //System.out.println("b int :" + val2);
        int result = 0;
        
        if(operando.equals("0000") || operando.equals("0001")){
            result = val1 + val2;
            if(result>=255){
                result = result - 255;
            }
            else{
                result = result;
            }
            //System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&: "+ result);
        }
        else if(operando.equals("0010") || operando.equals("0011") ){
            result = val1 - val2;
            if(result<0){
                result = 255 + result;
            }
            else{
                result = result;
            }
            //System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&: "+ result);
        }
        else if(operando.equals("0100")){
            result = val1 ^ val2;
            //System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
            //System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&"+result);
        }
        else if(operando.equals("1001")){
            result = val1 << val2;
            if(result>=255){
                result = result - 255;
            }
            else{
                result = result;
            }
            //System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&: "+ result);
        }
        else if(operando.equals("1010")){
            result = val1 >> val2;
            if(result<0){
                result = 255 + result;
            }
            else{
                result = result;
            }
            //System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&: "+ result);
        }
        else if(operando.equals("1011")){
            //result = val1 >> val2;
            String valor1 = a.substring(0, val2);
            String valor2 = a.substring(val2, 8);
            retornar = valor2 + valor1;
            result = Integer.parseInt(retornar,2);
            //System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&: "+ retornar);
        }
        else if(operando.equals("1100")){
            //result = val1 >> val2;
            String valor1 = a.substring(8-val2, 8);
            String valor2 = a.substring(0, 8-val2);
            retornar = valor1 + valor2;
            result = Integer.parseInt(retornar,2);
            //System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&: "+ result);
        }
        else{
            retornar ="00000000";
        }
        
        if(result<=1){
            retornar = "0000000" + Integer.toBinaryString(result);
        }
        else if (result>1 && result <= 3){
            retornar = "000000" + Integer.toBinaryString(result);
        }
        else if (result>3 && result <= 7){
            retornar = "00000" + Integer.toBinaryString(result);
            
        }
        else if (result>7 && result <= 15){
            retornar = "0000" + Integer.toBinaryString(result);
        }
        else if (result>15 && result <= 31){
            retornar = "000" + Integer.toBinaryString(result);
        }
        else if (result>31 && result <= 63){
            retornar = "00" + Integer.toBinaryString(result);
        }
        else if (result>63 && result <= 127){
            retornar = "0" + Integer.toBinaryString(result);
        }
        else{
            retornar =  Integer.toBinaryString(result);
            
        }
        
        if(retornar.equals("00000000")){
            z= true;
        }
        else{
            z=false;
        }
        
        if(retornar.substring(0)=="1"){
            n = true;
        }else{
            n = false;
        }
        //System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&: "+ retornar);
        return retornar;
    }
    
    public boolean getZ(){
        return z;
    }
    public boolean getN(){
        return n;
    }
    
    public String multi(String a [], String b[]){
        String retornar  = null;
        String A = a[0]+a[1]+a[2]+a[3]+a[4]+a[5]+a[6]+a[7];
        String B = b[0]+b[1]+b[2]+b[3]+b[4]+b[5]+b[6]+b[7];
        int val1  = Integer.parseInt(A,2);
        int val2  = Integer.parseInt(B,2);
        String temp = Integer.toBinaryString(val1*val2);
        for (int i = temp.length(); i < 64; i++) {
            temp ="0"+temp;
        }
        //System.out.println("pocesador.alu.multi()"+temp);
        retornar= temp;
        return retornar;
    }
    
}
