package Entity;

import java.util.List;

public class IStockUpdateImpl implements IStockUpdate{
    private List<Stock> stockList;


    @Override
    public void update(List<Integer> priceList) {
        for(int i=0;i<stockList.size();i++){
            stockList.get(0).setPrice(priceList.get(i));
        }
    }
}
