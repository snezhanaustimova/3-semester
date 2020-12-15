package example;

import java.io.*;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main {

    private static final String YANDEX_WEATHER = "https://yandex.ru/pogoda/213";

    public static void main(String[] args) throws IOException, InterruptedException {


        File file = new File("settings.txt");
        System.out.println(file.getCanonicalPath() + " существует файл? " + file.exists());
        BufferedReader br = null;

        try {
            if (file.exists()) {

                br = new BufferedReader(new FileReader("settings.txt"));
                String line;
                int userLastChoice = (char) br.read() - '0';
                System.out.println(userLastChoice);
                br.close();

                if (userLastChoice == 1) {
                    Weather1 weatherMSK1 = new Weather1(YANDEX_WEATHER);
                    weatherMSK1.weatherFromSite();
                } else if (userLastChoice == 2) {
                    Weather2 weatherMSK2 = new Weather2();
                    weatherMSK2.initialize();
                } else if (userLastChoice == 3) {
                    Weather3 weatherMSK3 = new Weather3();
                    weatherMSK3.weatherFromSite();
                }

                System.out.println("Использовать другой ресурс?(1 - YES, 2 - NO)");

                Scanner in = new Scanner(System.in);
                int change;
                do {
                    while (!in.hasNextInt()) {
                        System.out.println("Это не число");
                        in.next();
                    }
                    change = in.nextInt();
                } while (change != 1 && change != 2);

                if (change == 1) {
                    System.out.println("\nВыберите ресурс для предоставления информации о погоде:" + "\n" +
                            "1 - сервис ЯндексПогода;" + "\n" +
                            "2 - сервис OpenWeatherMap;" + "\n" +
                            "3 - сервис Gismeteo.");
                    in = new Scanner(System.in);
                    int number;
                    do {
                        System.out.println("Введите число от 1 до 3.");
                        while (!in.hasNextInt()) {
                            System.out.println("Это не число");
                            in.next();
                        }
                        number = in.nextInt();
                    } while (number != 1 && number != 2 && number != 3);

                    if (number == 1) {
                        Weather1 weatherMSK1 = new Weather1(YANDEX_WEATHER);
                        weatherMSK1.weatherFromSite();
                    } else if (number == 2) {
                        Weather2 weatherMSK2 = new Weather2();
                        weatherMSK2.initialize();
                    } else if (number == 3) {
                        Weather3 weatherMSK3 = new Weather3();
                        weatherMSK3.weatherFromSite();
                    }

                    file.createNewFile();
                    PrintWriter pw = new PrintWriter(file);
                    pw.println(number);
                    pw.close();
                }

            } else {

                System.out.println("Здравствуйте, Вас приветствует сервис");
                System.out.println("-------ПРОГНОЗ ПОГОДЫ В МОСКВЕ-------");
                System.out.println("\nВыберите ресурс для предоставления информации о погоде:" + "\n" +
                        "1 - сервис ЯндексПогода;" + "\n" +
                        "2 - сервис OpenWeatherMap;" + "\n" +
                        "3 - сервис Gismeteo.");

                Scanner in = new Scanner(System.in);
                int number;
                do {
                    System.out.println("Введите число от 1 до 3.");
                    while (!in.hasNextInt()) {
                        System.out.println("Это не число");
                        in.next();
                    }
                    number = in.nextInt();
                } while (number != 1 && number != 2 && number != 3);

                if (number == 1) {
                    Weather1 weatherMSK1 = new Weather1(YANDEX_WEATHER);
                    weatherMSK1.weatherFromSite();
                } else if (number == 2) {
                    Weather2 weatherMSK2 = new Weather2();
                    weatherMSK2.initialize();
                } else if (number == 3) {
                    Weather3 weatherMSK3 = new Weather3();
                    weatherMSK3.weatherFromSite();
                }

                file.createNewFile();
                PrintWriter pw = new PrintWriter(file);
                pw.println(number);
                pw.close();
            }
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }
}
