package user_interface;

import classes.Centre;
import classes.Client;
import classes.Option;
import classes.OptionRow;
import classes.Rental;
import classes.Vehicle;
import models.VehicleTable;
import utilities.Database;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import java.util.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ListDataListener;
import javax.swing.text.EditorKit;
import models.CentreTable;
import models.ClientTable;
import models.OptionTable;
import models.RentalTable;
import models.OptionRowTable;

// Created by Ionescu Radu Stefan //

public class Interface extends javax.swing.JFrame
{
    static private VehicleTable vehicleTable;
    static private VehicleTable searchvTable;
    static private CentreTable centreTable;
    static private CentreTable searchcTable;
    static private RentalTable rentalTable;
    static private RentalTable searchrTable;
    static private ClientTable clientTable;
    static private ClientTable searchclTable;
    static private OptionTable optionTable;
    static private OptionTable searchoTable;
    static private OptionRowTable optionRowTable;
    static private OptionRowTable searchorTable;

    public Interface()
    {
        // <editor-fold desc="Initialization">
        SplashScreen mySplash = SplashScreen.getSplashScreen();
        splashInit();
        appInit();
        if (mySplash != null)
        {
            mySplash.close();
        }
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        initComponents();
        //</editor-fold>

        // <editor-fold desc="Combo Box Listener: Table selection">
        cbTable.setSelectedIndex(1);
        cbTable.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                JComboBox cb = (JComboBox) e.getSource();
                String table = (String) cb.getSelectedItem();
                String[] columns;
                switch (table)
                {
                    case "Centres":
                        tDisplay.setModel(centreTable);
                        columns = new String[centreTable.getColumnCount()];
                        for (int i = 0; i < centreTable.getColumnCount(); i++)
                        {
                            columns[i] = centreTable.getColumnName(i);
                        }
                        cbColumn.setModel(new javax.swing.DefaultComboBoxModel<>(columns));
                        cbsColumn.setModel(new javax.swing.DefaultComboBoxModel<>(columns));
                        break;
                    case "Vehicles":
                        tDisplay.setModel(vehicleTable);
                        columns = new String[vehicleTable.getColumnCount()];
                        for (int i = 0; i < vehicleTable.getColumnCount(); i++)
                        {
                            columns[i] = vehicleTable.getColumnName(i);
                        }
                        cbColumn.setModel(new javax.swing.DefaultComboBoxModel<>(columns));
                        cbsColumn.setModel(new javax.swing.DefaultComboBoxModel<>(columns));
                        break;
                    case "Rentals":
                        tDisplay.setModel(rentalTable);
                        columns = new String[rentalTable.getColumnCount()];
                        for (int i = 0; i < rentalTable.getColumnCount(); i++)
                        {
                            columns[i] = rentalTable.getColumnName(i);
                        }
                        cbColumn.setModel(new javax.swing.DefaultComboBoxModel<>(columns));
                        cbsColumn.setModel(new javax.swing.DefaultComboBoxModel<>(columns));
                        break;
                    case "Clients":
                        tDisplay.setModel(clientTable);
                        columns = new String[clientTable.getColumnCount()];
                        for (int i = 0; i < clientTable.getColumnCount(); i++)
                        {
                            columns[i] = clientTable.getColumnName(i);
                        }
                        cbColumn.setModel(new javax.swing.DefaultComboBoxModel<>(columns));
                        cbsColumn.setModel(new javax.swing.DefaultComboBoxModel<>(columns));
                        break;
                    case "Options":
                        tDisplay.setModel(optionTable);
                        columns = new String[optionTable.getColumnCount()];
                        for (int i = 0; i < optionTable.getColumnCount(); i++)
                        {
                            columns[i] = optionTable.getColumnName(i);
                        }
                        cbColumn.setModel(new javax.swing.DefaultComboBoxModel<>(columns));
                        cbsColumn.setModel(new javax.swing.DefaultComboBoxModel<>(columns));
                        break;
                    case "Option Rows":
                        tDisplay.setModel(optionRowTable);
                        columns = new String[optionRowTable.getColumnCount()];
                        for (int i = 0; i < optionRowTable.getColumnCount(); i++)
                        {
                            columns[i] = optionRowTable.getColumnName(i);
                        }
                        cbColumn.setModel(new javax.swing.DefaultComboBoxModel<>(columns));
                        cbsColumn.setModel(new javax.swing.DefaultComboBoxModel<>(columns));
                        break;
                }
            }

        });
        // </editor-fold>

        // <editor-fold desc="Key Listeners">
        tDisplay.addKeyListener(new KeyAdapter()
        {
            public void keyPressed(KeyEvent e)
            {
                if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE)
                {
                    bRemove.doClick();
                }
            }

        });
        // </editor-fold>

        // <editor-fold desc="Table header Listener">
        tDisplay.getTableHeader().setReorderingAllowed(false);
        tDisplay.getTableHeader().addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                int col = tDisplay.getTableHeader().columnAtPoint(evt.getPoint());
                int table = cbTable.getSelectedIndex();
                if (evt.getClickCount() == 1)
                {
                    switch (table)
                    {
                        case 0:
                            switch (col)
                            {
                                case 0:
                                    centreTable.sortByIdCentre();
                                    break;
                                case 1:
                                    centreTable.sortByAddress();
                                    break;
                                case 2:
                                    centreTable.sortByPhone();
                                    break;
                            }
                        case 1:
                            switch (col)
                            {
                                case 0:
                                    vehicleTable.sortByIdVehicle();
                                    break;
                                case 1:
                                    vehicleTable.sortByMake();
                                    break;
                                case 2:
                                    vehicleTable.sortByModel();
                                    break;
                                case 3:
                                    vehicleTable.sortByCategory();
                                    break;
                                case 4:
                                    vehicleTable.sortByPower();
                                    break;
                                case 5:
                                    vehicleTable.sortByFuel();
                                    break;
                                case 6:
                                    vehicleTable.sortByGearbox();
                                    break;
                                case 7:
                                    vehicleTable.sortByFuelConsumption();
                                    break;
                                case 8:
                                    vehicleTable.sortByTrunk();
                                    break;
                                case 9:
                                    vehicleTable.sortByDoors();
                                    break;
                                case 10:
                                    vehicleTable.sortByPrice();
                                    break;
                                case 11:
                                    vehicleTable.sortByCentre();
                                    break;
                            }
                        case 2:
                            switch (col)
                            {
                                case 0:
                                    rentalTable.sortByIdRental();
                                    break;
                                case 1:
                                    rentalTable.sortByStart();
                                    break;
                                case 2:
                                    rentalTable.sortByEnd();
                                    break;
                                case 3:
                                    rentalTable.sortByIdVehicle();
                                    break;
                                case 4:
                                    rentalTable.sortByIdClient();
                                    break;
                                case 5:
                                    rentalTable.sortByIdCentre();
                                    break;
                            }
                        case 3:
                            switch (col)
                            {
                                case 0:
                                    clientTable.sortById();
                                    break;
                                case 1:
                                    clientTable.sortByFirstName();
                                    break;
                                case 2:
                                    clientTable.sortByLastName();
                                    break;
                            }
                        case 4:
                            switch (col)
                            {
                                case 0:
                                    optionTable.sortByName();
                                    break;
                                case 1:
                                    optionTable.sortByPrice();
                                    break;
                                case 2:
                                    optionTable.sortByDescription();
                                    break;
                            }
                        case 5:
                            switch (col)
                            {
                                case 0:
                                    optionRowTable.sortByName();
                                    break;
                                case 1:
                                    optionRowTable.sortByIdRental();
                                    break;
                                case 2:
                                    optionRowTable.sortByIdVehicle();
                                    break;
                                case 3:
                                    optionRowTable.sortByIdClient();
                                    break;
                                case 4:
                                    optionRowTable.sortByIdCentre();
                                    break;
                            }
                    }
                }
            }

        });
        //</editor-fold>

        // <editor-fold desc="Clock & UI">
        TimerTask clock = new TimerTask()
        {
            public void run()
            {
                GregorianCalendar current = new GregorianCalendar();
                String hour, minute, second;
                hour = String.valueOf(current.get(GregorianCalendar.HOUR));
                if (current.get(GregorianCalendar.MINUTE) < 10)
                {
                    minute = "0" + String.valueOf(current.get(GregorianCalendar.MINUTE));
                }
                else
                {
                    minute = String.valueOf(current.get(GregorianCalendar.MINUTE));
                }
                if (current.get(GregorianCalendar.SECOND) < 10)
                {
                    second = "0" + String.valueOf(current.get(GregorianCalendar.SECOND));
                }
                else
                {
                    second = String.valueOf(current.get(GregorianCalendar.SECOND));
                }
                lClock.setText(current.get(GregorianCalendar.DAY_OF_MONTH) + " - " + (current.get(GregorianCalendar.MONTH) + 1) + " - " + current.get(GregorianCalendar.YEAR) + "   " + hour + ":" + minute + ":" + second);
            }
        };
        java.util.Timer saver = new java.util.Timer();
        saver.schedule(clock, 0, 1000);
        setBounds(screenSize.width / 2 - this.getMinimumSize().width / 2, screenSize.height / 2 - this.getMinimumSize().height / 2, this.getMinimumSize().width, this.getMinimumSize().height);
        try
        {
            Image icon = ImageIO.read(getClass().getResource("/icons/iCarExpress.png"));
            this.setIconImage(icon);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        //</editor-fold>

        // <editor-fold desc="Login Dialog">
        tDisplay.setModel(vehicleTable);
        tDisplay.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        try
        {
            Thread.sleep((int) (Math.random() * 400));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        LoginDialog login = new LoginDialog(this, true);
        login.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        login.setResizable(false);
        login.setVisible(true);
        //</editor-fold>
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {
        java.awt.GridBagConstraints gridBagConstraints;

        fileChooser = new javax.swing.JFileChooser();
        scrollPanel = new javax.swing.JScrollPane();
        tDisplay = new javax.swing.JTable();
        pS = new javax.swing.JPanel();
        searchPanel = new javax.swing.JPanel();
        cbTable = new javax.swing.JComboBox<>();
        lSearch = new javax.swing.JLabel();
        tSearch = new javax.swing.JTextField();
        lBy = new javax.swing.JLabel();
        cbColumn = new javax.swing.JComboBox<>();
        sSeparator = new javax.swing.JSeparator();
        bSearch = new javax.swing.JButton();
        sortPanel = new javax.swing.JPanel();
        lSort = new javax.swing.JLabel();
        cbsColumn = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        bSort = new javax.swing.JButton();
        pButtons = new javax.swing.JPanel();
        bAdd = new javax.swing.JButton();
        bRemove = new javax.swing.JButton();
        bQuit = new javax.swing.JButton();
        lAd = new javax.swing.JLabel();
        pInfo = new javax.swing.JPanel();
        bBack = new javax.swing.JButton();
        lClock = new javax.swing.JLabel();
        lInfo = new javax.swing.JLabel();

        fileChooser.setAcceptAllFileFilterUsed(false);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CarExpress Administration");
        setBackground(new java.awt.Color(102, 102, 102));
        setForeground(new java.awt.Color(0, 0, 0));
        setMinimumSize(new java.awt.Dimension(1180, 500));
        getContentPane().setLayout(new java.awt.GridBagLayout());

        tDisplay.setBackground(new java.awt.Color(44, 44, 44));
        tDisplay.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tDisplay.setForeground(new java.awt.Color(196, 230, 255));
        tDisplay.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String []
            {
                "ID Client", "First Name", "Last Name"
            }
        )
        {
            boolean[] canEdit = new boolean []
            {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex)
            {
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

        searchPanel.setBackground(new java.awt.Color(44, 44, 44));
        searchPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        searchPanel.setPreferredSize(new java.awt.Dimension(142, 265));

        cbTable.setForeground(new java.awt.Color(196, 230, 255));
        cbTable.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Centres", "Vehicles", "Rentals", "Clients", "Options", "Option Rows" }));

        lSearch.setForeground(new java.awt.Color(196, 230, 255));
        lSearch.setText("Search");

        lBy.setForeground(new java.awt.Color(196, 230, 255));
        lBy.setText("by:");

        cbColumn.setForeground(new java.awt.Color(196, 230, 255));
        cbColumn.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "Make", "Model", "Category", "Power", "Fuel", "Gearbox", "Consumption", "Trunk", "Doors", "Price", "Centre" }));

        bSearch.setBackground(new java.awt.Color(44, 44, 44));
        bSearch.setForeground(new java.awt.Color(196, 230, 255));
        bSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/iDefault.png"))); // NOI18N
        bSearch.setText("Search");
        bSearch.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/iSearch.png"))); // NOI18N
        bSearch.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
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
                    .addComponent(tSearch)
                    .addComponent(cbColumn, 0, 0, Short.MAX_VALUE)
                    .addComponent(sSeparator, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(searchPanelLayout.createSequentialGroup()
                        .addGroup(searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lBy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbTable, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(bSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        searchPanelLayout.setVerticalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lSearch)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lBy)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbColumn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                .addComponent(sSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bSearch)
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 0.5;
        pS.add(searchPanel, gridBagConstraints);

        sortPanel.setBackground(new java.awt.Color(44, 44, 44));
        sortPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lSort.setForeground(new java.awt.Color(196, 230, 255));
        lSort.setText("Sort by:");

        cbsColumn.setForeground(new java.awt.Color(196, 230, 255));
        cbsColumn.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "Make", "Model", "Category", "Power", "Fuel", "Gearbox", "Consumption", "Trunk", "Doors", "Price", "Centre" }));

        bSort.setBackground(new java.awt.Color(44, 44, 44));
        bSort.setForeground(new java.awt.Color(196, 230, 255));
        bSort.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/iDefault.png"))); // NOI18N
        bSort.setText("Sort");
        bSort.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/iSort.png"))); // NOI18N
        bSort.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
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
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbsColumn, 0, 112, Short.MAX_VALUE)
                    .addComponent(lSort, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bSort, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE))
                .addContainerGap())
        );
        sortPanelLayout.setVerticalGroup(
            sortPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sortPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lSort)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbsColumn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bSort)
                .addContainerGap())
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

        pButtons.setBackground(new java.awt.Color(44, 44, 44));
        pButtons.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pButtons.setLayout(new java.awt.GridBagLayout());

        bAdd.setBackground(new java.awt.Color(44, 44, 44));
        bAdd.setForeground(new java.awt.Color(196, 230, 255));
        bAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/iDefault.png"))); // NOI18N
        bAdd.setText("Add");
        bAdd.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/iAdd.png"))); // NOI18N
        bAdd.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
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

        bRemove.setBackground(new java.awt.Color(44, 44, 44));
        bRemove.setForeground(new java.awt.Color(196, 230, 255));
        bRemove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/iDefault.png"))); // NOI18N
        bRemove.setText("Remove");
        bRemove.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/iRemove.png"))); // NOI18N
        bRemove.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
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

        bQuit.setBackground(new java.awt.Color(44, 44, 44));
        bQuit.setForeground(new java.awt.Color(196, 230, 255));
        bQuit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/iDefault.png"))); // NOI18N
        bQuit.setText("Quit");
        bQuit.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/iQuit.png"))); // NOI18N
        bQuit.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
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

        pInfo.setBackground(new java.awt.Color(44, 44, 44));
        pInfo.setLayout(new java.awt.GridBagLayout());

        bBack.setBackground(new java.awt.Color(44, 44, 44));
        bBack.setForeground(new java.awt.Color(196, 230, 255));
        bBack.setText("Back to complete table");
        bBack.setEnabled(false);
        bBack.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                bBackActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 11;
        pInfo.add(bBack, gridBagConstraints);

        lClock.setForeground(new java.awt.Color(196, 230, 255));
        lClock.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 74;
        gridBagConstraints.ipady = 21;
        pInfo.add(lClock, gridBagConstraints);

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

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void bSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSearchActionPerformed
        String table = cbTable.getSelectedItem().toString();
        String by = cbColumn.getSelectedItem().toString();
        switch (table)
        {
            case "Centres":
                switch (by)
                {
                    case "ID":
                        if (centreTable.searchByIdCentre(tSearch.getText()).size() == 0 || tSearch.getText() == "")
                        {
                            JOptionPane.showMessageDialog(this, "No result was found during your search!", "No Results", JOptionPane.INFORMATION_MESSAGE);
                            return;
                        }
                        if (tSearch.getText().length() > 0)
                        {
                            searchcTable = new CentreTable(centreTable.searchByIdCentre(tSearch.getText()));
                            tDisplay.setModel(searchcTable);
                            bBack.setEnabled(true);
                            lInfo.setText("Displayed: Search results by " + by + ".");
                        }
                        break;
                    case "Address":
                        if (centreTable.searchByAddress(tSearch.getText()).size() == 0 || tSearch.getText() == "")
                        {
                            JOptionPane.showMessageDialog(this, "No result was found during your search!", "No Results", JOptionPane.INFORMATION_MESSAGE);
                            return;
                        }
                        if (tSearch.getText().length() > 0)
                        {
                            searchcTable = new CentreTable(centreTable.searchByAddress(tSearch.getText()));
                            tDisplay.setModel(searchcTable);
                            bBack.setEnabled(true);
                            lInfo.setText("Displayed: Search results by " + by + ".");
                        }
                        break;
                    case "Phone":
                        if (centreTable.searchByPhone(tSearch.getText()).size() == 0 || tSearch.getText() == "")
                        {
                            JOptionPane.showMessageDialog(this, "No result was found during your search!", "No Results", JOptionPane.INFORMATION_MESSAGE);
                            return;
                        }
                        if (tSearch.getText().length() > 0)
                        {
                            searchcTable = new CentreTable(centreTable.searchByPhone(tSearch.getText()));
                            tDisplay.setModel(searchcTable);
                            bBack.setEnabled(true);
                            lInfo.setText("Displayed: Search results by " + by + ".");
                        }
                        break;
                }
            case "Rentals":
                switch (by)
                {
                    case "ID":
                        if (rentalTable.searchByIdRental(tSearch.getText()).size() == 0 || tSearch.getText() == "")
                        {
                            JOptionPane.showMessageDialog(this, "No result was found during your search!", "No Results", JOptionPane.INFORMATION_MESSAGE);
                            return;
                        }
                        if (tSearch.getText().length() > 0)
                        {
                            searchrTable = new RentalTable(rentalTable.searchByIdRental(tSearch.getText()));
                            tDisplay.setModel(searchrTable);
                            bBack.setEnabled(true);
                            lInfo.setText("Displayed: Search results by " + by + ".");
                        }
                        break;
                    case "Start Date":
                        if (rentalTable.searchByStart(tSearch.getText()).size() == 0 || tSearch.getText() == "")
                        {
                            JOptionPane.showMessageDialog(this, "No result was found during your search!", "No Results", JOptionPane.INFORMATION_MESSAGE);
                            return;
                        }
                        if (tSearch.getText().length() > 0)
                        {
                            searchrTable = new RentalTable(rentalTable.searchByStart(tSearch.getText()));
                            tDisplay.setModel(searchrTable);
                            bBack.setEnabled(true);
                            lInfo.setText("Displayed: Search results by " + by + ".");
                        }
                        break;
                    case "End Date":
                        if (rentalTable.searchByEnd(tSearch.getText()).size() == 0 || tSearch.getText() == "")
                        {
                            JOptionPane.showMessageDialog(this, "No result was found during your search!", "No Results", JOptionPane.INFORMATION_MESSAGE);
                            return;
                        }
                        if (tSearch.getText().length() > 0)
                        {
                            searchrTable = new RentalTable(rentalTable.searchByEnd(tSearch.getText()));
                            tDisplay.setModel(searchrTable);
                            bBack.setEnabled(true);
                            lInfo.setText("Displayed: Search results by " + by + ".");
                        }
                        break;
                    case "ID Vehicle":
                        if (rentalTable.searchByIdVehicle(tSearch.getText()).size() == 0 || tSearch.getText() == "")
                        {
                            JOptionPane.showMessageDialog(this, "No result was found during your search!", "No Results", JOptionPane.INFORMATION_MESSAGE);
                            return;
                        }
                        if (tSearch.getText().length() > 0)
                        {
                            searchrTable = new RentalTable(rentalTable.searchByIdVehicle(tSearch.getText()));
                            tDisplay.setModel(searchrTable);
                            bBack.setEnabled(true);
                            lInfo.setText("Displayed: Search results by " + by + ".");
                        }
                        break;
                    case "ID Client":
                        if (rentalTable.searchByIdClient(tSearch.getText()).size() == 0 || tSearch.getText() == "")
                        {
                            JOptionPane.showMessageDialog(this, "No result was found during your search!", "No Results", JOptionPane.INFORMATION_MESSAGE);
                            return;
                        }
                        if (tSearch.getText().length() > 0)
                        {
                            searchrTable = new RentalTable(rentalTable.searchByIdClient(tSearch.getText()));
                            tDisplay.setModel(searchrTable);
                            bBack.setEnabled(true);
                            lInfo.setText("Displayed: Search results by " + by + ".");
                        }
                        break;
                    case "ID Centre":
                        if (rentalTable.searchByIdCentre(tSearch.getText()).size() == 0 || tSearch.getText() == "")
                        {
                            JOptionPane.showMessageDialog(this, "No result was found during your search!", "No Results", JOptionPane.INFORMATION_MESSAGE);
                            return;
                        }
                        if (tSearch.getText().length() > 0)
                        {
                            searchrTable = new RentalTable(rentalTable.searchByIdCentre(tSearch.getText()));
                            tDisplay.setModel(searchrTable);
                            bBack.setEnabled(true);
                            lInfo.setText("Displayed: Search results by " + by + ".");
                        }
                        break;
                }
            case "Vehicles":
                switch (by)
                {
                    case "ID":
                        if (vehicleTable.searchByIdVehicle(tSearch.getText()).size() == 0 || tSearch.getText() == "")
                        {
                            JOptionPane.showMessageDialog(this, "No result was found during your search!", "No Results", JOptionPane.INFORMATION_MESSAGE);
                            return;
                        }
                        if (tSearch.getText().length() > 0)
                        {
                            searchvTable = new VehicleTable(vehicleTable.searchByIdVehicle(tSearch.getText()));
                            tDisplay.setModel(searchvTable);
                            bBack.setEnabled(true);
                            lInfo.setText("Displayed: Search results by " + by + ".");
                        }
                        break;
                    case "Make":
                        if (vehicleTable.searchByMake(tSearch.getText()).size() == 0 || tSearch.getText() == "")
                        {
                            JOptionPane.showMessageDialog(this, "No result was found during your search!", "No Results", JOptionPane.INFORMATION_MESSAGE);
                            return;
                        }
                        if (tSearch.getText().length() > 0)
                        {
                            searchvTable = new VehicleTable(vehicleTable.searchByMake(tSearch.getText()));
                            tDisplay.setModel(searchvTable);
                            bBack.setEnabled(true);
                            lInfo.setText("Displayed: Search results by " + by + ".");
                        }
                        break;
                    case "Model":
                        if (vehicleTable.searchByModel(tSearch.getText()).size() == 0 || tSearch.getText() == "")
                        {
                            JOptionPane.showMessageDialog(this, "No result was found during your search!", "No Results", JOptionPane.INFORMATION_MESSAGE);
                            return;
                        }
                        if (tSearch.getText().length() > 0)
                        {
                            searchvTable = new VehicleTable(vehicleTable.searchByModel(tSearch.getText()));
                            tDisplay.setModel(searchvTable);
                            bBack.setEnabled(true);
                            lInfo.setText("Displayed: Search results by " + by + ".");
                        }
                        break;
                    case "Category":
                        if (vehicleTable.searchByCategory(tSearch.getText()).size() == 0 || tSearch.getText() == "")
                        {
                            JOptionPane.showMessageDialog(this, "No result was found during your search!", "No Results", JOptionPane.INFORMATION_MESSAGE);
                            return;
                        }
                        if (tSearch.getText().length() > 0)
                        {
                            searchvTable = new VehicleTable(vehicleTable.searchByCategory(tSearch.getText()));
                            tDisplay.setModel(searchvTable);
                            bBack.setEnabled(true);
                            lInfo.setText("Displayed: Search results by " + by + ".");
                        }
                        break;
                    case "Power":
                        if (vehicleTable.searchByPower(tSearch.getText()).size() == 0 || tSearch.getText() == "")
                        {
                            JOptionPane.showMessageDialog(this, "No result was found during your search!", "No Results", JOptionPane.INFORMATION_MESSAGE);
                            return;
                        }
                        if (tSearch.getText().length() > 0)
                        {
                            searchvTable = new VehicleTable(vehicleTable.searchByPower(tSearch.getText()));
                            tDisplay.setModel(searchvTable);
                            bBack.setEnabled(true);
                            lInfo.setText("Displayed: Search results by " + by + ".");
                        }
                        break;
                    case "Fuel":
                        if (vehicleTable.searchByFuel(tSearch.getText()).size() == 0 || tSearch.getText() == "")
                        {
                            JOptionPane.showMessageDialog(this, "No result was found during your search!", "No Results", JOptionPane.INFORMATION_MESSAGE);
                            return;
                        }
                        if (tSearch.getText().length() > 0)
                        {
                            searchvTable = new VehicleTable(vehicleTable.searchByFuel(tSearch.getText()));
                            tDisplay.setModel(searchvTable);
                            bBack.setEnabled(true);
                            lInfo.setText("Displayed: Search results by " + by + ".");
                        }
                        break;
                    case "Gearbox":
                        if (vehicleTable.searchByGearbox(tSearch.getText()).size() == 0 || tSearch.getText() == "")
                        {
                            JOptionPane.showMessageDialog(this, "No result was found during your search!", "No Results", JOptionPane.INFORMATION_MESSAGE);
                            return;
                        }
                        if (tSearch.getText().length() > 0)
                        {
                            searchvTable = new VehicleTable(vehicleTable.searchByGearbox(tSearch.getText()));
                            tDisplay.setModel(searchvTable);
                            bBack.setEnabled(true);
                            lInfo.setText("Displayed: Search results by " + by + ".");
                        }
                        break;
                    case "Consumption":
                        if (vehicleTable.searchByFuelConsumption(tSearch.getText()).size() == 0 || tSearch.getText() == "")
                        {
                            JOptionPane.showMessageDialog(this, "No result was found during your search!", "No Results", JOptionPane.INFORMATION_MESSAGE);
                            return;
                        }
                        if (tSearch.getText().length() > 0)
                        {
                            searchvTable = new VehicleTable(vehicleTable.searchByFuelConsumption(tSearch.getText()));
                            tDisplay.setModel(searchvTable);
                            bBack.setEnabled(true);
                            lInfo.setText("Displayed: Search results by " + by + ".");
                        }
                        break;
                    case "Trunk":
                        if (vehicleTable.searchByTrunk(tSearch.getText()).size() == 0 || tSearch.getText() == "")
                        {
                            JOptionPane.showMessageDialog(this, "No result was found during your search!", "No Results", JOptionPane.INFORMATION_MESSAGE);
                            return;
                        }
                        if (tSearch.getText().length() > 0)
                        {
                            searchvTable = new VehicleTable(vehicleTable.searchByTrunk(tSearch.getText()));
                            tDisplay.setModel(searchvTable);
                            bBack.setEnabled(true);
                            lInfo.setText("Displayed: Search results by " + by + ".");
                        }
                        break;
                    case "Doors":
                        if (vehicleTable.searchByDoors(tSearch.getText()).size() == 0 || tSearch.getText() == "")
                        {
                            JOptionPane.showMessageDialog(this, "No result was found during your search!", "No Results", JOptionPane.INFORMATION_MESSAGE);
                            return;
                        }
                        if (tSearch.getText().length() > 0)
                        {
                            searchvTable = new VehicleTable(vehicleTable.searchByDoors(tSearch.getText()));
                            tDisplay.setModel(searchvTable);
                            bBack.setEnabled(true);
                            lInfo.setText("Displayed: Search results by " + by + ".");
                        }
                        break;
                    case "Price":
                        if (vehicleTable.searchByPrice(tSearch.getText()).size() == 0 || tSearch.getText() == "")
                        {
                            JOptionPane.showMessageDialog(this, "No result was found during your search!", "No Results", JOptionPane.INFORMATION_MESSAGE);
                            return;
                        }
                        if (tSearch.getText().length() > 0)
                        {
                            searchvTable = new VehicleTable(vehicleTable.searchByPrice(tSearch.getText()));
                            tDisplay.setModel(searchvTable);
                            bBack.setEnabled(true);
                            lInfo.setText("Displayed: Search results by " + by + ".");
                        }
                        break;
                    case "Centre":
                        if (vehicleTable.searchByCentre(tSearch.getText()).size() == 0 || tSearch.getText() == "")
                        {
                            JOptionPane.showMessageDialog(this, "No result was found during your search!", "No Results", JOptionPane.INFORMATION_MESSAGE);
                            return;
                        }
                        if (tSearch.getText().length() > 0)
                        {
                            searchvTable = new VehicleTable(vehicleTable.searchByCentre(tSearch.getText()));
                            tDisplay.setModel(searchvTable);
                            bBack.setEnabled(true);
                            lInfo.setText("Displayed: Search results by " + by + ".");
                        }
                        break;
                }
            case "Clients":
                switch (by)
                {
                    case "ID":
                        if (clientTable.searchByIdClient(tSearch.getText()).size() == 0 || tSearch.getText() == "")
                        {
                            JOptionPane.showMessageDialog(this, "No result was found during your search!", "No Results", JOptionPane.INFORMATION_MESSAGE);
                            return;
                        }
                        if (tSearch.getText().length() > 0)
                        {
                            searchclTable = new ClientTable(clientTable.searchByIdClient(tSearch.getText()));
                            tDisplay.setModel(searchclTable);
                            bBack.setEnabled(true);
                            lInfo.setText("Displayed: Search results by " + by + ".");
                        }
                        break;
                    case "First Name":
                        if (clientTable.searchByFirstName(tSearch.getText()).size() == 0 || tSearch.getText() == "")
                        {
                            JOptionPane.showMessageDialog(this, "No result was found during your search!", "No Results", JOptionPane.INFORMATION_MESSAGE);
                            return;
                        }
                        if (tSearch.getText().length() > 0)
                        {
                            searchclTable = new ClientTable(clientTable.searchByFirstName(tSearch.getText()));
                            tDisplay.setModel(searchclTable);
                            bBack.setEnabled(true);
                            lInfo.setText("Displayed: Search results by " + by + ".");
                        }
                        break;
                    case "Last Name":
                        if (clientTable.searchByLastName(tSearch.getText()).size() == 0 || tSearch.getText() == "")
                        {
                            JOptionPane.showMessageDialog(this, "No result was found during your search!", "No Results", JOptionPane.INFORMATION_MESSAGE);
                            return;
                        }
                        if (tSearch.getText().length() > 0)
                        {
                            searchclTable = new ClientTable(clientTable.searchByLastName(tSearch.getText()));
                            tDisplay.setModel(searchclTable);
                            bBack.setEnabled(true);
                            lInfo.setText("Displayed: Search results by " + by + ".");
                        }
                        break;
                }
            case "Options":
                switch (by)
                {
                    case "Name":
                        if (optionTable.searchByName(tSearch.getText()).size() == 0 || tSearch.getText() == "")
                        {
                            JOptionPane.showMessageDialog(this, "No result was found during your search!", "No Results", JOptionPane.INFORMATION_MESSAGE);
                            return;
                        }
                        if (tSearch.getText().length() > 0)
                        {
                            searchoTable = new OptionTable(optionTable.searchByName(tSearch.getText()));
                            tDisplay.setModel(searchoTable);
                            bBack.setEnabled(true);
                            lInfo.setText("Displayed: Search results by " + by + ".");
                        }
                        break;
                    case "Description":
                        if (optionTable.searchByDescription(tSearch.getText()).size() == 0 || tSearch.getText() == "")
                        {
                            JOptionPane.showMessageDialog(this, "No result was found during your search!", "No Results", JOptionPane.INFORMATION_MESSAGE);
                            return;
                        }
                        if (tSearch.getText().length() > 0)
                        {
                            searchoTable = new OptionTable(optionTable.searchByDescription(tSearch.getText()));
                            tDisplay.setModel(searchoTable);
                            bBack.setEnabled(true);
                            lInfo.setText("Displayed: Search results by " + by + ".");
                        }
                        break;
                    case "Price":
                        if (optionTable.searchByPrice(tSearch.getText()).size() == 0 || tSearch.getText() == "")
                        {
                            JOptionPane.showMessageDialog(this, "No result was found during your search!", "No Results", JOptionPane.INFORMATION_MESSAGE);
                            return;
                        }
                        if (tSearch.getText().length() > 0)
                        {
                            searchoTable = new OptionTable(optionTable.searchByPrice(tSearch.getText()));
                            tDisplay.setModel(searchoTable);
                            bBack.setEnabled(true);
                            lInfo.setText("Displayed: Search results by " + by + ".");
                        }
                        break;
                }
            case "Option Rows":
                switch (by)
                {
                    case "Name":
                        if (optionRowTable.searchByName(tSearch.getText()).size() == 0 || tSearch.getText() == "")
                        {
                            JOptionPane.showMessageDialog(this, "No result was found during your search!", "No Results", JOptionPane.INFORMATION_MESSAGE);
                            return;
                        }
                        if (tSearch.getText().length() > 0)
                        {
                            searchorTable = new OptionRowTable(optionRowTable.searchByName(tSearch.getText()));
                            tDisplay.setModel(searchorTable);
                            bBack.setEnabled(true);
                            lInfo.setText("Displayed: Search results by " + by + ".");
                        }
                        break;
                    case "ID Rental":
                        if (optionRowTable.searchByIdRental(tSearch.getText()).size() == 0 || tSearch.getText() == "")
                        {
                            JOptionPane.showMessageDialog(this, "No result was found during your search!", "No Results", JOptionPane.INFORMATION_MESSAGE);
                            return;
                        }
                        if (tSearch.getText().length() > 0)
                        {
                            searchorTable = new OptionRowTable(optionRowTable.searchByIdRental(tSearch.getText()));
                            tDisplay.setModel(searchorTable);
                            bBack.setEnabled(true);
                            lInfo.setText("Displayed: Search results by " + by + ".");
                        }
                        break;
                    case "ID Vehicle":
                        if (optionRowTable.searchByIdVehicle(tSearch.getText()).size() == 0 || tSearch.getText() == "")
                        {
                            JOptionPane.showMessageDialog(this, "No result was found during your search!", "No Results", JOptionPane.INFORMATION_MESSAGE);
                            return;
                        }
                        if (tSearch.getText().length() > 0)
                        {
                            searchorTable = new OptionRowTable(optionRowTable.searchByIdVehicle(tSearch.getText()));
                            tDisplay.setModel(searchorTable);
                            bBack.setEnabled(true);
                            lInfo.setText("Displayed: Search results by " + by + ".");
                        }
                        break;
                    case "ID Client":
                        if (optionRowTable.searchByIdClient(tSearch.getText()).size() == 0 || tSearch.getText() == "")
                        {
                            JOptionPane.showMessageDialog(this, "No result was found during your search!", "No Results", JOptionPane.INFORMATION_MESSAGE);
                            return;
                        }
                        if (tSearch.getText().length() > 0)
                        {
                            searchorTable = new OptionRowTable(optionRowTable.searchByIdClient(tSearch.getText()));
                            tDisplay.setModel(searchorTable);
                            bBack.setEnabled(true);
                            lInfo.setText("Displayed: Search results by " + by + ".");
                        }
                        break;
                    case "ID Centre":
                        if (optionRowTable.searchByIdCentre(tSearch.getText()).size() == 0 || tSearch.getText() == "")
                        {
                            JOptionPane.showMessageDialog(this, "No result was found during your search!", "No Results", JOptionPane.INFORMATION_MESSAGE);
                            return;
                        }
                        if (tSearch.getText().length() > 0)
                        {
                            searchorTable = new OptionRowTable(optionRowTable.searchByIdCentre(tSearch.getText()));
                            tDisplay.setModel(searchorTable);
                            bBack.setEnabled(true);
                            lInfo.setText("Displayed: Search results by " + by + ".");
                        }
                        break;
                }
        }
    }//GEN-LAST:event_bSearchActionPerformed
    private void bQuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bQuitActionPerformed
        JOptionPane.showMessageDialog(this, "The application will terminate!", "Close application", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }//GEN-LAST:event_bQuitActionPerformed
    private void bAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAddActionPerformed
        String table = cbTable.getSelectedItem().toString();
        switch (table)
            {
                case "Centres":
                    JOptionPane.showMessageDialog(this, "Not supported!", "Notification", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case "Rentals":
                    JOptionPane.showMessageDialog(this, "Not supported!", "Notification", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case "Vehicles":
                    JOptionPane.showMessageDialog(this, "Not supported!", "Notification", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case "Clients":
                    JOptionPane.showMessageDialog(this, "Not supported!", "Notification", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case "Options":
                    AddOptionDialog add = new AddOptionDialog(this, true);
                    add.setVisible(true);
                    add.addWindowListener(new WindowAdapter()
                    {
                       @Override
                        public void windowClosed(WindowEvent e) 
                        {
                          optionTable = new OptionTable(new Database().getOptions());
                          tDisplay.setModel(optionTable);
                        } 
                    });
                    break;
                case "Option Rows":
                    JOptionPane.showMessageDialog(this, "Not supported!", "Notification", JOptionPane.INFORMATION_MESSAGE);
                    break;
            }
    }//GEN-LAST:event_bAddActionPerformed
    private void bRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRemoveActionPerformed
        Object[] options =
        {
            "Yes", "No"
        };
        int n;
        String table = cbTable.getSelectedItem().toString();
        if (tDisplay.getSelectedRow() >= 0)
        {
            switch (table)
            {
                case "Centres":
                    Centre c;
                    if (tDisplay.getModel() == optionRowTable)
                    {
                        c = centreTable.centres.get(tDisplay.getSelectedRow());
                    }
                    else
                    {
                        c = searchcTable.centres.get(tDisplay.getSelectedRow());
                    }

                    n = JOptionPane.showOptionDialog(this,
                            "\bDo you really want to remove " + tDisplay.getModel().getValueAt(tDisplay.getSelectedRow(), 0) + "?\n"
                            + "All data will be erased!!\n",
                            "Warning!",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.WARNING_MESSAGE,
                            null,
                            options,
                            options[1]);
                    if (n == JOptionPane.YES_OPTION)
                    {
                        centreTable.removeCentre(c);
                        searchcTable.removeCentre(c);
                        new Database().deleteCentre(c.getIdCentre());
                    }
                    break;
                case "Rentals":
                    Rental r;
                    if (tDisplay.getModel() == optionRowTable)
                    {
                        r = rentalTable.rentals.get(tDisplay.getSelectedRow());
                    }
                    else
                    {
                        r = searchrTable.rentals.get(tDisplay.getSelectedRow());
                    }

                    n = JOptionPane.showOptionDialog(this,
                            "\bDo you really want to remove " + tDisplay.getModel().getValueAt(tDisplay.getSelectedRow(), 0) + "?\n"
                            + "All data will be erased!!\n",
                            "Warning!",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.WARNING_MESSAGE,
                            null,
                            options,
                            options[1]);
                    if (n == JOptionPane.YES_OPTION)
                    {
                        rentalTable.removeRental(r);
                        searchrTable.removeRental(r);
                        new Database().deleteRental(String.valueOf(r.getIdRental()));
                    }
                    break;
                case "Vehicles":
                    Vehicle v;
                    if (tDisplay.getModel() == vehicleTable)
                    {
                        v = vehicleTable.vehicles.get(tDisplay.getSelectedRow());
                    }
                    else
                    {
                        v = searchvTable.vehicles.get(tDisplay.getSelectedRow());
                    }

                    n = JOptionPane.showOptionDialog(this,
                            "\bDo you really want to remove " + tDisplay.getModel().getValueAt(tDisplay.getSelectedRow(), 0) + "?\n"
                            + "All data will be erased!!\n",
                            "Warning!",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.WARNING_MESSAGE,
                            null,
                            options,
                            options[1]);
                    if (n == JOptionPane.YES_OPTION)
                    {
                        vehicleTable.removeVehicle(v);
                        searchvTable.removeVehicle(v);
                        new Database().deleteVehicle(v.getIdVehicle());
                    }
                    break;
                case "Clients":
                    Client cl;
                    if (tDisplay.getModel() == clientTable)
                    {
                        cl = clientTable.clients.get(tDisplay.getSelectedRow());
                    }
                    else
                    {
                        cl = searchclTable.clients.get(tDisplay.getSelectedRow());
                    }

                    n = JOptionPane.showOptionDialog(this,
                            "\bDo you really want to remove " + tDisplay.getModel().getValueAt(tDisplay.getSelectedRow(), 0) + "?\n"
                            + "All data will be erased!!\n",
                            "Warning!",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.WARNING_MESSAGE,
                            null,
                            options,
                            options[1]);
                    if (n == JOptionPane.YES_OPTION)
                    {
                        clientTable.removeClient(cl);
                        searchclTable.removeClient(cl);
                        new Database().deleteClient(cl.getIdClient());
                    }
                    break;
                case "Options":
                    Option o;
                    if (tDisplay.getModel() == optionTable)
                    {
                        o = optionTable.options.get(tDisplay.getSelectedRow());
                    }
                    else
                    {
                        o = searchoTable.options.get(tDisplay.getSelectedRow());
                    }

                    n = JOptionPane.showOptionDialog(this,
                            "\bDo you really want to remove " + tDisplay.getModel().getValueAt(tDisplay.getSelectedRow(), 0) + "?\n"
                            + "All data will be erased!!\n",
                            "Warning!",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.WARNING_MESSAGE,
                            null,
                            options,
                            options[1]);
                    if (n == JOptionPane.YES_OPTION)
                    {
                        optionTable.removeOption(o);
                        searchoTable.removeOption(o);
                        new Database().deleteOption(o.getName());
                    }
                    break;
                case "Option Rows":
                    OptionRow or;
                    if (tDisplay.getModel() == optionRowTable)
                    {
                        or = optionRowTable.optionRows.get(tDisplay.getSelectedRow());
                    }
                    else
                    {
                        or = searchorTable.optionRows.get(tDisplay.getSelectedRow());
                    }

                    n = JOptionPane.showOptionDialog(this,
                            "\bDo you really want to remove " + tDisplay.getModel().getValueAt(tDisplay.getSelectedRow(), 0) + " " + tDisplay.getModel().getValueAt(tDisplay.getSelectedRow(), 1) + "?\n"
                            + "All data will be erased!!\n",
                            "Warning!",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.WARNING_MESSAGE,
                            null,
                            options,
                            options[1]);
                    if (n == JOptionPane.YES_OPTION)
                    {

                        optionRowTable.removeOptionRow(or);
                        searchorTable.removeOptionRow(or);
                        new Database().deleteOptionRow(or.getName(), String.valueOf(or.getIdRental()));
                    }
                    break;
            }
        }
        else
        {
            JOptionPane.showMessageDialog(this, "No user is selected!!!", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_bRemoveActionPerformed
    private void bSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSortActionPerformed
        String sort = cbsColumn.getSelectedItem().toString();
        int table = cbTable.getSelectedIndex();

        switch (table)
        {
            case 0:
                switch (sort)
                {
                    case "ID":
                        centreTable.sortByIdCentre();
                        break;
                    case "Address":
                        centreTable.sortByAddress();
                        break;
                    case "Phone":
                        centreTable.sortByPhone();
                        break;
                }
            case 1:
                switch (sort)
                {
                    case "ID":
                        vehicleTable.sortByIdVehicle();
                        break;
                    case "Make":
                        vehicleTable.sortByMake();
                        break;
                    case "Model":
                        vehicleTable.sortByModel();
                        break;
                    case "Category":
                        vehicleTable.sortByCategory();
                        break;
                    case "Power":
                        vehicleTable.sortByPower();
                        break;
                    case "Fuel":
                        vehicleTable.sortByFuel();
                        break;
                    case "Gearbox":
                        vehicleTable.sortByGearbox();
                        break;
                    case "Consumption":
                        vehicleTable.sortByFuelConsumption();
                        break;
                    case "Trunk":
                        vehicleTable.sortByTrunk();
                        break;
                    case "Doors":
                        vehicleTable.sortByDoors();
                        break;
                    case "Price":
                        vehicleTable.sortByPrice();
                        break;
                    case "Centre":
                        vehicleTable.sortByCentre();
                        break;
                }
            case 2:
                switch (sort)
                {
                    case "ID":
                        rentalTable.sortByIdRental();
                        break;
                    case "Start Date":
                        rentalTable.sortByStart();
                        break;
                    case "End Date":
                        rentalTable.sortByEnd();
                        break;
                    case "ID Vehicle":
                        rentalTable.sortByIdVehicle();
                        break;
                    case "ID Client":
                        rentalTable.sortByIdClient();
                        break;
                    case "ID Centre":
                        rentalTable.sortByIdCentre();
                        break;
                }
            case 3:
                switch (sort)
                {
                    case "ID":
                        clientTable.sortById();
                        break;
                    case "First Name":
                        clientTable.sortByFirstName();
                        break;
                    case "Last Name":
                        clientTable.sortByLastName();
                        break;
                }
            case 4:
                switch (sort)
                {
                    case "Name":
                        optionTable.sortByName();
                        break;
                    case "Description":
                        optionTable.sortByDescription();
                        break;
                    case "Price":
                        optionTable.sortByPrice();
                        break;
                }
            case 5:
                switch (sort)
                {
                    case "Name":
                        optionRowTable.sortByName();
                        break;
                    case "ID Rental":
                        optionRowTable.sortByIdRental();
                        break;
                    case "ID Vehicle":
                        optionRowTable.sortByIdVehicle();
                        break;
                    case "ID Client":
                        optionRowTable.sortByIdClient();
                        break;
                    case "ID Centre":
                        optionRowTable.sortByIdCentre();
                        break;
                }
        }
    }//GEN-LAST:event_bSortActionPerformed

    // <editor-fold desc="Back Button">
    private void bBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBackActionPerformed
        String table = cbTable.getSelectedItem().toString();
        switch (table)
        {
            case "Centres":
                tDisplay.setModel(centreTable);
                lInfo.setText("Displayed: Complete centre table.");
                bBack.setEnabled(false);
                break;
            case "Rentals":
                tDisplay.setModel(rentalTable);
                lInfo.setText("Displayed: Complete rental table.");
                bBack.setEnabled(false);
                break;
            case "Vehicles":
                tDisplay.setModel(vehicleTable);
                lInfo.setText("Displayed: Complete vehicle table.");
                bBack.setEnabled(false);
                break;
            case "Clients":
                tDisplay.setModel(clientTable);
                lInfo.setText("Displayed: Complete client table.");
                bBack.setEnabled(false);
                break;
            case "Options":
                tDisplay.setModel(optionTable);
                lInfo.setText("Displayed: Complete option table.");
                bBack.setEnabled(false);
                break;
            case "Option Rows":
                tDisplay.setModel(optionRowTable);
                lInfo.setText("Displayed: Complete option row table.");
                bBack.setEnabled(false);
                break;
        }
    }//GEN-LAST:event_bBackActionPerformed
    // </editor-fold>

    // <editor-fold desc="Splash Screen">
    private static void splashInit()
    {
        SplashScreen mySplash = SplashScreen.getSplashScreen();
        if (mySplash != null)
        {
            Graphics2D splashGraphics = mySplash.createGraphics();
            Font splashFont = new Font("Dialog", Font.ITALIC, 12);
            splashGraphics.setFont(splashFont);
            splashText("Starting...");
            splashProgress(0);
            try
            {
                Thread.sleep(1000);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
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
            Rectangle2D splashTextArea = new Rectangle2D.Double(width * .001, height * 0.875, width, 45.);
            Graphics2D splashGraphics = mySplash.createGraphics();
            splashGraphics.setPaint(new Color(44, 44, 44));
            splashGraphics.fill(splashTextArea);
            splashGraphics.setPaint(new Color(196, 230, 255));
            splashGraphics.drawString(str, (int) (splashTextArea.getX() + 10), (int) (splashTextArea.getY() + 15));
            splashGraphics.drawString("Created by Ionescu Radu Stefan", (int) (splashTextArea.getX() + 490), (int) (splashTextArea.getY() + 15));
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
            Rectangle2D splashProgressArea = new Rectangle2D.Double(width * .001, height * .92, width, 4);
            splashGraphics.setPaint(new Color(44, 44, 44));
            splashGraphics.fill(splashProgressArea);
            splashGraphics.setPaint(new Color(196, 230, 255));
            splashGraphics.draw(splashProgressArea);
            int x = (int) splashProgressArea.getMinX();
            int y = (int) splashProgressArea.getMinY();
            int wid = (int) splashProgressArea.getWidth();
            int hgt = (int) splashProgressArea.getHeight();
            int doneWidth = Math.round(pct * wid / 100.f);
            doneWidth = Math.max(0, Math.min(doneWidth, wid - 1));
            splashGraphics.setPaint(new Color(196, 230, 255));
            splashGraphics.fillRect(x, y + 1, doneWidth, hgt);
            mySplash.update();
        }
    }

    private static void appInit()
    {
        int pctDone = 15;
        splashText("Fetching vehicle data...");
        vehicleTable = new VehicleTable(new Database().getVehicles());
        splashProgress(pctDone);
        try
        {
            Thread.sleep((int) (Math.random() * 400));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        pctDone = 17;
        splashText("Done fetching vehicle data...");
        splashProgress(pctDone);
        try
        {
            Thread.sleep((int) (Math.random() * 100));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        pctDone = 32;
        splashText("Fetching rental data...");
        rentalTable = new RentalTable(new Database().getRentals());
        splashProgress(pctDone);
        try
        {
            Thread.sleep((int) (Math.random() * 400));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        pctDone = 34;
        splashText("Done fetching rental data...");
        splashProgress(pctDone);
        try
        {
            Thread.sleep((int) (Math.random() * 100));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        pctDone = 49;
        splashText("Fetching centre data...");
        centreTable = new CentreTable(new Database().getCentres());
        splashProgress(pctDone);
        try
        {
            Thread.sleep((int) (Math.random() * 400));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        pctDone = 51;
        splashText("Done fetching centre data...");
        splashProgress(pctDone);
        try
        {
            Thread.sleep((int) (Math.random() * 100));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        pctDone = 66;
        splashText("Fetching client data...");
        clientTable = new ClientTable(new Database().getClients());
        splashProgress(pctDone);
        try
        {
            Thread.sleep((int) (Math.random() * 400));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        pctDone = 68;
        splashText("Done fetching client data...");
        splashProgress(pctDone);
        try
        {
            Thread.sleep((int) (Math.random() * 100));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        pctDone = 83;
        splashText("Fetching option data...");
        optionTable = new OptionTable(new Database().getOptions());
        splashProgress(pctDone);
        try
        {
            Thread.sleep((int) (Math.random() * 400));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        pctDone = 85;
        splashText("Done fetching option data...");
        splashProgress(pctDone);
        try
        {
            Thread.sleep((int) (Math.random() * 100));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        pctDone = 98;
        splashText("Fetching option row data...");
        optionRowTable = new OptionRowTable(new Database().getOptionRows());
        splashProgress(pctDone);
        try
        {
            Thread.sleep((int) (Math.random() * 400));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        pctDone = 100;
        splashText("Done fetching option row data...");
        splashProgress(pctDone);
        try
        {
            Thread.sleep((int) (Math.random() * 100));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    //</editor-fold>

    // <editor-fold desc="Variables declaration">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAdd;
    private javax.swing.JButton bBack;
    private javax.swing.JButton bQuit;
    private javax.swing.JButton bRemove;
    private javax.swing.JButton bSearch;
    private javax.swing.JButton bSort;
    private javax.swing.JComboBox<String> cbColumn;
    private javax.swing.JComboBox<String> cbTable;
    private javax.swing.JComboBox<String> cbsColumn;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lAd;
    private javax.swing.JLabel lBy;
    private javax.swing.JLabel lClock;
    private javax.swing.JLabel lInfo;
    private javax.swing.JLabel lSearch;
    private javax.swing.JLabel lSort;
    private javax.swing.JPanel pButtons;
    private javax.swing.JPanel pInfo;
    private javax.swing.JPanel pS;
    private javax.swing.JSeparator sSeparator;
    private javax.swing.JScrollPane scrollPanel;
    private javax.swing.JPanel searchPanel;
    private javax.swing.JPanel sortPanel;
    public javax.swing.JTable tDisplay;
    private javax.swing.JTextField tSearch;
    // End of variables declaration//GEN-END:variables
    //</editor-fold>
}
