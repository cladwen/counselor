package gui.subtabs;

import baseLib.GenericoComboBoxModel;
import baseLib.GenericoComboObject;
import baseLib.SysProperties;
import business.facades.WorldFacadeCounselor;
import control.MapaControler;
import control.OrdemControler;
import control.OrdemControlerFloater;
import control.support.ActorInterface;
import control.support.ActorInterfaceFactory;
import gui.TabBase;
import gui.services.ComponentFactory;
import gui.services.IAcaoGui;
import java.awt.Component;
import java.awt.Dimension;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.swing.GroupLayout;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableModel;
import model.Cidade;
import model.Feitico;
import model.Nacao;
import model.Ordem;
import model.Personagem;
import model.PersonagemFeitico;
import model.PersonagemOrdem;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import persistence.BundleManager;
import persistence.SettingsManager;

/**
 *
 * @author gurgel
 */
public class SubTabOrdem extends TabBase implements Serializable {

    private static final Log log = LogFactory.getLog(SubTabOrdem.class);
    private static final BundleManager labels = SettingsManager.getInstance().getBundleManager();
    private OrdemControler ordemControl;
    private OrdemControlerFloater ordemControlFloater;
    private final ComponentFactory compFactory = new ComponentFactory();
    private final List<Component> parametrosCombos = new ArrayList();
    private final List<JLabel> parametrosLabels = new ArrayList();
    private ActorInterface actor;
    private final JDialog dAjuda = new JDialog(new JFrame(), false);
    private final JDialog dOrdem = new JDialog(new JFrame(), false);
    private final SubTabTextArea stAjuda = new SubTabTextArea();
    private final IAcaoGui parentTab;

