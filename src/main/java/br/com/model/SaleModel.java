package br.com.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SaleModel {
    private String id;
    private String numberSale;
    private String sallerName;
    private List<ItemModel> itens;
    private Double saleValue;
}
