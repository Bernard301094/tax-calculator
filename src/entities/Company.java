package entities;

public class Company extends TaxPayer{

    private Integer numberOfEmployees;

    public Integer getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(Integer numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    public Company(Double anualIncome, String name, Integer numberOfEmployees) {
        super(anualIncome, name);
        this.numberOfEmployees = numberOfEmployees;
    }

    @Override
    public double tax() {
        return getNumberOfEmployees() > 10 ? getAnualIncome() * 0.14 : getAnualIncome() * 0.16;
    }
}
