 

import java.awt.Cursor;
import java.io.*;
import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Scan_MGFGUI extends javax.swing.JFrame {

    public Scan_MGFGUI() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileChooser = new javax.swing.JFileChooser();
        jPanel1 = new javax.swing.JPanel();
        thresholdInput = new javax.swing.JTextField();
        minIntensityInput = new javax.swing.JTextField();
        minintensitylabel = new javax.swing.JLabel();
        massInput = new javax.swing.JTextField();
        massthresholdlabel = new javax.swing.JLabel();
        massthresholdexlabel = new javax.swing.JLabel();
        minintensityexlabel = new javax.swing.JLabel();
        masslabel = new javax.swing.JLabel();
        massexlabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        fileName = new javax.swing.JLabel();
        fileButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        findMatches = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        openOutputMS2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MGF Scanner");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        fileChooser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileChooserActionPerformed(evt);
            }
        });

        thresholdInput.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        thresholdInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thresholdInputActionPerformed(evt);
            }
        });

        minIntensityInput.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        minintensitylabel.setText("minimum relative intensity percentage [%]");

        massInput.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        massInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                massInputActionPerformed(evt);
            }
        });

        massthresholdlabel.setText("mass threshold [+/-]");

        massthresholdexlabel.setText("(ex: 1.0)");

        minintensityexlabel.setText("(ex: 20.0)");

        masslabel.setText("mass");

        massexlabel.setText("(ex: 569.5)");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(thresholdInput)
                    .addComponent(minIntensityInput, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                    .addComponent(massInput))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(massthresholdexlabel)
                    .addComponent(minintensityexlabel)
                    .addComponent(minintensitylabel)
                    .addComponent(massexlabel)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(masslabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(massthresholdlabel, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(massInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(masslabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13))
                    .addComponent(massexlabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(thresholdInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(massthresholdlabel)
                        .addGap(1, 1, 1)
                        .addComponent(massthresholdexlabel)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(minIntensityInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(minintensitylabel)
                        .addGap(2, 2, 2)
                        .addComponent(minintensityexlabel)))
                .addContainerGap())
        );

        fileName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        fileButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        fileButton.setText("choose MS2 .mgf file");
        fileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fileButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fileName, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(fileButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(fileName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        findMatches.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        findMatches.setText("find matches");
        findMatches.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findMatchesActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        jLabel2.setText("2020 Brandon Lam");

        openOutputMS2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        openOutputMS2.setText("compare existing MS2 scan output with MS3");
        openOutputMS2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openOutputMS2ActionPerformed(evt);
            }
        });

        jLabel1.setText("or");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(openOutputMS2))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(findMatches, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(findMatches)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(openOutputMS2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(fileChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(fileChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(22, 22, 22)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void findMatchesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findMatchesActionPerformed
        Cursor cursor = new Cursor(Cursor.WAIT_CURSOR);
        this.setCursor(cursor);
        
        File thing = fileChooser.getSelectedFile();
        
        float mass = 0;
        float threshold = 0;
        float minIntensity = 0;
        String outYay = "";
        
        try{
        mass = Float.parseFloat(massInput.getText());
        threshold = Float.parseFloat(thresholdInput.getText());
        minIntensity = Float.parseFloat(minIntensityInput.getText());
        thing = fileChooser.getSelectedFile();
        outYay = scan(mass,threshold,minIntensity,thing);
            if(thing==null){
                fileName.setText("no file selected!");
                return;
            }
        }
        catch(NumberFormatException e){
            fileName.setText("missing/invalid input!");
            return;
        } 
        catch (Exception e){
            fileName.setText("unknown error!");
            return;
        }
        
        String date = outYay.substring(0,outYay.indexOf("\n"));
        new outputMS2(outYay, thing.getName(), date).setVisible(true);
        
        cursor = new Cursor(Cursor.DEFAULT_CURSOR);
        this.setCursor(cursor);
    }//GEN-LAST:event_findMatchesActionPerformed

    private void fileChooserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileChooserActionPerformed

    }//GEN-LAST:event_fileChooserActionPerformed

    private void massInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_massInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_massInputActionPerformed

    private void thresholdInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thresholdInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_thresholdInputActionPerformed

    private void fileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileButtonActionPerformed

        String userDirLocation = System.getProperty("user.dir");
        File userDir = new File(userDirLocation);

        fileChooser = new javax.swing.JFileChooser(userDir);

        int returnVal = fileChooser.showOpenDialog(this);

        File thing = fileChooser.getSelectedFile();

        if(thing!=null){
            fileName.setText(thing.getName());
        }
        else{
            fileName.setText("no file selected!");
        }
    }//GEN-LAST:event_fileButtonActionPerformed

    private void openOutputMS2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openOutputMS2ActionPerformed
        String userDirLocation = System.getProperty("user.dir");
        File userDir = new File(userDirLocation);

        fileChooser = new javax.swing.JFileChooser(userDir);

        int returnVal = fileChooser.showOpenDialog(this);

        File thing = fileChooser.getSelectedFile();

        if(thing!=null){
            fileName.setText(thing.getName());
        }
        else{
            fileName.setText("no file selected!");
            Cursor cursor = new Cursor(Cursor.DEFAULT_CURSOR);
            this.setCursor(cursor);
            return;
        }
        
        Cursor cursor = new Cursor(Cursor.WAIT_CURSOR);
        this.setCursor(cursor);
        
        try {
            
            new outputMS2(thing, thing.getName()).setVisible(true);
        } 
        catch (FileNotFoundException ex) {
            fileName.setText("invalid MS2 file!");
            Logger.getLogger(Scan_MGFGUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Scan_MGFGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        cursor = new Cursor(Cursor.DEFAULT_CURSOR);
        this.setCursor(cursor);
    }//GEN-LAST:event_openOutputMS2ActionPerformed

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
            new Scan_MGFGUI().setVisible(true);
        });
    }
    
    public String scan(float mass, float threshold, float minIntensity, File file) throws IOException, FileNotFoundException {
        
	Scanner mgf = new Scanner(file);
        
	long begin = System.currentTimeMillis();

	String output = "";
        HashSet<Integer> uniqueSpectrumID = new HashSet<Integer>();
        HashSet<Integer> uniqueScanNo = new HashSet<Integer>();
        
	DateFormat sdf = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
	Date date = new Date();
	output += sdf.format(date) + "\n";

	output += "file: " + file.getName() + "\n";
	output += "minimum mass: " + mass + "\n";
	output += "mass threshold [+/-]: " + threshold + "\n";
	output += "minimum relative intensity [%]: " + minIntensity + "\n";
        
	while (mgf.hasNext()) {
		String y = "";

		String line = mgf.nextLine().toUpperCase();

                //goes to first BEGIN IONS before info
		while (!line.equals("BEGIN IONS") && mgf.hasNext()) {
			line = mgf.nextLine().toUpperCase();
		}
		if (!mgf.hasNext()) {
			break;
		}

                //obtaining spectrumID #
                while(!line.contains("SPECTRUM")){
                    line = mgf.nextLine().toUpperCase();
                }
                
                line = line.substring(line.indexOf("SPECTRUM"));
                Pattern p = Pattern.compile("\\d+");
                
                Matcher m = p.matcher(line);
                
                int SpectrumID = 0;
                if(m.find()){
                    SpectrumID = Integer.parseInt(m.group());
                }

                //getting pepmass
                while (!line.contains("PEPMASS=")){
                    line = mgf.nextLine().toUpperCase();
                }
                line = line.substring(line.indexOf("PEPMASS=")+8);
                String[] tempLine = line.split(" ");
                double pepMass = Double.parseDouble(tempLine[0]);
                
                //getting scan #
		while (!line.contains("SCANS=")) {
                    line = mgf.nextLine().toUpperCase();
		}
                line = line.substring(line.indexOf("SCANS="));
                p = Pattern.compile("\\d+");
                m = p.matcher(line);
                
                int scanNo = 0;
                if(m.find()){
                    scanNo = Integer.parseInt(m.group());
                }
                
                //determine highest intensity
                //store input (if meets threshold) in string to be retrieved later
                //input contains lines with valid m/z values
                //peaks contains all lines of input
                
                String input = "";
                ArrayList<String> peaks = new ArrayList<String>();
                
                float maxIntensity = 0;
		while (!line.equals("END IONS") && mgf.hasNext()) {
			line = mgf.nextLine();

			if (line.equals("END IONS") || !mgf.hasNext()) {
                            break;
			}
                        
                        peaks.add(line);
                        String[] pair = line.split(" ");
                        float val1 = Float.parseFloat(pair[0]);
                        float val2 = Float.parseFloat(pair[1]);
                        
                        //reduces # of lines saves to be read later
                        //only saves if mass within threshold
                        if(Math.abs(val1 - mass) <= threshold){
                            input+=line+",";
                        }
                        
                        maxIntensity = Math.max(maxIntensity, val2);
                        
		}
                
                //now processing input if it met the mass threshold
                
                //if met, start printing out all m/z & intensities
                boolean showAllPeaks = false;
                
                String[] inputz = {};
                if(input.length()>0){
                    
                    inputz = input.split(",");
                    for(String linez: inputz){
                        String[] pair = linez.split(" ");
                        
                        float val1 = Float.parseFloat(pair[0]);
                        float val2 = Float.parseFloat(pair[1]);
                    
                        float percentIntensity = val2/maxIntensity;
                    
                        if (percentIntensity >= (minIntensity/100)) {
                            y = y +"-"+pair[0] + " " + pair[1] + " ("+ percentIntensity*100 + "%) " + "\n";
                        
                            showAllPeaks = true;
                        }
                    
                    }
                }
                
                if(showAllPeaks){
                    String newPeaks = "";
                    
                    for(int i=0; i<peaks.size(); i++){
                        String[] lineMZ = peaks.get(i).split(" ");
                        float allPercentIntensity  = Float.parseFloat(lineMZ[1])/maxIntensity;
                        newPeaks = lineMZ[0]+" "+lineMZ[1]+" ("+allPercentIntensity*100+"%)\n";
                        y = y + newPeaks;
                    }
                }
                
		if (y.length() > 0) {
			output += "\nSPECTRUM ID: " + SpectrumID + " SCANS: " + scanNo + "\n" + "PEPMASS: " + pepMass + "\n" + y;
                        uniqueSpectrumID.add(SpectrumID);
                        uniqueScanNo.add(scanNo);
			y = "";
		}

	}
        
        output += "\n";
        output += "# Unique SpectrumID: " + uniqueSpectrumID.size()+"\n";
        output += "# Unique Scan Numbers: " + uniqueScanNo.size()+"\n";
        output += "\n";
        
	long end = System.currentTimeMillis();
	double time = (end - begin) / 1000.0;
	output += "Runtime: " + time + " seconds";

	return output;

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton fileButton;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JLabel fileName;
    private javax.swing.JButton findMatches;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField massInput;
    private javax.swing.JLabel massexlabel;
    private javax.swing.JLabel masslabel;
    private javax.swing.JLabel massthresholdexlabel;
    private javax.swing.JLabel massthresholdlabel;
    private javax.swing.JTextField minIntensityInput;
    private javax.swing.JLabel minintensityexlabel;
    private javax.swing.JLabel minintensitylabel;
    private javax.swing.JButton openOutputMS2;
    private javax.swing.JTextField thresholdInput;
    // End of variables declaration//GEN-END:variables

}
