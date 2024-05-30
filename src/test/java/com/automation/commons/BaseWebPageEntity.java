package com.automation.commons;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import com.automation.pages.SeleniumPageFactory;

public abstract class BaseWebPageEntity {
    private final WebDriver webDriver;
    private final SeleniumPageFactory seleniumPageFactory;
    private static final long DEFAULT_TIMEOUT_IN_SECONDS = 10;
    private static final long DEFAULT_SLEEP_TIME_IN_SECONDS = 1;
    private Actions actions;

    protected abstract ExpectedCondition<?> readyCondition();

    protected BaseWebPageEntity(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.seleniumPageFactory = new SeleniumPageFactory(webDriver);
        waitUntil(readyCondition());
    }

    protected void click(WebElement element) {
        waitUntil(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    protected void mouseOver(WebElement element) {
        waitUntil(ExpectedConditions.visibilityOf(element));
        actions = new Actions(webDriver);
        actions.moveToElement(element).perform();
    }

    protected String getText(WebElement element) {
        waitUntil(ExpectedConditions.visibilityOf(element));
        return element.getText();
    }

    protected int getNumberOfElements(List<WebElement> webElements) {
        waitUntil(ExpectedConditions.visibilityOfAllElements(webElements));
        return webElements.size();
    }

    protected SeleniumPageFactory page() {
        return seleniumPageFactory;
    }

    protected void waitUntil(ExpectedCondition<?> expectedCondition) {
        new FluentWait<>(webDriver)
                .withTimeout(Duration.ofSeconds(DEFAULT_TIMEOUT_IN_SECONDS))
                .pollingEvery(Duration.ofSeconds(DEFAULT_SLEEP_TIME_IN_SECONDS))
                .ignoring(NoSuchElementException.class)
                .until(expectedCondition);
    }

    protected Boolean is(ExpectedCondition<Boolean> expectedCondition) {
        return (Boolean) expectedCondition.apply(webDriver);
    }
}
