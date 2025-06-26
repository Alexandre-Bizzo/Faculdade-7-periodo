package crud.categoria_Produtos.dto;

import crud.categoria_Produtos.entry.Produto;

public record PesquisarProdutoOutputDTO(
        String id,
        String nome,
        String descricao,
        String marca,
        String categoria,
        String codigoDeBarras,
        Double quantidade,
        Double precoCusto,
        Double precoVenda
) {
    public static PesquisarProdutoOutputDTO output(Produto produto) {
        return new PesquisarProdutoOutputDTO(
                produto.getId(),
                produto.getNome(),
                produto.getDescricao(),
                produto.getMarca(),
                produto.getCategoria(),
                produto.getCodigoDeBarras(),
                produto.getQuantidade(),
                produto.getPrecoCusto(),
                produto.getPrecoVenda()
        );
    }
}
