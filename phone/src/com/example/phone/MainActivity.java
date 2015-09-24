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
        //����ťд�������¼�
        Button bt = (Button) findViewById(R.id.call);
        bt.setOnClickListener(new MyOnClickListener());
    }

    class MyOnClickListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			EditText tx = (EditText) findViewById(R.id.text_number);
			//��ȡ�û�����ĺ���
			System.out.println(tx.getText().toString());
			
			//��һ��Ӧ����������һ��Ӧ��
		    //����ϵͳ���ǵĶ��������ô�绰��Ӧ��
			Intent intent = new Intent();//������ͼ����
			//������װ����ͼ����
			intent.setAction(intent.ACTION_CALL);
			//���˭
			intent.setData(Uri.parse("tel:" + tx.getText().toString()));//�������Ҫ��tel:����������ϵͳ���Ǹ��绰��
			//�Ѷ�������ϵͳ ����������һ����绰��Ӧ��
			startActivity(intent);
			//����ط�����û���⵫��ǣ������һ��Ȩ�޵����⣬����һ�´�绰Ȩ���û�ͬ����ܴ�
			
			
		}
    	
    }
    
}