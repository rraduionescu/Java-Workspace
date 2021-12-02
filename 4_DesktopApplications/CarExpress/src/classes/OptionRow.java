package classes;

// Created by Ionescu Radu Stefan //

public class OptionRow implements Comparable<OptionRow>
{
    private String name;
    private int idRental;
    private String idVehicle;
    private String idClient;
    private String idCentre;

    public OptionRow()
    {

    }

    public OptionRow(String name, int idRental, String idVehicle, String idClient, String idCentre)
    {
        this.name = name;
        this.idRental = idRental;
        this.idVehicle = idVehicle;
        this.idClient = idClient;
        this.idCentre = idCentre;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getIdRental()
    {
        return idRental;
    }

    public void setIdRental(int idRental)
    {
        this.idRental = idRental;
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
        return name + idRental + idVehicle + idClient + idCentre;
    }

    @Override
    public int compareTo(OptionRow o)
    {
        return ((o.getName() + o.getIdRental() + o.getIdVehicle() + o.getIdClient() + o.getIdCentre()).compareTo(name + idRental + idVehicle + idClient + idCentre));
    }
}
