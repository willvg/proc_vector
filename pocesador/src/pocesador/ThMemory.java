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
public class ThMemory extends Thread {
    execute execute = new execute();

    Memory memory = new Memory();
    String completo;
    String vector[];
    
    memoriaDatos memData = new memoriaDatos();

    public ThMemory(execute exe, memoriaDatos mem) {
        execute = exe;
        memData = mem;
    }

    public void run(execute exe, memoriaDatos men) {
        completo = exe.getUnion()[5].substring(5, 8) + exe.getUnion()[6] + exe.getUnion()[7]; //union[0]+union[1]+union[2]+union[3]+ union[4]+union[5]+

        men.escribir(completo, exe.getDo_B(), exe.getWe_mem());

        vector = men.getVector(completo);
        execute = exe;
    }

    public Memory getObMemoria() {
        return memory;
    }
    
    public memoriaDatos getObMemDatos() {
        return memData;
    }



    public void escribir(boolean ciclo) {
        if (ciclo == false) {
            //System.out.println(inst);
            //System.out.println(fetc.getOpcode());
             memory.ingresar(execute.getUnion(), vector, execute.getSel_dt(), execute.getWe_c(), execute.getRr());
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
