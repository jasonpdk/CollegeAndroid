//Main class, service, and broadcast receiver defined in separated classes
package cis493.demos;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;

public class MyServiceDriver2 extends Activity {
    TextView txtMsg;
    Button btnStopService;
    ComponentName service;
    Intent intentMyService2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        txtMsg = (TextView) findViewById(R.id.txtMsg);                
        
        intentMyService2 = new Intent(this, MyService2.class);      
        
        service = startService(intentMyService2);   
                
        txtMsg.setText("MyService2 started - (see LogCat)");
        
        btnStopService = (Button) findViewById(R.id.btnStopService);
        btnStopService.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				try {
					stopService(intentMyService2);
					txtMsg.setText("After stoping Service: \n" + 
							        service.getClassName());
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
        	
        });
   
    }//onCreate


    
    
}