package test;

import org.testng.annotations.Test;
import page.CommonPage;
import utilities.Utility;

public class CommonTest extends BaseWebTest {

    @Test
    public void testSwitching() {
        CommonPage commonPage = new CommonPage(driver, explicitWait);

        commonPage.openNewTab();
        commonPage.switchWindow(1);
        commonPage.openUrl("https://facebook.com");
        commonPage.openNewWindow();
        commonPage.switchWindow(2);
        commonPage.openUrl("https://twitter.com");
        commonPage.switchWindow(0);
    }

    @Test
    public void testJavaScript() {
        CommonPage commonPage = new CommonPage(driver, explicitWait);
        String alertScript = "alert('beware of alert')";
        commonPage.runJavaScriptCommand(alertScript);
        Utility.hardWait(2);
        commonPage.acceptALert();
        Utility.hardWait(2);
    }
}
