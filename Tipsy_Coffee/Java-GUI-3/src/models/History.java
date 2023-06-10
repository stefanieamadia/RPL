package models;

public class History {
    private String jam;
    private String namaBarang;
    private int jumlahBarang;
    public History(){}

    public History(String jam, String namaBarang, int jumlahBarang){
        this.jam = jam;
        this.namaBarang = namaBarang;
        this.jumlahBarang = jumlahBarang;
    }

    public void setJam() {
        this.jam = jam;
    }

    public void setNamaBarang(){
        this.namaBarang = namaBarang;
    }

    public String getJam() {
        return this.jam;
    }

    public String getNamaBarang() {
        return this.namaBarang;
    }

    public void setJumlahBarang(){
        this.jumlahBarang = jumlahBarang;
    }

    public int getJumlahBarang() {
        return this.jumlahBarang;
    }
}
