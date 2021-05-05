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

    @Test(description = "TC04 - Contact Email contains correct href value which can help to quickly open Outlook Compose Message dialog")
    public void TC04() {
        LoggerHelper.startTestCase("TC04 - Contact Email contains correct href value which can help to quickly open Outlook Compose Message dialog");
        String contactEmail = "mailto:thanh.viet.le@logigear.com";
        homePage.goToContactPage();

        String actualEmailHref = contactPage.getEmailHref();
        Assert.assertEquals(actualEmailHref, contactEmail,"{} href should be appeared".format(contactEmail));
    }
}
