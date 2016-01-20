package org.itstep.pastukhov.dz_13;

import android.app.DialogFragment;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by lotrik on 20.01.16.
 */
public class Dialog extends DialogFragment implements View.OnFocusChangeListener{

    EditText oldPasswd;
    EditText newPasswd;
    EditText newPasswd2;
    TextView checkPasswd;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        getDialog().setTitle("Смена пароля");

        final View v = inflater.inflate(R.layout.dialog, null);

        oldPasswd = (EditText)v.findViewById(R.id.editText);
        newPasswd = (EditText)v.findViewById(R.id.editText2);
        newPasswd2 = (EditText)v.findViewById(R.id.editText3);
        checkPasswd = (TextView)v.findViewById(R.id.textView2);

        oldPasswd.setOnFocusChangeListener(this);
        newPasswd.setOnFocusChangeListener(this);
        newPasswd2.setOnFocusChangeListener(this);

        oldPasswd.getBackground().setColorFilter(getResources().getColor(R.color.grey),
                PorterDuff.Mode.SRC_ATOP);
        newPasswd.getBackground().setColorFilter(getResources().getColor(R.color.grey),
                PorterDuff.Mode.SRC_ATOP);
        newPasswd2.getBackground().setColorFilter(getResources().getColor(R.color.grey),
                PorterDuff.Mode.SRC_ATOP);

        TextWatcher textWatcher = new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if (!newPasswd.getText().toString().equals(newPasswd2.getText().toString())){

                    checkPasswd.setTextColor(Color.RED);
                    checkPasswd.setText("Пароли не совпадают");

                } else {

                    checkPasswd.setTextColor(getResources().getColor(R.color.green));
                    checkPasswd.setText("Пароли совпадают");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        };

        newPasswd2.addTextChangedListener(textWatcher);

        return v;
    }

    @Override
    public void onFocusChange(View view, boolean b) {
        if (b) {
            switch (view.getId()) {
                case R.id.editText:
                    oldPasswd.getBackground().setColorFilter(getResources().getColor(R.color.colorPrimaryDark),
                        PorterDuff.Mode.SRC_ATOP);
                    break;
                case R.id.editText2:
                    newPasswd.getBackground().setColorFilter(getResources().getColor(R.color.colorPrimaryDark),
                        PorterDuff.Mode.SRC_ATOP);
                    break;
                case R.id.editText3:
                    newPasswd2.getBackground().setColorFilter(getResources().getColor(R.color.colorPrimaryDark),
                        PorterDuff.Mode.SRC_ATOP);
                    break;
            }
        } else {

            switch (view.getId()) {

                case R.id.editText:
                    oldPasswd.getBackground().setColorFilter(getResources().getColor(R.color.grey),
                            PorterDuff.Mode.SRC_ATOP);
                    break;
                case R.id.editText2:
                    newPasswd.getBackground().setColorFilter(getResources().getColor(R.color.grey),
                            PorterDuff.Mode.SRC_ATOP);
                    break;
                case R.id.editText3:
                    newPasswd2.getBackground().setColorFilter(getResources().getColor(R.color.grey),
                            PorterDuff.Mode.SRC_ATOP);
                    break;
            }
        }
    }
}
