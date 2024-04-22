package stepDefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class MyStepdefsBasketball {

    private WebDriver driver;

    @Given("User is on the create a supporter account page")
    public void userIsOnTheCreateASupporterAccountPage() {
        driver = new ChromeDriver();
        driver.get("https://membership.basketballengland.co.uk/NewSupporterAccount");
    }

    @When("User fills in all the necessary information")
    public void userFillsInAllTheNecessaryInformation() {
        driver.findElement(By.id("dp")).sendKeys("20/08/2004");
        driver.findElement(By.id("member_firstname")).sendKeys("Petar");
        driver.findElement(By.id("member_lastname")).sendKeys("Bukovski");
        driver.findElement(By.id("member_emailaddress")).sendKeys("wamesi1722@em2lab.com");
        driver.findElement(By.id("member_confirmemailaddress")).sendKeys("wamesi1722@em2lab.com");
        driver.findElement(By.id("signupunlicenced_password")).sendKeys("Mjukvarutest345");
        driver.findElement(By.id("signupunlicenced_confirmpassword")).sendKeys("Mjukvarutest345");
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div/div/div/div/div/form/div[10]/div/div/div[4]/div/label/span[3]")).click();
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div/div/div/div/div/form/div[11]/div/div[2]/div[1]/label/span[3]")).click();
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div/div/div/div/div/form/div[11]/div/div[2]/div[2]/label/span[3]")).click();
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div/div/div/div/div/form/div[11]/div/div[7]/label/span[3]")).click();
    }

    @And("User clicks on the confirm and join button")
    public void userClicksOnTheConfirmAndJoinButton() {
        driver.findElement(By.name("join")).click();
    }

    @Then("An account is created")
    public void anAccountIsCreated() {
        boolean actual = driver.findElement(By.xpath("/html/body/div/div[2]/div/h2")).isDisplayed();
        boolean expected = true;
        assertEquals(expected, actual);
    }

    @When("User fills in all the necessary information but not the last name")
    public void userFillsInAllTheNecessaryInformationButNotTheLastName() {
        driver.findElement(By.id("dp")).sendKeys("20/08/2004");
        driver.findElement(By.id("member_firstname")).sendKeys("Petar");
        driver.findElement(By.id("member_emailaddress")).sendKeys("wamesi1722@em2lab.com");
        driver.findElement(By.id("member_confirmemailaddress")).sendKeys("wamesi1722@em2lab.com");
        driver.findElement(By.id("signupunlicenced_password")).sendKeys("Mjukvarutest345");
        driver.findElement(By.id("signupunlicenced_confirmpassword")).sendKeys("Mjukvarutest345");
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div/div/div/div/div/form/div[10]/div/div/div[4]/div/label/span[3]")).click();
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div/div/div/div/div/form/div[11]/div/div[2]/div[1]/label/span[3]")).click();
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div/div/div/div/div/form/div[11]/div/div[2]/div[2]/label/span[3]")).click();
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div/div/div/div/div/form/div[11]/div/div[7]/label/span[3]")).click();
    }

    @Then("User should recive an error that last name is missing")
    public void userShouldReciveAnErrorThatLastNameIsMissing() {
        String expected = "Last Name is required";
        String actual = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div/div/div/div/div/form/div[5]/div[2]/div/span/span")).getText();
        assertEquals(expected, actual );
    }

    @When("User fills in all the necessary information but the passwords dont match")
    public void userFillsInAllTheNecessaryInformationButThePasswordsDontMatch() {
        driver.findElement(By.id("dp")).sendKeys("20/08/2004");
        driver.findElement(By.id("member_firstname")).sendKeys("Petar");
        driver.findElement(By.id("member_lastname")).sendKeys("Bukovski");
        driver.findElement(By.id("member_emailaddress")).sendKeys("wamesi1722@em2lab.com");
        driver.findElement(By.id("member_confirmemailaddress")).sendKeys("wamesi1722@em2lab.com");
        driver.findElement(By.id("signupunlicenced_password")).sendKeys("Mjukvarutest3456");
        driver.findElement(By.id("signupunlicenced_confirmpassword")).sendKeys("Mjukvarutest345");
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div/div/div/div/div/form/div[10]/div/div/div[4]/div/label/span[3]")).click();
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div/div/div/div/div/form/div[11]/div/div[2]/div[1]/label/span[3]")).click();
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div/div/div/div/div/form/div[11]/div/div[2]/div[2]/label/span[3]")).click();
        driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div/div/div/div/div/form/div[11]/div/div[7]/label/span[3]")).click();
    }

    @Then("User should recive an error that the passwords are not matching")
    public void userShouldReciveAnErrorThatThePasswordsAreNotMatching() {
        String expected = "Password did not match";
        String actual = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div/div/div/div/div/form/div[8]/div/div[2]/div[2]/div/span/span")).getText();
        assertEquals(expected, actual );
    }

    @But("User does not accept terms and conditions")
    public void userDoesNotAcceptTermsAndConditions() {
        WebElement termsAndConditions = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div/div/div/div/div/form/div[11]/div/div[2]/div[1]/label/span[3]"));
        termsAndConditions.click();
    }

    @Then("User should recive an error that the terms and conditions must be accepted")
    public void userShouldReciveAnErrorThatTheTermsAndConditionsMustBeAccepted() {
        String expected = "You must confirm that you have read and accepted our Terms and Conditions";
        String actual = driver.findElement(By.xpath("/html/body/div/div[2]/div/div/div/div/div/div/div/form/div[11]/div/div[2]/div[1]/span/span")).getText();
        assertEquals(expected, actual );
    }
}
