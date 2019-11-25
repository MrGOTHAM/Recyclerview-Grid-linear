package com.example.work11.dialogfragment;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DialogActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EditNameDialogFragment editNameDialogFragment = new EditNameDialogFragment();
        editNameDialogFragment.show(getSupportFragmentManager(),"editNameDialogFragment");

    }
}
