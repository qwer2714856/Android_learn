package com.theadventus.phoneandmessagelx;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void call(View v){
    	switch(v.getId()){
    	case R.id.call:
    		//打电话
    		EditText tellNumber = (EditText) findViewById(R.id.callNumber);
    		//创建意图
    		Intent intent = new Intent();
    		intent.setAction(Intent.ACTION_CALL);
    		intent.setData(Uri.parse("tel:" + tellNumber.toString()));
    		startActivity(intent);
    		
    		;break;
    	case R.id.messageBt:
    			System.out.println("===");
    		//发短信
    		//1.获取目标地址 
    		//2.获取短信消息
    		EditText tellNumbers = (EditText) findViewById(R.id.messagepeople);
    		EditText msg = (EditText) findViewById(R.id.message);
    		
    		SmsManager sm = SmsManager.getDefault();
    		ArrayList <String> list = sm.divideMessage(msg.getText().toString());
    		for(String name : list){
    			sm.sendTextMessage(tellNumbers.getText().toString(), null, name, null, null);
    		}
    		;break;
    	}
    }

}
