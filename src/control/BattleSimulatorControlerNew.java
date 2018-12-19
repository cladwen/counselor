/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import baseLib.GenericoComboBoxModel;
import baseLib.GenericoComboObject;
import baseLib.IBaseModel;
import business.ImageManager;
import business.combat.ArmySim;
import business.converter.ConverterFactory;
import business.facade.BattleSimFacade;
import business.interfaces.IExercito;
import control.facade.WorldFacadeCounselor;
import control.services.AcaoConverter;
import control.services.CenarioConverter;
import control.services.ExercitoConverter;
import control.services.FiltroConverter;
import control.support.WindowPopupText;
import gui.accessories.BattleCasualtySimulatorNew;
import gui.accessories.TroopsCasualtiesList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;
import model.Cidade;
import model.Exercito;
import model.Nacao;
import model.Ordem;
import model.Terreno;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import persistenceCommons.BundleManager;
import persistenceCommons.SettingsManager;

/**
 *
 * @author gurgel
 */
public class BattleSimulatorControlerNew implements Serializable, ChangeListener, ListSelectionListener, ActionListener {

    private static final Log log = LogFactory.getLog(BattleSimulatorControlerNew.class);
    private static final BundleManager labels = SettingsManager.getInstance().getBundleManager();
    private final BattleCasualtySimulatorNew tabGui;
    private final List<ArmySim> listaExibida = new ArrayList<ArmySim>();
    private ArmySim exercito;
    private final BattleSimFacade combSim = new BattleSimFacade();
    private Terreno terreno;
    private int rowIndex = 0;
    private BattleSimPlatoonCasualtyControlerNew casualtyControler;

    public BattleSimulatorControlerNew(BattleCasualtySimulatorNew tabGui) {
        this.tabGui = tabGui;
    }

    public String getAjuda(Ordem ordem) {
        return AcaoConverter.getAjuda(ordem);
    }

    public BattleCasualtySimulatorNew getTabGui() {
        return tabGui;
    }

    public Terreno getTerrain() {
        return terreno;
    }

    private void setTerreno(Terreno terreno) {
        this.terreno = terreno;
    }

    public void setCasualtyControler(BattleSimPlatoonCasualtyControlerNew casualtyControler) {
        this.casualtyControler = casualtyControler;
    }

    public void doChangeTerrain(Terreno terrain) {
        setTerreno(terrain);
        this.getTabGui().setIconImage(ImageManager.getInstance().getTerrainImages(terrain.getCodigo()));
    }

    private void updateArmyCasualtyControler(ArmySim exercito, Terreno terreno) {
        if (this.casualtyControler == null) {
            //safe to ignore if not initialized
            return;
        }
        this.casualtyControler.updateArmy(exercito, terreno);
    }

    public ComboBoxModel listFiltroTactic() {
        return CenarioConverter.getInstance().getTaticaComboModel();
    }

    public GenericoComboBoxModel getNacaoComboModel() {
        List<IBaseModel> lista = new ArrayList<IBaseModel>(WorldFacadeCounselor.getInstance().getNacoes().values());
        return new GenericoComboBoxModel(lista.toArray(new IBaseModel[0]));
    }

    public TableModel getArmyListTableModel(Collection<Exercito> armies) {
        for (Exercito army : armies) {
            listaExibida.add(combSim.clone(army));
        }
        return ExercitoConverter.getBattleModel(listaExibida);
    }

    public GenericoComboBoxModel getTerrenoComboModel() {
        List<IBaseModel> lista = new ArrayList<IBaseModel>(WorldFacadeCounselor.getInstance().getCenario().getTerrenos().values());
        return new GenericoComboBoxModel(lista.toArray(new IBaseModel[0]));
    }

    private void doRemoveArmy(ArmySim army) {
        listaExibida.remove(army);
        rowIndex--;
        doRefreshArmy();
    }

    private void doCloneArmy(ArmySim army) {
        listaExibida.add(combSim.clone(army));
        rowIndex = listaExibida.size() - 1;
        doRefreshArmy();
    }

    private void doNewArmy() {
        //FIXME: needs to receive Local for the Battle to be resolved. Deal with this later. Local could be stored in GUi or Control.
        listaExibida.add(new ArmySim("Blank", getTerrain()));
        rowIndex = listaExibida.size() - 1;
        doRefreshArmy();
    }

    public void doRefreshArmy() {
        this.getTabGui().setArmyModel(ExercitoConverter.getBattleModel(listaExibida), rowIndex);
    }

    public ComboBoxModel listFiltroTypes() {
        return new GenericoComboBoxModel(FiltroConverter.listFiltroLW());
    }

    @Override
    public void stateChanged(ChangeEvent event) {
        if (event.getSource() instanceof JSlider) {
            JSlider source = (JSlider) event.getSource();
            if (!source.getValueIsAdjusting()) {
                if ("jsCityLoyalty".equals(source.getName()) || "jsCitySize".equals(source.getName()) || "jsCityFortification".equals(source.getName())) {
                    this.getTabGui().updateCityLabels();
                } else {
                    log.info(source.getName());
                }
            }
        } else if (event.getSource() instanceof JSpinner) {
            try {
                JSpinner source = (JSpinner) event.getSource();
                if ("jsArmyCommander".equals(source.getName())) {
                    exercito.setComandante((Integer) source.getValue());
                } else if ("jsArmyMorale".equals(source.getName())) {
                    exercito.setMoral((Integer) source.getValue());
                } else if ("jsArmyAbonus".equals(source.getName())) {
                    exercito.setBonusAttack((Integer) source.getValue());
                } else if ("jsArmyDbonus".equals(source.getName())) {
                    exercito.setBonusDefense((Integer) source.getValue());
                }
                doRefreshArmy();
            } catch (NullPointerException e) {
                //hex with no army
            }
        }
    }

