package br.com.stub;

import br.com.model.ItemModel;

import java.util.Arrays;
import java.util.List;

public class ItemStubTest {
    public static List<ItemModel> itemModel(){
        ItemModel item1 = ItemModel.builder()
                .agrupaValorItem(1000.0)
                .idItem("1")
                .quantidade("10")
                .preco("100")
                .build();

        ItemModel item2 = ItemModel.builder()
                .agrupaValorItem(75.0)
                .idItem("2")
                .quantidade("30")
                .preco("2.50")
                .build();

        ItemModel item3 = ItemModel.builder()
                .agrupaValorItem(124.0)
                .idItem("3")
                .quantidade("40")
                .preco("3.10")
                .build();

        return Arrays.asList(item1, item2, item3);
    }

    public static String itemText(){
        return "[1-10-100,2-30-2.50,3-40-3.10]";
    }

    public static List<String> itens() {
        return Arrays.asList("1-10-100", "2-30-2.50", "3-40-3.10");
    }
}
