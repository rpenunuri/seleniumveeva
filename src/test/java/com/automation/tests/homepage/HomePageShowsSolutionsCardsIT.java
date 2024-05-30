package com.automation.tests.homepage;
import com.automation.pages.HomePage;
import com.automation.tests.BaseSystemCase;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;


public class HomePageShowsSolutionsCardsIT extends BaseSystemCase {

    @Test
    public void testCase() {
        HomePage homePage = goToVeevaSite();
        assertThat(homePage.getAmountOfImpactCards()).isEqualTo(4);
        assertThat(homePage.getAmountOfOurSolutionsCards()).isEqualTo(6);
    }
}
