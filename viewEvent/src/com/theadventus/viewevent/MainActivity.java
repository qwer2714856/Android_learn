package com.theadventus.viewevent;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class MainActivity extends Activity implements OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bt = (Button) findViewById(R.id.bt);
        //bt.setOnClickListener(new MyClass());
        /*bt.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				System.out.println("2");
			}
        	
        
        });*/
        //bt.setOnClickListener(this);
        
    }  
    class MyClass implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			System.out.println("~~");
		}
    	
    }
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		System.out.println(3);
	}
	
	public void four(View v){
		System.out.println(4);
	}
	/**
	 * View���
	 * ������ť��ָ��ָ�����ˣ�������֣�ʹ��View v�����֡�
	 * View������ϵͳ�������ģ�ϵͳ��Ѵ�������������Ǹ������ΪView���󴫽�����
	 * @param v
	 */
	public void five(View v){
		//ͨ����view������жϾͿ���֪���û�����ĵ�������һ������
		//v.getId();//ʹ��getId����ȡָ�������������Щ��ť�� ��һ��id�İ�ť��
		switch(v.getId()){
			case R.id.five_1:System.out.println("hi");;break;
			case R.id.five_2:System.out.println("hi2");;break;
		}
	}
}