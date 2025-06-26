package crud.categoria_Produtos.dto;

public record CadastrarProdutoInputDTO(
    String nome,
    String descricao,
    String marca,
    String categoria,
    String codigoDeBarras,
    Double quantidade,
    Double precoCusto,
    Double precoVenda
) {}
