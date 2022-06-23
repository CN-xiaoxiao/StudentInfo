import com.xiaoxiao.view.LoginUi;
import com.xiaoxiao.view.RegisterUi;
import org.junit.Test;

public class UiTest {

    @Test
    public void testLoginAndRegister() {
        try
        {
            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        new RegisterUi().start();
    }
}
