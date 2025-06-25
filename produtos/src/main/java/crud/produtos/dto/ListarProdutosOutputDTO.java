package crud.produtos.dto;

import crud.produtos.entry.Produto;

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
