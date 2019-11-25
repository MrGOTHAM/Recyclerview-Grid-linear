package com.example.work11.dialogfragment;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DialogActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EditNameDialogFragment2 editNameDialogFragment2 = new EditNameDialogFragment2();
        editNameDialogFragment2.show(getSupportFragmentManager(),"aaaaaaa");
    }
}
