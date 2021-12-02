package classes;

import java.util.Date;

// Created by Ionescu Radu Stefan //

public class Rental implements Comparable<Rental>
{
    private int idRental;
    private Date start;
    private Date end;
    private String idVehicle;
    private String idClient;
    private String idCentre;

    public Rental()
    {
        
    }

    public Rental(int idRental, Date start, Date end)
    {
        this.idRental = idRental;
        this.start = start;
        this.end = end;
    }

    public int getIdRental()
    {
        return idRental;
    }

    public void setIdRental(int idRental)
    {
        this.idRental = idRental;
    }

    public Date getStart()
    {
        return start;
    }

    public void setStart(Date start)
    {
        this.start = start;
    }

    public Date getEnd()
    {
        return end;
    }

    public void setEnd(Date end)
    {
        this.end = end;
    }

    public String getIdVehicle()
    {
        return idVehicle;
    }

    public void setIdVehicle(String idVehicle)
    {
        this.idVehicle = idVehicle;
    }

    public String getIdClient()
    {
        return idClient;
    }

    public void setIdClient(String idClient)
    {
        this.idClient = idClient;
    }

    public String getIdCentre()
    {
        return idCentre;
    }

    public void setIdCentre(String idCentre)
    {
        this.idCentre = idCentre;
    }
    
    @Override
    public String toString()
    {
        return idVehicle + " " + start + " " + end;
    }
    
    @Override
    public int compareTo(Rental o)
    {
        return o.getIdRental() - idRental;
    }
}
