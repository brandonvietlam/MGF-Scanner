package learn;

import java.awt.Cursor;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class outputMS2 extends javax.swing.JFrame {

    private String output;
    private String fileName;
    private String time;
    
    public outputMS2() {
        output = "error: no output!";
        fileName = "error: no File!";
        time = "";
        initComponents();
    }
    
    public outputMS2(String x, String y, String z){
        output = x;
        fileName = y;
        time = z.replaceAll(":", ";");
        
        initComponents();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        saveFile = new javax.swing.JButton();
        fileOut = new javax.swing.JLabel();
        compareMS3 = new javax.swing.JButton();
        fileChooser = new javax.swing.JFileChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("output MS2");
        setPreferredSize(new java.awt.Dimension(500, 370));

        jEditorPane1.setFont(new java.awt.Font("Lucida Console", 0, 14)); // NOI18N
        jEditorPane1.setText(output);
        jScrollPane1.setViewportView(jEditorPane1);

        saveFile.setText("save output to file");
        saveFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveFileActionPerformed(evt);
            }
        });

        fileOut.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        compareMS3.setText("choose MS3 file to compare");
        compareMS3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                compareMS3ActionPerformed(evt);
            }
        });

        fileChooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileChooserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
                    .addComponent(saveFile, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(fileOut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(compareMS3)))
                .addGap(10, 10, 10))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(fileChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 500, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                .addGap(1, 1, 1)
                .addComponent(saveFile)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(fileOut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(compareMS3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(58, 58, 58))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(fileChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 370, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveFileActionPerformed
        try{
            String newFileName = "scan "+time+" "+fileName+".txt";
            BufferedWriter writer = new BufferedWriter(new FileWriter(newFileName));
            writer.write(output);
            writer.close();
            fileOut.setText("saved to: "+newFileName);
        }
        catch (IOException ex) {
            fileOut.setText("Couldn't write to file!");
        }
        
    }//GEN-LAST:event_saveFileActionPerformed

    private void compareMS3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_compareMS3ActionPerformed
        String userDirLocation = System.getProperty("user.dir");
        File userDir = new File(userDirLocation);

        fileChooser = new javax.swing.JFileChooser(userDir);

        int returnVal = fileChooser.showOpenDialog(this);

        File thing = fileChooser.getSelectedFile();

        if(thing!=null){
            fileOut.setText(thing.getName());
        }
        else{
            fileOut.setText("no file selected!");
        }
        
        Cursor cursor = new Cursor(Cursor.WAIT_CURSOR);
        this.setCursor(cursor);
        
        String outYay = null;
        try {
            cursor = new Cursor(Cursor.WAIT_CURSOR);
            this.setCursor(cursor);
            outYay = compare(thing, jEditorPane1.getText());
        } catch (IOException ex) {
            Logger.getLogger(outputMS2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        new outputMS3(outYay, thing.getName(), time).setVisible(true);
        
        cursor = new Cursor(Cursor.DEFAULT_CURSOR);
        this.setCursor(cursor);
    }//GEN-LAST:event_compareMS3ActionPerformed

    private void fileChooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileChooserActionPerformed

    }//GEN-LAST:event_fileChooserActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(outputMS2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(outputMS2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(outputMS2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(outputMS2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new outputMS2().setVisible(true);
        });
        
        
    }

    //assumed that ms2 scan no + 1 = ms3 scan no
    public String compare(File ms3, String ms2output) throws IOException, FileNotFoundException{
        Pattern p = Pattern.compile("\\d+");
        String output = "";
        
        output+=time+"\n";
        output+="MS3 File: "+ms3.getName()+"\n";
        
        Scanner readms3 = new Scanner(ms3);
        String ms3input = "";
        while(readms3.hasNext()){
            ms3input += readms3.nextLine()+"\n";
        }
        
        Scanner readms2 = new Scanner(ms2output);
        String line = "";
       
        while (readms2.hasNext()){
           while (!line.contains("SCANS: ")) {
               line = readms2.nextLine().toUpperCase();
               
               if(!readms2.hasNext() || line.contains("Runtime")){return output;}
           }
           
           line = line.substring(line.indexOf("SCANS:"));
           //p = Pattern.compile("\\d+");
           Matcher m = p.matcher(line);
                
           int ms2 = 0;
            if(m.find()){
                ms2 = Integer.parseInt(m.group());
                System.out.println("ms2val:   "+ms2);
                
                
            }
            
           if(ms3input.indexOf("\""+(ms2+1)+"\"")>0){ 
                output+="MS2: "+ms2+" MS3: "+ms2+1+"\n";
           }
           
           if(readms2.hasNext()){
                line = readms2.nextLine().toUpperCase();
           }
           
       }
       return output;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton compareMS3;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JLabel fileOut;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton saveFile;
    // End of variables declaration//GEN-END:variables
}
