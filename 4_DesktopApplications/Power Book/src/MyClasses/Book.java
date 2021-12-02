/*/
 * @author Radu Ionescu
/*/
package MyClasses;

import java.io.*;
import java.util.*;
import javax.swing.table.AbstractTableModel;

public class Book extends AbstractTableModel implements Serializable
    {
    public ArrayList<User> b = new ArrayList<>();
    public void setBook(ArrayList<User> x)
        {
        b=x;
        }
    public void modifyFirstName(User y,String x)
        {
        for(User u : b)
            {
            if(u.compareTo(y)==0)u.setFirstName(x);
            }
        fireTableDataChanged();
        } 
    public void modifyLastName(User y,String x)
        {
        for(User u : b)
            {
            if(u.compareTo(y)==0)u.setLastName(x);
            }
        fireTableDataChanged();
        }
    public void modifyPhoneNumber(User y,long x)
        {   
        for(User u : b)
            {
            if(u.compareTo(y)==0)u.setPhoneNumber(x);
            }
        fireTableDataChanged();
        }
    public void modifyID(User y,long x)
        { 
        for(User u : b)
            {
            if(u.compareTo(y)==0)u.setID(x);
            }
        fireTableDataChanged();
        }
    public void addUser(User r)
        {
        b.add(r);
        Collections.sort(b);
        fireTableDataChanged();
        }
    public void removeUser(User r)
        {
        b.remove(r);
        Collections.sort(b);
        fireTableDataChanged();
        }
    public void removeUser(int r)
        {
        b.remove(r);
        Collections.sort(b);
        fireTableDataChanged();
        }
    public void saveBook(File x)
        {
        try {
            FileOutputStream saveFile=new FileOutputStream(x);
            ObjectOutputStream save = new ObjectOutputStream(saveFile);
            save.writeObject(b);
            save.close();
            }
        catch(Exception e)
            {
            e.printStackTrace(); 
            }
        }
    public void openBook(File x)
        {
        try {
            FileInputStream saveFile=new FileInputStream(x);
            ObjectInputStream save = new ObjectInputStream(saveFile);
            setBook((ArrayList<User>)(save.readObject()));
            save.close();
            fireTableDataChanged();
            }
        catch(Exception e)
            {
            e.printStackTrace(); 
            }
        }
    public ArrayList<User> searchByFirstName(String x)
        {
        ArrayList<User> u = new ArrayList<>(); 
        for(User r : b)
            {
            if(r.getFirstName().toLowerCase().contains(x.toLowerCase()))u.add(r);
            }
        return u;
        }
    public ArrayList<User> searchByLastName(String x)
        {
        ArrayList<User> u = new ArrayList<>(); 
        for(User r : b)
            {
            if(r.getLastName().toLowerCase().contains(x.toLowerCase()))u.add(r);
            }
        return u;
        }
    public ArrayList<User> searchByID(String x)
        {
        ArrayList<User> u = new ArrayList<>(); 
        for(User r : b)
            {
            if(String.valueOf(r.getID()).contains(x))u.add(r);
            }
        return u;
        }
    public ArrayList<User> searchByPhoneNumber(String x)
        {
        ArrayList<User> u = new ArrayList<>(); 
        for(User r : b)
            {
            if(String.valueOf(r.getPhoneNumber()).contains(x))u.add(r);
            }
        return u;
        }
    public void sortByFirstName()
        {
        Comparator<User> c = new Comparator<User>()
                                {
                                public int compare(User x,User y) 
                                    {
                                    return x.getFirstName().compareToIgnoreCase(y.getFirstName());
                                    }
                                };
        Collections.sort(b,c);
        fireTableDataChanged();
        }
    public void sortByLastName()
        {
        Comparator<User> c = new Comparator<User>()
                                {
                                public int compare(User x,User y) 
                                    {
                                    return x.getLastName().compareToIgnoreCase(y.getLastName());
                                    }
                                };
        Collections.sort(b,c);
        fireTableDataChanged();
        }
    public void sortByID()
        {
        Comparator<User> c = new Comparator<User>()
                                {
                                public int compare(User x,User y) 
                                    {
                                    long k;
                                    k= (long)(x.getID()-y.getID());
                                    if(k<0)return -1;
                                    return 1;
                                    }
                                };
        Collections.sort(b,c);
        fireTableDataChanged();
        }
    public void sortByPhoneNumber()
        {
        Comparator<User> c = new Comparator<User>()
                                {
                                public int compare(User x,User y) 
                                    {
                                    return (int)(x.getPhoneNumber()-y.getPhoneNumber());
                                    }
                                };
        Collections.sort(b,c);
        fireTableDataChanged();
        }
    public int getRowCount() 
        {
        return b.size();
        }
    public int getColumnCount() 
        {
        return 4;
        }
    public Object getValueAt(int row, int col)     
        {
        switch(col) {
            case(0): return Book.getCapitalized(b.get(row).getFirstName()); 
            case(1): return Book.getCapitalized(b.get(row).getLastName());
            case(2): return b.get(row).getID();
            case(3): if(String.valueOf(b.get(row).getPhoneNumber()).length()==10)return b.get(row).getPhoneNumber(); 
                        else return String.valueOf("0"+b.get(row).getPhoneNumber());
                    }
        return null;
        }
    public String getColumnName(int x)
        {
        switch(x) {
            case(0): return "First Name"; 
            case(1): return "Last Name";
            case(2): return "ID Number";
            case(3): return "Phone Number"; 
                    }
        return null;
        }
    public static String getCapitalized(String x)  
        {  
        String lastPart = x.substring(1);  
        String firstLetter = x.substring(0, 1); 
        return (firstLetter.toUpperCase()+lastPart);  
        }  
    public void fire()
        {
        fireTableDataChanged();
        }
    }
