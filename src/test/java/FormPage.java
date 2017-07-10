import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class FormPage {
    @BeforeClass
    public static void openingPage(){
        MainClass.testSettingUPChrome();
    }

    @Test
    public void fillTheForm(){
        String name = "Monica";
        String lastName = "Ovando";
        String date = "24/06/1990";
        String photoLink = "C:/Users/Less/Dropbox/automated testing/Clase de hoy/junitclass/CX44_9vUAAAIQ_X.png";
        MainClass.createUser(name, lastName, date, photoLink);
        MainClass.tecnicalInfo();
    }

    @AfterClass
    // Closing Browser when finish the test
    public static void tearDown() {
        //driver.quit();
    }
}
