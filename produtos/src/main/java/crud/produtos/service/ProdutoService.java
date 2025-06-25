package crud.produtos.service;

import crud.produtos.dto.*;
import crud.produtos.entry.Produto;
import crud.produtos.repository.ProdutoRepository;
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
