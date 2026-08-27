package testes;

import loja.CarrinhoDeCompra;
import loja.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CarrinhoDeCompraTestes {

    private CarrinhoDeCompra carrinho;

    @BeforeEach
    public void setUp(){
        carrinho = new CarrinhoDeCompra();
    }

    @Test
    @DisplayName("Deve adicionar itens no carrinho")
    public void deveAdicionarItem(){

        Item elemento = new Item("Teclado Mecânico", 250, 1);
        Item elemento1 = new Item("Teclado Mecânico", 250, 1);

        carrinho.adicionar(elemento);
        carrinho.adicionar(elemento1);

        assertFalse(carrinho.getItens().isEmpty());
        assertEquals(1, carrinho.getItens().size());
        assertEquals("Teclado Mecânico", carrinho.getItens().get(0).getNome());

    }

    @Test
    @DisplayName(" Deve adicionar os itens e calcular o subtotal corretamente")
    public void deveCalcularSubtotal(){

        carrinho.adicionar(new Item("Notebook", 1, 3000));
        carrinho.adicionar(new Item("Mouse", 2, 100));

        assertEquals(3200, carrinho.calcularSubTotal());
    }

    @Test
    @DisplayName(" Deve calcular desconto")
    public void deveCalcularDesconto(){
        carrinho.adicionar(new Item("Notebook", 1, 3000));
        carrinho.adicionar(new Item("Mouse", 2, 100));

        assertEquals(2880, carrinho.calcularDesconto(10));
        assertEquals(3200, carrinho.calcularDesconto(0));
        assertEquals(1600, carrinho.calcularDesconto(50));
    }

    @Test
    @DisplayName("Deve testar descontos inválidos")
    public void deveTestarDescontoInvalido(){
        carrinho.adicionar(new Item("Notebook", 1, 3000));

        assertThrows(IllegalArgumentException.class, () -> {
            carrinho.calcularDesconto(-10);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            carrinho.calcularDesconto(60);
        });
    }

    public void deveTestarQuantidadeInvalida(){
        assertThrows(IllegalArgumentException.class, () ->{
            Item item = new Item("Notebook", -1, 3000);
        });
    }

}1
