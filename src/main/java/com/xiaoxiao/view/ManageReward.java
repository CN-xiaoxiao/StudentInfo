/*
 * Created by JFormDesigner on Thu Jun 23 21:30:38 CST 2022
 */

package com.xiaoxiao.view;

import com.xiaoxiao.entity.Reward;
import com.xiaoxiao.entity.Student;
import com.xiaoxiao.handler.RewardHandler;
import com.xiaoxiao.handler.StudentHandler;

import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import javax.swing.*;
import javax.swing.border.*;

/**
 * @author unknown
 */
public class ManageReward extends JFrame {
    public ManageReward() {
        initComponents();
    }

    private void selectButtonMouseClicked(MouseEvent e) {
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
        RewardHandler rewardHandler = new RewardHandler();
        int code = rewardHandler.getCodeByDescription(description);
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        int flag = rewardHandler.addReward(new Reward().setStudentId(id).setLevels(code).setDescription(description).setRecTime(formatter.format(date)));

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
        comboBox1 = new JComboBox();
        label3 = new JLabel();
        buttonBar = new JPanel();
        okButton = new JButton();
        cancelButton = new JButton();

        //======== this ========
        setTitle("\u6b63\u5728\u7ba1\u7406\u5b66\u751f\u5956\u8d4f");
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
                label1.setBounds(40, 15, 35, label1.getPreferredSize().height);
                contentPanel.add(textField1);
                textField1.setBounds(75, 10, 105, 25);

                //---- button1 ----
                button1.setText("\u67e5\u8be2");
                button1.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        selectButtonMouseClicked(e);
                    }
                });
                contentPanel.add(button1);
                button1.setBounds(new Rectangle(new Point(215, 10), button1.getPreferredSize()));
                contentPanel.add(label2);
                label2.setBounds(40, 50, 445, 30);
                contentPanel.add(comboBox1);
                comboBox1.setBounds(130, 100, 150, 30);

                //---- label3 ----
                label3.setText("\u8bf7\u9009\u62e9\u5956\u91d1\u7c7b\u578b");
                contentPanel.add(label3);
                label3.setBounds(30, 105, 95, label3.getPreferredSize().height);

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
                okButton.setText("\u786e\u5b9a");
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
    private JComboBox comboBox1;
    private JLabel label3;
    private JPanel buttonBar;
    private JButton okButton;
    private JButton cancelButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    public void start() {
        this.setSize(530,375);
        this.setVisible(true);

        // 添加奖学金类型进入下拉框中
        // 获取下拉框类型
        HashMap levels = new HashMap();
        // 写死算了，等知道怎么把查询结果保存到集合中再改
        RewardHandler rewardHandler = new RewardHandler();
        levels.put(0, rewardHandler.getDescriptionByCode(0));
        levels.put(1, rewardHandler.getDescriptionByCode(1));
        levels.put(2, rewardHandler.getDescriptionByCode(2));
        levels.put(3, rewardHandler.getDescriptionByCode(3));
        levels.put(4, rewardHandler.getDescriptionByCode(4));
        levels.put(5, rewardHandler.getDescriptionByCode(5));
        levels.put(6, rewardHandler.getDescriptionByCode(6));

        Iterator it = levels.keySet().iterator();
        while (it.hasNext()) {
            // 遍历 Map
            Object key = it.next();
            Object val = levels.get(key);
            this.comboBox1.addItem(val);
        }
    }
}
