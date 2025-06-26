package crud.categoria_Produtos.dto;

public record AtualizarProdutoInputDTO(
        String descricao,
        String codigoDeBarras,
        Double quantidade
) {}