    @Override
    public void valueChanged(ListSelectionEvent event) {
        if (event.getValueIsAdjusting()) {
            return;
        }
        try {
            ListSelectionModel lsm = (ListSelectionModel) event.getSource();
            if (lsm.isSelectionEmpty()) {
                return;
            }
            JTable table = this.getTabGui().getListaExercitos();
            rowIndex = lsm.getAnchorSelectionIndex();
            int modelIndex = table.convertRowIndexToModel(rowIndex);
            exercito = (ArmySim) listaExibida.get(modelIndex);
            getTabGui().updateArmy(exercito);
            //set short casualties list
            getTabGui().setCasualtyBorder(exercito, getTerrain());
            updateArmyCasualtyControler(exercito, getTerrain());
        } catch (IndexOutOfBoundsException ex) {
            //lista vazia?
        }
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() instanceof JTable) {
            log.info(labels.getString("OPS.JTABLE.EVENT"));
        } else if (event.getSource() instanceof JButton) {
            doActionButton(event);
        } else if (event.getSource() instanceof JComboBox) {
            actionOnTabGui(event);
        } else {
            log.info(labels.getString("OPS.GENERAL.EVENT"));
        }
    }

    protected void doActionButton(ActionEvent event) {
        JButton jbTemp = (JButton) event.getSource();
        //monta csv com as ordens
        if ("jbAbout".equals(jbTemp.getActionCommand())) {
            doAbout();
        } else if ("jbTacticHelp".equals(jbTemp.getActionCommand())) {
            doTacticHelp();
        } else if ("jbCasualtiesList".equals(jbTemp.getActionCommand())) {
            doLocalCasualties();
        } else if ("jbSimulation".equals(jbTemp.getActionCommand())) {
            doSimulation();
        } else if ("jbNewArmy".equals(jbTemp.getActionCommand())) {
            doNewArmy();
        } else if ("jbCloneArmy".equals(jbTemp.getActionCommand())) {
            doCloneArmy(exercito);
        } else if ("jbRemArmy".equals(jbTemp.getActionCommand())) {
            doRemoveArmy(exercito);
        } else {
            log.info(labels.getString("NOT.IMPLEMENTED") + jbTemp.getActionCommand());
        }
    }

    private void actionOnTabGui(ActionEvent event) {
        JComboBox jcbActive = (JComboBox) event.getSource();
        if ("jcbTerrain".equals(jcbActive.getActionCommand())) {
            try {
                final GenericoComboObject obj = (GenericoComboObject) jcbActive.getModel().getSelectedItem();
                final Terreno terrain = (Terreno) obj.getObject();
                for (ArmySim army : listaExibida) {
                    army.setTerreno(terrain);
                }
                doRefreshArmy();
                this.doChangeTerrain(terrain);
                getTabGui().setCasualtyBorder(exercito, terrain);
                //set short casualties list
                updateArmyCasualtyControler(exercito, getTerrain());
            } catch (NullPointerException ex) {
            }
        } else if ("cbTactic".equals(jcbActive.getActionCommand())) {
            final GenericoComboObject tactic = (GenericoComboObject) jcbActive.getModel().getSelectedItem();
            if (exercito != null) {
                exercito.setTatica(ConverterFactory.taticaToInt(tactic.getComboId()));
            }
            doRefreshArmy();
            updateArmyCasualtyControler(exercito, getTerrain());
        } else if ("cbNation".equals(jcbActive.getActionCommand())) {
            final GenericoComboObject nation = (GenericoComboObject) jcbActive.getModel().getSelectedItem();
            if (exercito != null) {
                exercito.setNacao((Nacao) nation.getObject());
            }
            doRefreshArmy();
            updateArmyCasualtyControler(exercito, getTerrain());
        } else if ("comboFiltro".equals(jcbActive.getActionCommand())) {
            updateArmyCasualtyControler(exercito, getTerrain());
        } else {
            log.info(String.format("actionOnTabGui %s %s", jcbActive.getActionCommand(), jcbActive.getName()));
        }
    }

    private void doAbout() {
        //Launch popup window with BatleSim disclaimer
        WindowPopupText.showWindowText(labels.getString("BATTLESIM.DISCLAIMER.TEXT"), labels.getString("BATTLESIM.DISCLAIMER.TITLE"), this.getTabGui());
    }

    private void doTacticHelp() {
        //launch tactics bonuses in a new window
        WindowPopupText.showWindowTable(CenarioConverter.getInstance().getTaticaTableModel(), labels.getString("BATTLESIM.TATICA.HINT"), this.getTabGui());

    }

    private void doLocalCasualties() {
        //TODO: implement this with Terreno, not Local
        TroopsCasualtiesList casualtiesSim = new TroopsCasualtiesList(getTerrain());
        casualtiesSim.setLocationRelativeTo(this.getTabGui());
        casualtiesSim.setVisible(true);
    }

    private void doSimulation() {
        //put results in a new window.
        //clone the army so that we can run multiple simulations without changing the BattleSim

        //FIXME: to start, all armies attack the city.
        doCombatCity();
    }

    private void doCombatCity() {
        //FIXME: add Cidade to GUI (as opposed to labels) and Controler
        final Cidade city = new Cidade();
        city.setTamanho(4);
        city.setFortificacao(1);
        city.setLealdade(50);
        CombatManagerCity cbm = new CombatManagerCity(city);
        for (IExercito army : listaExibida) {
            //clone the army so that we can run multiple simulations without changing the BattleSim
            cbm.addArmy(new ArmySim((ArmySim) army));
        }
        cbm.setTerrain(getTerrain());
        cbm.doCombat(0);
    }
}
