/*
 * Created by JFormDesigner on Thu Jun 16 09:43:59 CST 2022
 */

package com.xiaoxiao.view;

import com.xiaoxiao.handler.UserLoginHandler;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;


/**
 * @author xiaoxiao
 */
public class LoginUi extends JFrame {

    public LoginUi() {
        initComponents();
    }

    /**
     * 点击登录：执行以下流程：
     *   1.检查账号是否存在
     *   2.密码是否与数据库中的匹配
     *   3.如果匹配，进入学生管理系统界面，同时登录界面消失
     *   4.如果不匹配，则提示账号密码错误。
     * @param e
     */
    private void loginButtonMouseClicked(MouseEvent e) {
        // 获得文本框内容
        String username = textField1.getText();
        char[] pwd = passwordField1.getPassword();
        String password = new String(pwd);
        // 处理登录
        UserLoginHandler userLoginHandler = new UserLoginHandler();
        // TODO 修改flag类型为int，同时设置基础常数代表错误类型
        int flag = userLoginHandler.login(username,password);

        if (flag == UserLoginHandler.SUCCESS) {
            // 进入主界面
            new MainUi().start();
            // 销毁当前界面
            this.dispose();
            LoginUi ui = this;
            ui = null;
        } else {
            label1.setText("账号密码错误！");
        }
    }

    /**
     * 点击注册：执行以下操作：
     *    1.跳转到注册界面
     *    2.清除当前的登录界面
     * @param e
     */
    private void registerButtonMouseClicked(MouseEvent e) {
        new RegisterUi().start();
        this.dispose();
        LoginUi ui = this;
        ui = null;
        System.out.println("已跳转到注册界面");
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        menuBar1 = new JMenuBar();
        menu1 = new JMenu();
        menu2 = new JMenu();
        menu4 = new JMenu();
        menuItem1 = new JMenuItem();
        menu3 = new JMenu();
        dialogPane = new JPanel();
        panel1 = new JPanel();
        contentPanel = new JPanel();
        panel2 = new JPanel();
        label2 = new JLabel();
        panel3 = new JPanel();
        panel8 = new JPanel();
        label4 = new JLabel();
        textField1 = new JTextField();
        panel6 = new JPanel();
        panel4 = new JPanel();
        panel9 = new JPanel();
        label5 = new JLabel();
        passwordField1 = new JPasswordField();
        panel10 = new JPanel();
        panel5 = new JPanel();
        buttonBar2 = new JPanel();
        panel11 = new JPanel();
        label1 = new JLabel();
        okButton2 = new JButton();
        cancelButton2 = new JButton();

        //======== this ========
        setTitle("login");
        setIconImage(new ImageIcon(getClass().getResource("/img/iocn.jpg")).getImage());
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== menuBar1 ========
        {

            //======== menu1 ========
            {
                menu1.setText("\u5e38\u89c4");
            }
            menuBar1.add(menu1);

            //======== menu2 ========
            {
                menu2.setText("\u5e2e\u52a9");

                //======== menu4 ========
                {
                    menu4.setText("\u5fd8\u8bb0\u5bc6\u7801\uff1f");

                    //---- menuItem1 ----
                    menuItem1.setText("\u8bf7\u8054\u7cfb\u5de5\u4f5c\u4eba\u5458\u4fee\u6539\u5bc6\u7801");
                    menu4.add(menuItem1);
                }
                menu2.add(menu4);
            }
            menuBar1.add(menu2);

            //======== menu3 ========
            {
                menu3.setText("\u5173\u4e8e\u6211\u4eec");
            }
            menuBar1.add(menu3);
        }
        setJMenuBar(menuBar1);

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setLayout(new BorderLayout());

            //======== panel1 ========
            {
                panel1.setLayout(new BorderLayout());

                //======== contentPanel ========
                {
                    contentPanel.setLayout(new GridLayout(4, 2));

                    //======== panel2 ========
                    {
                        panel2.setLayout(new FlowLayout());

                        //---- label2 ----
                        label2.setText("\u5b66\u751f\u4fe1\u606f\u7ba1\u7406\u7cfb\u7edf");
                        label2.setFont(new Font("\u534e\u6587\u884c\u6977", Font.PLAIN, label2.getFont().getSize() + 17));
                        panel2.add(label2);
                    }
                    contentPanel.add(panel2);

                    //======== panel3 ========
                    {
                        panel3.setLayout(new GridLayout(1, 4));

                        //======== panel8 ========
                        {
                            panel8.setLayout(new GridLayout());
                        }
                        panel3.add(panel8);

                        //---- label4 ----
                        label4.setText("\u6635\u79f0\uff1a");
                        panel3.add(label4);
                        panel3.add(textField1);

                        //======== panel6 ========
                        {
                            panel6.setLayout(new FlowLayout(FlowLayout.RIGHT));
                        }
                        panel3.add(panel6);
                    }
                    contentPanel.add(panel3);

                    //======== panel4 ========
                    {
                        panel4.setLayout(new GridLayout(1, 4));

                        //======== panel9 ========
                        {
                            panel9.setLayout(new GridLayout());
                        }
                        panel4.add(panel9);

                        //---- label5 ----
                        label5.setText("\u5bc6\u7801\uff1a");
                        panel4.add(label5);
                        panel4.add(passwordField1);

                        //======== panel10 ========
                        {
                            panel10.setLayout(new GridLayout());
                        }
                        panel4.add(panel10);
                    }
                    contentPanel.add(panel4);

                    //======== panel5 ========
                    {
                        panel5.setLayout(new GridLayout(1, 1));
                    }
                    contentPanel.add(panel5);
                }
                panel1.add(contentPanel, BorderLayout.CENTER);
            }
            dialogPane.add(panel1, BorderLayout.CENTER);

            //======== buttonBar2 ========
            {
                buttonBar2.setBorder(new EmptyBorder(12, 0, 0, 0));
                buttonBar2.setLayout(new GridBagLayout());
                ((GridBagLayout)buttonBar2.getLayout()).columnWidths = new int[] {0, 85, 80};
                ((GridBagLayout)buttonBar2.getLayout()).columnWeights = new double[] {1.0, 0.0, 0.0};

                //======== panel11 ========
                {
                    panel11.setLayout(new FlowLayout(FlowLayout.RIGHT));
                    panel11.add(label1);
                }
                buttonBar2.add(panel11, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 5), 0, 0));

