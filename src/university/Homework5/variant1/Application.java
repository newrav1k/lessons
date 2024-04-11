package university.Homework5.variant1;

import javax.swing.*;
import java.awt.event.ActionListener;

public class Application {
    public static void main(String[] args) throws InterruptedException {
        JFrame jFrame = new JFrame("Exit button");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(50, 150);
        jFrame.setLocationRelativeTo(null);
        JButton jButton = new JButton("Press");

        ActionListener listener = e -> System.exit(0);
        jButton.addActionListener(listener);
        jFrame.getContentPane().add(jButton);
        jFrame.setVisible(true);

        Thread thread1 = new MyThread(1);
        Thread thread2 = new MyThread(2);
        Thread thread3 = new MyThread(3);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}