/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pocesador;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;


/**
 *
 * @author will
 */
public class Pocesador {
    public static void imagen (String memoria [], int alto, int ancho) throws IOException{
        /*File archivo = new File("/home/will/Documentos/Arqui/proyecto 2/imagenes proyecto 1/lena256gris.jpg");
        BufferedImage imagen = ImageIO.read(archivo);
        String temporal [] = new String [1024*1024];
        int contador=0;
        for (int i = 0; i < 256; i++) {
            for (int j = 0; j < 256; j++) {
                int rgb = imagen.getRGB(i,j);
                //imagen_encriptada.setRGB(i, j, rgb);
                Color col = new Color (rgb);
                temporal[contador] = Integer.toHexString(col.getRed());
                contador++;
            }
        }
        
        for (int i = 0; i < contador; i++) {
            System.out.println("base: "+temporal[i]);
        }
        
        int cont = 0;
        String tem [][] = new String[256][256];
        for (int i = 0; i < 256; i++) {
            for (int j = 0; j < 256; j++) {
                tem[i][j]= temporal[cont];
                cont++;
            }
        }*/
        //System.out.println(alto);
        //System.out.println(ancho);
        BufferedImage imagen_encriptada = new BufferedImage(alto,ancho,BufferedImage.TYPE_INT_RGB);
        int cont = 0;
        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {
                //System.out.println("pocesador.Pocesador.imagen()"+Integer.parseInt(temporal[j*i+j],16));
                Color myWhite = new Color(Integer.parseInt(memoria[cont],2), Integer.parseInt(memoria[cont],2), Integer.parseInt(memoria[cont],2));
                int rgb = myWhite.getRGB();
                imagen_encriptada.setRGB(i, j, rgb);
                //System.out.println("cont" + cont);
                //System.out.println("memoria" + memoria[cont]);
                cont++;
                
            }
        }
        
        //ImageIcon icono = new ImageIcon(imagen_encriptada);
        File outputfile = new File("/home/will/NetBeansProjects/pocesador/src/pocesador/saved.png");
        ImageIO.write(imagen_encriptada, "png", outputfile);
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
        memoriaInst memInt = new memoriaInst();
        int pc=0;
        sumador32 suma32 = new sumador32();
        fetch fetch = new fetch();
        
        memInt.leerArchivo();
        
        memoriaDatos memData = new memoriaDatos();
        
        memData.leerArchivo();
        
        bancoReg banco= new bancoReg();
        
        Extendido extend = new Extendido();
        
        UnidadControl uc = new UnidadControl();
        
        
                alu a1 = new alu();
        alu a2 = new alu();
        alu a3 = new alu();
        alu a4 = new alu();
        alu a5 = new alu();
        alu a6 = new alu();
        alu a7 = new alu();
        alu a8 = new alu();
        
        mux mux = new mux();
        
        String v1 = null;
        String v2 = null;
        String v3 = null;
        String v4 = null;
        String v5 = null;
        String v6 = null;
        String v7 = null;
        String v8 = null;
        
        CondicionControl cc = new CondicionControl();
        
        muxdt mdt = new muxdt();
        
