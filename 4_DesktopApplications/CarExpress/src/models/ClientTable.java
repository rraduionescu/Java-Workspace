package models;

import classes.Client;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.table.AbstractTableModel;

// Created by Ionescu Radu Stefan //

public class ClientTable extends AbstractTableModel
{
    public ArrayList<Client> clients;

    public ClientTable(ArrayList<Client> clients)
    {
        this.clients = clients;
    }

    //<editor-fold desc="ADD">
    //</editor-fold>
    
    //<editor-fold desc="REMOVE">
    public void removeClient(Client c)
    {
        clients.remove(c);
        Collections.sort(clients);
        fireTableDataChanged();
    }
    //</editor-fold>
    
    //<editor-fold desc="SEARCH">
    public ArrayList<Client> searchByIdClient(String x)
    {
        ArrayList<Client> response = new ArrayList<>();
        for (Client c : clients)
        {
            if (c.getIdClient().contains(x))
            {
                response.add(c);
            }
        }
        return response;
    }
    public ArrayList<Client> searchByFirstName(String x)
    {
        ArrayList<Client> response = new ArrayList<>();
        for (Client c : clients)
        {
            if (c.getFirstName().contains(x))
            {
                response.add(c);
            }
        }
        return response;
    }
    public ArrayList<Client> searchByLastName(String x)
    {
        ArrayList<Client> response = new ArrayList<>();
        for (Client c : clients)
        {
            if (c.getLastName().contains(x))
            {
                response.add(c);
            }
        }
        return response;
    }
    //</editor-fold>
    
    //<editor-fold desc="SORT">
    public void sortById()
    {
        Comparator<Client> c = new Comparator<Client>()
        {
            public int compare(Client x, Client y)
            {
                return x.getIdClient().compareToIgnoreCase(y.getIdClient());
            }
        };
        Collections.sort(clients, c);
        fireTableDataChanged();
    }
    public void sortByFirstName()
    {
        Comparator<Client> c = new Comparator<Client>()
        {
            public int compare(Client x, Client y)
            {
                return x.getFirstName().compareToIgnoreCase(y.getFirstName());
            }
        };
        Collections.sort(clients, c);
        fireTableDataChanged();
    }
    public void sortByLastName()
    {
        Comparator<Client> c = new Comparator<Client>()
        {
            public int compare(Client x, Client y)
            {
                return x.getLastName().compareToIgnoreCase(y.getLastName());
            }
        };
        Collections.sort(clients, c);
        fireTableDataChanged();
    }
    //</editor-fold>
    
    //<editor-fold desc="ADAPTER">
    public int getRowCount()
    {
        return clients.size();
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
                return clients.get(row).getIdClient();
            case (1):
                return clients.get(row).getFirstName();
            case (2):
                return clients.get(row).getLastName();
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
                return "First Name";
            case (2):
                return "Last Name";
        }
        return null;
    }
    public void fire()
    {
        fireTableDataChanged();
    }
    //</editor-fold>
}
