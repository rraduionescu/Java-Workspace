package classes;

// Created by Ionescu Radu Stefan //

public class Centre implements Comparable<Centre>
{
    private String idCentre;
    private String address;
    private String phone;

    public Centre()
    {
        
    }

    public Centre(String idCentre, String address, String phone)
    {
        this.idCentre = idCentre;
        this.address = address;
        this.phone = phone;
    }

    public String getIdCentre()
    {
        return idCentre;
    }

    public void setIdCentre(String idCentre)
    {
        this.idCentre = idCentre;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    @Override
    public String toString()
    {
        return idCentre;
    }

    @Override
    public int compareTo(Centre o)
    {
        return o.getIdCentre().compareTo(idCentre);
    }
}
