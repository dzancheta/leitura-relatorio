package br.com.service;

import br.com.data.SalesmanData;

public class SalesmanService {
    private SalesmanData salesmanData = SalesmanData.getInstance();

    public Long getAmountSalesman() {
        return salesmanData.getSalesmanCpf().stream().distinct().count();
    }
}
