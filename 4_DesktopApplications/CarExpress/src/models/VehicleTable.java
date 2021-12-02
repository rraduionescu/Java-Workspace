package models;

import classes.Vehicle;
import java.io.*;
import java.util.*;
import javax.swing.table.AbstractTableModel;

// Created by Ionescu Radu Stefan //

public class VehicleTable extends AbstractTableModel
{
    public ArrayList<Vehicle> vehicles;

    public VehicleTable(ArrayList<Vehicle> vehicles)
    {
        this.vehicles = vehicles;
    }
    
    //<editor-fold desc="ADD">
    public void addVehicle(Vehicle v)
    {
        vehicles.add(v);
        Collections.sort(vehicles);
        fireTableDataChanged();
    }
    //</editor-fold>
    
    //<editor-fold desc="REMOVE">
    public void removeVehicle(Vehicle v)
    {
        vehicles.remove(v);
        Collections.sort(vehicles);
        fireTableDataChanged();
    }
    //</editor-fold>

    //<editor-fold desc="SEARCH">
    public ArrayList<Vehicle> searchByIdVehicle(String x)
    {
        ArrayList<Vehicle> response = new ArrayList<>();
        for (Vehicle v : vehicles)
        {
            if (v.getIdVehicle().contains(x))
            {
                response.add(v);
            }
        }
        return response;
    }
    public ArrayList<Vehicle> searchByMake(String x)
    {
        ArrayList<Vehicle> response = new ArrayList<>();
        for (Vehicle v : vehicles)
        {
            if (v.getMake().contains(x))
            {
                response.add(v);
            }
        }
        return response;
    }
    public ArrayList<Vehicle> searchByModel(String x)
    {
        ArrayList<Vehicle> response = new ArrayList<>();
        for (Vehicle v : vehicles)
        {
            if (v.getModel().contains(x))
            {
                response.add(v);
            }
        }
        return response;
    }
    public ArrayList<Vehicle> searchByCategory(String x)
    {
        ArrayList<Vehicle> response = new ArrayList<>();
        for (Vehicle v : vehicles)
        {
            if (v.getCategory().contains(x))
            {
                response.add(v);
            }
        }
        return response;
    }
    public ArrayList<Vehicle> searchByPower(String x)
    {
        ArrayList<Vehicle> response = new ArrayList<>();
        float y = Float.parseFloat(x);
        for (Vehicle v : vehicles)
        {
            if (v.getPower() == y)
            {
                response.add(v);
            }
        }
        return response;
    }
    public ArrayList<Vehicle> searchByFuel(String x)
    {
        boolean y = (x.compareTo("diesel")==0?false:true);
        ArrayList<Vehicle> response = new ArrayList<>();
        for (Vehicle v : vehicles)
        {
            if (v.isFuel() == y)
            {
                response.add(v);
            }
        }
        return response;
    }
    public ArrayList<Vehicle> searchByGearbox(String x)
    {
        boolean y = (x.compareTo("manual")==0?true:false);
        ArrayList<Vehicle> response = new ArrayList<>();
        for (Vehicle v : vehicles)
        {
            if (v.isGearbox() == y)
            {
                response.add(v);
            }
        }
        return response;
    }
    public ArrayList<Vehicle> searchByFuelConsumption(String x)
    {
        ArrayList<Vehicle> response = new ArrayList<>();
        float y = Float.parseFloat(x);
        for (Vehicle v : vehicles)
        {
            if (v.getFuelConsumption() == y)
            {
                response.add(v);
            }
        }
        return response;
    }
    public ArrayList<Vehicle> searchByTrunk(String x)
    {
        ArrayList<Vehicle> response = new ArrayList<>();
        int y = Integer.parseInt(x);
        for (Vehicle v : vehicles)
        {
            if (v.getTrunk() == y)
            {
                response.add(v);
            }
        }
        return response;
    }
    public ArrayList<Vehicle> searchByDoors(String x)
    {
        ArrayList<Vehicle> response = new ArrayList<>();
        int y = Integer.parseInt(x);
        for (Vehicle v : vehicles)
        {
            if (v.getDoors() == y)
            {
                response.add(v);
            }
        }
        return response;
    }
    public ArrayList<Vehicle> searchByPrice(String x)
    {
        ArrayList<Vehicle> response = new ArrayList<>();
        float y = Float.parseFloat(x);
        for (Vehicle v : vehicles)
        {
            if (v.getPrice() == y)
            {
                response.add(v);
            }
        }
        return response;
    }
    public ArrayList<Vehicle> searchByCentre(String x)
    {
        ArrayList<Vehicle> response = new ArrayList<>();
        for (Vehicle v : vehicles)
        {
            if (v.getIdCentre().contains(x))
            {
                response.add(v);
            }
        }
        return response;
    }
    //</editor-fold>
   
