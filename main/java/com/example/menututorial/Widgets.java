package com.example.menututorial;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Widgets extends AppCompatActivity {

    CheckBox checkBox1;
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_widgets);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        getSupportActionBar().hide();

        checkBox1 = findViewById(R.id.checkBox1);
        radioGroup = findViewById(R.id.radioGroup);

        checkBox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if(b){
                    int checkedId = compoundButton.getId();

                    switch (checkedId){

                        case R.id.btnRadio1:
                            Toast.makeText(Widgets.this, "checked Checkbox1"  , Toast.LENGTH_SHORT).show();
                            break;
                        case R.id.btnRadio2:
                            Toast.makeText(Widgets.this, "checked Checkbox2"  , Toast.LENGTH_SHORT).show();
                            break;
                        default:
                            Toast.makeText(Widgets.this, "Not checked "  , Toast.LENGTH_SHORT).show();

                    }

                }
            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton radioBtn = findViewById(i);
                Toast.makeText(Widgets.this, "Selected " + radioBtn.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });




    }



}