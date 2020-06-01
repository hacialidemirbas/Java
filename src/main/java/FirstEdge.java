package main.java;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirstEdge {
    public static void main(String[] args) {
               WebDriver edgeDriver= new EdgeDriver();
               edgeDriver.get("https://samanyoluhaber.com");
        System.out.println("driver location is of edge : "+System.getProperty("webdriver.edge.driver"));

    }
}
