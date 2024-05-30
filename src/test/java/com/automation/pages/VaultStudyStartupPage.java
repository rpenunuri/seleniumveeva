package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.automation.commons.BaseWebPageEntity;

public class VaultStudyStartupPage extends BaseWebPageEntity {

    @FindBy(css = "section.hero-left-aligned div.copy-container h2")
    private WebElement heroSectionCopy;

    @Override
    protected ExpectedCondition<Boolean> readyCondition() {
        return ExpectedConditions.titleContains("Vault Study Startup");
    }

    public VaultStudyStartupPage(WebDriver webDriver) {
        super(webDriver);
    }

    public String getHeroSectionCopy() {
        return getText(heroSectionCopy);
    }
}
