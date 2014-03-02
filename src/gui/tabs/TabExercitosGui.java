/*
 * TabExercitosGui.java
 *
 * Created on April 23, 2008, 11:37 AM
 */
package gui.tabs;

import baseLib.GenericoComboObject;
import baseLib.GenericoTableModel;
import baseLib.SysProperties;
import control.ExercitoControler;
import control.MapaControler;
import control.services.ExercitoConverter;
import control.services.FiltroConverter;
import gui.TabBase;
import java.io.Serializable;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableModel;
import model.Exercito;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import persistence.BundleManager;
import persistence.SettingsManager;
import persistence.local.WorldManager;

/**
 *
 * @author gurgel
 */
public class TabExercitosGui extends TabBase implements Serializable {

    private static final Log log = LogFactory.getLog(TabExercitosGui.class);
    private static final BundleManager labels = SettingsManager.getInstance().getBundleManager();
    private ExercitoControler exercitoControl;

    /**
     * Creates new form TabExercitosGui
     */
    public TabExercitosGui(String titulo, String dica, MapaControler mapaControl) {
        initComponents();
        //Basico
        setIcone("/images/hex_exercito.gif");
        setTitle(titulo);
        setDica(dica);
        this.setMapaControler(mapaControl);
        //configura grid
        jtMainLista.setAutoCreateColumnsFromModel(true);
        jtMainLista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jtMainLista.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jtMainLista.setAutoCreateRowSorter(true);
        jtListaPelotao.setAutoCreateColumnsFromModel(true);
        jtListaPelotao.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jtListaPelotao.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jtListaPelotao.setAutoCreateRowSorter(true);
        jtListaInfos.setAutoCreateColumnsFromModel(true);
        jtListaInfos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jtListaInfos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jtListaInfos.setAutoCreateRowSorter(true);
        comboFiltro.setName("comboFiltro");
        comboFiltro.setModel(FiltroConverter.getFiltroComboModelByJogador(WorldManager.getInstance().getPartida().getJogadorAtivo(), 1));
        comboFiltro.setSelectedIndex(this.getFiltroDefault());
        //Cria o Controle da lista de exercitos
        exercitoControl = new ExercitoControler(this);

        //adiciona listeners
        comboFiltro.addActionListener(exercitoControl);
        jtMainLista.getSelectionModel().addListSelectionListener(exercitoControl);

        TableModel model = exercitoControl.getMainTableModel((GenericoComboObject) comboFiltro.getSelectedItem());
        this.setMainModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The
     * content of this method is always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        qtExercitos = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        comboFiltro = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtMainLista = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtListaPelotao = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaDetalhes = new javax.swing.JTextPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtListaInfos = new javax.swing.JTable();

        qtExercitos.setText(labels.getString("QTD")); // NOI18N

        jLabel2.setText(labels.getString("TOTAL:")); // NOI18N

        comboFiltro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todos", "Próprios" }));

        jLabel1.setText(labels.getString("LISTAR:")); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addComponent(comboFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(qtExercitos)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(qtExercitos)
                    .addComponent(jLabel2)
                    .addComponent(comboFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jtMainLista.setAutoCreateRowSorter(true);
        jtMainLista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nome", "Tamanho", "Nação", "Local", "Title 5"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jtMainLista);

        jtListaPelotao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Nome", "Treino", "Arma", "Armadura", "Quantidade", "Tipo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jtListaPelotao);

        jScrollPane1.setViewportView(listaDetalhes);

        jtListaInfos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Nome", "Valor"
            }
        ));
        jScrollPane4.setViewportView(jtListaInfos);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox comboFiltro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jtListaInfos;
    private javax.swing.JTable jtListaPelotao;
    private javax.swing.JTable jtMainLista;
    private javax.swing.JTextPane listaDetalhes;
    private javax.swing.JLabel qtExercitos;
    // End of variables declaration//GEN-END:variables

    public JTable getListaExercitos() {
        return jtMainLista;
    }

    public final void setMainModel(TableModel model) {
        setPelotaoModel(null);
        setInfoModel(null);
        this.listaDetalhes.setText("");
        this.jtMainLista.setModel(model);
        this.calcColumnWidths(jtMainLista);
        this.updateGui();
        this.doTagHide();
        this.jtMainLista.getSelectionModel().setSelectionInterval(0, 0);
    }

    private void setPelotaoModel(GenericoTableModel model) {
        if (model == null) {
            this.jtListaPelotao.setModel(new javax.swing.table.DefaultTableModel(
                    new Object[][]{
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null},
                        {null, null, null, null, null, null}},
                    new String[]{
                        labels.getString("NOME"), labels.getString("TREINO"), labels.getString("ARMA"), labels.getString("ARMADURA"), labels.getString("QT.TROPAS"), labels.getString("TIPO")
                    }));
        } else {
            this.jtListaPelotao.setModel(model);
            calcColumnWidths(jtListaPelotao);
        }
    }

    private void setInfoModel(GenericoTableModel model) {
        if (model == null) {
            jtListaInfos.setModel(new javax.swing.table.DefaultTableModel(
                    new Object[][]{
                        {null, null},
                        {null, null},
                        {null, null},
                        {null, null}},
                    new String[]{labels.getString("NOME"), labels.getString("VALOR")}));
        } else {
            this.jtListaInfos.setModel(model);
            calcColumnWidths(jtListaInfos);
        }
    }

    private void updateGui() {
        this.qtExercitos.setText(getListaExercitos().getRowCount() + "");
    }

    public void doMudaExercito(Exercito exercito) {
        try {
            getMapaControler().printTag(exercito.getLocal());
            if (SysProperties.getProps("ShowArmyMovPath", "1").equals("1")) {
                getMapaControler().printTagArmyRange(exercito);
            }
        } catch (NullPointerException ex) {
            this.doTagHide();
        }
        setPelotaoModel(exercitoControl.getPelotaoTableModel(exercito));
        setInfoModel(exercitoControl.getInfoTableModel(exercito));
        this.listaDetalhes.setText(ExercitoConverter.getDisplayDetalhes(exercito));
    }
}