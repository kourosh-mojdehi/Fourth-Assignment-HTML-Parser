import java.util.Objects;

public class Country {
    private String name;
    private String capital;
    private int population;
    private double area;

    public Country(String name, String capital, int population, double area) {
        this.name = name;
        this.capital = capital;
        this.area = area;
        this.population = population;

    }


    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~setter methods


    public void setName(String name) {
        this.name = name;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public void setArea(double area) {
        this.area = area;
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~getter methods
    public String getName() {
        return name;
    }


    public String getCapital() {
        return capital;
    }

    public int getPopulation() {
        return population;
    }

    public double getArea() {
        return area;
    }

    @Override
    public String toString() {
        //TODO
        return "";
    }

    @Override
    public boolean equals(Object o) {
        Country country = (Country) o;
        return population == country.population &&
                Double.compare(country.area, area) == 0 &&
                Objects.equals(name, country.name) &&
                Objects.equals(capital, country.capital);
    }
}
