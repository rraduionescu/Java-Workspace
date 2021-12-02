package classes;

// Created by Ionescu Radu Stefan //

public class Vehicle implements Comparable<Vehicle>
{
    private String idVehicle;
    private String make;
    private String model;
    private String category;
    private int power;
    private boolean fuel;
    private boolean gearbox;
    private float fuelConsumption;
    private int trunk;
    private int doors;
    private float price;
    private String idCentre;

    public Vehicle()
    {

    }

    public Vehicle(String idVehicle, String make, String model, String category, int power, boolean fuel, boolean gearbox, float fuelConsumption, int trunk, int doors, float price, String idCentre)
    {
        this.idVehicle = idVehicle;
        this.make = make;
        this.model = model;
        this.category = category;
        this.power = power;
        this.fuel = fuel;
        this.gearbox = gearbox;
        this.fuelConsumption = fuelConsumption;
        this.trunk = trunk;
        this.doors = doors;
        this.price = price;
        this.idCentre = idCentre;
    }

    public String getIdVehicle()
    {
        return idVehicle;
    }

    public void setIdVehicle(String idVehicle)
    {
        this.idVehicle = idVehicle;
    }

    public String getMake()
    {
        return make;
    }

    public void setMake(String make)
    {
        this.make = make;
    }

    public String getModel()
    {
        return model;
    }

    public void setModel(String model)
    {
        this.model = model;
    }

    public String getCategory()
    {
        return category;
    }

    public void setCategory(String category)
    {
        this.category = category;
    }

    public int getPower()
    {
        return power;
    }

    public void setPower(int power)
    {
        this.power = power;
    }

    public boolean isFuel()
    {
        return fuel;
    }

    public void setFuel(boolean fuel)
    {
        this.fuel = fuel;
    }

    public boolean isGearbox()
    {
        return gearbox;
    }

    public void setGearbox(boolean gearbox)
    {
        this.gearbox = gearbox;
    }

    public float getFuelConsumption()
    {
        return fuelConsumption;
    }

    public void setFuelConsumption(float fuelConsumption)
    {
        this.fuelConsumption = fuelConsumption;
    }

    public int getTrunk()
    {
        return trunk;
    }

    public void setTrunk(int trunk)
    {
        this.trunk = trunk;
    }

    public int getDoors()
    {
        return doors;
    }

    public void setDoors(int doors)
    {
        this.doors = doors;
    }

    public float getPrice()
    {
        return price;
    }

    public void setPrice(float price)
    {
        this.price = price;
    }

    public String getIdCentre()
    {
        return idCentre;
    }

    public void setIdCentre(String centre)
    {
        this.idCentre = centre;
    }

    @Override
    public String toString()
    {
        return idVehicle + " - " + idCentre;
    }

    @Override
    public int compareTo(Vehicle o)
    {
        return o.getIdVehicle().compareTo(idVehicle);
    }
}
