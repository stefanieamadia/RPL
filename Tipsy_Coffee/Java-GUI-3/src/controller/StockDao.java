package controller;

import models.Stock;
import connection.Connector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class StockDao {
    private final Connector con = new Connector();
    public ArrayList<Stock> getAllStock(){
        System.out.println("getStock()");
        try{
            String query = "SELECT * FROM stocks";
            ArrayList<Stock> allStocks = new ArrayList<>();
            Stock stock = new Stock();
            PreparedStatement ptsm = con.koneksi.prepareStatement(query);
            con.statement = con.koneksi.createStatement();
            ResultSet rs = ptsm.executeQuery(query);
            while(rs.next()){
                stock = new Stock(
                        rs.getString("bahan_baku"), rs.getInt("sisa_stock")
                );
                allStocks.add(stock);
            }
            return allStocks;
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
        return null;
    }

    public void addStock(String bahanBaku, int sisaStock) {
        System.out.println("addStock()");
        String query = "UPDATE stocks SET sisa_stock = sisa_stock + ? WHERE bahan_baku = ?";
        PreparedStatement pstm;
        try {
            con.statement = con.koneksi.createStatement();
            pstm = con.koneksi.prepareStatement(query);
            pstm.setInt(1, sisaStock);
            pstm.setString(2, bahanBaku);
            pstm.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
