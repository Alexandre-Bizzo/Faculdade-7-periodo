package crud.categoria_Produtos.dto;

import crud.categoria_Produtos.entry.Categoria;

public record PesquisarCategoriaOutputDTO(
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
    public static PesquisarCategoriaOutputDTO output(Categoria categoria) {
        return new PesquisarCategoriaOutputDTO(
                categoria.getId(),
                categoria.getNome(),
                categoria.getDescricao(),
                categoria.getMarca(),
                categoria.getCategoria(),
                categoria.getCodigoDeBarras(),
                categoria.getQuantidade(),
                categoria.getPrecoCusto(),
                categoria.getPrecoVenda()
        );
    }
}
