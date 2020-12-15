// чтобы было разнообразнее, в этот раз решила использовать JSON
// a68c08664481ac7d0c5293daec0c6cc3 - мой API
// сервер - OpenWeatherMap

package example;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.json.JSONObject;

public class Weather2 {

    void initialize () throws InterruptedException {
        String output = getUrlContent("http://api.openweathermap.org/data/2.5/weather?q=Moscow&appid=a68c08664481ac7d0c5293daec0c6cc3&units=metric");

        if (!output.isEmpty()) { // обработчик ошибок на праивльность введенного города
            JSONObject obj = new JSONObject(output);
            // обработка данных и вывод
            System.out.println("Совершается запрос к OpenWeatherMap...");
            TimeUnit.SECONDS.sleep(3); // делаем небольшую задержку
            System.out.println("Текущая температура: " + obj.getJSONObject("main").getDouble("temp") + "°");
            System.out.println("Ощущается как: " + obj.getJSONObject("main").getDouble("feels_like") + "°");
            System.out.println("Макс. температура: " + obj.getJSONObject("main").getDouble("temp_max") + "°");
            System.out.println("Мин. температура: " + obj.getJSONObject("main").getDouble("temp_min") + "°");
            System.out.println("Давление: " + obj.getJSONObject("main").getDouble("pressure") + " hPa");
            System.out.println("Влажность воздуха: " + obj.getJSONObject("main").getDouble("humidity") + "%");
            System.out.println("Скорость ветра: " + obj.getJSONObject("wind").getDouble("speed") + " м/с");
        }
    }

    private static String getUrlContent(String urlAdress) {
        StringBuffer content = new StringBuffer();

        try {
            URL url = new URL(urlAdress);
            URLConnection urlConn = url.openConnection();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                content.append(line + "\n");
            }
            bufferedReader.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return content.toString();
    }
}