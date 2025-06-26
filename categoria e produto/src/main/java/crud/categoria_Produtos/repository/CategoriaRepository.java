package crud.categoria_Produtos.repository;

import crud.categoria_Produtos.entry.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, String> {
}
