package br.comlojao241;

public class Frete {
    private int id;
    private int cepInicial;
    private int cepFinal;
    private double valorPorKilo;

    public Frete(int id, int cepInicial, int cepFinal, double valorPorKilo) {
        this.id = id;
        this.cepInicial = cepInicial;
        this.cepFinal = cepFinal;
        this.valorPorKilo = valorPorKilo;
    }

    public int getId() {
        return id;
    }

    public int getCepInicial() {
        return cepInicial;
    }

    public int getCepFinal() {
        return cepFinal;
    }

    public double getValorPorKilo() {
        return valorPorKilo;
    }
}
