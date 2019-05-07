package com.example.freshfinaltoolbarwhatsapp;

import android.database.Cursor;
import android.os.Build;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class TestUIActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_ui);
        checkPermissions();
        getContactList();
    }

    private void getContactList() {
        Cursor phones = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);

        while (phones.moveToNext()) {
            String Name = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            String number = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
            number = number.replaceAll("\\s+", "");
            String[] array = new String[]{Name, number};
            Toast.makeText(TestUIActivity.this, array[0] + " " + array[1], Toast.LENGTH_SHORT).show();
        }
    }

    private void checkPermissions() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
            requestPermissions(new String[]{"android.permission.READ_CONTACTS"}, 1);
    }
}
