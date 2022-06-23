import com.xiaoxiao.entity.Student;
import com.xiaoxiao.entity.User;
import com.xiaoxiao.mapper.StudentMapper;
import com.xiaoxiao.mapper.UserMapper;
import com.xiaoxiao.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

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
        System.out.println(mapper.insertStudent(new Student().setStudentId(2005010421).setName("李四").setSex("M")
                .setBirthday("2001-01-23").setStudentClass(4).setDepartment(5).setNativePlace("江西")));
    }
}
