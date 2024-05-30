package com.automation.tests.navbar;

import org.testng.annotations.Test;

import com.automation.pages.HomePage;
import com.automation.pages.VaultStudyStartupPage;
import com.automation.tests.BaseSystemCase;
import static org.assertj.core.api.Assertions.assertThat;

public class UserCanNavigateToClinicalStudyStartupIT extends BaseSystemCase {
    
        @Test
        public void testCase() {
            HomePage homePage = goToVeevaSite();
            VaultStudyStartupPage vaultStudyStartup = homePage.navbar
                                                        .hoverProducts()
                                                        .clickOnClinicalVaultStudyStartup();

            assertThat(vaultStudyStartup.getHeroSectionCopy()).isEqualTo("Veeva Vault Study Startup");
        }

}