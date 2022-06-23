import com.xiaoxiao.entity.Student;
import org.junit.Test;

import javax.swing.*;

public class ViewTest{
    public static void main(String[] args) {

        try
        {
            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        JFrame frame = new JFrame("Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setBounds(50, 50, 600, 400);

        frame.setVisible(true);
    }

    @Test
    public void testClass() {
        ViewTest test = this;
        System.out.println(test.toString() + "   " +  this.toString());
        test = null;
        System.out.println(test + "   " + this);

    }
}