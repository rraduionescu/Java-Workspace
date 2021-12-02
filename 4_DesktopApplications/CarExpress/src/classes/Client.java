package classes;

// Created by Ionescu Radu Stefan //

public class Client implements Comparable<Client>
{
    private String idClient;
    private String firstName;
    private String lastName;
    private String address;

    public Client()
    {
        
    }

    public Client(String idClient, String firstName, String lastName)
    {
        this.idClient = idClient;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getIdClient()
    {
        return idClient;
    }

    public void setIdClient(String idClient)
    {
        this.idClient = idClient;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    @Override
    public String toString()
    {
        return firstName + " " + lastName;
    }

    @Override
    public int compareTo(Client o)
    {
         return o.getIdClient().compareTo(idClient);
    }
}
