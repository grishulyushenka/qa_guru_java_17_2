package selenide;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDrop {

    @Test
    void actionsDragAndDrop(){
        //откройте страницу Selenide  в Github
        open("https://the-internet.herokuapp.com/drag_and_drop");

        //Перенесите прямоугольник А на место В
        actions().moveToElement($("div#column-a")).clickAndHold().moveToElement($("div#column-b"))
                .release().perform();

        //Проверьте, что прямоугольники действительно поменялись
        $("#column-a header").shouldHave(text("B"));
        $("#column-b header").shouldHave(text("A"));

    }

    @Test
    void selenideDragAndDrop(){
        //откройте страницу Selenide  в Github
        open("https://the-internet.herokuapp.com/drag_and_drop");

        //В Selenide есть команда $(element).dragAndDrop($(to-element)),
        // проверьте работает ли тест, если использовать её вместо actions()
        $("#column-a").dragAndDropTo($("#column-b"));

        //Проверьте, что прямоугольники действительно поменялись
        $("#column-a header").shouldHave(text("B"));
        $("#column-b header").shouldHave(text("A"));

    }
}
