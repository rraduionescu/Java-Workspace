/*/
 * @author Radu Ionescu
/*/
package MyClasses;

import java.io.Serializable;

public class PhoneNumber implements Serializable
    {
    private long number;
    public long getNumber()
        {
        return number;
        }
    public void setNumber(long x)
        {
        String s = String.valueOf(x);
        if(!s.matches("[0-9]{9}"))throw new RException("Invalid phone number!");
        number = x;
        }
    public PhoneNumber(long x)
        {
        setNumber(x);
        }
    public String toString() 
        {
        return String.valueOf(number); 
        }
    }
