package com.logigear;

import com.sun.org.glassfish.gmbal.Description;
import helper.Constant;
import helper.LoggerHelper;
import models.Account;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.ContactPage;
import page_objects.HomePage;

public class ContactTest extends BaseTest {

    private final HomePage homePage = new HomePage();
    private final ContactPage contactPage = new ContactPage();

    @Description("TC04 - Contact Email contains correct href value which can help to quickly open Outlook Compose Message dialog")
    @Test
    public void TC04() {
        LoggerHelper.startTestCase("TC04 - Contact Email contains correct href value which can help to quickly open Outlook Compose Message dialog");

        LoggerHelper.info("[STEP-1] - Click on contact tab");
        homePage.goToContactPage();

        LoggerHelper.info("[STEP-2] - Assert address email");
        String actualMsg = contactPage.getEmail();
        String expectedMsg = Constant.CONTACT_EMAIL;
        Assert.assertEquals(actualMsg, expectedMsg);
    }
}
