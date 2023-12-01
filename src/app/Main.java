package app;

import data.TradingCardGameDAO;
import entities.CommonCollection;

import java.io.File;
import java.util.ArrayList;

public class Main {


    public static void main(String[] args) {
        TradingCardGameDAO dao = new TradingCardGameDAO();
        dao.fetch_and_write_data();

        CommonCollection collection = new CommonCollection();
        collection.initializeCollection();
    }

}
