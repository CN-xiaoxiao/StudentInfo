import com.xiaoxiao.entity.StudentClass;
import com.xiaoxiao.mapper.ClassMapper;
import com.xiaoxiao.utils.SqlSessionUtils;
import com.xiaoxiao.view.ClassList;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class JTableTest extends JFrame {

    public static void main(String[] args) {
        ClassList ui = new ClassList();
        ui.setSize(710,455);
        ui.setVisible(true);
        DefaultTableModel model = new DefaultTableModel();
        ui.getTable1().setModel(model);
        Vector row = new Vector();
        Vector data = new Vector();
        Vector names = new Vector();
        List<StudentClass> list;
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ClassMapper mapper = sqlSession.getMapper(ClassMapper.class);

        list = mapper.getAllClass();
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
