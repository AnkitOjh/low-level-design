package Service;

import Entity.Stock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NiftyStock {
    private List<Stock> stockList;
    private HashMap<String,Stock> stringStockHashMap;
    public NiftyStock(){
        stockList = new ArrayList<>();
        stockList.add(new Stock("tata",100,100,1));
        stockList.add(new Stock("titan", 100,200,2));
        stockList.add(new Stock("google", 100, 300, 3));
        stringStockHashMap = new HashMap<>();
        stringStockHashMap.put("tata",new Stock("tata",100,100,1));
        stringStockHashMap.put("titan", new Stock("titan", 100,200,2));
    }

    public HashMap<String,Stock> getHashMap(){
        return this.stringStockHashMap;
    }

    public synchronized void printAllStocks(){
        for(Map.Entry<String,Stock> entry : this.stringStockHashMap.entrySet()){
            System.out.println("Company = "+ entry.getKey() + "Price = "+ entry.getValue().getPrice()+ "Quantity = "+ entry.getValue().getQuantity());
        }
    }
}
