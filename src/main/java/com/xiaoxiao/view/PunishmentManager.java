/*
 * Created by JFormDesigner on Fri Jun 24 00:40:08 CST 2022
 */

package com.xiaoxiao.view;

import com.xiaoxiao.entity.Punishment;
import com.xiaoxiao.entity.Reward;
import com.xiaoxiao.entity.Student;
import com.xiaoxiao.handler.PunishmentHandler;
import com.xiaoxiao.handler.RewardHandler;
import com.xiaoxiao.handler.StudentHandler;

import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import javax.swing.*;
import javax.swing.border.*;

/**
 * @author unknown
 */
public class PunishmentManager extends JFrame {
    public PunishmentManager() {
        initComponents();
    }

    private void selectMouseClicked(MouseEvent e) {
        // TODO add your code here
        // 获取学号
        String temp = textField1.getText();
        if ("".equals(temp)) {
            label2.setText("学号为空！");
            return;
        }
        int id = Integer.parseInt(temp);

        // 通过id查找学生
        StudentHandler studentHandler = new StudentHandler();
        Student student = studentHandler.getStudent(id);
        // 显示数据到界面上
        label2.setText("姓名：" + student.getName() + " 性别：" + ("M".equals(student.getSex()) ? "男" : "女") +
                " 生日：" + student.getBirthday() + " 籍贯：" + student.getNativePlace());
    }

    private void cancelButtonMouseClicked(MouseEvent e) {
        // TODO add your code here
        this.dispose();
        System.gc();
    }

    private void okButtonMouseClicked(MouseEvent e) {
        // TODO add your code here
        // 获取学号
        String temp = textField1.getText();
        if ("".equals(temp)) {
            label2.setText("学号为空！");
            return;
        }
        int id = Integer.parseInt(temp);

        // 获得下拉框的内容
        String description = (String) comboBox1.getSelectedItem();
        PunishmentHandler punishmentHandler = new PunishmentHandler();
        int code = punishmentHandler.getCodeByDescription(description);
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        // 获取是否生效
        String enable = null;
        if (radioButton1.isSelected()) {
            enable = "T";
        } else {
            enable = "F";
        }

        int flag = punishmentHandler.addPunish(new Punishment().setStudentId(id).setRecTime(formatter.format(date)).setDescription(description).setEnable(enable).setLevels(code));

        if (flag == 1) {
            this.dispose();
            new Success().setVisible(true);
            System.gc();
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        label1 = new JLabel();
        textField1 = new JTextField();
        button1 = new JButton();
        label2 = new JLabel();
        label3 = new JLabel();
        comboBox1 = new JComboBox();
        label4 = new JLabel();
        radioButton1 = new JRadioButton();
        radioButton2 = new JRadioButton();
        buttonBar = new JPanel();
        okButton = new JButton();
        cancelButton = new JButton();

        //======== this ========
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
                label1.setText("\u5b66\u53f7");
                contentPanel.add(label1);
                label1.setBounds(35, 25, 40, 25);
                contentPanel.add(textField1);
                textField1.setBounds(80, 25, 100, 30);

                //---- button1 ----
                button1.setText("\u67e5\u8be2");
                button1.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        selectMouseClicked(e);
                    }
                });
                contentPanel.add(button1);
                button1.setBounds(new Rectangle(new Point(210, 25), button1.getPreferredSize()));
                contentPanel.add(label2);
                label2.setBounds(30, 60, 470, 25);

                //---- label3 ----
                label3.setText("\u5904\u7f5a\u7c7b\u578b");
                contentPanel.add(label3);
                label3.setBounds(30, 100, 55, 20);
                contentPanel.add(comboBox1);
                comboBox1.setBounds(105, 95, 90, 30);

                //---- label4 ----
                label4.setText("\u662f\u5426\u751f\u6548");
                contentPanel.add(label4);
                label4.setBounds(new Rectangle(new Point(30, 160), label4.getPreferredSize()));

                //---- radioButton1 ----
                radioButton1.setText("\u662f");
                contentPanel.add(radioButton1);
                radioButton1.setBounds(new Rectangle(new Point(110, 155), radioButton1.getPreferredSize()));

                //---- radioButton2 ----
                radioButton2.setText("\u5426");
                contentPanel.add(radioButton2);
                radioButton2.setBounds(new Rectangle(new Point(165, 155), radioButton2.getPreferredSize()));

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
                okButton.setText("\u786e\u8ba4");
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
    private JLabel label1;
    private JTextField textField1;
    private JButton button1;
    private JLabel label2;
    private JLabel label3;
    private JComboBox comboBox1;
    private JLabel label4;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JPanel buttonBar;
    private JButton okButton;
    private JButton cancelButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    public void start() {
        this.setSize(560,335);
        this.setVisible(true);

        // 获取下拉框类型
        HashMap levels = new HashMap();
        // 写死算了，等知道怎么把查询结果保存到集合中再改
        PunishmentHandler punishmentHandler = new PunishmentHandler();
        levels.put(0, punishmentHandler.getDescriptionByCode(0));
        levels.put(1, punishmentHandler.getDescriptionByCode(1));
        levels.put(2, punishmentHandler.getDescriptionByCode(2));
        levels.put(3, punishmentHandler.getDescriptionByCode(3));
        levels.put(4, punishmentHandler.getDescriptionByCode(4));

        Iterator it = levels.keySet().iterator();
        while (it.hasNext()) {
            // 遍历 Map
            Object key = it.next();
            Object val = levels.get(key);
            this.comboBox1.addItem(val);
        }

        ButtonGroup group = new ButtonGroup();
        group.add(this.radioButton1);
        group.add(this.radioButton2);
    }
}
