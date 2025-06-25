package crud.produtos.dto;

public record AtualizarProdutoOutputDTO(
        String id
) {

    public static AtualizarProdutoOutputDTO output(String id){
        return new AtualizarProdutoOutputDTO(id);
    }
}
