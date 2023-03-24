/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Views.Usuario;

import java.awt.Color;

public class ProgressThread implements Runnable {

    CircleProgressBar progressbar;
    CircleProgressBar progressbar2;
    CircleProgressBar progressbar3;
    static int num_bar = 0;
    static int num_bar2 = 0;
    static int num_bar3 = 0;
    int pacientesAtendidos = 0;
    int numeroCamas = 0;

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
                ex.getMessage();
            }

            {

                this.getProgressbar().setValue(num_bar + 2);
                this.getProgressbar2().setValue(num_bar2);
                this.getProgressbar3().setValue(num_bar3++);

                if (progressbar.getValue() == 100) {

                    progressbar.setValue(pacientesAtendidos);
                    num_bar = 0;
                }

                if (progressbar2.getValue() == 100) {

                    progressbar2.setValue(numeroCamas);
                    num_bar2 = 50;
                }

                if (progressbar3.getValue() == 100) {

                    progressbar3.setValue(0);
                    num_bar3 = 0;
                }

            }

            num_bar++;
            num_bar2++;
            num_bar3++;
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

    public CircleProgressBar getProgressbar3() {
        return progressbar3;
    }

    public void setProgressbar3(CircleProgressBar progressbar3) {
        this.progressbar3 = progressbar3;
    }

    public static void setbandera(boolean resetbandera) {
        bandera = resetbandera;
    }

    public static void setContadores(int resetCont) {
        num_bar = resetCont;
        num_bar2 = resetCont;
        num_bar3 = resetCont;
    }

}
