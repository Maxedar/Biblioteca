/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lg0116088
 */
public class EmprestimosClass extends javax.swing.JFrame {

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(String codUsuario) {
        this.codUsuario = codUsuario;
    }

    public String getTituloObra() {
        return tituloObra;
    }

    public void setTituloObra(String tituloObra) {
        this.tituloObra = tituloObra;
    }

    public String getCodObra() {
        return codObra;
    }
    String cod_obra;
    String cod_usu;

    /**
     * Creates new form Emprestimo
     *
     */
    // String nome;
    public void setCodObra(String codObra) {
        this.codObra = codObra;
    }
    String nomeUsuario;
    String codUsuario;
    String tituloObra;
    String codObra;

    public void filtro() {

        DefaultTableModel tabelaAcervo = new DefaultTableModel();

        tabelaAcervo.addColumn("Nome");
        tabelaAcervo.addColumn("CPF");
        tabelaAcervo.addColumn("Código");

        UsuarioClass usuario = new UsuarioClass();

        ArrayList<UsuarioClass> dados = usuario.listar_usuarios("select * from usuarios where nome_usur like '%" + nome.getText() + "%'");

        for (UsuarioClass base : dados) {

            tabelaAcervo.addRow(new Object[]{base.nome, base.cpf, base.codigo});

        }

        jTUsuario.setModel(tabelaAcervo);
    }

    public void filtroObra() {

        DefaultTableModel tabelaAcervo = new DefaultTableModel();

        tabelaAcervo.addColumn("Título");
        tabelaAcervo.addColumn("Código");
        tabelaAcervo.addColumn("Status");

        CadastroAcervoClass acervo = new CadastroAcervoClass();

        ArrayList<CadastroAcervoClass> dados = acervo.listar_livros("select * from acervo where titulo like '%" + BuscaTitulo.getText() + "%' and status like 'DISPONÍVEL'");

        for (CadastroAcervoClass base : dados) {

            tabelaAcervo.addRow(new Object[]{base.titulo, base.codigo, base.status});

        }

        jTBuscaAcervo.setModel(tabelaAcervo);
    }

    public String dataAtual() {

        Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");

        String dataAtual = s.format(d.getTime());

        return dataAtual;

    }

    public String datadevolucao() {
        Date d = new Date();
        SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");

        String dataAtual = s.format(d.getTime());
        Calendar c = Calendar.getInstance();
        c.setTime(d);

        c.set(Calendar.DAY_OF_MONTH, c.get(Calendar.DAY_OF_MONTH) + 7);
        String dataDevolucao = s.format(c.getTime());

        return dataDevolucao;
        // System.out.println(new SimpleDateFormat("dd/MM/yyyy").format(c.getTime()));
    }

    public void empresta() {

    }

