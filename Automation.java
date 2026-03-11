
package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Automation {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //Open Website
        driver.get("https://automationexercise.com/");
        Thread.sleep(2000);

        //Click Login
        driver.findElement(By.xpath("//a[@href='/login']")).click();
        Thread.sleep(2000);

        //Enter value
        driver.findElement(By.xpath("//input[@data-qa='login-email']"))
                .sendKeys("savyatapandey1@gmail.com");

        driver.findElement(By.xpath("//input[@data-qa='login-password']"))
                .sendKeys("Savyata321");

        driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();
        Thread.sleep(3000);

        System.out.println("Login Successful");

        //Navigate to Product
        driver.findElement(By.xpath("//a[@href='/products']")).click();
        Thread.sleep(3000);

        //Add to Cart
        driver.findElement(By.xpath("(//a[@class='btn btn-default add-to-cart'])[1]")).click();
        Thread.sleep(2000);

        //Click view cart
        driver.findElement(By.xpath("//u[text()='View Cart']")).click();
        Thread.sleep(2000);

        //Verify Product is Visible
        boolean productVisible = driver.findElement(By.xpath("//td[@class='cart_description']")).isDisplayed();

        if(productVisible){
            System.out.println("Product successfully added to cart");
        }

        //Proceed to Checkout
        driver.findElement(By.xpath("//a[contains(text(),'Proceed To Checkout')]")).click();
        Thread.sleep(3000);

        //Verify Checkout Page
        boolean checkoutPage = driver.findElement(By.xpath("//h2[contains(text(),'Address Details')]")).isDisplayed();

        if(checkoutPage){
            System.out.println("Checkout Page Loaded Successfully");
        }

        driver.quit();
    }
}


