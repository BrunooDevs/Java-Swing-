package Public;

import static Public.Login.jPanel2;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.RasterFormatException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * @web http://www.jc-mouse.net/
 * @author Mouse
 */
public class Transaccion extends JPanel {

    public enum CTRL {
        NEXT,
        PREVIOUS
    }
    private CTRL option;
    private Dimension SIZE_PANEL = new Dimension(640, 680);
    private List<BufferedImage> imagenList = new ArrayList<BufferedImage>();
    private int index = 0;//imagen actual
    private Timer timer;
    private int speed = 10;//en milisegundos
    private int x = 0;
    private int y = 0;
    private int size_cut = -10;
    private boolean inTransition = false;

    private JPanel jPanel2;

    /**
     * Constructor de clase
     */
    public Transaccion(JPanel jPanel2) {

        super();
        this.jPanel2 = jPanel2;
        setSize(SIZE_PANEL);
        setVisible(true);

        //se carga imagenes en memoria
        try {
            imagenList.add(0, ImageIO.read(this.getClass().getResource("/images/1.jpg")));
            imagenList.add(1, ImageIO.read(this.getClass().getResource("/images/2.jpg")));
            imagenList.add(2, ImageIO.read(this.getClass().getResource("/images/3.jpg")));
            imagenList.add(3, ImageIO.read(this.getClass().getResource("/images/4.jpg")));
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        drawTransition(g2);
    }

    /**
     * pinta el efecto de transicion
     */
    public void drawTransition(Graphics2D g2) {
        //imagen actual
  
    try{
        
 
        g2.drawImage(imagenList.get(index), x, y, getWidth(), getHeight(), null);

        size_cut += 10;//incrementa
        if (size_cut > 0) {
            //obtiene coordenadas de recorte
            int px = getWidth() / 2 - size_cut / 2;
            int py = getHeight() / 2 - size_cut / 2;
            if (px >= 0) {
                int sindex = 0;
                if (option == CTRL.NEXT) {
                    sindex = ((index + 1) < imagenList.size()) ? index + 1 : 0;
                } else if (option == CTRL.PREVIOUS) {
                    sindex = ((index - 1) >= 0) ? index - 1 : imagenList.size() - 1;
                }
                //extrae recorte de imagen siguiente/anterior y dibuja
                BufferedImage recorte = imagenList.get(sindex).getSubimage(px, py, size_cut, size_cut);
                g2.drawImage(recorte, px, py, recorte.getWidth(), recorte.getHeight(), null);
                g2.dispose();
            } else {
                timer.stop();
                inTransition = false;
                g2.dispose();
                if (option == CTRL.NEXT) {
                    index += 1;
                    if (index >= imagenList.size()) {
                        index = 0;
                    }
                }
                if (option == CTRL.PREVIOUS) {
                    index -= 1;
                    if (index < 0) {
                        index = imagenList.size() - 1;
                    }
                }
                repaint();
                size_cut = -10;//reinicia 
            }
        }
        
           }catch (RasterFormatException e){
                  e.getMessage();
           }    

    }

    /**
     * @param CTRL option
     */
    public void play(CTRL option) {
        this.option = option;
        inTransition = !inTransition;
        ActionListener animation = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                repaint();//refresca panel
            }
        };

        if (inTransition) {
            if (timer != null) {
                timer.stop();
            }
            timer = new Timer(speed, animation);
            timer.start();
        }
        //else timer.stop();

    }
}//JPanelPPT:end
