/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intelektikajava;

import other.*;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import java.awt.*;

/**
 *
 * @author pgrig
 */
public class GUI extends javax.swing.JFrame {
    
    static Speliotojas speliotojas = new Speliotojas();
    
    /**
     * Creates new form GUI
     */
    public GUI() {
        initComponents();        
    }
    
    public static void pradeti(Zodis zodis){
        zaidimas = true;
        while (zaidimas)
        {
            speliotojas.GautiSpejamaZodi(zodis.pasleptasZodis);
            System.out.println("Veikia gijos");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Žodis:");

        jLabel2.setText("Gyvybės:");

        jLabel3.setText("5");

        jLabel4.setText("jLabel4");

        jButton1.setText("Pradėti");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jLabel5.setText("jLabel5");

        jLabel6.setText("jLabel6");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addGap(101, 101, 101))))))
            .addGroup(layout.createSequentialGroup()
                .addGap(162, 162, 162)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 162, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jButton1))
                .addGap(65, 65, 65)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(86, 86, 86))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(20, 20, 20)
                                .addComponent(jLabel5)))
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    String galimosRaides = "aąbcčdeęėfghiįyjklmnoprsštuūųvzž";
    private Boolean tikrintiZodi(String tekstas)
    {
        Boolean leista = false;
        for(char c : tekstas.toCharArray())
        {
            leista = false;
            for(char raide : galimosRaides.toCharArray())
            {
                if (c == raide || c == Character.toUpperCase(raide))
                {
                   leista = true; break;
                }
            }
            if (!leista) break;
        }
        return leista;
    }
    
    static Boolean zaidimas = false;
    Boolean sustabdyta = false;
    int busena = 3;
    int gyvybes;
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        (new Gija()).run();
        if(jButton1.getText().equals("Atšaukti"))
	{
            jButton1.setText("Pradėti");
            sustabdyta = true;
        }
        else
        {
            if(tikrintiZodi(jTextField1.getText()) && jTextField1.getText().length() > 1) //input apribojimai
            {
		jButton1.setText("Atšaukti");
		sustabdyta = false;
                //padaryti kazka su animacijom
		Zodis zodis = new Zodis(jTextField1.getText().toLowerCase());
		jTextField2.setText(zodis.Atvaizdavimas());
		zaidimas = true;
		gyvybes = 50;
		jLabel3.setText(Integer.toString(gyvybes));
		//Speliotojas.Pazadinti(zodis.pasleptasZodis);
		//Task zaisti = new Task(() => pradeti(zodis));
		//Thread.Sleep(50);
		//zaisti.Start();
            }
        }
        ImageIcon imgIcon = new ImageIcon("../slamstas/ajax-loader.gif");
        Image img = imgIcon.getImage().getScaledInstance(42, 42, Image.SCALE_SMOOTH);
        jLabel4.setIcon(new ImageIcon(img));
        //jLabel4.setVisible(false);
                
        ImageIcon homerThinking = new ImageIcon("../slamstas/homer_simpson_thinking.png");
        Image homerDrinking = homerThinking.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        jLabel5.setIcon(new ImageIcon(homerDrinking));
        //jLabel5.setVisible(false);
        
        ImageIcon homerWasRight = new ImageIcon("../slamstas/Homer_simpsonwoohooo.gif");
        Image homerWoohoo = homerWasRight.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        jLabel5.setIcon(new ImageIcon(homerWoohoo));
        //jLabel5.setVisible(false);
        
        ImageIcon homerWasWrong = new ImageIcon("../slamstas/Homer_simpsondoh.png");
        Image homerDoh = homerWasWrong.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        jLabel5.setIcon(new ImageIcon(homerDoh));
        //jLabel5.setVisible(false);
                
        ImageIcon homerHasDoneHisJob = new ImageIcon("../slamstas/sleeping.png");
        Image homerIsSleeping = homerHasDoneHisJob.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        jLabel5.setIcon(new ImageIcon(homerIsSleeping));
        //jLabel5.setVisible(false);    
        
//        ImageIcon Zzz = new ImageIcon("../slamstas/Zzz.gif");
//        Image Z = Zzz.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
//        jLabel5.setIcon(new ImageIcon(Z));
        //jLabel5.setVisible(false);
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
