package com.theadventus.message;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);   
    }
    
    
    
    //这里不用intent 采用一种别的方式来实现，电话是因为访问不到api所以采用意图对象，然而短信是可以访问api所以就不用意图对象了。
    //采用事件的第三种模式
    public void sendMessage(View e){
    	//phone number
        EditText phoneNum = (EditText) findViewById(R.id.num);
        //message
        EditText message = (EditText) findViewById(R.id.message);
        //消息的获取
        String phoneNumStr = phoneNum.getText().toString();
        String messageStr = message.getText().toString();
        //发送短信
        SmsManager sm = SmsManager.getDefault();
        //发短信
        //对方号码  短信服务中心地址（真机 SMSC 在 *#*#4636#*#* 弹出菜单看也不指定 一般不指定，特殊情况需要指定，这个东西的意思就是比如北京给北京的短信服务中心那么来青岛就发不了了，这个一般自动获取null就行）短信的内容
        //sentIntent 是广播发送后，会有成功或失败的状态码，因为现在没学广播所以传个null就行
        //deliveryIntent 这也是个广播,你的消息被对方成功接收后的一个广播
        //sm.sendTextMessage(phoneNumStr, null, messageStr, null, null);
        
        
        //如果短信很长运行商默认只给了70个字符所以大字符串发不出去
        //这个时候可以考虑拆分字符分别发送
        //第二步开始拆分字符串 这个不用我们自己拆有现成的方法用
        ArrayList <String> list = sm.divideMessage(messageStr);
        for(String name : list){
        	sm.sendTextMessage(phoneNumStr, null, name, null, null);
        }
    }
}
