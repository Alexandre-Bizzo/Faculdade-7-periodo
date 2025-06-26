package crud.categoria_Produtos.dto;

public record AtualizarCategoriaInputDTO(
        String descricao,
        String codigoDeBarras,
        Double quantidade
) {}
