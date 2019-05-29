package domain;

import domain.TemperatureException;
import domain.Temperature;
import org.junit.*;



public class TestTemperature
{


    @Test
    public void TestTemperatureConstructor()
    {
        try
        {
            Temperature  temp1 =  new Temperature();
            Assert.assertNotNull(temp1);
        }
        catch(TemperatureException tex)
        {
            Assert.assertTrue(false);
        }

    }


    @Test
    public void TestTemperatureKelvin()
    {

        try
        {
            Temperature  temp1 =  new Temperature();
            Assert.assertEquals(0.0,temp1.getKelvin(),.001);
        }
        catch(TemperatureException tex)
        {
            Assert.assertTrue(false);
        }

    }

    @Test
    public void TestTemperatureCelcius()
    {

        try
        {
            Temperature  temp1 =  new Temperature();
            Assert.assertEquals(-273.15,temp1.getCelsius(),.001);
        }
        catch(TemperatureException tex)
        {
            Assert.assertTrue(false);
        }

    }

    @Test
    public void TestTemperatureFahrenheit()
    {

        try
        {
            Temperature  temp1 =  new Temperature();
            Assert.assertEquals(-459.67,temp1.getFahrenheit(),.001);
        }
        catch(TemperatureException tex)
        {
            Assert.assertTrue(false);
        }

    }


//    @Test
//    public void TestTemperatureKelvinToCelsius()
//    {
//        try
//        {
//            Temperature  temp1 =  new Temperature();
//            Assert.assertEquals(-273.15,temp1.getCelsius(),.001);
//        }
//        catch(TemperatureException tex)
//        {
//            Assert.assertTrue(false);
//        }
//
//
//    }






}


