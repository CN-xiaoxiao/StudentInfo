/*
 * Created by JFormDesigner on Wed Jun 22 10:46:35 CST 2022
 */

package com.xiaoxiao.view;

import java.awt.event.*;
import com.xiaoxiao.entity.Department;
import com.xiaoxiao.entity.Student;
import com.xiaoxiao.handler.DepartmentHandler;
import com.xiaoxiao.handler.StudentHandler;

import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;
import javax.swing.*;
import javax.swing.border.*;

/**
 * @author unknown
 */
public class AddStudent extends JFrame {
    public AddStudent() {
        initComponents();
    }

    /**
     * 这里是真的忘记怎么把之前不要的对象给删掉了，是这样的，我们创建了一个类，这个类继承了JFrame，并
     * 产生了一个界面，但是我们使用，jframe.dispose()的时候，只是把这个窗口的资源释放了，而我们创建
     * 的类对象还是存在的，虽然感觉Java有自动回收机制，但是我在测试的时候会出现很卡的情况，因此，我想
     * 手动回收这个类，但是我又忘记怎么获取当前类对象，寄。希望测试的时候别蹦。太久没写代码了，生疏了。
     * @param e
     */
    private void thisWindowClosed(WindowEvent e) {
        // TODO add your code here
        System.gc();
    }

    /**
     * 添加学生信息，具体与添加班级什么的类似，首先获取文本框的内容，然后传入到处理类
     * @param e
     */
    private void addStudentOkButtonMouseClicked(MouseEvent e) {
        // TODO add your code here
        // 获取学号
        int id = Integer.parseInt(textField1.getText());
        // 获取姓名
        String name = textField2.getText();
        // 获取性别
        String sex;
        if (radioButton1.isSelected()) {
            sex = "M";
        } else {
            sex = "F";
        }
        // 获取 生日
        String birthday = textField4.getText();
        // 获取班级
        String studentClass = textField3.getText();
        // 获取学院信息
        String department = Objects.requireNonNull(comboBox1.getSelectedItem()).toString();
        // 获取籍贯信息
        String nativePlace = textField5.getText();

        StudentHandler studentHandler = new StudentHandler();
        // 传入数据到处理类
        int flag = studentHandler.addStudent(id, name, sex, birthday, studentClass, department, nativePlace);

        if (flag == StudentHandler.ID_IS_NULL) {
            label8.setText("学号为空！");
        }

        if (flag == StudentHandler.NAME_IS_NULL) {
            label8.setText("姓名为空！");
        }

        if (flag == StudentHandler.BIRTHDAY_IS_NULL) {
            label8.setText("生日为空！");
        }
        if (flag == StudentHandler.CLASS_IS_NULL) {
            label8.setText("教室为空！");
        }
        if (flag == StudentHandler.DEPARTMENT_IS_NULL) {
            label8.setText("学院为空！");
        }
        if (flag == StudentHandler.NATIVE_PLACE_IS_NULL) {
            label8.setText("籍贯为空！");
        }
        if (flag == StudentHandler.SUCCESS) {
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
        label2 = new JLabel();
        textField2 = new JTextField();
        label3 = new JLabel();
        textField3 = new JTextField();
        label4 = new JLabel();
        radioButton1 = new JRadioButton();
        radioButton2 = new JRadioButton();
        label5 = new JLabel();
        comboBox1 = new JComboBox();
        label6 = new JLabel();
        textField4 = new JTextField();
        label7 = new JLabel();
        textField5 = new JTextField();
        buttonBar = new JPanel();
        label8 = new JLabel();
        okButton = new JButton();

        //======== this ========
        setMaximizedBounds(new Rectangle(0, 0, 660, 460));
        setMinimumSize(new Dimension(660, 460));
        setTitle("\u6b63\u5728\u6dfb\u52a0\u5b66\u751f");
        setIconImage(new ImageIcon(getClass().getResource("/img/iocn.jpg")).getImage());
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
                label1.setText("\u5b66\u53f7");
                contentPanel.add(label1);
                label1.setBounds(20, 20, 50, label1.getPreferredSize().height);
                contentPanel.add(textField1);
                textField1.setBounds(70, 15, 80, 25);

                //---- label2 ----
                label2.setText("\u59d3\u540d");
                contentPanel.add(label2);
                label2.setBounds(20, 55, 35, label2.getPreferredSize().height);
                contentPanel.add(textField2);
                textField2.setBounds(70, 50, 85, 30);

                //---- label3 ----
                label3.setText("\u73ed\u7ea7");
                contentPanel.add(label3);
                label3.setBounds(330, 15, 35, 25);
                contentPanel.add(textField3);
                textField3.setBounds(380, 20, 135, 25);

                //---- label4 ----
                label4.setText("\u6027\u522b");
                contentPanel.add(label4);
                label4.setBounds(20, 95, 40, label4.getPreferredSize().height);

                //---- radioButton1 ----
                radioButton1.setText("\u7537");
                contentPanel.add(radioButton1);
                radioButton1.setBounds(new Rectangle(new Point(70, 90), radioButton1.getPreferredSize()));

                //---- radioButton2 ----
                radioButton2.setText("\u5973");
                contentPanel.add(radioButton2);
                radioButton2.setBounds(new Rectangle(new Point(115, 90), radioButton2.getPreferredSize()));

                //---- label5 ----
                label5.setText("\u5b66\u9662");
                contentPanel.add(label5);
                label5.setBounds(330, 55, 30, 20);
                contentPanel.add(comboBox1);
                comboBox1.setBounds(380, 55, 135, 25);

                //---- label6 ----
                label6.setText("\u751f\u65e5");
                contentPanel.add(label6);
                label6.setBounds(20, 130, 30, 20);
                contentPanel.add(textField4);
                textField4.setBounds(75, 125, 70, 30);

                //---- label7 ----
                label7.setText("\u7c4d\u8d2f");
                contentPanel.add(label7);
                label7.setBounds(330, 95, 35, 25);
                contentPanel.add(textField5);
                textField5.setBounds(380, 95, 140, 30);

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
                buttonBar.add(label8, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 5), 0, 0));

                //---- okButton ----
                okButton.setText("\u786e\u8ba4\u6dfb\u52a0");
                okButton.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        addStudentOkButtonMouseClicked(e);
                    }
                });
                buttonBar.add(okButton, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
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
    private JLabel label2;
    private JTextField textField2;
    private JLabel label3;
    private JTextField textField3;
    private JLabel label4;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JLabel label5;
    private JComboBox comboBox1;
    private JLabel label6;
    private JTextField textField4;
    private JLabel label7;
    private JTextField textField5;
    private JPanel buttonBar;
    private JLabel label8;
    private JButton okButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public void start() {
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        // 单选框成组，一次只能选中一个
        ButtonGroup group = new ButtonGroup();
        group.add(this.radioButton1);
        group.add(this.radioButton2);
        this.radioButton1.setSelected(true);

        // 获取学院信息，这里自动导包，导入的是awt的list，因此使用ArrayList,不想去找方法解决了，应该不会出问题，
        // 程序能跑就行。
        ArrayList<Department> list = (ArrayList<Department>) new DepartmentHandler().getAllDepartments();

        // 添加学院信息到下拉框中
        for (Department item : list) {
            this.comboBox1.addItem(item.getName());
        }
    }
}
