package com.example.andlabb.dialoge;

import android.app.Activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;

import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends Activity {

    String[] listItems;
    Button b1,b2,b3,sBtn;
    TextView op;
    EditText ed;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listItems = getResources().getStringArray(R.array.Gender);
        ed =findViewById(R.id.editText);
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        sBtn = findViewById(R.id.sBtn);
        op = findViewById(R.id.op);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
                mBuilder.setTitle("Choose an item");
                mBuilder.setSingleChoiceItems(listItems, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        b1.setText(listItems[i]);
                        dialogInterface.dismiss();
                    }
                });
                AlertDialog mDialog = mBuilder.create();
                mDialog.show();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final View dialogView = View.inflate(MainActivity.this, R.layout.calander, null);
                final AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();

                dialogView.findViewById(R.id.date_time_set).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        DatePicker datePicker = (DatePicker) dialogView.findViewById(R.id.date_picker);



                        b2.setText(datePicker.getDayOfMonth()+"-"+ datePicker.getMonth()+"-"+datePicker.getYear());

                        alertDialog.dismiss();
                    }});
                alertDialog.setView(dialogView);
                alertDialog.show();
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                String[] course = new String[]{
                        "ML",
                        "MC",
                        "ADM",
                        "JAVA / FP",
                        "BIG DATA"
                };

                final boolean[] checkedCourse = new boolean[]{
                        false,
                        false,
                        false,
                        false,
                        false

                };

                final List<String> courseList = Arrays.asList(course);


                builder.setMultiChoiceItems(course, checkedCourse, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        checkedCourse[which] = isChecked;
                        String currentItem = courseList.get(which);

                    }
                });
                builder.setCancelable(false);

                builder.setTitle("Your preferred courses?");

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        b3.setText("");
                        for (int i = 0; i<checkedCourse.length; i++){
                            boolean checked = checkedCourse[i];
                            if (checked) {
                                b3.setText(b3.getText() + courseList.get(i) + "\n");
                            }
                        }
                     }
                        });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });


                builder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        sBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final View dialogView = View.inflate(MainActivity.this, R.layout.confirm, null);


                final AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                alertDialog.setTitle("Confirm");
                dialogView.findViewById(R.id.confirm).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                            op.setText("\n\nName :  "+ed.getText()+"\nGender :  "+b1.getText()+"\nAge :  "+b2.getText()+"\nCourse :  "+b3.getText());

                        alertDialog.dismiss();
                    }});
                dialogView.findViewById(R.id.cancel).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {


                        op.setText("");
                        alertDialog.dismiss();
                    }});
                alertDialog.setView(dialogView);
                alertDialog.show();
            }
        });
    }
}