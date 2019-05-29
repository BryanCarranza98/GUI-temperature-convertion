package domain;

public class TemperatureException
        extends Exception
{


    public TemperatureException()
    {
        this ("Invalid temperature operation occurred !!! ");
       // super("Invalid temperature operation occurred !!! ");

    }


    public TemperatureException(String message )
    {
        super(message);

    }


}
