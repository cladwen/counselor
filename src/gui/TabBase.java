/*
 * TabBase.java
 *
 * Created on April 24, 2008, 10:28 PM
 */
package gui;

import control.MapaControler;
import gui.services.ColumnWidthsAdjuster;
import gui.services.LocalTableCellRenderer;
import java.io.Serializable;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import model.Local;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import persistenceCommons.BundleManager;
import persistenceCommons.SettingsManager;
import persistenceCommons.SysApoio;

/**
 *
 * @author gurgel
 */
public class TabBase extends javax.swing.JRootPane implements Serializable {

    private static final Log log = LogFactory.getLog(TabBase.class);
    private static final BundleManager labels = SettingsManager.getInstance().getBundleManager();
    private String dica;
    private String title;
    private ImageIcon icone;
    private MapaControler mapaControler;
    private int filtroDefault = 0;

    /**
     * Creates new form TabBase
     */
    public TabBase() {
        initComponents();
        int vlFiltro = SysApoio.parseInt(SettingsManager.getInstance().getConfig("filtro.default"));
        //se diferente de 1e0,provavelmente eh um valor invalido, ou chave nao encontrada.
        if (vlFiltro != 1) {
            vlFiltro = 0;
        }
        this.filtroDefault = vlFiltro;
    }

    public int getFiltroDefault() {
        return filtroDefault;
    }

    public String getDica() {
        return dica;
    }

    public void setDica(String toolTip) {
        this.dica = toolTip;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ImageIcon getIcone() {
        return icone;
    }

    public void setIcone(String iconeName) {
        try {
            this.icone = new ImageIcon(getClass().getResource(iconeName));
        } catch (NullPointerException ex) {
        }
    }

    public MapaControler getMapaControler() {
        return this.mapaControler;
    }

    protected void setMapaControler(MapaControler mapaControl) {
        this.mapaControler = mapaControl;
    }

    public void doTagHide() {
        this.mapaControler.getTabGui().hidefocusTag();
    }

    protected void calcColumnWidths(JTable table) {
        if (SettingsManager.getInstance().isTableColumnAdjust()) {
            final ColumnWidthsAdjuster cwa = new ColumnWidthsAdjuster();
            cwa.calcColumnWidths(table);
        }
        if (this.mapaControler != null) {
            table.setDefaultRenderer(Local.class, new LocalTableCellRenderer(this.mapaControler, table));
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
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

    protected DefaultComboBoxModel getDefaultComboBoxModelTodosProprio() {
        return new DefaultComboBoxModel(new String[]{labels.getString("FILTRO.TODOS"), labels.getString("FILTRO.PROPRIOS")});
    }
}
