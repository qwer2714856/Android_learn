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
	  
	  if(cb_ck.isChecked()){//勾选了是true
		  //写到本地文件去 这就是内部存贮空间路径
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
	  //吐司对话框弹出对话框API 第一个参数上下文对象 Activity 本身就是一个上下文对象所以传this 第二个参数提示消息内容 第三个参数过几秒消失Toast.LENGTH_LONG 5秒 Toast.LENGTH_SHORT 3秒 只能给这两个值不能有其它值
	  //这是创建还没有显示 所以要在后面show出来 Toast.LENGTH_SHORT 0 Toast.LENGTH_LONG 1可以直接传数字
	  //如果ctrl+鼠标左键没法看源码关联一下就可以去sdk下面的source关联一个版本就行
	  Toast.makeText(this, "提示消息", Toast.LENGTH_SHORT).show();
	 
   }
}
