/*/
 * @author Radu Ionescu
/*/
package GraphicInterface;

import MyClasses.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;
import java.io.*;
import java.util.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Interface extends javax.swing.JFrame 
    {
    static Book book = new Book(),searchBook = new Book();             
    String regCode = "12345";
    File autoSave,autoOpen;
    public Interface() 
        {
        SplashScreen mySplash = SplashScreen.getSplashScreen();
        splashInit();           
        appInit();
        if (mySplash!=null)mySplash.close();   
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Thread t = new Thread()
                        {
                        public void run() 
                            {
                            for(int i=0;i<=518400;i++)
                                {
                                if(i%2==0)lAd.setIcon(new ImageIcon(getClass().getResource("/GraphicInterface/Ad1.png")));
                                    else lAd.setIcon(new ImageIcon(getClass().getResource("/GraphicInterface/Ad2.png")));
                                try{Thread.sleep(3000);}
                                catch(InterruptedException e){e.printStackTrace();}
                                }
                            }
                         };
        initComponents();   
        /*autoOpen = new File("open.pbo");
        FileInputStream saveFile=new FileInputStream(autoOpen);
        ObjectInputStream saves = new ObjectInputStream(saveFile);
        book.openBook((File)(saves.readObject()));
        lInfo.setText("Displayed: Complete book.");
        saves.close(); */
        if(book.b.size()==0)lInfo.setText("Displayed: Empty book.");
        else lInfo.setText("Displayed: Complete book.");
        tDisplay.addMouseListener(new MouseAdapter() 
            {
            public void mouseClicked(java.awt.event.MouseEvent evt) 
                {
                 if(evt.getClickCount()==2)
                    {
                    int row = tDisplay.rowAtPoint(evt.getPoint());
                    int col = tDisplay.columnAtPoint(evt.getPoint());
                    if (row >= 0 && col >= 0)   
                        {
                        String a,b,c,d;
                        a=tDisplay.getModel().getValueAt(tDisplay.getSelectedRow(),0).toString();
                        b=tDisplay.getModel().getValueAt(tDisplay.getSelectedRow(),1).toString();
                        c=tDisplay.getModel().getValueAt(tDisplay.getSelectedRow(),2).toString();
                        d=tDisplay.getModel().getValueAt(tDisplay.getSelectedRow(),3).toString();
                        ModifyDialog modify = new ModifyDialog(Interface.this,true,a,b,c,d,tDisplay.getSelectedRow(),tDisplay.getModel());
                        modify.setVisible(true);
                        }
                    }
                } 
            });
        tDisplay.addKeyListener(new KeyAdapter() 
            {
            public void keyPressed(KeyEvent e) 
                {
                if(e.getKeyCode()==KeyEvent.VK_ENTER)
                    {
                        String a,b,c,d;
                        a=tDisplay.getModel().getValueAt(tDisplay.getSelectedRow(),0).toString();
                        b=tDisplay.getModel().getValueAt(tDisplay.getSelectedRow(),1).toString();
                        c=tDisplay.getModel().getValueAt(tDisplay.getSelectedRow(),2).toString();
                        d=tDisplay.getModel().getValueAt(tDisplay.getSelectedRow(),3).toString();
                        ModifyDialog modify = new ModifyDialog(Interface.this,true,a,b,c,d,tDisplay.getSelectedRow(),tDisplay.getModel());
                        modify.setVisible(true);
                    }
                if(e.getKeyCode()==KeyEvent.VK_BACK_SPACE)
                    {
                    if(tDisplay.getSelectedRow()>=0)
                        {
                        User f;
                        if(tDisplay.getModel()==book)f = book.b.get(tDisplay.getSelectedRow());
                            else f = searchBook.b.get(tDisplay.getSelectedRow());
                        Object[] options = {"Yes","No"};
                        int n = JOptionPane.showOptionDialog(Interface.this,
                        "\bDo you really want to remove the user "+tDisplay.getModel().getValueAt(tDisplay.getSelectedRow(),1)+" "+tDisplay.getModel().getValueAt(tDisplay.getSelectedRow(),0)+"?\n"
                        +"All data will be erased!!\n",
                        "Warning!",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE,
                        null,
                        options,
                        options[1]);
                        if(n==JOptionPane.YES_OPTION)
                            {
                            book.removeUser(f);
                            searchBook.removeUser(f);
                            }
                        }
                    else {JOptionPane.showMessageDialog(Interface.this,"No user is selected!!!","ERROR",JOptionPane.ERROR_MESSAGE);}
                    }
                }
            });
        tDisplay.getTableHeader().setReorderingAllowed(false);
        tDisplay.getTableHeader().addMouseListener(new MouseAdapter()
            {
            public void mouseClicked(java.awt.event.MouseEvent evt)
                {
                int col = tDisplay.getTableHeader().columnAtPoint(evt.getPoint());
                if(evt.getClickCount()==1)
                    {
                    if(col==0)book.sortByFirstName();
                    if(col==1)book.sortByLastName();
                    if(col==2)book.sortByID();
                    if(col==3)book.sortByPhoneNumber();
                    }
                }
            });
        TimerTask save = new TimerTask()
            {
            public void run() 
                {
                if(autoSave!=null)book.saveBook(autoSave);
                }
            };
        TimerTask clock = new TimerTask()
            {
            public void run() 
                {
                GregorianCalendar current = new GregorianCalendar();
                String hour,minute,second;
                hour = String.valueOf(current.get(GregorianCalendar.HOUR));
                if(current.get(GregorianCalendar.MINUTE)<10)minute = "0"+String.valueOf(current.get(GregorianCalendar.MINUTE));
                    else minute = String.valueOf(current.get(GregorianCalendar.MINUTE));
                if(current.get(GregorianCalendar.SECOND)<10)second = "0"+String.valueOf(current.get(GregorianCalendar.SECOND));
                    else second = String.valueOf(current.get(GregorianCalendar.SECOND));
		lClock.setText(hour+":"+minute+":"+second);     
                }
            };
        java.util.Timer saver = new java.util.Timer();
        saver.schedule(save,0,5*60*1000);
        saver.schedule(clock,0,1000);
        setBounds(screenSize.width/2-this.getMinimumSize().width/2,screenSize.height/2-this.getMinimumSize().height/2,this.getMinimumSize().width,this.getMinimumSize().height);
        try{t.start();}catch(Exception e){}
        try{Image icon = ImageIO.read(getClass().getResource("/GraphicInterface/iPowerBook.png"));this.setIconImage(icon);}catch(Exception e){}
        tDisplay.setModel(book);
        tDisplay.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        fileChooser.setMultiSelectionEnabled(false);
        fileChooser.addChoosableFileFilter(new PBDFilter());
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        }
    @SuppressWarnings("unchecked") 
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        fileChooser = new javax.swing.JFileChooser();
        bgSearch = new javax.swing.ButtonGroup();
        bgSort = new javax.swing.ButtonGroup();
        jRadioButton5 = new javax.swing.JRadioButton();
        scrollPanel = new javax.swing.JScrollPane();
        tDisplay = new javax.swing.JTable();
        pS = new javax.swing.JPanel();
        searchPanel = new javax.swing.JPanel();
        lSearch = new javax.swing.JLabel();
        tSearch = new javax.swing.JTextField();
        lBy = new javax.swing.JLabel();
        rFirst = new javax.swing.JRadioButton();
        rLast = new javax.swing.JRadioButton();
        rID = new javax.swing.JRadioButton();
        rPhone = new javax.swing.JRadioButton();
        bSearch = new javax.swing.JButton();
        sSeparator = new javax.swing.JSeparator();
        sortPanel = new javax.swing.JPanel();
        lSort = new javax.swing.JLabel();
        rsFirst = new javax.swing.JRadioButton();
        rsID = new javax.swing.JRadioButton();
        rsLast = new javax.swing.JRadioButton();
        rsPhone = new javax.swing.JRadioButton();
        bSort = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        pButtons = new javax.swing.JPanel();
        bAdd = new javax.swing.JButton();
        bRemove = new javax.swing.JButton();
        bModify = new javax.swing.JButton();
        bQuit = new javax.swing.JButton();
        lAd = new javax.swing.JLabel();
        pInfo = new javax.swing.JPanel();
        bBack = new javax.swing.JButton();
        lClock = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        lInfo = new javax.swing.JLabel();
        mBar = new javax.swing.JMenuBar();
        mFile = new javax.swing.JMenu();
        fOpen = new javax.swing.JMenuItem();
        fSave = new javax.swing.JMenuItem();
        fSeparator = new javax.swing.JPopupMenu.Separator();
        fQuit = new javax.swing.JMenuItem();
        mUsers = new javax.swing.JMenu();
        uAdd = new javax.swing.JMenuItem();
        uRemove = new javax.swing.JMenuItem();
        uModify = new javax.swing.JMenuItem();
        uSearch = new javax.swing.JMenuItem();
        mHelp = new javax.swing.JMenu();
        hRegister = new javax.swing.JMenuItem();
        hSeparator = new javax.swing.JPopupMenu.Separator();
        hAbout = new javax.swing.JMenuItem();

        fileChooser.setAcceptAllFileFilterUsed(false);

        jRadioButton5.setText("jRadioButton5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Power Book™");
        setBackground(new java.awt.Color(102, 102, 102));
        setForeground(new java.awt.Color(0, 0, 0));
        setMinimumSize(new java.awt.Dimension(670, 620));
        setPreferredSize(new java.awt.Dimension(671, 575));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        tDisplay.setBackground(new java.awt.Color(51, 51, 51));
        tDisplay.setBorder(new javax.swing.border.SoftBevelBorder(0));
        tDisplay.setForeground(new java.awt.Color(0, 200, 230));
        tDisplay.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "First Name", "Last Name", "ID Number", "Phone Number"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollPanel.setViewportView(tDisplay);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 499;
        gridBagConstraints.ipady = 455;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(scrollPanel, gridBagConstraints);

        pS.setLayout(new java.awt.GridBagLayout());

        searchPanel.setBackground(new java.awt.Color(51, 51, 51));
        searchPanel.setBorder(new javax.swing.border.SoftBevelBorder(0));
        searchPanel.setPreferredSize(new java.awt.Dimension(142, 265));

        lSearch.setForeground(new java.awt.Color(0, 200, 230));
        lSearch.setText("Search for:");

        lBy.setForeground(new java.awt.Color(0, 200, 230));
        lBy.setText("by:");

        bgSearch.add(rFirst);
        rFirst.setForeground(new java.awt.Color(0, 200, 230));
        rFirst.setText("First Name");

        bgSearch.add(rLast);
        rLast.setForeground(new java.awt.Color(0, 200, 230));
        rLast.setText("Last Name");

        bgSearch.add(rID);
        rID.setForeground(new java.awt.Color(0, 200, 230));
        rID.setText("ID Number");

        bgSearch.add(rPhone);
        rPhone.setForeground(new java.awt.Color(0, 200, 230));
        rPhone.setText("Phone Number");

        bSearch.setBackground(new java.awt.Color(0, 0, 0));
        bSearch.setForeground(new java.awt.Color(0, 200, 230));
        bSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GraphicInterface/iDefault.png"))); // NOI18N
        bSearch.setText("Search");
        bSearch.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/GraphicInterface/iSearch.png"))); // NOI18N
        bSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout searchPanelLayout = new javax.swing.GroupLayout(searchPanel);
        searchPanel.setLayout(searchPanelLayout);
        searchPanelLayout.setHorizontalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rFirst, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(searchPanelLayout.createSequentialGroup()
                        .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sSeparator)
                            .addGroup(searchPanelLayout.createSequentialGroup()
                                .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                    .addComponent(lBy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(bSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tSearch))
                        .addContainerGap())
                    .addComponent(rLast, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rPhone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        searchPanelLayout.setVerticalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchPanelLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(lSearch)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lBy)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rFirst)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rLast)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rID)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rPhone)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bSearch)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 0.5;
        pS.add(searchPanel, gridBagConstraints);

        sortPanel.setBackground(new java.awt.Color(51, 51, 51));
        sortPanel.setBorder(new javax.swing.border.SoftBevelBorder(0));

        lSort.setForeground(new java.awt.Color(0, 200, 230));
        lSort.setText("Sort by:");

        bgSort.add(rsFirst);
        rsFirst.setForeground(new java.awt.Color(0, 200, 230));
        rsFirst.setText("First Name");

        bgSort.add(rsID);
        rsID.setForeground(new java.awt.Color(0, 200, 230));
        rsID.setText("ID Number");

        bgSort.add(rsLast);
        rsLast.setForeground(new java.awt.Color(0, 200, 230));
        rsLast.setText("Last Name");
        rsLast.setPreferredSize(new java.awt.Dimension(142, 23));

        bgSort.add(rsPhone);
        rsPhone.setForeground(new java.awt.Color(0, 200, 230));
        rsPhone.setText("Phone Number");

        bSort.setBackground(new java.awt.Color(0, 0, 0));
        bSort.setForeground(new java.awt.Color(0, 200, 230));
        bSort.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GraphicInterface/iDefault.png"))); // NOI18N
        bSort.setText("Sort");
        bSort.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/GraphicInterface/iSort.png"))); // NOI18N
        bSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSortActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout sortPanelLayout = new javax.swing.GroupLayout(sortPanel);
        sortPanel.setLayout(sortPanelLayout);
        sortPanelLayout.setHorizontalGroup(
            sortPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sortPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sortPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addComponent(rsID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rsFirst, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rsLast, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(rsPhone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(sortPanelLayout.createSequentialGroup()
                        .addGroup(sortPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lSort, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bSort, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        sortPanelLayout.setVerticalGroup(
            sortPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sortPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lSort)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rsFirst)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rsLast, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rsID)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rsPhone)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bSort)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 0.5;
        pS.add(sortPanel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(pS, gridBagConstraints);

        pButtons.setBackground(new java.awt.Color(51, 51, 51));
        pButtons.setBorder(new javax.swing.border.SoftBevelBorder(0));
        pButtons.setLayout(new java.awt.GridBagLayout());

        bAdd.setBackground(new java.awt.Color(0, 0, 0));
        bAdd.setForeground(new java.awt.Color(0, 200, 230));
        bAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GraphicInterface/iDefault.png"))); // NOI18N
        bAdd.setText("Add");
        bAdd.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/GraphicInterface/iAdd.png"))); // NOI18N
        bAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAddActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 52;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 6, 0, 0);
        pButtons.add(bAdd, gridBagConstraints);

        bRemove.setBackground(new java.awt.Color(0, 0, 0));
        bRemove.setForeground(new java.awt.Color(0, 200, 230));
        bRemove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GraphicInterface/iDefault.png"))); // NOI18N
        bRemove.setText("Remove");
        bRemove.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/GraphicInterface/iRemove.png"))); // NOI18N
        bRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRemoveActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 32;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 6, 0, 0);
        pButtons.add(bRemove, gridBagConstraints);

        bModify.setBackground(new java.awt.Color(0, 0, 0));
        bModify.setForeground(new java.awt.Color(0, 200, 230));
        bModify.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GraphicInterface/iDefault.png"))); // NOI18N
        bModify.setText("Modify");
        bModify.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/GraphicInterface/iModify.png"))); // NOI18N
        bModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bModifyActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 38;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 6, 0, 0);
        pButtons.add(bModify, gridBagConstraints);

        bQuit.setBackground(new java.awt.Color(0, 0, 0));
        bQuit.setForeground(new java.awt.Color(0, 200, 230));
        bQuit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GraphicInterface/iDefault.png"))); // NOI18N
        bQuit.setText("Quit");
        bQuit.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/GraphicInterface/iQuit.png"))); // NOI18N
        bQuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bQuitActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 52;
        gridBagConstraints.weightx = 1.0;
        pButtons.add(bQuit, gridBagConstraints);

        lAd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 5, 0);
        pButtons.add(lAd, gridBagConstraints);

        pInfo.setBackground(new java.awt.Color(51, 51, 51));
        pInfo.setLayout(new java.awt.GridBagLayout());

        bBack.setBackground(new java.awt.Color(0, 0, 0));
        bBack.setForeground(new java.awt.Color(0, 200, 230));
        bBack.setText("Back to complete book");
        bBack.setEnabled(false);
        bBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBackActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 11;
        pInfo.add(bBack, gridBagConstraints);

        lClock.setForeground(new java.awt.Color(0, 200, 230));
        lClock.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 74;
        gridBagConstraints.ipady = 21;
        pInfo.add(lClock, gridBagConstraints);

        jSeparator2.setForeground(new java.awt.Color(0, 200, 230));
        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 11;
        gridBagConstraints.ipady = 22;
        pInfo.add(jSeparator2, gridBagConstraints);

        jSeparator3.setForeground(new java.awt.Color(0, 200, 230));
        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 11;
        gridBagConstraints.ipady = 22;
        pInfo.add(jSeparator3, gridBagConstraints);

        lInfo.setForeground(new java.awt.Color(0, 200, 230));
        lInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 365;
        gridBagConstraints.ipady = 21;
        gridBagConstraints.weightx = 1.0;
        pInfo.add(lInfo, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        pButtons.add(pInfo, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 205;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(pButtons, gridBagConstraints);

        mFile.setText("File");

        fOpen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GraphicInterface/iOpen.png"))); // NOI18N
        fOpen.setText("Open...");
        fOpen.setEnabled(false);
        fOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fOpenActionPerformed(evt);
            }
        });
        mFile.add(fOpen);

        fSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GraphicInterface/iSave.png"))); // NOI18N
        fSave.setText("Save...");
        fSave.setEnabled(false);
        fSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fSaveActionPerformed(evt);
            }
        });
        mFile.add(fSave);
        mFile.add(fSeparator);

        fQuit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GraphicInterface/iQuit.png"))); // NOI18N
        fQuit.setText("Quit");
        fQuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fQuitActionPerformed(evt);
            }
        });
        mFile.add(fQuit);

        mBar.add(mFile);

        mUsers.setText("Users");

        uAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GraphicInterface/iAdd.png"))); // NOI18N
        uAdd.setText("Add");
        uAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uAddActionPerformed(evt);
            }
        });
        mUsers.add(uAdd);

        uRemove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GraphicInterface/iRemove.png"))); // NOI18N
        uRemove.setText("Remove");
        uRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uRemoveActionPerformed(evt);
            }
        });
        mUsers.add(uRemove);

        uModify.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GraphicInterface/iModify.png"))); // NOI18N
        uModify.setText("Modify");
        uModify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uModifyActionPerformed(evt);
            }
        });
        mUsers.add(uModify);

        uSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GraphicInterface/iSearch.png"))); // NOI18N
        uSearch.setText("Search");
        uSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uSearchActionPerformed(evt);
            }
        });
        mUsers.add(uSearch);

        mBar.add(mUsers);

        mHelp.setText("Help");

        hRegister.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GraphicInterface/iRegister.png"))); // NOI18N
        hRegister.setText("Register");
        hRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hRegisterActionPerformed(evt);
            }
        });
        mHelp.add(hRegister);
        mHelp.add(hSeparator);

        hAbout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GraphicInterface/iAbout.png"))); // NOI18N
        hAbout.setText("About");
        hAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hAboutActionPerformed(evt);
            }
        });
        mHelp.add(hAbout);

        mBar.add(mHelp);

        setJMenuBar(mBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void hRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hRegisterActionPerformed
        String input = JOptionPane.showInputDialog(this,"Please enter the registration code below:","Register",JOptionPane.PLAIN_MESSAGE);
        if(input.compareTo(regCode)==0)
            {
            hRegister.setEnabled(false);
            fOpen.setEnabled(true);
            fSave.setEnabled(true);
            pButtons.remove(lAd);
            this.repaint();
            Dimension d = this.getSize(),e = new Dimension(670,525);
            this.setMinimumSize(e);
            this.setSize(d.width,d.height+1);
            }
        else JOptionPane.showMessageDialog(this,"Invalid registration code!","ERROR",JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_hRegisterActionPerformed
    private void fQuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fQuitActionPerformed
        Object[] options = {"Yes","No"};
        int n = JOptionPane.showOptionDialog(this,
        "\bDo you really want to quit the application?\n"
        +"Your last modifications may have NOT\n"
        +"been saved!",
        "Warning!",
        JOptionPane.YES_NO_OPTION,
        JOptionPane.WARNING_MESSAGE,
        null,
        options,
        options[1]);
        if(n==JOptionPane.YES_OPTION)System.exit(0);
    }//GEN-LAST:event_fQuitActionPerformed
    private void bSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSearchActionPerformed
        try {
            searchBook = new Book();
            if(bgSearch.getSelection()==null)throw new RException("No search criteria selected!!!");
            if(rFirst.isSelected())
                {
                if(book.searchByFirstName(tSearch.getText()).size()==0 || tSearch.getText()=="")
                    {
                    JOptionPane.showMessageDialog(this,"No result was found during your search!","No Results",JOptionPane.INFORMATION_MESSAGE);
                    return;
                    }
                if(tSearch.getText().length()>0)
                    {
                    searchBook.setBook(book.searchByFirstName(tSearch.getText()));
                    tDisplay.setModel(searchBook);
                    bBack.setEnabled(true);
                    lInfo.setText("Displayed: Search results by first name.");
                    }
                }
            if(rLast.isSelected())
                {
                if(book.searchByLastName(tSearch.getText()).size()==0 || tSearch.getText()=="")
                    {
                    JOptionPane.showMessageDialog(this,"No result was found during your search!","No Results",JOptionPane.INFORMATION_MESSAGE);
                    return;
                    }  
                if(tSearch.getText().length()>0)
                    {
                    searchBook.setBook(book.searchByLastName(tSearch.getText()));
                    tDisplay.setModel(searchBook);
                    bBack.setEnabled(true);
                    lInfo.setText("Displayed: Search results by last name.");
                    }
                }
            if(rID.isSelected())
                {
                if(book.searchByID(tSearch.getText()).size()==0 || tSearch.getText()=="")
                    {
                    JOptionPane.showMessageDialog(this,"No result was found during your search!","No Results",JOptionPane.INFORMATION_MESSAGE);
                    return;
                    }
                if(tSearch.getText().length()>0)
                    {
                    searchBook.setBook(book.searchByID(tSearch.getText()));
                    tDisplay.setModel(searchBook);
                    bBack.setEnabled(true);
                    lInfo.setText("Displayed: Search results by id number.");
                    }
            }
            if(rPhone.isSelected())
                {
                if(book.searchByPhoneNumber(String.valueOf(Long.parseLong(tSearch.getText()))).size()==0 || !tSearch.getText().matches("[0-9]{9}") || tSearch.getText()=="")
                    {
                    JOptionPane.showMessageDialog(this,"No result was found during your search!","No Results",JOptionPane.INFORMATION_MESSAGE);
                    return;
                    } 
                if(tSearch.getText().length()>0)
                    {
                    searchBook.setBook(book.searchByPhoneNumber(String.valueOf(Long.parseLong(tSearch.getText()))));
                    tDisplay.setModel(searchBook);
                    bBack.setEnabled(true);
                    lInfo.setText("Displayed: Search results by phone number.");
                    }
                }
            }
        catch(RException e){JOptionPane.showMessageDialog(this,e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);}
    }//GEN-LAST:event_bSearchActionPerformed
    private void bQuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bQuitActionPerformed
        fQuitActionPerformed(evt);
    }//GEN-LAST:event_bQuitActionPerformed
    private void uAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uAddActionPerformed
        bAddActionPerformed(evt);
    }//GEN-LAST:event_uAddActionPerformed
    private void uSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uSearchActionPerformed
        tSearch.requestFocusInWindow();
    }//GEN-LAST:event_uSearchActionPerformed
    private void hAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hAboutActionPerformed
        JOptionPane.showMessageDialog(this, "Created by Ionescu Radu for InfoAcademy!");
    }//GEN-LAST:event_hAboutActionPerformed
    private void bAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAddActionPerformed
        AddDialog add = new AddDialog(this,true);
        add.setVisible(true); 
    }//GEN-LAST:event_bAddActionPerformed
    private void bRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRemoveActionPerformed
        if(tDisplay.getSelectedRow()>=0)
            {
            User f;
            if(tDisplay.getModel()==book)f = book.b.get(tDisplay.getSelectedRow());
            else f = searchBook.b.get(tDisplay.getSelectedRow());
            Object[] options = {"Yes","No"};
            int n = JOptionPane.showOptionDialog(this,
            "\bDo you really want to remove the user "+tDisplay.getModel().getValueAt(tDisplay.getSelectedRow(),1)+" "+tDisplay.getModel().getValueAt(tDisplay.getSelectedRow(),0)+"?\n"
            +"All data will be erased!!\n",
            "Warning!",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.WARNING_MESSAGE,
            null,
            options,
            options[1]);
            if(n==JOptionPane.YES_OPTION)
                {
                book.removeUser(f);
                searchBook.removeUser(f);
                }
            }
            else {JOptionPane.showMessageDialog(this,"No user is selected!!!","ERROR",JOptionPane.ERROR_MESSAGE);}
    }//GEN-LAST:event_bRemoveActionPerformed
    private void fOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fOpenActionPerformed
        try {
            fileChooser.showOpenDialog(this);
            if(!fileChooser.getSelectedFile().toString().endsWith(".pbd"))throw new RException("The selected file format is not accepted!!!");
                else book.openBook(fileChooser.getSelectedFile());
            lInfo.setText("Displayed: Complete book.");
            }
        catch(RException e){JOptionPane.showMessageDialog(fileChooser,e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);}
    }//GEN-LAST:event_fOpenActionPerformed
    private void bSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSortActionPerformed
        try {
            if(bgSort.getSelection()==null)throw new RException("No sorting criteria selected!!!");
            if(rsFirst.isSelected())book.sortByFirstName();
            if(rsID.isSelected())book.sortByLastName();
            if(rsLast.isSelected())book.sortByID();
            if(rsPhone.isSelected())book.sortByPhoneNumber();
            }
        catch(RException e){JOptionPane.showMessageDialog(this,e.getMessage(),"ERROR",JOptionPane.ERROR_MESSAGE);}
    }//GEN-LAST:event_bSortActionPerformed
    private void bModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bModifyActionPerformed
    if(tDisplay.getSelectedRow()>=0)
            {
            String a,b,c,d;
            a=tDisplay.getModel().getValueAt(tDisplay.getSelectedRow(),0).toString();
            b=tDisplay.getModel().getValueAt(tDisplay.getSelectedRow(),1).toString();
            c=tDisplay.getModel().getValueAt(tDisplay.getSelectedRow(),2).toString();
            d=tDisplay.getModel().getValueAt(tDisplay.getSelectedRow(),3).toString();
            ModifyDialog modify = new ModifyDialog(this,true,a,b,c,d,tDisplay.getSelectedRow(),tDisplay.getModel());
            modify.setVisible(true);
            }
    else    {JOptionPane.showMessageDialog(this,"No user is selected!!!","ERROR",JOptionPane.ERROR_MESSAGE);}
    }//GEN-LAST:event_bModifyActionPerformed
    private void uRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uRemoveActionPerformed
        bRemoveActionPerformed(evt);
    }//GEN-LAST:event_uRemoveActionPerformed
    private void uModifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uModifyActionPerformed
        bModifyActionPerformed(evt);
    }//GEN-LAST:event_uModifyActionPerformed
    private void fSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fSaveActionPerformed
        fileChooser.showSaveDialog(this);
        if(!fileChooser.getSelectedFile().toString().endsWith(".pbd"))
            {
            book.saveBook(new File(fileChooser.getSelectedFile().toString()+".pbd"));
            autoSave = new File(fileChooser.getSelectedFile().toString()+".pbd");
            try {
                FileOutputStream saveFile=new FileOutputStream(new File("open.pbo"));
                ObjectOutputStream save = new ObjectOutputStream(saveFile);
                save.writeObject(new File(fileChooser.getSelectedFile().toString()+".pbd"));
                save.close();
                }
            catch(Exception e)
                {
                e.printStackTrace(); 
                }
            }
            else 
                {
                book.saveBook(fileChooser.getSelectedFile());
                autoSave = fileChooser.getSelectedFile();
                try {
                    FileOutputStream saveFile=new FileOutputStream(new File("open.pbo"));
                    ObjectOutputStream save = new ObjectOutputStream(saveFile);
                    save.writeObject(fileChooser.getSelectedFile());
                    save.close();
                    }
                catch(Exception e)
                    {
                    e.printStackTrace(); 
                    }
                }
    }//GEN-LAST:event_fSaveActionPerformed

    private void bBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBackActionPerformed
        tDisplay.setModel(book);
        lInfo.setText("Displayed: Complete book.");
        bBack.setEnabled(false);
    }//GEN-LAST:event_bBackActionPerformed
    private static void splashInit()
        {
        SplashScreen mySplash = SplashScreen.getSplashScreen();
        if (mySplash != null)
            {
             Graphics2D splashGraphics = mySplash.createGraphics();
             Font fiont = new Font("Dialog", Font.ITALIC, 12);
             splashGraphics.setFont(fiont);
             splashText("Starting...");
             splashProgress(0);
             try{Thread.sleep(1000);}
             catch (Exception e){}
            }
        }
    public static void splashText(String str)
        {
        SplashScreen mySplash = SplashScreen.getSplashScreen();    
        if (mySplash != null && mySplash.isVisible())
            {
            Dimension ssDim = mySplash.getSize();
            int height = ssDim.height;
            int width = ssDim.width;
            Rectangle2D splashTextArea = new Rectangle2D.Double(width * .001,height * 0.875,width,45.);
            Graphics2D splashGraphics = mySplash.createGraphics();
            splashGraphics.setPaint(Color.BLACK);
            splashGraphics.fill(splashTextArea);
            splashGraphics.setPaint(new Color(0,200,230));
            splashGraphics.drawString(str, (int)(splashTextArea.getX() + 10),(int)(splashTextArea.getY() + 15));
            splashGraphics.drawString("@ Ionescu Radu", (int)(splashTextArea.getX() + 590),(int)(splashTextArea.getY() + 15));
            mySplash.update();
            }
        }
    public static void splashProgress(int pct)
        {
        SplashScreen mySplash = SplashScreen.getSplashScreen();    
        if (mySplash != null && mySplash.isVisible())
            {
            Dimension ssDim = mySplash.getSize();
            int height = ssDim.height;
            int width = ssDim.width;
            Graphics2D splashGraphics = mySplash.createGraphics();
            Rectangle2D splashProgressArea = new Rectangle2D.Double(width * .001,height * .92,width,4);
            splashGraphics.setPaint(Color.BLACK);
            splashGraphics.fill(splashProgressArea);
            splashGraphics.setPaint(new Color(0,200,230));
            splashGraphics.draw(splashProgressArea);
            int x = (int) splashProgressArea.getMinX();
            int y = (int) splashProgressArea.getMinY();
            int wid = (int) splashProgressArea.getWidth();
            int hgt = (int) splashProgressArea.getHeight();
            int doneWidth = Math.round(pct*wid/100.f);
            doneWidth = Math.max(0, Math.min(doneWidth, wid-1));  
            splashGraphics.setPaint(new Color(0,200,230));
            splashGraphics.fillRect(x, y+1, doneWidth, hgt);
            mySplash.update();
            }
        }
    private static void appInit()
        {
        for(int i=1;i<=10;i++)
            {
            int pctDone =(int)(i*10-(i*Math.random()));
            splashText(getTask(i));
            splashProgress(pctDone);
            try{Thread.sleep((int)(Math.random()*500));}
            catch (Exception e){}
            }
        }
    public static String getTask(int x)
        {
        switch(x)
            {
            case 1:return "Verifying memory space...";
            case 2:return "Verifying virtual machine...";
            case 3:return "Loading classes...";
            case 4:return "Loading graphic components...";
            case 5:return "Starting new thread...";
            case 6:return "Loading database...";
            case 7:return "Initializing modules...";
            case 8:return "Initializing user interface...";
            case 9:return "Updating status...";
            case 10:return "Done!";
            default:return "Done!";
            }
        }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAdd;
    private javax.swing.JButton bBack;
    private javax.swing.JButton bModify;
    private javax.swing.JButton bQuit;
    private javax.swing.JButton bRemove;
    private javax.swing.JButton bSearch;
    private javax.swing.JButton bSort;
    private javax.swing.ButtonGroup bgSearch;
    private javax.swing.ButtonGroup bgSort;
    private javax.swing.JMenuItem fOpen;
    private javax.swing.JMenuItem fQuit;
    private javax.swing.JMenuItem fSave;
    private javax.swing.JPopupMenu.Separator fSeparator;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JMenuItem hAbout;
    private javax.swing.JMenuItem hRegister;
    private javax.swing.JPopupMenu.Separator hSeparator;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lAd;
    private javax.swing.JLabel lBy;
    private javax.swing.JLabel lClock;
    private javax.swing.JLabel lInfo;
    private javax.swing.JLabel lSearch;
    private javax.swing.JLabel lSort;
    private javax.swing.JMenuBar mBar;
    private javax.swing.JMenu mFile;
    private javax.swing.JMenu mHelp;
    private javax.swing.JMenu mUsers;
    private javax.swing.JPanel pButtons;
    private javax.swing.JPanel pInfo;
    private javax.swing.JPanel pS;
    private javax.swing.JRadioButton rFirst;
    private javax.swing.JRadioButton rID;
    private javax.swing.JRadioButton rLast;
    private javax.swing.JRadioButton rPhone;
    private javax.swing.JRadioButton rsFirst;
    private javax.swing.JRadioButton rsID;
    private javax.swing.JRadioButton rsLast;
    private javax.swing.JRadioButton rsPhone;
    private javax.swing.JSeparator sSeparator;
    private javax.swing.JScrollPane scrollPanel;
    private javax.swing.JPanel searchPanel;
    private javax.swing.JPanel sortPanel;
    public javax.swing.JTable tDisplay;
    private javax.swing.JTextField tSearch;
    private javax.swing.JMenuItem uAdd;
    private javax.swing.JMenuItem uModify;
    private javax.swing.JMenuItem uRemove;
    private javax.swing.JMenuItem uSearch;
    // End of variables declaration//GEN-END:variables
}
