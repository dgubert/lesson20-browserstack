package tests;

import io.qameta.allure.Owner;
import org.aeonbits.owner.Config;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import screens.ArticleScreen;
import screens.SearchScreen;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.id;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

@Owner("Denis Gubert")
public class SearchTests extends BaseTest {

    @ParameterizedTest(name = "Проверка наличия результатов по запросу {0}")
    @ValueSource( strings = {"Appium", "Selenide", "Owner"})
    void successfulSearchTest(String value) {
        SearchScreen.searchResults(value);

        SearchScreen.verifyResultsFound();
    }

    @Test
    @DisplayName("Проверка первой статьи по поиску Marathonbet")
    @Tag("android")
    void successfulSearch2Test() {
        SearchScreen.searchResults("Marathonbet");

        SearchScreen.clickFirstResult();

        ArticleScreen.verifyErrorMessage();
    }
}