/*
 * Created by JFormDesigner on Thu Jun 23 17:53:49 CST 2022
 */

package com.xiaoxiao.view;

import com.xiaoxiao.entity.Student;
import com.xiaoxiao.handler.StudentHandler;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * @author unknown
 */
public class UpDateStudent extends JFrame {
    public UpDateStudent() {
        initComponents();
    }

    private void selectButtonMouseClicked(MouseEvent e) {
        // TODO add your code here
        // 获取学号
        String temp = textField1.getText();
        int id = -1;
        if ("".equals(temp)) {
            label5.setText("学号为空！");
            return;
        } else {
            id = Integer.parseInt(temp);
        }

        // 通过学号查找到该学号的学生
        StudentHandler studentHandler = new StudentHandler();
        Student student = studentHandler.getStudent(id);

        if (student == null) {
            label5.setText("学生不存在！");
        } else {
            label5.setText("学生姓名：" + student.getName());
        }

    }

    private void upDateButtonMouseClicked(MouseEvent e) {
        // TODO add your code here
        // 获取学号
        String temp = textField1.getText();
        int id = -1;
        if ("".equals(temp)) {
            label5.setText("学号为空！");
            return;
        } else {
            id = Integer.parseInt(temp);
        }

        // 通过学号查找到该学号的学生
        StudentHandler studentHandler = new StudentHandler();
        Student student = studentHandler.getStudent(id);

        if (student == null) {
            return;
        }
        // 学生存在
        // 获取文本信息
        String name = textField2.getText();
        String birthday = textField3.getText();
        String nativePlace = textField4.getText();
        if (!("".equals(name))) {
            student.setName(name);
        }
        if (!("".equals(birthday))) {
            student.setBirthday(birthday);
        }
        if (!("".equals(nativePlace))) {
            student.setNativePlace(nativePlace);
        }

        if (studentHandler.upDate(student) >= 1) {
            new Success().setVisible(true);
            this.dispose();
            System.gc();
        }
    }

    private void cancelButtonMouseClicked(MouseEvent e) {
        // TODO add your code here
        this.dispose();
        System.gc();
    }

    private void thisWindowClosed(WindowEvent e) {
        // TODO add your code here
        System.gc();
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        label1 = new JLabel();
        textField1 = new JTextField();
        button1 = new JButton();
        label2 = new JLabel();
        textField2 = new JTextField();
        label3 = new JLabel();
        textField3 = new JTextField();
        label4 = new JLabel();
        textField4 = new JTextField();
        label5 = new JLabel();
        buttonBar = new JPanel();
        okButton = new JButton();
        cancelButton = new JButton();

        //======== this ========
        setTitle("\u6b63\u5728\u66f4\u6539\u5b66\u751f\u4fe1\u606f");
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                thisWindowClosed(e);
            }
        });
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {
                contentPanel.setLayout(null);

                //---- label1 ----
                label1.setText("\u5b66\u751f\u5b66\u53f7");
                contentPanel.add(label1);
                label1.setBounds(35, 225, 60, 25);
                contentPanel.add(textField1);
                textField1.setBounds(90, 225, 105, 30);

                //---- button1 ----
                button1.setText("\u67e5\u8be2");
                button1.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        selectButtonMouseClicked(e);
                    }
                });
                contentPanel.add(button1);
                button1.setBounds(new Rectangle(new Point(225, 225), button1.getPreferredSize()));

                //---- label2 ----
                label2.setText("\u5b66\u751f\u59d3\u540d");
                contentPanel.add(label2);
                label2.setBounds(30, 15, 60, 20);
                contentPanel.add(textField2);
                textField2.setBounds(90, 10, 85, 30);

                //---- label3 ----
                label3.setText("\u751f\u65e5");
                contentPanel.add(label3);
                label3.setBounds(50, 45, 35, 20);
                contentPanel.add(textField3);
                textField3.setBounds(90, 40, 85, 30);

                //---- label4 ----
                label4.setText("\u7c4d\u8d2f");
                contentPanel.add(label4);
                label4.setBounds(50, 75, 30, label4.getPreferredSize().height);
                contentPanel.add(textField4);
                textField4.setBounds(90, 75, 95, 30);
                contentPanel.add(label5);
                label5.setBounds(40, 265, 120, 25);

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < contentPanel.getComponentCount(); i++) {
                        Rectangle bounds = contentPanel.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = contentPanel.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    contentPanel.setMinimumSize(preferredSize);
                    contentPanel.setPreferredSize(preferredSize);
                }
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);

            //======== buttonBar ========
            {
                buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
                buttonBar.setLayout(new GridBagLayout());
                ((GridBagLayout)buttonBar.getLayout()).columnWidths = new int[] {0, 85, 80};
                ((GridBagLayout)buttonBar.getLayout()).columnWeights = new double[] {1.0, 0.0, 0.0};

                //---- okButton ----
                okButton.setText("\u4fee\u6539");
                okButton.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        upDateButtonMouseClicked(e);
                    }
                });
                buttonBar.add(okButton, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 5), 0, 0));

                //---- cancelButton ----
                cancelButton.setText("\u53d6\u6d88");
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
    private JLabel label1;
    private JTextField textField1;
    private JButton button1;
    private JLabel label2;
    private JTextField textField2;
    private JLabel label3;
    private JTextField textField3;
    private JLabel label4;
    private JTextField textField4;
    private JLabel label5;
    private JPanel buttonBar;
    private JButton okButton;
    private JButton cancelButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public void start() {
        this.setVisible(true);
        // 设置窗口大小
        this.setSize(670,450);
        // 设置窗口居中
        this.setLocationRelativeTo(null);
    }
}
