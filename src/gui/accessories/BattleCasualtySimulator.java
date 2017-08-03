/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.accessories;

import baseLib.GenericoComboBoxModel;
import business.facade.CidadeFacade;
import business.facade.LocalFacade;
import control.BattleSimulatorControler;
import control.CasualtyControler;
import control.support.IBattleSimulator;
import gui.services.ColumnWidthsAdjuster;
import gui.subtabs.SubTabCasualtyGui;
import java.util.Hashtable;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableModel;
import model.Cidade;
import model.ExercitoSim;
import model.Local;
import model.Terreno;
import persistenceCommons.BundleManager;
import persistenceCommons.SettingsManager;

/**
 *
 * @author jmoura
 */
public class BattleCasualtySimulator extends JFrame implements IBattleSimulator {

    private static final BundleManager labels = SettingsManager.getInstance().getBundleManager();
    private final LocalFacade localFacade = new LocalFacade();
    private final CidadeFacade cidadeFacade = new CidadeFacade();
    private final BattleSimulatorControler battleSimControler;

    public BattleCasualtySimulator(Local local) {
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        battleSimControler = new BattleSimulatorControler(this);
        battleSimControler.doChangeTerrain(local.getTerreno());
        setLocal(local);
        configUI(local);
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpCity = new javax.swing.JPanel();
        jlLoyalty = new javax.swing.JLabel();
        jlSize = new javax.swing.JLabel();
        jlFortification = new javax.swing.JLabel();
        jlDefense = new javax.swing.JLabel();
        jsLoyalty = new javax.swing.JSlider();
        jsSize = new javax.swing.JSlider();
        jsFortification = new javax.swing.JSlider();
        jpArmies = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtArmyList = new javax.swing.JTable();
        jpOptions = new javax.swing.JPanel();
        jcbTerrain = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jsCommander = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        jsMorale = new javax.swing.JSpinner();
        jlHint = new javax.swing.JLabel();
        jpQuadro = new javax.swing.JPanel();
        jpPlaceholder = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpCity.setBorder(javax.swing.BorderFactory.createTitledBorder(labels.getString("BATTLESIM.CITY.TITLE"))); // NOI18N

        jlLoyalty.setText(labels.getString("LEALDADE")); // NOI18N

        jlSize.setText(labels.getString("TAMANHO")); // NOI18N

        jlFortification.setText(labels.getString("FORTIFICACOES")); // NOI18N

        jlDefense.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jlDefense.setText(labels.getString("CIDADE.DEFESA")); // NOI18N

        jsLoyalty.setMajorTickSpacing(10);
        jsLoyalty.setMinimum(1);
        jsLoyalty.setMinorTickSpacing(5);
        jsLoyalty.setPaintTicks(true);
        jsLoyalty.setValue(1);
        jsLoyalty.setName("jsLoyalty"); // NOI18N

        jsSize.setMajorTickSpacing(1);
        jsSize.setMaximum(5);
        jsSize.setPaintLabels(true);
        jsSize.setPaintTicks(true);
        jsSize.setSnapToTicks(true);
        jsSize.setValue(0);
        jsSize.setName("jsSize"); // NOI18N

        jsFortification.setMajorTickSpacing(1);
        jsFortification.setMaximum(5);
        jsFortification.setPaintLabels(true);
        jsFortification.setPaintTicks(true);
        jsFortification.setSnapToTicks(true);
        jsFortification.setValue(0);
        jsFortification.setName("jsFortification"); // NOI18N

        javax.swing.GroupLayout jpCityLayout = new javax.swing.GroupLayout(jpCity);
        jpCity.setLayout(jpCityLayout);
        jpCityLayout.setHorizontalGroup(
            jpCityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jsFortification, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
            .addComponent(jsSize, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jsLoyalty, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jpCityLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpCityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlSize, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlDefense, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlFortification, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlLoyalty, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jpCityLayout.setVerticalGroup(
            jpCityLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpCityLayout.createSequentialGroup()
                .addComponent(jlDefense)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlLoyalty)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jsLoyalty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlSize)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jsSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlFortification)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jsFortification, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jpArmies.setBorder(javax.swing.BorderFactory.createTitledBorder(labels.getString("BATTLESIM.ARMIES.TITLE"))); // NOI18N

        jScrollPane1.setBorder(null);

        jtArmyList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jtArmyList);

