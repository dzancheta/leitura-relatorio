package br.com.dataanalytic;

import br.com.model.FormModel;
import br.com.service.CustomerService;
import br.com.service.SalesService;
import br.com.service.SalesmanService;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DataAnalytic {
    private CustomerService customerService = new CustomerService();
    private SalesmanService salesmanService = new SalesmanService();
    private SalesService salesService = new SalesService();

    private Path path = Paths.get("%HOMEPATH%/data/out/output.done.dat");

    public void formModel() {
        FormModel build = FormModel.builder()
                .AmountClients(customerService.getAmountClient())
                .AmountSalesman(salesmanService.getAmountSalesman())
                .idMostExpensiveSale(salesService.getBestSalling())
                .worstSalesmanEver(salesService.worstSeller())
                .build();

        try(BufferedWriter writer = Files.newBufferedWriter(path)){
            writer.write(build.toString());
            System.out.println("Salvou!");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
