package com.example.tatastriveform;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity implements android.view.View.OnClickListener {
    CheckBox b,b2,b3,b4,b5,b6,b7,b8,b9,b10;//identity checkbox declare
    CheckBox b11,b12,b13,b14,b15,b16;//about know
    CheckBox b21,b22,b23,b24,b25,b26,b27;//religion
    CheckBox b31,b32,b33,b34,b35;//caste
    CheckBox b41,b42,b43,b44,b45,b46;//
    RadioButton rbmale,rbfemale,rb_marrid, rb_unmarri,rb_divorsed,rb_widow;
    EditText sname,fname,mname,mobno,dob,add,house,landmark,village,dist,state,pin,edu, e_id,refnm1,refmb1;
    Button Insert, Delete, Update, View, ViewAll;
    SQLiteDatabase db;

    String strid,strabt,strreligion,strcaste,gender,marigestatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sname=findViewById(R.id.full_Name);
        fname=findViewById(R.id.FathersName);
        mname=findViewById(R.id.mathername);
        mobno=findViewById(R.id.mobno);
        add=findViewById(R.id.Fulladdress);
        house=findViewById(R.id.Houseno);
        landmark=findViewById(R.id.Nearestladmark);
        village=findViewById(R.id.village);
        dist=findViewById(R.id.District);
        state=findViewById(R.id.State);
        pin=findViewById(R.id.Pincode);
        sname=findViewById(R.id.full_Name);
        edu=findViewById(R.id.education);
        e_id=findViewById(R.id.EmailId);
        refnm1=findViewById(R.id.refname);

        refmb1=findViewById(R.id.refmob);
        rbmale=findViewById(R.id.radio_male);
        rbfemale=findViewById(R.id.radio_female);
        rb_marrid=findViewById(R.id.Married);
        rb_unmarri=findViewById(R.id.unmarried);
        rb_divorsed=findViewById(R.id.Divorced);
        rb_widow=findViewById(R.id.Widow);






        b = findViewById( R.id.VoterCard );
        b2 = findViewById( R.id.DrivingLicense );
        b3 = findViewById( R.id.BPLcard );
        b4 = findViewById( R.id.NREGACard );
        b5 = findViewById( R.id.RationCard );
        b6 = findViewById( R.id.Passport );
        b7 = findViewById( R.id.other );
        b8 = findViewById( R.id.pancard );
        // about know
        b9 = findViewById( R.id.Pradhan );
        b10 = findViewById( R.id.Friend );
        b11 = findViewById( R.id.CommunityMember );
        b12 = findViewById( R.id.SchoolTeacher );
        b13 = findViewById( R.id.Poster );
        b14 = findViewById( R.id.Internet );
        b15 = findViewById( R.id.Advertisement );
        // b16 = findViewById( R.id.Other1 );

        //religion
        b21 = findViewById( R.id.Hindu );
        b22 = findViewById( R.id.Muslim );
        b23 = findViewById( R.id.Sikh );
        b24 = findViewById( R.id.Christian );
        b25 = findViewById( R.id.Jain );
        b26 = findViewById( R.id.Buddhist );
        b27 = findViewById( R.id.Other2 );

        //Caste Category
        b31 = findViewById( R.id.General );
        b32 = findViewById( R.id.OBC );
        b33 = findViewById( R.id.SC );
        b34 = findViewById( R.id.ST );
        b35 = findViewById( R.id.Other3 );
        //currently worked
        b41 = findViewById( R.id.EmployeeAgricuture );
        b42 = findViewById( R.id.Employee_nonAgricuture );
        b43 = findViewById( R.id.SelfEmployee_Agriculture );
        b44 = findViewById( R.id.SelfEmployee_nonAgriculture );
        b45 = findViewById( R.id.Unemployee );
        b46 = findViewById( R.id.Student );

        Delete = findViewById( R.id.Delete );
        Update = findViewById( R.id.Update );
        View = findViewById( R.id.View );
        ViewAll = findViewById( R.id.ViewAll );
        Insert = findViewById( R.id.Insert );
        Insert.setOnClickListener( this );
        Delete.setOnClickListener( this );
        Update.setOnClickListener( this );
        View.setOnClickListener( this );
        ViewAll.setOnClickListener( this );

        // Creating database and table
        db = openOrCreateDatabase( "StudentDB1", Context.MODE_PRIVATE, null );
        db.execSQL( "CREATE TABLE IF NOT EXISTS student1(name VARCHAR,fname VARCHAR,mname VARCHAR,mobno VARCHAR,dob VARCHAR,address VARCHAR,houseno VARCHAR,landmark VARCHAR,village VARCHAR,dist VARCHAR,state VARCHAR,pin VARCHAR,eid VARCHAR,refnm VARCHAR,refmb VARCHAR);" );


    }

    @Override
    public void onClick(android.view.View v) {
        switch (v.getId())
        // Inserting a record to the Student table
        {
            case R.id.Insert:
                // Checking for empty fields
               /* if (sname.getText().toString().trim().length() == 0 ||
                        fname.getText().toString().trim().length() == 0 ||
                        mobno.getText().toString().trim().length() == 0) {
                    showMessage( "Error", "Please enter all values" );
                    return;
                }*/
                db.execSQL( "INSERT INTO student1 VALUES('" + sname.getText() + "','" + fname.getText() + "','" + mname.getText() + "','" + mobno.getText() + "','" + dob.getText() + "','" + add.getText() + "','" + house.getText() + "','" + landmark.getText() + "','" + village.getText() + "','" + dist.getText() + "','" + state.getText() + "','" + pin.getText() + "','" + e_id.getText() + "','" + refnm1.getText() + "','" + refmb1.getText() + "');" );

                showMessage( "Success", "Record added" );
                clearText();
                break;

            case R.id.ViewAll: {
                Cursor c3 = db.rawQuery( "SELECT * FROM student1", null );
                if (c3.getCount() == 0) {
                    showMessage( "Error", "No records found" );
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (c3.moveToNext()) {
                    buffer.append( "Stud Name : " + c3.getString( 0 ) + "\n" );
                    buffer.append( "Father Name: " + c3.getString( 1 ) + "\n" );
                    buffer.append( "Mother Name: " + c3.getString( 2 ) + "\n" );
                    buffer.append( "MOb No: " + c3.getString( 3 ) + "\n" );
                    buffer.append( "DOB: " + c3.getString( 4 ) + "\n" );
                    buffer.append( "Address: " + c3.getString( 5 ) + "\n" );
                    buffer.append( "House No: " + c3.getString( 6 ) + "\n" );
                    buffer.append( "Landmark: " + c3.getString( 7 ) + "\n" );
                    buffer.append( "Vilage: " + c3.getString( 8 ) + "\n" );
                    buffer.append( "Dist: " + c3.getString( 9 ) + "\n" );
                    buffer.append( "State: " + c3.getString( 10 ) + "\n" );
                    buffer.append( "Pin: " + c3.getString( 11 ) + "\n" );
                    buffer.append( "E_id: " + c3.getString( 12 ) + "\n" );
                    buffer.append( "Ref name 1: " + c3.getString( 13 ) + "\n" );
                    buffer.append( "Ref mob 1: " + c3.getString( 14 ) + "\n" );

                }
                showMessage( "Student Details", buffer.toString() );
            }
            break;
        }

    }

    private void clearText() {
        sname.setText("" );
        fname.setText( "" );
        mobno.setText( "" );
        mname.setText("");
    }

    private void showMessage(String error, String please_enter_all_values) {

        AlertDialog.Builder builder = new AlertDialog.Builder( this );
        builder.setCancelable( true );
        builder.setTitle( error );
        builder.setMessage( please_enter_all_values );
        builder.show();
        
    }

    public void selgender(android.view.View view) {

        if(rbmale.isChecked()==true) {
            gender = rbmale.getText().toString();
        }

        if(rbfemale.isChecked()==true)
        {
            gender=rbfemale.getText().toString();
        }

    }

    public void maristatus(android.view.View view) {
        if(rb_marrid.isChecked()==true) {
            marigestatus = rb_marrid.getText().toString();
        }

        if(rb_unmarri.isChecked()==true)
        {
            marigestatus=rb_unmarri.getText().toString();
        }

        if(rb_divorsed.isChecked()==true) {
            marigestatus = rb_divorsed.getText().toString();
        }

        if(rb_widow.isChecked()==true)
        {
            marigestatus=rb_widow.getText().toString();
        }


    }
}
