package crud.categoria_Produtos.dto;

public record CadastrarProdutoOutputDTO(
        String id
) {

    public static CadastrarProdutoOutputDTO output(String id) {
        return new CadastrarProdutoOutputDTO(id);
    }
}
