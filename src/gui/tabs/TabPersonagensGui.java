/*
 * TabPersonagensGui.java
 *
 * Created on April 23, 2008, 11:37 AM
 */
package gui.tabs;

import baseLib.GenericoComboObject;
import business.ImageManager;
import business.facade.JogadorFacade;
import business.facade.PersonagemFacade;
import business.facades.WorldFacadeCounselor;
import control.MapaControler;
import control.PersonagemControler;
import control.services.FiltroConverter;
import control.services.PersonagemConverter;
import gui.TabBase;
import gui.services.IAcaoGui;
import gui.subtabs.SubTabBaseList;
import gui.subtabs.SubTabOrdem;
import gui.subtabs.SubTabPopup;
import java.io.Serializable;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import javax.swing.BoxLayout;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableModel;
import model.ActorAction;
import model.Personagem;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import persistence.local.WorldManager;
import persistenceCommons.BundleManager;
import persistenceCommons.SettingsManager;

/**
 *
 * @author gurgel
 */
public class TabPersonagensGui extends TabBase implements Serializable, IAcaoGui {

    private static final Log log = LogFactory.getLog(TabPersonagensGui.class);
    private static final BundleManager labels = SettingsManager.getInstance().getBundleManager();
    private PersonagemControler personagemControl;
    private final PersonagemFacade personagemFacade = new PersonagemFacade();
    private final JogadorFacade jogadorFacade = new JogadorFacade();
    private Personagem personagemAtivo;
    private final SubTabPopup stResults = new SubTabPopup();
    private final SubTabBaseList stMagicItems = new SubTabBaseList();
    private final SubTabBaseList stSpells = new SubTabBaseList();
    private SubTabOrdem stOrdens;
    private final boolean showPortrait = SettingsManager.getInstance().isConfig("ShowCharacterPortraits", "1", "0"); //must be initialized BEFORE initComponents();

