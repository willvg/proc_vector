/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pocesador;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author will
 */
public class Pocesador {

    public static void imagen(String memoria[], int alto, int ancho) throws IOException {

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
        BufferedImage imagen_encriptada = new BufferedImage(alto, ancho, BufferedImage.TYPE_INT_RGB);
        int cont = 0;
        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {
                //System.out.println("pocesador.Pocesador.imagen()"+Integer.parseInt(temporal[j*i+j],16));
                Color myWhite = new Color(Integer.parseInt(memoria[cont], 2), Integer.parseInt(memoria[cont], 2), Integer.parseInt(memoria[cont], 2));
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
    public static void main(String[] args) throws IOException, InterruptedException {
        // TODO code application logic here

        //JFrame Ventana = null;
        //Dimension d = new Dimension();
        //d.height = 900;
        //d.width = 1500;
        //Ventana = new JFrame("Control");
        // Ventana.setPreferredSize(d);
        //Ventana.pack();
        //Ventana.setLocationRelativeTo(null);	//Centrar el JFrame
        //Ventana.setVisible(true);
        GUI ventana = new GUI();

        //ventana.setVisible(true);
        memoriaInst memInt = new memoriaInst();
        int pc = 0;
        sumador32 suma32 = new sumador32();
        fetch fetch = new fetch();

        memInt.leerArchivo();

        memoriaDatos memData = new memoriaDatos();

        memData.leerArchivo();

        decode decode = new decode();

        execute execute = new execute();

        Memory memory = new Memory();

        bancoReg banco = new bancoReg();

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

        String inst = "";
        String ext = "";

        //memData.imprimir();
        //***********************************************
        //***********************************************
        //***********************************************
        //***********************************************
        while (true) {

            if (ventana.getControl() && ventana.getPausa() == false) {
                inst = memInt.getInst(pc);

                int nuevoPc = suma32.suma(pc);
                pc = nuevoPc;

                ventana.varFetch(String.valueOf(pc), inst);

                fetch.guarda(inst);

                System.out.println("ejecuto fetch");
                Thread.sleep(500);
                //********************************************
                //********************************************
                //DECODE  
                uc.ingresar_valores(fetch.getOpcode(), fetch.getF());

                banco.DirA(fetch.getRp());
                if (fetch.getOpcode().equals("0101") || fetch.getOpcode().equals("0110")) {
                    banco.DirB(fetch.getRr());
                } else {
                    banco.DirB(fetch.getRs());
                }

                ext = extend.extender(uc.getExten(), fetch.getInmediato());

                decode.ingresar(uc.getAlu_ctrl(), uc.getSel_b(), uc.getSel_dt(), uc.getWe_c(),
                        uc.getWe_mem(), banco.getDoA(), banco.getDoB(), fetch.getRr(), ext, fetch.getOpcode(), fetch.getCond(), uc.compara());

                ventana.varDecode(fetch.getRr(), fetch.getRp(), fetch.getRs(), fetch.getOpcode(),
                        banco.getDoA(), banco.getDoB(), String.valueOf(uc.getWe_c()), String.valueOf(uc.getWe_mem()),
                        String.valueOf(uc.getSel_b()), String.valueOf(uc.getSel_dt()), String.valueOf(Integer.parseInt(fetch.getInmediato(), 2)));
                System.out.println("ejecuto decode");
                Thread.sleep(500);
                //********************************************
                //********************************************
                //EXECUTE
                String salida_mux[] = mux.seleccion(decode.getExt(), decode.getDo_B(), decode.getSel_b());

                String union[] = new String[8];
                if (decode.getAlu_ctr().equals("1110")) {
                    v1 = a1.multi(decode.getDo_A(), salida_mux);
                    union[0] = v1.substring(0, 8);
                    union[1] = v1.substring(8, 16);
                    union[2] = v1.substring(16, 24);
                    union[3] = v1.substring(24, 32);
                    union[4] = v1.substring(32, 40);
                    union[5] = v1.substring(40, 48);
                    union[6] = v1.substring(48, 56);
                    union[7] = v1.substring(56, 64);
                } else {

                    if (decode.getOpcode().equals("1101") || decode.getOpcode().equals("0101") || decode.getOpcode().equals("0110")
                            || decode.getOpcode().equals("0111") || decode.getOpcode().equals("1101")) {
                        v1 = a1.operacion("00000000", salida_mux[0], uc.getAlu_ctrl());
                        v2 = a2.operacion("00000000", salida_mux[1], uc.getAlu_ctrl());
                        v3 = a3.operacion("00000000", salida_mux[2], uc.getAlu_ctrl());
                        v4 = a4.operacion("00000000", salida_mux[3], uc.getAlu_ctrl());
                        v5 = a5.operacion("00000000", salida_mux[4], uc.getAlu_ctrl());
                        v6 = a6.operacion("00000000", salida_mux[5], uc.getAlu_ctrl());
                        v7 = a7.operacion("00000000", salida_mux[6], uc.getAlu_ctrl());
                        v8 = a8.operacion("00000000", salida_mux[7], uc.getAlu_ctrl());
                    } else {
                        v1 = a1.operacion(decode.getDo_A()[0], salida_mux[0], decode.getAlu_ctr());
                        v2 = a2.operacion(decode.getDo_A()[1], salida_mux[1], decode.getAlu_ctr());
                        v3 = a3.operacion(decode.getDo_A()[2], salida_mux[2], decode.getAlu_ctr());
                        v4 = a4.operacion(decode.getDo_A()[3], salida_mux[3], decode.getAlu_ctr());
                        v5 = a5.operacion(decode.getDo_A()[4], salida_mux[4], decode.getAlu_ctr());
                        v6 = a6.operacion(decode.getDo_A()[5], salida_mux[5], decode.getAlu_ctr());
                        v7 = a7.operacion(decode.getDo_A()[6], salida_mux[6], decode.getAlu_ctr());
                        v8 = a8.operacion(decode.getDo_A()[7], salida_mux[7], decode.getAlu_ctr());
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

                String vecN[] = new String[8];
                vecN[0] = String.valueOf(a1.getN());
                vecN[1] = String.valueOf(a2.getN());
                vecN[2] = String.valueOf(a3.getN());
                vecN[3] = String.valueOf(a4.getN());
                vecN[4] = String.valueOf(a5.getN());
                vecN[5] = String.valueOf(a6.getN());
                vecN[6] = String.valueOf(a7.getN());
                vecN[7] = String.valueOf(a8.getN());
                String vecZ[] = new String[8];
                vecZ[0] = String.valueOf(a1.getZ());
                vecZ[1] = String.valueOf(a2.getZ());
                vecZ[2] = String.valueOf(a3.getZ());
                vecZ[3] = String.valueOf(a4.getZ());
                vecZ[4] = String.valueOf(a5.getZ());
                vecZ[5] = String.valueOf(a6.getZ());
                vecZ[6] = String.valueOf(a7.getZ());
                vecZ[7] = String.valueOf(a8.getZ());

                boolean we_c = cc.endradas(decode.getCond(), cc.validaN(vecN), cc.validaZ(vecZ), decode.getWe_c(), decode.getCompara());

                execute.ingresar(union, decode.getDo_B(), decode.getWe_mem(), decode.getSel_dt(), we_c, decode.getRr());
                ventana.varExecute(decode.getRr(), salida_mux, union, String.valueOf(we_c), String.valueOf(decode.getWe_mem()), decode.getDo_B());

                System.out.println("ejecuto execute");
                Thread.sleep(500);
                //********************************************
                //********************************************
                //MEMORIA
                String completo = execute.getUnion()[5].substring(5, 8) + execute.getUnion()[6] + execute.getUnion()[7]; //union[0]+union[1]+union[2]+union[3]+ union[4]+union[5]+

                memData.escribir(completo, execute.getDo_B(), execute.getWe_mem());

                String vector[] = memData.getVector(completo);

                memory.ingresar(execute.getUnion(), vector, execute.getSel_dt(), execute.getWe_c(), execute.getRr());
                ventana.varMemory(execute.getRr(), execute.getUnion(), vector, String.valueOf(execute.getWe_c()), String.valueOf(execute.getSel_dt()));
                System.out.println("ejecuto memory");
                Thread.sleep(500);
                //********************************************
                //********************************************
                //ESCRIBIR
                String esc[] = mdt.seleccioDt(memory.getUnion(), memory.getVector(), memory.getSel_dt());

                banco.escribir(memory.getRr(), esc, memory.getWe_c());
                ventana.varWrite(memory.getRr(), esc, String.valueOf(memory.getWe_c()), String.valueOf(memory.getSel_dt()));
                System.out.println("ejecuto write");
                Thread.sleep(500);

                banco.DirA("1000");

                if (banco.getDoA()[7].equals("00000001")) {

                    break;
                }

            } else {
                if (ventana.getPausa() == false) {
                    inst = memInt.getInst(pc);

                    int nuevoPc = suma32.suma(pc);
                    pc = nuevoPc;

                    ventana.varFetch(String.valueOf(pc), inst);

                    fetch.guarda(inst);

                    //********************************************
                    //********************************************
                    //DECODE  
                    uc.ingresar_valores(fetch.getOpcode(), fetch.getF());

                    banco.DirA(fetch.getRp());
                    if (fetch.getOpcode().equals("0101") || fetch.getOpcode().equals("0110")) {
                        banco.DirB(fetch.getRr());
                    } else {
                        banco.DirB(fetch.getRs());
                    }

                    ext = extend.extender(uc.getExten(), fetch.getInmediato());

                    decode.ingresar(uc.getAlu_ctrl(), uc.getSel_b(), uc.getSel_dt(), uc.getWe_c(),
                            uc.getWe_mem(), banco.getDoA(), banco.getDoB(), fetch.getRr(), ext, fetch.getOpcode(), fetch.getCond(), uc.compara());

                    ventana.varDecode(fetch.getRr(), fetch.getRp(), fetch.getRs(), fetch.getOpcode(),
                            banco.getDoA(), banco.getDoB(), String.valueOf(uc.getWe_c()), String.valueOf(uc.getWe_mem()),
                            String.valueOf(uc.getSel_b()), String.valueOf(uc.getSel_dt()), String.valueOf(Integer.parseInt(fetch.getInmediato(), 2)));

                    //********************************************
                    //********************************************
                    //EXECUTE
                    String salida_mux[] = mux.seleccion(decode.getExt(), decode.getDo_B(), decode.getSel_b());

                    String union[] = new String[8];
                    if (decode.getAlu_ctr().equals("1110")) {
                        v1 = a1.multi(decode.getDo_A(), salida_mux);
                        union[0] = v1.substring(0, 8);
                        union[1] = v1.substring(8, 16);
                        union[2] = v1.substring(16, 24);
                        union[3] = v1.substring(24, 32);
                        union[4] = v1.substring(32, 40);
                        union[5] = v1.substring(40, 48);
                        union[6] = v1.substring(48, 56);
                        union[7] = v1.substring(56, 64);
                    } else {

                        if (decode.getOpcode().equals("1101") || decode.getOpcode().equals("0101") || decode.getOpcode().equals("0110")
                                || decode.getOpcode().equals("0111") || decode.getOpcode().equals("1101")) {
                            v1 = a1.operacion("00000000", salida_mux[0], uc.getAlu_ctrl());
                            v2 = a2.operacion("00000000", salida_mux[1], uc.getAlu_ctrl());
                            v3 = a3.operacion("00000000", salida_mux[2], uc.getAlu_ctrl());
                            v4 = a4.operacion("00000000", salida_mux[3], uc.getAlu_ctrl());
                            v5 = a5.operacion("00000000", salida_mux[4], uc.getAlu_ctrl());
                            v6 = a6.operacion("00000000", salida_mux[5], uc.getAlu_ctrl());
                            v7 = a7.operacion("00000000", salida_mux[6], uc.getAlu_ctrl());
                            v8 = a8.operacion("00000000", salida_mux[7], uc.getAlu_ctrl());
                        } else {
                            v1 = a1.operacion(decode.getDo_A()[0], salida_mux[0], decode.getAlu_ctr());
                            v2 = a2.operacion(decode.getDo_A()[1], salida_mux[1], decode.getAlu_ctr());
                            v3 = a3.operacion(decode.getDo_A()[2], salida_mux[2], decode.getAlu_ctr());
                            v4 = a4.operacion(decode.getDo_A()[3], salida_mux[3], decode.getAlu_ctr());
                            v5 = a5.operacion(decode.getDo_A()[4], salida_mux[4], decode.getAlu_ctr());
                            v6 = a6.operacion(decode.getDo_A()[5], salida_mux[5], decode.getAlu_ctr());
                            v7 = a7.operacion(decode.getDo_A()[6], salida_mux[6], decode.getAlu_ctr());
                            v8 = a8.operacion(decode.getDo_A()[7], salida_mux[7], decode.getAlu_ctr());
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

                    String vecN[] = new String[8];
                    vecN[0] = String.valueOf(a1.getN());
                    vecN[1] = String.valueOf(a2.getN());
                    vecN[2] = String.valueOf(a3.getN());
                    vecN[3] = String.valueOf(a4.getN());
                    vecN[4] = String.valueOf(a5.getN());
                    vecN[5] = String.valueOf(a6.getN());
                    vecN[6] = String.valueOf(a7.getN());
                    vecN[7] = String.valueOf(a8.getN());
                    String vecZ[] = new String[8];
                    vecZ[0] = String.valueOf(a1.getZ());
                    vecZ[1] = String.valueOf(a2.getZ());
                    vecZ[2] = String.valueOf(a3.getZ());
                    vecZ[3] = String.valueOf(a4.getZ());
                    vecZ[4] = String.valueOf(a5.getZ());
                    vecZ[5] = String.valueOf(a6.getZ());
                    vecZ[6] = String.valueOf(a7.getZ());
                    vecZ[7] = String.valueOf(a8.getZ());

                    boolean we_c = cc.endradas(decode.getCond(), cc.validaN(vecN), cc.validaZ(vecZ), decode.getWe_c(), decode.getCompara());

                    execute.ingresar(union, decode.getDo_B(), decode.getWe_mem(), decode.getSel_dt(), we_c, decode.getRr());
                    ventana.varExecute(decode.getRr(), salida_mux, union, String.valueOf(we_c), String.valueOf(decode.getWe_mem()), decode.getDo_B());

                    //********************************************
                    //********************************************
                    //MEMORIA
                    String completo = execute.getUnion()[5].substring(5, 8) + execute.getUnion()[6] + execute.getUnion()[7]; //union[0]+union[1]+union[2]+union[3]+ union[4]+union[5]+

                    memData.escribir(completo, execute.getDo_B(), execute.getWe_mem());

                    String vector[] = memData.getVector(completo);

                    memory.ingresar(execute.getUnion(), vector, execute.getSel_dt(), execute.getWe_c(), execute.getRr());
                    ventana.varMemory(execute.getRr(), execute.getUnion(), vector, String.valueOf(execute.getWe_c()), String.valueOf(execute.getSel_dt()));

                    //********************************************
                    //********************************************
                    //ESCRIBIR
                    String esc[] = mdt.seleccioDt(memory.getUnion(), memory.getVector(), memory.getSel_dt());

                    banco.escribir(memory.getRr(), esc, memory.getWe_c());
                    ventana.varWrite(memory.getRr(), esc, String.valueOf(memory.getWe_c()), String.valueOf(memory.getSel_dt()));

                    banco.DirA("1000");

                    if (banco.getDoA()[7].equals("00000001")) {

                        break;
                    }
                } else {
                    System.out.println("Esta en pasua");
                }
            }
        }
        //memData.imprimir();
        imagen(memData.getMemoria(), memData.getAlto(), memData.getAncho());

    }

}
