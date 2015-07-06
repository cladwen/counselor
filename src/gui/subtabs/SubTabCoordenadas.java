/*
 * SubTabTropas.java
 *
 * Created on 30/Abr/2011, 13:15:51
 */
package gui.subtabs;

import baseLib.GenericoComboBoxModel;
import baseLib.IBaseModel;
import business.MovimentoPersonagem;
import business.facade.LocalFacade;
import control.MapaControler;
import gui.TabBase;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import model.Local;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import persistence.BundleManager;
import persistence.SettingsManager;
import persistence.local.WorldManager;

/**
 *
 * @author jmoura
 */
public class SubTabCoordenadas extends TabBase implements Serializable {

    private static final Log log = LogFactory.getLog(SubTabCoordenadas.class);
    private static final BundleManager labels = SettingsManager.getInstance().getBundleManager();
    private final LocalFacade localFacade = new LocalFacade();

    public SubTabCoordenadas(String vlInicial, Local origem, int range, boolean all, boolean water, MapaControler mapaControl) {
        //water=true, lista todos os hexes, water=false, lista apenas os hexes de terra (nao agua)
        initComponents();
        //define o controler
        this.setMapaControler(mapaControl);
        //liga actionlisteners para a combo
        jcLocais.addItemListener(mapaControl);
        jcLocais.setActionCommand("Coordenadas");
        //seta model no combo do panel
        GenericoComboBoxModel cbmTemp = getCombo(origem, range, water, all);
        jcLocais.setModel(cbmTemp);
        //seleciona vlInicial como default
        if (vlInicial == null || vlInicial.equals("")) {
            vlInicial = localFacade.getCoordenadas(origem);
        }
        int index = cbmTemp.getIndexByDisplay(vlInicial);
        if (index == 0 && jcLocais.isEditable()) {
            jcLocais.insertItemAt(vlInicial, 0);
        }
        //desenha no mapa quando selecionado ou vlInicial
        jcLocais.setSelectedIndex(index);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jcLocais = new javax.swing.JComboBox();

        jcLocais.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jcLocais, 0, 208, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jcLocais)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox jcLocais;
    // End of variables declaration//GEN-END:variables

    private GenericoComboBoxModel getCombo(Local origem, int range, boolean water, boolean all) {
        //prep list
        List<MovimentoPersonagem> lista = new ArrayList<MovimentoPersonagem>(WorldManager.getInstance().getLocais().size());
        //monta a lista de locais
        for (Local local : WorldManager.getInstance().getLocais().values()) {
            if (all) {
                //verifica se ALL
                lista.add(new MovimentoPersonagem(origem, local, range, water));
            } else if (!localFacade.isAgua(local) || water) {
                //filtra os locais no range
                if (localFacade.getDistancia(origem, local) <= range) {
                    //verifica se Water
                    lista.add(new MovimentoPersonagem(origem, local, range, water));
                }
            }
        }
        GenericoComboBoxModel model = new GenericoComboBoxModel(lista.toArray(new MovimentoPersonagem[0]));
        return model;
    }

    public IBaseModel getCoordenadaSelected() {
        return (IBaseModel) jcLocais.getModel().getSelectedItem();
    }
}
