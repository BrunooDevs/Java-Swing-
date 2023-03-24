package Public;

import Views.Medico.ProgressThread;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;

public class TransaccionThread implements Runnable {

    Transaccion transaccion;
    boolean bandera;

 

    @Override
    public void run() {

        while (bandera) {

            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {

            }
        
             transaccion.play(Transaccion.CTRL.PREVIOUS); 
        }

    }

    public Transaccion getTransaccion() {
        return transaccion;
    }

    public void setTransaccion(Transaccion transaccion) {
        this.transaccion = transaccion;
    }
    
       public boolean isBandera() {
        return bandera;
    }

    public void setBandera(boolean bandera) {
        this.bandera = bandera;
    }

}
