package com.automation.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.automation.commons.BaseWebPageEntity;
import com.automation.pages.VaultStudyStartupPage;

public class Navbar extends BaseWebPageEntity {
    @FindBy(id = "nav-section-products")
    WebElement products;

    @FindBy(id = "cta-topNav-products-clinical-study-startup")
    WebElement productClinicalVaultStudyStartup;

    public Navbar(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    @Override
    protected ExpectedCondition<WebElement> readyCondition() {
        return ExpectedConditions
            .visibilityOfElementLocated(By.cssSelector("#nav-section-products"));
    }

    public Navbar hoverProducts() {
        mouseOver(products);
        return this;
    }

    public VaultStudyStartupPage clickOnClinicalVaultStudyStartup() {
        click(productClinicalVaultStudyStartup);
        return page().vaultStudyStartup();
    }
}
