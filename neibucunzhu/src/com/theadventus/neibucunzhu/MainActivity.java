package com.theadventus.neibucunzhu;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.io.*;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


   public void login(View v){
	  EditText et_username =  (EditText) findViewById(R.id.username);
	  EditText et_password =  (EditText) findViewById(R.id.password);
	  
	  CheckBox cb_ck = (CheckBox) findViewById(R.id.ck);
	  
	  String userName = et_username.getText().toString();
	  String password = et_password.getText().toString();
	  
	  if(cb_ck.isChecked()){//��ѡ����true
		  //д�������ļ�ȥ ������ڲ������ռ�·��
		  File file = new File("data/data/com.theadventus.neibucunzhu/info.txt");
		  FileWriter fw = null;
		  try {
			fw = new FileWriter(file);
			fw.write(userName+"\r\n");
			fw.write(password+"\r\n");
		  } catch (IOException e) {
			// TODO Auto-generated catch block
			  
			e.printStackTrace();
		}finally{
			try {
				fw.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	  }
	  //��˾�Ի��򵯳��Ի���API ��һ�����������Ķ��� Activity ��������һ�������Ķ������Դ�this �ڶ���������ʾ��Ϣ���� ������������������ʧToast.LENGTH_LONG 5�� Toast.LENGTH_SHORT 3�� ֻ�ܸ�������ֵ����������ֵ
	  //���Ǵ�����û����ʾ ����Ҫ�ں���show���� Toast.LENGTH_SHORT 0 Toast.LENGTH_LONG 1����ֱ�Ӵ�����
	  //���ctrl+������û����Դ�����һ�¾Ϳ���ȥsdk�����source����һ���汾����
	  Toast.makeText(this, "��ʾ��Ϣ", Toast.LENGTH_SHORT).show();
	 
   }
}