import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class Parser {
    static List<Country> countries = new ArrayList<>();

    public static List<Country> sortByName(){
        List<Country> sortedByName = new ArrayList<>(countries);
        int size = sortedByName.size();
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {

                String name1 = sortedByName.get(i).getName();
                String name2 = sortedByName.get(j).getName();
                if (name1.compareTo(name2) > 0) {
                    Country temp = sortedByName.get(i);
                    sortedByName.set(i , sortedByName.get(j));
                    sortedByName.set(j , sortedByName.get(i));
                }
            }
        }
        return  sortedByName;
    }

    public static List<Country> sortByPopulation(){
        List<Country> sortedByPopulation = new ArrayList<>(countries);
        // Sort countries by population (most)
        //TODO
        return sortedByPopulation;
    }

    public static List<Country> sortByArea(){
        List<Country> sortedByArea = new ArrayList<>(countries);
        // Sort countries by area (most)
        //TODO
        return sortedByArea;
    }

    public static void  setUp() throws IOException {

        //Parse the HTML file using Jsoup
        File file = new File("src/Resources/country-list.html");
        Document doc = Jsoup.parse(file, "UTF-8");
        Elements elements = doc.getElementsByClass("col-md-4 country");
        Country newCountry ;
        for( Element i : elements){
            String name = i.getElementsByClass("country-name").first().text();
            String capital = i.getElementsByClass("country-capital").first() . text();
            String populationtext = (i .getElementsByClass("country-population").first().text() );
            int population = Integer.parseInt( populationtext );
            String areatext = i. getElementsByClass("country-area").first().text();
            double area = Double.parseDouble( areatext);
            newCountry=  new Country( name , capital , population , area);
            countries.add(newCountry);
        }



        // Iterate through each country element


        // Iterate through each country div to extract country data
        //TODO
    }

    public static void main(String[] args) throws IOException {
        //you can test your code here before you run the unit tests ;)
        setUp();
        for ( Country i : sortByName()){

        }

    }
}
