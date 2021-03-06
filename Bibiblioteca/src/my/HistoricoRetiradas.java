/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my;

import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Larissa Guder
 */
public class HistoricoRetiradas extends javax.swing.JFrame {

    /**
     * Creates new form HistoricoRetiradas
     */
    public HistoricoRetiradas() {
        initComponents();
        this.setLocationRelativeTo(null);
        // inutiliza o X
        this.setDefaultCloseOperation(WIDTH);

    }

    public void filtroObra(int ordem) {
        String ausente;
        DefaultTableModel historico = new DefaultTableModel();
        historico.addColumn("Usuário");
        historico.addColumn("Obra");
        historico.addColumn("Data de Devolução");
        historico.addColumn("Data de Emprestimo");
        historico.addColumn("Item ausente");
        jTHistorico.getTableHeader();
        historicoGeral historico_tabela = new historicoGeral();
        if (ordem == 1) {
            ArrayList<historicoGeral> dados = historico_tabela.emprestimos_abertos("SELECT * FROM emprestimo ORDER BY usuario ASC");
            for (historicoGeral base : dados) {
                if (base.devo == true) {
                    ausente = "SIM";
                } else {
                    ausente = "NÃO";
                }
                historico.addRow(new Object[]{base.usuario, base.obra, base.dataDev, base.data, ausente});
            }
        }
        if (ordem == 2) {
            ArrayList<historicoGeral> dados = historico_tabela.emprestimos_abertos("SELECT * FROM emprestimo ORDER BY obra ASC");
            for (historicoGeral base : dados) {
                if (base.devo == true) {
                    ausente = "SIM";
                } else {
                    ausente = "NÃO";
                }

                historico.addRow(new Object[]{base.usuario, base.obra, base.dataDev, base.data, ausente});
            }
        }
        if (ordem == 3) {
            ArrayList<historicoGeral> dados = historico_tabela.emprestimos_abertos("SELECT * FROM emprestimo ORDER BY data_emp ASC");
            for (historicoGeral base : dados) {
                if (base.devo == true) {
                    ausente = "SIM";
                } else {
                    ausente = "NÃO";
                }

                historico.addRow(new Object[]{base.usuario, base.obra, base.dataDev, base.data, ausente});
            }

        }
        if (ordem == 4) {
            ArrayList<historicoGeral> dados = historico_tabela.emprestimos_abertos("SELECT * FROM emprestimo ORDER BY emprestimo DESC");
            for (historicoGeral base : dados) {
                if (base.devo == true) {
                    ausente = "SIM";
                } else {
                    ausente = "NÃO";
                }

                historico.addRow(new Object[]{base.usuario, base.obra, base.dataDev, base.data, ausente});
            }
        }

        jTHistorico.setModel(historico);

        ButtonGroup bg = new ButtonGroup();

        bg.add(jRBData);
        bg.add(jRBItens);
        bg.add(jRBObra);
        bg.add(jRBUsuario);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        buttonGroup6 = new javax.swing.ButtonGroup();
        buttonGroup7 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTHistorico = new javax.swing.JTable();
        Busca = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jRBUsuario = new javax.swing.JRadioButton();
        jRBObra = new javax.swing.JRadioButton();
        jRBData = new javax.swing.JRadioButton();
        jRBItens = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Histórico de Retiradas");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jTHistorico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Usuário", "Obra", "Data de Devolução", "Data de Emprestimo", "Devolvido"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTHistorico);

        Busca.setText("Buscar");
        Busca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscaActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Classificar por:");

        jRBUsuario.setText("Usuário");

        jRBObra.setText("Obra");

        jRBData.setText("Data de Emprestimo");

        jRBItens.setText("Itens Ausentes");
        jRBItens.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRBItensActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRBUsuario)
                        .addGap(18, 18, 18)
                        .addComponent(jRBObra)
                        .addGap(18, 18, 18)
                        .addComponent(jRBData)
                        .addGap(18, 18, 18)
                        .addComponent(jRBItens))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(Busca)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 668, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jRBUsuario)
                    .addComponent(jRBObra)
                    .addComponent(jRBData)
                    .addComponent(jRBItens))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(Busca)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscaActionPerformed
        int ordem = 0;
        if (!jRBData.isSelected() && !jRBObra.isSelected() && !jRBUsuario.isSelected() && !jRBItens.isSelected()) {
            JOptionPane.showMessageDialog(rootPane, "Selecione um método de ordenação");

        } else if (jRBUsuario.isSelected() && !jRBObra.isSelected() && !jRBData.isSelected() && !jRBItens.isSelected()) {
            ordem = 1;
        } else if (jRBObra.isSelected() && !jRBData.isSelected() && !jRBUsuario.isSelected() && !jRBItens.isSelected()) {
            ordem = 2;
        } else if (jRBData.isSelected() && !jRBObra.isSelected() && !jRBUsuario.isSelected() && !jRBItens.isSelected()) {
            ordem = 3;
        } else if (jRBItens.isSelected() && !jRBObra.isSelected() && !jRBUsuario.isSelected() && !jRBData.isSelected()) {
            ordem = 4;
        } else {
            JOptionPane.showMessageDialog(rootPane, "Escolha apenas um método de ordenação");
        }

        filtroObra(ordem);
    }//GEN-LAST:event_BuscaActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        filtroObra(1);
    }//GEN-LAST:event_formWindowOpened

    private void jRBItensActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRBItensActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRBItensActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HistoricoRetiradas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HistoricoRetiradas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HistoricoRetiradas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HistoricoRetiradas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HistoricoRetiradas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Busca;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.ButtonGroup buttonGroup6;
    private javax.swing.ButtonGroup buttonGroup7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JRadioButton jRBData;
    private javax.swing.JRadioButton jRBItens;
    private javax.swing.JRadioButton jRBObra;
    private javax.swing.JRadioButton jRBUsuario;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTHistorico;
    // End of variables declaration//GEN-END:variables
}
