package com.automation.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.automation.commons.BaseWebPageEntity;
import com.automation.components.Navbar;

public class HomePage extends BaseWebPageEntity {

    public Navbar navbar;

    @FindBy(css = "div.impact-card")
    private List<WebElement> impactCards;

    @FindBy(css = "a.icon-card")
    private List<WebElement> ourSolutionsCards;

    @Override
    protected ExpectedCondition<Boolean> readyCondition() {
        return ExpectedConditions.titleContains("Veeva Systems");
    }

    public HomePage(WebDriver webDriver) {
        super(webDriver);
        this.navbar = new Navbar(webDriver);
    }

    public int getAmountOfImpactCards() {
        return getNumberOfElements(impactCards);
    }

    public int getAmountOfOurSolutionsCards() {
        return getNumberOfElements(ourSolutionsCards);
    }
}
