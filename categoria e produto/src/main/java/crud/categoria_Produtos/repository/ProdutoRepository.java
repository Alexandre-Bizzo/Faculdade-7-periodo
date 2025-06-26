package crud.categoria_Produtos.repository;

import crud.categoria_Produtos.entry.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, String> {
}
