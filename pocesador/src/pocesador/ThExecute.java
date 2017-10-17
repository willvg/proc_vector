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
public class ThExecute extends Thread {

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
    
    String union[] = new String[8];
    
    boolean we_c;
    execute execute = new execute();
    decode decode = new decode();
    CondicionControl cc = new CondicionControl();

    public ThExecute(decode dec) {
        decode = dec;
    }

    public void run(decode dec) {
        String salida_mux[] = mux.seleccion(dec.getExt(), dec.getDo_B(), dec.getSel_b());

        //for (int i = 0; i < 8; i++) {
        //   System.out.println("salida: "+salida_mux[i]);
        //    System.out.println("a: "+banco.getDoA()[i]);
        //}
        //System.out.println("alu: "+ uc.getAlu_ctrl());
        
        if (dec.getAlu_ctr().equals("1110")) {
            v1 = a1.multi(dec.getDo_A(), salida_mux);
            union[0] = v1.substring(0, 8);
            union[1] = v1.substring(8, 16);
            union[2] = v1.substring(16, 24);
            union[3] = v1.substring(24, 32);
            union[4] = v1.substring(32, 40);
            union[5] = v1.substring(40, 48);
            union[6] = v1.substring(48, 56);
            union[7] = v1.substring(56, 64);
        } else {
            for (int i = 0; i < 8; i++) {
            System.out.println("-------------------------------------------salida: "+salida_mux[i]);
               System.out.println("------------------------------------------------a: "+dec.getDo_A()[i]);
                System.out.println("------------------------------------------control: " + dec.getAlu_ctr());
            }
            if (dec.getOpcode().equals("1101") || dec.getOpcode().equals("0101") || dec.getOpcode().equals("0110")
                    || dec.getOpcode().equals("0111") || dec.getOpcode().equals("1101")) {
                v1 = a1.operacion("00000000", salida_mux[0], dec.getAlu_ctr());
                v2 = a2.operacion("00000000", salida_mux[1], dec.getAlu_ctr());
                v3 = a3.operacion("00000000", salida_mux[2], dec.getAlu_ctr());
                v4 = a4.operacion("00000000", salida_mux[3], dec.getAlu_ctr());
                v5 = a5.operacion("00000000", salida_mux[4], dec.getAlu_ctr());
                v6 = a6.operacion("00000000", salida_mux[5], dec.getAlu_ctr());
                v7 = a7.operacion("00000000", salida_mux[6], dec.getAlu_ctr());
                v8 = a8.operacion("00000000", salida_mux[7], dec.getAlu_ctr());
            } else {
                
                v1 = a1.operacion(dec.getDo_A()[0], salida_mux[0], dec.getAlu_ctr());
                v2 = a2.operacion(dec.getDo_A()[1], salida_mux[1], dec.getAlu_ctr());
                v3 = a3.operacion(dec.getDo_A()[2], salida_mux[2], dec.getAlu_ctr());
                v4 = a4.operacion(dec.getDo_A()[3], salida_mux[3], dec.getAlu_ctr());
                v5 = a5.operacion(dec.getDo_A()[4], salida_mux[4], dec.getAlu_ctr());
                v6 = a6.operacion(dec.getDo_A()[5], salida_mux[5], dec.getAlu_ctr());
                v7 = a7.operacion(dec.getDo_A()[6], salida_mux[6], dec.getAlu_ctr());
                v8 = a8.operacion(dec.getDo_A()[7], salida_mux[7], dec.getAlu_ctr());
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

        //System.out.println("N: "+ vecN[7]);
        //System.out.println("Z: "+ vecZ[7]);
        for (int i = 0; i < 8; i++) {
            System.out.println("-------------------------------------------union: "+ union[i]);
        }
        we_c = cc.endradas(dec.getCond(), cc.validaN(vecN), cc.validaZ(vecZ), dec.getWe_c(), dec.getCompara());
        
        decode = dec;
        //System.out.println("we_c: "+ we_c);
        //esperarXsegundos(1);
    }

    public execute getObExcute() {
        return execute;
    }

    public void escribir(boolean ciclo) {
        if (ciclo == false) {
            //System.out.println("para escribir en opcode"+fetch.getOpcode());
            execute.ingresar(union, decode.getDo_B(), decode.getWe_mem(), decode.getSel_dt(), we_c, decode.getRr());
        }
    }

    private void esperarXsegundos(int segundos) {
        try {
            Thread.sleep(segundos * 1000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}
