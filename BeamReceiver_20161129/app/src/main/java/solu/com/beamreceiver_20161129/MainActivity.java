package solu.com.beamreceiver_20161129;

import android.content.Intent;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txt_msg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt_msg=(TextView)findViewById(R.id.txt_msg);

        Intent intent = getIntent();

        getInfo(intent);
    }

    /*NDEF 레코드 추출하기*/
    public void getInfo(Intent intent){
        /*인텐트에 Parcelable 형태로 심어져 있기 때문에*/
        Parcelable[] parcelables=intent.getParcelableArrayExtra(NfcAdapter.EXTRA_NDEF_MESSAGES);
        NdefMessage message=(NdefMessage) parcelables[0];//0번째는 MIME type 1번째는 AAR 안드로이드 레코드
        NdefRecord record=(NdefRecord)message.getRecords()[0];
        String msg = new String(record.getPayload());//byte형 배열 반환 메서드인데, string으로 받는다.

        txt_msg.setText(msg);

    }
}
