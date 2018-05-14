package br.com.listeners;

import br.com.data.SalesData;
import br.com.parser.SaleTextParser;

import java.util.List;

public class SaleFileListener implements FileListener{

    private SalesData salesData;

    public SaleFileListener() {
        this.salesData = SalesData.getInstance();
    }

    @Override
    public void proccess(List<String> lines) {
        this.salesData.add(SaleTextParser.parseSale(lines));
    }
}