        //memData.imprimir();
        //***********************************************
        //***********************************************
        //***********************************************
        //***********************************************
        while(true){
        

        String inst = memInt.getInst(pc);
        //System.out.println("**************");
        //System.out.println(inst);
        //System.out.println(inst.substring(0, 4));
        int nuevoPc=suma32.suma(pc);
        pc=nuevoPc;
        //System.out.println(inst.substring);
        
        fetch.guarda(inst);
        String rp= fetch.getRp();
        //System.out.println("rp: " + rp);
        
        String rs= fetch.getRs();
        //System.out.println("rs: " + rs);
        
        String rr= fetch.getRr();
        //System.out.println("rr: " + rr);
        
        
        String op= fetch.getOpcode();
        //System.out.println("opcode: " + op);
        
        String cond= fetch.getCond();
        //System.out.println("cond: " + cond);
        
        String f= fetch.getF();
        //System.out.println("F: " + f);
        
        String in= fetch.getInmediato();
        //System.out.println("inmediato: " + in);
        
        //********************************************
        //********************************************
        //DECODE  
        
        uc.ingresar_valores(fetch.getOpcode(), fetch.getF());
        
        banco.DirA(fetch.getRp());
        if(fetch.getOpcode().equals("0101") || fetch.getOpcode().equals("0110")){
            banco.DirB(fetch.getRr());
        }
        else{
            banco.DirB(fetch.getRs());
        }
        
        
        
        String ext = extend.extender(uc.getExten(), fetch.getInmediato());
        
        
        
        //********************************************
        //********************************************
        //EXECUTE

        
        
        //System.out.println("***********************************************sel b: "+  uc.getSel_b());
        String salida_mux [] = mux.seleccion(ext, banco.getDoB(), uc.getSel_b());
        
        //for (int i = 0; i < 8; i++) {
        //   System.out.println("salida: "+salida_mux[i]);
        //    System.out.println("a: "+banco.getDoA()[i]);
        //}
        //System.out.println("alu: "+ uc.getAlu_ctrl());
        
        String union [] = new String[8];
        if(uc.getAlu_ctrl()=="1110"){
            v1 =a1.multi(banco.getDoA(), salida_mux);
            union[0] = v1.substring(0, 8);
            union[1] = v1.substring(8, 16);
            union[2] = v1.substring(16, 24);
            union[3] = v1.substring(24, 32);
            union[4] = v1.substring(32, 40);
            union[5] = v1.substring(40, 48);
            union[6] = v1.substring(48, 56);
            union[7] = v1.substring(56, 64);
        }
        else{
            //for (int i = 0; i < 8; i++) {
            //System.out.println("-------------------------------------------salida: "+salida_mux[i]);
         //   System.out.println("------------------------------------------------a: "+banco.getDoA()[i]);
        //    System.out.println("------------------------------------------control: "+uc.getAlu_ctrl());
        //}
            if(fetch.getOpcode().equals("1101")|| fetch.getOpcode().equals("0101")|| fetch.getOpcode().equals("0110")
                    || fetch.getOpcode().equals("0111")|| fetch.getOpcode().equals("1101")){
                v1 = a1.operacion("00000000", salida_mux[0], uc.getAlu_ctrl());
                v2 = a2.operacion("00000000", salida_mux[1], uc.getAlu_ctrl());
                v3 = a3.operacion("00000000", salida_mux[2], uc.getAlu_ctrl());
                v4 = a4.operacion("00000000", salida_mux[3], uc.getAlu_ctrl());
                v5 = a5.operacion("00000000", salida_mux[4], uc.getAlu_ctrl());
                v6 = a6.operacion("00000000", salida_mux[5], uc.getAlu_ctrl());
                v7 = a7.operacion("00000000", salida_mux[6], uc.getAlu_ctrl());
                v8 = a8.operacion("00000000", salida_mux[7], uc.getAlu_ctrl());
            }
            else{
                v1 = a1.operacion(banco.getDoA()[0], salida_mux[0], uc.getAlu_ctrl());
                v2 = a2.operacion(banco.getDoA()[1], salida_mux[1], uc.getAlu_ctrl());
                v3 = a3.operacion(banco.getDoA()[2], salida_mux[2], uc.getAlu_ctrl());
                v4 = a4.operacion(banco.getDoA()[3], salida_mux[3], uc.getAlu_ctrl());
                v5 = a5.operacion(banco.getDoA()[4], salida_mux[4], uc.getAlu_ctrl());
                v6 = a6.operacion(banco.getDoA()[5], salida_mux[5], uc.getAlu_ctrl());
                v7 = a7.operacion(banco.getDoA()[6], salida_mux[6], uc.getAlu_ctrl());
                v8 = a8.operacion(banco.getDoA()[7], salida_mux[7], uc.getAlu_ctrl());
            }
            
            union[0] = v1;
            union[1] = v2;
            union[2] = v3;
            union[3] = v4;
            union[4] = v5;
            union[5] = v6;
            union[6] = v7;
            union[7] = v8;
        }
 
        String vecN [] = new String[8];
        vecN[0]= String.valueOf(a1.getN());
        vecN[1]= String.valueOf(a2.getN());
        vecN[2]= String.valueOf(a3.getN());
        vecN[3]= String.valueOf(a4.getN());
        vecN[4]= String.valueOf(a5.getN());
        vecN[5]= String.valueOf(a6.getN());
        vecN[6]= String.valueOf(a7.getN());
        vecN[7]= String.valueOf(a8.getN());
        String vecZ [] = new String[8];
        vecZ[0]= String.valueOf(a1.getZ());
        vecZ[1]= String.valueOf(a2.getZ());
        vecZ[2]= String.valueOf(a3.getZ());
        vecZ[3]= String.valueOf(a4.getZ());
        vecZ[4]= String.valueOf(a5.getZ());
        vecZ[5]= String.valueOf(a6.getZ());
        vecZ[6]= String.valueOf(a7.getZ());
        vecZ[7]= String.valueOf(a8.getZ());
        
        //System.out.println("N: "+ vecN[7]);
        //System.out.println("Z: "+ vecZ[7]);
        
        
        //for (int i = 0; i < 8; i++) {
        //    System.out.println("-------------------------------------------union: "+ union[i]);
        //}
        
        
        boolean we_c = cc.endradas( fetch.getCond(), cc.validaN(vecN), cc.validaZ(vecZ), uc.getWe_c(),uc.compara());
        
        //System.out.println("we_c: "+ we_c);
        //********************************************
        //********************************************
        //MEMORIA
        
        //memData.imprimir();
        String completo = union[6]+union[7]; //union[0]+union[1]+union[2]+union[3]+ union[4]+union[5]+
        //System.out.println("wemen " + uc.getWe_mem());
        
        
        memData.escribir(completo, banco.getDoB(), uc.getWe_mem());
        
        String vector [] = memData.getVector(completo);
        

        //for (int i = 0; i < 8; i++) {
        //    System.out.println(vector[i]);
        //}
        

        //********************************************
        //********************************************
        //ESCRIBIR
        
        
        //System.out.println("dat " +uc.getSel_dt());
        
        String esc [] = mdt.seleccioDt(union, vector, uc.getSel_dt());
        //for (int i = 0; i < 8; i++) {
        //    System.out.println(" *** "+esc[i]);
        //}
        //System.out.println("cosa: "+ fetch.getRr());
        banco.escribir(fetch.getRr(), esc, we_c);
        
        /*System.out.println("Inicia las impersiones:  ********************************************************");
        for (int i = 0; i < 8; i++) {
            //banco.DirA("1000");
            System.out.print("  "+banco.getDoA()[i]);
        }
        System.out.println("");
        for (int i = 0; i < 8; i++) {
            //banco.DirA("0000");
            System.out.print("  "+banco.getDoB()[i]);
        }
        System.out.println("");
        System.out.println("");
        for (int i = 0; i < 8; i++) {
            banco.DirA(fetch.getRr());
            System.out.print("  "+banco.getDoA()[i]);
        }
        System.out.println("");*/
        
   
        banco.DirA("1000");
        
        //System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        if(banco.getDoA()[7].equals("00000001")){
            
            break;
        }
        
        }
         //memData.imprimir();
        imagen(memData.getMemoria(), memData.getAlto(), memData.getAncho() );

      
    }
    
}
