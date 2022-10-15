/*
 * MainResultWindowGui.java
 *
 * Created on April 23, 2008, 10:38 AM
 */
package gui;

import business.ImageManager;
import control.MapaControler;
import control.WorldControler;
import control.facade.WorldFacadeCounselor;
import gui.components.JLabelGradient;
import gui.services.ComponentFactory;
import gui.tabs.TabPersonagensGui;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.io.Serializable;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.plaf.basic.BasicSplitPaneUI;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import persistenceCommons.BundleManager;
import persistenceCommons.SettingsManager;
import persistenceCommons.SysApoio;

/**
 *
 * @author gurgel
 */
public class MainResultWindowGui extends javax.swing.JPanel implements Serializable {

    private static final Log LOG = LogFactory.getLog(MainResultWindowGui.class);
    private static final BundleManager labels = SettingsManager.getInstance().getBundleManager();
    private final WorldControler wc = new WorldControler(this);
    private TabPersonagensGui tabPersonagem;
    private JLabelGradient jlActionCounter;

    private final SettingsManager settingsManager;

    /**
     * Creates new form MainResultWindowGui
     *
     * @param autoLoad
     */
    public MainResultWindowGui(String autoLoad) {
        this.settingsManager = SettingsManager.getInstance();
        initComponents();
        doConfigStatusBar();
        //load teaser
        doLoadTeaser();

        //   SettingsControler settingsControler = new SettingsControler(this);
        //adiciona listeners
        jbOpen.addActionListener(wc);
        jbLoad.addActionListener(wc);
        jbSave.addActionListener(wc);
        jbSaveWorld.addActionListener(wc);
        jbMap.addActionListener(wc);
        jbCopy.addActionListener(wc);
        jbEmailList.addActionListener(wc);
        jbSend.addActionListener(wc);
        jbAbout.addActionListener(wc);
        jbScoreGraph.addActionListener(wc);
        jbScoreGraph1.addActionListener(wc);
        jbScoreGraph2.addActionListener(wc);
        jbHexview.addActionListener(wc);
        jbConfigs.addActionListener(wc);
        togglePathPj.addActionListener(wc);
        togglePathPjFuture.addActionListener(wc);
        toggleFogWar.addActionListener(wc);
        togglePathArmy.addActionListener(wc);
        toggleDisplayPortrait.addActionListener(wc);
        wc.doAutoLoad(autoLoad);
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        infoPanel = new javax.swing.JPanel();
        labelNacao = new javax.swing.JLabel();
        labelMoney = new javax.swing.JLabel();
        labelJogador = new javax.swing.JLabel();
        labelCenario = new javax.swing.JLabel();
        labelTurno = new javax.swing.JLabel();
        labelDeadline = new javax.swing.JLabel();
        labelJogo = new javax.swing.JLabel();
        jToolBar1 = new javax.swing.JToolBar();
        jbOpen = new javax.swing.JButton();
        jbLoad = new javax.swing.JButton();
        jbSave = new javax.swing.JButton();
        jbSend = new javax.swing.JButton();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        jbSaveWorld = new javax.swing.JButton();
        jbCopy = new javax.swing.JButton();
        jbEmailList = new javax.swing.JButton();
        jbMap = new javax.swing.JButton();
        jbScoreGraph = new javax.swing.JButton();
        jbScoreGraph2 = new javax.swing.JButton();
        jbScoreGraph1 = new javax.swing.JButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        jToolBar2 = new javax.swing.JToolBar();
        togglePathPj = new javax.swing.JToggleButton();
        togglePathPjFuture = new javax.swing.JToggleButton();
        togglePathArmy = new javax.swing.JToggleButton();
        toggleFogWar = new javax.swing.JToggleButton();
        toggleScouts = new javax.swing.JToggleButton();
        toggleDisplayPortrait = new javax.swing.JToggleButton();
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        jbHexview = new javax.swing.JButton();
        jbConfigs = new javax.swing.JButton();
        jbAbout = new javax.swing.JButton();
        splitMainPanel = new javax.swing.JSplitPane();
        jlLeft = new javax.swing.JLabel();
        jlRight = new javax.swing.JLabel();
        statusBar = new javax.swing.JPanel();
        statusLabel = new javax.swing.JLabel();
        jlActionCountPlaceholder = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1024, 768));

        infoPanel.setBackground(new java.awt.Color(204, 204, 255));

        labelNacao.setText(labels.getString("NACAO")); // NOI18N

        labelMoney.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("labels"); // NOI18N
        labelMoney.setText(bundle.getString("MONEY")); // NOI18N
        labelMoney.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        labelJogador.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelJogador.setText(labels.getString("JOGADOR")); // NOI18N
        labelJogador.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        labelCenario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelCenario.setText(labels.getString("CENARIO")); // NOI18N
        labelCenario.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        labelTurno.setText(labels.getString("TURNO")); // NOI18N
        labelTurno.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        labelDeadline.setText(labels.getString("TURNO")); // NOI18N
        labelDeadline.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

        labelJogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelJogo.setText(labels.getString("JOGO")); // NOI18N
        labelJogo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        jbOpen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/open actions.png"))); // NOI18N
        jbOpen.setText(labels.getString("ABRIR.TURNO")); // NOI18N
        jbOpen.setToolTipText(labels.getString("ABRIR.TURNO.TOOLTIP")); // NOI18N
        jbOpen.setActionCommand("jbOpen");
        jbOpen.setFocusable(false);
        jbOpen.setName("jbOpen"); // NOI18N
        jToolBar1.add(jbOpen);

        jbLoad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/open results.png"))); // NOI18N
        jbLoad.setText(labels.getString("CARREGAR.ACOES")); // NOI18N
        jbLoad.setToolTipText(labels.getString("CARREGAR.ACOES.TOOLTIP")); // NOI18N
        jbLoad.setActionCommand("jbLoad");
        jbLoad.setEnabled(false);
        jbLoad.setFocusable(false);
        jbLoad.setName("jbLoad"); // NOI18N
        jToolBar1.add(jbLoad);

        jbSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/save.png"))); // NOI18N
        jbSave.setText(labels.getString("SALVAR.ACOES")); // NOI18N
        jbSave.setToolTipText(labels.getString("SALVAR.ACOES.TOOLTIP")); // NOI18N
        jbSave.setActionCommand("jbSave");
        jbSave.setEnabled(false);
        jbSave.setFocusable(false);
        jbSave.setName("jbSave"); // NOI18N
        jToolBar1.add(jbSave);

        jbSend.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/submit.png"))); // NOI18N
        jbSend.setText(labels.getString("ENVIAR.ACOES")); // NOI18N
        jbSend.setToolTipText(labels.getString("ENVIAR.ACOES.TOOLTIP")); // NOI18N
        jbSend.setActionCommand("jbSend");
        jbSend.setEnabled(false);
        jbSend.setFocusable(false);
        jbSend.setName("jbSend"); // NOI18N
        jToolBar1.add(jbSend);
        jToolBar1.add(filler2);

        jbSaveWorld.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/disk icon.png"))); // NOI18N
        jbSaveWorld.setText(labels.getString("SALVAR.WORLD")); // NOI18N
        jbSaveWorld.setToolTipText(labels.getString("SALVAR.WORLD.TOOLTIP")); // NOI18N
        jbSaveWorld.setActionCommand("jbSaveWorld");
        jbSaveWorld.setEnabled(false);
        jbSaveWorld.setFocusable(false);
        jbSaveWorld.setName("jbSaveWorld"); // NOI18N
        jToolBar1.add(jbSaveWorld);

        jbCopy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/copy.png"))); // NOI18N
        jbCopy.setText(labels.getString("COPIAR.ACOES")); // NOI18N
        jbCopy.setToolTipText(labels.getString("COPIAR.ACOES.TOOLTIP")); // NOI18N
        jbCopy.setActionCommand("jbCopy");
        jbCopy.setEnabled(false);
        jbCopy.setFocusable(false);
        jbCopy.setName("jbCopy"); // NOI18N
        jToolBar1.add(jbCopy);

        jbEmailList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/email.png"))); // NOI18N
        jbEmailList.setToolTipText(labels.getString("COPIAR.EMAILS.TOOLTIP")); // NOI18N
        jbEmailList.setActionCommand("jbEmailList");
        jbEmailList.setEnabled(false);
        jbEmailList.setFocusable(false);
        jbEmailList.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jbEmailList.setName("jbEmailList"); // NOI18N
        jbEmailList.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jbEmailList);

        jbMap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/save map.png"))); // NOI18N
        jbMap.setText(labels.getString("SALVAR.MAPA")); // NOI18N
        jbMap.setToolTipText(labels.getString("SALVAR.MAPA.TOOLTIP")); // NOI18N
        jbMap.setActionCommand("jbExportMap");
        jbMap.setEnabled(false);
        jbMap.setFocusable(false);
        jbMap.setName("jbExportMap"); // NOI18N
        jToolBar1.add(jbMap);

        jbScoreGraph.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bargraph icon.png"))); // NOI18N
        jbScoreGraph.setText(labels.getString("PONTOS.VITORIA")); // NOI18N
        jbScoreGraph.setToolTipText(labels.getString("MENU.PNTOS.VITORIA.TOOLTIP")); // NOI18N
        jbScoreGraph.setActionCommand("jbScoreGraph");
        jbScoreGraph.setEnabled(false);
        jbScoreGraph.setFocusable(false);
        jbScoreGraph.setName("jbScoreGraph"); // NOI18N
        jbScoreGraph.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jbScoreGraph);

        jbScoreGraph2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/areagraph icon.png"))); // NOI18N
        jbScoreGraph2.setText(labels.getString("PONTOS.VITORIA.GAME")); // NOI18N
        jbScoreGraph2.setToolTipText(labels.getString("MENU.PNTOS.VITORIA.TOOLTIP")); // NOI18N
        jbScoreGraph2.setActionCommand("jbGraphAllTurns");
        jbScoreGraph2.setEnabled(false);
        jbScoreGraph2.setFocusable(false);
        jbScoreGraph2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jbScoreGraph2.setName("jbGraphAllTurns"); // NOI18N
        jbScoreGraph2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jbScoreGraph2);

        jbScoreGraph1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bargraph icon.png"))); // NOI18N
        jbScoreGraph1.setText(labels.getString("PONTOS.VITORIA.TEAM")); // NOI18N
        jbScoreGraph1.setToolTipText(labels.getString("MENU.PNTOS.VITORIA.TOOLTIP")); // NOI18N
        jbScoreGraph1.setActionCommand("jbGraphSingleTurn");
        jbScoreGraph1.setEnabled(false);
        jbScoreGraph1.setFocusable(false);
        jbScoreGraph1.setName("jbGraphSingleTurn"); // NOI18N
        jbScoreGraph1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jbScoreGraph1);
        jToolBar1.add(filler1);

        jToolBar2.setRollover(true);

        togglePathPj.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/hex_path_pj.png"))); // NOI18N
        togglePathPj.setSelected(isPcPathSelected());
        togglePathPj.setToolTipText(bundle.getString("SETTINGS.MAP.PCPATH")); // NOI18N
        togglePathPj.setActionCommand("pcPathDraw");
        togglePathPj.setEnabled(false);
        togglePathPj.setFocusable(false);
        togglePathPj.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        togglePathPj.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(togglePathPj);

        togglePathPjFuture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/hex_path_pj_2.png"))); // NOI18N
        togglePathPjFuture.setSelected(isPcPathFutureSelected());
        togglePathPjFuture.setToolTipText(bundle.getString("SETTINGS.MAP.PCPATH.FUTURE")); // NOI18N
        togglePathPjFuture.setActionCommand("pcPathDraw");
        togglePathPjFuture.setEnabled(false);
        togglePathPjFuture.setFocusable(false);
        togglePathPjFuture.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        togglePathPjFuture.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(togglePathPjFuture);

        togglePathArmy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/hex_path_army.png"))); // NOI18N
        togglePathArmy.setSelected(true);
        togglePathArmy.setToolTipText(bundle.getString("SETTINGS.MAP.ARMYPATH.ARMY")); // NOI18N
        togglePathArmy.setActionCommand("drawPathArmy");
        togglePathArmy.setEnabled(false);
        togglePathArmy.setFocusable(false);
        togglePathArmy.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        togglePathArmy.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(togglePathArmy);

        toggleFogWar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/hex_fog.png"))); // NOI18N
        toggleFogWar.setSelected(isFogOfWarSelected());
        toggleFogWar.setToolTipText(bundle.getString("SETTINGS.DISPLAY.FILTER.FOGOFWAR")); // NOI18N
        toggleFogWar.setActionCommand("drawFogWar");
        toggleFogWar.setEnabled(false);
        toggleFogWar.setFocusable(false);
        toggleFogWar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        toggleFogWar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(toggleFogWar);

        toggleScouts.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/hex_fog.png"))); // NOI18N
        toggleScouts.setSelected(isFogOfWarSelected());
        toggleScouts.setToolTipText(bundle.getString("SETTINGS.DISPLAY.FILTER.FOGOFWAR")); // NOI18N
        toggleScouts.setActionCommand("drawFogWar");
        toggleScouts.setEnabled(false);
        toggleScouts.setFocusable(false);
        toggleScouts.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        toggleScouts.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(toggleScouts);

        toggleDisplayPortrait.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/display_portrait.png"))); // NOI18N
        toggleDisplayPortrait.setSelected(isDisplayPortraitsSelected());
        toggleDisplayPortrait.setToolTipText(bundle.getString("SETTINGS.DISPLAY.SHOWPORTRAITS")); // NOI18N
        toggleDisplayPortrait.setActionCommand("drawDisplayPortraits");
        toggleDisplayPortrait.setEnabled(false);
        toggleDisplayPortrait.setFocusable(false);
        toggleDisplayPortrait.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        toggleDisplayPortrait.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar2.add(toggleDisplayPortrait);

        jToolBar1.add(jToolBar2);
        jToolBar1.add(filler3);

        jbHexview.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/hex_icon.png"))); // NOI18N
        jbHexview.setText(bundle.getString("MENU.HEXVIEW")); // NOI18N
        jbHexview.setToolTipText(bundle.getString("MENU.HEXVIEW.TOOLTIP")); // NOI18N
        jbHexview.setActionCommand("jbHexview");
        jbHexview.setEnabled(false);
        jbHexview.setFocusable(false);
        jbHexview.setName("jbConfig"); // NOI18N
        jToolBar1.add(jbHexview);

        jbConfigs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon_customize.gif"))); // NOI18N
        jbConfigs.setText(bundle.getString("MENU.CONFIG")); // NOI18N
        jbConfigs.setToolTipText(bundle.getString("MENU.CONFIG.TOOLTIP")); // NOI18N
        jbConfigs.setActionCommand("jbConfig");
        jbConfigs.setFocusable(false);
        jbConfigs.setName("jbConfig"); // NOI18N
        jToolBar1.add(jbConfigs);

        jbAbout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/about.png"))); // NOI18N
        jbAbout.setText(labels.getString("MENU.ABOUT")); // NOI18N
        jbAbout.setToolTipText(labels.getString("MENU.ABOUT.TOOLTIP")); // NOI18N
        jbAbout.setActionCommand("jbAbout");
        jbAbout.setFocusable(false);
        jbAbout.setName("jbAbout"); // NOI18N
        jToolBar1.add(jbAbout);

        javax.swing.GroupLayout infoPanelLayout = new javax.swing.GroupLayout(infoPanel);
        infoPanel.setLayout(infoPanelLayout);
        infoPanelLayout.setHorizontalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(infoPanelLayout.createSequentialGroup()
                        .addComponent(labelTurno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(15, 15, 15)
                        .addComponent(labelDeadline, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(infoPanelLayout.createSequentialGroup()
                        .addComponent(labelNacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(3, 3, 3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelJogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelCenario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelMoney, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelJogador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        infoPanelLayout.setVerticalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPanelLayout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelJogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelNacao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(labelJogador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCenario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelMoney, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelTurno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelDeadline, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        splitMainPanel.setBorder(null);
        splitMainPanel.setDividerSize(8);
        splitMainPanel.setAutoscrolls(true);
        splitMainPanel.setMinimumSize(new java.awt.Dimension(0, 0));
        splitMainPanel.setOneTouchExpandable(true);
        splitMainPanel.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                splitMainPanelPropertyChange(evt);
            }
        });

        jlLeft.setToolTipText("Open.");
        splitMainPanel.setLeftComponent(jlLeft);

        jlRight.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        splitMainPanel.setRightComponent(jlRight);

        statusBar.setBackground(new java.awt.Color(204, 204, 255));

        statusLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        statusLabel.setText(labels.getString("STATUS.MESSAGES")); // NOI18N

        jlActionCountPlaceholder.setBackground(new java.awt.Color(204, 204, 255));
        jlActionCountPlaceholder.setText(String.format("%s: 0 / 0 ", labels.getString("ACOES")));

        javax.swing.GroupLayout statusBarLayout = new javax.swing.GroupLayout(statusBar);
        statusBar.setLayout(statusBarLayout);
        statusBarLayout.setHorizontalGroup(
            statusBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statusBarLayout.createSequentialGroup()
                .addComponent(statusLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlActionCountPlaceholder))
        );
        statusBarLayout.setVerticalGroup(
            statusBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statusBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(statusLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlActionCountPlaceholder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(infoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(splitMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(statusBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(infoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(splitMainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 648, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statusBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void splitMainPanelPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_splitMainPanelPropertyChange
        if (evt.getPropertyName().equals(javax.swing.JSplitPane.DIVIDER_LOCATION_PROPERTY)) {
            String splitWidth = evt.getNewValue().toString();
            LOG.debug("Split pane divisor modified to " + splitWidth + " px.");
            if (Integer.parseInt(splitWidth) > 0) {
                SettingsManager.getInstance().setConfig("splitSize", splitWidth);
            }
        }
    }//GEN-LAST:event_splitMainPanelPropertyChange

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.JPanel infoPanel;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JButton jbAbout;
    private javax.swing.JButton jbConfigs;
    private javax.swing.JButton jbCopy;
    private javax.swing.JButton jbEmailList;
    private javax.swing.JButton jbHexview;
    private javax.swing.JButton jbLoad;
    private javax.swing.JButton jbMap;
    private javax.swing.JButton jbOpen;
    private javax.swing.JButton jbSave;
    private javax.swing.JButton jbSaveWorld;
    private javax.swing.JButton jbScoreGraph;
    private javax.swing.JButton jbScoreGraph1;
    private javax.swing.JButton jbScoreGraph2;
    private javax.swing.JButton jbSend;
    private javax.swing.JLabel jlActionCountPlaceholder;
    private javax.swing.JLabel jlLeft;
    private javax.swing.JLabel jlRight;
    private javax.swing.JLabel labelCenario;
    private javax.swing.JLabel labelDeadline;
    private javax.swing.JLabel labelJogador;
    private javax.swing.JLabel labelJogo;
    private javax.swing.JLabel labelMoney;
    private javax.swing.JLabel labelNacao;
    private javax.swing.JLabel labelTurno;
    private javax.swing.JSplitPane splitMainPanel;
    private javax.swing.JPanel statusBar;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JToggleButton toggleDisplayPortrait;
    private javax.swing.JToggleButton toggleFogWar;
    private javax.swing.JToggleButton togglePathArmy;
    private javax.swing.JToggleButton togglePathPj;
    private javax.swing.JToggleButton togglePathPjFuture;
    private javax.swing.JToggleButton toggleScouts;
    // End of variables declaration//GEN-END:variables

    public void iniciaConfig() {
        LOG.info(labels.getString("INICIALIZANDO.GUI"));
        //infopanel
        this.labelCenario.setText(String.format("%s: %s", labels.getString("CENARIO"), wc.getCenarioNome()));
        if (wc.isGameOver()) {
            this.labelDeadline.setText(String.format(labels.getString("GAMEOVER"), wc.getTurno()));
            this.labelDeadline.setForeground(Color.white);
            this.infoPanel.setBackground(Color.orange);
        } else if (wc.isJogadorAtivoEliminado()) {
            this.labelDeadline.setText(String.format(labels.getString("GAMEOVER.PLAYER"), wc.getTurno()));
            this.labelDeadline.setForeground(Color.white);
            this.infoPanel.setBackground(Color.orange);
        } else {
            if (wc.getDeadlineDaysRemaining() > 0) {
                this.labelDeadline.setText(String.format(labels.getString("PARTIDA.LABEL.DEADLINE"), wc.getDeadlineDaysRemaining(), wc.getDeadline()));
                this.labelDeadline.setForeground(Color.black);
                this.infoPanel.setBackground(new Color(204, 204, 255));
            } else {
                this.labelDeadline.setText(String.format(labels.getString("PARTIDA.LABEL.DEADLINE.NOW"), wc.getDeadline()));
                this.labelDeadline.setForeground(Color.white);
                this.infoPanel.setBackground(Color.orange);
            }
            this.infoPanel.repaint();
        }
        this.labelTurno.setText(String.format("%s: %s / %s", labels.getString("TURNO"), wc.getTurno(), wc.getTurnoMax()));
        this.labelJogador.setText(String.format("%s: %s", labels.getString("JOGADOR"), wc.getJogadorAtivoNome()));
        //just pre-load with some dummy data. Will be replaced later.
        final String labelActionsCost = String.format(labels.getString("MENU.ACTION.COST"), wc.getJogadorAtivoNome(), 0);
        this.setLabelMoney(labelActionsCost);
        this.labelJogo.setText(String.format("%s: %s", labels.getString("JOGO"), wc.getPartidaNome()));
        if (wc.getNacoesJogadorAtivoQtd() < 4) {
            this.labelNacao.setText(String.format("%s: %s", labels.getString("NACAO"), wc.getNacoesJogadorAtivoNome()));
        } else {
            //too many names to display
            this.labelNacao.setText(String.format("%s: %s", labels.getString("NACAO"), wc.getNacoesJogadorAtivoQtd() + " ... "));
        }

        MapaControler mapaControl = WorldFacadeCounselor.getInstance().getMapaControler();//new MapaControler(this); //
        if (mapaControl == null) {
            mapaControl = new MapaControler(this);
        } else {
            mapaControl.initialize(this);
        }

        //   MapaControler mapaControl = new MapaControler(this);
        WorldFacadeCounselor.getInstance().setMapaControler(mapaControl);
        MainMapaGui mapaGui = new MainMapaGui();
        //Monta área do mapa
        this.splitMainPanel.setRightComponent(mapaGui);
        // Monta tabbed panel para dados
        MainDadosGui dadosGui = new MainDadosGui();
        this.splitMainPanel.setLeftComponent(dadosGui);
        this.tabPersonagem = dadosGui.getTabPersonagem();

        //habilita o toolbar
        jbLoad.setEnabled(true);
        jbSave.setEnabled(true);
        jbSave.setVisible(!SettingsManager.getInstance().isAutoSaveActions());

        if (SettingsManager.getInstance().isWorldBuilder()) {
            jbSaveWorld.setEnabled(true);
        } else {
            jbSaveWorld.setEnabled(false);
            jbSaveWorld.setVisible(false);
        }
        jbMap.setEnabled(true);
        jbScoreGraph.setEnabled(true);
        jbScoreGraph1.setEnabled(true);
        jbScoreGraph2.setEnabled(wc.isVictoryPointsExists());
        jbHexview.setEnabled(true);
        jbCopy.setEnabled(true);
        jbEmailList.setEnabled(true);
        jbSend.setEnabled(true);
        jbAbout.setEnabled(true);
        jbHexview.setEnabled(true);
        jbConfigs.setEnabled(true);

        togglePathPj.setEnabled(true);
        togglePathPjFuture.setEnabled(true);
        togglePathArmy.setEnabled(true);
        toggleFogWar.setEnabled(true);
        toggleDisplayPortrait.setEnabled(true);

        // Joga a janela toda para a esquerda = 0
        // divide a janela ao meio = -1
        //        this.splitMainPanel.setDividerLocation(55555);
        int splitWid = SysApoio.parseInt(SettingsManager.getInstance().getConfig("splitSize", "660"));
        this.splitMainPanel.setDividerLocation(splitWid);
        doMinimizeMap();
    }

    public void doMinimizeMap() {
        if (SettingsManager.getInstance().getConfig("minimizeMapOnStart", "0").equals("1")) {
            //configuracoes para o autoloader
            this.splitMainPanel.addComponentListener(new ComponentListener() {
                @Override
                public void componentHidden(ComponentEvent e) {
                }

                @Override
                public void componentMoved(ComponentEvent e) {
                }

                @Override
                public void componentResized(ComponentEvent e) {
                    splitMainPanel.setDividerLocation(1.0);
                }

                @Override
                public void componentShown(ComponentEvent e) {
                    splitMainPanel.setDividerLocation(1.0);
                }
            });
            //configuracoes caso esteja abvrindo outro turno com a interface ja exibida.
            //forcando atualizacao das labels para nao alterar oe stado do splitpanel
            this.validate();
            this.setVisible(true);
            BasicSplitPaneUI uiTest = (BasicSplitPaneUI) this.splitMainPanel.getUI();
            Container divider = uiTest.getDivider();
            JButton max = (JButton) divider.getComponent(1);
            max.doClick();
        }
    }

    public TabPersonagensGui getTabPersonagem() {
        return this.tabPersonagem;
    }

    public void setStatusMsg(String txt) {
        statusLabel.setText(txt);
    }

    public void setLabelMoney(String txt) {
        if (SysApoio.parseInt(txt) > 0) {
            this.labelMoney.setForeground(Color.black);
        } else {
            this.labelMoney.setForeground(Color.red);
        }
        this.labelMoney.setText(txt);
    }

    private void doLoadTeaser() {
        final ImageIcon teaser = ImageManager.getInstance().getTeaser();
        //Gera o mapa
        Dimension tamanho = new Dimension(teaser.getIconWidth(), teaser.getIconHeight());
        this.splitMainPanel.setPreferredSize(tamanho);
        this.jlRight.setSize(tamanho);
        this.jlRight.setIcon(teaser);
    }

    public void setActionsCount(float actionCount, float slotCount) {
        jlActionCounter.setPercent(actionCount, slotCount);
        jlActionCounter.setText(String.format("%s: %s / %s ", labels.getString("ACOES"), (int) actionCount, (int) slotCount));
    }

    private void doConfigStatusBar() {
        final ComponentFactory cf = new ComponentFactory();
        jlActionCounter = cf.getLabelGradient();
        jlActionCounter.setBackground(jlActionCountPlaceholder.getBackground());
        jlActionCounter.setForeground(jlActionCountPlaceholder.getForeground());
        jlActionCounter.setMinBarSize(SettingsManager.getInstance().getConfigAsInt("LookAndFeelFontSize", "12"));
        jlActionCounter.setText(String.format("%s: 0 / 0 ", labels.getString("ACOES")));
        jlActionCounter.setPercent(0, 0);
        //replace component in UI
        GroupLayout parLayout = (GroupLayout) statusBar.getLayout();
        parLayout.replace(jlActionCountPlaceholder, jlActionCounter);
    }

    public boolean isPcPathSelected() {
        int drawPcPath = settingsManager.getConfigAsInt("drawPcPath", "1");
        return drawPcPath == 1 || drawPcPath == 2;
    }

    public JToggleButton getPcPath() {
        return this.togglePathPj;
    }

    public JToggleButton getArmyPath() {
        return this.togglePathArmy;
    }

    public boolean isPcPathFutureSelected() {
        int drawPcPath = settingsManager.getConfigAsInt("drawPcPath", "1");
        return drawPcPath == 1 || drawPcPath == 3;
    }

    public JToggleButton getPcPathFuture() {
        return this.togglePathPjFuture;
    }

    public boolean isFogOfWarSelected() {
        return settingsManager.getConfig("fogOfWarType", "1").equals("1");
    }

    public JToggleButton getFogOfWar() {
        return this.toggleFogWar;
    }

    public boolean isDisplayPortraitsSelected() {
        return settingsManager.getConfig("ShowCharacterPortraits", "1").equals("1");
    }

    public JToggleButton getDisplayPortraits() {
        return this.toggleDisplayPortrait;
    }

    public void setSplitPaneValue(int value) {
        this.splitMainPanel.setDividerLocation(value);
    }

}
