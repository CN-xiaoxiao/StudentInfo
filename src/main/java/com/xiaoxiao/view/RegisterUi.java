/*
 * Created by JFormDesigner on Thu Jun 16 09:48:57 CST 2022
 */

package com.xiaoxiao.view;

import com.xiaoxiao.handler.UserRegisterHandler;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * @author unknown
 */
public class RegisterUi extends JFrame {
    public RegisterUi() {
        initComponents();
    }

    /**
     * 点击注册按钮，执行以下步骤：
     *   1.检查昵称和密码是否为空
     *   2.如果为空，提示什么为空（提示第一个）
     *   3.如果不为空，检查两次密码是否一致
     *   4.如果不一致，提示密码不一致，并清空密码（或者刷新整个界面）
     *   5.如果一致，加密密码后存入数据库，跳转到登录界面
     *   6.删除当前注册界面。
     *
     * @param e
     */
    private void registerButtonMouseClicked(MouseEvent e) {
        // TODO add your code here
        // 获取所有栏的信息
        String username = textField1.getText();
        char[] pwd1 = passwordField1.getPassword();
        char[] pwd2 = passwordField2.getPassword();
        String password1 = new String(pwd1);
        String password2= new String(pwd2);
        // 创建处理类对象，调用注册方法
        UserRegisterHandler userRegisterHandler = new UserRegisterHandler();
        int flag = userRegisterHandler.registerUser(username, password1, password2);
        // 通过返回的错误信息，填写相应方法
        if (flag == UserRegisterHandler.PSD_DIFFERENT) {
            label2.setText("两次输入密码不一致");
        }
        if (flag == UserRegisterHandler.USER_REGISTERED) {
            label2.setText("用户名重复！");
        }
        if (flag == UserRegisterHandler.USERNAME_NONE) {
            label2.setText("用户名为空！");
        }
        if (flag == UserRegisterHandler.PASSWORD_NONE) {
            label2.setText("密码不能为空！");
        }
        // 注册成功，跳转到登录界面并销毁该界面
        if (flag == UserRegisterHandler.SUCCESS) {
            new LoginUi().start();
            this.dispose();
            RegisterUi ui = this;
            ui = null;
            System.out.println("已跳转到登录界面");
        }
    }

    /**
     * 点击重置按钮，
     *   清空昵称、密码的所有信息
     * @param e
     */
    private void cancelButtonMouseClicked(MouseEvent e) {
        // TODO add your code here
        // 清空所有栏
        textField1.setText("");
        passwordField1.setText("");
        passwordField2.setText("");
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        panel1 = new JPanel();
        label1 = new JLabel();
        textField1 = new JTextField();
        panel2 = new JPanel();
        label3 = new JLabel();
        passwordField1 = new JPasswordField();
        panel3 = new JPanel();
        label4 = new JLabel();
        passwordField2 = new JPasswordField();
        panel4 = new JPanel();
        buttonBar = new JPanel();
        panel5 = new JPanel();
        label2 = new JLabel();
        okButton = new JButton();
        cancelButton = new JButton();

        //======== this ========
        setTitle("register");
        setIconImage(new ImageIcon(getClass().getResource("/img/iocn.jpg")).getImage());
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {
                contentPanel.setLayout(new GridLayout(4, 1));

                //======== panel1 ========
                {
                    panel1.setLayout(new GridLayout(1, 2));

                    //---- label1 ----
                    label1.setText("\u6635\u79f0");
                    panel1.add(label1);
                    panel1.add(textField1);
                }
                contentPanel.add(panel1);

                //======== panel2 ========
                {
                    panel2.setLayout(new GridLayout(1, 2));

                    //---- label3 ----
                    label3.setText("\u5bc6\u7801");
                    panel2.add(label3);
                    panel2.add(passwordField1);
                }
                contentPanel.add(panel2);

                //======== panel3 ========
                {
                    panel3.setLayout(new GridLayout(1, 2));

                    //---- label4 ----
                    label4.setText("\u786e\u8ba4\u5bc6\u7801");
                    panel3.add(label4);
                    panel3.add(passwordField2);
                }
                contentPanel.add(panel3);

                //======== panel4 ========
                {
                    panel4.setLayout(new GridLayout(1, 2));
                }
                contentPanel.add(panel4);
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);

            //======== buttonBar ========
            {
                buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
                buttonBar.setLayout(new GridBagLayout());
                ((GridBagLayout)buttonBar.getLayout()).columnWidths = new int[] {0, 85, 80};
                ((GridBagLayout)buttonBar.getLayout()).columnWeights = new double[] {1.0, 0.0, 0.0};

                //======== panel5 ========
                {
                    panel5.setLayout(new FlowLayout(FlowLayout.RIGHT));
                    panel5.add(label2);
                }
                buttonBar.add(panel5, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 5), 0, 0));

                //---- okButton ----
                okButton.setText("\u6ce8\u518c");
                okButton.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        registerButtonMouseClicked(e);
                    }
                });
                buttonBar.add(okButton, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 5), 0, 0));

                //---- cancelButton ----
                cancelButton.setText("\u91cd\u7f6e");
                cancelButton.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        cancelButtonMouseClicked(e);
                    }
                });
                buttonBar.add(cancelButton, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));
            }
            dialogPane.add(buttonBar, BorderLayout.SOUTH);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JPanel panel1;
    private JLabel label1;
    private JTextField textField1;
    private JPanel panel2;
    private JLabel label3;
    private JPasswordField passwordField1;
    private JPanel panel3;
    private JLabel label4;
    private JPasswordField passwordField2;
    private JPanel panel4;
    private JPanel buttonBar;
    private JPanel panel5;
    private JLabel label2;
    private JButton okButton;
    private JButton cancelButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public void start() {
        // 设置窗口大小
        this.setSize(500,400);
        // 设置窗口居中
        this.setLocationRelativeTo(null);

        // 设置关闭窗口结束程序
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
