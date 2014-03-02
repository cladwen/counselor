/*
 * TabNacoesGui.java
 *
 * Created on April 23, 2008, 11:37 AM
 */
package gui.tabs;

import business.facade.NacaoFacade;
import control.MapaControler;
import control.NacaoControler;
import gui.TabBase;
import java.io.Serializable;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableModel;
import model.Habilidade;
import model.HabilidadeNacao;
import model.Nacao;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import persistence.BundleManager;
import persistence.SettingsManager;

/**
 *
 * @author gurgel
 */
public class TabNacoesGui extends TabBase implements Serializable {

    private static final Log log = LogFactory.getLog(TabNacoesGui.class);
    private static final BundleManager labels = SettingsManager.getInstance().getBundleManager();
    private NacaoControler nacaoControl;

    public TabNacoesGui(String titulo, String dica, MapaControler mapaControl) {
        initComponents();
        //Basico
        setIcone("/images/cp_acampamento.gif");
        setTitle(titulo);
        setDica(dica);
        this.setMapaControler(mapaControl);
        //configura grid
        jtMainLista.setAutoCreateColumnsFromModel(true);
        jtMainLista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jtMainLista.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jtMainLista.setAutoCreateRowSorter(true);
        jtRelacionamento.setAutoCreateColumnsFromModel(true);
        jtRelacionamento.setAutoCreateRowSorter(true);
        jtRelacionamento.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jtRelacionamento.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jtTropas.setAutoCreateColumnsFromModel(true);
        jtTropas.setAutoCreateRowSorter(true);
        jtTropas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jtTropas.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        comboFiltro.setName("comboFiltro");
        comboFiltro.setSelectedIndex(this.getFiltroDefault());
        //Cria o Controle da lista 
        nacaoControl = new NacaoControler(this);

        //adiciona listeners
        comboFiltro.addActionListener(nacaoControl);
        jtMainLista.getSelectionModel().addListSelectionListener(nacaoControl);

        TableModel model = nacaoControl.getMainTableModel(this.getFiltro());
        this.setMainModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtMainLista = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtRelacionamento = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        txDescricao = new javax.swing.JTextPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        comboFiltro = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        qtNacoes = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtTropas = new javax.swing.JTable();

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
        jtMainLista.setName(""); // NOI18N
        jScrollPane3.setViewportView(jtMainLista);

        jtRelacionamento.setAutoCreateRowSorter(true);
        jtRelacionamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Nome", "Relacionamento"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtRelacionamento.setName(""); // NOI18N
        jScrollPane2.setViewportView(jtRelacionamento);

        jScrollPane1.setViewportView(txDescricao);

        jLabel2.setText(labels.getString("TOTAL:")); // NOI18N

        comboFiltro.setModel(getDefaultComboBoxModelTodosProprio());

        jLabel1.setText(labels.getString("LISTAR:")); // NOI18N

        qtNacoes.setText("66666"); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(qtNacoes)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(qtNacoes))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jtTropas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(jtTropas);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE))
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
    private javax.swing.JTable jtMainLista;
    private javax.swing.JTable jtRelacionamento;
    private javax.swing.JTable jtTropas;
    private javax.swing.JLabel qtNacoes;
    private javax.swing.JTextPane txDescricao;
    // End of variables declaration//GEN-END:variables

    public JTable getMainLista() {
        return jtMainLista;
    }

    public final void setMainModel(TableModel model) {
        this.txDescricao.setText("");
        this.setRelacionamentoModel(null);
        this.setTropaModel(null);
        this.jtMainLista.setModel(model);
        this.calcColumnWidths(jtMainLista);
        this.updateGui();
        this.doTagHide();
        this.jtMainLista.getSelectionModel().setSelectionInterval(0, 0);
    }

    private int getFiltro() {
        return comboFiltro.getSelectedIndex();
    }

    private void updateGui() {
        this.qtNacoes.setText(getMainLista().getRowCount() + "");
    }

    private void setRelacionamentoModel(TableModel model) {
        if (model == null) {
            jtRelacionamento.setModel(new javax.swing.table.DefaultTableModel(
                    new Object[][]{
                {"-", "-"}},
                    new String[]{
                labels.getString("NACAO"), labels.getString("RELACIONAMENTO")
            }));
        } else {
            this.jtRelacionamento.setModel(model);
            calcColumnWidths(jtRelacionamento);
        }
        this.updateGui();
    }

    private void setTropaModel(TableModel model) {
        if (model == null) {
            jtTropas.setModel(new javax.swing.table.DefaultTableModel(
                    new Object[][]{
                {"-", "-"}},
                    new String[]{
                labels.getString("TROPA"), labels.getString("CUSTO.MANUTENCAO")
            }));
        } else {
            this.jtTropas.setModel(model);
            calcColumnWidths(jtTropas);
        }
        this.updateGui();
    }

    public void doMudaNacao(Nacao nacao) {
        try {
            getMapaControler().printTag(nacao.getCapital().getLocal());
        } catch (NullPointerException ex) {
            this.doTagHide();
        }
        setRelacionamentoModel(nacaoControl.getRelacionamentoTableModel(nacao));
        setTropaModel(nacaoControl.getTropaTableModel(nacao));
        String hab = labels.getString("HABILIDADES.ESPECIAIS") + "\n";
        NacaoFacade nacaoFacade = new NacaoFacade();
        for (HabilidadeNacao elem : nacaoFacade.getHabilidadesNacao(nacao)) {
            hab += String.format("- %s\n", elem.getNome());
        }
        for (Habilidade elem : nacaoFacade.getHabilidades(nacao)) {
            if (!elem.isPackage()) {
                hab += String.format("- %s\n", elem.getNome());
            }
        }
        try {
            for (String msg : nacaoFacade.getMensagens(nacao)) {
//                hab += "\n\n\n" + msg.replace(',', '\n');
                hab += "\n\n\n" + msg;
            }
        } catch (NullPointerException ex) {
            //just skip
            hab += labels.getString("?");
        }
        this.txDescricao.setText(hab);
    }
}