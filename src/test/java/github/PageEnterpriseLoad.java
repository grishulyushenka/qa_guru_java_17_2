package github;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class PageEnterpriseLoad {

    @Test
    void openEnterprisePageFromSolutionsMenu(){
        //откройте страницу Selenide  в Github
        open("https://github.com");

        //выберите меню Solutions -> Enterprise с помощью команды hover для Solutions
        $$("nav ul li").findBy(text("Solutions")).hover();
        $$(".HeaderMenu-item .HeaderMenu-dropdown-link").findBy(visible)
                .shouldHave(text("Enterprise")).click();
        //убедитесь что загрузилась нужная страница
        $("div h1").shouldHave(text("Build like the best"));

    }
}
