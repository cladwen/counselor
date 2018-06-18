/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package radialMenu;

import business.ImageManager;
import business.facade.LocalFacade;
import control.MapaControler;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import model.Local;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author jmoura
 */
public class RadialMenu extends javax.swing.JPanel {

    private static final Log log = LogFactory.getLog(RadialMenu.class);
    private final List<RadialButton> rootMenu = new ArrayList<RadialButton>();
    private double initAngle = 120;
    private Local local;
    private boolean direction;
    private RmActionListener optionListener;
    private final LocalFacade localFacade = new LocalFacade();
    private SortedMap<String, Local> locais; //TODO: quando extrair a criacao dos buttons daki, retirar o locais...

    /**
     * Creates new form RadialMenu
     */
    public RadialMenu(Point canvasSize) {
        initComponents();
        initConfig(canvasSize);
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    private void initConfig(Point canvasSize) {
        //TODO: get actual width and height of the map.
        final Rectangle pos = new Rectangle(0, 0, canvasSize.x, canvasSize.y);
        this.setBounds(pos);
        this.setVisible(false);
        this.setOpaque(false);
    }

    public void addRootMenuItem(RadialButton menu) {
        getRootMenu().add(menu);
        this.add(menu);
    }

    public void doActivate(Point initialPosition) {
        //set buttons position and visible 
        updateButtons(initialPosition);
        this.setVisible(true);
    }

    private void updateButtons(Point position) {

        //TODO: falta tratamento quando menu eh direcao (nao colocar os invalidos)
        final int startAngle;
        final int totalArc;
        //check for map boundaries
        if (position.x <= 0 && position.y <= 0) {
            //upper left corner
            totalArc = 120;
            startAngle = 0;
        } else if (position.x >= this.getWidth() - ImageManager.HEX_SIZE * 2 && position.y <= 0) {
            //upper right corner
            totalArc = 120;
            startAngle = 270;
        } else if (position.x <= 0 && position.y >= this.getHeight() - ImageManager.HEX_SIZE * 2) {
            //bottom left corner
            totalArc = 120;
            startAngle = 90;
        } else if (position.x >= this.getWidth() - ImageManager.HEX_SIZE * 2 && position.y >= this.getHeight() - ImageManager.HEX_SIZE * 2) {
            //bottom right corner
            totalArc = 120;
            startAngle = 180;
        } else if (position.y <= 0) {
            //upper border
            totalArc = 180;
            startAngle = 0;
        } else if (position.y >= this.getHeight() - ImageManager.HEX_SIZE * 2) {
            //lower border
            totalArc = 180;
            startAngle = 180;
        } else if (position.x >= this.getWidth() - ImageManager.HEX_SIZE * 2) {
            //right border
            totalArc = 180;
            startAngle = 270;
        } else if (position.x <= 0) {
            //left border
            totalArc = 180;
            startAngle = 90;
        } else {
            totalArc = 360;
            startAngle = 120;
        }
        final double angularSpacing = (double) totalArc / (double) (getRootMenu().size() - 1);
        setInitAngle(startAngle);
        //set each's menu position
        for (RadialButton menu : getRootMenu()) {
            // Get current angles (in radians)
            double currentXAngle = Math.cos(Math.toRadians(getInitAngle()));
            double currentYAngle = Math.sin(Math.toRadians(getInitAngle()));
            // Get current offset coordinates
            double currentXCoordinate = ImageManager.HEX_SIZE * currentXAngle;
            double currentYCoordinate = ImageManager.HEX_SIZE * currentYAngle;
            // Position buttons around circle
            menu.setPosition(position);
            menu.setBounds(position.x + (int) currentXCoordinate,
                    position.y - (int) currentYCoordinate,
                    ImageManager.HEX_SIZE, ImageManager.HEX_SIZE);
            menu.setInitAngle(getInitAngle() - angularSpacing);
            menu.setVisible(true);
            menu.closeSubMenu();
            // Update arcs:
//            int x = this.getWidth() / 2;
//            int y = this.getHeight() / 2;
//            buttonsArcs[i].setFrame(x - 80, y - 80, 160, 160);
//            buttonsArcs[i].setAngleStart(initAngle - (angularSpacing / 2));
//            buttonsArcs[i].setAngleExtent(angularSpacing);

            setInitAngle(getInitAngle() - angularSpacing);
        }
    }

    /**
     * @return the initAngle
     */
    private double getInitAngle() {
        return initAngle;
    }

    /**
     * @param initAngle the initAngle to set
     */
    public void setInitAngle(double initAngle) {
        this.initAngle = initAngle;
    }

    public void doHide() {
        this.setVisible(false);
    }

    public void doDelete() {
        getRootMenu().clear();
        this.setVisible(false);
    }

    /**
     * @return the local
     */
    public Local getLocal() {
        return local;
    }

    /**
     * @param local the local to set
     */
    private void setLocal(Local local) {
        this.local = local;
    }

    /**
     * @return the direction
     */
    public boolean isDirection() {
        return direction;
    }

    /**
     * @param direction the direction to set
     */
    public void setDirection(boolean direction) {
        this.direction = direction;
    }

    public void setHierarchyAncestor(MapaControler grandParent) {
        for (RadialButton rb : getRootMenu()) {
            rb.setHierarchyAncestor(grandParent);
        }
    }

    public void setLocalMenu(Local local) {
        this.setLocal(local);
        for (RadialButton rb : getRootMenu()) {
            rb.setLocal(localFacade.getLocalVizinho(local, rb.getActionCommand(), getLocais()));
        }
    }

    /**
     * @return the optionListener
     */
    public RmActionListener getOptionListener() {
        return optionListener;
    }

    /**
     * @param optionListener the optionListener to set
     */
    public void setOptionListener(RmActionListener optionListener) {
        this.optionListener = optionListener;
    }

    /**
     * @return the locais
     */
    public SortedMap<String, Local> getLocais() {
        return locais;
    }

    /**
     * @param locais the locais to set
     */
    public void setLocais(SortedMap<String, Local> locais) {
        this.locais = locais;
    }

    /**
     * @return the rootMenu
     */
    public List<RadialButton> getRootMenu() {
        return rootMenu;
    }
}
