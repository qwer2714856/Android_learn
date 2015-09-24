package com.example.phone;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CallLog.Calls;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * @author Administrator
 *
 */
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //给按钮写个侦听事件
        Button bt = (Button) findViewById(R.id.call);
        bt.setOnClickListener(new MyOnClickListener());
    }

    class MyOnClickListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			EditText tx = (EditText) findViewById(R.id.text_number);
			//获取用户输入的号码
			System.out.println(tx.getText().toString());
			
			//在一个应用启动另外一个应用
		    //告诉系统我们的动作，调用打电话的应用
			Intent intent = new Intent();//创建意图对象
			//动作封装到意图对象
			intent.setAction(intent.ACTION_CALL);
			//打给谁
			intent.setData(Uri.parse("tel:" + tx.getText().toString()));//这里必须要用tel:加起来告诉系统这是个电话。
			//把动作告诉系统 就是启动了一个打电话的应用
			startActivity(intent);
			//这个地方代码没问题但是牵扯到了一个权限的问题，申请一下打电话权限用户同意就能打。
			
			
		}
    	
    }
    
}