    public EmprestimosClass() {
        initComponents();
        // centraliza tela
        this.setLocationRelativeTo(null);
        // inutiliza o X
        this.setDefaultCloseOperation(WIDTH);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jBEmprestar = new javax.swing.JButton();
        jBCancelar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTUsuario = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTBuscaAcervo = new javax.swing.JTable();
        nome = new javax.swing.JTextField();
        jBBuscarNome = new javax.swing.JButton();
        BuscaTitulo = new javax.swing.JTextField();
        jBBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Nome:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Obra:");

        jBEmprestar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/folder/Merge Files-26.png"))); // NOI18N
        jBEmprestar.setText("Emprestar");
        jBEmprestar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEmprestarActionPerformed(evt);
            }
        });

        jBCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/folder/Delete-26 (1).png"))); // NOI18N
        jBCancelar.setText("Cancelar");
        jBCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCancelarActionPerformed(evt);
            }
        });

        jTUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Nome", "Código"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTUsuarioMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTUsuario);

        jTBuscaAcervo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Obra", "Código", "Disponibilidade"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTBuscaAcervo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTBuscaAcervoMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTBuscaAcervo);

        nome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nomeKeyReleased(evt);
            }
        });

        jBBuscarNome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/folder/Binoculars-26.png"))); // NOI18N
        jBBuscarNome.setText("Buscar");
        jBBuscarNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBuscarNomeActionPerformed(evt);
            }
        });

        BuscaTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscaTituloActionPerformed(evt);
            }
        });
        BuscaTitulo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                BuscaTituloKeyReleased(evt);
            }
        });

        jBBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/folder/Binoculars-26.png"))); // NOI18N
        jBBuscar.setText("Buscar");
        jBBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jBEmprestar)
                        .addGap(18, 18, 18)
                        .addComponent(jBCancelar)
                        .addGap(90, 90, 90))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBBuscarNome)))
                        .addContainerGap(33, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(BuscaTitulo)
                        .addGap(18, 18, 18)
                        .addComponent(jBBuscar)
                        .addGap(147, 147, 147))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBBuscarNome))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(BuscaTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jBBuscar)))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBEmprestar)
                    .addComponent(jBCancelar))
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBBuscarNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBuscarNomeActionPerformed
        filtro();
    }//GEN-LAST:event_jBBuscarNomeActionPerformed

    private void BuscaTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscaTituloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BuscaTituloActionPerformed

    private void jBEmprestarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEmprestarActionPerformed
        emprestimos novoEmprestimo = new emprestimos();

        String dataatual = dataAtual();
        String datadevolução = datadevolucao();
        if (!nome.getText().isEmpty() && !BuscaTitulo.getText().isEmpty()) {
            novoEmprestimo.emprestar(nome.getText(), BuscaTitulo.getText(), dataatual, datadevolução, cod_usu, cod_obra);
            nome.setText(null);
            BuscaTitulo.setText(null);
            filtro();
            filtroObra();
        } else {
            JOptionPane.showMessageDialog(null, "Você deve selecionar uma obra e um usuário!");
            nome.setText(null);
            BuscaTitulo.setText(null);
            filtro();
            filtroObra();
        }
    }//GEN-LAST:event_jBEmprestarActionPerformed

    private void jBCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCancelarActionPerformed
        this.dispose();

    }//GEN-LAST:event_jBCancelarActionPerformed

    private void jTUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTUsuarioMouseClicked
        int linha_selecionada2 = jTUsuario.getSelectedRow();
        nome.setText(jTUsuario.getValueAt(linha_selecionada2, 0).toString());
        cod_usu = jTUsuario.getValueAt(linha_selecionada2, 2).toString();


    }//GEN-LAST:event_jTUsuarioMouseClicked

    private void jTBuscaAcervoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTBuscaAcervoMouseClicked
        int linha_selecionada1 = jTBuscaAcervo.getSelectedRow();
        BuscaTitulo.setText(jTBuscaAcervo.getValueAt(linha_selecionada1, 0).toString());
        cod_obra = jTBuscaAcervo.getValueAt(linha_selecionada1, 1).toString();

    }//GEN-LAST:event_jTBuscaAcervoMouseClicked

    private void jBBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBuscarActionPerformed
        filtroObra();

    }//GEN-LAST:event_jBBuscarActionPerformed

    private void nomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nomeKeyReleased
        nome.setText(nome.getText().toUpperCase());
        // TODO add your handling code here:
    }//GEN-LAST:event_nomeKeyReleased

    private void BuscaTituloKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BuscaTituloKeyReleased
        BuscaTitulo.setText(BuscaTitulo.getText().toUpperCase());        // TODO add your handling code here:
    }//GEN-LAST:event_BuscaTituloKeyReleased

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
            java.util.logging.Logger.getLogger(EmprestimosClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmprestimosClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmprestimosClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmprestimosClass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmprestimosClass().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField BuscaTitulo;
    private javax.swing.JButton jBBuscar;
    private javax.swing.JButton jBBuscarNome;
    private javax.swing.JButton jBCancelar;
    private javax.swing.JButton jBEmprestar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTBuscaAcervo;
    private javax.swing.JTable jTUsuario;
    private javax.swing.JTextField nome;
    // End of variables declaration//GEN-END:variables
}
