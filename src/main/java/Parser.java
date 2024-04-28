import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.File;
import java.io.IOException;
import java.util.*;

import static java.lang.System.exit;

public class Parser {
    protected static Scanner scanner = new Scanner(System.in);

    public static String shortRedWave = "\u001B[31m" + "~~~~~~~~~~~~~~" + "\u001B[0m";
    public static String longRedWave = "\u001B[31m" + "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + "\u001B[0m\n";
    //~~~~~~~~~~~~colors
    public static String green = "\u001B[32m";
    public static String red = "\u001B[31m";
    public static String blue = "\u001B[34m";
    public static String yellow = "\033[0;33m";
    public static String white = "\u001B[0m";
    static List<Country> countries = new ArrayList<>();

    public static List<Country> sortByName() {
        List<Country> sortedByName = new ArrayList<>(countries);
        int size = sortedByName.size();
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {

                String name1 = sortedByName.get(i).getName();
                String name2 = sortedByName.get(j).getName();
                if (name1.compareTo(name2) > 0) {
                    Country temp = sortedByName.get(i);
                    sortedByName.set(i, sortedByName.get(j));
                    sortedByName.set(j, temp);
                }
            }
        }
        return sortedByName;
    }

    public static List<Country> sortByPopulation() {
        List<Country> sortedByPopulation = new ArrayList<>(countries);
        int size = sortedByPopulation.size();
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (sortedByPopulation.get(j).getPopulation() < sortedByPopulation.get(j + 1).getPopulation()) {
                    Country temp = sortedByPopulation.get(j);
                    sortedByPopulation.set(j, sortedByPopulation.get(j + 1));
                    sortedByPopulation.set(j + 1, temp);
                }
            }
        }
        return sortedByPopulation;

    }


    public static List<Country> sortByArea() {
        List<Country> sortedByArea = new ArrayList<>(countries);

        int size = sortedByArea.size();
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (sortedByArea.get(j).getArea() < sortedByArea.get(j + 1).getArea()) {
                    Country temp = sortedByArea.get(j);
                    sortedByArea.set(j, sortedByArea.get(j + 1));
                    sortedByArea.set(j + 1, temp);
                }
            }
        }
        return sortedByArea;
    }


    public static void setUp() throws IOException {

        //Parse the HTML file using Jsoup
        File file = new File("src/Resources/country-list.html");
        Document doc = Jsoup.parse(file, "UTF-8");
        Elements elements = doc.getElementsByClass("col-md-4 country");
        Country newCountry;
        for (Element i : elements) {
            String name = i.getElementsByClass("country-name").first().text();
            String capital = i.getElementsByClass("country-capital").first().text();
            String populationtext = (i.getElementsByClass("country-population").first().text());
            int population = Integer.parseInt(populationtext);
            String areatext = i.getElementsByClass("country-area").first().text();
            double area = Double.parseDouble(areatext);
            newCountry = new Country(name, capital, population, area);
            countries.add(newCountry);
        }
    }

    public static void printer(List<Country> list, int input) {
        String nameColor=green , areaColor =green, populationColor = green;
        switch (input) {
            case 1 -> populationColor =blue;
            case 2 -> areaColor = blue;
            case 3 -> nameColor = blue;
        }
        int size = list.size();
        System.out.print(yellow);
        System.out.printf("%-35s" , "name");
        System.out.printf("%-30s" , "capital");
        System.out.printf("%-20s" , "population");
        System.out.println("AREA" + white);
        for(int i=0 ; i<size ; i++ ){

            System.out.print(nameColor);
            System.out.printf("%-35S" , list.get(i).getName() );
            System.out.printf("%-30S" , list.get(i).getCapital() );
            System.out.print(populationColor);
            System.out.printf("%-20S" , list.get(i).getPopulation());
            System.out.print(areaColor);
            System.out.print( list.get(i).getArea());
            System.out.println();
        }

    }


    public static void main(String[] args) throws IOException {
        setUp();
        System.out.println(red + "welcome to country information guide");
        System.out.println(blue + "what can I do for you?");
        System.out.println("1 : show me list of countries by population");
        System.out.println("2 : show me list of countries by area");
        System.out.println("3 : show me list of countries by name");
        System.out.println(red + "4 : exit");
        String input = "";
        boolean invalidInput = true;
        List <Country> list = null ;

        while (invalidInput) {
            input = scanner.nextLine();

            switch (input) {
                case "1":
                    list = sortByPopulation();
                    invalidInput = false;
                    break;

                case "2":
                    list = sortByPopulation();
                    invalidInput = false;
                    break;

                case "3":
                    list = sortByName();
                    invalidInput = false;

                    break;
                case "4":
                    exit(0);
                    break;

                default:
                    System.out.println(red + "please enter a number from 1 to 4 ");
                    break;
            }
        }

        printer(list ,Integer.parseInt( input ));

    }
}



