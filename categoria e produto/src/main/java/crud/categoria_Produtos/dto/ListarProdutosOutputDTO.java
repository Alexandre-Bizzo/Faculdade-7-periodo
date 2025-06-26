package crud.categoria_Produtos.dto;

import crud.categoria_Produtos.entry.Produto;

public record ListarProdutosOutputDTO(
        String id,
        String nome,
        String descricao,
        String marca,
        String categoria,
        String codigoDeBarras,
        Double quantidade
) {

    public static ListarProdutosOutputDTO output(Produto produto) {
        return new ListarProdutosOutputDTO(
                produto.getId(),
                produto.getNome(),
                produto.getDescricao(),
                produto.getMarca(),
                produto.getCategoria(),
                produto.getCodigoDeBarras(),
                produto.getQuantidade()
        );
    }
}
