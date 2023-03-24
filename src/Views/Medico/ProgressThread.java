package Views.Medico;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ProgressThread implements Runnable {

    private CircleProgressBar progressbar;
    private CircleProgressBar progressbar2;
    private static int num_bar = 0;
    private static int num_bar2 = 0;
    private int pacientesAtendidos = 0;
    private int numeroCamas = 0;
    static boolean bandera = true;

    public ProgressThread(int pacientesAtendidos, int numeroCamas) {
        this.pacientesAtendidos = pacientesAtendidos;
        this.numeroCamas = numeroCamas;

    }

    @Override
    public void run() {

        while (bandera) {

            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(ProgressThread.class.getName()).log(Level.SEVERE, null, ex);
            }

            {

                this.getProgressbar().setValue(num_bar + 2);
                this.getProgressbar2().setValue(num_bar2);

                if (progressbar.getValue() == 100) {

                    //progressbar.setValue(0);
                    num_bar = 0;
                }

                if (progressbar2.getValue() == 100) {

                    progressbar2.setValue(numeroCamas);
                    num_bar2 = 70;
                }

            }

            num_bar++;
            num_bar2++;
        }

    }

    public CircleProgressBar getProgressbar() {
        return progressbar;
    }

    public void setProgressbar(CircleProgressBar progressbar) {
        this.progressbar = progressbar;
    }

    public CircleProgressBar getProgressbar2() {
        return progressbar2;
    }

    public void setProgressbar2(CircleProgressBar progressbar2) {
        this.progressbar2 = progressbar2;
    }

    public static void setbandera(boolean resetbandera) {
        bandera = resetbandera;
    }

    public static void setContadores(int resetCont) {
        num_bar = resetCont;
        num_bar2 = resetCont;

    }

}
