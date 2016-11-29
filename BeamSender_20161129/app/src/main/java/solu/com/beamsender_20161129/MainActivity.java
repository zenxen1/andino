package solu.com.beamsender_20161129;
/*NFC는 반드시 태그형태로만 존재하는 것은아니기 때문에 디바이스간 NDEF형식의 데이터를 주고 받을 수 있다.*/
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.nfc.NfcEvent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.nio.charset.Charset;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements NfcAdapter.CreateNdefMessageCallback{

    NfcAdapter nfcAdapter;//nfc칩을 표현한 객체
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkNfcSupport();

        nfcAdapter.setNdefPushMessageCallback(this, this);/*여기*/

    }
    /*--------------------------------------------------------
    NFC지원여부 체크
    --------------------------------------------------------*/
    public void checkNfcSupport(){
        nfcAdapter = NfcAdapter.getDefaultAdapter(this);
        if(nfcAdapter==null){
            showAlert("안내","이 디바이스는 NFC를 지원하지 않습니다.");
            finish();///*여기*//*질문*/
            return;//다음으로 넘어갈 수 없음.
        }
    }

    /*개발자는 받는 쪽 디바이스에 어떤 메세지를 보낼지아래의 메서드를재정의하면 재정의하면된다.*/
    @Override
    public NdefMessage createNdefMessage(NfcEvent nfcEvent) {
        NdefMessage message = new NdefMessage(new NdefRecord[]{
            createTextRecord("아두이노",true)
    });

        return message;
    }
    //안드로이드 forum에서 정한 표준 NFC 스펙
    public NdefRecord createTextRecord(String payload, boolean encodeInUtf8) {
        byte[] langBytes = Locale.getDefault().getLanguage().getBytes(Charset.forName("US-ASCII"));/*여기*/
        Charset utfEncoding = encodeInUtf8 ? Charset.forName("UTF-8") : Charset.forName("UTF-16");
        byte[] textBytes = payload.getBytes(utfEncoding);
        int utfBit = encodeInUtf8 ? 0 : (1 << 7);
        char status = (char) (utfBit + langBytes.length);
        byte[] data = new byte[1 + langBytes.length + textBytes.length];
        data[0] = (byte) status;
        System.arraycopy(langBytes, 0, data, 1, langBytes.length);
        System.arraycopy(textBytes, 0, data, 1 + langBytes.length, textBytes.length);
        NdefRecord record = new NdefRecord(NdefRecord.TNF_WELL_KNOWN,
                NdefRecord.RTD_TEXT, new byte[0], data);
        return record;
    }

    public void showAlert(String title, String msg){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle(title).setMessage(msg).show();
    }
}
