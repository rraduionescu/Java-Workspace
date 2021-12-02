/*/
 * @author Radu Ionescu
/*/
package GraphicInterface;

import MyClasses.*;
import java.awt.*;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

public class ModifyDialog extends javax.swing.JDialog 
    {
    User user;
    public ModifyDialog(java.awt.Frame parent, boolean modal,String a,String b,String c,String d,int e,TableModel f) 
        {
        super(parent, modal);
        initComponents();
        CFN.setText(a);
        CLN.setText(b);
        IN.setText(c);
        PN.setText(d);
        if(f==Interface.book) user = Interface.book.b.get(e);
            else user = Interface.searchBook.b.get(e);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(screenSize.width/2-this.getMinimumSize().width/2,screenSize.height/2-this.getMinimumSize().height/2,427,190);
        TimerTask task = new TimerTask()
                                    {
                                    public void run() 
                                        {
                                        if(tCFN.getText().length()>0&&tCFN.getText().compareToIgnoreCase(CFN.getText())!=0)CFN.setForeground(Color.RED);
                                            else if(tCFN.getText().compareToIgnoreCase(CFN.getText())==0)CFN.setForeground(Color.GREEN);
                                                else CFN.setForeground(Color.GREEN);
                                        if(tCLN.getText().length()>0&&tCLN.getText().compareToIgnoreCase(CLN.getText())!=0)CLN.setForeground(Color.RED);
                                            else if(tCLN.getText().compareToIgnoreCase(CLN.getText())==0)CLN.setForeground(Color.GREEN);
                                                else CLN.setForeground(Color.GREEN);
                                        if(tIN.getText().length()>0&&tIN.getText().compareToIgnoreCase(IN.getText())!=0)IN.setForeground(Color.RED);
                                            else if(tIN.getText().compareToIgnoreCase(IN.getText())==0)IN.setForeground(Color.GREEN);
                                                else IN.setForeground(Color.GREEN);
                                        if(tPN.getText().length()>0&&tPN.getText().compareToIgnoreCase(PN.getText())!=0)PN.setForeground(Color.RED);
                                            else if(tPN.getText().compareToIgnoreCase(PN.getText())==0)PN.setForeground(Color.GREEN);
                                                else PN.setForeground(Color.GREEN);
                                        }
                                    };
        Timer timer = new Timer();
        timer.schedule(task,0,75);
        }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        pModify = new javax.swing.JPanel();
        lCFN = new javax.swing.JLabel();
        lCLN = new javax.swing.JLabel();
        lIN = new javax.swing.JLabel();
        lPN = new javax.swing.JLabel();
        CFN = new javax.swing.JLabel();
        CLN = new javax.swing.JLabel();
        IN = new javax.swing.JLabel();
        PN = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tCFN = new javax.swing.JTextField();
        tCLN = new javax.swing.JTextField();
        tIN = new javax.swing.JTextField();
        tPN = new javax.swing.JTextField();
        bModify = new javax.swing.JButton();

        jLabel5.setText("jLabel5");

        jLabel10.setText("jLabel10");

        jLabel6.setText("jLabel6");

        jTextField5.setText("jTextField5");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Modify User");
        setResizable(false);

        pModify.setBackground(new java.awt.Color(51, 51, 51));

        lCFN.setForeground(new java.awt.Color(0, 200, 230));
        lCFN.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lCFN.setText("Current First Name:");

        lCLN.setForeground(new java.awt.Color(0, 200, 230));
        lCLN.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lCLN.setText("Current Last Name:");

        lIN.setForeground(new java.awt.Color(0, 200, 230));
        lIN.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lIN.setText("Current ID Number:");

        lPN.setForeground(new java.awt.Color(0, 200, 230));
        lPN.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lPN.setText("Current Phone Number:");

        CFN.setForeground(new java.awt.Color(0, 200, 230));
        CFN.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CFN.setText("jLabel6");

        CLN.setForeground(new java.awt.Color(0, 200, 230));
        CLN.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CLN.setText("jLabel7");

        IN.setForeground(new java.awt.Color(0, 200, 230));
        IN.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        IN.setText("jLabel8");

        PN.setForeground(new java.awt.Color(0, 200, 230));
        PN.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PN.setText("jLabel9");

        jLabel1.setForeground(new java.awt.Color(0, 200, 230));
        jLabel1.setText("Change to:");

        jLabel2.setForeground(new java.awt.Color(0, 200, 230));
        jLabel2.setText("Change to:");

        jLabel3.setForeground(new java.awt.Color(0, 200, 230));
        jLabel3.setText("Change to:");

        jLabel4.setForeground(new java.awt.Color(0, 200, 230));
        jLabel4.setText("Change to:");

        bModify.setBackground(new java.awt.Color(0, 0, 0));
        bModify.setForeground(new java.awt.Color(0, 200, 230));
        bModify.setText("Modify User");
        bModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bModifyActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout pModifyLayout = new org.jdesktop.layout.GroupLayout(pModify);
        pModify.setLayout(pModifyLayout);
        pModifyLayout.setHorizontalGroup(
            pModifyLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pModifyLayout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(pModifyLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                    .add(bModify, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(pModifyLayout.createSequentialGroup()
                        .add(pModifyLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, lCLN, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, lIN, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(org.jdesktop.layout.GroupLayout.LEADING, lPN, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(lCFN, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(pModifyLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(IN, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .add(PN, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(CLN, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(CFN, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(pModifyLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(jLabel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(jLabel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(jLabel3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(jLabel4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(pModifyLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(tCFN)
                            .add(tCLN)
                            .add(tIN)
                            .add(tPN, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)))))
        );
        pModifyLayout.setVerticalGroup(
            pModifyLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pModifyLayout.createSequentialGroup()
                .addContainerGap()
                .add(pModifyLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lCFN)
                    .add(CFN)
                    .add(jLabel1)
                    .add(tCFN, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(pModifyLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lCLN)
                    .add(CLN)
                    .add(jLabel2)
                    .add(tCLN, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(pModifyLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lIN)
                    .add(IN)
                    .add(jLabel3)
                    .add(tIN, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(pModifyLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(lPN)
                    .add(PN)
                    .add(jLabel4)
                    .add(tPN, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(bModify)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pModify, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(pModify, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bModifyActionPerformed
        try {
            if(tCFN.getText().length()>0)Interface.book.modifyFirstName(user,tCFN.getText());
            if(tCLN.getText().length()>0)Interface.book.modifyLastName(user,tCLN.getText());
            if(tIN.getText().length()>0)Interface.book.modifyID(user,Long.parseLong(tIN.getText()));
            if(tPN.getText().length()>0)Interface.book.modifyPhoneNumber(user,Long.parseLong(tPN.getText()));
            if(tCFN.getText().length()>0)Interface.searchBook.modifyFirstName(user,tCFN.getText());
            if(tCLN.getText().length()>0)Interface.searchBook.modifyLastName(user,tCLN.getText());
            if(tIN.getText().length()>0)Interface.searchBook.modifyID(user,Long.parseLong(tIN.getText()));
            if(tPN.getText().length()>0)Interface.searchBook.modifyPhoneNumber(user,Long.parseLong(tPN.getText()));
            this.setVisible(false);
            }
        catch(RException e)
            {
             JOptionPane.showMessageDialog(this,e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);  
            }
    }//GEN-LAST:event_bModifyActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CFN;
    private javax.swing.JLabel CLN;
    private javax.swing.JLabel IN;
    private javax.swing.JLabel PN;
    private javax.swing.JButton bModify;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JLabel lCFN;
    private javax.swing.JLabel lCLN;
    private javax.swing.JLabel lIN;
    private javax.swing.JLabel lPN;
    private javax.swing.JPanel pModify;
    private javax.swing.JTextField tCFN;
    private javax.swing.JTextField tCLN;
    private javax.swing.JTextField tIN;
    private javax.swing.JTextField tPN;
    // End of variables declaration//GEN-END:variables
}
