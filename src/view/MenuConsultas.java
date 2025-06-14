package view;

import dataAccessObject.ConsultaDAO;
import dataAccessObject.UtenteDAO;
import exception.ExcepcaoDAO;
import starter.MenuPrincipal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import model.Consulta;
import model.Utente;

/**
 *
 * @author Tiago Junqueira
 */
public final class MenuConsultas extends javax.swing.JFrame {
    
    // DAO para consultas
    private ConsultaDAO consultaDAO;
    private UtenteDAO utenteDAO;
    private DefaultTableModel tableModel;


    /**
     * Creates new form MenuConsultas
     */
    public MenuConsultas() {
        consultaDAO = new ConsultaDAO();
        utenteDAO = new UtenteDAO();
        initComponents();
        tableModel = (DefaultTableModel) tb.getModel();
        ocultarColunaID();
        setLocationRelativeTo(null);
        atualizarTabelaConsultas();
        atualizarCbxUtentes();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnVoltar = new javax.swing.JButton();
        btnApagar = new javax.swing.JButton();
        btnCriar = new javax.swing.JButton();
        txtData = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtHora = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb = new javax.swing.JTable();
        btnEditar = new javax.swing.JButton();
        cbxNome = new javax.swing.JComboBox<model.Utente>()
        ;
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel2.setBackground(new java.awt.Color(51, 126, 107));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(254, 255, 235));
        jLabel1.setText("Gerir Consultas");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(51, 126, 107));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 18, Short.MAX_VALUE)
        );

        btnVoltar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        btnApagar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnApagar.setText("Apagar Consulta");
        btnApagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApagarActionPerformed(evt);
            }
        });

        btnCriar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCriar.setText("Criar Consulta");
        btnCriar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCriarActionPerformed(evt);
            }
        });

        txtData.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Selecione nome do utente");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Data (YYYY-MM-DD)");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Hora (HH:mm)");

        txtHora.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtHora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHoraActionPerformed(evt);
            }
        });

        tb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Nome do utente", "Hora da consulta", "Data da consulta"
            }
        ));
        jScrollPane2.setViewportView(tb);

        btnEditar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEditar.setText("Editar Consulta");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        cbxNome.setModel(new javax.swing.DefaultComboBoxModel<>(new Utente[] { }));
        cbxNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxNomeActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Selecione uma consulta para editar");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Selecione uma consulta para apagar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnApagar)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3)
                                .addComponent(cbxNome, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnCriar))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(7, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbxNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(btnEditar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtHora)
                        .addGap(2, 2, 2)
                        .addComponent(btnCriar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnApagar)
                        .addGap(33, 33, 33)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(btnVoltar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCriarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCriarActionPerformed
        // TODO add your handling code here
        criarConsulta();
    }//GEN-LAST:event_btnCriarActionPerformed
   
    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        // TODO add your handling code here:
        new MenuPrincipal().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnApagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApagarActionPerformed
        // TODO add your handling code here:
       apagarConsulta();
    }//GEN-LAST:event_btnApagarActionPerformed

    private void txtHoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHoraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHoraActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        editarConsulta();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void cbxNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxNomeActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnApagar;
    private javax.swing.JButton btnCriar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JComboBox<Utente> cbxNome;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tb;
    private javax.swing.JTextField txtData;
    private javax.swing.JTextField txtHora;
    // End of variables declaration//GEN-END:variables

    /**
     * Oculta a coluna do id
     */
    private void ocultarColunaID() {
        tb.getColumnModel().getColumn(0).setMinWidth(0);
        tb.getColumnModel().getColumn(0).setMaxWidth(0);
        tb.getColumnModel().getColumn(0).setPreferredWidth(0);
    }
    /**
     * Atualiza o JComboBox com a lista de utentes da base de dados
     */
    private void atualizarCbxUtentes() {
        try {
            List<Utente> lista = utenteDAO.lerTodosUtentes();
            cbxNome.removeAllItems();
            for (Utente utente : lista) {
                cbxNome.addItem(utente);
            }
        } catch (ExcepcaoDAO ex) {
            JOptionPane.showMessageDialog(this,
                    "Erro ao carregar os utentes: " + ex.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Cria uma nova consulta com os dados dos campos de entrada
     */
    private void criarConsulta() {
        String data = txtData.getText().trim();
        String hora = txtHora.getText().trim();

        // Validação: os campos data e hora devem estar preenchidos
        if (data.isEmpty() || hora.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Data e hora devem ser preenchidas!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Obter o utente selecionado na cbx
        Utente utenteSelecionado = (Utente) cbxNome.getSelectedItem();
        if (utenteSelecionado == null) {
            JOptionPane.showMessageDialog(this, "Nenhum utente disponível para consulta.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int utenteId = utenteSelecionado.getId();

        // Cria o objeto Consulta, o ID é 0
        Consulta novaConsulta = new Consulta(0, data, hora, utenteId);
        try {
            consultaDAO.criarConsulta(novaConsulta);
            JOptionPane.showMessageDialog(this, "Consulta criada com sucesso!");
            atualizarTabelaConsultas();
            // Limpa os campos de entrada
            txtData.setText("");
            txtHora.setText("");
        } catch (ExcepcaoDAO ex) {
            JOptionPane.showMessageDialog(this, "Erro ao criar consulta: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Edita a consulta selecionada na JTable
     * Permite alterar o nome do utente, a hora e a data
     */
    private void editarConsulta() {
        try {
            int linhaSelecionada = tb.getSelectedRow();
            if (linhaSelecionada == -1) {
                JOptionPane.showMessageDialog(this, "Selecione uma consulta para editar.", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            // Obter dados atuais: ID (oculto), nome do utente, hora e data
            int idConsulta = Integer.parseInt(tb.getValueAt(linhaSelecionada, 0).toString());
            String nomeUtenteAtual = tb.getValueAt(linhaSelecionada, 1).toString();
            String horaAtual = tb.getValueAt(linhaSelecionada, 2).toString();
            String dataAtual = tb.getValueAt(linhaSelecionada, 3).toString();
            
            // Solicitar novos valores
            String novoNomeUtente = JOptionPane.showInputDialog(this, "Novo nome do utente:", nomeUtenteAtual);
            if (novoNomeUtente == null) return;
            String novaHora = JOptionPane.showInputDialog(this, "Nova hora (HH:MM):", horaAtual);
            if (novaHora == null) return;
            String novaData = JOptionPane.showInputDialog(this, "Nova data (YYYY-MM-DD):", dataAtual);
            if (novaData == null) return;
            
            // Validação: todos os campos devem estar preenchidos
            if (novoNomeUtente.trim().isEmpty() || novaHora.trim().isEmpty() || novaData.trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Todos os campos devem ser preenchidos!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            // Converter o novo nome do utente para o seu ID utilizando utenteDAO
            Utente utenteNovo = utenteDAO.lerUtentePorNome(novoNomeUtente);
            if (utenteNovo == null) {
                JOptionPane.showMessageDialog(this, "Utente não encontrado com o nome fornecido!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            int novoUtenteId = utenteNovo.getId();
            
            // Cria o objeto Consulta atualizado
            Consulta consultaAtualizada = new Consulta(idConsulta, novaData, novaHora, novoUtenteId);
            try {
                consultaDAO.actualizarConsulta(consultaAtualizada);
                JOptionPane.showMessageDialog(this, "Consulta actualizada com sucesso!");
                atualizarTabelaConsultas();
            } catch (ExcepcaoDAO ex) {
                JOptionPane.showMessageDialog(this, "Erro ao actualizar a consulta: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (ExcepcaoDAO ex) {
            Logger.getLogger(MenuConsultas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Apaga a consulta selecionada na JTable, após confirmação
     */
    private void apagarConsulta() {
        int linhaSelecionada = tb.getSelectedRow();
        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(this, "Selecione uma consulta para apagar.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        int confirmacao = JOptionPane.showConfirmDialog(this, "Tem a certeza que pretende apagar a consulta selecionada?", "Confirmar Apagar", JOptionPane.YES_NO_OPTION);
        if (confirmacao != JOptionPane.YES_OPTION) return;

        int idConsulta = Integer.parseInt(tb.getValueAt(linhaSelecionada, 0).toString());
        try {
            consultaDAO.apagarConsulta(idConsulta);
            JOptionPane.showMessageDialog(this, "Consulta apagada com sucesso!");
            atualizarTabelaConsultas();
        } catch (ExcepcaoDAO ex) {
            JOptionPane.showMessageDialog(this, "Erro ao apagar a consulta: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Atualiza a JTable com a lista de consultas obtida da base de dado
     * A coluna oculta contém o ID da consulta, enquanto as colunas visíveis mostram:
     * Nome do Utente, Hora e Data.+
     */
    public void atualizarTabelaConsultas() {
        try {
            List<Consulta> lista = consultaDAO.lerTodasConsultas();
            tableModel.setRowCount(0);
            for (Consulta consulta : lista) {
                // Obter o utente associado à consulta
                Utente utente = utenteDAO.lerUtentePorId(consulta.getUtenteId());
                String nomeUtente = (utente != null) ? utente.getNome() : "Desconhecido";
                // Adicionar a linha com: ID (oculto), Nome do Utente, Hora e Data
                Object[] linha = {consulta.getId(), nomeUtente, consulta.getHoraConsulta(), consulta.getDataConsulta()};
                tableModel.addRow(linha);
            }
        } catch (ExcepcaoDAO ex) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar as consultas: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}

