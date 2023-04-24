package tests;

import org.testng.annotations.Test;
import utils.DriverWeb;

public class testdene {
    @Test
    public void test(){
      DriverWeb.getDriver().get("https://www.google.com");
    }
}
