import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class MainClass {
    public static By TABLE_LINK = By.cssSelector("a[title='Automation Practice Table']");
    private static WebDriver driver;
    private static String toolsURL = "http://toolsqa.com/automation-practice-form/";
    private static String tableURL = "http://toolsqa.com/automation-practice-table/";

    public static void testSettingUPChrome() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/Less/Dropbox/automated testing/Clase de hoy/junitclass/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        //Disable barInfo
        options.addArguments("disable-infobars");
        driver = new ChromeDriver(options);
        //Open page
        driver.navigate().to(toolsURL);
    }

    public static void openingLink() {
        //Clicking the right link
        WebElement table_link = driver.findElement(TABLE_LINK);
        table_link.click();
        //make TRY for error
        try {
            String currentURL = driver.getCurrentUrl();
            Assert.assertEquals(tableURL, currentURL);
        } catch (Exception e) {
            System.out.println("Failed to catch the table");
        }
    }

    public static void checkingTable() {
        By TABLE_FILES = By.cssSelector("tbody tr");
        By CHINA_FILE = By.cssSelector("tr:nth-child(4) td:nth-child(4)");
        By TAIWAN_FILE = By.cssSelector("tr:nth-child(3) td:nth-child(2)");
        //Count files
        int files_number = driver.findElements(TABLE_FILES).size();
        Assert.assertEquals(files_number, 4);
        //Check China
        WebElement chinaTD = driver.findElement(CHINA_FILE);
        String chinaHeight = chinaTD.getText();
        Assert.assertEquals(chinaHeight, "492m");
        //Check Taiwan
        WebElement taiwanTD = driver.findElement(TAIWAN_FILE);
        String taiwanRank = taiwanTD.getText();
        Assert.assertNotEquals(taiwanRank, "2");
        //Returning to the main page
        driver.navigate().back();
        //Look if we are in the right page
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(toolsURL, currentURL);
    }

    public static void createUser(String name, String lastName, String date, String photoLink) {
        By NAME_INPUT = By.cssSelector("input[name=firstname]");
        By LASTNAME_INPUT = By.cssSelector("input[name=lastname]");
        By FEM_GENDER = By.cssSelector("input[id=sex-1]");
        By EXP_YEARS = By.cssSelector("input[id=exp-5]");
        By DATE_INPUT = By.cssSelector("input[id=datepicker]");
        By JOB_PICK = By.cssSelector("input[id=profession-1]");
        By PHOTO_BUTTON = By.cssSelector("input[id=photo]");
        //Naming user
        driver.findElement(NAME_INPUT).sendKeys(name);
        driver.findElement(LASTNAME_INPUT).sendKeys(lastName);
        //Picking gender
        driver.findElement(FEM_GENDER).click();
        //Picking years of experience
        driver.findElement(EXP_YEARS).click();
        //Pick date
        driver.findElement(DATE_INPUT).sendKeys(date);
        //Check job
        driver.findElement(JOB_PICK).click();
        //Upload picture
        driver.findElement(PHOTO_BUTTON).sendKeys(photoLink);
    }

    public static void tecnicalInfo() {
        By DOWNLOAD_LINK = By.cssSelector("a[href$=xlsx]");
        By AT_TOOL_SWEBDRIVER = By.cssSelector("input[id=tool-2]");
        By SELECT_CONTINENT = By.cssSelector("select[id=continents]");
        By SELECT_SCOMMAND = By.cssSelector("select[id=selenium_commands]");
        By SUBMIT_BUTTON = By.cssSelector("button[id=submit]");
        //Click link to download
        driver.findElement(DOWNLOAD_LINK).click();
        //Pick automation tool
        driver.findElement(AT_TOOL_SWEBDRIVER).click();
        //Choose continent
        Select pickContinent = new Select(driver.findElement(SELECT_CONTINENT));
        pickContinent.selectByIndex(6);
        //Select Selenium commands
        Select pickCommand = new Select(driver.findElement(SELECT_SCOMMAND));
        pickCommand.selectByIndex(4);
        //Submit
        driver.findElement(SUBMIT_BUTTON).click();

    }

}
