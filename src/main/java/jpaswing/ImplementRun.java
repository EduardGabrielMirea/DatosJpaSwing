package app;

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
    @Override
    public void run(ApplicationArguments args) throws Exception {
        //This boots up the GUI.
        EventQueue.invokeLater(()  ->  JOptionPane.showMessageDialog(null, "FUNCIONA"));
    }
}
