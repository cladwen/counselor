/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.accessories;

import business.ImageManager;
import control.facade.WorldFacadeCounselor;
import gui.subtabs.SubTabDirecaoExercito;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import model.Local;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import persistenceCommons.BundleManager;
import persistenceCommons.SettingsManager;

/**
 *
 * @author jmoura
 */
public class ArmyMoveSimulator extends JFrame {

    private static final Log log = LogFactory.getLog(ArmyMoveSimulator.class);
    private static final BundleManager labels = SettingsManager.getInstance().getBundleManager();
    private Local local;

    public ArmyMoveSimulator(Local local, boolean waterMovement) {
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocal(local);
        configUi();
        int armyMoveMaxPoints = WorldFacadeCounselor.getInstance().getCenarioArmyMoveMaxPoints();
        SubTabDirecaoExercito jtabDirecao = new SubTabDirecaoExercito(local, armyMoveMaxPoints, waterMovement, WorldFacadeCounselor.getInstance().getMapaControler());
        GroupLayout parLayout = (GroupLayout) jpQuadro.getLayout();
        parLayout.replace(jPanel1, jtabDirecao);
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpQuadro = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpQuadro.setBorder(javax.swing.BorderFactory.createTitledBorder(labels.getString("ARMYMOV.ARMY.TITLE"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 261, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 292, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jpQuadroLayout = new javax.swing.GroupLayout(jpQuadro);
        jpQuadro.setLayout(jpQuadroLayout);
        jpQuadroLayout.setHorizontalGroup(
            jpQuadroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpQuadroLayout.setVerticalGroup(
            jpQuadroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpQuadro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpQuadro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jpQuadro.getAccessibleContext().setAccessibleName("Army");

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jpQuadro;
    // End of variables declaration//GEN-END:variables

    private void configUi() {
        final String title = String.format(labels.getString("ARMYMOVSIM.TITLE"), getLocal().getCoordenadas());
        setTitle(title);
        this.setIconImage(ImageManager.getInstance().getTerrainImages(getLocal().getTerreno().getCodigo()));
    }

    private Local getLocal() {
        return local;
    }

    private void setLocal(Local local) {
        this.local = local;
    }
}
