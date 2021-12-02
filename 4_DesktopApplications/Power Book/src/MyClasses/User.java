/*/
 * @author Radu Ionescu
/*/
package MyClasses;

import java.io.Serializable;

public class User implements Comparable<User>,Serializable
    {
    private String firstName,lastName; 
    private long ID;
    private PhoneNumber phoneNumber;
    public String getFirstName()
        {
        return firstName;
        }
    public String getLastName()
        {
        return lastName;
        }
    public long getID()
        {
        return ID;
        }
    public long getPhoneNumber()
        {
        return phoneNumber.getNumber();
        }
    public void setFirstName(String x)
        {
        if(!x.matches("[a-zA-Z]{3,20}"))throw new RException("Invalid first name!");
        firstName=x;
        }
    public void setLastName(String x)
        {
        if(!x.matches("[a-zA-Z]{3,20}"))throw new RException("Invalid last name!");
        lastName=x;
        }        
    public void setID(long x)
        {
        String id = String.valueOf(x);
            System.out.println(id);
        if(!id.matches("[0-9]{13}"))throw new RException("Invalid ID!");
        ID=x;
        }
    public void setPhoneNumber(long x)
        {
        phoneNumber.setNumber(x);
        }
    public User(String f,String l,long i,long p)
        {
        setFirstName(f);
        setLastName(l);
        setID(i);
        phoneNumber = new PhoneNumber(p);
        }
    public String toString() 
        {
        return String.valueOf(ID);
        }               
    
    public int compareTo(User x) 
        {
        return (int)(ID-x.getID());
        }
    }
