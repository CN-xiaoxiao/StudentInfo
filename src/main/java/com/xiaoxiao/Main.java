package com.xiaoxiao;

import com.xiaoxiao.view.LoginUi;

/**
 * @author xiaoxiao
 * 程序主入口
 */
public class Main {
    public static void main(String[] args) {
        try
        {
            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        new LoginUi().start();
    }
}
