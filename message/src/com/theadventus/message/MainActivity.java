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
    
    
    
    //���ﲻ��intent ����һ�ֱ�ķ�ʽ��ʵ�֣��绰����Ϊ���ʲ���api���Բ�����ͼ����Ȼ�������ǿ��Է���api���ԾͲ�����ͼ�����ˡ�
    //�����¼��ĵ�����ģʽ
    public void sendMessage(View e){
    	//phone number
        EditText phoneNum = (EditText) findViewById(R.id.num);
        //message
        EditText message = (EditText) findViewById(R.id.message);
        //��Ϣ�Ļ�ȡ
        String phoneNumStr = phoneNum.getText().toString();
        String messageStr = message.getText().toString();
        //���Ͷ���
        SmsManager sm = SmsManager.getDefault();
        //������
        //�Է�����  ���ŷ������ĵ�ַ����� SMSC �� *#*#4636#*#* �����˵���Ҳ��ָ�� һ�㲻ָ�������������Ҫָ���������������˼���Ǳ��籱���������Ķ��ŷ���������ô���ൺ�ͷ������ˣ����һ���Զ���ȡnull���У����ŵ�����
        //sentIntent �ǹ㲥���ͺ󣬻��гɹ���ʧ�ܵ�״̬�룬��Ϊ����ûѧ�㲥���Դ���null����
        //deliveryIntent ��Ҳ�Ǹ��㲥,�����Ϣ���Է��ɹ����պ��һ���㲥
        //sm.sendTextMessage(phoneNumStr, null, messageStr, null, null);
        
        
        //������źܳ�������Ĭ��ֻ����70���ַ����Դ��ַ���������ȥ
        //���ʱ����Կ��ǲ���ַ��ֱ���
        //�ڶ�����ʼ����ַ��� ������������Լ������ֳɵķ�����
        ArrayList <String> list = sm.divideMessage(messageStr);
        for(String name : list){
        	sm.sendTextMessage(phoneNumStr, null, name, null, null);
        }
    }
}