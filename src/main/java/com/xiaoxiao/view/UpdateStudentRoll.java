/*
 * Created by JFormDesigner on Thu Jun 23 11:27:00 CST 2022
 */

package com.xiaoxiao.view;

import com.xiaoxiao.entity.Change;
import com.xiaoxiao.entity.StudentClass;
import com.xiaoxiao.handler.ChangeHandler;
import com.xiaoxiao.handler.ClassHandler;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;

/**
 * @author unknown
 */
public class UpdateStudentRoll extends JFrame {
    public UpdateStudentRoll() {
        initComponents();
    }

    private void changeButtonMouseClicked(MouseEvent e) {
        // TODO add your code here
        // 获取输入的学号
        int id1 = Integer.parseInt(textField1.getText());
        int id2 = Integer.parseInt(textField2.getText());
        if (id1 != id2) {
            label3.setText("两次学号不一致！");
            return;
        }
        if ("".equals(textField1.getText())) {
            label3.setText("学号为空!");
            return;
        }

        // 获取选中的修改选项
        int selected = -1;
        if (radioButton1.isSelected()) {
            selected = 0;
        } else if (radioButton2.isSelected()) {
            selected = 1;
        } else if (radioButton3.isSelected()) {
            selected = 2;
        } else if (radioButton4.isSelected()) {
            selected = 3;
        } else if (radioButton5.isSelected()) {
            selected = 4;
        }

        // 调用处理类进行处理
        ChangeHandler changeHandler = new ChangeHandler();
        int flag = changeHandler.changeRoll(id1, selected);
        if (flag == 1) {
            textField1.setText("");
            textField2.setText("");
            this.dispose();
            System.gc();
            new Success().setVisible(true);
        }
    }

