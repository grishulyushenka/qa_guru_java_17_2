package github;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SoftAssertionsPageSearch {

    @Test
    void softAssertionsContainsJUnit5(){
        //откройте страницу Selenide  в Github
        open("https://github.com/selenide/selenide");
        //перейдите в раздел Wiki Проекта
        $("#wiki-tab").click();
        //Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
        $(".filter-bar #wiki-pages-filter").setValue("softassertions").pressEnter();
        $("#wiki-pages-box").shouldHave(text("SoftAssertions"));
        //откройте страницу SoftAssertions,
        //$("#wiki-pages-box").$(byText("SoftAssertions")).click();
        $(byText("SoftAssertions")).click();
        //проверьте,что внутри есть пример кода для JUnit5
        $("#wiki-body").shouldHave(text("Using JUnit5 extend test class"));
    }
}
