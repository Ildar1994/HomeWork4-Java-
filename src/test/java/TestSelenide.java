import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TestSelenide {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
    }


    @Test
    void proverkaSelenide() {

        //открыть сайт
        open("https://github.com/selenide/selenide");

        // - Перейдите в раздел Wiki проекта
        $("#wiki-tab").click();


        $("#wiki-pages-filter").setValue("SoftAssertions").pressEnter();
        $("a[href='/selenide/selenide/wiki/SoftAssertions']").click();


        $("#wiki-body").shouldHave(text(
                "@Listeners({ SoftAsserts.class})\n" +
                        "public class Tests {\n" +
                        "  @Test\n" +
                        "  public void test() {\n" +
                        "    Configuration.assertionMode = SOFT;\n" +
                        "    open(\"page.html\");\n" +
                        "\n" +
                        "    $(\"#first\").should(visible).click();\n" +
                        "    $(\"#second\").should(visible).click();\n" +
                        "  }\n" +
                        "}"));








    }
}







