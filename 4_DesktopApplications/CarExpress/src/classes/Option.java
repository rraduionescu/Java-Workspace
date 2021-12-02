package classes;

// Created by Ionescu Radu Stefan //

public class Option implements Comparable<Option>
{
    private String name;
    private String description;
    private float price;

    public Option()
    {
        
    }

    public Option(String name, String description, float price)
    {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public float getPrice()
    {
        return price;
    }

    public void setPrice(float price)
    {
        this.price = price;
    }

    @Override
    public String toString()
    {
        return name;
    }

    @Override
    public int compareTo(Option o)
    {
        return o.getName().compareTo(name);
    }
}
