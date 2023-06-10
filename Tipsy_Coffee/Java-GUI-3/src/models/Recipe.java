package models;

public class Recipe {
    private int id;
    private String namaMenu;
    private String resepMenu;

    public Recipe() {}

    public Recipe(String namaMenu, String resepMenu) {
        this.namaMenu = namaMenu;
        this.resepMenu = resepMenu;
    }

    public Recipe(int id, String namaMenu, String resepMenu) {
        this.id = id;
        this.namaMenu = namaMenu;
        this.resepMenu = resepMenu;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setNamaMenu(String namaMenu) {
        this.namaMenu = namaMenu;
    }

    public void setResepMenu(String resepMenu) {
        this.resepMenu = resepMenu;
    }

    public String getNamaMenu() {
        return this.namaMenu;
    }

    public String getResepMenu() {
        return this.resepMenu;
    }

    @Override
    public String toString() {
        return "{" +
                " nama menu='" + getNamaMenu() + "'" +
                ", resep menu='" + getResepMenu() + "'" +
                "}";
    }
}