    private void thisWindowClosed(WindowEvent e) {
        // TODO add your code here
        System.gc();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        panel1 = new JPanel();
        radioButton1 = new JRadioButton();
        radioButton2 = new JRadioButton();
        radioButton3 = new JRadioButton();
        radioButton4 = new JRadioButton();
        radioButton5 = new JRadioButton();
        label1 = new JLabel();
        textField1 = new JTextField();
        label2 = new JLabel();
        textField2 = new JTextField();
        buttonBar = new JPanel();
        panel2 = new JPanel();
        panel4 = new JPanel();
        panel3 = new JPanel();
        panel6 = new JPanel();
        panel5 = new JPanel();
        label3 = new JLabel();
        okButton = new JButton();

        //======== this ========
        setTitle("\u6b63\u5728\u4fee\u6539\u5b66\u751f\u5b66\u7c4d");
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

                //======== scrollPane1 ========
                {
                    scrollPane1.setViewportView(table1);
                }
                contentPanel.add(scrollPane1);
                scrollPane1.setBounds(0, 0, 585, 245);

                //======== panel1 ========
                {
                    panel1.setLayout(null);

                    //---- radioButton1 ----
                    radioButton1.setText("\u8f6c\u7cfb");
                    panel1.add(radioButton1);
                    radioButton1.setBounds(360, 20, 70, radioButton1.getPreferredSize().height);

                    //---- radioButton2 ----
                    radioButton2.setText("\u4f11\u5b66");
                    panel1.add(radioButton2);
                    radioButton2.setBounds(440, 20, 70, radioButton2.getPreferredSize().height);

                    //---- radioButton3 ----
                    radioButton3.setText("\u590d\u5b66");
                    panel1.add(radioButton3);
                    radioButton3.setBounds(new Rectangle(new Point(520, 20), radioButton3.getPreferredSize()));

                    //---- radioButton4 ----
                    radioButton4.setText("\u9000\u5b66");
                    panel1.add(radioButton4);
                    radioButton4.setBounds(new Rectangle(new Point(360, 55), radioButton4.getPreferredSize()));

                    //---- radioButton5 ----
                    radioButton5.setText("\u6bd5\u4e1a");
                    panel1.add(radioButton5);
                    radioButton5.setBounds(new Rectangle(new Point(435, 55), radioButton5.getPreferredSize()));

                    //---- label1 ----
                    label1.setText("\u5b66\u751f\u5b66\u53f7");
                    panel1.add(label1);
                    label1.setBounds(new Rectangle(new Point(70, 20), label1.getPreferredSize()));
                    panel1.add(textField1);
                    textField1.setBounds(135, 15, 110, 25);

                    //---- label2 ----
                    label2.setText("\u518d\u6b21\u8f93\u5165\u5b66\u751f\u5b66\u53f7");
                    panel1.add(label2);
                    label2.setBounds(new Rectangle(new Point(25, 40), label2.getPreferredSize()));
                    panel1.add(textField2);
                    textField2.setBounds(135, 40, 110, 25);

                    {
                        // compute preferred size
                        Dimension preferredSize = new Dimension();
                        for(int i = 0; i < panel1.getComponentCount(); i++) {
                            Rectangle bounds = panel1.getComponent(i).getBounds();
                            preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                            preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                        }
                        Insets insets = panel1.getInsets();
                        preferredSize.width += insets.right;
                        preferredSize.height += insets.bottom;
                        panel1.setMinimumSize(preferredSize);
                        panel1.setPreferredSize(preferredSize);
                    }
                }
                contentPanel.add(panel1);
                panel1.setBounds(0, 245, 585, 100);

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
                ((GridBagLayout)buttonBar.getLayout()).columnWidths = new int[] {0, 80};
                ((GridBagLayout)buttonBar.getLayout()).columnWeights = new double[] {1.0, 0.0};

                //======== panel2 ========
                {
                    panel2.setLayout(new GridLayout(1, 4));

                    //======== panel4 ========
                    {
                        panel4.setLayout(new GridLayout());
                    }
                    panel2.add(panel4);

                    //======== panel3 ========
                    {
                        panel3.setLayout(new GridLayout());

                        //======== panel6 ========
                        {
                            panel6.setLayout(new GridLayout());
                        }
                        panel3.add(panel6);

                        //======== panel5 ========
                        {
                            panel5.setLayout(new GridLayout());
                            panel5.add(label3);
                        }
                        panel3.add(panel5);
                    }
                    panel2.add(panel3);
                }
                buttonBar.add(panel2, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 5), 0, 0));

                //---- okButton ----
                okButton.setText("\u4fee\u6539");
                okButton.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        changeButtonMouseClicked(e);
                    }
                });
                buttonBar.add(okButton, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
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
    private JScrollPane scrollPane1;
    private JTable table1;
    private JPanel panel1;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JRadioButton radioButton3;
    private JRadioButton radioButton4;
    private JRadioButton radioButton5;
    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JTextField textField2;
    private JPanel buttonBar;
    private JPanel panel2;
    private JPanel panel4;
    private JPanel panel3;
    private JPanel panel6;
    private JPanel panel5;
    private JLabel label3;
    private JButton okButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public void start() {
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        ButtonGroup group = new ButtonGroup();
        group.add(this.radioButton1);
        group.add(this.radioButton2);
        group.add(this.radioButton3);
        group.add(this.radioButton4);
        group.add(this.radioButton5);
        this.showChange();
    }

    public void showChange() {
        ArrayList<Change> list = new ChangeHandler().getAllChanges();
        DefaultTableModel model = new DefaultTableModel();
        this.table1.setModel(model);
        Vector row = new Vector();
        Vector data = new Vector();
        Vector names = new Vector();

        for (Change tem : list) {
            Vector hang = new Vector();
            hang.add(tem.getId());
            hang.add(tem.getStudentId());
            hang.add(tem.getChangeCode());
            hang.add(tem.getRecTime());
            hang.add(tem.getDescription());
            data.add(hang);
        }

        names.add("操作编号");
        names.add("学生学号");
        names.add("改变代码");
        names.add("操作时间");
        names.add("描述");

        model.setDataVector(data, names);
    }
}
