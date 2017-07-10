import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class TablePage {

    @BeforeClass
    public static void openingPage(){
        MainClass.testSettingUPChrome();
    }

    @Test
    public void usingTheTable(){
        MainClass.openingLink();
        MainClass.checkingTable();
    }

    @AfterClass
    // Closing Browser when finish the test
    public static void tearDown() {
        //driver.quit();
    }
}



