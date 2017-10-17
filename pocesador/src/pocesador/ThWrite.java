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
public class ThWrite {

    Memory memory = new Memory();
    muxdt mdt = new muxdt();
    String esc[];

    public ThWrite(Memory mem) {
        memory = mem;
    }

    public void run(Memory mem) {
        esc = mdt.seleccioDt(mem.getUnion(), mem.getVector(), mem.getSel_dt());
        memory = mem;
    }
    
    public String getRr(){
        return memory.getRr();
    }
    public String [] getvar(){
        return esc;
    }
    public boolean getWe_c(){
        return memory.getWe_c();
    }
    //public void escribir(boolean ciclo, bancoReg banco) {
    //   if (ciclo == false) {
     //       banco.escribir(memory.getRr(), esc, memory.getWe_c());
     //   }
    //}

    private void esperarXsegundos(int segundos) {
        try {
            Thread.sleep(segundos * 1000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}
