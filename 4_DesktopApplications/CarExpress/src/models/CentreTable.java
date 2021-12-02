package models;

import classes.Centre;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.table.AbstractTableModel;

// Created by Ionescu Radu Stefan //

public class CentreTable extends AbstractTableModel
{
    public ArrayList<Centre> centres;

    public CentreTable(ArrayList<Centre> centres)
    {
        this.centres = centres;
    }
    
    //<editor-fold desc="ADD">
    //</editor-fold>
    
    //<editor-fold desc="REMOVE">
    public void removeCentre(Centre c)
    {
        centres.remove(c);
        Collections.sort(centres);
        fireTableDataChanged();
    }
    //</editor-fold>
    
    //<editor-fold desc="SEARCH">
    public ArrayList<Centre> searchByIdCentre(String x)
    {
        ArrayList<Centre> response = new ArrayList<>();
        for (Centre c : centres)
        {
            if (c.getIdCentre().contains(x))
            {
                response.add(c);
            }
        }
        return response;
    }
    public ArrayList<Centre> searchByAddress(String x)
    {
        ArrayList<Centre> response = new ArrayList<>();
        for (Centre c : centres)
        {
            if (c.getAddress().contains(x))
            {
                response.add(c);
            }
        }
        return response;
    }
    public ArrayList<Centre> searchByPhone(String x)
    {
        ArrayList<Centre> response = new ArrayList<>();
        for (Centre c : centres)
        {
            if (c.getPhone().contains(x))
            {
                response.add(c);
            }
        }
        return response;
    }
    //</editor-fold>

    //<editor-fold desc="SORT">
    public void sortByIdCentre()
    {
        Comparator<Centre> c = new Comparator<Centre>()
        {
            public int compare(Centre x, Centre y)
            {
                return x.getIdCentre().compareToIgnoreCase(y.getIdCentre());
            }
        };
        Collections.sort(centres, c);
        fireTableDataChanged();
    }
    public void sortByAddress()
    {
        Comparator<Centre> c = new Comparator<Centre>()
        {
            public int compare(Centre x, Centre y)
            {
                return x.getAddress().compareToIgnoreCase(y.getAddress());
            }
        };
        Collections.sort(centres, c);
        fireTableDataChanged();
    }
    public void sortByPhone()
    {
        Comparator<Centre> c = new Comparator<Centre>()
        {
            public int compare(Centre x, Centre y)
            {
                return x.getPhone().compareToIgnoreCase(y.getPhone());
            }
        };
        Collections.sort(centres, c);
        fireTableDataChanged();
    }
    //</editor-fold>
    
    //<editor-fold desc="ADAPTER">
    public int getRowCount()
    {
        return centres.size();
    }
    public int getColumnCount()
    {
        return 3;
    }
    public Object getValueAt(int row, int col)
    {
        switch (col)
        {
            case (0):
                return centres.get(row).getIdCentre();
            case (1):
                return centres.get(row).getAddress();
            case (2):
                return centres.get(row).getPhone();
        }
        return null;
    }
    public String getColumnName(int x)
    {
        switch (x)
        {
            case (0):
                return "ID";
            case (1):
                return "Address";
            case (2):
                return "Phone";
        }
        return null;
    }
    public void fire()
    {
        fireTableDataChanged();
    }
    //</editor-fold>
}