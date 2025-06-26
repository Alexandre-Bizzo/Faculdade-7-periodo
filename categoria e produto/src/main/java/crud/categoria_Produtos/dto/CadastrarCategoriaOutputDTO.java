package crud.categoria_Produtos.dto;

public record CadastrarCategoriaOutputDTO(
        String id
) {

    public static CadastrarCategoriaOutputDTO output(String id) {
        return new CadastrarCategoriaOutputDTO(id);
    }
}
