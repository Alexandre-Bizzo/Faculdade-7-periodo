package crud.categoria_Produtos.controller;

import crud.categoria_Produtos.dto.*;
import crud.categoria_Produtos.service.CategoriaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/categorias")
@Tag(name = "Categoria", description = "Gerenciar as categorias dos produtos")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Cadastrar categoria")
    @ApiResponse(responseCode = "201", description = "Categoria cadastrada")
    @ApiResponse(responseCode = "400", description = "Erro de validação")
    @ApiResponse(responseCode = "500", description = "Ocorreu um erro no servidor")
    public ResponseEntity<CadastrarCategoriaOutputDTO> cadastrar(@RequestBody CadastrarCategoriaInputDTO input){
        CadastrarCategoriaOutputDTO output = categoriaService.cadastrar(input);
        return ResponseEntity.created(URI.create("/categorias/" + output.id())).body(output);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Atualizar categoria")
    @ApiResponse(responseCode = "200", description = "Categoria atualizada")
    @ApiResponse(responseCode = "400", description = "Erro de validação")
    @ApiResponse(responseCode = "500", description = "Ocorreu um erro no servidor")
    public ResponseEntity<AtualizarCategoriaOutputDTO> atualizar(@PathVariable("id") String id, @RequestBody AtualizarCategoriaInputDTO input){
        AtualizarCategoriaOutputDTO output = categoriaService.atualizar(id, input);
        return ResponseEntity.ok(output);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Pesquisar categoria")
    @ApiResponse(responseCode = "200", description = "Categoria consultada")
    @ApiResponse(responseCode = "400", description = "Erro de validação")
    @ApiResponse(responseCode = "404", description = "Categoria não encontrada")
    @ApiResponse(responseCode = "500", description = "Ocorreu um erro no servidor")
    public ResponseEntity<PesquisarCategoriaOutputDTO> pesquisar(@PathVariable("id") String id) {
        PesquisarCategoriaOutputDTO output = categoriaService.pesquisar(id);
        return ResponseEntity.ok(output);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Listar categorias")
    @ApiResponse(responseCode = "200", description = "Categorias listadas")
    @ApiResponse(responseCode = "400", description = "Erro de validação")
    @ApiResponse(responseCode = "500", description = "Ocorreu um erro no servidor")
    public ResponseEntity<List<ListarCategoriasOutputDTO>> listar() {
        List<ListarCategoriasOutputDTO> output = categoriaService.listar();
        return ResponseEntity.ok(output);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Deletar categoria")
    @ApiResponse(responseCode = "204", description = "Categoria excluída")
    @ApiResponse(responseCode = "400", description = "Erro de validação")
    @ApiResponse(responseCode = "404", description = "Categoria não encontrada")
    @ApiResponse(responseCode = "500", description = "Ocorreu um erro no servidor")
    public ResponseEntity<Void> deletar(@PathVariable("id") String id) {
        categoriaService.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
