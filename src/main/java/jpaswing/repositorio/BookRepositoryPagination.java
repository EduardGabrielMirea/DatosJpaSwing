package jpaswing.repositorio;

import jpaswing.entity.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;

/***
 * Para ello vamos a aprovecharnos de un tipo de repositorio llamado PagingAndSortingRepository que ya provee de paginación y de ordenación:
 * De momento vamos a crear una consulta que nos devuelva cuántos registros contiene la entidad actual:
 */
@Component
public interface BookRepositoryPagination extends PagingAndSortingRepository<Book, Long> {
    @Query("SELECT COUNT(b) FROM Book b")
    public int countAllRecords();

}
