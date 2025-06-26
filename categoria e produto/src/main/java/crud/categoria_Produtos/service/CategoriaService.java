package crud.categoria_Produtos.service;

import crud.categoria_Produtos.dto.*;
import crud.categoria_Produtos.entry.Categoria;
import crud.categoria_Produtos.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository){
        this.categoriaRepository = categoriaRepository;
    }

    public CadastrarCategoriaOutputDTO cadastrar(CadastrarCategoriaInputDTO input) {
        Categoria categoria = Categoria.novaCategoria(
                input.nome(),
                input.descricao(),
                input.marca(),
                input.categoria(),
                input.codigoDeBarras(),
                input.quantidade(),
                input.precoCusto(),
                input.precoVenda()
        );

        final var categoriaSalvo = categoriaRepository.save(categoria);

        return CadastrarCategoriaOutputDTO.output(categoriaSalvo.getId());
    }

    public AtualizarCategoriaOutputDTO atualizar(String id, AtualizarCategoriaInputDTO input){

        final var categoria = categoriaRepository.findById(id).orElseThrow();

        categoria.atualizar(
                input.descricao(),
                input.codigoDeBarras(),
                input.quantidade()
        );

        final var categoriaAtualizado = categoriaRepository.save(categoria);

        return AtualizarCategoriaOutputDTO.output(categoriaAtualizado.getId());
    }

    public PesquisarCategoriaOutputDTO pesquisar(String id){
        final var categoria = categoriaRepository.findById(id).orElseThrow();

        return PesquisarCategoriaOutputDTO.output(categoria);
    }

    public List<ListarCategoriasOutputDTO> listar(){
        final var categorias = categoriaRepository.findAll();

      return categorias.stream()
              .map(ListarCategoriasOutputDTO::output)
              .toList();
    }

    public void deletar(String id) {
        categoriaRepository.deleteById(id);
    }
}
