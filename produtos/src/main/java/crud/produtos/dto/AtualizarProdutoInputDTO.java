package crud.produtos.dto;

public record AtualizarProdutoInputDTO(
        String descricao,
        String codigoDeBarras,
        Double quantidade
) {}
