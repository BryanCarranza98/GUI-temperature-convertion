package domain;
import org.apache.logging.log4j.*;

public class Temperature
{
    private static Logger logger = LogManager.getLogger(Temperature.class);

    public enum Scale { Kelvin, Celsius, Fahrenheit };


    private static final double LOWEST_KELVIN_TEMP = 0.0;
    private static final double LOWEST_CELSIUS_TEMP = -273.15;
    private static final double LOWEST_FAHRENHEIT_TEMP = -459.67;

    private double kelvin;
    private double celsius;
    private double fahrenheit;


    public Temperature()
            throws TemperatureException
    {
        logger.debug("INSIDE Temperature ");

        setKelvin( LOWEST_KELVIN_TEMP);

    }

    public Temperature(double inputTemp)
            throws TemperatureException
    {

        setKelvin(inputTemp);

    }




    public Temperature(Scale inputScale, double inputTemp)
            throws TemperatureException
    {
        //int intScale = inputScale.ordinal();


        switch (inputScale )
        {
            case Kelvin:
                setKelvin(inputTemp);
                break;
            case Celsius:
                setCelsius(inputTemp);
                break;
            case Fahrenheit:
                setFahrenheit(inputTemp);
                break;

        }



    }



    public void setKelvin(double kelvin)
            throws TemperatureException
    {

        if(kelvin < LOWEST_KELVIN_TEMP)
        {
            throw new TemperatureException("Invalid Kelvin Temp (must be >=" + LOWEST_KELVIN_TEMP+ ")" );
        }

        this.kelvin = kelvin;
        convertKelvinToCelsius();
        convertCelsiusToFahrenheit();

    }

    public void setCelsius(double celsius)  throws TemperatureException
    {
        if(celsius < LOWEST_CELSIUS_TEMP)
        {
            throw new TemperatureException("Invalid Celsius Temp (must be >=" + LOWEST_CELSIUS_TEMP+ ")" );
        }

        this.celsius = celsius;
        convertCelsiusToKelvin();
        convertCelsiusToFahrenheit();
    }



    public void setFahrenheit(double fahrenheit)throws TemperatureException
    {
        if(fahrenheit < LOWEST_FAHRENHEIT_TEMP)
        {
            throw new TemperatureException("Invalid fahrenheit Temp (must be >=" + LOWEST_FAHRENHEIT_TEMP+ ")" );
        }

        this.fahrenheit = fahrenheit;
        convertFahrenheitToCelsius();
        convertCelsiusToKelvin();

    }


    public double getKelvin() {
        return kelvin;
    }

    public double getCelsius() {
        return celsius;
    }

    public double getFahrenheit() {
        return fahrenheit;
    }



    @Override
    public String toString() {
        return "Temperature{" +
                "kelvin=" + kelvin +
                ", celsius=" + celsius +
                ", fahrenheit=" + fahrenheit +
                '}';
    }


    private void convertKelvinToCelsius()
    {
        celsius = kelvin + LOWEST_CELSIUS_TEMP;
    }


    private void convertFahrenheitToCelsius()
    {

        celsius = (fahrenheit -32) * 5.0 /9.0;

    }

    private void convertCelsiusToKelvin()
    {
        kelvin = celsius - LOWEST_CELSIUS_TEMP;

    }

    private void convertCelsiusToFahrenheit()
    {

        fahrenheit = celsius * 9.0 / 5.0 + 32.0;

    }



}
