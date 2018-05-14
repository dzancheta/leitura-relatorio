package br.com.parser;

import br.com.stub.ItemStubTest;
import org.junit.Assert;
import org.junit.Test;

public class ItemTextParserTest {
    @Test
    public void shouldReturnListStringItens() {
        Assert.assertEquals(ItemTextParser.parse(ItemStubTest.itemText()), ItemStubTest.itens());
    }
}
