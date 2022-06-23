/*
 * Created by JFormDesigner on Sat Jun 18 11:28:35 CST 2022
 */

package com.xiaoxiao.view;

import com.xiaoxiao.handler.ClassHandler;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * @author unknown
 */
public class AddClass extends JFrame {
    public AddClass() {
        initComponents();
    }

    private void okButtonMouseClicked(MouseEvent e) {
        // TODO add your code here
        // 获得文本框内容
        String name = textField1.getText();
        String monitor = textField2.getText();
        ClassHandler classHandler = new ClassHandler();

        int flag = classHandler.addClass(name, monitor);

        if (flag == ClassHandler.CLASS_EXISTENCE) {
            label4.setText("班级以存在！");
        }

        if (flag == ClassHandler.CLASS_NAME_NONE) {
            label4.setText("班级名称为空！");
        }

        if (flag == ClassHandler.MONITOR_IS_NONE) {
            label4.setText("未设置班长！");
        }

        if (flag == ClassHandler.ERROR) {
            label4.setText("未知错误，请检查输入信息!");
        }

        if (flag == ClassHandler.SUCCESS) {
            new Success().setVisible(true);
            this.dispose();
            AddClass ui = this;
            ui = null;
        }
    }

    private void cancelButtonMouseClicked(MouseEvent e) {
        // TODO add your code here
        this.dispose();
        AddClass ui = this;
        ui = null;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        panel4 = new JPanel();
        panel5 = new JPanel();
        label3 = new JLabel();
        panel6 = new JPanel();
        panel10 = new JPanel();
        label1 = new JLabel();
        textField1 = new JTextField();
        panel11 = new JPanel();
        panel7 = new JPanel();
        panel12 = new JPanel();
        label2 = new JLabel();
        textField2 = new JTextField();
        panel13 = new JPanel();
        buttonBar = new JPanel();
        panel1 = new JPanel();
        label4 = new JLabel();
        okButton = new JButton();
        cancelButton = new JButton();

        //======== this ========
        setTitle("\u6b63\u5728\u6dfb\u52a0\u73ed\u7ea7");
        setIconImage(new ImageIcon(getClass().getResource("/img/iocn.jpg")).getImage());
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {
                contentPanel.setLayout(new GridLayout());

                //======== panel4 ========
                {
                    panel4.setLayout(new GridLayout(4, 0));

                    //======== panel5 ========
                    {
                        panel5.setLayout(new FlowLayout());

                        //---- label3 ----
                        label3.setText("\u6dfb\u52a0\u73ed\u7ea7");
                        label3.setFont(new Font("\u6977\u4f53", Font.BOLD, 25));
                        panel5.add(label3);
                    }
                    panel4.add(panel5);

                    //======== panel6 ========
                    {
                        panel6.setLayout(new GridLayout());

                        //======== panel10 ========
                        {
                            panel10.setLayout(new GridLayout());
                        }
                        panel6.add(panel10);

                        //---- label1 ----
                        label1.setText("\u73ed\u7ea7\u540d\u79f0");
                        panel6.add(label1);
                        panel6.add(textField1);

                        //======== panel11 ========
                        {
                            panel11.setLayout(new GridLayout());
                        }
                        panel6.add(panel11);
                    }
                    panel4.add(panel6);

                    //======== panel7 ========
                    {
                        panel7.setLayout(new GridLayout(1, 4));

                        //======== panel12 ========
                        {
                            panel12.setLayout(new GridLayout());
                        }
                        panel7.add(panel12);

                        //---- label2 ----
                        label2.setText("\u73ed\u957f\u5b66\u53f7");
                        panel7.add(label2);
                        panel7.add(textField2);

                        //======== panel13 ========
                        {
                            panel13.setLayout(new GridLayout());
                        }
                        panel7.add(panel13);
                    }
                    panel4.add(panel7);
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

                //======== panel1 ========
                {
                    panel1.setLayout(new FlowLayout(FlowLayout.RIGHT));
                    panel1.add(label4);
                }
                buttonBar.add(panel1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 5), 0, 0));

                //---- okButton ----
                okButton.setText("\u6dfb\u52a0");
                okButton.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        okButtonMouseClicked(e);
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
    private JPanel panel4;
    private JPanel panel5;
    private JLabel label3;
    private JPanel panel6;
    private JPanel panel10;
    private JLabel label1;
    private JTextField textField1;
    private JPanel panel11;
    private JPanel panel7;
    private JPanel panel12;
    private JLabel label2;
    private JTextField textField2;
    private JPanel panel13;
    private JPanel buttonBar;
    private JPanel panel1;
    private JLabel label4;
    private JButton okButton;
    private JButton cancelButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public void start() {
//        AddClass ui = new AddClass();
        this.setSize(500,340);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
