package loja;

public class Item {
    private String nome;
    private double precoUnitario;
    private int quantidade;

    public Item(String nome, int quantidade, double precoUnitario) {

        if(precoUnitario <= 0 || quantidade <=0){
            throw new IllegalArgumentException();
        }
        this.nome = nome;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
