package crud.produtos.controller;

import crud.produtos.dto.*;
import crud.produtos.service.ProdutoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/produtos")
@Tag(name = "Produto", description = "Gerenciar os produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController (ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Cadastrar produto")
    @ApiResponse(responseCode = "201", description = "Produto cadastrado")
    @ApiResponse(responseCode = "400", description = "Erro de validação")
    @ApiResponse(responseCode = "500", description = "Ocorreu um erro no servidor")
    public ResponseEntity<CadastrarProdutoOutputDTO> cadastrar(@RequestBody CadastrarProdutoInputDTO input){
        CadastrarProdutoOutputDTO output = produtoService.cadastrar(input);
        return ResponseEntity.created(URI.create("/produtos/" + output.id())).body(output);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Atualizar produto")
    @ApiResponse(responseCode = "200", description = "Produto atualizado")
    @ApiResponse(responseCode = "400", description = "Erro de validação")
    @ApiResponse(responseCode = "500", description = "Ocorreu um erro no servidor")
    public ResponseEntity<AtualizarProdutoOutputDTO> atualizar(@PathVariable("id") String id, @RequestBody AtualizarProdutoInputDTO input){
        AtualizarProdutoOutputDTO output = produtoService.atualizar(id, input);
        return ResponseEntity.ok(output);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Pesquisar produto")
    @ApiResponse(responseCode = "200", description = "Produto consultado")
    @ApiResponse(responseCode = "400", description = "Erro de validação")
    @ApiResponse(responseCode = "404", description = "Produto não encontrado")
    @ApiResponse(responseCode = "500", description = "Ocorreu um erro no servidor")
    public ResponseEntity<PesquisarProdutoOutputDTO> pesquisar(@PathVariable("id") String id) {
        PesquisarProdutoOutputDTO output = produtoService.pesquisar(id);
        return ResponseEntity.ok(output);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Listar produtos")
    @ApiResponse(responseCode = "200", description = "Produtos listados")
    @ApiResponse(responseCode = "400", description = "Erro de validação")
    @ApiResponse(responseCode = "500", description = "Ocorreu um erro no servidor")
    public ResponseEntity<List<ListarProdutosOutputDTO>> listar() {
        List<ListarProdutosOutputDTO> output = produtoService.listar();
        return ResponseEntity.ok(output);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Deletar produto")
    @ApiResponse(responseCode = "204", description = "Produto excluído")
    @ApiResponse(responseCode = "400", description = "Erro de validação")
    @ApiResponse(responseCode = "404", description = "Produto não encontrado")
    @ApiResponse(responseCode = "500", description = "Ocorreu um erro no servidor")
    public ResponseEntity<Void> deletar(@PathVariable("id") String id) {
        produtoService.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
