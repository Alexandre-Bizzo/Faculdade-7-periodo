package crud.categoria_Produtos.dto;

import crud.categoria_Produtos.entry.Categoria;

public record ListarCategoriasOutputDTO(
        String id,
        String nome,
        String descricao,
        String marca,
        String categoria,
        String codigoDeBarras,
        Double quantidade
) {

    public static ListarCategoriasOutputDTO output(Categoria categoria) {
        return new ListarCategoriasOutputDTO(
                categoria.getId(),
                categoria.getNome(),
                categoria.getDescricao(),
                categoria.getMarca(),
                categoria.getCategoria(),
                categoria.getCodigoDeBarras(),
                categoria.getQuantidade()
        );
    }
}
