package crud.produtos.dto;

public record CadastrarProdutoOutputDTO(
        String id
) {

    public static CadastrarProdutoOutputDTO output(String id) {
        return new CadastrarProdutoOutputDTO(id);
    }
}
