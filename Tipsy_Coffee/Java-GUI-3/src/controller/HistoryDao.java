package controller;

import models.History;
import connection.Connector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class HistoryDao {
    private final Connector con = new Connector();
    public ArrayList<History> getAllHistory(){
        System.out.println("getHistory()");
        try{
            String query = "SELECT * FROM history";
            ArrayList<History> allHistory = new ArrayList<>();
            History history = new History();
            PreparedStatement ptsm = con.koneksi.prepareStatement(query);
            con.statement = con.koneksi.createStatement();
            ResultSet rs = ptsm.executeQuery(query);
            while(rs.next()){
                history = new History(
                        rs.getString("jam"), rs.getString("nama_barang"), rs.getInt("jumlah_barang")
                );
                allHistory.add(history);
                System.out.println(allHistory);
            }
            return allHistory;
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
        return null;
    }
}
