/*/
 * @author Radu Ionescu
/*/
package user_interface;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import utilities.Database;

public class AddOptionDialog extends javax.swing.JDialog 
    {
    ImageIcon icon;
    public AddOptionDialog(java.awt.Frame parent, boolean modal) 
        {
        super(parent, modal);
        initComponents();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(screenSize.width/2-this.getMinimumSize().width/2,screenSize.height/2-this.getMinimumSize().height/2,247,187);
        }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        tPhone = new javax.swing.JTextField();
        lPhone = new javax.swing.JLabel();
        pAdd = new javax.swing.JPanel();
        lName = new javax.swing.JLabel();
        lPrice = new javax.swing.JLabel();
        lDescription = new javax.swing.JLabel();
        tName = new javax.swing.JTextField();
        tPrice = new javax.swing.JTextField();
        tDescription = new javax.swing.JTextField();
        lID1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        bAdd = new javax.swing.JButton();

        jLabel5.setText("jLabel5");

        jTextField1.setText("jTextField1");

        jTextField6.setText("jTextField6");

        lPhone.setForeground(new java.awt.Color(196, 230, 255));
        lPhone.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lPhone.setText("Phone Number:");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add Option");
        setBackground(new java.awt.Color(51, 51, 51));
        setMinimumSize(new java.awt.Dimension(500, 330));
        setPreferredSize(new java.awt.Dimension(800, 500));
        setResizable(false);
        setSize(new java.awt.Dimension(800, 500));

        pAdd.setBackground(new java.awt.Color(44, 44, 44));

        lName.setForeground(new java.awt.Color(196, 230, 255));
        lName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lName.setText("Name:");

        lPrice.setForeground(new java.awt.Color(196, 230, 255));
        lPrice.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lPrice.setText("Price:");

        lDescription.setForeground(new java.awt.Color(196, 230, 255));
        lDescription.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lDescription.setText("Description:");

        lID1.setForeground(new java.awt.Color(196, 230, 255));
        lID1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lID1.setText("Picture:");

        jButton1.setBackground(new java.awt.Color(44, 44, 44));
        jButton1.setText("Choose...");
        jButton1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        bAdd.setBackground(new java.awt.Color(44, 44, 44));
        bAdd.setForeground(new java.awt.Color(196, 230, 255));
        bAdd.setText("Add Option");
        bAdd.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                bAddActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout pAddLayout = new org.jdesktop.layout.GroupLayout(pAdd);
        pAdd.setLayout(pAddLayout);
        pAddLayout.setHorizontalGroup(
            pAddLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pAddLayout.createSequentialGroup()
                .add(pAddLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, pAddLayout.createSequentialGroup()
                        .add(pAddLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, lName, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, lPrice, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, lDescription, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
                            .add(lID1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(pAddLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(tName)
                            .add(tPrice)
                            .add(tDescription)
                            .add(jButton1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)))
                    .add(pAddLayout.createSequentialGroup()
                        .addContainerGap()
                        .add(pAddLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(bAdd, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        pAddLayout.setVerticalGroup(
            pAddLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pAddLayout.createSequentialGroup()
                .addContainerGap()
                .add(pAddLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lName)
                    .add(tName, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(pAddLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(tPrice, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(lPrice))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(pAddLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(tDescription, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(lDescription))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(pAddLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lID1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 33, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jButton1))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 133, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(bAdd, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 32, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pAdd, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pAdd, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAddActionPerformed
        new Database().insertOption(tName.getText(), tPrice.getText(), tDescription.getText());
        this.dispose();
    }//GEN-LAST:event_bAddActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton1ActionPerformed
    {//GEN-HEADEREND:event_jButton1ActionPerformed
       JFileChooser fc = new JFileChooser();
                int result = fc.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File file = fc.getSelectedFile();
                    try 
                    {
                        jLabel1.setIcon(new ImageIcon(ImageIO.read(file)));
                    } 
                    catch (IOException e) 
                    {
                        e.printStackTrace();
                    }
                }
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAdd;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JLabel lDescription;
    private javax.swing.JLabel lID1;
    private javax.swing.JLabel lName;
    private javax.swing.JLabel lPhone;
    private javax.swing.JLabel lPrice;
    private javax.swing.JPanel pAdd;
    private javax.swing.JTextField tDescription;
    private javax.swing.JTextField tName;
    private javax.swing.JTextField tPhone;
    private javax.swing.JTextField tPrice;
    // End of variables declaration//GEN-END:variables
    }
