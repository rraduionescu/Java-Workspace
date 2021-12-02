/*/
 * @author Radu Ionescu
/*/
package GraphicInterface;

import MyClasses.*;
import java.awt.*;
import javax.swing.JOptionPane;

public class AddDialog extends javax.swing.JDialog 
    {
    public AddDialog(java.awt.Frame parent, boolean modal) 
        {
        super(parent, modal);
        initComponents();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(screenSize.width/2-this.getMinimumSize().width/2,screenSize.height/2-this.getMinimumSize().height/2,247,187);
        }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        pAdd = new javax.swing.JPanel();
        lFirst = new javax.swing.JLabel();
        lLast = new javax.swing.JLabel();
        lID = new javax.swing.JLabel();
        lPhone = new javax.swing.JLabel();
        tFirst = new javax.swing.JTextField();
        tLast = new javax.swing.JTextField();
        tID = new javax.swing.JTextField();
        tPhone = new javax.swing.JTextField();
        bAdd = new javax.swing.JButton();

        jLabel5.setText("jLabel5");

        jTextField1.setText("jTextField1");

        jTextField6.setText("jTextField6");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add User");
        setBackground(new java.awt.Color(51, 51, 51));
        setResizable(false);

        pAdd.setBackground(new java.awt.Color(51, 51, 51));

        lFirst.setForeground(new java.awt.Color(0, 200, 230));
        lFirst.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lFirst.setText("First Name:");

        lLast.setForeground(new java.awt.Color(0, 200, 230));
        lLast.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lLast.setText("Last Name:");

        lID.setForeground(new java.awt.Color(0, 200, 230));
        lID.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lID.setText("ID Number:");

        lPhone.setForeground(new java.awt.Color(0, 200, 230));
        lPhone.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lPhone.setText("Phone Number:");

        bAdd.setBackground(new java.awt.Color(0, 0, 0));
        bAdd.setForeground(new java.awt.Color(0, 200, 230));
        bAdd.setText("Add User");
        bAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAddActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout pAddLayout = new org.jdesktop.layout.GroupLayout(pAdd);
        pAdd.setLayout(pAddLayout);
        pAddLayout.setHorizontalGroup(
            pAddLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pAddLayout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(pAddLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                    .add(bAdd, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(pAddLayout.createSequentialGroup()
                        .add(pAddLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(lFirst, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(lPhone, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                            .add(lID, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(lLast, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(pAddLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(tLast, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                            .add(tFirst)
                            .add(tID)
                            .add(tPhone)))))
        );
        pAddLayout.setVerticalGroup(
            pAddLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pAddLayout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(pAddLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lFirst)
                    .add(tFirst, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(pAddLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lLast)
                    .add(tLast, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(pAddLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lID)
                    .add(tID, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(pAddLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lPhone)
                    .add(tPhone, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(bAdd))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pAdd, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pAdd, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAddActionPerformed
        try {
            Interface.book.addUser(new User(tFirst.getText(),tLast.getText(),Long.parseLong(tID.getText()),Long.parseLong(tPhone.getText())));
            this.setVisible(false);
            }
        catch(RException e)
            {
            JOptionPane.showMessageDialog(this,e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);   
            }
    }//GEN-LAST:event_bAddActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAdd;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JLabel lFirst;
    private javax.swing.JLabel lID;
    private javax.swing.JLabel lLast;
    private javax.swing.JLabel lPhone;
    private javax.swing.JPanel pAdd;
    private javax.swing.JTextField tFirst;
    private javax.swing.JTextField tID;
    private javax.swing.JTextField tLast;
    private javax.swing.JTextField tPhone;
    // End of variables declaration//GEN-END:variables
    }
