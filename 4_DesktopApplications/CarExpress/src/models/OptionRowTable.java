package models;

import classes.OptionRow;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.table.AbstractTableModel;

// Created by Ionescu Radu Stefan //

public class OptionRowTable extends AbstractTableModel
{
    public ArrayList<OptionRow> optionRows;

    public OptionRowTable(ArrayList<OptionRow> optionRows)
    {
        this.optionRows = optionRows;
    }
    
    //<editor-fold desc="ADD">
    //</editor-fold>
    
    //<editor-fold desc="REMOVE">
    public void removeOptionRow(OptionRow c)
    {
        optionRows.remove(c);
        Collections.sort(optionRows);
        fireTableDataChanged();
    }
    //</editor-fold>

    //<editor-fold desc="SEARCH">
    public ArrayList<OptionRow> searchByName(String x)
    {
        ArrayList<OptionRow> response = new ArrayList<>();
        for (OptionRow o : optionRows)
        {
            if (o.getName().contains(x))
            {
                response.add(o);
            }
        }
        return response;
    }
    public ArrayList<OptionRow> searchByIdCentre(String x)
    {
        ArrayList<OptionRow> response = new ArrayList<>();
        for (OptionRow o : optionRows)
        {
            if (o.getIdCentre().contains(x))
            {
                response.add(o);
            }
        }
        return response;
    }
    public ArrayList<OptionRow> searchByIdClient(String x)
    {
        ArrayList<OptionRow> response = new ArrayList<>();
        for (OptionRow c : optionRows)
        {
            if (c.getIdClient().contains(x))
            {
                response.add(c);
            }
        }
        return response;
    }
    public ArrayList<OptionRow> searchByIdVehicle(String x)
    {
        ArrayList<OptionRow> response = new ArrayList<>();
        for (OptionRow v : optionRows)
        {
            if (v.getIdVehicle().contains(x))
            {
                response.add(v);
            }
        }
        return response;
    }
    public ArrayList<OptionRow> searchByIdRental(String x)
    {
        ArrayList<OptionRow> response = new ArrayList<>();
        int y = Integer.parseInt(x);
        for (OptionRow o : optionRows)
        {
            if (o.getIdRental() == y)
            {
                response.add(o);
            }
        }
        return response;
    }
    //</editor-fold>
    
    //<editor-fold desc="SORT">
    public void sortByName()
    {
        Comparator<OptionRow> c = new Comparator<OptionRow>()
        {
            public int compare(OptionRow x, OptionRow y)
            {
                return x.getName().compareToIgnoreCase(y.getName());
            }
        };
        Collections.sort(optionRows, c);
        fireTableDataChanged();
    }
    public void sortByIdRental()
    {
        Comparator<OptionRow> c = new Comparator<OptionRow>()
        {
            public int compare(OptionRow x, OptionRow y)
            {
                return x.getIdRental() - y.getIdRental();
            }
        };
        Collections.sort(optionRows, c);
        fireTableDataChanged();
    }
    public void sortByIdVehicle()
    {
        Comparator<OptionRow> c = new Comparator<OptionRow>()
        {
            public int compare(OptionRow x, OptionRow y)
            {
                return x.getIdVehicle().compareToIgnoreCase(y.getIdVehicle());
            }
        };
        Collections.sort(optionRows, c);
        fireTableDataChanged();
    }
    public void sortByIdClient()
    {
        Comparator<OptionRow> c = new Comparator<OptionRow>()
        {
            public int compare(OptionRow x, OptionRow y)
            {
                return x.getIdClient().compareToIgnoreCase(y.getIdClient());
            }
        };
        Collections.sort(optionRows, c);
        fireTableDataChanged();
    }
    public void sortByIdCentre()
    {
        Comparator<OptionRow> c = new Comparator<OptionRow>()
        {
            public int compare(OptionRow x, OptionRow y)
            {
                return x.getIdCentre().compareToIgnoreCase(y.getIdCentre());
            }
        };
        Collections.sort(optionRows, c);
        fireTableDataChanged();
    }
    //</editor-fold>
    
    //<editor-fold desc="ADAPTER">
    public int getRowCount()
    {
        return optionRows.size();
    }
    public int getColumnCount()
    {
        return 5;
    }
    public Object getValueAt(int row, int col)
    {
        switch (col)
        {
            case (0):
                return optionRows.get(row).getName();
            case (1):
                return optionRows.get(row).getIdRental();
            case (2):
                return optionRows.get(row).getIdVehicle();
            case (3):
                return optionRows.get(row).getIdClient();
            case (4):
                return optionRows.get(row).getIdCentre();
        }
        return null;
    }
    public String getColumnName(int x)
    {
        switch (x)
        {
            case (0):
                return "Name";
            case (1):
                return "ID Rental";
            case (2):
                return "ID Vehicle";
            case (3):
                return "ID Client";
            case (4):
                return "ID Centre";
        }
        return null;
    }
    public void fire()
    {
        fireTableDataChanged();
    }
    //</editor-fold>
}
