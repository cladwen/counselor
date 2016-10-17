/*
 * TabCidadesGui.java
 *
 * Created on April 23, 2008, 11:40 AM
 */
package gui.tabs;

import baseLib.GenericoComboObject;
import business.facade.CenarioFacade;
import business.facade.CidadeFacade;
import business.facade.JogadorFacade;
import business.facades.WorldFacadeCounselor;
import control.CidadeControler;
import control.MapaControler;
import control.services.CidadeConverter;
import control.services.FiltroConverter;
import gui.TabBase;
import gui.services.IAcaoGui;
import gui.subtabs.SubTabBaseList;
import gui.subtabs.SubTabOrdem;
import gui.subtabs.SubTabTextArea;
import java.io.Serializable;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableModel;
import model.Cenario;
import model.Cidade;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import persistenceCommons.BundleManager;
import persistenceCommons.SettingsManager;
import persistence.local.WorldManager;

/**
 *
 * @author gurgel
 */
public class TabCidadesGui extends TabBase implements Serializable, IAcaoGui {

    private static final Log log = LogFactory.getLog(TabCidadesGui.class);
    private static final BundleManager labels = SettingsManager.getInstance().getBundleManager();
    private CidadeControler cidadeControl;
    private final CenarioFacade cenarioFacade = new CenarioFacade();
    private final CidadeFacade cidadeFacade = new CidadeFacade();
    private final JogadorFacade jogadorFacade = new JogadorFacade();
//    private SubTabConfigActor stRename = new SubTabConfigActor();
    private final SubTabTextArea stResults = new SubTabTextArea();
    private final SubTabBaseList stPersonagens = new SubTabBaseList();
    private final SubTabBaseList stProdutos = new SubTabBaseList();
    private SubTabOrdem stOrdens;
    private Cenario cenario;

    /**
     * Creates new form TabCidadesGui
     */
    public TabCidadesGui(String titulo, String dica, MapaControler mapaControl) {
        initComponents();
        //Basico
        setIcone("/images/cp_acampamento.gif");
        setTitle(titulo);
        setDica(dica);
        this.setMapaControler(mapaControl);
        initConfig();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        comboFiltro = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        qtCidades = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtMainLista = new javax.swing.JTable();
        detalhesCidade = new javax.swing.JTabbedPane();

        jLabel3.setText(labels.getString("LISTAR:")); // NOI18N

        comboFiltro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todos", "Próprios" }));
        comboFiltro.setName("comboFiltro"); // NOI18N

        jLabel5.setText(labels.getString("TOTAL:")); // NOI18N

        qtCidades.setText("999");

        jScrollPane3.setBorder(null);
        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jtMainLista.setAutoCreateRowSorter(true);
        jtMainLista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
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
        jtMainLista.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jtMainLista.setName(""); // NOI18N
        jtMainLista.setShowVerticalLines(false);
        jScrollPane3.setViewportView(jtMainLista);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(2, 2, 2)
                .addComponent(qtCidades))
            .addComponent(detalhesCidade, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(comboFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(qtCidades)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(detalhesCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox comboFiltro;
    private javax.swing.JTabbedPane detalhesCidade;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jtMainLista;
    private javax.swing.JLabel qtCidades;
    // End of variables declaration//GEN-END:variables

    private void initConfig() {
        cenario = WorldFacadeCounselor.getInstance().getCenario();
        stOrdens = new SubTabOrdem(this, getMapaControler());
        jtMainLista.setAutoCreateColumnsFromModel(true);
        jtMainLista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jtMainLista.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        comboFiltro.setName("comboFiltro");
        comboFiltro.setModel(FiltroConverter.getFiltroComboModelByJogador(WorldManager.getInstance().getPartida().getJogadorAtivo(), 5));
        comboFiltro.setSelectedIndex(this.getFiltroDefault());

        //Cria o Controle da lista de cidades
        cidadeControl = new CidadeControler(this);

        //adiciona listeners
        comboFiltro.addActionListener(cidadeControl);
        jtMainLista.getSelectionModel().addListSelectionListener(cidadeControl);

        TableModel model = cidadeControl.getMainTableModel((GenericoComboObject) comboFiltro.getSelectedItem());
        this.setMainModel(model);
        stResults.setFontText(detalhesCidade.getFont());
        doAddTabs();
    }

    public JTable getMainLista() {
        return jtMainLista;
    }

    public final void setMainModel(TableModel model) {
        stPersonagens.setListModelClear();
        stProdutos.setListModelClear();
        this.jtMainLista.setModel(model);
        this.calcColumnWidths(jtMainLista);
        this.updateGui();
        this.doTagHide();
        this.jtMainLista.getSelectionModel().setSelectionInterval(0, 0);
    }

    public GenericoComboObject getFiltro() {
        return (GenericoComboObject) comboFiltro.getSelectedItem();
    }

    public void updateGui() {
        this.qtCidades.setText(getMainLista().getRowCount() + "");
    }

    private void doPrintTag(Cidade cidade) {
        try {
            getMapaControler().printTag(cidade.getLocal());
        } catch (NullPointerException ex) {
            this.doTagHide();
        }
    }

    private void doAddTabs() {
        //config tabs
        if (cenarioFacade.hasOrdensCidade(cenario)) {
            detalhesCidade.addTab(labels.getString("ACAO"),
                    new javax.swing.ImageIcon(getClass().getResource("/images/right.gif")),
                    stOrdens, labels.getString("ORDERNS.TOOLTIP"));
            detalhesCidade.addTab(labels.getString("RESULTADOS"),
                    new javax.swing.ImageIcon(getClass().getResource("/images/write-document-20x20.png")),
                    stResults, labels.getString("RESULTADOS.TOOLTIP"));
        }
        if (cenarioFacade.hasResourceManagement(cenario)) {
            detalhesCidade.addTab(labels.getString("ESTOQUES"),
                    new javax.swing.ImageIcon(getClass().getResource("/images/financas.gif")),
                    stProdutos, labels.getString("ESTOQUE.TOOLTIP"));
        }
        detalhesCidade.addTab(labels.getString("PRESENCAS"),
                new javax.swing.ImageIcon(getClass().getResource("/images/hex_personagem.gif")),
                stPersonagens, labels.getString("PRESENCA.TOOLTIP"));
        if (!cenarioFacade.hasOrdensCidade(cenario)) {
            //resultados no final.
            detalhesCidade.addTab(labels.getString("RESULTADOS"),
                    new javax.swing.ImageIcon(getClass().getResource("/images/write-document-20x20.png")),
                    stResults, labels.getString("RESULTADOS.TOOLTIP"));
        }
    }

    @Override
    public void setValueAt(String[] ordemDisplay, int ordIndex) {
    }

    public void doMudaCidadeClear() {
        this.doTagHide();
        stProdutos.setListModelClear();
        stPersonagens.setListModelClear();
        stResults.setText("");
    }

    public void doMudaCidade(Cidade cidade) {
        doPrintTag(cidade);
        stProdutos.setListModel(CidadeConverter.getProdutoModel(cidade));
        stPersonagens.setListModel(CidadeConverter.getPresencasModel(cidade));
        stResults.setText(cidadeControl.getResultados(cidade));
        stOrdens.doMudaActor(cidade);
        if (jogadorFacade.isMine(cidade, WorldFacadeCounselor.getInstance().getJogadorAtivo())
                && cidadeFacade.isAtivo(cidade)) {
            //can receive orders
            stOrdens.doMudaActor(cidade);
        } else {
            //refem ou morto, nao pode dar ordem
            //forca selecao para vazio, limpando quadro de parametros
            stOrdens.doOrdemClear();
        }
    }
}
