package screens;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.accessibilityId;
import static io.appium.java_client.AppiumBy.id;
import static org.assertj.core.api.Assertions.assertThat;

public class SearchScreen {

    @Step("Поиск '{0}' в Wikipedia")
    public static void searchResults(String str) {
        $(accessibilityId("Search Wikipedia")).click();
        $(id("org.wikipedia.alpha:id/search_src_text")).sendKeys(str);
    }

    @Step("Переходим по первой ссылке из списка результатов поиска")
    public static void clickFirstResult() {
        $(id("org.wikipedia.alpha:id/page_list_item_title")).click();
    }

    @Step("Проверяем наличие результатов поиска")
    public static void verifyResultsFound() {
        assertThat($$(id("org.wikipedia.alpha:id/page_list_item_title"))).hasSizeGreaterThan(0);
    }
}