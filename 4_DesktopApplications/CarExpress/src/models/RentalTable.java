package models;

import classes.Rental;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Locale;
import javax.swing.table.AbstractTableModel;

// Created by Ionescu Radu Stefan //

public class RentalTable extends AbstractTableModel
{
    public ArrayList<Rental> rentals;

    public RentalTable(ArrayList<Rental> rentals)
    {
        this.rentals = rentals;
    }

    //<editor-fold desc="ADD">
    //</editor-fold>
    
    //<editor-fold desc="REMOVE">
    public void removeRental(Rental r)
    {
        rentals.remove(r);
        Collections.sort(rentals);
        fireTableDataChanged();
    }
    //</editor-fold>
    
    //<editor-fold desc="SEARCH">
    public ArrayList<Rental> searchByIdRental(String x)
    {
        ArrayList<Rental> response = new ArrayList<>();
        int y = Integer.parseInt(x);
        for (Rental o : rentals)
        {
            if (o.getIdRental() == y)
            {
                response.add(o);
            }
        }
        return response;
    }
    public ArrayList<Rental> searchByStart(String x)
    {
        ArrayList<Rental> response = new ArrayList<>();
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        try
        {
            Date d = format.parse(x);
            for (Rental o : rentals)
            {   
                if (o.getStart() == d)
                {
                    response.add(o);
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
      
        return response;
    }
    public ArrayList<Rental> searchByEnd(String x)
    {
        ArrayList<Rental> response = new ArrayList<>();
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        try
        {
            Date d = format.parse(x);
            for (Rental o : rentals)
            {
                if (o.getEnd() == d)
                {
                    response.add(o);
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return response;
    }
    public ArrayList<Rental> searchByIdVehicle(String x)
    {
        ArrayList<Rental> response = new ArrayList<>();
        for (Rental v : rentals)
        {
            if (v.getIdVehicle().contains(x))
            {
                response.add(v);
            }
        }
        return response;
    }
    public ArrayList<Rental> searchByIdClient(String x)
    {
        ArrayList<Rental> response = new ArrayList<>();
        for (Rental c : rentals)
        {
            if (c.getIdClient().contains(x))
            {
                response.add(c);
            }
        }
        return response;
    }
    public ArrayList<Rental> searchByIdCentre(String x)
    {
        ArrayList<Rental> response = new ArrayList<>();
        for (Rental c : rentals)
        {
            if (c.getIdCentre().contains(x))
            {
                response.add(c);
            }
        }
        return response;
    }
    //</editor-fold>

    //<editor-fold desc="SORT">
    public void sortByIdRental()
    {
        Comparator<Rental> c = new Comparator<Rental>()
        {
            public int compare(Rental x, Rental y)
            {
                return x.getIdRental() - y.getIdRental();
            }

        };
        Collections.sort(rentals, c);
        fireTableDataChanged();
    }
    public void sortByStart()
    {
        Comparator<Rental> c = new Comparator<Rental>()
        {
            public int compare(Rental x, Rental y)
            {
                return (int) (x.getStart().getTime() - y.getStart().getTime());
            }

        };
        Collections.sort(rentals, c);
        fireTableDataChanged();
    }
    public void sortByEnd()
    {
        Comparator<Rental> c = new Comparator<Rental>()
        {
            public int compare(Rental x, Rental y)
            {
                return (int) (x.getEnd().getTime() - y.getEnd().getTime());
            }

        };
        Collections.sort(rentals, c);
        fireTableDataChanged();
    }
    public void sortByIdVehicle()
    {
        Comparator<Rental> c = new Comparator<Rental>()
        {
            public int compare(Rental x, Rental y)
            {
                return x.getIdVehicle().compareToIgnoreCase(y.getIdVehicle());
            }

        };
        Collections.sort(rentals, c);
        fireTableDataChanged();
    }
    public void sortByIdClient()
    {
        Comparator<Rental> c = new Comparator<Rental>()
        {
            public int compare(Rental x, Rental y)
            {
                return x.getIdClient().compareToIgnoreCase(y.getIdClient());
            }

        };
        Collections.sort(rentals, c);
        fireTableDataChanged();
    }
    public void sortByIdCentre()
    {
        Comparator<Rental> c = new Comparator<Rental>()
        {
            public int compare(Rental x, Rental y)
            {
                return x.getIdCentre().compareToIgnoreCase(y.getIdCentre());
            }

        };
        Collections.sort(rentals, c);
        fireTableDataChanged();
    }
    //</editor-fold>

    //<editor-fold desc="ADAPTER">
    public int getRowCount()
    {
        return rentals.size();
    }
    public int getColumnCount()
    {
        return 6;
    }
    public Object getValueAt(int row, int col)
    {
        DateFormat format = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);
        switch (col)
        {
            case (0):
                return rentals.get(row).getIdRental();
            case (1):
                return format.format(rentals.get(row).getStart());
            case (2):
                return format.format(rentals.get(row).getEnd());
            case (3):
                return rentals.get(row).getIdVehicle();
            case (4):
                return rentals.get(row).getIdClient();
            case (5):
                return rentals.get(row).getIdCentre();
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
                return "Start Date";
            case (2):
                return "End Date";
            case (3):
                return "ID Vehicle";
            case (4):
                return "ID Client";
            case (5):
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
