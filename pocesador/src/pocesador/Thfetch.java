/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pocesador;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author will
 */
public class Thfetch extends Thread {

    fetch fetc = new fetch();
    memoriaInst memInt = new memoriaInst();
    int pc = 0;
    sumador32 suma32 = new sumador32();
    String inst;

    public Thfetch(memoriaInst memoria) {
        memInt = memoria;
    }

    public void run() {
        inst = memInt.getInst(pc);
        //System.out.println("**************");
        //System.out.println(inst);
        //System.out.println(inst.substring(0, 4));
        int nuevoPc = suma32.suma(pc);
        pc = nuevoPc;
        //System.out.println(inst.substring);
        /*try {
            //System.out.println(fetc.getOpcode());
            //esperarXsegundos(1);
            Thread.sleep(0, 1);
        } catch (InterruptedException ex) {
            Logger.getLogger(Thfetch.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }

    public fetch getObFetch() {
        return fetc;
    }

    public void escribir(boolean ciclo) {
        if (ciclo == false) {
            System.out.println(inst);
            System.out.println(fetc.getOpcode());
            if (inst != null) {
                fetc.guarda(inst);
            }
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
