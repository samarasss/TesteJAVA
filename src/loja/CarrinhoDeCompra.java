package loja;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompra {

    private List<Item> itens;

    public CarrinhoDeCompra() {
        this.itens = new ArrayList<>();
    }

    public void adicionar(Item elemento){
        for(Item itemExistente: itens){
            if(itemExistente.getNome().equalsIgnoreCase(elemento.getNome())){
                itemExistente.setQuantidade(itemExistente.getQuantidade() + elemento.getQuantidade());
                return;
            }
        }
        itens.add(elemento);
    }
    public List<Item> getItens() {
        return itens;
    }
    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    public double calcularSubTotal(){
        double subtotal = 0;
        for(Item itemExistente: itens){
            double valorPorItem = itemExistente.getQuantidade() * itemExistente.getPrecoUnitario();
            subtotal += valorPorItem;
        }
        return subtotal;
    }

    public double calcularDesconto(double porcentagem){
        if(porcentagem < 0 || porcentagem > 50){
            throw  new IllegalArgumentException("O desconto deve ser entre 0% e 50%");
        }
        double subtotal = calcularSubTotal();
        //return subtotal * (100 - porcentagem)/100;
        return subtotal - (subtotal * porcentagem/100);
    }
}
