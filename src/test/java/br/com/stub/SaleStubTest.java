package br.com.stub;

import br.com.model.SaleModel;

import java.util.Arrays;
import java.util.List;

public class SaleStubTest {
    public static List<String> saleTextTest() {
        String sale1 = "003ç10ç[1-10-100,2-30-2.50,3-40-3.10]çDiego";

        return Arrays.asList(sale1);
    }

    public static List<SaleModel> saleModel(){
       return Arrays.asList(SaleModel.builder()
                .sallerName("Diego")
                .saleValue(1199.0)
                .numberSale("10")
                .id("003")
                .itens(ItemStubTest.itemModel())
                .build());
    }
}
