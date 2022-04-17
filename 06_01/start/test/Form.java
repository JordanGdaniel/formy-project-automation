import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertEquals;

public class Form {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\jorda\\Selenium Drivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://formy-project.herokuapp.com/form");

        WebElement firstName = driver.findElement(By.id("first-name"));
        firstName.sendKeys("Jordan");

        WebElement lastName = driver.findElement(By.id("last-name"));
        lastName.sendKeys("Daniel");

        WebElement jobTitle = driver.findElement(By.id("job-title"));
        jobTitle.sendKeys("Manager");

        WebElement educationLevel = driver.findElement(By.id("radio-button-3"));
        educationLevel.click();

        WebElement sex = driver.findElement(By.id("checkbox-1"));
        sex.click();

        WebElement yearsOfExperience = driver.findElement(By.cssSelector("option[value='4']"));
        yearsOfExperience.click();

        WebElement dateField = driver.findElement(By.id("datepicker"));
        dateField.sendKeys("04/15/2022");
        driver.findElement(By.id("datepicker")).sendKeys(Keys.RETURN);

        WebElement submitButton = driver.findElement(By.cssSelector(".btn.btn-lg.btn-primary"));
        submitButton.click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement alert = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("alert")));

        String alertTex = alert.getText();

        assertEquals("The form was successfully submitted!", alertTex);


        driver.quit();
    }
}