    public SubTabOrdem(IAcaoGui parentTab, MapaControler mapaControl) {
        initComponents();
        //Basico do constructor
        this.setMapaControler(mapaControl);
        setTitle(labels.getString("ACAO"));
        setDica(labels.getString("ORDERNS.TOOLTIP"));
        this.parentTab = parentTab;

        iniciaConfig();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpMaster = new javax.swing.JPanel();
        detOrdens = new javax.swing.JScrollPane();
        jpDetOrdens = new javax.swing.JPanel();
        jpOrdens = new javax.swing.JPanel();
        cbPar11 = new javax.swing.JComboBox();
        cbPar12 = new javax.swing.JComboBox();
        cbPar13 = new javax.swing.JComboBox();
        cbPar14 = new javax.swing.JComboBox();
        cbPar15 = new javax.swing.JComboBox();
        cbPar16 = new javax.swing.JComboBox();
        cbPar17 = new javax.swing.JComboBox();
        jlPar11 = new javax.swing.JLabel();
        jlPar12 = new javax.swing.JLabel();
        jlPar13 = new javax.swing.JLabel();
        jlPar14 = new javax.swing.JLabel();
        jlPar15 = new javax.swing.JLabel();
        jlPar16 = new javax.swing.JLabel();
        jlPar17 = new javax.swing.JLabel();
        cbOrdem = new javax.swing.JComboBox();
        jbOk = new javax.swing.JButton();
        jbClear = new javax.swing.JButton();
        jbDetach = new javax.swing.JToggleButton();
        jbHelp = new javax.swing.JButton();
        cbOrdersAll = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtListaOrdens = new javax.swing.JTable();

        detOrdens.setBorder(null);
        detOrdens.setToolTipText(labels.getString("PERSONAGEM.ACOES.TOOLTIP")); // NOI18N

        jpOrdens.setBorder(javax.swing.BorderFactory.createTitledBorder(labels.getString("ORDENS"))); // NOI18N
        jpOrdens.setToolTipText(labels.getString("ORDENS.TOOLTIP")); // NOI18N

        cbPar11.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbPar12.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbPar13.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbPar14.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbPar15.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbPar16.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbPar17.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jlPar11.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jlPar11.setLabelFor(cbPar11);
        jlPar11.setText("Par 01:"); // NOI18N

        jlPar12.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jlPar12.setLabelFor(cbPar12);
        jlPar12.setText("Par 02:"); // NOI18N

        jlPar13.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jlPar13.setLabelFor(cbPar13);
        jlPar13.setText("Par 03:"); // NOI18N

        jlPar14.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jlPar14.setLabelFor(cbPar14);
        jlPar14.setText("Par 04:"); // NOI18N

        jlPar15.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jlPar15.setLabelFor(cbPar15);
        jlPar15.setText("Par 05:"); // NOI18N

        jlPar16.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jlPar16.setLabelFor(cbPar16);
        jlPar16.setText("Par 06:"); // NOI18N

        jlPar17.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jlPar17.setLabelFor(cbPar17);
        jlPar17.setText("Par 07:"); // NOI18N

        cbOrdem.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jbOk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/right.gif"))); // NOI18N
        jbOk.setToolTipText(labels.getString("GRAVA.ACAO.TOOLTIP")); // NOI18N

        jbClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/erase.png"))); // NOI18N
        jbClear.setToolTipText(labels.getString("PERSONAGEM.ERASE.TOOLTIP")); // NOI18N
        jbClear.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));
        jbClear.setFocusable(false);

        jbDetach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/detach.png"))); // NOI18N
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("labels"); // NOI18N
        jbDetach.setToolTipText(bundle.getString("PERSONAGEM.DETACH.TOOLTIP")); // NOI18N
        jbDetach.setFocusable(false);
        jbDetach.setMaximumSize(new java.awt.Dimension(23, 23));
        jbDetach.setMinimumSize(new java.awt.Dimension(23, 23));
        jbDetach.setPreferredSize(new java.awt.Dimension(23, 23));

        jbHelp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/help_icon.gif"))); // NOI18N
        jbHelp.setToolTipText(labels.getString("PERSONAGEM.AJUDA.TOOLTIP")); // NOI18N
        jbHelp.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));
        jbHelp.setFocusable(false);

        cbOrdersAll.setText(labels.getString("ALL")); // NOI18N
        cbOrdersAll.setToolTipText(labels.getString("PERSONAGEM.ORDENSALL.TOOLTIP")); // NOI18N
        cbOrdersAll.setActionCommand("cbOrdersAll"); // NOI18N
        cbOrdersAll.setFocusable(false);
        cbOrdersAll.setName("cbOrdersAll"); // NOI18N

        javax.swing.GroupLayout jpOrdensLayout = new javax.swing.GroupLayout(jpOrdens);
        jpOrdens.setLayout(jpOrdensLayout);
        jpOrdensLayout.setHorizontalGroup(
            jpOrdensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpOrdensLayout.createSequentialGroup()
                .addGroup(jpOrdensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpOrdensLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jpOrdensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jlPar11, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                            .addComponent(jlPar12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlPar13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlPar14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlPar15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlPar16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlPar17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpOrdensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbPar12, 0, 1, Short.MAX_VALUE)
                            .addComponent(cbPar13, 0, 0, Short.MAX_VALUE)
                            .addComponent(cbPar14, 0, 1, Short.MAX_VALUE)
                            .addComponent(cbPar15, 0, 1, Short.MAX_VALUE)
                            .addComponent(cbPar16, 0, 1, Short.MAX_VALUE)
                            .addComponent(cbPar17, 0, 1, Short.MAX_VALUE)
                            .addComponent(cbPar11, 0, 1, Short.MAX_VALUE)))
                    .addGroup(jpOrdensLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(cbOrdem, 0, 370, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpOrdensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbOk)
                    .addComponent(cbOrdersAll)
                    .addGroup(jpOrdensLayout.createSequentialGroup()
                        .addComponent(jbHelp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbClear))
                    .addComponent(jbDetach, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jpOrdensLayout.setVerticalGroup(
            jpOrdensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpOrdensLayout.createSequentialGroup()
                .addComponent(cbOrdem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpOrdensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbPar11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlPar11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpOrdensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlPar12)
                    .addComponent(cbPar12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpOrdensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbPar13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlPar13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpOrdensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbPar14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlPar14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpOrdensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbPar15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlPar15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpOrdensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbPar16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlPar16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpOrdensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbPar17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlPar17)))
            .addGroup(jpOrdensLayout.createSequentialGroup()
                .addComponent(jbOk)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpOrdensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbClear)
                    .addComponent(jbHelp))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbDetach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(cbOrdersAll))
        );

        jScrollPane1.setBorder(null);
        jScrollPane1.setToolTipText(labels.getString("ACOES.TOOLTIP")); // NOI18N

        jtListaOrdens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Ação", "Parâmetro"
            }
        ));
        jScrollPane1.setViewportView(jtListaOrdens);

        javax.swing.GroupLayout jpDetOrdensLayout = new javax.swing.GroupLayout(jpDetOrdens);
        jpDetOrdens.setLayout(jpDetOrdensLayout);
        jpDetOrdensLayout.setHorizontalGroup(
            jpDetOrdensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpOrdens, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
        );
        jpDetOrdensLayout.setVerticalGroup(
            jpDetOrdensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDetOrdensLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpOrdens, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        detOrdens.setViewportView(jpDetOrdens);

        javax.swing.GroupLayout jpMasterLayout = new javax.swing.GroupLayout(jpMaster);
        jpMaster.setLayout(jpMasterLayout);
        jpMasterLayout.setHorizontalGroup(
            jpMasterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpMasterLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(detOrdens, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                .addGap(3, 3, 3))
        );
        jpMasterLayout.setVerticalGroup(
            jpMasterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpMasterLayout.createSequentialGroup()
                .addComponent(detOrdens, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpMaster, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpMaster, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cbOrdem;
    private javax.swing.JCheckBox cbOrdersAll;
    private javax.swing.JComboBox cbPar11;
    private javax.swing.JComboBox cbPar12;
    private javax.swing.JComboBox cbPar13;
    private javax.swing.JComboBox cbPar14;
    private javax.swing.JComboBox cbPar15;
    private javax.swing.JComboBox cbPar16;
    private javax.swing.JComboBox cbPar17;
    private javax.swing.JScrollPane detOrdens;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbClear;
    private javax.swing.JToggleButton jbDetach;
    private javax.swing.JButton jbHelp;
    private javax.swing.JButton jbOk;
    private javax.swing.JLabel jlPar11;
    private javax.swing.JLabel jlPar12;
    private javax.swing.JLabel jlPar13;
    private javax.swing.JLabel jlPar14;
    private javax.swing.JLabel jlPar15;
    private javax.swing.JLabel jlPar16;
    private javax.swing.JLabel jlPar17;
    private javax.swing.JPanel jpDetOrdens;
    private javax.swing.JPanel jpMaster;
    private javax.swing.JPanel jpOrdens;
    private javax.swing.JTable jtListaOrdens;
    // End of variables declaration//GEN-END:variables

    // FIM das Constantes para busca das chaves no banco.
    private void iniciaConfig() {
        //Cria o Controle da lista de Ordens
        ordemControl = new OrdemControler(this);
        ordemControlFloater = new OrdemControlerFloater(this);
        compFactory.setMapaControler(getMapaControler());
        compFactory.setOrdemControl(ordemControl);

        //Monta lista de parametros para usar nos replaces
        parametrosCombos.add(cbPar11);
        parametrosCombos.add(cbPar12);
        parametrosCombos.add(cbPar13);
        parametrosCombos.add(cbPar14);
        parametrosCombos.add(cbPar15);
        parametrosCombos.add(cbPar16);
        parametrosCombos.add(cbPar17);
        parametrosLabels.add(jlPar11);
        parametrosLabels.add(jlPar12);
        parametrosLabels.add(jlPar13);
        parametrosLabels.add(jlPar14);
        parametrosLabels.add(jlPar15);
        parametrosLabels.add(jlPar16);
        parametrosLabels.add(jlPar17);
        doParametrosHideAll();

        //configura grid
        jtListaOrdens.setAutoCreateColumnsFromModel(true);
        jtListaOrdens.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jtListaOrdens.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        jtListaOrdens.setAutoCreateRowSorter(true);

        //configura jDialog
        stAjuda.setFontMonospaced();
        dAjuda.add(stAjuda);
        dAjuda.setTitle(labels.getString("AJUDA"));
        dAjuda.setAlwaysOnTop(true);
        dAjuda.setPreferredSize(new Dimension(300, 600));
        dAjuda.setLocationRelativeTo(this.jtListaOrdens);
        //monta a floating window para ordens
        dOrdem.setTitle(labels.getString("ACOES.DISPONIVEL"));
        dOrdem.setAlwaysOnTop(true);
        dOrdem.setPreferredSize(new Dimension(400, 500));
        dOrdem.addComponentListener(ordemControlFloater);
        dOrdem.setName("dOrdem");

        //configs gerais das ordens
        jbOk.setActionCommand("jbOk");
        cbOrdem.setActionCommand("cbOrdem");
        cbOrdersAll.setActionCommand("cbOrdersAll");
        jbHelp.setActionCommand("jbHelp");
        jbClear.setActionCommand("jbClear");
        jbDetach.setActionCommand("jbDetach");

        doDisableFields();

        //adiciona listeners
        jtListaOrdens.getSelectionModel().addListSelectionListener(ordemControl);
        cbOrdem.addItemListener(ordemControl);
        cbOrdersAll.addItemListener(ordemControl);
        jbOk.addActionListener(ordemControl);
        cbOrdersAll.addItemListener(ordemControl);
        jbHelp.addActionListener(ordemControl);
        jbClear.addActionListener(ordemControl);
        jbDetach.addItemListener(ordemControl);

        this.setDefaultButton(jbOk);
    }

    public ActorInterface getActor() {
        return actor;
    }

    public void setActor(ActorInterface actor) {
        this.actor = actor;
    }

    private boolean isAllSelected() {
        return this.cbOrdersAll.isSelected();
    }

    private void setOrdensModel(TableModel model) {
        if (model == null) {
            jtListaOrdens.setModel(new javax.swing.table.DefaultTableModel(
                    new Object[][]{
                        {null, null},
                        {null, null},
                        {null, null}},
                    new String[]{
                        labels.getString("ACAO"), labels.getString("PARAMETRO")
                    }));
        } else {
            this.jtListaOrdens.setModel(model);
//            calcColumnWidths(jtListaOrdens);
        }
    }

    public void setOrdemParametrosQuadro(GenericoComboObject itemSelecionado) {
        //esconde todo mundo
        doParametrosHideAll();
        try {
            Ordem ordemSelecionada = (Ordem) itemSelecionado.getObject();
            GroupLayout parLayout = (GroupLayout) jpOrdens.getLayout();
            String vlParametro;
            //exibe a quantidade correta de parametros
            int qtParametroMax = ordemSelecionada.getParametrosIdeQtd();
            for (int nn = 0; nn < qtParametroMax; nn++) {
                if (ordemSelecionada.getParametroIde(nn).equalsIgnoreCase("variado")) {
                    JComboBox jcMagia = (JComboBox) parametrosCombos.get(nn - 1);
                    if ("jcMagia".equals(jcMagia.getActionCommand())) {
                        try {
                            setOrdemParametrosMagia((GenericoComboObject) jcMagia.getModel().getSelectedItem());
                        } catch (NullPointerException ex) {
                            //nao faz nada, ordens nao disponiveis...
                        }
                    }
                    continue;
                }
                //ajusta os labels
                doParametroLabel((JLabel) parametrosLabels.get(nn), ordemSelecionada.getParametroIdeDisplay(nn));
                //recupera valor display do parametro
                vlParametro = ordemControl.getParametroDisplay(nn);
                //pega parametro novo para posicao
                Component cNovo = getParametroComponent(
                        ordemSelecionada.getParametroIde(nn), vlParametro,
                        ordemSelecionada, ordemControl.getPersonagemOrdem(), nn);
                //atualiza a tela e a lista de rastreamento com o novo componente
                parLayout.replace((Component) parametrosCombos.get(nn), cNovo);
                parametrosCombos.set(nn, cNovo);
            }
            this.setLastHelp(ordemControl.getOrdemAjuda(ordemSelecionada));
            jbOk.setEnabled(true);
        } catch (NullPointerException ex) {
            doDisableFields();
            setOrdensModel(null);
        }
    }

    private Component getOrdemParametrosMagia(GenericoComboObject magiaSelecionada) {
        Component cNovo;
        try {
            Feitico magia;
            if (magiaSelecionada.getObject() instanceof Feitico) {
                magia = (Feitico) magiaSelecionada.getObject();
            } else {
                magia = ((PersonagemFeitico) magiaSelecionada.getObject()).getFeitico();
            }
            if ("None".equals(magia.getParametroChave())) {
                cNovo = compFactory.getBlank(false);
            } else if ("Variado".equals(magia.getParametroChave())) {
                //recursividade controlada.
                cNovo = doMagiaParamVariado(magia);
            } else {
                //recupera valor display do parametro da magia
                int nn = 1;
                String vlParametro = ordemControl.getParametroDisplay(nn);
                //pega parametro novo para posicao. Ordem nao importa (=null)
                cNovo = getParametroComponent(magia.getParametroChave(),
                        vlParametro, null, null, nn);
            }
        } catch (NullPointerException e) {
            cNovo = compFactory.getBlank(false);
        }
        return cNovo;
    }

    private Component doMagiaParamVariado(Feitico magia) {
        Component cNovo;
        int nn = 1;
        String vlParametro = ordemControl.getParametroDisplay(nn);
        cNovo = getParametroComponent(magia.getParametroChave(),
                vlParametro, null, null, nn);
        //Variado eh para ser usado para definir o parametro da magia.
        //ordem de magia pode ter apeans um parametro para que o get(0) funcione.
        JComboBox jcMagia = (JComboBox) parametrosCombos.get(0);
        GenericoComboObject magiaSelecionada = (GenericoComboObject) jcMagia.getModel().getSelectedItem();
        if (magiaSelecionada != null) {
            cNovo = getOrdemParametrosMagia(magiaSelecionada);
            //caso especial, ajusta label.
            if ("None".equals(magia.getParametroChave())) {
                //esconde o parametro 1
                parametrosLabels.get(1).setVisible(false);
                parametrosCombos.get(1).setVisible(false);
            } else {
                doParametroLabel((JLabel) parametrosLabels.get(1), magia.getParametroLabel());
            }
        } else {
            //nao tem parametros
            parametrosLabels.get(1).setVisible(false);
            parametrosCombos.get(1).setVisible(false);
            cNovo = compFactory.getBlank(false);
        }
        return cNovo;
    }

    public void setOrdemParametrosMagia(GenericoComboObject magiaSelecionada) {
        int nn = 1;
        GroupLayout parLayout = (GroupLayout) jpOrdens.getLayout();
        //ajusta os labels
        Feitico magia;
        if (magiaSelecionada.getObject() instanceof Feitico) {
            magia = (Feitico) magiaSelecionada.getObject();
        } else {
            magia = ((PersonagemFeitico) magiaSelecionada.getObject()).getFeitico();
        }
        if ("None".equals(magia.getParametroChave())) {
            //esconde o parametro 1
            parametrosLabels.get(nn).setVisible(false);
            parametrosCombos.get(nn).setVisible(false);
        } else {
            doParametroLabel((JLabel) parametrosLabels.get(nn), magia.getParametroLabel());
            Component cNovo = getOrdemParametrosMagia(magiaSelecionada);
            //atualiza a tela e a lista de rastreamento com o novo componente
            parLayout.replace((Component) parametrosCombos.get(nn), cNovo);
            parametrosCombos.set(nn, cNovo);
        }
    }

    public PersonagemOrdem getOrdemQuadro() throws NullPointerException {
        Ordem ordem;
        ordem = (Ordem) ((GenericoComboObject) cbOrdem.getModel().getSelectedItem()).getObject();
        List<String> parId = new ArrayList();
        List<String> parDisplay = new ArrayList();
        //adiciona a ordem na primeira posicao
        //adiciona os parametros
        for (Component parametrosCombo : parametrosCombos) {
            if (!((Component) parametrosCombo).isVisible()) {
                continue;
            }
            compFactory.getParametros(parametrosCombo, parId, parDisplay);
        }
        PersonagemOrdem po = new PersonagemOrdem();
        po.setNome(this.getActor().getNome());
        po.setOrdem(ordem);
        po.setParametrosDisplay(parDisplay);
        po.setParametrosId(parId);
        return po;
    }

    private void doParametroLabel(JLabel label, String texto) {
        label.setText(texto + ":");
        label.setVisible(true);
    }

    private void doParametrosHideAll() {
        //esconde todo mundo
        for (int nn = 0; nn < 7; nn++) {
            ((Component) parametrosCombos.get(nn)).setVisible(false);
            ((Component) parametrosLabels.get(nn)).setVisible(false);
        }
        this.getMapaControler().remMovementTag();
    }

    public void doDisplayAjuda() {
        //stAjuda.setTextBackground(new Color(236, 233, 216));
        //monta a floating window para ajuda
        dAjuda.pack();
        dAjuda.setVisible(true);
    }

    private void setLastHelp(String text) {
        this.stAjuda.setText(text);
    }

    public void doDetachOrders() {
        //change triggered by CheckBox
        if (jbDetach.isSelected()) {
            //monta a floating window para ordens
            dOrdem.add(this.jpDetOrdens);
            dOrdem.pack();
            dOrdem.setLocationRelativeTo(this.detOrdens);
            dOrdem.setVisible(true);
            this.detOrdens.repaint();
        } else {
            dOrdem.setVisible(false);
            detOrdens.setViewportView(jpDetOrdens);
        }
    }

    public void doAttachOrders() {
        //closing dialog, forced to redraw
        jbDetach.setSelected(false);
        detOrdens.setViewportView(jpDetOrdens);
    }

    public int getNextActionSlot() {
        //testa se slot next actor
        for (int ii = 0; ii < this.jtListaOrdens.getModel().getRowCount(); ii++) {
            String valueAt = (String) this.jtListaOrdens.getModel().getValueAt(ii, 0);
            if (valueAt.equals(" ")) {
                return ii;
            }
        }
        //no open slots
        return -1;
    }

    public boolean doFindNextActionSlot() {
        if (!SysProperties.getProps("AutoMoveNextAction", "1").equals("1")) {
            return false;
        }
        final int nextActionSlot = getNextActionSlot();
        //todo: testa slot em outros personagens?
        if (nextActionSlot > -1) {
//                log.fatal("muda foco aki");
            this.jtListaOrdens.getSelectionModel().setSelectionInterval(nextActionSlot, nextActionSlot);
            return true;
        }
        //sem slot aberto, entao nao faz nada
        return false;
    }

    public void setValueAt(String[] ordemDisplay, int ordIndex) {
        for (int ii = 0; ii < ordemDisplay.length; ii++) {
            this.jtListaOrdens.getModel().setValueAt(ordemDisplay[ii], ordIndex, ii);
        }
        this.jtListaOrdens.getModel().setValueAt(ordemDisplay[1].replace('[', ' ').replace(']', ' ').trim(), ordIndex, 1);
        parentTab.setValueAt(ordemDisplay, ordIndex);
    }

    public void doOrdemClear() {
        this.getMapaControler().remMovementTag();
        doDisableFields();
        setOrdemParametrosQuadro(null);
    }

    public void doMudaActor(Personagem personagem) {
        this.setActor(ActorInterfaceFactory.getInstance().getActorInterface(personagem));
        doMudaActor();
    }

    public void doMudaActor(Cidade cidade) {
        this.setActor(ActorInterfaceFactory.getInstance().getActorInterface(cidade));
        doMudaActor();
    }

    public void doMudaActor(Nacao nacao) {
        this.setActor(ActorInterfaceFactory.getInstance().getActorInterface(nacao));
        doMudaActor();
    }

    private void doMudaActor() {
        boolean allowOrders;
        try {
            allowOrders = getActor().getNacao().isAtiva();
        } catch (NullPointerException e) {
            allowOrders = false;
        }

        if (SysProperties.getProps("OverrideElimination", "0").equals("1")) {
            allowOrders = true;
        } else if (WorldFacadeCounselor.getInstance().isGameOver()
                || WorldFacadeCounselor.getInstance().isJogadorAtivoEliminado(WorldFacadeCounselor.getInstance().getJogadorAtivo())) {
            allowOrders = false;
        }

        if (allowOrders) {
            //can receive orders
            this.getMapaControler().remMovementTag();
            //ordens do actor
            setOrdensModel(getActor().getOrdemTableModel());
            //trigger selection and doMudaOrdem(0)
            if (!doFindNextActionSlot()) {
                jtListaOrdens.getSelectionModel().setSelectionInterval(0, 0);
            }
        } else {
            //eh gameover?
            //forca selecao para vazio, limpando quadro de parametros
            doOrdemClear();
        }
    }

    public void doMudaOrdem(int indexOrdem) {
        if (getActor() == null) {
            log.fatal("Ator NULO!!!!!! quem nao setou.");
        }

        this.getMapaControler().remMovementTag();
        dOrdem.setTitle(labels.getString("ACOES.DISPONIVEL") + ": " + getActor().getNome());
        GenericoComboBoxModel model = getActor().getOrdemComboModel(indexOrdem, isAllSelected());
        this.cbOrdem.setModel(model);
        doEnableFields();
        //ve qual é a ordem para deixar selecionada na combo
        int oIndex = getActor().getOrdemComboIndex(indexOrdem, model);
        if (oIndex != 0) {
            //posiciona na ordem selecionada. O listener vai montar os parametros quando selecionar.
            cbOrdem.setSelectedIndex(oIndex);
        } else {
            //monta o quadro de parametros para a primeira ordem
            setOrdemParametrosQuadro((GenericoComboObject) model.getSelectedItem());
        }

        this.cbOrdem.requestFocusInWindow();
    }

    public JTable getOrdemLista() {
        return jtListaOrdens;
    }

    private void doDisableFields() {
        //se der erro, coloca um dummy.
        this.cbOrdem.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"                                                "}));
        this.cbOrdem.setEnabled(false);
        this.cbOrdersAll.setEnabled(false);
        jbHelp.setEnabled(false);
        jbClear.setEnabled(false);
        jbDetach.setEnabled(false);
        this.setLastHelp("");
        jbOk.setEnabled(false);
        jtListaOrdens.setEnabled(false);
    }

    private void doEnableFields() {
        jtListaOrdens.setEnabled(true);
        this.cbOrdem.setEnabled(true);
        this.cbOrdersAll.setEnabled(true);
        jbHelp.setEnabled(true);
        jbClear.setEnabled(true);
        jbDetach.setEnabled(true);
    }

    private Component getParametroComponent(String controle, String vlParametro, Ordem ordemSelecionada, PersonagemOrdem ordemGravada, int nuParametro) {
        compFactory.setAllSelected(isAllSelected());
        compFactory.setActor(getActor());
//        Ordem actorOrdemGravada;
//        try {
//            actorOrdemGravada = ordemGravada.getOrdem();
//        } catch (NullPointerException ex) {
//            actorOrdemGravada = null;
//        }
        String vlDefault;
        try {
            vlDefault = ordemGravada.getParametrosId().get(nuParametro);
        } catch (Exception ex) {
            //do nothing if ANY exception happened
            vlDefault = vlParametro;
        }
        return compFactory.getParametroComponent(controle, vlParametro, vlDefault, ordemSelecionada);
    }
}
