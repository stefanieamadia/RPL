package controller;
import models.Recipe;
import connection.Connector;
import models.Recipe;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
public class RecipeDao {
    private final Connector con = new Connector();
    public ArrayList<Recipe> getAllRecipe(){
        System.out.println("getRecipe()");
        try{
            String query = "SELECT * FROM recipe";
            ArrayList<Recipe> allRecipe = new ArrayList<>();
            Recipe recipe = new Recipe();
            PreparedStatement ptsm = con.koneksi.prepareStatement(query);
            con.statement = con.koneksi.createStatement();
            ResultSet rs = ptsm.executeQuery(query);
            while(rs.next()){
                recipe = new Recipe(
                        rs.getInt("id"), rs.getString("nama_menu"), rs.getString("resep_menu")
                );
                allRecipe.add(recipe);
            }
            return allRecipe;
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
        return null;
    }

    public void updateRecipe(int id, String namaMenu, String resepMenu) {
        System.out.println("updateRecipe()");
        System.out.println("id:" + id + "nama menu:" + namaMenu + "resep menu:" + resepMenu);
        String query = "UPDATE recipe SET nama_menu = ?, resep_menu = ? WHERE id = ?";
        PreparedStatement pstm;
        try {
            con.statement = con.koneksi.createStatement();
            pstm = con.koneksi.prepareStatement(query);
            pstm.setString(1, namaMenu);
            pstm.setString(2, resepMenu);
            pstm.setInt(3, id);
            pstm.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

}
