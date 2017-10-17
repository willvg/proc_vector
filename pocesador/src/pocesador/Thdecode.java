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
public class Thdecode extends Thread {

    fetch fetch = new fetch();
    UnidadControl uc = new UnidadControl();
    bancoReg banco = new bancoReg();

    Extendido extend = new Extendido();
    String ext;
    decode decode = new decode();

    public Thdecode(fetch fet) {
        fetch = fet;
    }

    public void run(fetch fet) {
        //System.out.println("para escribir en opcode"+fet.getOpcode());
        uc.ingresar_valores(fet.getOpcode(), fet.getF());

        banco.DirA(fet.getRp());
        if (fet.getOpcode().equals("0101") || fet.getOpcode().equals("0110")) {
            banco.DirB(fet.getRr());
        } else {
            banco.DirB(fet.getRs());
        }

        ext = extend.extender(uc.getExten(), fet.getInmediato());
        fetch = fet;

        System.out.println("Inicia las impersiones:  ********************************************************");
        for (int i = 0; i < 8; i++) {
            //banco.DirA("1000");
            System.out.print("  " + banco.getDoA()[i]);
        }
        System.out.println("");
        for (int i = 0; i < 8; i++) {
            //banco.DirA("0000");
            System.out.print("  " + banco.getDoB()[i]);
        }
        System.out.println("");
        System.out.println("");
        for (int i = 0; i < 8; i++) {
            banco.DirA(fetch.getRr());
            System.out.print("  " + banco.getDoA()[i]);
        }
        //esperarXsegundos(1);
    }

    public decode getObDecode() {
        return decode;
    }

    public bancoReg getBanco() {
        return banco;
    }

    public void cambiarDireccion(String dirA) {
        banco.DirA(dirA);
    }

    public void escribirBanco(String Rr, String var[], boolean We_c) {
        //System.out.println("thWRr: " + Rr);
        //System.out.println("thWvar: " + var[5]);
        //System.out.println("thWWe_c: " + We_c);
        if(Rr!=null){
        banco.escribir(Rr, var, We_c);}
    }

    public void escribir(boolean ciclo) {
        if (ciclo == false) {
            //System.out.println("para escribir en opcode"+fetch.getOpcode());
            decode.ingresar(uc.getAlu_ctrl(), uc.getSel_b(), uc.getSel_dt(), uc.getWe_c(),
                    uc.getWe_mem(), banco.getDoA(), banco.getDoB(), fetch.getRr(), ext, fetch.getOpcode(), fetch.getCond(), uc.compara());
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