    //<editor-fold desc="SORT">
    public void sortByIdVehicle()
    {
        Comparator<Vehicle> c = new Comparator<Vehicle>()
        {
            public int compare(Vehicle x, Vehicle y)
            {
                return x.getIdVehicle().compareToIgnoreCase(y.getIdVehicle());
            }
        };
        Collections.sort(vehicles, c);
        fireTableDataChanged();
    }
    public void sortByMake()
    {
        Comparator<Vehicle> c = new Comparator<Vehicle>()
        {
            public int compare(Vehicle x, Vehicle y)
            {
                return x.getMake().compareToIgnoreCase(y.getMake());
            }
        };
        Collections.sort(vehicles, c);
        fireTableDataChanged();
    }
    public void sortByModel()
    {
        Comparator<Vehicle> c = new Comparator<Vehicle>()
        {
            public int compare(Vehicle x, Vehicle y)
            {
                return x.getModel().compareToIgnoreCase(y.getModel());
            }
        };
        Collections.sort(vehicles, c);
        fireTableDataChanged();
    }
    public void sortByCategory()
    {
        Comparator<Vehicle> c = new Comparator<Vehicle>()
        {
            public int compare(Vehicle x, Vehicle y)
            {
                return x.getCategory().compareToIgnoreCase(y.getCategory());
            }
        };
        Collections.sort(vehicles, c);
        fireTableDataChanged();
    }
    public void sortByPower()
    {
        Comparator<Vehicle> c = new Comparator<Vehicle>()
        {
            public int compare(Vehicle x, Vehicle y)
            {
                return x.getPower() - y.getPower();
            }
        };
        Collections.sort(vehicles, c);
        fireTableDataChanged();
    }
    public void sortByFuel()
    {
        Comparator<Vehicle> c = new Comparator<Vehicle>()
        {
            public int compare(Vehicle x, Vehicle y)
            {
                if (x.isFuel() != y.isFuel())
                {
                    return -1;
                }
                return 0;
            }
        };
        Collections.sort(vehicles, c);
        Collections.sort(vehicles, c);
        fireTableDataChanged();
    }
    public void sortByGearbox()
    {
        Comparator<Vehicle> c = new Comparator<Vehicle>()
        {
            public int compare(Vehicle x, Vehicle y)
            {
                if (x.isGearbox() != y.isGearbox())
                {
                    return -1;
                }
                return 0;
            }
        };
        Collections.sort(vehicles, c);
        Collections.sort(vehicles, c);
        fireTableDataChanged();
    }
    public void sortByFuelConsumption()
    {
        Comparator<Vehicle> c = new Comparator<Vehicle>()
        {
            public int compare(Vehicle x, Vehicle y)
            {
                return (int) (x.getFuelConsumption() - y.getFuelConsumption());
            }
        };
        Collections.sort(vehicles, c);
        fireTableDataChanged();
    }
    public void sortByTrunk()
    {
        Comparator<Vehicle> c = new Comparator<Vehicle>()
        {
            public int compare(Vehicle x, Vehicle y)
            {
                return x.getTrunk() - y.getTrunk();
            }
        };
        Collections.sort(vehicles, c);
        fireTableDataChanged();
    }
    public void sortByDoors()
    {
        Comparator<Vehicle> c = new Comparator<Vehicle>()
        {
            public int compare(Vehicle x, Vehicle y)
            {
                return x.getDoors() - y.getDoors();
            }
        };
        Collections.sort(vehicles, c);
        fireTableDataChanged();
    }
    public void sortByPrice()
    {
        Comparator<Vehicle> c = new Comparator<Vehicle>()
        {
            public int compare(Vehicle x, Vehicle y)
            {
                return (int) (x.getPrice() - y.getPrice());
            }
        };
        Collections.sort(vehicles, c);
        fireTableDataChanged();
    }
    public void sortByCentre()
    {
        Comparator<Vehicle> c = new Comparator<Vehicle>()
        {
            public int compare(Vehicle x, Vehicle y)
            {
                return x.getIdCentre().compareToIgnoreCase(y.getIdCentre());
            }
        };
        Collections.sort(vehicles, c);
        fireTableDataChanged();
    }
    //</editor-fold>

    //<editor-fold desc="ADAPTER">
    public int getRowCount()
    {
        return vehicles.size();
    }
    public int getColumnCount()
    {
        return 12;
    }
    public Object getValueAt(int row, int col)
    {
        switch (col)
        {
            case (0):
                return vehicles.get(row).getIdVehicle();
            case (1):
                return vehicles.get(row).getMake();
            case (2):
                return vehicles.get(row).getModel();
            case (3):
                return vehicles.get(row).getCategory();
            case (4):
                return vehicles.get(row).getPower();
            case (5):
                if (vehicles.get(row).isFuel())
                {
                    return "petrol";
                }
                else
                {
                    return "diesel";
                }
            case (6):
                if (vehicles.get(row).isGearbox())
                {
                    return "manual";
                }
                else
                {
                    return "automatic";
                }
            case (7):
                return vehicles.get(row).getFuelConsumption();
            case (8):
                return vehicles.get(row).getTrunk();
            case (9):
                return vehicles.get(row).getDoors();
            case (10):
                return vehicles.get(row).getPrice();
            case (11):
                return vehicles.get(row).getIdCentre();
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
                return "Make";
            case (2):
                return "Model";
            case (3):
                return "Category";
            case (4):
                return "Power";
            case (5):
                return "Fuel";
            case (6):
                return "Gearbox";
            case (7):
                return "Consumption";
            case (8):
                return "Trunk";
            case (9):
                return "Doors";
            case (10):
                return "Price";
            case (11):
                return "Centre";
        }
        return null;
    }
    public void fire()
    {
        fireTableDataChanged();
    }
    //</editor-fold>
}
