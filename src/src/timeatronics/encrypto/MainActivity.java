package timeatronics.encrypto;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	StringReturnUtil r=new StringReturnUtil();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.main);
		Button encryptButton=(Button)findViewById(R.id.encryptButton);
		Button decryptButton=(Button)findViewById(R.id.decryptButton);

		encryptButton.setOnClickListener(onSave);
		decryptButton.setOnClickListener(onSave);
	}
	
	private View.OnClickListener onSave=new View.OnClickListener() {
		public void onClick(View v) {

			EditText message=(EditText)findViewById(R.id.message);
			EditText key=(EditText)findViewById(R.id.key);

			TextView textView=(TextView)findViewById(R.id.outputView);

			r.setMessage(message.getText().toString());
			r.setKey(key.getText().toString());

            final String secretKey = key.getText().toString();

			switch (v.getId()) {

            	case R.id.encryptButton:
					String originalString=message.getText().toString();
	    			String encryptedString = AES.encrypt(originalString, secretKey);
					textView.setText("Output: " + encryptedString);
                	break;

            	case R.id.decryptButton:
					String originalString1=message.getText().toString();
	    			String decryptedString = AES.decrypt(originalString1, secretKey);
					textView.setText("Output: " + decryptedString);
                	break;

            	default:
                	break;
        	}
		}
	};
}
