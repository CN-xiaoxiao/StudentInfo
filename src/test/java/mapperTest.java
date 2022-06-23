import com.xiaoxiao.entity.*;
import com.xiaoxiao.mapper.*;
import com.xiaoxiao.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class mapperTest {


    @Test
    public void TestUserMapper() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        System.out.println(mapper.insertUser(new User("张三", "123456")));
    }

    @Test
    public void testStudentMapper() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        System.out.println(mapper.updateStudent(new Student().setStudentId(2005010421).setName("李四")
                .setBirthday("2001-01-23").setNativePlace("黑龙江")));
    }

    @Test
    public void testChangeMapper() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ChangeMapper mapper = sqlSession.getMapper(ChangeMapper.class);
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        mapper.insertChange(new Change().setStudentId(2005010420).setChangeCode(4).setRecTime(formatter.format(date)).setDescription("毕业").setId(1));
//        mapper.getAllChanges();
    }

    @Test
    public void testDepartmentMapper() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);

        mapper.insertDepartment(new Department().setId(1).setName("教育学院"));
    }

    @Test
    public void testRewardMapper() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        RewardMapper mapper = sqlSession.getMapper(RewardMapper.class);
//        System.out.println(mapper.getDescriptionById(1));
//        System.out.println(mapper.getCodeByDescription("校二等奖学金"));
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        System.out.println(mapper.insertReward(new Reward().setStudentId(2005010420).setLevels(3).setRecTime(formatter.format(date)).setDescription("校三等奖学金")));
    }

}
