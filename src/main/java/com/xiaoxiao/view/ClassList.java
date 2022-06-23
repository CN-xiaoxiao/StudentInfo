/*
 * Created by JFormDesigner on Tue Jun 21 21:22:30 CST 2022
 */

package com.xiaoxiao.view;

import java.awt.event.*;
import com.xiaoxiao.entity.StudentClass;
import com.xiaoxiao.handler.ClassHandler;

import java.awt.*;
import java.util.List;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * @author unknown
 */
public class ClassList extends JFrame {

    Vector row;
    Vector data;
    Vector names;
    DefaultTableModel model;

    public ClassList() {
        initComponents();
    }

    private void selectButtonMouseClicked(MouseEvent e) {
        // TODO add your code here
        // 获取文本框的内容
        String text = textField1.getText();
        if ("".equals(text)) {
            System.out.println("输入了空白");

            List<StudentClass> list = new ClassHandler().getAllClass();
            // 清空所有表格内容
            ((DefaultTableModel)table1.getModel()).getDataVector().clear();
            // 填入数据
            Vector data = ((DefaultTableModel)table1.getModel()).getDataVector();
            for (StudentClass sc : list) {
                Vector tep = new Vector();
                tep.add(sc.getId());
                tep.add(sc.getName());
                tep.add(sc.getMonitor());
                data.add(tep);
            }

            return;
        }
        // 查询是否有该文本的班级
        StudentClass studentClass = new ClassHandler().getClassForClassName(text);

        if (studentClass == null) {
            System.out.println("查询为空!");
            return;
        }

        // 清空所有表格内容
        ((DefaultTableModel)table1.getModel()).getDataVector().clear();
        // 填入数据
        Vector data = ((DefaultTableModel)table1.getModel()).getDataVector();

        Vector hang = new Vector();
        hang.add(studentClass.getId());
        hang.add(studentClass.getName());
        hang.add(studentClass.getMonitor());
        data.add(hang);
        System.out.println("添加成功!");

    }

    private void thisWindowClosed(WindowEvent e) {
        // TODO add your code here
        ClassList ui = this;
        ui = null;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        panel1 = new JPanel();
        label1 = new JLabel();
        textField1 = new JTextField();
        button1 = new JButton();

        //======== this ========
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                thisWindowClosed(e);
            }
        });
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(0, 0, 710, 265);

        //======== panel1 ========
        {
            panel1.setMinimumSize(new Dimension(710, 160));
            panel1.setMaximumSize(new Dimension(710, 160));
            panel1.setLayout(null);

            //---- label1 ----
            label1.setText("\u73ed\u7ea7\u540d\u79f0");
            panel1.add(label1);
            label1.setBounds(35, 35, 55, 15);

            //---- textField1 ----
            textField1.setMaximumSize(new Dimension(100, 30));
            textField1.setMinimumSize(new Dimension(100, 30));
            panel1.add(textField1);
            textField1.setBounds(105, 30, 100, 30);

            //---- button1 ----
            button1.setText("\u67e5\u8be2");
            button1.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    selectButtonMouseClicked(e);
                }
            });
            panel1.add(button1);
            button1.setBounds(new Rectangle(new Point(290, 30), button1.getPreferredSize()));

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
        contentPane.add(panel1);
        panel1.setBounds(0, 265, 710, 160);

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane1;
    private JTable table1;
    private JPanel panel1;
    private JLabel label1;
    private JTextField textField1;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public JScrollPane getScrollPane1() {
        return scrollPane1;
    }

    public JTable getTable1() {
        return table1;
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public void start() {
        this.setSize(710,455);
        this.setVisible(true);
        DefaultTableModel model = new DefaultTableModel();
        this.table1.setModel(model);
        Vector row = new Vector();
        Vector data = new Vector();
        Vector names = new Vector();

        List<StudentClass> list = new ClassHandler().getAllClass();

        for (StudentClass tem : list) {
            Vector hang = new Vector();
            hang.add(tem.getId());
            hang.add(tem.getName());
            hang.add(tem.getMonitor());
            data.add(hang);
        }

        names.add("班级编号");
        names.add("班级名称");
        names.add("班长学号");

        model.setDataVector(data, names);
    }
}
