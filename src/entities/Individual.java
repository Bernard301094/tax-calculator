package entities;

public class Individual extends TaxPayer {

    private Double healthExpenditures;

    public Double getHealthExpenditures() {
        return healthExpenditures;
    }

    public void setHealthExpenditures(Double healthExpenditures) {
        this.healthExpenditures = healthExpenditures;
    }

    public Individual(Double anualIncome, String name, Double healthExpenditures) {
        super(anualIncome, name);
        this.healthExpenditures = healthExpenditures;
    }

    @Override
    public double tax() {
        if (getAnualIncome() < 20000.0){
            return getAnualIncome() * 0.15 - (healthExpenditures * 0.5);
        } else {
            return getAnualIncome() * 0.25 - (healthExpenditures * 0.5);
        }
    }
}
