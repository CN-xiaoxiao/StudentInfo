/*
 * Created by JFormDesigner on Thu Jun 23 17:23:35 CST 2022
 */

package com.xiaoxiao.view;

import java.awt.event.*;
import com.xiaoxiao.entity.Department;
import com.xiaoxiao.entity.StudentClass;
import com.xiaoxiao.handler.ClassHandler;
import com.xiaoxiao.handler.DepartmentHandler;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * @author unknown
 */
public class DepartmentList extends JFrame {
    public DepartmentList() {
        initComponents();
    }

    private void thisWindowClosed(WindowEvent e) {
        // TODO add your code here
        System.gc();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        table1 = new JTable();

        //======== this ========
        setTitle("\u5b66\u9662\u5217\u8868");
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
        scrollPane1.setBounds(0, 0, 540, 310);

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
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public void start() {

        this.setVisible(true);
        DefaultTableModel model = new DefaultTableModel();
        this.table1.setModel(model);
        Vector row = new Vector();
        Vector data = new Vector();
        Vector names = new Vector();
        ArrayList<Department> list = (ArrayList<Department>) new DepartmentHandler().getAllDepartments();

        for (Department tem : list) {
            Vector hang = new Vector();
            hang.add(tem.getId());
            hang.add(tem.getName());
            data.add(hang);
        }

        names.add("学院编号");
        names.add("学院名称");

        model.setDataVector(data, names);
    }
}
