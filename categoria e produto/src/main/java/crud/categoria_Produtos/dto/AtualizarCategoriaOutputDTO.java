package crud.categoria_Produtos.dto;

public record AtualizarCategoriaOutputDTO(
        String id
) {

    public static AtualizarCategoriaOutputDTO output(String id){
        return new AtualizarCategoriaOutputDTO(id);
    }
}
