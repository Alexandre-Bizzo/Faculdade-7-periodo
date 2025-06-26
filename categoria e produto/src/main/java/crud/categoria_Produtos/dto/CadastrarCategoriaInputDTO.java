package crud.categoria_Produtos.dto;

public record CadastrarCategoriaInputDTO(
    String nome,
    String descricao,
    String marca,
    String categoria,
    String codigoDeBarras,
    Double quantidade,
    Double precoCusto,
    Double precoVenda
) {}
