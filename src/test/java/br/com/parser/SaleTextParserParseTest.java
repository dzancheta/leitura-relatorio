package br.com.parser;

import br.com.stub.SaleStubTest;
import org.junit.Assert;
import org.junit.Test;

public class SaleTextParserParseTest {
    @Test
    public void shouldReturnSaleModel() {
        Assert.assertEquals(SaleTextParser.parseSale(SaleStubTest.saleTextTest()), SaleStubTest.saleModel());
    }
}
