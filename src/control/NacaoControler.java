/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import baseLib.GenericoTableModel;
import control.services.NacaoConverter;
import gui.tabs.TabNacoesGui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import model.Nacao;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import persistence.BundleManager;
import persistence.SettingsManager;

/**
 *
 * @author gurgel
 */
public class NacaoControler implements Serializable, ActionListener, ListSelectionListener {

    private static final Log log = LogFactory.getLog(NacaoControler.class);
    private static final BundleManager labels = SettingsManager.getInstance().getBundleManager();
    ;
    private GenericoTableModel mainTableModel;
    private TabNacoesGui tabNacaoGui;
    private List listaExibida;

    public NacaoControler(TabNacoesGui tabGui) {
        this.tabNacaoGui = tabGui;
    }

    public GenericoTableModel getMainTableModel(int filtro) {
        listaExibida = NacaoConverter.listaByFiltro(filtro);
        this.mainTableModel = NacaoConverter.getNacaoModel(filtro);
        return this.mainTableModel;
    }

    public GenericoTableModel getRelacionamentoTableModel(Nacao nacao) {
        if (nacao == null) {
            return (null);
        } else {
            GenericoTableModel nacaoModel = NacaoConverter.getRelacionamentoModel(nacao);
            return (nacaoModel);
        }
    }

    public GenericoTableModel getTropaTableModel(Nacao nacao) {
        if (nacao == null) {
            return (null);
        } else {
            GenericoTableModel nacaoModel = NacaoConverter.getTropaModel(nacao);
            return (nacaoModel);
        }
    }

    public TabNacoesGui getTabGui() {
        return tabNacaoGui;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() instanceof JTable) {
            log.info(labels.getString("OPS.JTABLE.EVENT"));
        } else if (event.getSource() instanceof JComboBox) {
            JComboBox cb = (JComboBox) event.getSource();
            if ("comboFiltro".equals(cb.getName())) {
                getTabGui().setMainModel(getMainTableModel(cb.getSelectedIndex()));
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
                Nacao nacao = (Nacao) listaExibida.get(modelIndex);
                getTabGui().doMudaNacao(nacao);
                //PENDING atualizar table mensagens
            }
        } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            //lista vazia?
        }
    }
}