
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */

/**
 *
 * @author erhan
 */
public class NotepadPages extends javax.swing.JDialog {
    DefaultTableModel model;
    NotesOperations operations = new NotesOperations();
    /**
     * Creates new form NotepadPages
     */
    public NotepadPages(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        model = (DefaultTableModel)notesTable.getModel();
        showNote();
        note.setLineWrap(true);
        note.setWrapStyleWord(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        notesTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        title = new javax.swing.JTextField();
        date = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        note = new javax.swing.JTextArea();
        addnote = new javax.swing.JButton();
        updateNote = new javax.swing.JButton();
        deleteNote = new javax.swing.JButton();
        quit = new javax.swing.JButton();
        seachBar1 = new javax.swing.JTextField();
        messageWriting = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBounds(new java.awt.Rectangle(400, 200, 0, 0));

        notesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Title", "Note", "Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        notesTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                notesTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(notesTable);
        if (notesTable.getColumnModel().getColumnCount() > 0) {
            notesTable.getColumnModel().getColumn(0).setResizable(false);
            notesTable.getColumnModel().getColumn(1).setResizable(false);
            notesTable.getColumnModel().getColumn(2).setResizable(false);
            notesTable.getColumnModel().getColumn(3).setResizable(false);
        }

        jLabel1.setText("Title : ");

        jLabel2.setText("Note : ");

        jLabel3.setText("Date : ");

        note.setColumns(20);
        note.setRows(5);
        note.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                noteKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(note);

        addnote.setText("Add note");
        addnote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addnoteActionPerformed(evt);
            }
        });

        updateNote.setText("Update note");
        updateNote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateNoteActionPerformed(evt);
            }
        });

        deleteNote.setText("Delete note");
        deleteNote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteNoteActionPerformed(evt);
            }
        });

        quit.setText("Quit");
        quit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitActionPerformed(evt);
            }
        });

        seachBar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seachBar1ActionPerformed(evt);
            }
        });
        seachBar1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                seachBar1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                seachBar1KeyReleased(evt);
            }
        });

        messageWriting.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(seachBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 553, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane2)
                                    .addComponent(title)
                                    .addComponent(date))
                                .addGap(125, 125, 125)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(addnote, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(updateNote, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(deleteNote, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(quit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(232, 232, 232)
                        .addComponent(messageWriting, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(162, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(seachBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addnote))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateNote))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(deleteNote)
                        .addGap(18, 18, 18)
                        .addComponent(quit)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(messageWriting, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void quitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_quitActionPerformed

    private void addnoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addnoteActionPerformed
        
       if(title.getText().trim().isEmpty() || note.getText().trim().isEmpty() || date.getText().trim().isEmpty()){
           messageWriting.setText("Imformation boxex cannot be empty , please fill whole boxes!!!");
       }
       else{
            messageWriting.setText("");
            String title = this.title.getText();
            String note = this.note.getText();
            String date = this.date.getText();

            operations.addNote(title, note, date);
            showNote();
            messageWriting.setText("New note added with successfully...");
            this.title.setText("");
            this.date.setText("");
            this.note.setText("");
       }
    }//GEN-LAST:event_addnoteActionPerformed

    private void updateNoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateNoteActionPerformed
        String title = this.title.getText();
        String note = this.note.getText();
        String date = this.date.getText();
        
        int selectedrow = notesTable.getSelectedRow();
        if (title.isEmpty() || note.isEmpty() || date.isEmpty() ) {
            messageWriting.setText("Please fill in all fields.");
            return;
        }
        if (selectedrow == -1) {
            if (model.getRowCount() == 0) {
                messageWriting.setText("Notepad table is currently empty.");
            } else {
                messageWriting.setText("Please choose a Note to update.");
            }
        } else {
            try {
                int id = (int)notesTable.getValueAt(selectedrow, 0);
                operations.updateNote(id, title, note, date);
                
                
                showNote();
                messageWriting.setText("Note updated successfully.");
            } catch (Exception e) {
                messageWriting.setText("An error occurred while updating the Note.");
                e.printStackTrace();
            }
            this.note.setText("");
            this.date.setText("");
            this.title.setText("");
        }
        
        
        
    }//GEN-LAST:event_updateNoteActionPerformed

    private void deleteNoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteNoteActionPerformed
        messageWriting.setText("");
        
        int selectedrow = notesTable.getSelectedRow();

        if (selectedrow == -1) {
            if (model.getRowCount() == 0) {
                messageWriting.setText("Note table is currently empty.");
            } else {
                messageWriting.setText("Please choose a note to delete.");
            }
        }
        else {
            try {
                int id = (int)model.getValueAt(selectedrow, 0);
                operations.deleteNote(id);
                
    
                showNote();
                messageWriting.setText("Note deleted successfully.");
            } catch (Exception e) {
                messageWriting.setText("An error occurred while deleting the note.");
                e.printStackTrace();
            }
            note.setText("");
            date.setText("");
            title.setText("");
        }
    }//GEN-LAST:event_deleteNoteActionPerformed

    private void seachBar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seachBar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_seachBar1ActionPerformed

    private void seachBar1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_seachBar1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_seachBar1KeyPressed
    public void dinamicSearch(String search){
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
        notesTable.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search));
    }
    private void seachBar1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_seachBar1KeyReleased
        String search = seachBar1.getText();
        
        dinamicSearch(search);
    }//GEN-LAST:event_seachBar1KeyReleased

    private void notesTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_notesTableMouseClicked
        int selectedrow = notesTable.getSelectedRow();
        
        title.setText(model.getValueAt(selectedrow, 1).toString());
        note.setText(model.getValueAt(selectedrow, 2).toString());
        date.setText(model.getValueAt(selectedrow, 3).toString());
       
    }//GEN-LAST:event_notesTableMouseClicked
    
    private void noteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_noteKeyPressed
        
       
    }//GEN-LAST:event_noteKeyPressed

    /**
     * @param args the command line arguments
     */
    public void showNote(){
        
         model.setRowCount(0);
        ArrayList<User> users = new ArrayList<User>();
         users = operations.bringWorkers();
         
         if(users != null){
             for(User user : users){
                 Object[] adding = {user.getId(),user.getTitle(),user.getNote(),user.getDate()};
                 
                 model.addRow(adding);
             }
         }
        
    }
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
            java.util.logging.Logger.getLogger(NotepadPages.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NotepadPages.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NotepadPages.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NotepadPages.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                NotepadPages dialog = new NotepadPages(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addnote;
    private javax.swing.JTextField date;
    private javax.swing.JButton deleteNote;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel messageWriting;
    private javax.swing.JTextArea note;
    private javax.swing.JTable notesTable;
    private javax.swing.JButton quit;
    private javax.swing.JTextField seachBar1;
    private javax.swing.JTextField title;
    private javax.swing.JButton updateNote;
    // End of variables declaration//GEN-END:variables
}