                //---- okButton2 ----
                okButton2.setText("\u767b\u5f55");
                okButton2.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        loginButtonMouseClicked(e);
                    }
                });
                buttonBar2.add(okButton2, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 5), 0, 0));

                //---- cancelButton2 ----
                cancelButton2.setText("\u6ce8\u518c");
                cancelButton2.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        registerButtonMouseClicked(e);
                    }
                });
                buttonBar2.add(cancelButton2, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));
            }
            dialogPane.add(buttonBar2, BorderLayout.SOUTH);
        }
        contentPane.add(dialogPane, BorderLayout.NORTH);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JMenuBar menuBar1;
    private JMenu menu1;
    private JMenu menu2;
    private JMenu menu4;
    private JMenuItem menuItem1;
    private JMenu menu3;
    private JPanel dialogPane;
    private JPanel panel1;
    private JPanel contentPanel;
    private JPanel panel2;
    private JLabel label2;
    private JPanel panel3;
    private JPanel panel8;
    private JLabel label4;
    private JTextField textField1;
    private JPanel panel6;
    private JPanel panel4;
    private JPanel panel9;
    private JLabel label5;
    private JPasswordField passwordField1;
    private JPanel panel10;
    private JPanel panel5;
    private JPanel buttonBar2;
    private JPanel panel11;
    private JLabel label1;
    private JButton okButton2;
    private JButton cancelButton2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables


    public void start() {
//        ui.setBounds(50,50,500,300);
        this.setVisible(true);
        // 设置窗口大小
        this.setSize(500,350);
        // 设置窗口居中
        this.setLocationRelativeTo(null);

        // 设置关闭窗口结束程序
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