        javax.swing.GroupLayout jpArmiesLayout = new javax.swing.GroupLayout(jpArmies);
        jpArmies.setLayout(jpArmiesLayout);
        jpArmiesLayout.setHorizontalGroup(
            jpArmiesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE)
        );
        jpArmiesLayout.setVerticalGroup(
            jpArmiesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpArmiesLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        jpOptions.setBorder(javax.swing.BorderFactory.createTitledBorder(labels.getString("BATTLESIM.ARMY.TITLE"))); // NOI18N

        jcbTerrain.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setText(labels.getString("COMANDANTE")); // NOI18N

        jsCommander.setModel(new javax.swing.SpinnerNumberModel(0, 0, 1000, 1));
        jsCommander.setName("jsCommander"); // NOI18N

        jLabel2.setText(labels.getString("MORAL")); // NOI18N

        jsMorale.setModel(new javax.swing.SpinnerNumberModel(0, 0, 1000, 1));
        jsMorale.setName("jsMorale"); // NOI18N

        jlHint.setText("jLabel3");

        javax.swing.GroupLayout jpOptionsLayout = new javax.swing.GroupLayout(jpOptions);
        jpOptions.setLayout(jpOptionsLayout);
        jpOptionsLayout.setHorizontalGroup(
            jpOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpOptionsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlHint, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jcbTerrain, 0, 186, Short.MAX_VALUE)
                    .addGroup(jpOptionsLayout.createSequentialGroup()
                        .addGroup(jpOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jpOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jsMorale)
                            .addComponent(jsCommander))
                        .addContainerGap())))
        );
        jpOptionsLayout.setVerticalGroup(
            jpOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpOptionsLayout.createSequentialGroup()
                .addComponent(jcbTerrain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jsCommander, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpOptionsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jsMorale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                .addComponent(jlHint, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jpQuadro.setBorder(javax.swing.BorderFactory.createTitledBorder(labels.getString("TROOPCASUALTIES.BORDER.TITLE"))); // NOI18N

        javax.swing.GroupLayout jpPlaceholderLayout = new javax.swing.GroupLayout(jpPlaceholder);
        jpPlaceholder.setLayout(jpPlaceholderLayout);
        jpPlaceholderLayout.setHorizontalGroup(
            jpPlaceholderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 381, Short.MAX_VALUE)
        );
        jpPlaceholderLayout.setVerticalGroup(
            jpPlaceholderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 345, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jpQuadroLayout = new javax.swing.GroupLayout(jpQuadro);
        jpQuadro.setLayout(jpQuadroLayout);
        jpQuadroLayout.setHorizontalGroup(
            jpQuadroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpPlaceholder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpQuadroLayout.setVerticalGroup(
            jpQuadroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpPlaceholder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jpCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jpOptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jpArmies, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpQuadro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jpQuadro, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jpCity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jpOptions, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jpArmies, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(2, 2, 2))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox jcbTerrain;
    private javax.swing.JLabel jlDefense;
    private javax.swing.JLabel jlFortification;
    private javax.swing.JLabel jlHint;
    private javax.swing.JLabel jlLoyalty;
    private javax.swing.JLabel jlSize;
    private javax.swing.JPanel jpArmies;
    private javax.swing.JPanel jpCity;
    private javax.swing.JPanel jpOptions;
    private javax.swing.JPanel jpPlaceholder;
    private javax.swing.JPanel jpQuadro;
    private javax.swing.JSpinner jsCommander;
    private javax.swing.JSlider jsFortification;
    private javax.swing.JSlider jsLoyalty;
    private javax.swing.JSpinner jsMorale;
    private javax.swing.JSlider jsSize;
    private javax.swing.JTable jtArmyList;
    // End of variables declaration//GEN-END:variables

    private void setLocal(Local local) {
        final String title = String.format(labels.getString("BATTLECAUSUALITYSIM.TITLE"), local.getCoordenadas());
        setTitle(title);
        setCidade(local);
        setArmy(local);
    }

    /**
     * set initial values from city
     *
     * @param local
     */
    private void setCidade(Local local) {
        if (!localFacade.isCidade(local)) {
            return;
        }
        final Cidade city = localFacade.getCidade(local);
        jsLoyalty.setValue(cidadeFacade.getLealdade(city));
        jsSize.setValue(cidadeFacade.getTamanho(city));
        jsFortification.setValue(cidadeFacade.getFortificacao(city));

        jpCity.setBorder(javax.swing.BorderFactory.createTitledBorder(
                String.format("%s: %s", labels.getString("BATTLESIM.CITY.TITLE"),
                        cidadeFacade.getNomeCoordenada(city))));
        updateCityLabels();
    }

    @Override
    public void updateCityLabels() {
        jlLoyalty.setText(String.format("%s: %s",
                labels.getString("LEALDADE"),
                jsLoyalty.getValue()));

        jlSize.setText(String.format("%s: %s", labels.getString("TAMANHO"), cidadeFacade.getTamanhoNome(jsSize.getValue())));

        jlFortification.setText(String.format("%s: %s", labels.getString("FORTIFICACOES"),
                cidadeFacade.getFortificacaoNome(jsFortification.getValue())));

        jlDefense.setText(String.format("%s: %s", labels.getString("CIDADE.DEFESA"),
                cidadeFacade.getDefesa(jsSize.getValue(), jsFortification.getValue(), jsLoyalty.getValue())));
    }

    private void configCitySliders() {
        jsLoyalty.addChangeListener(battleSimControler);
        jsSize.addChangeListener(battleSimControler);
        jsFortification.addChangeListener(battleSimControler);

        Hashtable sizeLabels = new Hashtable();
        for (int ii = jsSize.getMinimum(); ii < jsSize.getMaximum(); ii++) {
            sizeLabels.put(ii, new JLabel(cidadeFacade.getTamanhoNome(ii)));
        }
        jsSize.setLabelTable(sizeLabels);
        jsSize.setPaintLabels(true);

        Hashtable fortLabels = new Hashtable();
        for (int ii = jsFortification.getMinimum(); ii < jsFortification.getMaximum(); ii++) {
            fortLabels.put(ii, new JLabel(cidadeFacade.getFortificacaoNome(ii)));
        }
        jsFortification.setLabelTable(fortLabels);
        jsFortification.setPaintLabels(true);
    }

    private void setArmy(Local local) {
        if (localFacade.getExercitos(local).isEmpty()) {
            return;
        }
        final TableModel model = battleSimControler.getArmyListTableModel(localFacade.getExercitos(local).values());
        this.setArmyModel(model, 0);
    }

    private void configUI(Local local) {
        jlHint.setText(labels.getString("BATTLECAUSUALITYSIM.HINT"));

        configCitySliders();
        jsCommander.addChangeListener(battleSimControler);
        jsMorale.addChangeListener(battleSimControler);
        jcbTerrain.setActionCommand("jcbTerrain");
        final GenericoComboBoxModel terrenoComboModel = battleSimControler.getTerrenoComboModel();
        jcbTerrain.setModel(terrenoComboModel);
        final int index = terrenoComboModel.getIndexByDisplay(local.getTerreno().getComboDisplay());
        this.jcbTerrain.setSelectedIndex(index);
        this.jcbTerrain.setMaximumRowCount(terrenoComboModel.getSize());
        jcbTerrain.addActionListener(battleSimControler);

        jtArmyList.setAutoCreateColumnsFromModel(true);
        jtArmyList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jtArmyList.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jtArmyList.getSelectionModel().addListSelectionListener(battleSimControler);

        //create and link controlers
        final CasualtyControler casualtyControler = new CasualtyControler(local);
        battleSimControler.setCasualtyControler(casualtyControler);

        //add component to UI
        SubTabCasualtyGui jtabMain = new SubTabCasualtyGui(local, casualtyControler);
        GroupLayout parLayout = (GroupLayout) jpQuadro.getLayout();
        parLayout.replace(jpPlaceholder, jtabMain);

        //select first army to load titles
        this.jtArmyList.setRowSelectionInterval(0, 0);
    }

    @Override
    public void setCasualtyBorder(ExercitoSim exercito, Terreno terrain) {
        //config border
        final String title;
        if (exercito != null) {
            title = String.format(labels.getString("TROOPCASUALTIES.COMMANDER.TITLE"), exercito.getNome(), terrain.getNome());
        } else {
            title = labels.getString("TROOPCASUALTIES.BORDER.TITLE");
        }
        jpQuadro.setBorder(javax.swing.BorderFactory.createTitledBorder(title));
    }

    @Override
    public final void setArmyModel(TableModel model, int selected) {
        this.jtArmyList.setModel(model);
        final ColumnWidthsAdjuster cwa = new ColumnWidthsAdjuster();
        cwa.calcColumnWidths(jtArmyList);
        this.jtArmyList.getSelectionModel().setSelectionInterval(0, 0);
        this.jtArmyList.setRowSelectionInterval(selected, selected);
    }

    @Override
    public JTable getListaExercitos() {
        return jtArmyList;
    }

    @Override
    public void updateArmy(ExercitoSim exercito) {
        jsMorale.removeChangeListener(battleSimControler);
        jsCommander.removeChangeListener(battleSimControler);
        jsMorale.setValue(exercito.getMoral());
        jsCommander.setValue(exercito.getPericiaComandante());
        jsMorale.addChangeListener(battleSimControler);
        jsCommander.addChangeListener(battleSimControler);
    }
}
