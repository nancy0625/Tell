package cn.edu.gdmec.android.tell;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bCall = (Button)findViewById(R.id.btn);
        Button bSms = (Button)findViewById(R.id.btn_sms);
        Button bContact = (Button)findViewById(R.id.btn_contact);
        bCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText telnum = (EditText)findViewById(R.id.tel);
                String telNum = telnum.getText().toString();
                //拨打电话
                if (PhoneNumberUtils.isGlobalPhoneNumber(telNum)){
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(//Uri.parse的方法返回的是一个URI类型，通过这个URI可以访问一个网络上或者是本地的资源
                            //使用系统拨号盘
                            "tel://"+telNum
                    ));

                    MainActivity.this.startActivity(intent);
                }else{
                    Toast.makeText(MainActivity.this,"号码不正确",Toast.LENGTH_LONG).show();
                }



            }
        });
            //发送短信
        bSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText telnum = (EditText)findViewById(R.id.tel);
                String telNum = telnum.getText().toString();
                //拨打电话
                if (PhoneNumberUtils.isGlobalPhoneNumber(telNum)){
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(//Uri.parse的方法返回的是一个URI类型，通过这个URI可以访问一个网络上或者是本地的资源
                            //使用系统拨号盘
                            "smsto:"+telNum
                    ));

                    MainActivity.this.startActivity(intent);
                }else{
                    Toast.makeText(MainActivity.this,"号码不正确",Toast.LENGTH_LONG).show();
                }



            }
        });
    }
}
