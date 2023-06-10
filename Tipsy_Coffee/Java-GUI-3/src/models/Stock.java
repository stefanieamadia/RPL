package models;

public class Stock {
    private String bahanBaku;
    private int sisaStock;

    public Stock() {}

    public Stock(String bahanBaku, int sisaStock) {
        this.bahanBaku = bahanBaku;
        this.sisaStock = sisaStock;
    }

    public void setBahanBaku() {
        this.bahanBaku = bahanBaku;
    }

    public void setSisaStock() {
        this.sisaStock = sisaStock;
    }

    public String getBahanBaku() {
        return this.bahanBaku;
    }

    public int getSisaStock() {
        return this.sisaStock;
    }

    @Override
    public String toString() {
        return "{" +
                " bahan baku='" + getBahanBaku() + "'" +
                ", sisa stock='" + getSisaStock() + "'" +
                "}";
    }
}
