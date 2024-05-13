package jpaswing.controlador;


import jpaswing.entity.Book;
import jpaswing.repositorio.BookRepository;
import jpaswing.repositorio.BookRepositoryPagination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.Optional;

//Necesario para que se pueda inyectar con AutoWired
@Component
public class BookController {
    private final BookRepository bookRepository;
    private final BookRepositoryPagination bookRepositoryPagination;
    private int currentPage = 0;
    private int count;
    private Optional<Book> currentBook;
    @Autowired
    public BookController(BookRepository bookRepository, BookRepositoryPagination bookRepositoryPagination){
        this.bookRepository = bookRepository;
        this.bookRepositoryPagination = bookRepositoryPagination;
        this.count = bookRepositoryPagination.countAllRecords();
    }
    public Optional<Book> getBook(){
        //El primer parámetro es el número de página y el segundo los registros que queremos que nos devuelva
        PageRequest pr = PageRequest.of(currentPage, 1);
        currentBook = Optional.of(bookRepositoryPagination.findAll(pr).getContent().get(0));
        return currentBook;
    }

    public Optional<Book> next(){
        //Si ya estoy al final, devuelvo el libro actual
        this.count = bookRepositoryPagination.countAllRecords();
        if (currentPage == this.count -1 ) return currentBook;

        currentPage++;
        return getBook();
    }

    public Optional<Book> previous(){
        //Si ya estoy al principio, devuelvo el libro actual
        if (currentPage == 0) return currentBook;

        currentPage--;
        return getBook();
    }

    public Optional<Book> first(){
        //Primer libro
        currentPage = 0;
        return getBook();
    }
    public Optional<Book> last(){
        //Último libro
        this.count = bookRepositoryPagination.countAllRecords();
        currentPage = count - 1;
        return getBook();
    }

}
