package br.com.service;

import br.com.data.CustomerData;

public class CustomerService {
    private CustomerData customerData;

    public CustomerService(){
        this.customerData = CustomerData.getInstance();
    }

    public Long getAmountClient() {
        return customerData.getCustomerCnpj().stream().distinct().count();
    }
}
