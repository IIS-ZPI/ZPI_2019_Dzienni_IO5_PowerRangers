package caishenproject.caishen.providers.data;

public class Param {

    private double mediana;
    private double dominanta;
    private double standartDeviation;
    private double coefficientOfVariation;

    public Param(double mediana, double dominanta, double standartDeviation, double coefficientOfVariation) {
        this.mediana = mediana;
        this.dominanta = dominanta;
        this.standartDeviation = standartDeviation;
        this.coefficientOfVariation = coefficientOfVariation;
    }

    public double getMediana() {
        return mediana;
    }

    public double getDominanta() {
        return dominanta;
    }

    public double getStandartDeviation() {
        return standartDeviation;
    }

    public double getCoefficientOfVariation() {
        return coefficientOfVariation;
    }
}
