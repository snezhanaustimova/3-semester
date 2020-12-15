/* GISMETEO, снова JSOUP
тут у меня возникли небольшие проблемы с извлечением данных,
но на 2 параметра, как указано в задании, хватило
*/

package example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Weather3 {

    public void weatherFromSite() throws InterruptedException {
        Document doc=
                null;
        try {
            doc = Jsoup.connect("https://www.gismeteo.ru/weather-moscow-4368/").get();
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }

        Elements temp_line=doc.select("span [class=js_value tab-weather__value_l]");
        Elements feelstemp_line=doc.select("span [class=unit unit_temperature_c]");

        Element curr_temp = temp_line.get(0);
        Element feels_temp = feelstemp_line.get(0);
        System.out.println("Совершается запрос к GISMETEO...");
        TimeUnit.SECONDS.sleep(3); // делаем небольшую задержку
        System.out.println("Текущая температура: " + curr_temp.text() + "°");
        System.out.println("Ощущается как: " + feels_temp.text() + "°");
    }
}
