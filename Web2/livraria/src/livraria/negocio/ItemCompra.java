package livraria.negocio;

public class ItemCompra {
    private Livro item;
    private int quantidade;

    public ItemCompra(Livro prod) {
        item = prod;
        quantidade = 1;
    }

    public void incrementaQuantidade() {
        quantidade++;
    }

    public void decrementaQuantidade() {
        quantidade--;
    }

    public Livro getItem() {
        return item;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantity) {
        this.quantidade = quantity;
    }
}