/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import baseLib.GenericoComboObject;
import baseLib.GenericoTableModel;
import control.services.ArtefatoConverter;
import gui.tabs.TabArtefatosGui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import model.Artefato;
import model.Nacao;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import persistenceCommons.BundleManager;
import persistenceCommons.SettingsManager;

/**
 *
 * @author gurgel
 */
public class ArtefatoControler implements Serializable, ActionListener, ListSelectionListener {

    private static final Log log = LogFactory.getLog(ArtefatoControler.class);
    private static final BundleManager labels = SettingsManager.getInstance().getBundleManager();
    private GenericoTableModel mainTableModel;
    private final TabArtefatosGui tabGui;
    private List listaExibida;

    public ArtefatoControler(TabArtefatosGui tabGui) {
        this.tabGui = tabGui;
    }

    public GenericoTableModel getMainTableModel(GenericoComboObject filtro) {
        try {
            final Nacao nacao = (Nacao) filtro.getObject();
            listaExibida = ArtefatoConverter.listaByNacao(nacao);
        } catch (ClassCastException e) {
            listaExibida = ArtefatoConverter.listaByFiltro(filtro.getComboId());
        }
        this.mainTableModel = ArtefatoConverter.getArtefatoModel(listaExibida);
        return this.mainTableModel;
    }

    public TabArtefatosGui getTabGui() {
        return tabGui;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() instanceof JTable) {
            log.info(labels.getString("OPS.JTABLE.EVENT"));
        } else if (event.getSource() instanceof JComboBox) {
            JComboBox cb = (JComboBox) event.getSource();
            if ("comboFiltro".equals(cb.getName())) {
                SettingsManager.getInstance().setConfigAndSaveToFile(getTabGui().getKeyFilterProperty(), cb.getSelectedIndex() + "");
                getTabGui().setMainModel(getMainTableModel((GenericoComboObject) cb.getSelectedItem()));
            }
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent event) {
        if (event.getValueIsAdjusting()) {
            return;
        }
        try {
            JTable table = this.getTabGui().getMainLista();
            ListSelectionModel lsm = (ListSelectionModel) event.getSource();
            if (!lsm.isSelectionEmpty()) {
                //testes
                int rowIndex = lsm.getAnchorSelectionIndex();
                int modelIndex = table.convertRowIndexToModel(rowIndex);
                Artefato artefato = (Artefato) listaExibida.get(modelIndex);
                getTabGui().doMudaArtefato(artefato);
                //PENDING atualizar table mensagens
            }
        } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            //lista vazia?
        }
    }
}
