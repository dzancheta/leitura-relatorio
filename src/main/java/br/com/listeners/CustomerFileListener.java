package br.com.listeners;

import br.com.data.CustomerData;
import br.com.parser.DefaultParser;

import java.util.List;

public class CustomerFileListener implements FileListener {
    private static final String CUSTOMER_ID = "001";

    private CustomerData customerData;

    public CustomerFileListener(){
        this.customerData = CustomerData.getInstance();
    }

    @Override
    public void proccess(List<String> lines) {
        this.customerData.add(DefaultParser.parseDefaultIdentifier(lines, CUSTOMER_ID));
    }
}
