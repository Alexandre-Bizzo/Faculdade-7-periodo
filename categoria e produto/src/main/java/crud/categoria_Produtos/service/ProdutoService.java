package crud.categoria_Produtos.service;

import crud.categoria_Produtos.dto.*;
import crud.categoria_Produtos.entry.Produto;
import crud.categoria_Produtos.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository){
        this.produtoRepository = produtoRepository;
    }

    public CadastrarProdutoOutputDTO cadastrar(CadastrarProdutoInputDTO input) {
        Produto produto = Produto.novoProduto(
                input.nome(),
                input.descricao(),
                input.marca(),
                input.categoria(),
                input.codigoDeBarras(),
                input.quantidade(),
                input.precoCusto(),
                input.precoVenda()
        );

        final var produtoSalvo = produtoRepository.save(produto);

        return CadastrarProdutoOutputDTO.output(produtoSalvo.getId());
    }

    public AtualizarProdutoOutputDTO atualizar(String id, AtualizarProdutoInputDTO input){

        final var produto = produtoRepository.findById(id).orElseThrow();

        produto.atualizar(
                input.descricao(),
                input.codigoDeBarras(),
                input.quantidade()
        );

        final var produtoAtualizado = produtoRepository.save(produto);

        return AtualizarProdutoOutputDTO.output(produtoAtualizado.getId());
    }

    public PesquisarProdutoOutputDTO pesquisar(String id){
        final var produto = produtoRepository.findById(id).orElseThrow();

        return PesquisarProdutoOutputDTO.output(produto);
    }

    public List<ListarProdutosOutputDTO> listar(){
        final var produtos = produtoRepository.findAll();

      return produtos.stream()
              .map(ListarProdutosOutputDTO::output)
              .toList();
    }

    public void deletar(String id) {
        produtoRepository.deleteById(id);
    }
}
