// ЯНДЕКС ПОГОДА
// для парсинга была использована библиотека JSOUP

package example;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Weather1 {

    private static String URL;

    public Weather1 (String URL) {
        this.URL = URL;
    }

    public void weatherFromSite() throws IOException, InterruptedException {

        Document doc = Jsoup.connect(getWeather()).get();

        Elements currTemp = doc
                .select("div.temp.fact__temp.fact__temp_size_s"); // текущая температура
        Elements feelsTemp = doc
                .select("div.link__feelings.fact__feelings"); // ощущается как
        Elements clouds = doc
                .select("div.link__condition.day-anchor.i-bem"); // облачность
        Elements weatherElements = doc.select("div.term__value"); // влажность, давление и т.д

        String cloudy = clouds.text().trim();
        int currTempJSOUP = currTemp.text().lastIndexOf("а");
        int currTempJSOUP_Char = currTemp.text()
                .lastIndexOf("°"); // поиск последнего символа "°"
        int feelsTempJSOUP = feelsTemp.text().lastIndexOf(" "); // поиск последнего пробела
        int feelsTempJSOUP_Char = feelsTemp.text()
                .lastIndexOf("°"); // аналогично

        String currentTemperature = currTemp.text().substring(currTempJSOUP + 1,
                currTempJSOUP_Char + 1); // собираем
        String feelsTemperature = feelsTemp.text()
                .substring(feelsTempJSOUP + 1, feelsTempJSOUP_Char + 1);

        String[] otherCharacteristic = weatherElements.text().split(" ");

        System.out.println("Совершается запрос к ЯндексПогоде...");
        TimeUnit.SECONDS.sleep(3); // делаем небольшую задержку
        System.out.println("Текущая температура: "
                + currentTemperature + "\n"
                + "Ощущается как: "  + feelsTemperature + "\n"
                + cloudy + "\n"
                + "Скорость ветра: " + otherCharacteristic[2] + " (м/с)" + "\n"
                + "Направление: " + otherCharacteristic[4] + "\n"
                + "Влажность воздуха: " + otherCharacteristic[5] + "\n"
                + "Давление: " + otherCharacteristic[6] + " мм ртутного столба");
    }

    public String getWeather() {
        return URL;
    }
}