    /**
     * Creates new form TabPersonagensGui
     */
    public TabPersonagensGui(String titulo, String dica, MapaControler mapaControl) {
        initComponents();
        //Basico do constructor
        this.setMapaControler(mapaControl);
        setIcone("/images/hex_personagem.gif");
        setTitle(titulo);
        setDica(dica);

        iniciaConfig();

        if (showPortrait) {
            ImageManager.getInstance().doLoadPortraits();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpMaster = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        comboFiltro = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        qtPersonagens = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtMainLista = new javax.swing.JTable();
        detalhesPersonagem = new javax.swing.JTabbedPane();
        portraitPanel = new javax.swing.JPanel();

        jLabel3.setLabelFor(comboFiltro);
        jLabel3.setText(labels.getString("LISTAR:")); // NOI18N

        comboFiltro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todos", "Próprios" }));

        jLabel2.setLabelFor(qtPersonagens);
        jLabel2.setText(labels.getString("TOTAL:")); // NOI18N

        qtPersonagens.setText(labels.getString("QTD")); // NOI18N

        jScrollPane3.setBorder(null);
        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane3.setMaximumSize(new java.awt.Dimension(200, 600));
        jScrollPane3.setOpaque(false);
        jScrollPane3.setPreferredSize(new java.awt.Dimension(200, 200));

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
        jtMainLista.setName(""); // NOI18N
        jScrollPane3.setViewportView(jtMainLista);

        portraitPanel.setFocusable(false);
        portraitPanel.setPreferredSize(new java.awt.Dimension(140, 250));

        javax.swing.GroupLayout portraitPanelLayout = new javax.swing.GroupLayout(portraitPanel);
        portraitPanel.setLayout(portraitPanelLayout);
        portraitPanelLayout.setHorizontalGroup(
            portraitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 140, Short.MAX_VALUE)
        );
        portraitPanelLayout.setVerticalGroup(
            portraitPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
        );

        portraitPanel.setVisible(showPortrait);

        javax.swing.GroupLayout jpMasterLayout = new javax.swing.GroupLayout(jpMaster);
        jpMaster.setLayout(jpMasterLayout);
        jpMasterLayout.setHorizontalGroup(
            jpMasterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpMasterLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(qtPersonagens, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpMasterLayout.createSequentialGroup()
                .addComponent(portraitPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(detalhesPersonagem))
            .addGroup(jpMasterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jpMasterLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel3)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(comboFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(75, Short.MAX_VALUE)))
        );
        jpMasterLayout.setVerticalGroup(
            jpMasterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpMasterLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpMasterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(qtPersonagens)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpMasterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(detalhesPersonagem)
                    .addComponent(portraitPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(jpMasterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jpMasterLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jpMasterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(comboFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(382, Short.MAX_VALUE)))
        );

        detalhesPersonagem.getAccessibleContext().setAccessibleName("Ações");

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
    private javax.swing.JComboBox comboFiltro;
    private javax.swing.JTabbedPane detalhesPersonagem;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel jpMaster;
    private javax.swing.JTable jtMainLista;
    private javax.swing.JPanel portraitPanel;
    private javax.swing.JLabel qtPersonagens;
    // End of variables declaration//GEN-END:variables
    // FIM das Constantes para busca das chaves no banco.

    private void iniciaConfig() {
        //Cria o Controle da lista de Personagem
        personagemControl = new PersonagemControler(this);

        stOrdens = new SubTabOrdem(this, getMapaControler());

        //configura grid de personagens
        comboFiltro.setName("comboFiltro");
        comboFiltro.setModel(FiltroConverter.getFiltroComboModelByJogador(WorldManager.getInstance().getPartida().getJogadorAtivo(), 2));
        comboFiltro.setSelectedIndex(this.getFiltroDefault());
        jtMainLista.setAutoCreateColumnsFromModel(true);
        jtMainLista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jtMainLista.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jtMainLista.setAutoCreateRowSorter(true);

        //adiciona listeners
        comboFiltro.addActionListener(personagemControl);
        jtMainLista.getSelectionModel().addListSelectionListener(personagemControl);

        doAddTabs();
        doLoadChars();
    }

    public Personagem getPersonagem() {
        return personagemAtivo;
    }

    public void setPersonagem(Personagem personagem) {
        this.personagemAtivo = personagem;
    }

    public JTable getMainLista() {
        return jtMainLista;
    }

    /*
     * recebe o valor do filtro, capturado pelo controler
     */
    public void setMainModel(TableModel model) {
        this.jtMainLista.setModel(model);
        this.doConfigTableColumns(jtMainLista);
        this.doTagHide();
        this.qtPersonagens.setText(getMainLista().getRowCount() + "");
        //seta primeira linha da tablemaster como selecionado e forca a carga dos detalhes.
        this.jtMainLista.getSelectionModel().setSelectionInterval(0, 0);
    }

    @Override
    public void setValueAt(ActorAction actorAction, int ordIndex) {
        this.jtMainLista.getModel().setValueAt(actorAction,
                personagemControl.getModelRowIndex(),
                PersonagemConverter.ORDEM_COL_INDEX_START + ordIndex);
    }

    public void doLoadChars() {
        //carrega a lista de personagens
        TableModel model = personagemControl.getMainTableModel((GenericoComboObject) comboFiltro.getSelectedItem());
        this.setMainModel(model);
    }

    public void doPersonagemClear() {
        this.doTagHide();
        stOrdens.doOrdemClear();
    }

    private void doConfigTabs() {
        final String popupTitle = labels.getString("RESULTADOS.OF") + ": " + personagemControl.getNome();
        stResults.setText(popupTitle, personagemControl.getResultado());
        doTabMagicItem();
        doTabSpells();
    }

    private void doTabSpells() {
        if (personagemFacade.isMago(personagemAtivo)) {
            stSpells.setListModel(personagemControl.getFeiticoTableModel());
        } else {
            stSpells.setListModelClear();
        }
    }

    private void doTabMagicItem() {
        if (personagemFacade.hasArtefatos(getPersonagem())) {
            stMagicItems.setListModel(personagemControl.getArtefatoTableModel());
            detalhesPersonagem.addTab(labels.getString("ARTEFATOS"),
                    new javax.swing.ImageIcon(getClass().getResource("/images/hex_artefato.gif")),
                    stMagicItems, labels.getString("ARTEFATOS.TOOLTIP"));
        } else {
            detalhesPersonagem.remove(stMagicItems);
        }
    }

    private void doAddTabs() {
        //config tabs
        stResults.setFontText(detalhesPersonagem.getFont());
        detalhesPersonagem.addTab(labels.getString("ACAO"),
                new javax.swing.ImageIcon(getClass().getResource("/images/hex_personagem.gif")),
                stOrdens, labels.getString("ORDERNS.TOOLTIP"));
        detalhesPersonagem.addTab(labels.getString("RESULTADOS"),
                new javax.swing.ImageIcon(getClass().getResource("/images/write-document-20x20.png")),
                stResults, labels.getString("RESULTADOS.TOOLTIP"));
        if (WorldFacadeCounselor.getInstance().isSpells()) {
            detalhesPersonagem.addTab(labels.getString("FEITICOS"),
                    new javax.swing.ImageIcon(getClass().getResource("/images/middle.gif")),
                    stSpells, labels.getString("FEITICOS.TOOLTIP"));
        }
    }

    public void doPersonagemMuda(Personagem personagem) {
        setPersonagem(personagem);
        getMapaControler().printTag(personagemFacade.getLocal(personagem));
        doConfigTabs();
        showPortrait(personagem);
        //verifica se o personagem pode receber ordens...
        if (jogadorFacade.isMine(personagem, WorldFacadeCounselor.getInstance().getJogadorAtivo())
                && personagemFacade.isAtivo(personagem)) {
            //can receive orders
            stOrdens.doMudaActor(personagem);
        } else {
            //refem ou morto, nao pode dar ordem
            //forca selecao para vazio, limpando quadro de parametros
            stOrdens.doOrdemClear();
        }
    }

    public void switchPortrait(boolean showPortrait) {
        showPortrait(getPersonagem());
        this.portraitPanel.setVisible(showPortrait);

    }

    private void showPortrait(Personagem personagem) {
        String portraitFileName = personagem.getPortraitFilename();

        javax.swing.JLabel portrait = new javax.swing.JLabel(ImageManager.getInstance().getPortrait(portraitFileName));
        portrait.setBorder(new javax.swing.border.EmptyBorder(0, 5, 0, 0));
        if (portraitPanel.getComponentCount() > 0) {
            portraitPanel.removeAll();
            portraitPanel.repaint();
        }
        this.portraitPanel.setAlignmentX(CENTER_ALIGNMENT);
        this.portraitPanel.setLayout(new BoxLayout(this.portraitPanel, BoxLayout.Y_AXIS));
        this.portraitPanel.add(portrait);

        javax.swing.JLabel habilidad; // = null;

        Map<Integer, javax.swing.JLabel> rankMap = new TreeMap<Integer, javax.swing.JLabel>(Collections.reverseOrder());

        if (personagem.getPericiaComandanteNatural() > 0) {
            habilidad = getRankLabel("COMANDANTE", personagem.getPericiaComandanteNatural(), personagem.getPericiaComandante());
            rankMap.put(personagem.getPericiaComandanteNatural(), habilidad);
        }

        if (WorldFacadeCounselor.getInstance().hasRogue() || !WorldFacadeCounselor.getInstance().getCenario().isLom() && personagem.getPericiaAgenteNatural() > 0) {
            habilidad = getRankLabel("AGENTE", personagem.getPericiaAgenteNatural(), personagem.getPericiaAgente());
            if (rankMap.containsKey(personagem.getPericiaAgenteNatural())) {
                rankMap.put(personagem.getPericiaAgenteNatural() - 1, habilidad);
            } else {
                rankMap.put(personagem.getPericiaAgenteNatural(), habilidad);
            }
        }

        if (WorldFacadeCounselor.getInstance().hasDiplomat() && personagem.getPericiaEmissarioNatural() > 0) {
            habilidad = getRankLabel("EMISSARIO", personagem.getPericiaEmissarioNatural(), personagem.getPericiaEmissario());
            if (rankMap.containsKey(personagem.getPericiaEmissarioNatural())) {
                rankMap.put(personagem.getPericiaEmissarioNatural() - 2, habilidad);
            } else {
                rankMap.put(personagem.getPericiaEmissarioNatural(), habilidad);
            }
        }

        if (WorldFacadeCounselor.getInstance().hasWizard() && personagem.getPericiaMagoNatural() > 0) {
            habilidad = getRankLabel("MAGO", personagem.getPericiaMagoNatural(), personagem.getPericiaMago());
            if (rankMap.containsKey(personagem.getPericiaMagoNatural())) {
                rankMap.put(personagem.getPericiaMagoNatural() - 3, habilidad);
            } else {
                rankMap.put(personagem.getPericiaMagoNatural(), habilidad);
            }
        }
        Iterator<Entry<Integer, javax.swing.JLabel>> iterator = rankMap.entrySet().iterator();
        Entry<Integer, javax.swing.JLabel> entrada;

        while (iterator.hasNext()) {
            entrada = iterator.next();
            this.portraitPanel.add(entrada.getValue());
        }

        if (personagem.getPericiaFurtividadeNatural() > 0) {
            habilidad = getRankLabel("FURTIVIDADE", personagem.getPericiaFurtividadeNatural(), personagem.getPericiaFurtividade());
            this.portraitPanel.add(habilidad);
        }

            final int dueloNat = personagem.getDuelo() - personagem.getDueloBonus();
        if (dueloNat > 0) {
            habilidad = getRankLabel("DUELO", dueloNat, personagem.getDuelo());
            this.portraitPanel.add(habilidad);
        }

        if (personagem.getVida() > 0) {
            habilidad = getRankLabel("VITALIDADE", personagem.getVida(), personagem.getVida());
            this.portraitPanel.add(habilidad);
        }

        portraitPanel.repaint();
        portraitPanel.revalidate();
    }

    javax.swing.JLabel getRankLabel(String rankName, int periciaNatural, int pericia) {
        javax.swing.JLabel habilidadLabel = null;
        String labelText;
        if (periciaNatural > 0) {
            labelText = labels.getString(rankName) + ": " + periciaNatural;
            if (periciaNatural != pericia) {
                labelText = labelText.concat(" (" + pericia + ")");

            }
            habilidadLabel = new javax.swing.JLabel(labelText);
            habilidadLabel.setBorder(new javax.swing.border.EmptyBorder(5, 5, 0, 0)); //top,left,bottom,right
        }

        return habilidadLabel;
    }
}
