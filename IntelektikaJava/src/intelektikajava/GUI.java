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
import java.lang.reflect.*;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author pgrig
 */
public class GUI extends javax.swing.JFrame {

    static Zodis zodis;
    public static Speliotojas speliotojas = new Speliotojas();
    Gija gija = new Gija();

    static Clip clip;
    static File atspejoF;
    static File neatspejoF;

    /**
     * Creates new form GUI
     */
    public GUI() {
        initComponents();
        jLabel5.setHorizontalTextPosition(JLabel.CENTER);
        jLabel4.setText("");
        jLabel5.setText("");
           
        atspejoF = new File("../slamstas/woohoo.wav");
        neatspejoF = new File("../slamstas/Doh.wav");
    }

    public static void pradeti(Zodis zodis) throws InterruptedException {
        //zaidimas = true;
        while (zaidimas) {
            speliotojas.GautiSpejamaZodi(zodis.pasleptasZodis);
            apdorojamasSpejimas(zodis, speliotojas.SpekRaide());
            //Thread.sleep(100);
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
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setText("Žodis:");

        jLabel2.setText("Gyvybės:");

        jLabel3.setText("5");

        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setText("jLabel5");
        jPanel5.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jButton1.setText("Pradėti");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLayeredPane1.setPreferredSize(new java.awt.Dimension(60, 60));

        jLabel4.setText("jLabel4");

        jLayeredPane1.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addGap(0, 26, Short.MAX_VALUE))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addGap(0, 46, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(148, Short.MAX_VALUE)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)))
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    String galimosRaides = "aąbcčdeęėfghiįyjklmnoprsštuūųvzž";

    private Boolean tikrintiZodi(String tekstas) {
        Boolean leista = false;
        for (char c : tekstas.toCharArray()) {
            leista = false;
            for (char raide : galimosRaides.toCharArray()) {
                if (c == raide || c == Character.toUpperCase(raide)) {
                    leista = true;
                    break;
                }
            }
            if (!leista) {
                break;
            }
        }
        return leista;
    }

    public static Boolean zaidimas = false;
    static Boolean sustabdyta = false;
    static int busena = 3;
    static int gyvybes;
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if (jButton1.getText().equals("Atšaukti")) {
            jButton1.setText("Pradėti");
            sustabdyta = true;
        } else {
            if (tikrintiZodi(jTextField1.getText()) && jTextField1.getText().length() > 1) //input apribojimai
            {
                gija = new Gija();
                jButton1.setText("Atšaukti");
                sustabdyta = false;
                //padaryti kazka su animacijom
                zodis = new Zodis(jTextField1.getText().toLowerCase());
                jTextField2.setText(zodis.Atvaizdavimas());
                zaidimas = true;
                gyvybes = 6;
                jLabel3.setText(Integer.toString(gyvybes));
                speliotojas.Pazadinti(zodis.pasleptasZodis);
                gija.start(zodis);
                //Task zaisti = new Task(() => pradeti(zodis));
                //Thread.Sleep(50);
                //zaisti.Start();
            }
        }

        //jLabel5.setVisible(false);    

    }//GEN-LAST:event_jButton1ActionPerformed

    private static void apdorojamasSpejimas(Zodis zodis, char spejimas) throws InterruptedException {
        busena = 0;
        animacija();
        Thread.sleep(500);
        if (!sustabdyta) {
            if (zodis.Spejimas(spejimas)) {

                jTextField2.setText(zodis.Atvaizdavimas());
                System.out.println("spejimas: " + spejimas);
                //output for log
                if (!zodis.ArAtspejoZodi()) {
                    busena = 1;
                    animacija();
                    speliotojas.RaidesAtspejimoSekme(true, spejimas);
                } else //zaidimas baigtas, AI laimejo
                {
                    System.out.println("laimejo");
                    //output for log
                    busena = 3;
                    animacija();
                    zaidimas = false;
                    jButton1.setText("Pradėti");
                    perduotAtsakyma(true, zodis.GautiZodi());
                    //ideti animacija, ar kaip kitaip atvaizduoti pergale
                }
            } else {
                gyvybes--;
                jLabel3.setText(Integer.toString(gyvybes));
                System.out.println("spejimas: " + spejimas);
                //output for log
                if (gyvybes != 0) {
                    busena = 2;
                    animacija();
                    speliotojas.RaidesAtspejimoSekme(false, spejimas);
                } else //zaidimas baigtas - AI pralaimejo
                {
                    System.out.println("praleimejo");
                    //output for log
                    busena = 3;
                    animacija();
                    zaidimas = false;
                    jButton1.setText("Pradėti");
                    perduotAtsakyma(false, zodis.GautiZodi());
                    //ideti animacija, ar kaip kitaip atvaizduoti pralaimejima
                }
            }
            Thread.sleep(500);
            //Thread.Sleep(1000);// atspejo/neatspejo animacijai isskirtas laikas
        } else {
            busena = 3;
            animacija();
            zaidimas = false;
        }
    }

    private static void perduotAtsakyma(boolean pasisekimas, String zodis) {
        try {
            speliotojas.GautAtsakyma(pasisekimas, zodis);
        } catch (SQLException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void animacija() {
           
        try {            
            clip = AudioSystem.getClip();
        } catch (LineUnavailableException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }  
        try {            
            if (busena == 0) //galvoja
            {
                jLabel4.setVisible(true);
                ImageIcon imgIcon = new ImageIcon("../slamstas/load.gif");
                jLabel4.setIcon(imgIcon);

                ImageIcon homerThinking = new ImageIcon("../slamstas/homer_simpson_thinking.png");
                Image homerDrinking = homerThinking.getImage().getScaledInstance(86, 120, Image.SCALE_SMOOTH);
                jLabel5.setIcon(new ImageIcon(homerDrinking));
            } else if (busena == 1) //atspejo
            {
                jLabel4.setVisible(false);
                ImageIcon homerWasRight = new ImageIcon("../slamstas/woohoo.gif");
                jLabel5.setIcon(homerWasRight);

                clip.open(AudioSystem.getAudioInputStream(atspejoF));
                clip.start();
            } else if (busena == 2) //neatspejo
            {
                jLabel4.setVisible(false);
                ImageIcon homerWasWrong = new ImageIcon("../slamstas/Homer_simpsondoh.png");
                Image homerDoh = homerWasWrong.getImage().getScaledInstance(141, 120, Image.SCALE_SMOOTH);
                jLabel5.setIcon(new ImageIcon(homerDoh));

                clip.open(AudioSystem.getAudioInputStream(neatspejoF));
                clip.start();    
            } else //laukia
            {
                jLabel4.setVisible(true);
                ImageIcon Zzz = new ImageIcon("../slamstas/zz.gif");
                jLabel4.setIcon(Zzz);
                ImageIcon homerHasDoneHisJob = new ImageIcon("../slamstas/sleeping.png");
                Image homerIsSleeping = homerHasDoneHisJob.getImage().getScaledInstance(200, 110, Image.SCALE_SMOOTH);
                jLabel5.setIcon(new ImageIcon(homerIsSleeping));
            }
        } catch (Exception ex) {
        }
    }

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        zaidimas = false;
        gija.stop();
        System.err.println("formWindowClosing");
    }//GEN-LAST:event_formWindowClosing

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
    private static javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private static javax.swing.JLabel jLabel3;
    private static javax.swing.JLabel jLabel4;
    private static javax.swing.JLabel jLabel5;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTextField jTextField1;
    private static javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
