/*
 * COPYRIGHT. HSBC HOLDINGS PLC 2018. ALL RIGHTS RESERVED.
 *
 * This software is only to be used for the purpose for which it has been
 * provided. No part of it is to be reproduced, disassembled, transmitted,
 * stored in a retrieval system nor translated in any human or computer
 * language in any way or for any other purposes whatsoever without the
 * prior written consent of HSBC Holdings plc.
 */

import browsers.BrowserFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumTest {

    private WebDriver driver;
    private String githubTestUrl = "https://github.com/";
    private String wordpressBaseUrl = "http://joomla/";
    private String title = "GitHub";

//    @Test
//    public void testGithubChrome() throws Exception {
//        driver = BrowserFactory.getRemoteBrowser("chrome", true);
//        driver.get(githubTestUrl);
//        githubLogoTest();
//    }

//    @Test
//    public void testGithubFirefox() throws Exception {
//        driver = BrowserFactory.getRemoteBrowser("firefox", true);
//        driver.get(githubTestUrl);
//        githubLogoTest();
//    }

    @Test
    public void testJoomlaChrome() throws Exception {
        driver = BrowserFactory.getRemoteBrowser("chrome", false);
        driver.get(wordpressBaseUrl);
        joomlaTitleTest();
    }

    @Test
    public void testJoomlaFirefox() throws Exception {
        driver = BrowserFactory.getRemoteBrowser("firefox", false);
        driver.get(wordpressBaseUrl);
        joomlaTitleTest();
    }

    public void githubLogoTest() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.className("octicon-mark-github")));
        Assert.assertEquals(title, driver.getTitle());
    }

    public void joomlaTitleTest() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.className("site-title")));
        Assert.assertEquals("Docker Jlabs Training", driver.findElement(By.className("site-title")).getText());
    }

    @After
    public void quit() {
        driver.quit();
    }
}
