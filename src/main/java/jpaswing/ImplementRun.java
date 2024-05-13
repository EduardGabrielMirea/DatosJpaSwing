package jpaswing;

import jpaswing.repositorio.BookRepository;
import jpaswing.ui.BookUI;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

/**
 * This CommandLineRunner fires off at runtime and boots up our GUI.
 */

@Component
public class ImplementRun implements ApplicationRunner {
    private final BookRepository bookRepository;
    private BeanFactory context;

    public ImplementRun(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    @Override
    public void run(ApplicationArguments args) throws Exception {

        //This boots up the GUI.
        //EventQueue.invokeLater(()  ->  JOptionPane.showMessageDialog(null, "FUNCIONA"));
        //EventQueue.invokeLater(() -> new BookUI(bookRepository).setVisible(true));
        EventQueue.invokeLater(()->{
            //obtenemos el objeto BookUI a través de Spring de tal forma que inyecte los componentes en el constructor
            BookUI bookUI = context.getBean(BookUI.class);
            bookUI.setVisible(true);
        });

    }
}
