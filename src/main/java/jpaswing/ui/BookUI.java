package jpaswing.ui;

import jpaswing.entity.Book;
import jpaswing.repositorio.BookRepository;

import javax.swing.*;
import java.awt.*;

public class BookUI extends JFrame {
    private JTextArea idField;
    private JTextField nameField;
    private JPanel panel1;
    private Book book;

    public BookUI(JTextArea idField, JTextField nameField, JPanel panel1) throws HeadlessException {
        this.idField = idField;
        this.nameField = nameField;
        this.panel1 = panel1;
    }

    /***
     * Es un constructor para llamar al libro y modelar graficamente la ventana del panel
     * @param bookRepository
     */
    public BookUI(BookRepository bookRepository) {
        setTitle("Book Maintenance");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 400);
        initComponents();
        
        //Insertamos en Book desde la base de datos, el primero ordenado por id de forma ascendente.
        this.book = (Book) bookRepository.findFirstByOrderByIdAsc();
        updateData();
    }

    /**
     * Con este metodo modelamos que queremos enseñar en el panel graficamente.
     */
    private void initComponents() {
        panel1 = new JPanel();
        idField = new JTextArea();
        nameField = new JTextField();
        JLabel l;

        this.setLayout(null);
        panel1.setLayout(null);
        panel1.setBounds(0, 0, 500, 650);

        l = new JLabel("ID:");
        l.setBounds(10, 10, 70, 20);
        panel1.add(l);
        idField.setEnabled(false);
        idField.setBounds(10 + 80, 10, 200, 20);
        panel1.add(idField);

        l = new JLabel("Name:");
        l.setBounds(10, 40, 70, 20);
        panel1.add(l);
        nameField.setBounds(10 + 80, 40, 200, 20 );
        panel1.add(nameField);
        this.add(panel1);
    }
    private void updateData() {
        idField.setText(Long.toString(this.book.getId()));
        nameField.setText(this.book.getName());
    }
}
