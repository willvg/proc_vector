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
public class bancoReg {
    
    public bancoReg(){
        
    }
    
    
    deco16 deco1 = new deco16();
    //uso para vectores
    String R [] = {"00000000","00000000","00000000","00000000","00000000","00000000","00000000","00000000"};
    private registro r0 = new registro(R);
    private registro r1 = new registro(R);
    private registro r2 = new registro(R);
    private registro r3 = new registro(R);
    private registro r4 = new registro(R);
    private registro r5 = new registro(R);
    private registro r6 = new registro(R);
    private registro r7 = new registro(R);
    
    //uso para escalares
    private registro r8 = new registro(R);
    private registro r9 = new registro(R);
    private registro r10 = new registro(R);
    private registro r11 = new registro(R);
    private registro r12 = new registro(R);
    private registro r13 = new registro(R);
    private registro r14 = new registro(R);
    private registro r15 = new registro(R);
    
    private String Do_A [] = new String [8];
    private String Do_B [] = new String [8];
    
    public void DirA(String Rp){
        String s = deco1.asinSalida(Rp);
        int valor = Integer.parseInt(s,2);
        if(valor==1){
            Do_A = r0.getValor();
        }
        else if(valor==2){
            Do_A = r1.getValor();
        }
        else if(valor==3){
            Do_A = r2.getValor();
        }
        else if(valor==4){
            Do_A = r3.getValor();
        }
        else if(valor==5){
            Do_A = r4.getValor();
        }
        else if(valor==6){
            Do_A = r5.getValor();
        }
        else if(valor==7){
            Do_A = r6.getValor();
        }
        else if(valor==8){
            Do_A = r7.getValor();
        }
        else if(valor==9){
            Do_A = r8.getValor();
        }
        else if(valor==10){
            Do_A = r9.getValor();
        }
        else if(valor==11){
            Do_A = r10.getValor();
        }
        else if(valor==12){
            Do_A = r11.getValor();
        }
        else if(valor==13){
            Do_A = r12.getValor();
        }
        else if(valor==14){
            Do_A = r13.getValor();
        }
        else if(valor==15){
            Do_A = r14.getValor();
        }
        else if(valor==16){
            Do_A = r15.getValor();
        }
        
    }
    
    public void DirB(String Rs){
        String s = deco1.asinSalida(Rs);
        int valor = Integer.parseInt(s,2);
        if(valor==1){
            Do_B = r0.getValor();
        }
        else if(valor==2){
            Do_B = r1.getValor();
        }
        else if(valor==3){
            Do_B = r2.getValor();
        }
        else if(valor==4){
            Do_B = r3.getValor();
        }
        else if(valor==5){
            Do_B = r4.getValor();
        }
        else if(valor==6){
            Do_B = r5.getValor();
        }
        else if(valor==7){
            Do_B = r6.getValor();
        }
        else if(valor==8){
            Do_B = r7.getValor();
        }
        else if(valor==9){
            Do_B = r8.getValor();
        }
        else if(valor==10){
            Do_B = r9.getValor();
        }
        else if(valor==11){
            Do_B = r10.getValor();
        }
        else if(valor==12){
            Do_B = r11.getValor();
        }
        else if(valor==13){
            Do_B = r12.getValor();
        }
        else if(valor==14){
            Do_B = r13.getValor();
        }
        else if(valor==15){
            Do_B = r14.getValor();
        }
        else if(valor==16){
            Do_B = r15.getValor();
        }
        
    }
    
    public void escribir(String Rr, String vector [], boolean We_c){
        String s = deco1.asinSalida(Rr);
        
        int valor = Integer.parseInt(s,2);
        
        if(valor==1){
            r0.escriba(vector, We_c);
        }
        else if(valor==2){
            r1.escriba(vector, We_c);
        }
        else if(valor==3){
            r2.escriba(vector, We_c);
        }
        else if(valor==4){
            r3.escriba(vector, We_c);
        }
        else if(valor==5){
            r4.escriba(vector, We_c);
        }
        else if(valor==6){
            r5.escriba(vector, We_c);
        }
        else if(valor==7){
            r6.escriba(vector, We_c);
        }
        else if(valor==8){
            r7.escriba(vector, We_c);
        }
        else if(valor==9){
            r8.escriba(vector, We_c);
        }
        else if(valor==10){
            r9.escriba(vector, We_c);
        }
        else if(valor==11){
            r10.escriba(vector, We_c);
        }
        else if(valor==12){
            r11.escriba(vector, We_c);
        }
        else if(valor==13){
            r12.escriba(vector, We_c);
        }
        else if(valor==14){
            r13.escriba(vector, We_c);
        }
        else if(valor==15){
            r14.escriba(vector, We_c);
        }
        else if(valor==16){
            r15.escriba(vector, We_c);
        }
    }
    
    public String [] getDoA(){
        return Do_A;
    }
    public String[] getDoB() {
        return Do_B;
    }
    
    
}
