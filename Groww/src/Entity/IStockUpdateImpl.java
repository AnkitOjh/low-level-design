package Entity;

import Service.NiftyStock;

import java.util.List;

public class IStockUpdateImpl implements IStockUpdate{
    private NiftyStock niftyStock;

    public IStockUpdateImpl(NiftyStock niftyStock){
        this.niftyStock = niftyStock;
    }
    @Override
    public void update(String companyName,int price) {
        niftyStock.getHashMap().get(companyName).setPrice(price);
        niftyStock.printAllStocks();
    }
}
