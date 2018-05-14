package br.com.data;

import br.com.model.SaleModel;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SalesData {

    private Set<SaleModel> vendaModel;
    private static SalesData salesData = new SalesData();

    public SalesData() {
        vendaModel = new HashSet<>();
    }
    public void add(List<SaleModel> vendaModel) {
        this.vendaModel.addAll(vendaModel);
    }

    public Set<SaleModel> getVendaModel() {
        return this.vendaModel;
    }

    public static SalesData getInstance() {
        return salesData;
    }
}
