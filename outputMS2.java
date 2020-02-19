 

import java.awt.Cursor;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class outputMS2 extends javax.swing.JFrame {

    private String output;
    private boolean fast;
    private String fileName;
    private String time;
    
    public outputMS2() {
        fileName = "error: no File!";
        fast = false;
        time = "";
        initComponents();
    }
    
    public outputMS2(String w, boolean x, String y, String z){
        output = w;
        fast = x;
        fileName = y;
        time = z.replaceAll(":", ";");
        initComponents();
        
    }
    
    public outputMS2(File x, String y) throws FileNotFoundException, IOException{
        
        String lines = new String ( Files.readAllBytes(Paths.get(x.getAbsolutePath())) );
        output = lines;
        String date = lines.substring(0,lines.indexOf("\n"));
        fileName = y;
        time = date.replaceAll(":", ";");
        
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileChooser = new javax.swing.JFileChooser();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        saveFile = new javax.swing.JButton();
        fileOut = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        compareMS3 = new javax.swing.JButton();
        peakInput = new javax.swing.JTextField();
        nLabel = new javax.swing.JLabel();
        nexLabel = new javax.swing.JLabel();
        daltonInput = new javax.swing.JTextField();
        nLabel1 = new javax.swing.JLabel();
        nexLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("output MS2");

        fileChooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileChooserActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(fileOut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saveFile))
            .addComponent(jScrollPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(saveFile, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(fileOut, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        compareMS3.setText("choose MS3 file to compare");
        compareMS3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                compareMS3ActionPerformed(evt);
            }
        });

        peakInput.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        peakInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                peakInputActionPerformed(evt);
            }
        });

        nLabel.setText("# top MS2 peaks");

        nexLabel.setText("(ex: 3)");

        daltonInput.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        daltonInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                daltonInputActionPerformed(evt);
            }
        });

        nLabel1.setText("dalton threshold [+/-]");

        nexLabel1.setText("(ex: 1.0)");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(compareMS3))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(daltonInput)
                    .addComponent(peakInput, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nexLabel)
                    .addComponent(nLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                    .addComponent(nexLabel1)
                    .addComponent(nLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE))
                .addGap(161, 161, 161))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(daltonInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(nLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(13, 13, 13))
                        .addComponent(nexLabel1)))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(peakInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(nLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(13, 13, 13))
                        .addComponent(nexLabel)))
                .addGap(7, 7, 7)
                .addComponent(compareMS3)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(fileChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 520, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(fileChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 490, Short.MAX_VALUE)))
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

    private void fileChooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileChooserActionPerformed

    }//GEN-LAST:event_fileChooserActionPerformed

    private void peakInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_peakInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_peakInputActionPerformed

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

        String outYay2 = null;
        cursor = new Cursor(Cursor.WAIT_CURSOR);
        this.setCursor(cursor);
        try {
            outYay2 = compare(thing, output, Integer.parseInt(peakInput.getText()), Double.parseDouble(daltonInput.getText()), fast);
        } 
        catch (IOException e) {
            cursor = new Cursor(Cursor.DEFAULT_CURSOR);
            if(peakInput.getText().equals("")){
                fileOut.setText("Missing Input!");
                Logger.getLogger(Scan_MGFGUI.class.getName()).log(Level.SEVERE, null, e);
            }
            else{
                fileOut.setText("Unknown Error!");
                Logger.getLogger(Scan_MGFGUI.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        catch (OutOfMemoryError e){
            fileOut.setText("out of memory!");
            Logger.getLogger(Scan_MGFGUI.class.getName()).log(Level.SEVERE, null, e);
            cursor = new Cursor(Cursor.DEFAULT_CURSOR);
            return;
        }
        catch (Exception e){
            fileOut.setText("unknown error!");
            Logger.getLogger(Scan_MGFGUI.class.getName()).log(Level.SEVERE, null, e);
            cursor = new Cursor(Cursor.DEFAULT_CURSOR);
            return;
        }

        new outputMS3(outYay2, thing.getName(), time).setVisible(true);

        cursor = new Cursor(Cursor.DEFAULT_CURSOR);
        this.setCursor(cursor);
    }//GEN-LAST:event_compareMS3ActionPerformed

    private void daltonInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_daltonInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_daltonInputActionPerformed

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
            java.util.logging.Logger.getLogger(outputMS2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new outputMS2().setVisible(true);
        });
        
        
    }

    public String compare(File ms3, String ms2output, int n, double daltonInput, boolean fast) throws IOException, FileNotFoundException{
        
        long begin = System.currentTimeMillis();
        
        Pattern p = Pattern.compile("\\d+");
        String output = "";
        TreeSet<String> uniqueMatches = new TreeSet<String>();
        ArrayList<String[]> ms3Arry = new ArrayList<String[]>();
                
        output+=time+"\n";
        output+="MS3 File: "+ms3.getName()+"\n";
        output+="# top peaks: "+n+"\n";
        output+="dalton threshold: "+daltonInput+"\n";
        output+="fast scan: "+fast+"\n\n";
        
        BufferedReader readms2 = new BufferedReader(new StringReader(ms2output));
        String line = "";
       
        BufferedReader readms3 = new BufferedReader(new FileReader(ms3));
        
        //try to find the appropriate column
        //"First Scan"
        //"m/z [Da]"
        //"MH+ [Da]"
        //"Charge"
        String[] heading = readms3.readLine().split("\"\t\"");
        int scanCol = -1;
        int massCol = -1;
        int mhCol = -1;
        int chargeCol = -1;
        for(int i=0; i<heading.length; i++){
            if(heading[i].equals("First Scan"))
                scanCol = i;
            if(heading[i].equals("m/z [Da]"))
                massCol = i;
            if(heading[i].equals("MH+ [Da]"))
                mhCol = i;
            if(heading[i].equals("Charge"))
                chargeCol = i;
        }
        
        while(readms3.ready()){
            ms3Arry.add(readms3.readLine().split("\"\t\""));
        }
        
        while (readms2.ready()){
           
           //stop at end of file
           if(line.contains("Runtime") || line.contains("# Unique")){
               break;
           }
           
           if(line.contains("SCANS")){
               line = readms2.readLine().toUpperCase();
           }
           
           //travel to the next set of [m/z][intensity] pairs
           while (!line.contains("SCANS") && !line.contains("RUNTIME")) {
               line = readms2.readLine().toUpperCase();
           }
           if(line.contains("RUNTIME")){
               break;
           }
           
           //get the scan number
           line = line.substring(line.indexOf("SCANS:"));
           //p = Pattern.compile("\\d+");
           Matcher m = p.matcher(line);
                
           int ms2ScanNo = 0;
           if(m.find()){
                ms2ScanNo = Integer.parseInt(m.group());
            }
           
           //get pepmass
           line = readms2.readLine().toUpperCase();
           line = line.substring(line.indexOf("PEPMASS: ")+9);
           double pepMass = Double.parseDouble(line);
           
           //go past initial line w spectrum no
           readms2.readLine();
           
           //start reading in pairs
           //for each pair, reference with ms3
           
           for(int i=0; i<ms3Arry.size(); i++){
               
               String[] pair = ms3Arry.get(i);

               int ms3ScanNo = Integer.parseInt(pair[scanCol]);
               int scanDiff = ms3ScanNo - ms2ScanNo;
               
               if(scanDiff <= n && scanDiff >= 1){
                   line = readms2.readLine();
                   
                   while(!line.equals("") && !line.contains("#") && !line.contains("SPECTRUM")){
                       
                       double ms2mass = -1;
                       double ms3mass = -1;
                       double massDiff = -1;
                       boolean withinDiff = true;
                       if(!fast){
                       String[] ms2MassLines = line.split(" ");
                       ms2mass = Double.parseDouble(ms2MassLines[0]);
                       ms3mass = Double.parseDouble(pair[massCol]);
                       massDiff = ms2mass - ms3mass;
                       withinDiff = Math.abs(massDiff) <= .001;
                       }
                           
                           if(withinDiff){
                              //pepMass, calcMass
                             
                              double charge = Integer.parseInt(pair[chargeCol]);
                              double calcMass = (Double.parseDouble(pair[mhCol]) + 569.2 + 1.0078*charge)/(charge+1);
                              double pepDiff = Math.abs(pepMass-calcMass);
                              
                              if(pepDiff <= daltonInput){
                                  System.out.println(""+ms2ScanNo+" "+ms3ScanNo+" "+scanDiff);
                              String match = "MS2#: "+ms2ScanNo+" MS3#: "+ms3ScanNo+"\n"+
                                                "peptide mass: "+pepMass+"\n"+
                                                "calculated mass: "+calcMass+"\n"+
                                                "daltons: "+pepDiff+"\n";
                              if(!fast){
                                  match = match+"MS2: "+line.substring(1)+"\n"+ "MS3: "+ms3mass+"\n";
                              }
                              match += "\n";
                              uniqueMatches.add(match);
                              }
                          }
                           
                           line = readms2.readLine();
                           if(line.equals("") && line.contains("#") && line.contains("Runtime")){
                                break;
                           }
                           
                       }
                   line = readms2.readLine();
                   }
               }
               
           }
        
        Iterator it = uniqueMatches.iterator();
            while(it.hasNext()){
                output += (String) it.next();
            }
            
            long end = System.currentTimeMillis();
            double timez = (end - begin) / 1000.0;
            output += "Runtime: " + timez + " seconds";
            return output;
        
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton compareMS3;
    private javax.swing.JTextField daltonInput;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JLabel fileOut;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nLabel;
    private javax.swing.JLabel nLabel1;
    private javax.swing.JLabel nexLabel;
    private javax.swing.JLabel nexLabel1;
    private javax.swing.JTextField peakInput;
    private javax.swing.JButton saveFile;
    // End of variables declaration//GEN-END:variables
}
