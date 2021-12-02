package models;

import classes.Option;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.table.AbstractTableModel;

// Created by Ionescu Radu Stefan //

public class OptionTable extends AbstractTableModel
{
    public ArrayList<Option> options;

    public OptionTable(ArrayList<Option> options)
    {
        this.options = options;
    }
    
    //<editor-fold desc="ADD">
    //</editor-fold>
    
    //<editor-fold desc="REMOVE">
    public void removeOption(Option o)
    {
        options.remove(o);
        Collections.sort(options);
        fireTableDataChanged();
    }
    //</editor-fold>
    
    //<editor-fold desc="SEARCH">
    public ArrayList<Option> searchByName(String x)
    {
        ArrayList<Option> response = new ArrayList<>();
        for (Option o : options)
        {
            if (o.getName().contains(x))
            {
                response.add(o);
            }
        }
        return response;
    }
    public ArrayList<Option> searchByPrice(String x)
    {
        ArrayList<Option> response = new ArrayList<>();
        float y = Float.parseFloat(x);
        for (Option o : options)
        {
            if (o.getPrice() == y)
            {
                response.add(o);
            }
        }
        return response;
    }
    public ArrayList<Option> searchByDescription(String x)
    {
        ArrayList<Option> response = new ArrayList<>();
        for (Option o : options)
        {
            if (o.getDescription().contains(x))
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
        Comparator<Option> c = new Comparator<Option>()
        {
            public int compare(Option x, Option y)
            {
                return x.getName().compareToIgnoreCase(y.getName());
            }
        };
        Collections.sort(options, c);
        fireTableDataChanged();
    }
    public void sortByPrice()
    {
        Comparator<Option> c = new Comparator<Option>()
        {
            public int compare(Option x, Option y)
            {
                return (int)((x.getPrice()-y.getPrice())*10000);
            }
        };
        Collections.sort(options, c);
        fireTableDataChanged();
    }
    public void sortByDescription()
    {
        Comparator<Option> c = new Comparator<Option>()
        {
            public int compare(Option x, Option y)
            {
                return x.getDescription().compareToIgnoreCase(y.getDescription());
            }
        };
        Collections.sort(options, c);
        fireTableDataChanged();
    }
    //</editor-fold>

    //<editor-fold desc="ADAPTER">
    public int getRowCount()
    {
        return options.size();
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
                return options.get(row).getName();
            case (1):
                return options.get(row).getPrice();
            case (2):
                return options.get(row).getDescription();
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
                return "Price";
            case (2):
                return "Description";
        }
        return null;
    }
    public void fire()
    {
        fireTableDataChanged();
    }
    //</editor-fold>
}
