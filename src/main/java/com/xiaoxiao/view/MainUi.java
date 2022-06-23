/*
 * Created by JFormDesigner on Sat Jun 18 09:52:31 CST 2022
 */

package com.xiaoxiao.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author unknown
 */
public class MainUi extends JFrame {
    public MainUi() {
        initComponents();
    }

    private void addClassMouseClicked(MouseEvent e) {
        // TODO add your code here
        new AddClass().start();
    }

    private void classListMouseClicked(MouseEvent e) {
        // TODO add your code here
        new ClassList().start();
    }

    private void addStudentMouseClicked(MouseEvent e) {
        // TODO add your code here
        new AddStudent().start();
    }

    private void rollUpdateMouseClicked(MouseEvent e) {
        // TODO add your code here
        new UpdateStudentRoll().start();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        menuBar1 = new JMenuBar();
        menu1 = new JMenu();
        menu2 = new JMenu();
        button2 = new JButton();
        button3 = new JButton();
        menu3 = new JMenu();
        button4 = new JButton();
        button5 = new JButton();
        button8 = new JButton();
        menu4 = new JMenu();
        button1 = new JButton();
        menu5 = new JMenu();
        button6 = new JButton();
        button7 = new JButton();
        menu6 = new JMenu();
        panel1 = new JPanel();
        panel2 = new JPanel();
        label3 = new JLabel();

        //======== this ========
        setIconImage(new ImageIcon(getClass().getResource("/img/iocn.jpg")).getImage());
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("\u5b66\u751f\u4fe1\u606f\u7ba1\u7406\u7cfb\u7edf");
        Container contentPane = getContentPane();
        contentPane.setLayout(new GridLayout(1, 1));

        //======== menuBar1 ========
        {

            //======== menu1 ========
            {
                menu1.setText("\u7cfb\u7edf\u7ba1\u7406");
            }
            menuBar1.add(menu1);

            //======== menu2 ========
            {
                menu2.setText("\u73ed\u7ea7\u7ba1\u7406");

                //---- button2 ----
                button2.setText("\u6dfb\u52a0\u73ed\u7ea7");
                button2.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        addClassMouseClicked(e);
                    }
                });
                menu2.add(button2);

                //---- button3 ----
                button3.setText("\u73ed\u7ea7\u5217\u8868");
                button3.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        classListMouseClicked(e);
                    }
                });
                menu2.add(button3);
            }
            menuBar1.add(menu2);

            //======== menu3 ========
            {
                menu3.setText("\u5b66\u751f\u7ba1\u7406");

                //---- button4 ----
                button4.setText("\u6dfb\u52a0\u5b66\u751f");
                button4.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        addStudentMouseClicked(e);
                    }
                });
                menu3.add(button4);

                //---- button5 ----
                button5.setText("\u5b66\u7c4d\u4fee\u6539");
                button5.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        rollUpdateMouseClicked(e);
                    }
                });
                menu3.add(button5);

                //---- button8 ----
                button8.setText("\u4fe1\u606f\u7ba1\u7406");
                menu3.add(button8);
            }
            menuBar1.add(menu3);

            //======== menu4 ========
            {
                menu4.setText("\u5b66\u9662\u7ba1\u7406");

                //---- button1 ----
                button1.setText("\u6dfb\u52a0\u5b66\u9662");
                menu4.add(button1);
            }
            menuBar1.add(menu4);

            //======== menu5 ========
            {
                menu5.setText("\u5956\u8d4f\u7ba1\u7406");

                //---- button6 ----
                button6.setText("\u5956\u52b1\u7ba1\u7406");
                menu5.add(button6);

                //---- button7 ----
                button7.setText("\u5904\u5206\u7ba1\u7406");
                menu5.add(button7);
            }
            menuBar1.add(menu5);

            //======== menu6 ========
            {
                menu6.setText("\u5173\u4e8e");
            }
            menuBar1.add(menu6);
        }
        setJMenuBar(menuBar1);

        //======== panel1 ========
        {
            panel1.setLayout(new GridLayout());

            //======== panel2 ========
            {
                panel2.setLayout(new GridLayout());

                //---- label3 ----
                label3.setIcon(new ImageIcon(getClass().getResource("/img/\u80cc\u666f\u56fe\u7247.png")));
                label3.setHorizontalAlignment(SwingConstants.CENTER);
                panel2.add(label3);
            }
            panel1.add(panel2);
        }
        contentPane.add(panel1);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JMenuBar menuBar1;
    private JMenu menu1;
    private JMenu menu2;
    private JButton button2;
    private JButton button3;
    private JMenu menu3;
    private JButton button4;
    private JButton button5;
    private JButton button8;
    private JMenu menu4;
    private JButton button1;
    private JMenu menu5;
    private JButton button6;
    private JButton button7;
    private JMenu menu6;
    private JPanel panel1;
    private JPanel panel2;
    private JLabel label3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public void start() {
//        MainUi ui = new MainUi();
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;
        this.setBounds(0,0, width, height);
        this.setVisible(true);
    }
}
