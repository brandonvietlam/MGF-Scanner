package learn;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class outputMS3 extends javax.swing.JFrame {
    
    private String output;
    private String fileName;
    private String time;
    private ArrayList<Integer> scanMatches;
    private File ms3;
    
    public outputMS3() {
        output = "error: no output!";
        fileName = "error: no File!";
        time = "";
        
        initComponents();
    }
    
    public outputMS3(String x, String y, String z, ArrayList<Integer> _matches, File _ms3){
        output = x;
        fileName = y;
        time = z.replaceAll(":", ";");
        
        scanMatches = _matches;
        ms3 = _ms3;
        
        initComponents();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        saveFile = new javax.swing.JButton();
        fileOut = new javax.swing.JLabel();
        saveTsv = new javax.swing.JButton();
        tsvOut = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("compare MS2 MS3");
        setPreferredSize(new java.awt.Dimension(515, 390));

        jEditorPane1.setFont(new java.awt.Font("Lucida Console", 0, 14)); // NOI18N
        jEditorPane1.setText(output);
        jScrollPane1.setViewportView(jEditorPane1);

        saveFile.setText("save output to .txt");
        saveFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveFileActionPerformed(evt);
            }
        });

        saveTsv.setText("generate .tsv");
        saveTsv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveTsvActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tsvOut, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fileOut, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(saveFile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(saveTsv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(saveFile)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(saveTsv))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(fileOut, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tsvOut, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveFileActionPerformed
        
        String newFileName = "compare MS3 scan "+time+" "+fileName+".txt";
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(newFileName));
            writer.write(output);
            writer.close();
            fileOut.setText("saved to: "+newFileName);
        }
        catch (IOException ex) {
            fileOut.setText("Couldn't write to file!");
        }
        
    }//GEN-LAST:event_saveFileActionPerformed

    private void saveTsvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveTsvActionPerformed
        
        BufferedReader readms3 = null;
        try{
            String tsvOutput = "";
            readms3 = new BufferedReader(new FileReader(ms3));
            TreeSet < String > uniqueMatches = new TreeSet < String > ();
            
            String line = "";
            boolean endOfFile = false;
            int scanCol = -1;
            while(!endOfFile){
                line = readms3.readLine();
                if(line!=null && !line.contains("# Unique Matches")){
                    //getting the column of the "scanNum"
                    if(scanCol==-1){
                        tsvOutput+=line+"\n";
                        String[] heading = line.split("\t");
                        for (int i = 0; i < heading.length; i++) {
                                if (heading[i].equals("ScanNum"))
                                        scanCol = i;
                        }
                    }
                    else{
                        //otherwise, all other lines of tsv
                        String[] pair = line.split("\t");
                        for(int i=0;i<scanMatches.size();i++){
                            if(Integer.parseInt(pair[scanCol])==scanMatches.get(i)){
                                uniqueMatches.add(line+"\n");
                            }
                        }
                    }
                }
                else{
                    endOfFile = true;
                    Iterator it = uniqueMatches.iterator();
                    while(it.hasNext()){
                        tsvOutput += (String) it.next();
                    }
                }
            }
            
            String newFileName = "compare MS3 scan "+time+" "+fileName+".tsv";
            try{
                BufferedWriter writer = new BufferedWriter(new FileWriter(newFileName));
                writer.write(tsvOutput);
                writer.close();
                tsvOut.setText("saved to: "+newFileName);
            }
            catch (IOException ex) {
                tsvOut.setText("Couldn't write to file!");
                return;
            }
        }
        catch (FileNotFoundException ex) {
            Logger.getLogger(outputMS3.class.getName()).log(Level.SEVERE, null, ex);
            tsvOut.setText("Cant find ms3 file!");
            return;
        }
        catch (IOException ex) {
            Logger.getLogger(outputMS3.class.getName()).log(Level.SEVERE, null, ex);
            tsvOut.setText("error in format of ms3 file!");
            return;
        }
    }//GEN-LAST:event_saveTsvActionPerformed


    public void main(String args[]) {
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Scan_MGFGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        
        java.awt.EventQueue.invokeLater(() -> {
            new outputMS3().setVisible(true);
        });
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel fileOut;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton saveFile;
    private javax.swing.JButton saveTsv;
    private javax.swing.JLabel tsvOut;
    // End of variables declaration//GEN-END:variables
}
