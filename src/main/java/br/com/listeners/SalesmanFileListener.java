package br.com.listeners;

import br.com.data.SalesmanData;
import br.com.parser.DefaultParser;

import java.util.List;

public class SalesmanFileListener implements FileListener {

    private SalesmanData salesmanData = SalesmanData.getInstance();
    private static final String SALESMAN_ID = "002";

    @Override
    public void proccess(List<String> lines) {
        salesmanData.add(DefaultParser.parseDefaultIdentifier(lines, SALESMAN_ID));
    }
}
