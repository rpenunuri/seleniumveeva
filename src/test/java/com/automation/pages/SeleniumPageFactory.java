package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class SeleniumPageFactory extends PageFactory {
    private final WebDriver _webDriver;


    public SeleniumPageFactory(WebDriver webDriver) {
        _webDriver = webDriver;
    }

    public HomePage veevaHome() {
        return initElements(_webDriver, HomePage.class);
    }

    public VaultStudyStartupPage vaultStudyStartup() {
        return initElements(_webDriver, VaultStudyStartupPage.class);
    }
}
