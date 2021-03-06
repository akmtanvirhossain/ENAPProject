
 package org.icddrb.enap;


 //Android Manifest Code
 //<activity android:name=".Registration" android:label="Registration" />
 import java.text.ParseException;
 import java.text.SimpleDateFormat;
 import java.util.ArrayList;
 import java.util.Calendar;
 import java.util.Date;
 import java.util.HashMap;
 import java.util.List;
 import android.app.*;
 import android.app.AlertDialog;
 import android.app.DatePickerDialog;
 import android.app.Dialog;
 import android.app.TimePickerDialog;
 import android.content.Context;
 import android.content.DialogInterface;
 import android.content.Intent;
 import android.database.Cursor;
 import android.location.Location;
 import android.location.LocationListener;
 import android.location.LocationManager;
 import android.net.Uri;
 import android.provider.Settings;
 import android.text.Editable;
 import android.text.InputFilter;
 import android.text.InputType;
 import android.text.TextWatcher;
 import android.view.Gravity;
 import android.view.KeyEvent;
 import android.os.Bundle;
 import android.view.Menu;
 import android.view.MenuInflater;
 import android.view.MenuItem;
 import android.view.View;
 import android.view.MotionEvent;
 import android.view.View.OnFocusChangeListener;
 import android.view.ViewGroup;
 import android.view.LayoutInflater;
 import android.view.Window;
 import android.view.WindowManager;
 import android.widget.AdapterView;
 import android.widget.AutoCompleteTextView;
 import android.widget.Button;
 import android.widget.CheckBox;
 import android.widget.DatePicker;
 import android.widget.EditText;
 import android.widget.ImageButton;
 import android.widget.LinearLayout;
 import android.widget.RadioButton;
 import android.widget.RadioGroup;
 import android.widget.ListView;
 import android.widget.RelativeLayout;
 import android.widget.SimpleAdapter;
 import android.widget.BaseAdapter;
 import android.widget.Spinner;
 import android.widget.TextView;
 import android.widget.TimePicker;
 import android.widget.ArrayAdapter;
 import android.widget.CompoundButton;
 import android.graphics.Color;
 import Utility.*;
 import Common.*;

 public class Registration extends Activity {
    boolean networkAvailable=false;
    Location currentLocation; 
    double currentLatitude,currentLongitude; 
    //Disabled Back/Home key
    //--------------------------------------------------------------------------------------------------
    @Override 
    public boolean onKeyDown(int iKeyCode, KeyEvent event)
    {
        if(iKeyCode == KeyEvent.KEYCODE_BACK || iKeyCode == KeyEvent.KEYCODE_HOME) 
             { return false; }
        else { return true;  }
    }
    String VariableID;
    private int hour;
    private int minute;
    private int mDay;
    private int mMonth;
    private int mYear;
    static final int DATE_DIALOG = 1;
    static final int TIME_DIALOG = 2;

    Connection C;
    Global g;
    SimpleAdapter dataAdapter;
    ArrayList<HashMap<String, String>> dataList = new ArrayList<HashMap<String, String>>();

     LinearLayout secConReason;
     EditText txtConReason;

     LinearLayout secMotEdu;
     EditText txtMotEdu;
     LinearLayout secMotEduDK;
     CheckBox chkMotEduDK;

     EditText txtMotDataID;

     CheckBox chkadwghtkmcDK;
     CheckBox chkgaadmDK;

     LinearLayout secDOBNewbornDK;
     CheckBox chkDOBNewbornDK;

     CheckBox chkprevpregDK;
     CheckBox chkprevlivebDK;
     CheckBox chkprevstillbDK;
     CheckBox chkprevabDK;
     CheckBox chkprevcsecDK;
     CheckBox chkyrslstbthDK;

     EditText txtMotStudyIDReType;
         TextView lblHeading;
         LinearLayout secCountryCode;
         View lineCountryCode;
         TextView VlblCountryCode;
         EditText txtCountryCode;
         LinearLayout secFaciCode;
         View lineFaciCode;
         TextView VlblFaciCode;
         EditText txtFaciCode;
         LinearLayout secRegisType;
         View lineRegisType;
         TextView VlblRegisType;
         EditText txtRegisType;
         LinearLayout secDataID;
         View lineDataID;
         TextView VlblDataID;
         EditText txtDataID;
         LinearLayout secRegDate;
         View lineRegDate;
         TextView VlblRegDate;
         EditText dtpRegDate;
         LinearLayout secRegTime;
         View lineRegTime;
         TextView VlblRegTime;
         EditText txtRegTime;
         LinearLayout secHospID;
         View lineHospID;
         TextView VlblHospID;
         EditText txtHospID;
     EditText txtHospIDReTyp;
         LinearLayout secConsent;
         View lineConsent;
         TextView VlblConsent;
         RadioGroup rdogrpConsent;
         
         RadioButton rdoConsent1;
         RadioButton rdoConsent2;
     RadioButton rdoConsent3;
     RadioButton rdoConsent4;
     RadioButton rdoConsent5;

         LinearLayout secStudyID;
         View lineStudyID;
         TextView VlblStudyID;
         EditText txtStudyID;
         LinearLayout secMotRegis;
         View lineMotRegis;
         TextView VlblMotRegis;
         RadioGroup rdogrpMotRegis;
         
         RadioButton rdoMotRegis1;
         RadioButton rdoMotRegis2;
         LinearLayout secMotStudyID;
         View lineMotStudyID;
         TextView VlblMotStudyID;
         EditText txtMotStudyID;
         LinearLayout secMotHospID;
         View lineMotHospID;
         TextView VlblMotHospID;
         EditText txtMotHospID;
         LinearLayout secMotName;
         View lineMotName;
         TextView VlblMotName;
         EditText txtMotName;
         LinearLayout secMotDOB;
         View lineMotDOB;
         TextView VlblMotDOB;
         EditText dtpMotDOB;
         LinearLayout secMotDOBDK;
         View lineMotDOBDK;
         TextView VlblMotDOBDK;
         CheckBox chkMotDOBDK;
         LinearLayout secMotAge;
         View lineMotAge;
         TextView VlblMotAge;
         EditText txtMotAge;
         LinearLayout secMotEthnicity;

         View lineMotEthnicity;
         TextView VlblMotEthnicity;
         Spinner spnMotEthnicity;

         LinearLayout secMotEthnicityOth;
         EditText txtMotEthnicityOth;
         LinearLayout secMotReligionOth;
         EditText txtMotReligionOth;

         LinearLayout secMotReligion;
         View lineMotReligion;
         TextView VlblMotReligion;
         Spinner spnMotReligion;
         LinearLayout secAddress1;
         View lineAddress1;
         TextView VlblAddress1;
         Spinner spnAddress1;
         AutoCompleteTextView txtAddress2;
         AutoCompleteTextView txtAddress3;
         AutoCompleteTextView txtAddress4;

         LinearLayout secAddress2;
         View lineAddress2;
         TextView VlblAddress2;
         Spinner spnAddress2;
         LinearLayout secAddress3;
         View lineAddress3;
         TextView VlblAddress3;
         Spinner spnAddress3;
         LinearLayout secAddress4;
         View lineAddress4;
         TextView VlblAddress4;
         Spinner spnAddress4;
         LinearLayout secAddressDetail;
         View lineAddressDetail;
         TextView VlblAddressDetail;
         EditText txtAddressDetail;
         LinearLayout secMotContact;
         View lineMotContact;
         TextView VlblMotContact;
         EditText txtMotContact;
         LinearLayout secAltContact;
         View lineAltContact;
         TextView VlblAltContact;
         EditText txtAltContact;
         LinearLayout secNameNewBorn;
         View lineNameNewBorn;
         TextView VlblNameNewBorn;
         EditText txtNameNewBorn;
         LinearLayout secDOBNewborn;
         View lineDOBNewborn;
         TextView VlblDOBNewborn;
         EditText dtpDOBNewborn;
         LinearLayout secAgeNewborn;
         View lineAgeNewborn;
         TextView VlblAgeNewborn;
         EditText txtAgeNewborn;
         LinearLayout secAgeNewbornDMY;
         View lineAgeNewbornDMY;
         TextView VlblAgeNewbornDMY;
         RadioGroup rdogrpAgeNewbornDMY;
         
         RadioButton rdoAgeNewbornDMY1;
         RadioButton rdoAgeNewbornDMY2;
         RadioButton rdoAgeNewbornDMY3;

     LinearLayout secSex;
     RadioGroup rdogrpSex;
     RadioButton rdoSex1;
     RadioButton rdoSex2;
     RadioButton rdoSex3;
     LinearLayout secMotStudyIDReType;
     LinearLayout secFatherName;
     EditText txtFatherName;


     //ObsHisCurPreg
     LinearLayout seccard;
     View linecard;
     TextView Vlblcard;
     RadioGroup rdogrpcard;

     RadioButton rdocard1;
     RadioButton rdocard2;
     RadioButton rdocard7;
     LinearLayout secprevpreg;
     View lineprevpreg;
     TextView Vlblprevpreg;
     EditText txtprevpreg;
     LinearLayout secprevliveb;
     View lineprevliveb;
     TextView Vlblprevliveb;
     EditText txtprevliveb;
     LinearLayout secprevstillb;
     View lineprevstillb;
     TextView Vlblprevstillb;
     EditText txtprevstillb;
     LinearLayout secprevab;
     View lineprevab;
     TextView Vlblprevab;
     EditText txtprevab;
     LinearLayout secprevcsec;
     View lineprevcsec;
     TextView Vlblprevcsec;
     EditText txtprevcsec;
     LinearLayout secyrslstbth;
     View lineyrslstbth;
     TextView Vlblyrslstbth;
     EditText txtyrslstbth;
     LinearLayout secedd;
     View lineedd;
     TextView Vlbledd;
     EditText dtpedd;
     LinearLayout seceddDK;
     View lineeddDK;
     TextView VlbleddDK;
     CheckBox chkeddDK;
     LinearLayout secgaadm;
     LinearLayout secgaadmi;
     View linegaadm;
     TextView Vlblgaadm;
     EditText txtgaadm;
     EditText txtgaadmi;
     LinearLayout secgameth;
     View linegameth;
     TextView Vlblgameth;
     RadioGroup rdogrpgameth;

     RadioButton rdogameth1;
     RadioButton rdogameth2;
     RadioButton rdogameth3;
     RadioButton rdogameth4;
     RadioButton rdogameth5;
     LinearLayout secbb4expect;
     View linebb4expect;
     TextView Vlblbb4expect;
     RadioGroup rdogrpbb4expect;

     RadioButton rdobb4expect1;
     RadioButton rdobb4expect2;
     RadioButton rdobb4expect3;
     LinearLayout secnumbby;
     View linenumbby;
     TextView Vlblnumbby;
     RadioGroup rdogrpnumbby;

     RadioButton rdonumbby1;
     RadioButton rdonumbby2;
     RadioButton rdonumbby3;
     RadioButton rdonumbby4;
     LinearLayout secnumPreg;
     View linenumPreg;
     TextView VlblnumPreg;
     EditText txtnumPreg;
     LinearLayout secbheartadm;
     View linebheartadm;
     TextView Vlblbheartadm;
     RadioGroup rdogrpbheartadm;

     RadioButton rdobheartadm1;
     RadioButton rdobheartadm2;
     RadioButton rdobheartadm3;
     LinearLayout secbheartrateadm;
     View linebheartrateadm;
     TextView Vlblbheartrateadm;
     RadioGroup rdogrpbheartrateadm;

     RadioButton rdobheartrateadm1;
     RadioButton rdobheartrateadm2;
     RadioButton rdobheartrateadm3;
     RadioButton rdobheartrateadm4;
     LinearLayout secbheartratenum;
     View linebheartratenum;
     TextView Vlblbheartratenum;
     EditText txtbheartratenum;
     LinearLayout secanybcompadm;
     View lineanybcompadm;
     TextView Vlblanybcompadm;

     LinearLayout secallocobsv;
     View lineallocobsv;
     TextView Vlblallocobsv;
     RadioGroup rdogrpallocobsv;

     RadioButton rdoallocobsv1;
     RadioButton rdoallocobsv2;

     //KMC Pre Observe
     LinearLayout secadwghedkmc;
     View lineadwghedkmc;
     TextView Vlbladwghedkmc;
     RadioGroup rdogrpadwghedkmc;

     RadioButton rdoadwghedkmc1;
     RadioButton rdoadwghedkmc2;
     RadioButton rdoadwghedkmc3;
     LinearLayout secadwghtkmc;
     View lineadwghtkmc;
     TextView Vlbladwghtkmc;
     EditText txtadwghtkmc;
     //LinearLayout secgaadm;
     //View linegaadm;
     //TextView Vlblgaadm;
     //EditText txtgaadm;
     LinearLayout secplacedeliv;
     View lineplacedeliv;
     TextView Vlblplacedeliv;
     Spinner spnplacedeliv;
     LinearLayout secplacedelivoth;
     View lineplacedelivoth;
     TextView Vlblplacedelivoth;
     EditText txtplacedelivoth;
     LinearLayout secfacnamedeliv;
     View linefacnamedeliv;
     TextView Vlblfacnamedeliv;
     EditText txtfacnamedeliv;
     LinearLayout secKMCPreObs;
     LinearLayout secLDPreObs;
     LinearLayout secgaadmiDK;
     CheckBox chkgaadmiDK;

     CheckBox chkanybcompadma;
     CheckBox chkanybcompadmb;
     CheckBox chkanybcompadmc;
     CheckBox chkanybcompadmd;
     CheckBox chkanybcompadme;
     CheckBox chkanybcompadmf;
     CheckBox chkanybcompadmg;
     CheckBox chkanybcompadmh;
     LinearLayout secanybcompadmoth;
     EditText txtanybcompadmoth;

     LinearLayout secParity;
     Spinner spnParity;

     //Infection Pre Obs
     LinearLayout secInfDelPlace;
     View lineInfDelPlace;
     TextView VlblInfDelPlace;
     Spinner spnInfDelPlace;
     LinearLayout secInfDelPlaceoth;
     View lineInfDelPlaceoth;
     TextView VlblInfDelPlaceoth;
     EditText txtInfDelPlaceoth;
     LinearLayout secInfDelMod;
     View lineInfDelMod;
     TextView VlblInfDelMod;
     Spinner spnInfDelMod;
     LinearLayout seclblh;
     View linelblh;
     LinearLayout secInfMCompa;
     View lineInfMCompa;
     TextView VlblInfMCompa;
     LinearLayout secInfMComp;
     CheckBox chkInfMCompa;
     LinearLayout secInfMCompb;
     View lineInfMCompb;
     TextView VlblInfMCompb;
     CheckBox chkInfMCompb;
     LinearLayout secInfMCompc;
     View lineInfMCompc;
     TextView VlblInfMCompc;
     CheckBox chkInfMCompc;
     LinearLayout secInfMCompd;
     View lineInfMCompd;
     TextView VlblInfMCompd;
     CheckBox chkInfMCompd;
     LinearLayout secInfMCompe;
     View lineInfMCompe;
     TextView VlblInfMCompe;
     CheckBox chkInfMCompe;
     LinearLayout secInfMCompf;
     View lineInfMCompf;
     TextView VlblInfMCompf;
     CheckBox chkInfMCompf;
     LinearLayout secInfMCompg;
     View lineInfMCompg;
     TextView VlblInfMCompg;
     CheckBox chkInfMCompg;
     LinearLayout secInfGAge;
     View lineInfGAge;
     TextView VlblInfGAge;
     EditText txtInfGAge;
     LinearLayout secInfGAgeDK;
     View lineInfGAgeDK;
     TextView VlblInfGAgeDK;
     CheckBox chkInfGAgeDK;
     LinearLayout secInfBWeight;
     View lineInfBWeight;
     TextView VlblInfBWeight;
     EditText txtInfBWeight;
     LinearLayout secInfBWeightDK;
     View lineInfBWeightDK;
     TextView VlblInfBWeightDK;
     CheckBox chkInfBWeightDK;



    static String TableName;

    static String STARTTIME = "";
    static String DEVICEID  = "";
    static String ENTRYUSER = "";
    MySharedPreferences sp;

    Bundle IDbundle;
    static String COUNTRYCODE = "";
    static String FACICODE = "";
    static String DATAID = "";
    static String LOCATIONID = "";
    static String JOBTYPE     = "";
    static String JOBLOCATION = "";
    static String SID = "";

    TextView lblTitle;
    LinearLayout seclbl1;
     Button cmdMotID;

     LinearLayout secTOBNewborn;
     EditText txtTOBNewborn;
     LinearLayout secTOBNewbornDK;
     CheckBox chkTOBNewbornDK;

     LinearLayout secInfection;

 public void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
   try
     {
         setContentView(R.layout.registration);
         C = new Connection(this);
         g = Global.getInstance();
         getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

         STARTTIME   = g.CurrentTime24();
         DEVICEID    = sp.getValue(this, "deviceid");
         ENTRYUSER   = sp.getValue(this, "userid");
         COUNTRYCODE = sp.getValue(this, "countrycode");
         FACICODE    = sp.getValue(this, "facicode");
         JOBTYPE     = sp.getValue(this, "jobtype");

         IDbundle = getIntent().getExtras();
         DATAID      = IDbundle.getString("dataid");
         LOCATIONID  = IDbundle.getString("locationid");
         SID  = IDbundle.getString("sid");

         TableName = "Registration";

         //turnGPSOn();

         //GPS Location
         //FindLocation();
         // Double.toString(currentLatitude);
         // Double.toString(currentLongitude);
         secConReason=(LinearLayout)findViewById(R.id.secConReason) ;
         txtConReason=(EditText)findViewById(R.id.txtConReason) ;

         secInfection = (LinearLayout)findViewById(R.id.secInfection);

         secTOBNewborn=(LinearLayout)findViewById(R.id.secTOBNewborn) ;
         txtTOBNewborn=(EditText)findViewById(R.id.txtTOBNewborn) ;
         secTOBNewbornDK=(LinearLayout)findViewById(R.id.secTOBNewbornDK) ;
         chkTOBNewbornDK=(CheckBox)findViewById(R.id.chkTOBNewbornDK) ;


         secParity=(LinearLayout)findViewById(R.id.secParity) ;
         spnParity=(Spinner)findViewById(R.id.spnParity) ;
         List<String> listPatiry = new ArrayList<String>();
         listPatiry.add("");
         listPatiry.add("1-Primipara");
         listPatiry.add("2-Multipara");
         listPatiry.add("3-Grand Multipara");
         listPatiry.add("9-Don't know");

         ArrayAdapter<String> adptrParity= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listPatiry);
         spnParity.setAdapter(adptrParity);

         secMotEdu=(LinearLayout)findViewById(R.id.secMotEdu) ;
         txtMotEdu=(EditText)findViewById(R.id.txtMotEdu) ;
         secMotEduDK=(LinearLayout)findViewById(R.id.secMotEduDK) ;
         chkMotEduDK=(CheckBox)findViewById(R.id.chkMotEduDK) ;

         txtMotDataID=(EditText)findViewById(R.id.txtMotDataID);
         chkadwghtkmcDK=(CheckBox)findViewById(R.id.chkadwghtkmcDK) ;
         chkgaadmDK=(CheckBox)findViewById(R.id.chkgaadmDK) ;

         secDOBNewbornDK=(LinearLayout)findViewById(R.id.secDOBNewbornDK) ;
         chkDOBNewbornDK=(CheckBox)findViewById(R.id.chkDOBNewbornDK) ;

         txtAddress2=(AutoCompleteTextView)findViewById(R.id.txtAddress2);
         txtAddress2.setAdapter(C.getArrayAdapter("Select distinct UpName Address2 from AreaDB union Select distinct Address2 from Registration order by Address2"));
         txtAddress2.setOnTouchListener(new View.OnTouchListener() {
             @Override
             public boolean onTouch(View v, MotionEvent event) {
                 final int DRAWABLE_RIGHT = 2;
                 if(event.getAction() == MotionEvent.ACTION_UP) {
                     if(event.getRawX() >= (txtAddress2.getRight() - txtAddress2.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                         ((EditText)v).setText("");
                         txtAddress2.setText("");
                         return true;
                     }
                 }
                 return false;
             }
         });

         txtAddress3=(AutoCompleteTextView)findViewById(R.id.txtAddress3);
         txtAddress3.setAdapter(C.getArrayAdapter("Select distinct UnName Address3 from AreaDB union Select distinct Address3 from Registration order by Address3"));
         txtAddress3.setOnTouchListener(new View.OnTouchListener() {
             @Override
             public boolean onTouch(View v, MotionEvent event) {
                 final int DRAWABLE_RIGHT = 2;
                 if(event.getAction() == MotionEvent.ACTION_UP) {
                     if(event.getRawX() >= (txtAddress3.getRight() - txtAddress3.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                         ((EditText)v).setText("");
                         txtAddress3.setText("");
                         return true;
                     }
                 }
                 return false;
             }
         });



         txtAddress4=(AutoCompleteTextView)findViewById(R.id.txtAddress4);
         txtAddress4.setAdapter(C.getArrayAdapter("Select distinct VillName Address4 from AreaDB union Select distinct Address4 from Registration order by Address4"));
         txtAddress4.setOnTouchListener(new View.OnTouchListener() {
             @Override
             public boolean onTouch(View v, MotionEvent event) {
                 final int DRAWABLE_RIGHT = 2;
                 if(event.getAction() == MotionEvent.ACTION_UP) {
                     if(event.getRawX() >= (txtAddress4.getRight() - txtAddress4.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                         ((EditText)v).setText("");
                         txtAddress4.setText("");
                         return true;
                     }
                 }
                 return false;
             }
         });

         chkprevpregDK=(CheckBox)findViewById(R.id.chkprevpregDK) ;
         chkprevlivebDK=(CheckBox)findViewById(R.id.chkprevlivebDK) ;
         chkprevstillbDK=(CheckBox)findViewById(R.id.chkprevstillbDK) ;
         chkprevabDK=(CheckBox)findViewById(R.id.chkprevabDK) ;
         chkprevcsecDK=(CheckBox)findViewById(R.id.chkprevcsecDK) ;
         chkyrslstbthDK=(CheckBox)findViewById(R.id.chkyrslstbthDK) ;

         chkanybcompadma=(CheckBox)findViewById(R.id.chkanybcompadma) ;
         chkanybcompadmb=(CheckBox)findViewById(R.id.chkanybcompadmb) ;
         chkanybcompadmc=(CheckBox)findViewById(R.id.chkanybcompadmc) ;
         chkanybcompadmd=(CheckBox)findViewById(R.id.chkanybcompadmd) ;
         chkanybcompadme=(CheckBox)findViewById(R.id.chkanybcompadme) ;
         chkanybcompadmf=(CheckBox)findViewById(R.id.chkanybcompadmf) ;
         chkanybcompadmg=(CheckBox)findViewById(R.id.chkanybcompadmg) ;
         chkanybcompadmh=(CheckBox)findViewById(R.id.chkanybcompadmh) ;

         secanybcompadmoth=(LinearLayout)findViewById(R.id.secanybcompadmoth) ;
         txtanybcompadmoth=(EditText)findViewById(R.id.txtanybcompadmoth) ;

         secMotEthnicityOth=(LinearLayout)findViewById(R.id.secMotEthnicityOth) ;
         txtMotEthnicityOth=(EditText)findViewById(R.id.txtMotEthnicityOth) ;
         secMotReligionOth=(LinearLayout)findViewById(R.id.secMotReligionOth) ;
         txtMotReligionOth=(EditText)findViewById(R.id.txtMotReligionOth) ;

         secgaadmiDK = (LinearLayout)findViewById(R.id.secgaadmiDK);
         chkgaadmiDK = (CheckBox)findViewById(R.id.chkgaadmiDK);

         secKMCPreObs = (LinearLayout)findViewById(R.id.secKMCPreObs);
         secLDPreObs = (LinearLayout)findViewById(R.id.secLDPreObs);

         secFatherName=(LinearLayout)findViewById(R.id.secFatherName);
         txtFatherName=(EditText)findViewById(R.id.txtFatherName);

         txtMotStudyIDReType = (EditText)findViewById(R.id.txtMotStudyIDReType);
         seclbl1 = (LinearLayout)findViewById(R.id.seclbl1);
         secMotStudyIDReType = (LinearLayout)findViewById(R.id.secMotStudyIDReType);
         lblHeading = (TextView)findViewById(R.id.lblHeading);
         secMotRegis=(LinearLayout)findViewById(R.id.secMotRegis);
         lblTitle = (TextView)findViewById(R.id.lblTitle);
         secNameNewBorn=(LinearLayout)findViewById(R.id.secNameNewBorn);
         secDOBNewborn=(LinearLayout)findViewById(R.id.secDOBNewborn);
         secAgeNewborn=(LinearLayout)findViewById(R.id.secAgeNewborn);
         secAgeNewbornDMY=(LinearLayout)findViewById(R.id.secAgeNewbornDMY);
         lineNameNewBorn=(View)findViewById(R.id.lineNameNewBorn);
         lineDOBNewborn=(View)findViewById(R.id.lineDOBNewborn);
         lineAgeNewborn=(View)findViewById(R.id.lineAgeNewborn);
         lineAgeNewbornDMY=(View)findViewById(R.id.lineAgeNewbornDMY);
         secSex=(LinearLayout)findViewById(R.id.secSex);
         rdogrpSex=(RadioGroup)findViewById(R.id.rdogrpSex) ;
         rdoSex1=(RadioButton)findViewById(R.id.rdoSex1) ;
         rdoSex2=(RadioButton)findViewById(R.id.rdoSex2) ;
         rdoSex3=(RadioButton)findViewById(R.id.rdoSex3) ;

         ImageButton cmdBack = (ImageButton) findViewById(R.id.cmdBack);
         cmdBack.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
                 AlertDialog.Builder adb = new AlertDialog.Builder(Registration.this);
                 adb.setTitle("Close");
                 adb.setMessage("Do you want to close this form[Yes/No]?");
                 adb.setNegativeButton("No", null);
                 adb.setPositiveButton("Yes", new AlertDialog.OnClickListener() {
                     public void onClick(DialogInterface dialog, int which) {
                         finish();
                     }});
                 adb.show();
             }});


         secCountryCode=(LinearLayout)findViewById(R.id.secCountryCode);
         lineCountryCode=(View)findViewById(R.id.lineCountryCode);
         VlblCountryCode=(TextView) findViewById(R.id.VlblCountryCode);
         txtCountryCode=(EditText) findViewById(R.id.txtCountryCode);
         txtCountryCode.setText(COUNTRYCODE);
         secFaciCode=(LinearLayout)findViewById(R.id.secFaciCode);
         lineFaciCode=(View)findViewById(R.id.lineFaciCode);
         VlblFaciCode=(TextView) findViewById(R.id.VlblFaciCode);
         txtFaciCode=(EditText) findViewById(R.id.txtFaciCode);
         txtFaciCode.setText(FACICODE);
         secRegisType=(LinearLayout)findViewById(R.id.secRegisType);
         lineRegisType=(View)findViewById(R.id.lineRegisType);
         VlblRegisType=(TextView) findViewById(R.id.VlblRegisType);
         txtRegisType=(EditText) findViewById(R.id.txtRegisType);
         txtRegisType.setText(LOCATIONID);
         secDataID=(LinearLayout)findViewById(R.id.secDataID);
         lineDataID=(View)findViewById(R.id.lineDataID);
         VlblDataID=(TextView) findViewById(R.id.VlblDataID);
         txtDataID=(EditText) findViewById(R.id.txtDataID);
         if(DATAID.length()==0)
             txtDataID.setText(NewDataID(DEVICEID));
         else
             txtDataID.setText(DATAID);

         secRegDate=(LinearLayout)findViewById(R.id.secRegDate);
         lineRegDate=(View)findViewById(R.id.lineRegDate);
         VlblRegDate=(TextView) findViewById(R.id.VlblRegDate);
         dtpRegDate=(EditText) findViewById(R.id.dtpRegDate);
         dtpRegDate.setText(Global.DateNowDMY());
         secRegTime=(LinearLayout)findViewById(R.id.secRegTime);
         lineRegTime=(View)findViewById(R.id.lineRegTime);
         VlblRegTime=(TextView) findViewById(R.id.VlblRegTime);
         txtRegTime=(EditText) findViewById(R.id.txtRegTime);
         txtRegTime.setText(g.CurrentTime24());
         secHospID=(LinearLayout)findViewById(R.id.secHospID);
         lineHospID=(View)findViewById(R.id.lineHospID);
         VlblHospID=(TextView) findViewById(R.id.VlblHospID);
         txtHospID=(EditText) findViewById(R.id.txtHospID);
         txtHospIDReTyp=(EditText) findViewById(R.id.txtHospIDReTyp);

         secConsent=(LinearLayout)findViewById(R.id.secConsent);
         lineConsent=(View)findViewById(R.id.lineConsent);
         VlblConsent = (TextView) findViewById(R.id.VlblConsent);
         rdogrpConsent = (RadioGroup) findViewById(R.id.rdogrpConsent);
         
         rdoConsent1 = (RadioButton) findViewById(R.id.rdoConsent1);
         rdoConsent2 = (RadioButton) findViewById(R.id.rdoConsent2);
         rdoConsent3 = (RadioButton) findViewById(R.id.rdoConsent3);
         rdoConsent4 = (RadioButton) findViewById(R.id.rdoConsent4);
         rdoConsent5 = (RadioButton) findViewById(R.id.rdoConsent5);

         rdogrpConsent.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpConsent = new String[] {"1","2","3","4","5"};
             for (int i = 0; i < rdogrpConsent.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpConsent.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpConsent[i];
             }

             if(rbData.equalsIgnoreCase("1") | rbData.equalsIgnoreCase("5"))
             {
                 if(SID.length()==0)
                     txtStudyID.setText(NewStudyID(DEVICEID));
                 else
                     txtStudyID.setText(SID);

                 secStudyID.setVisibility(View.VISIBLE);
                 lineStudyID.setVisibility(View.VISIBLE);
                 secConReason.setVisibility(View.GONE);
                 txtConReason.setText("");
                 secAddress1.setVisibility(View.VISIBLE);
                 lineAddress1.setVisibility(View.VISIBLE);
                 secAddress2.setVisibility(View.VISIBLE);
                 lineAddress2.setVisibility(View.VISIBLE);
                 secAddress3.setVisibility(View.VISIBLE);
                 lineAddress3.setVisibility(View.VISIBLE);
                 secAddress4.setVisibility(View.VISIBLE);
                 lineAddress4.setVisibility(View.VISIBLE);

                 //1-Bangladesh, 2-Nepal, 3-Tanzania
                 if(COUNTRYCODE.equals(ProjectSetting.BANGLADESH))
                 {
                     VlblAddress1.setText("a. District");
                     VlblAddress2.setText("b. Upazila/Thana");
                     VlblAddress3.setText("c. Union/Ward");
                     VlblAddress4.setText("d. Village/Moholla");
                     //secAddress4.setVisibility(View.GONE);
                 }
                 else if(COUNTRYCODE.equals(ProjectSetting.NEPAL))
                 {
                     VlblAddress1.setText("a. District");
                     VlblAddress2.setText("b. Municipailty/VDC");
                     VlblAddress3.setText("c. Ward Number");
                     VlblAddress4.setText("d. Street/Tole");
                     //secAddress4.setVisibility(View.GONE);
                 }
                 else if(COUNTRYCODE.equals(ProjectSetting.TANZANIA))
                 {
                     VlblAddress1.setText("a. District");
                     VlblAddress2.setText("b. Ward");
                     VlblAddress3.setText("c. Street");
                     secAddress4.setVisibility(View.GONE);
                 }


                 secAddressDetail.setVisibility(View.VISIBLE);
                 lineAddressDetail.setVisibility(View.VISIBLE);
                 secMotContact.setVisibility(View.VISIBLE);
                 lineMotContact.setVisibility(View.VISIBLE);
                 secAltContact.setVisibility(View.VISIBLE);
                 lineAltContact.setVisibility(View.VISIBLE);
                 seclbl1.setVisibility(View.VISIBLE);
                    /*secNameNewBorn.setVisibility(View.VISIBLE);
                    lineNameNewBorn.setVisibility(View.VISIBLE);
                    secDOBNewborn.setVisibility(View.VISIBLE);
                    lineDOBNewborn.setVisibility(View.VISIBLE);
                    secAgeNewborn.setVisibility(View.VISIBLE);
                    lineAgeNewborn.setVisibility(View.VISIBLE);
                    secAgeNewbornDMY.setVisibility(View.VISIBLE);
                    lineAgeNewbornDMY.setVisibility(View.VISIBLE);*/

                 if(LOCATIONID.equals(ProjectSetting.LABOR_AND_DELIVERY_ID)){
                     secMotRegis.setVisibility(View.GONE);
                     secNameNewBorn.setVisibility(View.GONE);
                     lineNameNewBorn.setVisibility(View.GONE);
                     secDOBNewborn.setVisibility(View.GONE);
                     secDOBNewbornDK.setVisibility(View.GONE);

                     secTOBNewborn.setVisibility(View.GONE);
                     secTOBNewbornDK.setVisibility(View.GONE);

                     secTOBNewborn.setVisibility(View.GONE);
                     secTOBNewbornDK.setVisibility(View.GONE);

                     lineDOBNewborn.setVisibility(View.GONE);
                     secAgeNewborn.setVisibility(View.GONE);
                     secAgeNewbornDMY.setVisibility(View.GONE);
                     secSex.setVisibility(View.GONE);
                     rdogrpSex.clearCheck();
                     secMotStudyIDReType.setVisibility(View.GONE);
                     secFatherName.setVisibility(View.GONE);

                     secKMCPreObs.setVisibility(View.GONE);
                     secLDPreObs.setVisibility(View.VISIBLE);

                     secInfection.setVisibility(View.GONE);

                 }else if(LOCATIONID.equals(ProjectSetting.KMC_ID)){
                     secMotRegis.setVisibility(View.VISIBLE);
                     secNameNewBorn.setVisibility(View.VISIBLE);
                     lineNameNewBorn.setVisibility(View.VISIBLE);
                     secDOBNewborn.setVisibility(View.VISIBLE);
                     secDOBNewbornDK.setVisibility(View.VISIBLE);

                     secTOBNewborn.setVisibility(View.VISIBLE);
                     secTOBNewbornDK.setVisibility(View.VISIBLE);

                     lineDOBNewborn.setVisibility(View.VISIBLE);
                     secAgeNewborn.setVisibility(View.VISIBLE);
                     secAgeNewbornDMY.setVisibility(View.GONE);
                     secSex.setVisibility(View.VISIBLE);
                     secMotStudyIDReType.setVisibility(View.GONE);
                     secFatherName.setVisibility(View.VISIBLE);

                     secKMCPreObs.setVisibility(View.VISIBLE);
                     secLDPreObs.setVisibility(View.GONE);

                     secInfection.setVisibility(View.GONE);
                 }else if(LOCATIONID.equals(ProjectSetting.SEPSIS_ID)){
                     secMotRegis.setVisibility(View.VISIBLE);
                     secNameNewBorn.setVisibility(View.VISIBLE);
                     lineNameNewBorn.setVisibility(View.VISIBLE);
                     secDOBNewborn.setVisibility(View.VISIBLE);
                     secDOBNewbornDK.setVisibility(View.VISIBLE);

                     secTOBNewborn.setVisibility(View.VISIBLE);
                     secTOBNewbornDK.setVisibility(View.VISIBLE);

                     lineDOBNewborn.setVisibility(View.VISIBLE);
                     secAgeNewborn.setVisibility(View.VISIBLE);
                     secAgeNewbornDMY.setVisibility(View.GONE);
                     secSex.setVisibility(View.VISIBLE);
                     secMotStudyIDReType.setVisibility(View.GONE);
                     secFatherName.setVisibility(View.VISIBLE);

                     secKMCPreObs.setVisibility(View.GONE);
                     secLDPreObs.setVisibility(View.GONE);

                     secInfection.setVisibility(View.VISIBLE);
                 }
             }
             else
             {
                 if(rbData.equalsIgnoreCase("4")){
                    secConReason.setVisibility(View.VISIBLE);
                 }else{
                     secConReason.setVisibility(View.GONE);
                     txtConReason.setText("");
                 }


                    secStudyID.setVisibility(View.GONE);
                    lineStudyID.setVisibility(View.GONE);
                    txtStudyID.setText("");

                    secAddress1.setVisibility(View.GONE);
                    lineAddress1.setVisibility(View.GONE);
                    spnAddress1.setSelection(0);
                    secAddress2.setVisibility(View.GONE);
                    lineAddress2.setVisibility(View.GONE);
                    txtAddress2.setText("");
                    secAddress3.setVisibility(View.GONE);
                    lineAddress3.setVisibility(View.GONE);
                 txtAddress3.setText("");
                    secAddress4.setVisibility(View.GONE);
                    lineAddress4.setVisibility(View.GONE);
                 txtAddress4.setText("");
                    secAddressDetail.setVisibility(View.GONE);
                    lineAddressDetail.setVisibility(View.GONE);
                    txtAddressDetail.setText("");
                    secMotContact.setVisibility(View.GONE);
                    lineMotContact.setVisibility(View.GONE);
                    txtMotContact.setText("");
                    secAltContact.setVisibility(View.GONE);
                    lineAltContact.setVisibility(View.GONE);
                    txtAltContact.setText("");
                    secNameNewBorn.setVisibility(View.GONE);
                    lineNameNewBorn.setVisibility(View.GONE);
                    txtNameNewBorn.setText("");
                    secDOBNewborn.setVisibility(View.GONE);
                 secDOBNewbornDK.setVisibility(View.GONE);

                 secTOBNewborn.setVisibility(View.GONE);
                 secTOBNewbornDK.setVisibility(View.GONE);
                 txtTOBNewborn.setText("");
                 chkTOBNewbornDK.setChecked(false);

                    lineDOBNewborn.setVisibility(View.GONE);
                    dtpDOBNewborn.setText("");
                    secAgeNewborn.setVisibility(View.GONE);
                    lineAgeNewborn.setVisibility(View.GONE);
                    txtAgeNewborn.setText("");
                    secAgeNewbornDMY.setVisibility(View.GONE);
                    //lineAgeNewbornDMY.setVisibility(View.GONE);
                    rdogrpAgeNewbornDMY.clearCheck();
                    secSex.setVisibility(View.GONE);
                    rdogrpSex.clearCheck();
                    seclbl1.setVisibility(View.GONE);
                    secFatherName.setVisibility(View.GONE);
                    secMotStudyIDReType.setVisibility(View.GONE);

                 secKMCPreObs.setVisibility(View.GONE);
                 secLDPreObs.setVisibility(View.GONE);
                 secInfection.setVisibility(View.GONE);

                 if(LOCATIONID.equals(ProjectSetting.LABOR_AND_DELIVERY_ID)){
                     rdogrpcard.clearCheck();
                     txtprevpreg.setText("");
                     chkprevpregDK.setChecked(false);
                     txtprevliveb.setText("");
                     chkprevlivebDK.setChecked(false);
                     txtprevstillb.setText("");
                     chkprevstillbDK.setChecked(false);
                     txtprevab.setText("");
                     chkprevabDK.setChecked(false);
                     txtprevcsec.setText("");
                     chkprevcsecDK.setChecked(false);
                     txtyrslstbth.setText("");
                     chkyrslstbthDK.setChecked(false);
                     dtpedd.setText("");
                     chkeddDK.setChecked(false);
                     txtgaadmi.setText("");
                     chkgaadmiDK.setChecked(false);
                     rdogrpgameth.clearCheck();
                     rdogrpbb4expect.clearCheck();
                     rdogrpnumbby.clearCheck();
                     txtnumPreg.setText("");
                     rdogrpbheartadm.clearCheck();
                     rdogrpbheartrateadm.clearCheck();
                     txtbheartratenum.setText("");

                     chkanybcompadmg.setChecked(true);
                     chkanybcompadmg.setChecked(false);
                     chkanybcompadmh.setChecked(false);
                     txtanybcompadmoth.setText("");
                     rdogrpallocobsv.clearCheck();

                 }else if(LOCATIONID.equals(ProjectSetting.KMC_ID)){
                     rdogrpadwghedkmc.clearCheck();
                     txtadwghtkmc.setText("");
                     chkadwghtkmcDK.setChecked(false);
                     txtgaadm.setText("");
                     chkgaadmDK.setChecked(false);
                     spnplacedeliv.setSelection(0);
                     txtplacedelivoth.setText("");
                     txtfacnamedeliv.setText("");
                 }
             }

            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secStudyID=(LinearLayout)findViewById(R.id.secStudyID);
         lineStudyID=(View)findViewById(R.id.lineStudyID);
         VlblStudyID=(TextView) findViewById(R.id.VlblStudyID);
         txtStudyID=(EditText) findViewById(R.id.txtStudyID);

         lineMotRegis=(View)findViewById(R.id.lineMotRegis);
         VlblMotRegis = (TextView) findViewById(R.id.VlblMotRegis);
         rdogrpMotRegis = (RadioGroup) findViewById(R.id.rdogrpMotRegis);
         
         rdoMotRegis1 = (RadioButton) findViewById(R.id.rdoMotRegis1);
         rdoMotRegis2 = (RadioButton) findViewById(R.id.rdoMotRegis2);
         rdogrpMotRegis.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
         @Override
         public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
             String rbData = "";
             RadioButton rb;
             String[] d_rdogrpMotRegis = new String[] {"1","2"};
             for (int i = 0; i < rdogrpMotRegis.getChildCount(); i++)
             {
               rb = (RadioButton)rdogrpMotRegis.getChildAt(i);
               if (rb.isChecked()) rbData = d_rdogrpMotRegis[i];
             }

             if(rbData.equalsIgnoreCase("2"))
             {
                    secMotStudyID.setVisibility(View.GONE);
                    lineMotStudyID.setVisibility(View.GONE);
                    txtMotStudyID.setText("");
                    secMotHospID.setVisibility(View.GONE);
                    lineMotHospID.setVisibility(View.GONE);
                    txtMotHospID.setText("");
                    secMotStudyIDReType.setVisibility(View.GONE);
                    txtMotStudyIDReType.setText("");

                 txtMotName.setText("");
                 dtpMotDOB.setText("");
                 txtMotAge.setText("");
                 spnMotEthnicity.setSelection(0);
                 spnMotReligion.setSelection(0);
                 spnAddress1.setSelection(0);
                 spnAddress2.setSelection(0);
                 spnAddress3.setSelection(0);
                 spnAddress4.setSelection(0);
                 txtAddressDetail.setText("");
                 txtMotContact.setText("");
                 txtAltContact.setText("");
             }
             else
             {
                    secMotStudyID.setVisibility(View.VISIBLE);
                    lineMotStudyID.setVisibility(View.VISIBLE);
                    secMotHospID.setVisibility(View.VISIBLE);
                    lineMotHospID.setVisibility(View.VISIBLE);
                    secMotStudyIDReType.setVisibility(View.VISIBLE);
             }
            }
         public void onNothingSelected(AdapterView<?> adapterView) {
             return;
            } 
         }); 
         secMotStudyID=(LinearLayout)findViewById(R.id.secMotStudyID);
         lineMotStudyID=(View)findViewById(R.id.lineMotStudyID);
         VlblMotStudyID=(TextView) findViewById(R.id.VlblMotStudyID);
         txtMotStudyID=(EditText) findViewById(R.id.txtMotStudyID);
         secMotHospID=(LinearLayout)findViewById(R.id.secMotHospID);
         lineMotHospID=(View)findViewById(R.id.lineMotHospID);
         VlblMotHospID=(TextView) findViewById(R.id.VlblMotHospID);
         txtMotHospID=(EditText) findViewById(R.id.txtMotHospID);
         secMotName=(LinearLayout)findViewById(R.id.secMotName);
         lineMotName=(View)findViewById(R.id.lineMotName);
         VlblMotName=(TextView) findViewById(R.id.VlblMotName);
         txtMotName=(EditText) findViewById(R.id.txtMotName);
         secMotDOB=(LinearLayout)findViewById(R.id.secMotDOB);
         lineMotDOB=(View)findViewById(R.id.lineMotDOB);
         VlblMotDOB=(TextView) findViewById(R.id.VlblMotDOB);
         dtpMotDOB=(EditText) findViewById(R.id.dtpMotDOB);
         secMotDOBDK=(LinearLayout)findViewById(R.id.secMotDOBDK);
         lineMotDOBDK=(View)findViewById(R.id.lineMotDOBDK);
         VlblMotDOBDK=(TextView) findViewById(R.id.VlblMotDOBDK);
         chkMotDOBDK=(CheckBox) findViewById(R.id.chkMotDOBDK);
         secMotAge=(LinearLayout)findViewById(R.id.secMotAge);
         lineMotAge=(View)findViewById(R.id.lineMotAge);
         VlblMotAge=(TextView) findViewById(R.id.VlblMotAge);
         txtMotAge=(EditText) findViewById(R.id.txtMotAge);
         secMotEthnicity=(LinearLayout)findViewById(R.id.secMotEthnicity);
         lineMotEthnicity=(View)findViewById(R.id.lineMotEthnicity);
         VlblMotEthnicity=(TextView) findViewById(R.id.VlblMotEthnicity);
         spnMotEthnicity=(Spinner) findViewById(R.id.spnMotEthnicity);
         List<String> listMotEthnicity = new ArrayList<String>();


         if(COUNTRYCODE.equals(ProjectSetting.TANZANIA)) {
             listMotEthnicity.add("");
             listMotEthnicity.add("101-Arusha");
             listMotEthnicity.add("102-Bena");
             listMotEthnicity.add("103-Bondei");
             listMotEthnicity.add("104-Chaga");
             listMotEthnicity.add("105-Digo");
             listMotEthnicity.add("106-Fipa");
             listMotEthnicity.add("107-Gogo");
             listMotEthnicity.add("108-Gweno");
             listMotEthnicity.add("109-Hangaza");
             listMotEthnicity.add("110-Haya");
             listMotEthnicity.add("111-Hehe");
             listMotEthnicity.add("112-Irak");
             listMotEthnicity.add("113-Jita");
             listMotEthnicity.add("114-Kaburu");
             listMotEthnicity.add("115-Kamba");
             listMotEthnicity.add("116-Kerewe");
             listMotEthnicity.add("117-Kinga");
             listMotEthnicity.add("118-Kuria");
             listMotEthnicity.add("119-Kwere");
             listMotEthnicity.add("120-Luguru");
             listMotEthnicity.add("121-Luo");
             listMotEthnicity.add("122-Masai");
             listMotEthnicity.add("123-Machinga");
             listMotEthnicity.add("124-Mbulu");
             listMotEthnicity.add("125-Mangonde");
             listMotEthnicity.add("126-Makua");
             listMotEthnicity.add("127-Manyema");
             listMotEthnicity.add("128-Manda");
             listMotEthnicity.add("129-Matumbi");
             listMotEthnicity.add("130-Meru");
             listMotEthnicity.add("131-Mwera");
             listMotEthnicity.add("132-Ndali");
             listMotEthnicity.add("133-Ndamba");
             listMotEthnicity.add("134-Ndendeure");
             listMotEthnicity.add("135-Ndengereko");
             listMotEthnicity.add("136-Ngindo");
             listMotEthnicity.add("137-Ngoni");
             listMotEthnicity.add("138-Ngazija");
             listMotEthnicity.add("139-Nyakyusa");
             listMotEthnicity.add("140-Nyasa");
             listMotEthnicity.add("141-Nyamwezi");
             listMotEthnicity.add("142-Nyaturu");
             listMotEthnicity.add("143-Nyiha");
             listMotEthnicity.add("144-Nyiramba");
             listMotEthnicity.add("145-Pare");
             listMotEthnicity.add("146-Pogoro");
             listMotEthnicity.add("147-Rangi");
             listMotEthnicity.add("148-Rufiji");
             listMotEthnicity.add("149-Sambaa");
             listMotEthnicity.add("150-Sukuma");
             listMotEthnicity.add("151-Yao");
             listMotEthnicity.add("152-Zaramo");
             listMotEthnicity.add("153-Zigua");
             listMotEthnicity.add("154-Zinza");
             listMotEthnicity.add("155-Zanzibari");
             listMotEthnicity.add("777-Others");
         }else if(COUNTRYCODE.equals(ProjectSetting.NEPAL)){
             listMotEthnicity.add("");
             listMotEthnicity.add("101-Dalit");
             listMotEthnicity.add("102-Disadvantaged Janajatis");
             listMotEthnicity.add("103-Disadvantaged non Dalit Terai Caste Groups");
             listMotEthnicity.add("104-Religious Minorities");
             listMotEthnicity.add("105-Relatively advantaged Janajatis");
             listMotEthnicity.add("106-Upper Caste Groups");
             /*listMotEthnicity.add("101-Hill Brahman/Chhetri");
             listMotEthnicity.add("102-Terai/Madhesi Brahman/Chhetri");
             listMotEthnicity.add("103-Terai/Madhesi Other Castes");
             listMotEthnicity.add("104-Dalits");
             listMotEthnicity.add("105-Newar");
             listMotEthnicity.add("106-Janajati");
             listMotEthnicity.add("107-Muslim");*/
             listMotEthnicity.add("777-Others");
         }else if(COUNTRYCODE.equals(ProjectSetting.BANGLADESH)){
             listMotEthnicity.add("888-Not Applicable");
         }


         ArrayAdapter<String> adptrMotEthnicity= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listMotEthnicity);
         spnMotEthnicity.setAdapter(adptrMotEthnicity);
         spnMotEthnicity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                 String rel = spnMotEthnicity.getSelectedItemPosition()==0?"":spnMotEthnicity.getSelectedItem().toString().split("-")[0];
                 if(rel.equals("777")) secMotEthnicityOth.setVisibility(View.VISIBLE);
                 else {
                     secMotEthnicityOth.setVisibility(View.GONE);
                     txtMotEthnicityOth.setText("");
                 }
             }

             @Override
             public void onNothingSelected(AdapterView<?> parentView) {
                 // your code here
             }

         });


         secMotReligion=(LinearLayout)findViewById(R.id.secMotReligion);
         lineMotReligion=(View)findViewById(R.id.lineMotReligion);
         VlblMotReligion=(TextView) findViewById(R.id.VlblMotReligion);
         spnMotReligion=(Spinner) findViewById(R.id.spnMotReligion);
         List<String> listMotReligion = new ArrayList<String>();

         if(COUNTRYCODE.equals(ProjectSetting.BANGLADESH)|COUNTRYCODE.equals(ProjectSetting.NEPAL)) {
             listMotReligion.add("");
             listMotReligion.add("1-Muslim");
             listMotReligion.add("2-Hindu");
             listMotReligion.add("3-Buddhist");
             listMotReligion.add("4-Christian");
             listMotReligion.add("7-Others");
         }else{
             listMotReligion.add("8-Not Applicable");
         }

         ArrayAdapter<String> adptrMotReligion= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listMotReligion);
         spnMotReligion.setAdapter(adptrMotReligion);
         spnMotReligion.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                 String rel = spnMotReligion.getSelectedItemPosition()==0?"":spnMotReligion.getSelectedItem().toString().split("-")[0];
                 if(rel.equals("7")) secMotReligionOth.setVisibility(View.VISIBLE);
                 else {
                     secMotReligionOth.setVisibility(View.GONE);
                     txtMotReligionOth.setText("");
                 }
             }

             @Override
             public void onNothingSelected(AdapterView<?> parentView) {
                 // your code here
             }

         });

         secAddress1=(LinearLayout)findViewById(R.id.secAddress1);
         lineAddress1=(View)findViewById(R.id.lineAddress1);
         VlblAddress1=(TextView) findViewById(R.id.VlblAddress1);
         spnAddress1=(Spinner) findViewById(R.id.spnAddress1);
         spnAddress1.setAdapter(C.getArrayAdapter("Select '' union Select distinct District||'-'||DistName from AreaDB where CCode='"+ COUNTRYCODE +"'"));
         /*List<String> listAddress1 = new ArrayList<String>();
         
         listAddress1.add("");
         listAddress1.add("01-Leve1");
         ArrayAdapter<String> adptrAddress1= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listAddress1);
         spnAddress1.setAdapter(adptrAddress1);*/

         secAddress2=(LinearLayout)findViewById(R.id.secAddress2);
         lineAddress2=(View)findViewById(R.id.lineAddress2);
         VlblAddress2=(TextView) findViewById(R.id.VlblAddress2);
         spnAddress2=(Spinner) findViewById(R.id.spnAddress2);
         List<String> listAddress2 = new ArrayList<String>();
         
         listAddress2.add("");
         listAddress2.add("0001-Level2");
         ArrayAdapter<String> adptrAddress2= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listAddress2);
         spnAddress2.setAdapter(adptrAddress2);

         secAddress3=(LinearLayout)findViewById(R.id.secAddress3);
         lineAddress3=(View)findViewById(R.id.lineAddress3);
         VlblAddress3=(TextView) findViewById(R.id.VlblAddress3);
         spnAddress3=(Spinner) findViewById(R.id.spnAddress3);
         List<String> listAddress3 = new ArrayList<String>();
         
         listAddress3.add("");
         listAddress3.add("0001-Level3");
         ArrayAdapter<String> adptrAddress3= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listAddress3);
         spnAddress3.setAdapter(adptrAddress3);

         secAddress4=(LinearLayout)findViewById(R.id.secAddress4);
         lineAddress4=(View)findViewById(R.id.lineAddress4);
         VlblAddress4=(TextView) findViewById(R.id.VlblAddress4);
         spnAddress4=(Spinner) findViewById(R.id.spnAddress4);
         List<String> listAddress4 = new ArrayList<String>();
         
         listAddress4.add("");
         listAddress4.add("0001-Level4");
         ArrayAdapter<String> adptrAddress4= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listAddress4);
         spnAddress4.setAdapter(adptrAddress4);


         if(COUNTRYCODE.equals(ProjectSetting.NEPAL)){
             txtAddress3.setInputType(InputType.TYPE_CLASS_NUMBER);
         }

         secAddressDetail=(LinearLayout)findViewById(R.id.secAddressDetail);
         lineAddressDetail=(View)findViewById(R.id.lineAddressDetail);
         VlblAddressDetail=(TextView) findViewById(R.id.VlblAddressDetail);
         txtAddressDetail=(EditText) findViewById(R.id.txtAddressDetail);
         secMotContact=(LinearLayout)findViewById(R.id.secMotContact);
         lineMotContact=(View)findViewById(R.id.lineMotContact);
         VlblMotContact=(TextView) findViewById(R.id.VlblMotContact);
         txtMotContact=(EditText) findViewById(R.id.txtMotContact);
         secAltContact=(LinearLayout)findViewById(R.id.secAltContact);
         lineAltContact=(View)findViewById(R.id.lineAltContact);
         VlblAltContact=(TextView) findViewById(R.id.VlblAltContact);
         txtAltContact=(EditText) findViewById(R.id.txtAltContact);
         if(COUNTRYCODE.equals(ProjectSetting.BANGLADESH)){
             txtMotContact.setFilters(new InputFilter[] {new InputFilter.LengthFilter(11)});
             txtAltContact.setFilters(new InputFilter[] {new InputFilter.LengthFilter(11)});
         }else if(COUNTRYCODE.equals(ProjectSetting.NEPAL)){
             txtMotContact.setFilters(new InputFilter[] {new InputFilter.LengthFilter(10)});
             txtAltContact.setFilters(new InputFilter[] {new InputFilter.LengthFilter(10)});
         }else if(COUNTRYCODE.equals(ProjectSetting.TANZANIA)){
             //txtMotContact.setFilters(new InputFilter[] {new InputFilter.LengthFilter(10)});
             //txtAltContact.setFilters(new InputFilter[] {new InputFilter.LengthFilter(10)});
         }

         VlblNameNewBorn=(TextView) findViewById(R.id.VlblNameNewBorn);
         txtNameNewBorn=(EditText) findViewById(R.id.txtNameNewBorn);


         VlblDOBNewborn=(TextView) findViewById(R.id.VlblDOBNewborn);
         dtpDOBNewborn=(EditText) findViewById(R.id.dtpDOBNewborn);


         VlblAgeNewborn=(TextView) findViewById(R.id.VlblAgeNewborn);
         txtAgeNewborn=(EditText) findViewById(R.id.txtAgeNewborn);


         VlblAgeNewbornDMY = (TextView) findViewById(R.id.VlblAgeNewbornDMY);
         rdogrpAgeNewbornDMY = (RadioGroup) findViewById(R.id.rdogrpAgeNewbornDMY);
         
         rdoAgeNewbornDMY1 = (RadioButton) findViewById(R.id.rdoAgeNewbornDMY1);
         rdoAgeNewbornDMY2 = (RadioButton) findViewById(R.id.rdoAgeNewbornDMY2);
         rdoAgeNewbornDMY3 = (RadioButton) findViewById(R.id.rdoAgeNewbornDMY3);


         dtpRegDate.setOnTouchListener(new View.OnTouchListener() {
             @Override
             public boolean onTouch(View v, MotionEvent event) {
                 final int DRAWABLE_RIGHT  = 2;
                 if(event.getAction() == MotionEvent.ACTION_UP) {
                     if(event.getRawX() >= (dtpRegDate.getRight() - dtpRegDate.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                         VariableID = "btnRegDate"; showDialog(DATE_DIALOG);
                      return true;
                     }
                 }
                 return false;
             }
         });
         dtpMotDOB.setOnTouchListener(new View.OnTouchListener() {
             @Override
             public boolean onTouch(View v, MotionEvent event) {
                 final int DRAWABLE_RIGHT  = 2;
                 if(event.getAction() == MotionEvent.ACTION_UP) {
                     if(event.getRawX() >= (dtpMotDOB.getRight() - dtpMotDOB.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                         VariableID = "btnMotDOB"; showDialog(DATE_DIALOG);
                      return true;
                     }
                 }
                 return false;
             }
         });
         dtpDOBNewborn.setOnTouchListener(new View.OnTouchListener() {
             @Override
             public boolean onTouch(View v, MotionEvent event) {
                 final int DRAWABLE_RIGHT  = 2;
                 if(event.getAction() == MotionEvent.ACTION_UP) {
                     if(event.getRawX() >= (dtpDOBNewborn.getRight() - dtpDOBNewborn.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                         VariableID = "btnDOBNewborn"; showDialog(DATE_DIALOG);
                      return true;
                     }
                 }
                 return false;
             }
         });


         txtRegTime.setOnTouchListener(new View.OnTouchListener() {
         @Override
         public boolean onTouch(View v, MotionEvent event) {
             final int DRAWABLE_RIGHT = 2;
             if(event.getAction() == MotionEvent.ACTION_UP) {
                 if(event.getRawX() >= (txtRegTime.getRight() - txtRegTime.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                     VariableID = "btnRegTime"; showDialog(TIME_DIALOG);
                  return true;
                 }
             }
             return false;
           }
         });

         txtTOBNewborn.setOnTouchListener(new View.OnTouchListener() {
             @Override
             public boolean onTouch(View v, MotionEvent event) {
                 final int DRAWABLE_RIGHT = 2;
                 if(event.getAction() == MotionEvent.ACTION_UP) {
                     if(event.getRawX() >= (txtTOBNewborn.getRight() - txtTOBNewborn.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                         VariableID = "btnTOBNewborn"; showDialog(TIME_DIALOG);
                         return true;
                     }
                 }
                 return false;
             }
         });

         ObsHos_Initialize();
         KMCPreObs_Initialize();
         InfectionPreObs_Initialize();


         //Hide all skip variables
         secStudyID.setVisibility(View.GONE);
         lineStudyID.setVisibility(View.GONE);
         //secMotRegis.setVisibility(View.GONE);
         //lineMotRegis.setVisibility(View.GONE);
         secMotStudyID.setVisibility(View.GONE);
         lineMotStudyID.setVisibility(View.GONE);
         secMotStudyIDReType.setVisibility(View.GONE);
         secMotHospID.setVisibility(View.GONE);
         lineMotHospID.setVisibility(View.GONE);
         /*
         secMotName.setVisibility(View.GONE);
         lineMotName.setVisibility(View.GONE);
         secMotDOB.setVisibility(View.GONE);
         lineMotDOB.setVisibility(View.GONE);
         secMotDOBDK.setVisibility(View.GONE);
         lineMotDOBDK.setVisibility(View.GONE);
         secMotAge.setVisibility(View.GONE);
         lineMotAge.setVisibility(View.GONE);
         secMotEdu.setVisibility(View.GONE);
         secMotEduDK.setVisibility(View.GONE);
         secParity.setVisibility(View.GONE);

         secMotEthnicity.setVisibility(View.GONE);
         secMotEthnicityOth.setVisibility(View.GONE);
         lineMotEthnicity.setVisibility(View.GONE);
         secMotReligion.setVisibility(View.GONE);
         secMotReligionOth.setVisibility(View.GONE);
         lineMotReligion.setVisibility(View.GONE);
         */
         secAddress1.setVisibility(View.GONE);
         lineAddress1.setVisibility(View.GONE);
         secAddress2.setVisibility(View.GONE);
         lineAddress2.setVisibility(View.GONE);
         secAddress3.setVisibility(View.GONE);
         lineAddress3.setVisibility(View.GONE);
         secAddress4.setVisibility(View.GONE);
         lineAddress4.setVisibility(View.GONE);
         secAddressDetail.setVisibility(View.GONE);
         lineAddressDetail.setVisibility(View.GONE);
         secMotContact.setVisibility(View.GONE);
         lineMotContact.setVisibility(View.GONE);
         secAltContact.setVisibility(View.GONE);
         lineAltContact.setVisibility(View.GONE);
         secNameNewBorn.setVisibility(View.GONE);
         lineNameNewBorn.setVisibility(View.GONE);
         secDOBNewborn.setVisibility(View.GONE);
         secDOBNewbornDK.setVisibility(View.GONE);

         secTOBNewborn.setVisibility(View.GONE);
         secTOBNewbornDK.setVisibility(View.GONE);


         lineDOBNewborn.setVisibility(View.GONE);
         secAgeNewborn.setVisibility(View.GONE);
         lineAgeNewborn.setVisibility(View.GONE);
         secAgeNewbornDMY.setVisibility(View.GONE);
         //lineAgeNewbornDMY.setVisibility(View.GONE);
         secMotStudyID.setVisibility(View.GONE);
         lineMotStudyID.setVisibility(View.GONE);
         secMotHospID.setVisibility(View.GONE);
         lineMotHospID.setVisibility(View.GONE);
         secSex.setVisibility(View.GONE);
         seclbl1.setVisibility(View.GONE);
         secMotStudyIDReType.setVisibility(View.GONE);
         secFatherName.setVisibility(View.GONE);
         secanybcompadmoth.setVisibility(View.GONE);
         secInfection.setVisibility(View.GONE);

         //1-Bangladesh, 2-Nepal, 3-Tanzania
         if(COUNTRYCODE.equals(ProjectSetting.BANGLADESH))
         {
             VlblAddress1.setText("a. District");
             VlblAddress2.setText("b. Upazila/Thana");
             VlblAddress3.setText("c. Union/Ward");
             VlblAddress4.setText("d. Village/Moholla");
             //secAddress4.setVisibility(View.GONE);
         }
         else if(COUNTRYCODE.equals(ProjectSetting.NEPAL))
         {
             VlblAddress1.setText("a. District");
             VlblAddress2.setText("b. Municipailty/VDC");
             VlblAddress3.setText("c. Ward Number");
             VlblAddress4.setText("d. Street/Tole");
             //secAddress4.setVisibility(View.GONE);
         }
         else if(COUNTRYCODE.equals(ProjectSetting.TANZANIA))
         {
             VlblAddress1.setText("a. District");
             VlblAddress2.setText("b. Ward");
             VlblAddress3.setText("c. Street");
             secAddress4.setVisibility(View.GONE);
         }

         chkMotDOBDK.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
         {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
             {
                 if ( isChecked )
                 {
                     dtpMotDOB.setText("");
                     txtMotAge.setEnabled(true);
                     txtMotAge.requestFocus();
                 }
             }
         });


         chkgaadmiDK.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
         {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
             {
                 if ( isChecked )
                 {
                     txtgaadmi.setText("");
                 }
             }
         });
         txtgaadmi.addTextChangedListener(new TextWatcher() {
             public void afterTextChanged(Editable s) {}
             public void beforeTextChanged(CharSequence s, int start,int count, int after) {}
             public void onTextChanged(CharSequence s, int start,int before, int count) {
                 if(txtgaadmi.getText().toString().length()>0) chkgaadmiDK.setChecked(false);
             }
         });

         chkDOBNewbornDK.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
         {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
             {
                 if ( isChecked )
                 {
                     dtpDOBNewborn.setText("");
                     txtAgeNewborn.setEnabled(true);
                 }else{
                     txtAgeNewborn.setEnabled(false);
                 }
             }
         });
         dtpDOBNewborn.addTextChangedListener(new TextWatcher() {
             public void afterTextChanged(Editable s) {}
             public void beforeTextChanged(CharSequence s, int start,int count, int after) {}
             public void onTextChanged(CharSequence s, int start,int before, int count) {
                 if(dtpDOBNewborn.getText().toString().length()>0) chkDOBNewbornDK.setChecked(false);
             }
         });


         txtMotAge.setEnabled(false);
         txtAgeNewborn.setEnabled(false);

         cmdMotID = (Button)findViewById(R.id.cmdMotID);
         cmdMotID.setOnClickListener(new View.OnClickListener() {
             public void onClick(View v) {
                 LD_Patient_List_Form();
             }});

         chkanybcompadmh.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
         {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
             {
                 if (isChecked)
                 {
                     //chkanybcompadma.setChecked(false);
                     secanybcompadmoth.setVisibility(View.VISIBLE);
                 }else{
                     secanybcompadmoth.setVisibility(View.GONE);
                     txtanybcompadmoth.setText("");
                 }

             }
         });

         chkanybcompadma.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
         {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
             {
                 if (isChecked)
                 {
                     /*chkanybcompadmb.setChecked(false);
                     chkanybcompadmc.setChecked(false);
                     chkanybcompadmd.setChecked(false);
                     chkanybcompadme.setChecked(false);
                     chkanybcompadmf.setChecked(false);
                     chkanybcompadmg.setChecked(false);
                     chkanybcompadmh.setChecked(false);*/
                     chkanybcompadmg.setChecked(false);
                 }

             }
         });

         chkanybcompadmb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
         {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
             {
                 if (isChecked)
                 {
                     chkanybcompadmg.setChecked(false);
                 }

             }
         });
         chkanybcompadmc.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
         {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
             {
                 if (isChecked)
                 {
                     chkanybcompadmg.setChecked(false);
                 }

             }
         });
         chkanybcompadmd.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
         {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
             {
                 if (isChecked)
                 {
                     chkanybcompadmg.setChecked(false);
                 }

             }
         });
         chkanybcompadme.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
         {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
             {
                 if (isChecked)
                 {
                     chkanybcompadmg.setChecked(false);
                 }

             }
         });
         chkanybcompadmf.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
         {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
             {
                 if (isChecked)
                 {
                     chkanybcompadmg.setChecked(false);
                 }

             }
         });
         chkanybcompadmg.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
         {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
             {
                 if (isChecked)
                 {
                     /*chkanybcompadma.setChecked(false);
                     chkanybcompadmb.setChecked(false);
                     chkanybcompadmc.setChecked(false);
                     chkanybcompadmd.setChecked(false);
                     chkanybcompadme.setChecked(false);
                     chkanybcompadmf.setChecked(false);
                     chkanybcompadmh.setChecked(false);*/
                     chkanybcompadma.setChecked(false);
                     chkanybcompadmb.setChecked(false);
                     chkanybcompadmc.setChecked(false);
                     chkanybcompadmd.setChecked(false);
                     chkanybcompadme.setChecked(false);
                     chkanybcompadmf.setChecked(false);
                     //chkanybcompadmg.setChecked(false);
                     chkanybcompadmh.setChecked(false);
                 }

             }
         });
         /*chkanybcompadmh.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
         {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
             {
                 if (isChecked)
                 {
                     chkanybcompadma.setChecked(false);
                 }

             }
         });*/



         txtprevpreg.addTextChangedListener(new TextWatcher() {
             public void onTextChanged(CharSequence s, int start, int before,int count) {
             }
             public void beforeTextChanged(CharSequence s, int start, int count,int after) {
             }
             public void afterTextChanged(Editable s) {
                 if(COUNTRYCODE.equals(ProjectSetting.NEPAL)) {
                     String preg = txtprevpreg.getText().toString().length() == 0 ? "0" : txtprevpreg.getText().toString();
                     if (Integer.valueOf(preg) == 0) {
                         txtprevliveb.setText("0");
                         txtprevliveb.setEnabled(false);
                         txtprevstillb.setText("0");
                         txtprevstillb.setEnabled(false);
                         txtprevab.setText("0");
                         txtprevab.setEnabled(false);
                         txtprevcsec.setText("0");
                         txtprevcsec.setEnabled(false);
                         txtyrslstbth.setText("0");
                         txtyrslstbth.setEnabled(false);
                     } else {
                         txtprevliveb.setEnabled(true);
                         txtprevstillb.setEnabled(true);
                         txtprevab.setEnabled(true);
                         txtprevcsec.setEnabled(true);
                         txtyrslstbth.setEnabled(true);
                     }
                 }
             }
         });


         chkTOBNewbornDK.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
         {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
             {
                 if ( isChecked )
                 {
                     txtTOBNewborn.setText("");
                 }
             }
         });
         txtTOBNewborn.addTextChangedListener(new TextWatcher() {
             public void afterTextChanged(Editable s) {}
             public void beforeTextChanged(CharSequence s, int start,int count, int after) {}
             public void onTextChanged(CharSequence s, int start,int before, int count) {
                 if(txtTOBNewborn.getText().toString().length()>0) chkTOBNewbornDK.setChecked(false);
             }
         });


         secLDPreObs.setVisibility(View.GONE);
         secKMCPreObs.setVisibility(View.GONE);

         if(LOCATIONID.equals(ProjectSetting.LABOR_AND_DELIVERY_ID)){
             lblTitle.setText(ProjectSetting.LABOR_AND_DELIVERY_NAME);
             secMotRegis.setVisibility(View.GONE);
             secNameNewBorn.setVisibility(View.GONE);
             lineNameNewBorn.setVisibility(View.GONE);
             secDOBNewborn.setVisibility(View.GONE);
             secDOBNewbornDK.setVisibility(View.GONE);

             secTOBNewborn.setVisibility(View.GONE);
             secTOBNewbornDK.setVisibility(View.GONE);

             lineDOBNewborn.setVisibility(View.GONE);
             secAgeNewborn.setVisibility(View.GONE);
             //lineAgeNewbornDMY.setVisibility(View.GONE);
             secAgeNewbornDMY.setVisibility(View.GONE);
             secSex.setVisibility(View.GONE);
             secFatherName.setVisibility(View.GONE);
             secMotStudyIDReType.setVisibility(View.GONE);
             //secLDPreObs.setVisibility(View.VISIBLE);

             //15a: 05 jul 2017
             secTOBNewborn.setVisibility(View.GONE);
             secTOBNewbornDK.setVisibility(View.GONE);

         }else if(LOCATIONID.equals(ProjectSetting.KMC_ID)){
             lblTitle.setText(ProjectSetting.KMC_NAME);
             //secMotRegis.setVisibility(View.GONE);
             secNameNewBorn.setVisibility(View.GONE);
             lineNameNewBorn.setVisibility(View.GONE);
             secDOBNewborn.setVisibility(View.GONE);
             secDOBNewbornDK.setVisibility(View.GONE);

             secTOBNewborn.setVisibility(View.GONE);
             secTOBNewbornDK.setVisibility(View.GONE);

             lineDOBNewborn.setVisibility(View.GONE);
             secAgeNewborn.setVisibility(View.GONE);
             //lineAgeNewbornDMY.setVisibility(View.VISIBLE);
             secAgeNewbornDMY.setVisibility(View.GONE);
             secSex.setVisibility(View.GONE);
             secFatherName.setVisibility(View.GONE);
             secMotStudyIDReType.setVisibility(View.GONE);
             //secKMCPreObs.setVisibility(View.VISIBLE);

             //15a: 05 jul 2017
             secTOBNewborn.setVisibility(View.GONE);
             secTOBNewbornDK.setVisibility(View.GONE);

         }else if(LOCATIONID.equals(ProjectSetting.SEPSIS_ID)){
             lblTitle.setText(ProjectSetting.SEPSIS_NAME);
             //secMotRegis.setVisibility(View.GONE);
             secNameNewBorn.setVisibility(View.GONE);
             lineNameNewBorn.setVisibility(View.GONE);
             secDOBNewborn.setVisibility(View.GONE);
             secDOBNewbornDK.setVisibility(View.GONE);

             secTOBNewborn.setVisibility(View.GONE);
             secTOBNewbornDK.setVisibility(View.GONE);

             lineDOBNewborn.setVisibility(View.GONE);
             secAgeNewborn.setVisibility(View.GONE);
             //lineAgeNewbornDMY.setVisibility(View.VISIBLE);
             secAgeNewbornDMY.setVisibility(View.GONE);
             secSex.setVisibility(View.GONE);
             secFatherName.setVisibility(View.GONE);
             secMotStudyIDReType.setVisibility(View.GONE);

             //15a: 05 jul 2017
             //secTOBNewborn.setVisibility(View.VISIBLE);
             //secTOBNewbornDK.setVisibility(View.VISIBLE);
         }





         chkprevpregDK.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
         {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
             {
                 if ( isChecked )
                 {
                     txtprevpreg.setText("");
                 }
             }
         });
         txtprevpreg.addTextChangedListener(new TextWatcher() {
             public void afterTextChanged(Editable s) {}
             public void beforeTextChanged(CharSequence s, int start,int count, int after) {}
             public void onTextChanged(CharSequence s, int start,int before, int count) {
                 if(txtprevpreg.getText().toString().length()>0) chkprevpregDK.setChecked(false);
             }
         });

         chkprevlivebDK.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
         {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
             {
                 if ( isChecked )
                 {
                     txtprevliveb.setText("");
                 }
             }
         });
         txtprevliveb.addTextChangedListener(new TextWatcher() {
             public void afterTextChanged(Editable s) {}
             public void beforeTextChanged(CharSequence s, int start,int count, int after) {}
             public void onTextChanged(CharSequence s, int start,int before, int count) {
                 if(txtprevliveb.getText().toString().length()>0) chkprevlivebDK.setChecked(false);
             }
         });

         chkprevstillbDK.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
         {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
             {
                 if ( isChecked )
                 {
                     txtprevstillb.setText("");
                 }
             }
         });
         txtprevstillb.addTextChangedListener(new TextWatcher() {
             public void afterTextChanged(Editable s) {}
             public void beforeTextChanged(CharSequence s, int start,int count, int after) {}
             public void onTextChanged(CharSequence s, int start,int before, int count) {
                 if(txtprevstillb.getText().toString().length()>0) chkprevstillbDK.setChecked(false);
             }
         });

         chkprevabDK.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
         {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
             {
                 if ( isChecked )
                 {
                     txtprevab.setText("");
                 }
             }
         });
         txtprevab.addTextChangedListener(new TextWatcher() {
             public void afterTextChanged(Editable s) {}
             public void beforeTextChanged(CharSequence s, int start,int count, int after) {}
             public void onTextChanged(CharSequence s, int start,int before, int count) {
                 if(txtprevab.getText().toString().length()>0) chkprevabDK.setChecked(false);
             }
         });

         chkprevcsecDK.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
         {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
             {
                 if ( isChecked )
                 {
                     txtprevcsec.setText("");
                 }
             }
         });
         txtprevcsec.addTextChangedListener(new TextWatcher() {
             public void afterTextChanged(Editable s) {}
             public void beforeTextChanged(CharSequence s, int start,int count, int after) {}
             public void onTextChanged(CharSequence s, int start,int before, int count) {
                 if(txtprevcsec.getText().toString().length()>0) chkprevcsecDK.setChecked(false);
             }
         });

         chkyrslstbthDK.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
         {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
             {
                 if ( isChecked )
                 {
                     txtyrslstbth.setText("");
                 }
             }
         });
         txtyrslstbth.addTextChangedListener(new TextWatcher() {
             public void afterTextChanged(Editable s) {}
             public void beforeTextChanged(CharSequence s, int start,int count, int after) {}
             public void onTextChanged(CharSequence s, int start,int before, int count) {
                 if(txtyrslstbth.getText().toString().length()>0) chkyrslstbthDK.setChecked(false);
             }
         });

         chkadwghtkmcDK.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
         {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
             {
                 if ( isChecked )
                 {
                     txtadwghtkmc.setText("");
                 }
             }
         });
         txtadwghtkmc.addTextChangedListener(new TextWatcher() {
             public void afterTextChanged(Editable s) {}
             public void beforeTextChanged(CharSequence s, int start,int count, int after) {}
             public void onTextChanged(CharSequence s, int start,int before, int count) {
                 if(txtadwghtkmc.getText().toString().length()>0) chkadwghtkmcDK.setChecked(false);
             }
         });

         chkgaadmDK.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
         {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
             {
                 if ( isChecked )
                 {
                     txtgaadm.setText("");
                 }
             }
         });
         txtgaadm.addTextChangedListener(new TextWatcher() {
             public void afterTextChanged(Editable s) {}
             public void beforeTextChanged(CharSequence s, int start,int count, int after) {}
             public void onTextChanged(CharSequence s, int start,int before, int count) {
                 if(txtgaadm.getText().toString().length()>0) chkgaadmDK.setChecked(false);
             }
         });


         chkMotEduDK.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
         {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
             {
                 if ( isChecked )
                 {
                     txtMotEdu.setText("");
                 }
             }
         });
         txtMotEdu.addTextChangedListener(new TextWatcher() {
             public void afterTextChanged(Editable s) {}
             public void beforeTextChanged(CharSequence s, int start,int count, int after) {}
             public void onTextChanged(CharSequence s, int start,int before, int count) {
                 if(txtMotEdu.getText().toString().length()>0) chkMotEduDK.setChecked(false);
             }
         });

         secConReason.setVisibility(View.GONE);
         DataSearch(COUNTRYCODE,FACICODE,DATAID);
         DataSearchObsHis(COUNTRYCODE,FACICODE,DATAID);
         KMCPreObs_DataSearch(COUNTRYCODE,FACICODE,DATAID);
         InfectionPreObs_DataSearch(COUNTRYCODE,FACICODE,DATAID);

        Button cmdSave = (Button) findViewById(R.id.cmdSave);
        cmdSave.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            DataSave();
        }});

         if(JOBTYPE.equals(ProjectSetting.JT_REGISTRATION)){
             cmdSave.setVisibility(View.VISIBLE);
         }else{
             cmdSave.setVisibility(View.GONE);
         }


         if(LOCATIONID.equals(ProjectSetting.LABOR_AND_DELIVERY_ID)){
             secParity.setVisibility(View.GONE);
         }else{
             secParity.setVisibility(View.VISIBLE);
         }

         if(COUNTRYCODE.equals(ProjectSetting.NEPAL)){
             chkprevpregDK.setText("Not readable/Not recorded");
             chkprevlivebDK.setText("Not readable/Not recorded");
             chkprevstillbDK.setText("Not readable/Not recorded");
             chkprevabDK.setText("Not readable/Not recorded");
             chkprevcsecDK.setText("Not readable/Not recorded");
             chkyrslstbthDK.setText("Not readable/Not recorded");
         }
     }
     catch(Exception  e)
     {
         Connection.MessageBox(Registration.this, e.getMessage());
         return;
     }
 }

 private void DataSave()
 {
   try
     {
 
         String DV="";

         if(txtCountryCode.getText().toString().length()==0 & secCountryCode.isShown())
           {
             Connection.MessageBox(Registration.this, "Required field: Country.");
             txtCountryCode.requestFocus(); 
             return;	
           }
         else if(Integer.valueOf(txtCountryCode.getText().toString().length()==0 ? "1" : txtCountryCode.getText().toString()) < 1 || Integer.valueOf(txtCountryCode.getText().toString().length()==0 ? "3" : txtCountryCode.getText().toString()) > 3)
           {
             Connection.MessageBox(Registration.this, "Value should be between 1 and 3(Country).");
             txtCountryCode.requestFocus(); 
             return;	
           }
         else if(txtFaciCode.getText().toString().length()==0 & secFaciCode.isShown())
           {
             Connection.MessageBox(Registration.this, "Required field: Facility.");
             txtFaciCode.requestFocus(); 
             return;	
           }
         else if(Integer.valueOf(txtFaciCode.getText().toString().length()==0 ? "1" : txtFaciCode.getText().toString()) < 1 || Integer.valueOf(txtFaciCode.getText().toString().length()==0 ? "9" : txtFaciCode.getText().toString()) > 9)
           {
             Connection.MessageBox(Registration.this, "Value should be between 1 and 9(Facility).");
             txtFaciCode.requestFocus(); 
             return;	
           }
         else if(txtRegisType.getText().toString().length()==0 & secRegisType.isShown())
           {
             Connection.MessageBox(Registration.this, "Required field: Registration Type.");
             txtRegisType.requestFocus(); 
             return;	
           }
         else if(Integer.valueOf(txtRegisType.getText().toString().length()==0 ? "1" : txtRegisType.getText().toString()) < 1 || Integer.valueOf(txtRegisType.getText().toString().length()==0 ? "5" : txtRegisType.getText().toString()) > 5)
           {
             Connection.MessageBox(Registration.this, "Value should be between 1 and 5(Registration Type).");
             txtRegisType.requestFocus(); 
             return;	
           }
         else if(txtDataID.getText().toString().length()==0 & secDataID.isShown())
           {
             Connection.MessageBox(Registration.this, "Required field: Data ID.");
             txtDataID.requestFocus(); 
             return;	
           }
         DV = Global.DateValidate(dtpRegDate.getText().toString());
         if(DV.length()!=0 & secRegDate.isShown())
           {
             Connection.MessageBox(Registration.this, DV);
             dtpRegDate.requestFocus(); 
             return;	
           }
         else if(txtRegTime.getText().length()==0 & secRegTime.isShown())
           {
             Connection.MessageBox(Registration.this, "Required field: Time.");
             txtRegTime.requestFocus(); 
             return;	
           }
         else if(txtHospID.getText().toString().length()==0 & secHospID.isShown())
           {
             Connection.MessageBox(Registration.this, "Required field: Hospital ID/Registration Number.");
             txtHospID.requestFocus(); 
             return;	
           }
         else if(txtHospIDReTyp.getText().toString().length()==0 & secHospID.isShown())
         {
             Connection.MessageBox(Registration.this, "Required field: Re-Type Hospital ID/Registration Number.");
             txtHospIDReTyp.requestFocus();
             return;
         }
         else if(!txtHospID.getText().toString().equals(txtHospIDReTyp.getText().toString())){
             Connection.MessageBox(Registration.this, "Hospital ID/Registration Number does not matched with the Re-Type Hospital ID/Registration Number.");
             txtHospID.requestFocus();
             return;
         }
         else if(!rdoConsent1.isChecked() & !rdoConsent2.isChecked() & !rdoConsent3.isChecked() & !rdoConsent4.isChecked() & !rdoConsent5.isChecked() & secConsent.isShown())
           {
              Connection.MessageBox(Registration.this, "Select anyone options from (Consent).");
              rdoConsent1.requestFocus();
              return;
           }
           else if(rdoConsent4.isChecked() & txtConReason.getText().toString().length()==0 & secConsent.isShown()){
             Connection.MessageBox(Registration.this, "Entry the specific reason for the Not asked-not eligible.");
             txtConReason.requestFocus();
             return;
         }
         else if(txtStudyID.getText().toString().length()==0 & secStudyID.isShown())
           {
             Connection.MessageBox(Registration.this, "Required field: Study ID.");
             txtStudyID.requestFocus(); 
             return;	
           }
         
         else if(!rdoMotRegis1.isChecked() & !rdoMotRegis2.isChecked() & secMotRegis.isShown())
           {
              Connection.MessageBox(Registration.this, "Select anyone options from (Mother Registered).");
              rdoMotRegis1.requestFocus();
              return;
           }
         else if(txtMotStudyID.getText().toString().length()==0 & secMotStudyID.isShown())
           {
             Connection.MessageBox(Registration.this, "Required field: Mother Study ID.");
             txtMotStudyID.requestFocus(); 
             return;	
           }

         if(!txtMotStudyID.getText().toString().equals(txtMotStudyIDReType.getText().toString()) & secMotStudyID.isShown())
         {
             Connection.MessageBox(Registration.this, "Mother's Study ID and Re-Type ID does not matched.");
             txtMotStudyID.requestFocus();
             return;
         }

         if(txtMotHospID.getText().toString().length()==0 & secMotHospID.isShown())
           {
             Connection.MessageBox(Registration.this, "Required field: Mothers Hospital ID.");
             txtMotHospID.requestFocus(); 
             return;	
           }
         else if(txtMotName.getText().toString().length()==0 & secMotName.isShown())
           {
             Connection.MessageBox(Registration.this, "Required field: Name of Mother.");
             txtMotName.requestFocus(); 
             return;	
           }
         DV = Global.DateValidate(dtpMotDOB.getText().toString());
         if(DV.length()!=0 & secMotDOB.isShown() & !chkMotDOBDK.isShown())
           {
             Connection.MessageBox(Registration.this, DV);
             dtpMotDOB.requestFocus(); 
             return;	
           }
         else if(txtMotAge.getText().toString().length()==0 & secMotAge.isShown())
           {
             Connection.MessageBox(Registration.this, "Required field: Age of the Mother.");
             txtMotAge.requestFocus(); 
             return;	
           }
         else if(!chkMotEduDK.isChecked() & txtMotEdu.getText().toString().length()==0 & secMotEdu.isShown()){
             Connection.MessageBox(Registration.this, "Required field: Mothers total years of formal education.");
             txtMotEdu.requestFocus();
             return;
         }
         else if(spnParity.getSelectedItemPosition()==0 & secParity.isShown()){
             Connection.MessageBox(Registration.this, "Required field: 11b. Parity.");
             spnParity.requestFocus();
             return;
         }
         else if(Integer.valueOf(txtMotAge.getText().toString().length()==0 ? "1" : txtMotAge.getText().toString()) < 10 || Integer.valueOf(txtMotAge.getText().toString().length()==0 ? "99" : txtMotAge.getText().toString()) > 49)
           {
             Connection.MessageBox(Registration.this, "Value should be between 10 and 49(9. Age of the Mother).");
             txtMotAge.requestFocus(); 
             return;	
           }
         else if(spnMotEthnicity.getSelectedItemPosition()==0 & secMotEthnicity.isShown() & !COUNTRYCODE.equals(ProjectSetting.BANGLADESH))
           {
             Connection.MessageBox(Registration.this, "Required field: Ethnicity of the Mother.");
             spnMotEthnicity.requestFocus(); 
             return;	
           }
         else if(spnMotReligion.getSelectedItemPosition()==0  & secMotReligion.isShown() & (COUNTRYCODE.equals(ProjectSetting.BANGLADESH) | COUNTRYCODE.equals(ProjectSetting.NEPAL)))
           {
             Connection.MessageBox(Registration.this, "Required field: Religion of the Mother.");
             spnMotReligion.requestFocus(); 
             return;	
           }
         else if(spnAddress1.getSelectedItemPosition()==0  & secAddress1.isShown())
           {
             Connection.MessageBox(Registration.this, "Required field: Level1.");
             spnAddress1.requestFocus(); 
             return;	
           }
         else if(txtAddress2.getText().toString().length()==0  & secAddress2.isShown())
           {
             Connection.MessageBox(Registration.this, "Required field: Level2.");
               txtAddress2.requestFocus();
             return;	
           }
         else if(txtAddress3.getText().toString().length()==0  & secAddress3.isShown())
           {
             Connection.MessageBox(Registration.this, "Required field: Level3.");
               txtAddress3.requestFocus();
             return;	
           }
         else if(txtAddress4.getText().toString().length()==0  & secAddress4.isShown() & COUNTRYCODE.equals(ProjectSetting.BANGLADESH))
           {
             Connection.MessageBox(Registration.this, "Required field: Level4.");
               txtAddress4.requestFocus();
             return;	
           }
         /*else if(txtAddressDetail.getText().toString().length()==0 & secAddressDetail.isShown())
           {
             Connection.MessageBox(Registration.this, "Required field: Detail Address.");
             txtAddressDetail.requestFocus(); 
             return;	
           }
         else if(txtMotContact.getText().toString().length()==0 & secMotContact.isShown())
           {
             Connection.MessageBox(Registration.this, "Required field: Contact Number - Mother.");
             txtMotContact.requestFocus(); 
             return;	
           }

         else if(txtAltContact.getText().toString().length()==0 & secAltContact.isShown())
           {
             Connection.MessageBox(Registration.this, "Required field: Alternate.");
             txtAltContact.requestFocus(); 
             return;	
           }*/
         else if(txtNameNewBorn.getText().toString().length()==0 & secNameNewBorn.isShown())
           {
             Connection.MessageBox(Registration.this, "Required field: Name of Newborn.");
             txtNameNewBorn.requestFocus(); 
             return;	
           }
         DV = Global.DateValidate(dtpDOBNewborn.getText().toString());
         if(!chkDOBNewbornDK.isChecked() & DV.length()!=0 & secDOBNewborn.isShown())
           {
             Connection.MessageBox(Registration.this, "Invalid Date: 15. Date of birth of newborn.");
             dtpDOBNewborn.requestFocus(); 
             return;	
           }

           if(!chkTOBNewbornDK.isChecked() & txtTOBNewborn.getText().toString().length()==0 & secTOBNewborn.isShown()){
               Connection.MessageBox(Registration.this, "Required field: 15a. Time of birth of the newborn.");
               txtTOBNewborn.requestFocus();
               return;
           }

           if(txtAgeNewborn.getText().toString().length()==0 & secAgeNewborn.isShown())
           {
             Connection.MessageBox(Registration.this, "Required field: Age of the Newborn.");
             txtAgeNewborn.requestFocus(); 
             return;	
           }
         else if(Integer.valueOf(txtAgeNewborn.getText().toString().length()==0 ? "0" : txtAgeNewborn.getText().toString()) < 0 || Integer.valueOf(txtAgeNewborn.getText().toString().length()==0 ? "60" : txtAgeNewborn.getText().toString()) > 60)
           {
             Connection.MessageBox(Registration.this, "Value should be between 0 and 60(Age of the Newborn).");
             txtAgeNewborn.requestFocus(); 
             return;	
           }
         
         /*else if(!rdoAgeNewbornDMY1.isChecked() & !rdoAgeNewbornDMY2.isChecked() & !rdoAgeNewbornDMY3.isChecked() & secAgeNewbornDMY.isShown())
           {
              Connection.MessageBox(Registration.this, "Select anyone options from ().");
              rdoAgeNewbornDMY1.requestFocus();
              return;
           }*/
         else if(!rdoSex1.isChecked() & !rdoSex2.isChecked() & !rdoSex3.isChecked() & secSex.isShown()){
             Connection.MessageBox(Registration.this, "Required field: Sex of the Newborn.");
             rdoSex1.requestFocus();
             return;
         }

         //Labour and Delivery:
         if(LOCATIONID.equals(ProjectSetting.LABOR_AND_DELIVERY_ID)) {
             if (txtDataID.getText().toString().length() == 0 & secDataID.isShown()) {
                 Connection.MessageBox(Registration.this, "Required field: Data ID.");
                 txtDataID.requestFocus();
                 return;
             } else if (!rdocard1.isChecked() & !rdocard2.isChecked() & !rdocard7.isChecked() & seccard.isShown()) {
                 Connection.MessageBox(Registration.this, "Select anyone options from (Antenatal card available).");
                 rdocard1.requestFocus();
                 return;
             } else if (!chkprevpregDK.isChecked() & txtprevpreg.getText().toString().length() == 0 & secprevpreg.isShown()) {
                 Connection.MessageBox(Registration.this, "Required field: Number of previous pregnancies.");
                 txtprevpreg.requestFocus();
                 return;
             } else if (!chkprevpregDK.isChecked() & (Integer.valueOf(txtprevpreg.getText().toString().length() == 0 ? "0" : txtprevpreg.getText().toString()) < 0 || Integer.valueOf(txtprevpreg.getText().toString().length() == 0 ? "97" : txtprevpreg.getText().toString()) > 97)) {
                 Connection.MessageBox(Registration.this, "Value should be between 0 and 97(Number of previous pregnancies).");
                 txtprevpreg.requestFocus();
                 return;
             } else if (!chkprevlivebDK.isChecked() & txtprevliveb.getText().toString().length() == 0 & secprevliveb.isShown()) {
                 Connection.MessageBox(Registration.this, "Required field: Number of previous live births.");
                 txtprevliveb.requestFocus();
                 return;
             } else if (!chkprevlivebDK.isChecked() & (Integer.valueOf(txtprevliveb.getText().toString().length() == 0 ? "0" : txtprevliveb.getText().toString()) < 0 || Integer.valueOf(txtprevliveb.getText().toString().length() == 0 ? "97" : txtprevliveb.getText().toString()) > 97)) {
                 Connection.MessageBox(Registration.this, "Value should be between 0 and 97(Number of previous live births).");
                 txtprevliveb.requestFocus();
                 return;
             } else if (!chkprevstillbDK.isChecked() & txtprevstillb.getText().toString().length() == 0 & secprevstillb.isShown()) {
                 Connection.MessageBox(Registration.this, "Required field: Number of previous stillbirths (≥28/40).");
                 txtprevstillb.requestFocus();
                 return;
             } else if (!chkprevstillbDK.isChecked() & (Integer.valueOf(txtprevstillb.getText().toString().length() == 0 ? "0" : txtprevstillb.getText().toString()) < 0 || Integer.valueOf(txtprevstillb.getText().toString().length() == 0 ? "97" : txtprevstillb.getText().toString()) > 97)) {
                 Connection.MessageBox(Registration.this, "Value should be between 0 and 97(Number of previous stillbirths (≥28/40)).");
                 txtprevstillb.requestFocus();
                 return;
             } else if (!chkprevabDK.isChecked() & txtprevab.getText().toString().length() == 0 & secprevab.isShown()) {
                 Connection.MessageBox(Registration.this, "Required field: Number of previous abortions or miscarriages (<28 weeks).");
                 txtprevab.requestFocus();
                 return;
             } else if (!chkprevabDK.isChecked() & (Integer.valueOf(txtprevab.getText().toString().length() == 0 ? "0" : txtprevab.getText().toString()) < 0 || Integer.valueOf(txtprevab.getText().toString().length() == 0 ? "97" : txtprevab.getText().toString()) > 97)) {
                 Connection.MessageBox(Registration.this, "Value should be between 0 and 97(Number of previous abortions or miscarriages (<28 weeks)).");
                 txtprevab.requestFocus();
                 return;
             } else if (!chkprevcsecDK.isChecked() & txtprevcsec.getText().toString().length() == 0 & secprevcsec.isShown()) {
                 Connection.MessageBox(Registration.this, "Required field: Number of previous Caesarean sections.");
                 txtprevcsec.requestFocus();
                 return;
             } else if (!chkprevcsecDK.isChecked() & (Integer.valueOf(txtprevcsec.getText().toString().length() == 0 ? "0" : txtprevcsec.getText().toString()) < 0 || Integer.valueOf(txtprevcsec.getText().toString().length() == 0 ? "99" : txtprevcsec.getText().toString()) > 99)) {
                 Connection.MessageBox(Registration.this, "Value should be between 0 and 99(Number of previous Caesarean sections).");
                 txtprevcsec.requestFocus();
                 return;
             } else if (!chkyrslstbthDK.isChecked() & txtyrslstbth.getText().toString().length() == 0 & secyrslstbth.isShown()) {
                 Connection.MessageBox(Registration.this, "Required field: Number of years since last birth? (completed years).");
                 txtyrslstbth.requestFocus();
                 return;
             } else if (!chkyrslstbthDK.isChecked() & (Integer.valueOf(txtyrslstbth.getText().toString().length() == 0 ? "0" : txtyrslstbth.getText().toString()) < 0 || Integer.valueOf(txtyrslstbth.getText().toString().length() == 0 ? "99" : txtyrslstbth.getText().toString()) > 99)) {
                 Connection.MessageBox(Registration.this, "Value should be between 0 and 99(Number of years since last birth? (completed years)).");
                 txtyrslstbth.requestFocus();
                 return;
             }

             /*DV = Global.DateValidate(dtpedd.getText().toString());
             if (DV.length() != 0 & !chkeddDK.isChecked() & secedd.isShown()) {
                 Connection.MessageBox(Registration.this, "Expected date of delivery:" + DV);
                 dtpedd.requestFocus();
                 return;
             } */

             if (!chkgaadmiDK.isChecked() & txtgaadmi.getText().toString().length() == 0 & secgaadmi.isShown()) {
                 Connection.MessageBox(Registration.this, "Required field: Gestational age at admission (weeks).");
                 txtgaadmi.requestFocus();
                 return;
             } else if ((Integer.valueOf(txtgaadmi.getText().toString().length() == 0 ? "10" : txtgaadmi.getText().toString()) < 10 || Integer.valueOf(txtgaadmi.getText().toString().length() == 0 ? "45" : txtgaadmi.getText().toString()) > 45) & !chkgaadmiDK.isChecked()) {
                 Connection.MessageBox(Registration.this, "Value should be between 10 and 45(Gestational age at admission (weeks)).");
                 txtgaadmi.requestFocus();
                 return;
             } else if (!rdogameth1.isChecked() & !rdogameth2.isChecked() & !rdogameth3.isChecked() & !rdogameth4.isChecked() & !rdogameth5.isChecked() & secgameth.isShown()) {
                 Connection.MessageBox(Registration.this, "Select anyone options from (Gestational age assessment method).");
                 rdogameth1.requestFocus();
                 return;
             } else if (!rdobb4expect1.isChecked() & !rdobb4expect2.isChecked() & !rdobb4expect3.isChecked() & secbb4expect.isShown()) {
                 Connection.MessageBox(Registration.this, "Select anyone options from (Birth less than 34 completed weeks gestation?(Suspected premature labour)).");
                 rdobb4expect1.requestFocus();
                 return;
             } else if (!rdonumbby1.isChecked() & !rdonumbby2.isChecked() & !rdonumbby3.isChecked() & !rdonumbby4.isChecked() & secnumbby.isShown()) {
                 Connection.MessageBox(Registration.this, "Select anyone options from (Current pregnancy).");
                 rdonumbby1.requestFocus();
                 return;
             } else if (txtnumPreg.getText().toString().length() == 0 & secnumPreg.isShown()) {
                 Connection.MessageBox(Registration.this, "Required field: Number.");
                 txtnumPreg.requestFocus();
                 return;
             } else if (Integer.valueOf(txtnumPreg.getText().toString().length() == 0 ? "0" : txtnumPreg.getText().toString()) < 0 || Integer.valueOf(txtnumPreg.getText().toString().length() == 0 ? "99" : txtnumPreg.getText().toString()) > 99) {
                 Connection.MessageBox(Registration.this, "Value should be between 0 and 99(Number).");
                 txtnumPreg.requestFocus();
                 return;
             } else if (!rdobheartadm1.isChecked() & !rdobheartadm2.isChecked() & !rdobheartadm3.isChecked() & secbheartadm.isShown()) {
                 Connection.MessageBox(Registration.this, "Select anyone options from (Fetal Heart Sound checked at admission?).");
                 rdobheartadm1.requestFocus();
                 return;
             } else if (!rdobheartrateadm1.isChecked() & !rdobheartrateadm2.isChecked() & !rdobheartrateadm3.isChecked() & !rdobheartrateadm4.isChecked() & secbheartrateadm.isShown()) {
                 Connection.MessageBox(Registration.this, "Select anyone options from (Fetal Heart Sound at admission).");
                 rdobheartrateadm1.requestFocus();
                 return;
             } else if (txtbheartratenum.getText().toString().length() == 0 & secbheartratenum.isShown()) {
                 Connection.MessageBox(Registration.this, "Required field: Number.");
                 txtbheartratenum.requestFocus();
                 return;
             } else if (Integer.valueOf(txtbheartratenum.getText().toString().length() == 0 ? "1" : txtbheartratenum.getText().toString()) < 1 || Integer.valueOf(txtbheartratenum.getText().toString().length() == 0 ? "999" : txtbheartratenum.getText().toString()) > 999) {
                 Connection.MessageBox(Registration.this, "Value should be between 1 and 999(Number).");
                 txtbheartratenum.requestFocus();
                 return;
             }else if (!rdoallocobsv1.isChecked() & !rdoallocobsv2.isChecked() & secallocobsv.isShown()) {
                 Connection.MessageBox(Registration.this, "Select anyone options from (Allocated to an observer).");
                 rdoallocobsv1.requestFocus();
                 return;
             }else if(chkanybcompadmh.isChecked() & txtanybcompadmoth.getText().length()==0){
                 Connection.MessageBox(Registration.this, "Required field:(37. Other complication specify).");
                 txtanybcompadmoth.requestFocus();
                 return;
             }

             //04 Jul 2017
             if (!chkgaadmiDK.isChecked() & txtgaadmi.getText().toString().length() == 0 & secgaadmi.isShown()) {
                 Connection.MessageBox(Registration.this, "Required field: Gestational age at admission (weeks).");
                 txtgaadmi.requestFocus();
                 return;
             }

             if (!chkgaadmiDK.isChecked() &
                     (Integer.valueOf(txtgaadmi.getText().toString().length() == 0 ? "0" : txtgaadmi.getText().toString()) < 34) &
                     !rdobb4expect1.isChecked() & secbb4expect.isShown()) {
                 Connection.MessageBox(Registration.this, "33. Value should be Yes, Where gestational age is less than 34 weeks.");
                 txtgaadmi.requestFocus();
                 return;
             }else if (!chkgaadmiDK.isChecked() &
                     (Integer.valueOf(txtgaadmi.getText().toString().length() == 0 ? "0" : txtgaadmi.getText().toString()) >= 34) &
                     rdobb4expect1.isChecked() & secbb4expect.isShown()) {
                 Connection.MessageBox(Registration.this, "33. Value should not be Yes, Where gestational age is greater or equal 34 weeks.");
                 txtgaadmi.requestFocus();
                 return;
             }
         }

         //KMC PreObserve
         else if(LOCATIONID.equals(ProjectSetting.KMC_ID)) {
             if (!rdoadwghedkmc1.isChecked() & !rdoadwghedkmc2.isChecked() & !rdoadwghedkmc3.isChecked() & secadwghedkmc.isShown()) {
                 Connection.MessageBox(Registration.this, "Select anyone options from (Baby weighed at admission).");
                 rdoadwghedkmc1.requestFocus();
                 return;
             } else if (!chkadwghtkmcDK.isChecked() & txtadwghtkmc.getText().toString().length() == 0 & secadwghtkmc.isShown()) {
                 Connection.MessageBox(Registration.this, "Required field: Baby’s weight at admission.");
                 txtadwghtkmc.requestFocus();
                 return;
             } else if (!chkadwghtkmcDK.isChecked() & (Integer.valueOf(txtadwghtkmc.getText().toString().length() == 0 ? "400" : txtadwghtkmc.getText().toString()) < 400 || Integer.valueOf(txtadwghtkmc.getText().toString().length() == 0 ? "9999" : txtadwghtkmc.getText().toString()) > 9999)) {
                 Connection.MessageBox(Registration.this, "Value should be between 400 and 9999(Baby’s weight at admission).");
                 txtadwghtkmc.requestFocus();
                 return;
             } else if (!chkgaadmDK.isChecked() & txtgaadm.getText().toString().length() == 0 & secgaadm.isShown()) {
                 Connection.MessageBox(Registration.this, "Required field: Gestational age at admission (weeks).");
                 txtgaadm.requestFocus();
                 return;
             } else if (!chkgaadmDK.isChecked() & ((Integer.valueOf(txtgaadm.getText().toString().length() == 0 ? "10" : txtgaadm.getText().toString()) < 10 || Integer.valueOf(txtgaadm.getText().toString().length() == 0 ? "48" : txtgaadm.getText().toString()) > 48) & !txtgaadm.getText().toString().equals("97"))) {
                 Connection.MessageBox(Registration.this, "Value should be between 10 and 48, 97(Gestational age at admission (weeks)-97 for Dont know).");
                 txtgaadm.requestFocus();
                 return;
             } else if (spnplacedeliv.getSelectedItemPosition() == 0 & secplacedeliv.isShown()) {
                 Connection.MessageBox(Registration.this, "Required field: Place of Delivery.");
                 spnplacedeliv.requestFocus();
                 return;
             } else if (txtplacedelivoth.getText().toString().length() == 0 & secplacedelivoth.isShown()) {
                 Connection.MessageBox(Registration.this, "Required field: Others.");
                 txtplacedelivoth.requestFocus();
                 return;
             } else if (txtfacnamedeliv.getText().toString().length() == 0 & secfacnamedeliv.isShown()) {
                 Connection.MessageBox(Registration.this, "Required field: Name of facility where delivered.");
                 txtfacnamedeliv.requestFocus();
                 return;
             }
         }

         //Infection : 05 Jul 2017
         else if(LOCATIONID.equals(ProjectSetting.SEPSIS_ID)) {
             if(spnInfDelPlace.getSelectedItemPosition()==0  & secInfDelPlace.isShown())
             {
                 Connection.MessageBox(Registration.this, "Required field: Place of Delivery.");
                 spnInfDelPlace.requestFocus();
                 return;
             }
             else if(txtInfDelPlaceoth.getText().toString().length()==0 & secInfDelPlaceoth.isShown())
             {
                 Connection.MessageBox(Registration.this, "Required field: Other (Specify).");
                 txtInfDelPlaceoth.requestFocus();
                 return;
             }
             else if(spnInfDelMod.getSelectedItemPosition()==0  & secInfDelMod.isShown())
             {
                 Connection.MessageBox(Registration.this, "Required field: Mode of birth/delivery.");
                 spnInfDelMod.requestFocus();
                 return;
             }
             else if(!chkInfGAgeDK.isChecked() & txtInfGAge.getText().toString().length()==0 & secInfGAge.isShown())
             {
                 Connection.MessageBox(Registration.this, "Required field: Gestational age at birth (weeks).");
                 txtInfGAge.requestFocus();
                 return;
             }
             else if(!chkInfGAgeDK.isChecked() & (Integer.valueOf(txtInfGAge.getText().toString().length()==0 ? "10" : txtInfGAge.getText().toString()) < 10 || Integer.valueOf(txtInfGAge.getText().toString().length()==0 ? "45" : txtInfGAge.getText().toString()) > 45))
             {
                 Connection.MessageBox(Registration.this, "Value should be between 10 and 45(Gestational age at birth (weeks)).");
                 txtInfGAge.requestFocus();
                 return;
             }
             else if(!chkInfBWeightDK.isChecked() & txtInfBWeight.getText().toString().length()==0 & secInfBWeight.isShown())
             {
                 Connection.MessageBox(Registration.this, "Required field: Birth Weight.");
                 txtInfBWeight.requestFocus();
                 return;
             }
             else if(!chkInfBWeightDK.isChecked() & (Integer.valueOf(txtInfBWeight.getText().toString().length()==0 ? "400" : txtInfBWeight.getText().toString()) < 400 || Integer.valueOf(txtInfBWeight.getText().toString().length()==0 ? "9999" : txtInfBWeight.getText().toString()) > 9999))
             {
                 Connection.MessageBox(Registration.this, "Value should be between 400 and 9999(Birth Weight).");
                 txtInfBWeight.requestFocus();
                 return;
             }
         }

         String SQL = "";
         RadioButton rb;

         Registration_DataModel objSave = new Registration_DataModel();
         objSave.setCountryCode(txtCountryCode.getText().toString());
         objSave.setFaciCode(txtFaciCode.getText().toString());
         objSave.setRegisType(txtRegisType.getText().toString());
         objSave.setDataID(txtDataID.getText().toString());
         objSave.setRegDate(dtpRegDate.getText().toString().length() > 0 ? Global.DateConvertYMD(dtpRegDate.getText().toString()) : dtpRegDate.getText().toString());
         objSave.setRegTime(txtRegTime.getText().toString());
         objSave.setHospID(txtHospID.getText().toString());
         objSave.setHospIDReTyp(txtHospIDReTyp.getText().toString());

         String[] d_rdogrpConsent = new String[] {"1","2","3","4","5"};
         objSave.setConsent("");
         for (int i = 0; i < rdogrpConsent.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpConsent.getChildAt(i);
             if (rb.isChecked()) objSave.setConsent(d_rdogrpConsent[i]);
         }
         objSave.setConReason(txtConReason.getText().toString());
         objSave.setStudyID(txtStudyID.getText().toString());
         String[] d_rdogrpMotRegis = new String[] {"1","2"};
         objSave.setMotRegis("");
         for (int i = 0; i < rdogrpMotRegis.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpMotRegis.getChildAt(i);
             if (rb.isChecked()) objSave.setMotRegis(d_rdogrpMotRegis[i]);
         }

         objSave.setMotDataID(txtMotDataID.getText().toString());
         objSave.setMotStudyID(txtMotStudyID.getText().toString());
         objSave.setMotStudyIDReType(txtMotStudyIDReType.getText().toString());

         objSave.setMotHospID(txtMotHospID.getText().toString());
         objSave.setMotName(txtMotName.getText().toString());
         objSave.setMotDOB(dtpMotDOB.getText().toString().length() > 0 ? Global.DateConvertYMD(dtpMotDOB.getText().toString()) : dtpMotDOB.getText().toString());
         objSave.setMotDOBDK((chkMotDOBDK.isChecked()?"1":(secMotDOBDK.isShown()?"2":"")));
         objSave.setMotAge(txtMotAge.getText().toString());

         objSave.setMotEdu(txtMotEdu.getText().toString());
         objSave.setMotEduDK(chkMotEduDK.isChecked()?"1":(secMotEdu.isShown()?"2":"3"));
         objSave.setParity((spnParity.getSelectedItemPosition() == 0 ? "" : Connection.SelectedSpinnerValue(spnParity.getSelectedItem().toString(), "-")));

         objSave.setMotEthnicity((spnMotEthnicity.getSelectedItemPosition() == 0 ? "" : Connection.SelectedSpinnerValue(spnMotEthnicity.getSelectedItem().toString(), "-")));
         objSave.setMotEthnicityOth(txtMotEthnicityOth.getText().toString());

         objSave.setMotReligion((spnMotReligion.getSelectedItemPosition() == 0 ? "" : Connection.SelectedSpinnerValue(spnMotReligion.getSelectedItem().toString(), "-")));
         objSave.setMotReligionOth(txtMotReligionOth.getText().toString());

         objSave.setAddress1((spnAddress1.getSelectedItemPosition() == 0 ? "" : Connection.SelectedSpinnerValue(spnAddress1.getSelectedItem().toString(), "-")));
         //objSave.setAddress2((spnAddress2.getSelectedItemPosition() == 0 ? "" : Connection.SelectedSpinnerValue(spnAddress2.getSelectedItem().toString(), "-")));
         //objSave.setAddress3((spnAddress3.getSelectedItemPosition() == 0 ? "" : Connection.SelectedSpinnerValue(spnAddress3.getSelectedItem().toString(), "-")));
         //objSave.setAddress4((spnAddress4.getSelectedItemPosition() == 0 ? "" : Connection.SelectedSpinnerValue(spnAddress4.getSelectedItem().toString(), "-")));
         objSave.setAddress2(txtAddress2.getText().toString());
         objSave.setAddress3(txtAddress3.getText().toString());
         objSave.setAddress4(txtAddress4.getText().toString());


         objSave.setAddressDetail(txtAddressDetail.getText().toString());
         objSave.setMotContact(txtMotContact.getText().toString());
         objSave.setAltContact(txtAltContact.getText().toString());
         objSave.setNameNewBorn(txtNameNewBorn.getText().toString());
         objSave.setDOBNewborn(dtpDOBNewborn.getText().toString().length() > 0 ? Global.DateConvertYMD(dtpDOBNewborn.getText().toString()) : dtpDOBNewborn.getText().toString());
         objSave.setDOBNewbornDK(chkDOBNewbornDK.isChecked()?"1":(secDOBNewborn.isShown()?"2":""));

         objSave.setTOBNewborn(txtTOBNewborn.getText().toString());
         objSave.setTOBNewbornDK(chkTOBNewbornDK.isChecked()?"1":(secTOBNewborn.isShown()?"2":""));

         objSave.setAgeNewborn(txtAgeNewborn.getText().toString());
         String[] d_rdogrpAgeNewbornDMY = new String[] {"1","2","3"};
         objSave.setAgeNewbornDMY("");
         for (int i = 0; i < rdogrpAgeNewbornDMY.getChildCount(); i++)
         {
             rb = (RadioButton)rdogrpAgeNewbornDMY.getChildAt(i);
             if (rb.isChecked()) objSave.setAgeNewbornDMY(d_rdogrpAgeNewbornDMY[i]);
         }
         objSave.setSex(rdoSex1.isChecked()?"1":(rdoSex2.isChecked()?"2":(rdoSex3.isChecked()?"3":"")));
         objSave.setFatherName(txtFatherName.getText().toString());
         String A,B,C,D;
         A = spnAddress1.getSelectedItemPosition()>0 ? spnAddress1.getSelectedItem().toString().split("-")[1]:"";
         //B = spnAddress2.getSelectedItemPosition()>0 ? spnAddress2.getSelectedItem().toString().split("-")[1]:"";
         //C = spnAddress3.getSelectedItemPosition()>0 ? spnAddress3.getSelectedItem().toString().split("-")[1]:"";
         //D = spnAddress4.getSelectedItemPosition()>0 ? spnAddress4.getSelectedItem().toString().split("-")[1]:"";
         objSave.setCompleteAdd(A + ", "+ txtAddress2.getText().toString() +", "+ txtAddress3.getText().toString() +", "+ txtAddress4.getText().toString());

         objSave.setEnDt(Global.DateTimeNowYMDHMS());
         objSave.setStartTime(STARTTIME);
         objSave.setEndTime(g.CurrentTime24());
         objSave.setDeviceID(DEVICEID);
         objSave.setEntryUser(ENTRYUSER); //from data entry user list
         objSave.setmodifyDate(Global.DateTimeNowYMDHMS());
         //objSave.setLat(Double.toString(currentLatitude));
         //objSave.setLon(Double.toString(currentLongitude));

         String status = objSave.SaveUpdateData(this);
         if(status.length()==0) {
             if(LOCATIONID.equals(ProjectSetting.LABOR_AND_DELIVERY_ID)) {
                 String Status1 = DataSaveObsHis();
                 if (Status1.length() != 0) {
                     Connection.MessageBox(Registration.this, Status1);
                     return;
                 }
             }else if(LOCATIONID.equals(ProjectSetting.KMC_ID)) {
                 String Status2 = KMCPreObs_DataSave();
                 if (Status2.length() != 0) {
                     Connection.MessageBox(Registration.this, Status2);
                     return;
                 }
             }else if(LOCATIONID.equals(ProjectSetting.SEPSIS_ID)) {
                 String Status3 = InfectionPreObs_DataSave();
                 if (Status3.length() != 0) {
                     Connection.MessageBox(Registration.this, Status3);
                     return;
                 }
             }
             finish();
             Intent returnIntent = new Intent();
             returnIntent.putExtra("res", "");
             setResult(Activity.RESULT_OK, returnIntent);

             Connection.MessageBox(Registration.this, "Saved Successfully");
             //Connection.RegistrationDataSync(Registration.this);
             new Thread() {
                 public void run() {
                     try {
                         Connection.RegistrationDataSync(Registration.this);
                     } catch (Exception e) {
                     }
                 }
             }.start();
         }
         else{
             Connection.MessageBox(Registration.this, status);
             return;
         }
     }
     catch(Exception  e)
     {
         Connection.MessageBox(Registration.this, e.getMessage());
         return;
     }
 }

 private void DataSearch(String CountryCode, String FaciCode, String DataID)
     {
       try
        {
           RadioButton rb;
           Registration_DataModel d = new Registration_DataModel();
           String SQL = "Select * from "+ TableName +"  Where CountryCode='"+ CountryCode +"' and FaciCode='"+ FaciCode +"' and DataID='"+ DataID +"'";
           List<Registration_DataModel> data = d.SelectAll(this, SQL);
           for(Registration_DataModel item : data){
             txtCountryCode.setText(item.getCountryCode());
             txtFaciCode.setText(item.getFaciCode());
             txtRegisType.setText(item.getRegisType());
             txtDataID.setText(item.getDataID());
             dtpRegDate.setText(item.getRegDate().toString().length()==0 ? "" : Global.DateConvertDMY(item.getRegDate()));
             txtRegTime.setText(item.getRegTime());
             txtHospID.setText(item.getHospID());
             txtHospIDReTyp.setText(item.getHospIDReTyp());

             String[] d_rdogrpConsent = new String[] {"1","2","3","4","5"};
             for (int i = 0; i < d_rdogrpConsent.length; i++)
             {
                 if (item.getConsent().equals(String.valueOf(d_rdogrpConsent[i])))
                 {
                     rb = (RadioButton)rdogrpConsent.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             txtConReason.setText(item.getConReason());

             txtStudyID.setText(item.getStudyID());
             //-------------------------------------------------------------------------------------
               SID = item.getStudyID();
             //-------------------------------------------------------------------------------------
             String[] d_rdogrpMotRegis = new String[] {"1","2"};
             for (int i = 0; i < d_rdogrpMotRegis.length; i++)
             {
                 if (item.getMotRegis().equals(String.valueOf(d_rdogrpMotRegis[i])))
                 {
                     rb = (RadioButton)rdogrpMotRegis.getChildAt(i);
                     rb.setChecked(true);
                 }
             }
             txtMotDataID.setText(item.getMotDataID());
             txtMotStudyID.setText(item.getMotStudyID());
               txtMotStudyIDReType.setText(item.getMotStudyIDReType());
             txtMotHospID.setText(item.getMotHospID());
             txtMotName.setText(item.getMotName());
             dtpMotDOB.setText(item.getMotDOB().toString().length()==0 ? "" : Global.DateConvertDMY(item.getMotDOB()));
             if(item.getMotDOBDK().equals("1"))
             {
                chkMotDOBDK.setChecked(true);
             }
             else if(item.getMotDOBDK().equals("2"))
             {
                chkMotDOBDK.setChecked(false);
             }
             txtMotAge.setText(item.getMotAge());
               txtMotEdu.setText(item.getMotEdu());
               if(item.getMotEduDK().equals("1")) chkMotEduDK.setChecked(true); else chkMotEduDK.setChecked(false);

               spnParity.setSelection(Global.SpinnerItemPositionAnyLength(spnParity, item.getParity()));

             spnMotEthnicity.setSelection(Global.SpinnerItemPositionAnyLength(spnMotEthnicity, item.getMotEthnicity()));
             txtMotEthnicityOth.setText(item.getMotEthnicityOth());
             spnMotReligion.setSelection(Global.SpinnerItemPositionAnyLength(spnMotReligion, item.getMotReligion()));
             txtMotReligionOth.setText(item.getMotReligionOth());
             spnAddress1.setSelection(Global.SpinnerItemPositionAnyLength(spnAddress1, item.getAddress1()));
             /*spnAddress2.setSelection(Global.SpinnerItemPositionAnyLength(spnAddress2, item.getAddress2()));
             spnAddress3.setSelection(Global.SpinnerItemPositionAnyLength(spnAddress3, item.getAddress3()));
             spnAddress4.setSelection(Global.SpinnerItemPositionAnyLength(spnAddress4, item.getAddress4()));*/
             txtAddress2.setText(item.getAddress2());
             txtAddress3.setText(item.getAddress3());
             txtAddress4.setText(item.getAddress4());

             txtAddressDetail.setText(item.getAddressDetail());
             txtMotContact.setText(item.getMotContact());
             txtAltContact.setText(item.getAltContact());
             txtNameNewBorn.setText(item.getNameNewBorn());

             dtpDOBNewborn.setText(item.getDOBNewborn().toString().length()==0 ? "" : Global.DateConvertDMY(item.getDOBNewborn()));
             if(item.getDOBNewbornDK().equals("1")) chkDOBNewbornDK.setChecked(true); else chkDOBNewbornDK.setChecked(false);

             txtTOBNewborn.setText(item.getTOBNewborn());
             if(item.getTOBNewbornDK().equals("1")) chkTOBNewbornDK.setChecked(true); else chkTOBNewbornDK.setChecked(false);

             txtAgeNewborn.setText(item.getAgeNewborn());
             String[] d_rdogrpAgeNewbornDMY = new String[] {"1","2","3"};
             for (int i = 0; i < d_rdogrpAgeNewbornDMY.length; i++)
             {
                 if (item.getAgeNewbornDMY().equals(String.valueOf(d_rdogrpAgeNewbornDMY[i])))
                 {
                     rb = (RadioButton)rdogrpAgeNewbornDMY.getChildAt(i);
                     rb.setChecked(true);
                 }
             }

               String[] d_rdogrpSex = new String[] {"1","2","3"};
               for (int i = 0; i < d_rdogrpSex.length; i++)
               {
                   if (item.getSex().equals(String.valueOf(d_rdogrpSex[i])))
                   {
                       rb = (RadioButton)rdogrpSex.getChildAt(i);
                       rb.setChecked(true);
                   }
               }

             txtFatherName.setText(item.getFatherName());
           }
        }
        catch(Exception  e)
        {
            Connection.MessageBox(Registration.this, e.getMessage());
            return;
        }
     }



 protected Dialog onCreateDialog(int id) {
   final Calendar c = Calendar.getInstance();
   hour   = c.get(Calendar.HOUR_OF_DAY);
   minute = c.get(Calendar.MINUTE);

     Calendar cal = Calendar.getInstance();
     SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
     String DT = "";
     if (VariableID.equals("btnRegDate"))
     {
         DT = dtpRegDate.getText().toString();
     }
     else if (VariableID.equals("btnMotDOB"))
     {
         DT = dtpMotDOB.getText().toString();
     }
     else if (VariableID.equals("btnDOBNewborn"))
     {
         DT = dtpDOBNewborn.getText().toString();
     }
     else if(VariableID.equals("btnedd"))
     {
         DT = dtpedd.getText().toString();
     }

     try {
         cal.setTime(formatter.parse(DT));
     } catch (ParseException e) {
         e.printStackTrace();
     }

     int mYear  = 0;
     int mMonth = 0;
     int mDay   = 0;

     if(DT.length()==0){
         mYear  = g.mYear;
         mMonth = g.mMonth;
         mDay   = g.mDay;
     }else{
         mYear  = cal.get(Calendar.YEAR);
         mMonth = cal.get(Calendar.MONTH);
         mDay   = cal.get(Calendar.DAY_OF_MONTH);
     }

   switch (id) {
       case DATE_DIALOG:
           return new DatePickerDialog(this, mDateSetListener,mYear,mMonth,mDay);

       case TIME_DIALOG:
           return new TimePickerDialog(this, timePickerListener, hour, minute,false);
       }
     return null;
 }

 private DatePickerDialog.OnDateSetListener mDateSetListener = new DatePickerDialog.OnDateSetListener() {
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        mYear = year;
        mMonth = monthOfYear+1;
        mDay = dayOfMonth;

        EditText dtpDate;


             dtpDate = (EditText)findViewById(R.id.dtpRegDate);
             if (VariableID.equals("btnRegDate"))
              {
                  dtpDate = (EditText)findViewById(R.id.dtpRegDate);
                  dtpDate.setText(new StringBuilder()
                          .append(Global.Right("00"+mDay,2)).append("/")
                          .append(Global.Right("00"+mMonth,2)).append("/")
                          .append(mYear));
              }
             else if (VariableID.equals("btnMotDOB"))
              {
                  dtpDate = (EditText)findViewById(R.id.dtpMotDOB);
                  dtpDate.setText(new StringBuilder()
                          .append(Global.Right("00"+mDay,2)).append("/")
                          .append(Global.Right("00"+mMonth,2)).append("/")
                          .append(mYear));

                  String AgeDay = String.valueOf(Global.DateDifferenceDays(dtpRegDate.getText().toString(),dtpDate.getText().toString()));
                  txtMotAge.setText(String.valueOf((int)(Double.valueOf(AgeDay)/365.25)));
                  txtMotAge.setEnabled(false);
                  chkMotDOBDK.setChecked(false);
              }
             else if (VariableID.equals("btnDOBNewborn"))
              {
                  dtpDate = (EditText)findViewById(R.id.dtpDOBNewborn);
                  dtpDate.setText(new StringBuilder()
                          .append(Global.Right("00"+mDay,2)).append("/")
                          .append(Global.Right("00"+mMonth,2)).append("/")
                          .append(mYear));
                  String AgeDay = String.valueOf(Global.DateDifferenceDays(dtpRegDate.getText().toString(),dtpDate.getText().toString()));
                  txtAgeNewborn.setText(AgeDay);
                  txtAgeNewborn.setEnabled(false);
              }
              else if(VariableID.equals("btnedd"))
             {
                 dtpDate = (EditText)findViewById(R.id.dtpedd);
                 dtpDate.setText(new StringBuilder()
                         .append(Global.Right("00"+mDay,2)).append("/")
                         .append(Global.Right("00"+mMonth,2)).append("/")
                         .append(mYear));
                 chkeddDK.setChecked(false);
             }

      }
  };

 private TimePickerDialog.OnTimeSetListener timePickerListener = new TimePickerDialog.OnTimeSetListener() {
    public void onTimeSet(TimePicker view, int selectedHour, int selectedMinute) {
       hour = selectedHour; minute = selectedMinute;
       EditText tpTime;


              tpTime = (EditText)findViewById(R.id.txtRegTime);
             if (VariableID.equals("btnRegTime"))
              {
                  tpTime = (EditText)findViewById(R.id.txtRegTime);
              }
              else if (VariableID.equals("btnTOBNewborn"))
             {
                 tpTime = (EditText)findViewById(R.id.txtTOBNewborn);
             }
          tpTime.setText(new StringBuilder().append(Global.Right("00"+hour,2)).append(":").append(Global.Right("00"+minute,2)));

    }
  };


 //GPS Reading
 //.....................................................................................................
 public void FindLocation() {
 LocationManager locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);

 LocationListener locationListener = new LocationListener() {
     public void onLocationChanged(Location location) {
         updateLocation(location);
     }
     public void onStatusChanged(String provider, int status, Bundle extras) {
     }
     public void onProviderEnabled(String provider) {
     }
     public void onProviderDisabled(String provider) {
     }
   };
  locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
 }

 void updateLocation(Location location) {
     currentLocation  = location;
     currentLatitude  = currentLocation.getLatitude();
     currentLongitude = currentLocation.getLongitude();
 }


 // Method to turn on GPS
 public void turnGPSOn(){
     try
     {
         String provider = Settings.Secure.getString(getContentResolver(), Settings.Secure.LOCATION_PROVIDERS_ALLOWED);
         if(!provider.contains("gps")){ //if gps is disabled
             final Intent poke = new Intent();
             poke.setClassName("com.android.settings", "com.android.settings.widget.SettingsAppWidgetProvider");
             poke.addCategory(Intent.CATEGORY_ALTERNATIVE);
             poke.setData(Uri.parse("3"));
             sendBroadcast(poke);
         }
     }
     catch (Exception e) {
     }
 }
 
 // Method to turn off the GPS
 public void turnGPSOff(){
     String provider = Settings.Secure.getString(getContentResolver(), Settings.Secure.LOCATION_PROVIDERS_ALLOWED);
 
     if(provider.contains("gps")){ //if gps is enabled
         final Intent poke = new Intent();
         poke.setClassName("com.android.settings", "com.android.settings.widget.SettingsAppWidgetProvider");
         poke.addCategory(Intent.CATEGORY_ALTERNATIVE);
         poke.setData(Uri.parse("3"));
         sendBroadcast(poke);
     }
 }
 
 // turning off the GPS if its in on state. to avoid the battery drain.
 @Override
 protected void onDestroy() {
     // TODO Auto-generated method stub
     super.onDestroy();
     turnGPSOff();
 }


     private String NewDataID(String DeviceID)
     {
         String PID = C.ReturnSingleValue("Select (ifnull(max(cast(DataID as numeric(10))),0)+1)MaxId from Registration where DeviceID='"+ DeviceID +"'");
         return DeviceID + Global.Right("00000"+PID,6);
     }

     private String NewStudyID(String DeviceID)
     {
         String PID = C.ReturnSingleValue("Select (ifnull(max(cast(StudyID as numeric(12))),0)+1)MaxId from Registration where substr(StudyId,1,3)='"+ DeviceID +"'");
         //String PID = C.ReturnSingleValue("Select (ifnull(max(cast(StudyID as numeric(12))),0)+1)MaxId from Registration where DeviceID='"+ DeviceID +"'");
         return DeviceID  + Global.Right("00000"+PID,6);
     }

     private void MotherDataSearch(String CountryCode, String FaciCode, String DataID)
     {
         try
         {
             RadioButton rb;
             Registration_DataModel d = new Registration_DataModel();
             String SQL = "";//"Select * from "+ TableName +"  Where CountryCode='"+ CountryCode +"' and FaciCode='"+ FaciCode +"' and DataID='"+ DataID +"'";
             SQL = "Select r.CountryCode, r.FaciCode, RegisType, r.DataID, RegDate, RegTime, HospID, Consent, StudyID, MotRegis, MotStudyID, MotStudyIDReType,";
             SQL += " MotHospID, MotName, MotDOB, MotDOBDK, MotAge, MotEthnicity, MotEthnicityOth, MotReligion, MotReligionOth, Address1, Address2, Address3, Address4,";
             SQL += " AddressDetail, MotContact, AltContact, NameNewBorn, DOBNewborn, AgeNewborn, AgeNewbornDMY, Sex, FatherName, CompleteAdd, CompleteStatus, ObjPause,";
             SQL += " ObserverId, StatusObj, StatusRS, StatusDE, (case when h.gaadm is null then '' else h.gaadm end)gaadmi,";
             SQL += " (case when h.gaadmDK is null then '2' else h.gaadmDK end)gaadmDK,MotEdu,MotEduDK";
             SQL += " from Registration r";
             SQL += " Left outer join ObsHisCurPreg h on r.CountryCode=h.CountryCode and r.FaciCode=h.FaciCode and r.DataID=h.DataID";
             SQL += " Where r.CountryCode='"+ CountryCode +"' and r.FaciCode='"+ FaciCode +"' and r.DataID='"+ DataID +"'";

             List<Registration_DataModel> data = d.SelectAll_Mother(this, SQL);
             for(Registration_DataModel item : data){

                 //txtMotStudyID.setText(item.getMotStudyID());
                 //txtMotStudyIDReType.setText(item.getMotStudyIDReType());
                 txtMotHospID.setText(item.getHospID());
                 txtMotName.setText(item.getMotName());
                 dtpMotDOB.setText(item.getMotDOB().toString().length()==0 ? "" : Global.DateConvertDMY(item.getMotDOB()));
                 if(item.getMotDOBDK().equals("1"))
                 {
                     chkMotDOBDK.setChecked(true);
                 }
                 else if(item.getMotDOBDK().equals("2"))
                 {
                     chkMotDOBDK.setChecked(false);
                 }
                 txtMotAge.setText(item.getMotAge());
                 spnMotEthnicity.setSelection(Global.SpinnerItemPositionAnyLength(spnMotEthnicity, item.getMotEthnicity()));
                 spnMotReligion.setSelection(Global.SpinnerItemPositionAnyLength(spnMotReligion, item.getMotReligion()));
                 txtMotReligionOth.setText(item.getMotReligionOth());
                 spnAddress1.setSelection(Global.SpinnerItemPositionAnyLength(spnAddress1, item.getAddress1()));

                 txtAddress2.setText(item.getAddress2());
                 txtAddress3.setText(item.getAddress3());
                 txtAddress4.setText(item.getAddress4());

                 //spnAddress2.setSelection(Global.SpinnerItemPositionAnyLength(spnAddress2, item.getAddress2()));
                 //spnAddress3.setSelection(Global.SpinnerItemPositionAnyLength(spnAddress3, item.getAddress3()));
                 //spnAddress4.setSelection(Global.SpinnerItemPositionAnyLength(spnAddress4, item.getAddress4()));
                 txtAddressDetail.setText(item.getAddressDetail());
                 txtMotContact.setText(item.getMotContact());
                 txtAltContact.setText(item.getAltContact());

                 txtgaadm.setText(item.getgaadmi());
                 if(item.getgaadmiDK().equals("1")) chkgaadmDK.setChecked(true); else chkgaadmDK.setChecked(false);

             }
         }
         catch(Exception  e)
         {
             Connection.MessageBox(Registration.this, e.getMessage());
             return;
         }
     }



     Dialog dialog;
     private void LD_Patient_List_Form() {
         try {
             dialog = new Dialog(Registration.this);
             dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
             dialog.setContentView(R.layout.ld_patient_list);
             dialog.setCanceledOnTouchOutside(true);
             dialog.setCancelable(true);

             Window window = dialog.getWindow();
             WindowManager.LayoutParams wlp = window.getAttributes();

             wlp.gravity = Gravity.TOP;
             wlp.flags &= ~WindowManager.LayoutParams.FLAG_DIM_BEHIND;
             window.setAttributes(wlp);

             Button cmdClose = (Button) dialog.findViewById(R.id.cmdClose);
             cmdClose.setOnClickListener(new View.OnClickListener() {
                 public void onClick(View v) {
                     dialog.dismiss();
                 }});


             try
             {
                 Registration_DataModel d = new Registration_DataModel();
                 String param = "";
                 String SQL = "Select * from Registration r Where r.CountryCode='"+ COUNTRYCODE +"' and r.FaciCode='"+ FACICODE +"' and r.Consent='1' and r.RegisType='2' order by date(r.EnDt) desc limit 50";

                 List<Registration_DataModel> data = d.SelectAll(this, SQL);
                 dataList.clear();
                 dataAdapter = null;

                 ListView list = (ListView)dialog.findViewById(R.id.lstData);

                 HashMap<String, String> map;
                 Integer i = 0;
                 for(Registration_DataModel item : data){
                     map = new HashMap<String, String>();

                     map.put("dataid", item.getDataID());
                     map.put("hospitalid", item.getHospID());
                     map.put("studyid", item.getStudyID());
                     map.put("patname", item.getMotName());
                     map.put("patage", "Age: "+ (item.getRegisType().equals(ProjectSetting.LABOR_AND_DELIVERY_ID)? item.getMotAge()+ " years" : item.getAgeNewborn()+" "+ (item.getAgeNewbornDMY().equals("1")?"days":(item.getAgeNewbornDMY().equals("2")?"month":"years"))));
                     map.put("patagedmy", item.getAgeNewbornDMY());
                     map.put("patsex", "");
                     map.put("patdob",item.getMotDOB());
                     map.put("regdate", item.getRegDate());
                     map.put("regtime", item.getRegTime());
                     map.put("mainaddress", item.getCompleteAdd());
                     map.put("phone1", item.getMotContact());
                     map.put("phone2", item.getAltContact());
                     map.put("sl",String.valueOf(i));

                     i+=1;
                     dataList.add(map);
                 }

                 dataAdapter = new SimpleAdapter(Registration.this, dataList, R.layout.ld_patient_list,new String[] {"rowsec"},
                         new int[] {R.id.secRow});
                 list.setAdapter(new DataListAdapter(this, dataAdapter));

             }
             catch(Exception  e)
             {
                 Connection.MessageBox(Registration.this, e.getMessage());
                 return;
             }

             dialog.show();
         } catch (Exception e) {
             Connection.MessageBox(Registration.this, e.getMessage());
             return;
         }
     }


     public class DataListAdapter extends BaseAdapter
     {
         private Context context;
         private SimpleAdapter dataAdap;

         public DataListAdapter(Context c, SimpleAdapter da){ context = c;  dataAdap = da; }
         public int getCount() {  return dataAdap.getCount();  }
         public Object getItem(int position) {  return position;  }
         public long getItemId(int position) {  return position;  }
         public View getView(final int position, View convertView, ViewGroup parent) {
             LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
             if (convertView == null) {
                 convertView = inflater.inflate(R.layout.ld_patient_list_row, null);
             }
             //LinearLayout   secListRow = (LinearLayout)convertView.findViewById(R.id.secListRow);
             final RelativeLayout secRow = (RelativeLayout) convertView.findViewById(R.id.secRow);
             final TextView studyId = (TextView) convertView.findViewById(R.id.txtStudyID);
             final TextView hospitalId = (TextView) convertView.findViewById(R.id.txtHospID);
             final TextView patientName = (TextView) convertView.findViewById(R.id.txtName);
             final TextView patientAge = (TextView) convertView.findViewById(R.id.txtAge);
             final TextView patientAddress = (TextView) convertView.findViewById(R.id.txtAddress);
             final TextView location = (TextView) convertView.findViewById(R.id.lblType);

             final HashMap<String, String> o = (HashMap<String, String>) dataAdap.getItem(position);
             studyId.setText(o.get("studyid"));
             hospitalId.setText(o.get("hospitalid"));
             patientName.setText(o.get("patname"));
             patientAge.setText(o.get("patage"));
             patientAddress.setText(o.get("mainaddress"));
             if(Integer.valueOf(o.get("sl"))%2==0)
                 secRow.setBackgroundColor(Color.parseColor("#F3F3F3"));
             else
                 secRow.setBackgroundColor(Color.parseColor("#FFFFFF"));

             secRow.setOnClickListener(new View.OnClickListener() {
                 public void onClick(View v) {
                     txtMotDataID.setText(o.get("dataid"));
                     txtMotStudyID.setText(o.get("studyid"));
                     txtMotStudyIDReType.setText(o.get("studyid"));
                     MotherDataSearch(COUNTRYCODE, FACICODE, o.get("dataid"));
                     dialog.dismiss();
                 }
             });



             return convertView;
         }
     }


     private void ObsHos_Initialize()
     {
         seccard=(LinearLayout)findViewById(R.id.seccard);
         linecard=(View)findViewById(R.id.linecard);
         Vlblcard = (TextView) findViewById(R.id.Vlblcard);
         rdogrpcard = (RadioGroup) findViewById(R.id.rdogrpcard);

         rdocard1 = (RadioButton) findViewById(R.id.rdocard1);
         rdocard2 = (RadioButton) findViewById(R.id.rdocard2);
         rdocard7 = (RadioButton) findViewById(R.id.rdocard7);

         secprevpreg=(LinearLayout)findViewById(R.id.secprevpreg);
         lineprevpreg=(View)findViewById(R.id.lineprevpreg);
         Vlblprevpreg=(TextView) findViewById(R.id.Vlblprevpreg);
         txtprevpreg=(EditText) findViewById(R.id.txtprevpreg);
         secprevliveb=(LinearLayout)findViewById(R.id.secprevliveb);
         lineprevliveb=(View)findViewById(R.id.lineprevliveb);
         Vlblprevliveb=(TextView) findViewById(R.id.Vlblprevliveb);
         txtprevliveb=(EditText) findViewById(R.id.txtprevliveb);
         secprevstillb=(LinearLayout)findViewById(R.id.secprevstillb);
         lineprevstillb=(View)findViewById(R.id.lineprevstillb);
         Vlblprevstillb=(TextView) findViewById(R.id.Vlblprevstillb);
         txtprevstillb=(EditText) findViewById(R.id.txtprevstillb);
         secprevab=(LinearLayout)findViewById(R.id.secprevab);
         lineprevab=(View)findViewById(R.id.lineprevab);
         Vlblprevab=(TextView) findViewById(R.id.Vlblprevab);
         txtprevab=(EditText) findViewById(R.id.txtprevab);
         secprevcsec=(LinearLayout)findViewById(R.id.secprevcsec);
         lineprevcsec=(View)findViewById(R.id.lineprevcsec);
         Vlblprevcsec=(TextView) findViewById(R.id.Vlblprevcsec);
         txtprevcsec=(EditText) findViewById(R.id.txtprevcsec);
         secyrslstbth=(LinearLayout)findViewById(R.id.secyrslstbth);
         lineyrslstbth=(View)findViewById(R.id.lineyrslstbth);
         Vlblyrslstbth=(TextView) findViewById(R.id.Vlblyrslstbth);
         txtyrslstbth=(EditText) findViewById(R.id.txtyrslstbth);
         secedd=(LinearLayout)findViewById(R.id.secedd);
         lineedd=(View)findViewById(R.id.lineedd);
         Vlbledd=(TextView) findViewById(R.id.Vlbledd);
         dtpedd=(EditText) findViewById(R.id.dtpedd);
         seceddDK=(LinearLayout)findViewById(R.id.seceddDK);
         lineeddDK=(View)findViewById(R.id.lineeddDK);
         VlbleddDK=(TextView) findViewById(R.id.VlbleddDK);
         chkeddDK=(CheckBox) findViewById(R.id.chkeddDK);
         secgaadmi=(LinearLayout)findViewById(R.id.secgaadmi);
         linegaadm=(View)findViewById(R.id.linegaadm);
         Vlblgaadm=(TextView) findViewById(R.id.Vlblgaadm);
         txtgaadmi=(EditText) findViewById(R.id.txtgaadmi);
         secgameth=(LinearLayout)findViewById(R.id.secgameth);
         linegameth=(View)findViewById(R.id.linegameth);
         Vlblgameth = (TextView) findViewById(R.id.Vlblgameth);
         rdogrpgameth = (RadioGroup) findViewById(R.id.rdogrpgameth);

         rdogameth1 = (RadioButton) findViewById(R.id.rdogameth1);
         rdogameth2 = (RadioButton) findViewById(R.id.rdogameth2);
         rdogameth3 = (RadioButton) findViewById(R.id.rdogameth3);
         rdogameth4 = (RadioButton) findViewById(R.id.rdogameth4);
         rdogameth5 = (RadioButton) findViewById(R.id.rdogameth5);

         secbb4expect=(LinearLayout)findViewById(R.id.secbb4expect);
         linebb4expect=(View)findViewById(R.id.linebb4expect);
         Vlblbb4expect = (TextView) findViewById(R.id.Vlblbb4expect);
         rdogrpbb4expect = (RadioGroup) findViewById(R.id.rdogrpbb4expect);

         rdobb4expect1 = (RadioButton) findViewById(R.id.rdobb4expect1);
         rdobb4expect2 = (RadioButton) findViewById(R.id.rdobb4expect2);
         rdobb4expect3 = (RadioButton) findViewById(R.id.rdobb4expect3);
         secnumbby=(LinearLayout)findViewById(R.id.secnumbby);
         linenumbby=(View)findViewById(R.id.linenumbby);
         Vlblnumbby = (TextView) findViewById(R.id.Vlblnumbby);
         rdogrpnumbby = (RadioGroup) findViewById(R.id.rdogrpnumbby);

         rdonumbby1 = (RadioButton) findViewById(R.id.rdonumbby1);
         rdonumbby2 = (RadioButton) findViewById(R.id.rdonumbby2);
         rdonumbby3 = (RadioButton) findViewById(R.id.rdonumbby3);
         rdonumbby4 = (RadioButton) findViewById(R.id.rdonumbby4);

         rdogrpnumbby.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
             @Override
             public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
                 String rbData = "";
                 RadioButton rb;
                 String[] d_rdogrpnumbby = new String[] {"1","2","3","7"};
                 for (int i = 0; i < rdogrpnumbby.getChildCount(); i++)
                 {
                     rb = (RadioButton)rdogrpnumbby.getChildAt(i);
                     if (rb.isChecked()) rbData = d_rdogrpnumbby[i];
                 }

                 if(rbData.equalsIgnoreCase("1"))
                 {
                     secnumPreg.setVisibility(View.GONE);
                     linenumPreg.setVisibility(View.GONE);
                     txtnumPreg.setText("");
                 }
                 else if(rbData.equalsIgnoreCase("2"))
                 {
                     secnumPreg.setVisibility(View.GONE);
                     linenumPreg.setVisibility(View.GONE);
                     txtnumPreg.setText("");
                 }
                 else if(rbData.equalsIgnoreCase("7"))
                 {
                     secnumPreg.setVisibility(View.GONE);
                     linenumPreg.setVisibility(View.GONE);
                     txtnumPreg.setText("");
                 }
                 else
                 {
                     secnumPreg.setVisibility(View.VISIBLE);
                     linenumPreg.setVisibility(View.VISIBLE);
                 }
             }
             public void onNothingSelected(AdapterView<?> adapterView) {
                 return;
             }
         });
         secnumPreg=(LinearLayout)findViewById(R.id.secnumPreg);
         linenumPreg=(View)findViewById(R.id.linenumPreg);
         VlblnumPreg=(TextView) findViewById(R.id.VlblnumPreg);
         txtnumPreg=(EditText) findViewById(R.id.txtnumPreg);
         secbheartadm=(LinearLayout)findViewById(R.id.secbheartadm);
         linebheartadm=(View)findViewById(R.id.linebheartadm);
         Vlblbheartadm = (TextView) findViewById(R.id.Vlblbheartadm);
         rdogrpbheartadm = (RadioGroup) findViewById(R.id.rdogrpbheartadm);

         rdobheartadm1 = (RadioButton) findViewById(R.id.rdobheartadm1);
         rdobheartadm2 = (RadioButton) findViewById(R.id.rdobheartadm2);
         rdobheartadm3 = (RadioButton) findViewById(R.id.rdobheartadm3);
         rdogrpbheartadm.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
             @Override
             public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
                 String rbData = "";
                 RadioButton rb;
                 String[] d_rdogrpbheartadm = new String[] {"1","2","7"};
                 for (int i = 0; i < rdogrpbheartadm.getChildCount(); i++)
                 {
                     rb = (RadioButton)rdogrpbheartadm.getChildAt(i);
                     if (rb.isChecked()) rbData = d_rdogrpbheartadm[i];
                 }

                 if(rbData.equalsIgnoreCase("2"))
                 {
                     secbheartrateadm.setVisibility(View.GONE);
                     linebheartrateadm.setVisibility(View.GONE);
                     rdogrpbheartrateadm.clearCheck();
                     secbheartratenum.setVisibility(View.GONE);
                     //linebheartratenum.setVisibility(View.GONE);
                     txtbheartratenum.setText("");
                 }
                 else if(rbData.equalsIgnoreCase("7"))
                 {
                     secbheartrateadm.setVisibility(View.GONE);
                     linebheartrateadm.setVisibility(View.GONE);
                     rdogrpbheartrateadm.clearCheck();
                     secbheartratenum.setVisibility(View.GONE);
                     //linebheartratenum.setVisibility(View.GONE);
                     txtbheartratenum.setText("");
                 }
                 else
                 {
                     secbheartrateadm.setVisibility(View.VISIBLE);
                     //linebheartrateadm.setVisibility(View.VISIBLE);
                 }
             }
             public void onNothingSelected(AdapterView<?> adapterView) {
                 return;
             }
         });
         secbheartrateadm=(LinearLayout)findViewById(R.id.secbheartrateadm);
         linebheartrateadm=(View)findViewById(R.id.linebheartrateadm);
         Vlblbheartrateadm = (TextView) findViewById(R.id.Vlblbheartrateadm);
         rdogrpbheartrateadm = (RadioGroup) findViewById(R.id.rdogrpbheartrateadm);

         rdobheartrateadm1 = (RadioButton) findViewById(R.id.rdobheartrateadm1);
         rdobheartrateadm2 = (RadioButton) findViewById(R.id.rdobheartrateadm2);
         rdobheartrateadm3 = (RadioButton) findViewById(R.id.rdobheartrateadm3);
         rdobheartrateadm4 = (RadioButton) findViewById(R.id.rdobheartrateadm4);
         rdogrpbheartrateadm.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
             @Override
             public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
                 String rbData = "";
                 RadioButton rb;
                 String[] d_rdogrpbheartrateadm = new String[] {"7","1","2","3"};
                 for (int i = 0; i < rdogrpbheartrateadm.getChildCount(); i++)
                 {
                     rb = (RadioButton)rdogrpbheartrateadm.getChildAt(i);
                     if (rb.isChecked()) rbData = d_rdogrpbheartrateadm[i];
                 }

                 if(rbData.equalsIgnoreCase("3")){
                     secbheartratenum.setVisibility(View.VISIBLE);
                     linebheartratenum.setVisibility(View.VISIBLE);
                 }else{
                     secbheartratenum.setVisibility(View.GONE);
                     txtbheartratenum.setText("");
                 }

                 /*if(rbData.equalsIgnoreCase("1"))
                 {
                     secbheartratenum.setVisibility(View.GONE);
                     //linebheartratenum.setVisibility(View.GONE);
                     txtbheartratenum.setText("");
                     //secanybcompadm.setVisibility(View.GONE);
                     //lineanybcompadm.setVisibility(View.GONE);
                     //rdogrpanybcompadm.clearCheck();
                 }
                 else if(rbData.equalsIgnoreCase("2"))
                 {
                     secbheartratenum.setVisibility(View.GONE);
                     //linebheartratenum.setVisibility(View.GONE);
                     txtbheartratenum.setText("");
                     //secanybcompadm.setVisibility(View.GONE);
                     //lineanybcompadm.setVisibility(View.GONE);
                     //rdogrpanybcompadm.clearCheck();
                 }
                 else if(rbData.equalsIgnoreCase("7"))
                 {
                     secbheartratenum.setVisibility(View.GONE);
                     //linebheartratenum.setVisibility(View.GONE);
                     txtbheartratenum.setText("");
                     //secanybcompadm.setVisibility(View.GONE);
                     //lineanybcompadm.setVisibility(View.GONE);
                     //rdogrpanybcompadm.clearCheck();
                 }
                 else
                 {
                     secbheartratenum.setVisibility(View.VISIBLE);
                     linebheartratenum.setVisibility(View.VISIBLE);
                     //secanybcompadm.setVisibility(View.VISIBLE);
                     //lineanybcompadm.setVisibility(View.VISIBLE);
                 }*/
             }
             public void onNothingSelected(AdapterView<?> adapterView) {
                 return;
             }
         });
         secbheartratenum=(LinearLayout)findViewById(R.id.secbheartratenum);
         linebheartratenum=(View)findViewById(R.id.linebheartratenum);
         Vlblbheartratenum=(TextView) findViewById(R.id.Vlblbheartratenum);
         txtbheartratenum=(EditText) findViewById(R.id.txtbheartratenum);
         secanybcompadm=(LinearLayout)findViewById(R.id.secanybcompadm);
         lineanybcompadm=(View)findViewById(R.id.lineanybcompadm);
         Vlblanybcompadm = (TextView) findViewById(R.id.Vlblanybcompadm);

         secallocobsv=(LinearLayout)findViewById(R.id.secallocobsv);

         Vlblallocobsv = (TextView) findViewById(R.id.Vlblallocobsv);
         rdogrpallocobsv = (RadioGroup) findViewById(R.id.rdogrpallocobsv);

         rdoallocobsv1 = (RadioButton) findViewById(R.id.rdoallocobsv1);
         rdoallocobsv2 = (RadioButton) findViewById(R.id.rdoallocobsv2);


         dtpedd.setOnTouchListener(new View.OnTouchListener() {
             @Override
             public boolean onTouch(View v, MotionEvent event) {
                 final int DRAWABLE_RIGHT  = 2;
                 if(event.getAction() == MotionEvent.ACTION_UP) {
                     if(event.getRawX() >= (dtpedd.getRight() - dtpedd.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                         VariableID = "btnedd"; showDialog(DATE_DIALOG);
                         return true;
                     }
                 }
                 return false;
             }
         });


         chkeddDK.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
         {
             @Override
             public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
             {
                 if ( isChecked )
                 {
                    dtpedd.setText("");
                 }

             }
         });

         //Hide all skip variables
         secnumPreg.setVisibility(View.GONE);
         linenumPreg.setVisibility(View.GONE);
         secnumPreg.setVisibility(View.GONE);
         linenumPreg.setVisibility(View.GONE);
         secbheartrateadm.setVisibility(View.GONE);
         linebheartrateadm.setVisibility(View.GONE);
         secbheartratenum.setVisibility(View.GONE);
         //linebheartratenum.setVisibility(View.GONE);
         secbheartrateadm.setVisibility(View.GONE);
         linebheartrateadm.setVisibility(View.GONE);
         secbheartratenum.setVisibility(View.GONE);
         //linebheartratenum.setVisibility(View.GONE);
         secbheartratenum.setVisibility(View.GONE);
         //linebheartratenum.setVisibility(View.GONE);
         //secanybcompadm.setVisibility(View.GONE);
         //lineanybcompadm.setVisibility(View.GONE);
         //secbheartratenum.setVisibility(View.GONE);
         //linebheartratenum.setVisibility(View.GONE);
         //secanybcompadm.setVisibility(View.GONE);
         //lineanybcompadm.setVisibility(View.GONE);
         //secbheartratenum.setVisibility(View.GONE);
         //linebheartratenum.setVisibility(View.GONE);
         //secanybcompadm.setVisibility(View.GONE);
         //lineanybcompadm.setVisibility(View.GONE);
     }


    private void InfectionPreObs_Initialize()
    {
        secInfDelPlace=(LinearLayout)findViewById(R.id.secInfDelPlace);
        lineInfDelPlace=(View)findViewById(R.id.lineInfDelPlace);
        VlblInfDelPlace=(TextView) findViewById(R.id.VlblInfDelPlace);
        spnInfDelPlace=(Spinner) findViewById(R.id.spnInfDelPlace);
        List<String> listInfDelPlace = new ArrayList<String>();

        listInfDelPlace.add("");
        if(COUNTRYCODE.equals(ProjectSetting.NEPAL)) {
            listInfDelPlace.add("2-Labour Room");
            listInfDelPlace.add("7-Other");
            listInfDelPlace.add("9-Don’t know");
            //listplacedeliv.add("4-MNSC");
        }
        else {
            listInfDelPlace.add("1-Admission Room");
            listInfDelPlace.add("2-Labour Room");
            listInfDelPlace.add("3-Operation theatre");
            listInfDelPlace.add("7-Other");
            listInfDelPlace.add("9-Don’t know");
        }

        /*listInfDelPlace.add("1-Admission room");
        listInfDelPlace.add("2-Labour room");
        listInfDelPlace.add("3-Operation theatre");
        listInfDelPlace.add("7-Other");
        listInfDelPlace.add("9-Don’t know");*/
        ArrayAdapter<String> adptrInfDelPlace= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listInfDelPlace);
        spnInfDelPlace.setAdapter(adptrInfDelPlace);


        secInfDelPlaceoth=(LinearLayout)findViewById(R.id.secInfDelPlaceoth);
        VlblInfDelPlaceoth=(TextView) findViewById(R.id.VlblInfDelPlaceoth);
        txtInfDelPlaceoth=(EditText) findViewById(R.id.txtInfDelPlaceoth);
        secInfDelMod=(LinearLayout)findViewById(R.id.secInfDelMod);
        VlblInfDelMod=(TextView) findViewById(R.id.VlblInfDelMod);
        spnInfDelMod=(Spinner) findViewById(R.id.spnInfDelMod);
        List<String> listInfDelMod = new ArrayList<String>();

        listInfDelMod.add("");
        listInfDelMod.add("1-Normal vaginal delivery");
        listInfDelMod.add("2-Vaginal breech");
        listInfDelMod.add("3-Vacuum extraction");
        listInfDelMod.add("4-Forcep (Any)");
        listInfDelMod.add("5-Elective caesarean section");
        listInfDelMod.add("6-Emergency caesarean section");
        listInfDelMod.add("7-C/S not specified");
        listInfDelMod.add("9-Don’t know");
        ArrayAdapter<String> adptrInfDelMod= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listInfDelMod);
        spnInfDelMod.setAdapter(adptrInfDelMod);

        chkInfMCompa=(CheckBox) findViewById(R.id.chkInfMCompa);
        chkInfMCompb=(CheckBox) findViewById(R.id.chkInfMCompb);
        chkInfMCompc=(CheckBox) findViewById(R.id.chkInfMCompc);
        chkInfMCompd=(CheckBox) findViewById(R.id.chkInfMCompd);
        chkInfMCompe=(CheckBox) findViewById(R.id.chkInfMCompe);
        chkInfMCompf=(CheckBox) findViewById(R.id.chkInfMCompf);
        chkInfMCompg=(CheckBox) findViewById(R.id.chkInfMCompg);

        secInfMComp=(LinearLayout)findViewById(R.id.secInfMComp);

        secInfGAge=(LinearLayout)findViewById(R.id.secInfGAge);
        lineInfGAge=(View)findViewById(R.id.lineInfGAge);
        VlblInfGAge=(TextView) findViewById(R.id.VlblInfGAge);
        txtInfGAge=(EditText) findViewById(R.id.txtInfGAge);
        chkInfGAgeDK=(CheckBox) findViewById(R.id.chkInfGAgeDK);
        secInfBWeight=(LinearLayout)findViewById(R.id.secInfBWeight);
        VlblInfBWeight=(TextView) findViewById(R.id.VlblInfBWeight);
        txtInfBWeight=(EditText) findViewById(R.id.txtInfBWeight);
        chkInfBWeightDK=(CheckBox) findViewById(R.id.chkInfBWeightDK);

        spnInfDelPlace.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String spnData = "";
                if (spnInfDelPlace.getSelectedItem().toString().length() != 0)
                {
                    spnData = Connection.SelectedSpinnerValue(spnInfDelPlace.getSelectedItem().toString(), "-");
                }

                if(spnData.equalsIgnoreCase("7"))
                {
                    secInfDelPlaceoth.setVisibility(View.VISIBLE);
                    //lineInfDelPlaceoth.setVisibility(View.VISIBLE);
                }else{
                    secInfDelPlaceoth.setVisibility(View.GONE);
                    //lineInfDelPlaceoth.setVisibility(View.GONE);
                    txtInfDelPlaceoth.setText("");
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }
        });

        chkInfGAgeDK.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if ( isChecked )
                {
                    txtInfGAge.setText("");
                }
            }
        });
        txtInfGAge.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {}
            public void beforeTextChanged(CharSequence s, int start,int count, int after) {}
            public void onTextChanged(CharSequence s, int start,int before, int count) {
                if(txtInfGAge.getText().toString().length()>0) chkInfGAgeDK.setChecked(false);
            }
        });

        chkInfBWeightDK.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if ( isChecked )
                {
                    txtInfBWeight.setText("");
                }
            }
        });
        txtInfBWeight.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {}
            public void beforeTextChanged(CharSequence s, int start,int count, int after) {}
            public void onTextChanged(CharSequence s, int start,int before, int count) {
                if(txtInfBWeight.getText().toString().length()>0) chkInfBWeightDK.setChecked(false);
            }
        });

        //Hide all skip variables
        secInfDelPlaceoth.setVisibility(View.GONE);
    }


     public String DataSaveObsHis()
     {
         try
         {
             String SQL = "";
             RadioButton rb;

             ObsHisCurPreg_DataModel objSave = new ObsHisCurPreg_DataModel();
             objSave.setCountryCode(txtCountryCode.getText().toString());
             objSave.setFaciCode(txtFaciCode.getText().toString());
             objSave.setDataID(txtDataID.getText().toString());
             String[] d_rdogrpcard = new String[] {"1","2","7"};
             objSave.setcard("");
             for (int i = 0; i < rdogrpcard.getChildCount(); i++)
             {
                 rb = (RadioButton)rdogrpcard.getChildAt(i);
                 if (rb.isChecked()) objSave.setcard(d_rdogrpcard[i]);
             }

             objSave.setprevpreg(txtprevpreg.getText().toString());
             objSave.setprevpregdk(chkprevpregDK.isChecked()?"1":(secprevpreg.isShown()?"2":""));

             objSave.setprevliveb(txtprevliveb.getText().toString());
             objSave.setprevlivebdk(chkprevlivebDK.isChecked()?"1":(secprevliveb.isShown()?"2":""));

             objSave.setprevstillb(txtprevstillb.getText().toString());
             objSave.setprevstillbdk(chkprevstillbDK.isChecked()?"1":(secprevstillb.isShown()?"2":""));

             objSave.setprevab(txtprevab.getText().toString());
             objSave.setprevabdk(chkprevabDK.isChecked()?"1":(secprevab.isShown()?"2":""));

             objSave.setprevcsec(txtprevcsec.getText().toString());
             objSave.setprevcsecdk(chkprevcsecDK.isChecked()?"1":(secprevcsec.isShown()?"2":""));

             objSave.setyrslstbth(txtyrslstbth.getText().toString());
             objSave.setyrslstbthdk(chkyrslstbthDK.isChecked()?"1":(secyrslstbth.isShown()?"2":""));

             objSave.setedd(dtpedd.getText().toString().length() > 0 ? Global.DateConvertYMD(dtpedd.getText().toString()) : dtpedd.getText().toString());
             objSave.seteddDK((chkeddDK.isChecked()?"1":(seceddDK.isShown()?"2":"")));
             objSave.setgaadm(txtgaadmi.getText().toString());
             objSave.setgaadmDK(chkgaadmiDK.isChecked()?"1":(secgaadmi.isShown()?"2":""));
             String[] d_rdogrpgameth = new String[] {"1","2","3","4","7"};
             objSave.setgameth("");
             for (int i = 0; i < rdogrpgameth.getChildCount(); i++)
             {
                 rb = (RadioButton)rdogrpgameth.getChildAt(i);
                 if (rb.isChecked()) objSave.setgameth(d_rdogrpgameth[i]);
             }

             String[] d_rdogrpbb4expect = new String[] {"1","2","7"};
             objSave.setbb4expect("");
             for (int i = 0; i < rdogrpbb4expect.getChildCount(); i++)
             {
                 rb = (RadioButton)rdogrpbb4expect.getChildAt(i);
                 if (rb.isChecked()) objSave.setbb4expect(d_rdogrpbb4expect[i]);
             }

             String[] d_rdogrpnumbby = new String[] {"1","2","3","7"};
             objSave.setnumbby("");
             for (int i = 0; i < rdogrpnumbby.getChildCount(); i++)
             {
                 rb = (RadioButton)rdogrpnumbby.getChildAt(i);
                 if (rb.isChecked()) objSave.setnumbby(d_rdogrpnumbby[i]);
             }

             objSave.setnumPreg(txtnumPreg.getText().toString());
             String[] d_rdogrpbheartadm = new String[] {"1","2","7"};
             objSave.setbheartadm("");
             for (int i = 0; i < rdogrpbheartadm.getChildCount(); i++)
             {
                 rb = (RadioButton)rdogrpbheartadm.getChildAt(i);
                 if (rb.isChecked()) objSave.setbheartadm(d_rdogrpbheartadm[i]);
             }

             String[] d_rdogrpbheartrateadm = new String[] {"7","1","2","3"};
             objSave.setbheartrateadm("");
             for (int i = 0; i < rdogrpbheartrateadm.getChildCount(); i++)
             {
                 rb = (RadioButton)rdogrpbheartrateadm.getChildAt(i);
                 if (rb.isChecked()) objSave.setbheartrateadm(d_rdogrpbheartrateadm[i]);
             }

             objSave.setbheartratenum(txtbheartratenum.getText().toString());
             /*String[] d_rdogrpanybcompadm = new String[] {"0","1","2","3","4","5","6","7"};
             objSave.setanybcompadm("");
             for (int i = 0; i < rdogrpanybcompadm.getChildCount(); i++)
             {
                 rb = (RadioButton)rdogrpanybcompadm.getChildAt(i);
                 if (rb.isChecked()) objSave.setanybcompadm(d_rdogrpanybcompadm[i]);
             }*/
             objSave.setanybcompadma(chkanybcompadma.isChecked()?"1":(secanybcompadm.isShown()?"2":""));
             objSave.setanybcompadmb(chkanybcompadmb.isChecked()?"1":(secanybcompadm.isShown()?"2":""));
             objSave.setanybcompadmc(chkanybcompadmc.isChecked()?"1":(secanybcompadm.isShown()?"2":""));
             objSave.setanybcompadmd(chkanybcompadmd.isChecked()?"1":(secanybcompadm.isShown()?"2":""));
             objSave.setanybcompadme(chkanybcompadme.isChecked()?"1":(secanybcompadm.isShown()?"2":""));
             objSave.setanybcompadmf(chkanybcompadmf.isChecked()?"1":(secanybcompadm.isShown()?"2":""));
             objSave.setanybcompadmg(chkanybcompadmg.isChecked()?"1":(secanybcompadm.isShown()?"2":""));
             objSave.setanybcompadmh(chkanybcompadmh.isChecked()?"1":(secanybcompadm.isShown()?"2":""));
             objSave.setanybcompadmoth(txtanybcompadmoth.getText().toString());

             String[] d_rdogrpallocobsv = new String[] {"1","2"};
             objSave.setallocobsv("");
             for (int i = 0; i < rdogrpallocobsv.getChildCount(); i++)
             {
                 rb = (RadioButton)rdogrpallocobsv.getChildAt(i);
                 if (rb.isChecked()) objSave.setallocobsv(d_rdogrpallocobsv[i]);
             }

             objSave.setEnDt(Global.DateTimeNowYMDHMS());
             objSave.setStartTime(STARTTIME);
             objSave.setEndTime(g.CurrentTime24());
             objSave.setDeviceID(DEVICEID);
             objSave.setEntryUser(ENTRYUSER); //from data entry user list
             objSave.setmodifyDate(Global.DateTimeNowYMDHMS());
             //objSave.setLat(Double.toString(currentLatitude));
             //objSave.setLon(Double.toString(currentLongitude));

             String status = objSave.SaveUpdateData(this);
             return status;
         }
         catch(Exception  e)
         {
             return e.getMessage();
         }
     }

     public void DataSearchObsHis(String CountryCode, String FaciCode, String DataID)
     {
         try
         {

             RadioButton rb;
             ObsHisCurPreg_DataModel d = new ObsHisCurPreg_DataModel();
             String SQL = "Select * from ObsHisCurPreg Where CountryCode='"+ CountryCode +"' and FaciCode='"+ FaciCode +"' and DataID='"+ DataID +"'";
             List<ObsHisCurPreg_DataModel> data = d.SelectAll(this, SQL);
             for(ObsHisCurPreg_DataModel item : data){
                 txtCountryCode.setText(item.getCountryCode());
                 txtFaciCode.setText(item.getFaciCode());
                 txtDataID.setText(item.getDataID());
                 String[] d_rdogrpcard = new String[] {"1","2","7"};
                 for (int i = 0; i < d_rdogrpcard.length; i++)
                 {
                     if (item.getcard().equals(String.valueOf(d_rdogrpcard[i])))
                     {
                         rb = (RadioButton)rdogrpcard.getChildAt(i);
                         rb.setChecked(true);
                     }
                 }

                 txtprevpreg.setText(item.getprevpreg());
                 if(item.getprevpregdk().equals("1")) chkprevpregDK.setChecked(true); else
                     chkprevpregDK.setChecked(false);

                 txtprevliveb.setText(item.getprevliveb());
                 if(item.getprevlivebdk().equals("1")) chkprevlivebDK.setChecked(true); else
                     chkprevlivebDK.setChecked(false);

                 txtprevstillb.setText(item.getprevstillb());
                 if(item.getprevstillbdk().equals("1")) chkprevstillbDK.setChecked(true); else
                     chkprevstillbDK.setChecked(false);

                 txtprevab.setText(item.getprevab());
                 if(item.getprevabdk().equals("1")) chkprevabDK.setChecked(true); else
                     chkprevabDK.setChecked(false);

                 txtprevcsec.setText(item.getprevcsec());
                 if(item.getprevcsecdk().equals("1")) chkprevcsecDK.setChecked(true); else
                     chkprevcsecDK.setChecked(false);

                 txtyrslstbth.setText(item.getyrslstbth());
                 if(item.getyrslstbthdk().equals("1")) chkyrslstbthDK.setChecked(true); else
                     chkyrslstbthDK.setChecked(false);

                 dtpedd.setText(item.getedd().toString().length()==0 ? "" : Global.DateConvertDMY(item.getedd()));
                 if(item.geteddDK().equals("1"))
                 {
                     chkeddDK.setChecked(true);
                 }
                 else if(item.geteddDK().equals("2"))
                 {
                     chkeddDK.setChecked(false);
                 }
                 txtgaadmi.setText(item.getgaadm());
                 if(item.getgaadmDK().equals("1")) chkgaadmiDK.setChecked(true); else chkgaadmiDK.setChecked(false);
                 String[] d_rdogrpgameth = new String[] {"1","2","3","4","7"};
                 for (int i = 0; i < d_rdogrpgameth.length; i++)
                 {
                     if (item.getgameth().equals(String.valueOf(d_rdogrpgameth[i])))
                     {
                         rb = (RadioButton)rdogrpgameth.getChildAt(i);
                         rb.setChecked(true);
                     }
                 }
                 String[] d_rdogrpbb4expect = new String[] {"1","2","7"};
                 for (int i = 0; i < d_rdogrpbb4expect.length; i++)
                 {
                     if (item.getbb4expect().equals(String.valueOf(d_rdogrpbb4expect[i])))
                     {
                         rb = (RadioButton)rdogrpbb4expect.getChildAt(i);
                         rb.setChecked(true);
                     }
                 }
                 String[] d_rdogrpnumbby = new String[] {"1","2","3","7"};
                 for (int i = 0; i < d_rdogrpnumbby.length; i++)
                 {
                     if (item.getnumbby().equals(String.valueOf(d_rdogrpnumbby[i])))
                     {
                         rb = (RadioButton)rdogrpnumbby.getChildAt(i);
                         rb.setChecked(true);
                     }
                 }
                 txtnumPreg.setText(item.getnumPreg());
                 String[] d_rdogrpbheartadm = new String[] {"1","2","7"};
                 for (int i = 0; i < d_rdogrpbheartadm.length; i++)
                 {
                     if (item.getbheartadm().equals(String.valueOf(d_rdogrpbheartadm[i])))
                     {
                         rb = (RadioButton)rdogrpbheartadm.getChildAt(i);
                         rb.setChecked(true);
                     }
                 }
                 String[] d_rdogrpbheartrateadm = new String[] {"7","1","2","3"};
                 for (int i = 0; i < d_rdogrpbheartrateadm.length; i++)
                 {
                     if (item.getbheartrateadm().equals(String.valueOf(d_rdogrpbheartrateadm[i])))
                     {
                         rb = (RadioButton)rdogrpbheartrateadm.getChildAt(i);
                         rb.setChecked(true);
                     }
                 }
                 txtbheartratenum.setText(item.getbheartratenum());
                 /*String[] d_rdogrpanybcompadm = new String[] {"0","1","2","3","4","5","6","7"};
                 for (int i = 0; i < d_rdogrpanybcompadm.length; i++)
                 {
                     if (item.getanybcompadm().equals(String.valueOf(d_rdogrpanybcompadm[i])))
                     {
                         rb = (RadioButton)rdogrpanybcompadm.getChildAt(i);
                         rb.setChecked(true);
                     }
                 }*/

                 if(item.getanybcompadma().equals("1")) chkanybcompadma.setChecked(true); else chkanybcompadma.setChecked(false);
                 if(item.getanybcompadmb().equals("1")) chkanybcompadmb.setChecked(true); else chkanybcompadmb.setChecked(false);
                 if(item.getanybcompadmc().equals("1")) chkanybcompadmc.setChecked(true); else chkanybcompadmc.setChecked(false);
                 if(item.getanybcompadmd().equals("1")) chkanybcompadmd.setChecked(true); else chkanybcompadmd.setChecked(false);
                 if(item.getanybcompadme().equals("1")) chkanybcompadme.setChecked(true); else chkanybcompadme.setChecked(false);
                 if(item.getanybcompadmf().equals("1")) chkanybcompadmf.setChecked(true); else chkanybcompadmf.setChecked(false);
                 if(item.getanybcompadmg().equals("1")) chkanybcompadmg.setChecked(true); else chkanybcompadmg.setChecked(false);
                 if(item.getanybcompadmh().equals("1")) chkanybcompadmh.setChecked(true); else chkanybcompadmh.setChecked(false);
                 txtanybcompadmoth.setText(item.getanybcompadmoth());

                 String[] d_rdogrpallocobsv = new String[] {"1","2"};
                 for (int i = 0; i < d_rdogrpallocobsv.length; i++)
                 {
                     if (item.getallocobsv().equals(String.valueOf(d_rdogrpallocobsv[i])))
                     {
                         rb = (RadioButton)rdogrpallocobsv.getChildAt(i);
                         rb.setChecked(true);
                     }
                 }
             }
         }
         catch(Exception  e)
         {
             Connection.MessageBox(Registration.this, e.getMessage());
             return;
         }
     }




     //KMC Pre Observe
     private void KMCPreObs_Initialize()
     {
         secadwghedkmc=(LinearLayout)findViewById(R.id.secadwghedkmc);
         lineadwghedkmc=(View)findViewById(R.id.lineadwghedkmc);
         Vlbladwghedkmc = (TextView) findViewById(R.id.Vlbladwghedkmc);
         rdogrpadwghedkmc = (RadioGroup) findViewById(R.id.rdogrpadwghedkmc);

         rdoadwghedkmc1 = (RadioButton) findViewById(R.id.rdoadwghedkmc1);
         rdoadwghedkmc2 = (RadioButton) findViewById(R.id.rdoadwghedkmc2);
         rdoadwghedkmc3 = (RadioButton) findViewById(R.id.rdoadwghedkmc3);
         rdogrpadwghedkmc.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
             @Override
             public void onCheckedChanged(RadioGroup radioGroup,int radioButtonID) {
                 String rbData = "";
                 RadioButton rb;
                 String[] d_rdogrpadwghedkmc = new String[] {"1","2","7"};
                 for (int i = 0; i < rdogrpadwghedkmc.getChildCount(); i++)
                 {
                     rb = (RadioButton)rdogrpadwghedkmc.getChildAt(i);
                     if (rb.isChecked()) rbData = d_rdogrpadwghedkmc[i];
                 }

                 if(rbData.equalsIgnoreCase("2")|rbData.equalsIgnoreCase("7"))
                 {
                     secadwghtkmc.setVisibility(View.GONE);
                     lineadwghtkmc.setVisibility(View.GONE);
                     txtadwghtkmc.setText("");
                     chkadwghtkmcDK.setChecked(false);
                 }
                 else
                 {
                     secadwghtkmc.setVisibility(View.VISIBLE);
                     lineadwghtkmc.setVisibility(View.VISIBLE);
                 }
             }
             public void onNothingSelected(AdapterView<?> adapterView) {
                 return;
             }
         });
         secadwghtkmc=(LinearLayout)findViewById(R.id.secadwghtkmc);
         lineadwghtkmc=(View)findViewById(R.id.lineadwghtkmc);
         Vlbladwghtkmc=(TextView) findViewById(R.id.Vlbladwghtkmc);
         txtadwghtkmc=(EditText) findViewById(R.id.txtadwghtkmc);
         secgaadm=(LinearLayout)findViewById(R.id.secgaadm);
         linegaadm=(View)findViewById(R.id.linegaadm);
         Vlblgaadm=(TextView) findViewById(R.id.Vlblgaadm);
         txtgaadm=(EditText) findViewById(R.id.txtgaadm);
         secplacedeliv=(LinearLayout)findViewById(R.id.secplacedeliv);
         lineplacedeliv=(View)findViewById(R.id.lineplacedeliv);
         Vlblplacedeliv=(TextView) findViewById(R.id.Vlblplacedeliv);
         spnplacedeliv=(Spinner) findViewById(R.id.spnplacedeliv);
         List<String> listplacedeliv = new ArrayList<String>();

         listplacedeliv.add("");
         if(COUNTRYCODE.equals(ProjectSetting.NEPAL)) {
             listplacedeliv.add("2-Labour Room");
             listplacedeliv.add("7-Other");
             //listplacedeliv.add("4-MNSC");
         }
         else {
             listplacedeliv.add("1-Admission Room");
             listplacedeliv.add("2-Labour Room");
             listplacedeliv.add("3-Operation theatre");
             listplacedeliv.add("7-Other");
         }



         ArrayAdapter<String> adptrplacedeliv= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listplacedeliv);
         spnplacedeliv.setAdapter(adptrplacedeliv);

         spnplacedeliv.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
             @Override
             public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                 if (spnplacedeliv.getSelectedItem().toString().length() == 0) return;
                 String spnData = Connection.SelectedSpinnerValue(spnplacedeliv.getSelectedItem().toString(),"-");
                 if(spnData.equalsIgnoreCase("1"))
                 {
                     secplacedelivoth.setVisibility(View.GONE);
                     lineplacedelivoth.setVisibility(View.GONE);
                     txtplacedelivoth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("2"))
                 {
                     secplacedelivoth.setVisibility(View.GONE);
                     lineplacedelivoth.setVisibility(View.GONE);
                     txtplacedelivoth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("3"))
                 {
                     secplacedelivoth.setVisibility(View.GONE);
                     lineplacedelivoth.setVisibility(View.GONE);
                     txtplacedelivoth.setText("");
                 }
                 else if(spnData.equalsIgnoreCase("4"))
                 {
                     secplacedelivoth.setVisibility(View.GONE);
                     lineplacedelivoth.setVisibility(View.GONE);
                     txtplacedelivoth.setText("");
                 }
                 else
                 {
                     secplacedelivoth.setVisibility(View.VISIBLE);
                     lineplacedelivoth.setVisibility(View.VISIBLE);
                 }
             }
             @Override
             public void onNothingSelected(AdapterView<?> parentView) {
             }
         });
         secplacedelivoth=(LinearLayout)findViewById(R.id.secplacedelivoth);
         lineplacedelivoth=(View)findViewById(R.id.lineplacedelivoth);
         Vlblplacedelivoth=(TextView) findViewById(R.id.Vlblplacedelivoth);
         txtplacedelivoth=(EditText) findViewById(R.id.txtplacedelivoth);
         secfacnamedeliv=(LinearLayout)findViewById(R.id.secfacnamedeliv);
         linefacnamedeliv=(View)findViewById(R.id.linefacnamedeliv);
         Vlblfacnamedeliv=(TextView) findViewById(R.id.Vlblfacnamedeliv);
         txtfacnamedeliv=(EditText) findViewById(R.id.txtfacnamedeliv);

         //Hide all skip variables
         secadwghtkmc.setVisibility(View.GONE);
         lineadwghtkmc.setVisibility(View.GONE);
         secplacedelivoth.setVisibility(View.GONE);
         lineplacedelivoth.setVisibility(View.GONE);
         secplacedelivoth.setVisibility(View.GONE);
         lineplacedelivoth.setVisibility(View.GONE);
         secplacedelivoth.setVisibility(View.GONE);
         lineplacedelivoth.setVisibility(View.GONE);
     }


     private String KMCPreObs_DataSave()
     {
         try
         {
             String SQL = "";
             RadioButton rb;

             KmcPreObs_DataModel objSave = new KmcPreObs_DataModel();
             objSave.setCountryCode(txtCountryCode.getText().toString());
             objSave.setFaciCode(txtFaciCode.getText().toString());
             objSave.setDataID(txtDataID.getText().toString());
             String[] d_rdogrpadwghedkmc = new String[] {"1","2","7"};
             objSave.setadwghedkmc("");
             for (int i = 0; i < rdogrpadwghedkmc.getChildCount(); i++)
             {
                 rb = (RadioButton)rdogrpadwghedkmc.getChildAt(i);
                 if (rb.isChecked()) objSave.setadwghedkmc(d_rdogrpadwghedkmc[i]);
             }

             objSave.setadwghtkmc(txtadwghtkmc.getText().toString());
             objSave.setadwghtkmcdk(chkadwghtkmcDK.isChecked()?"1":(secadwghtkmc.isShown()?"2":""));

             objSave.setgaadm(txtgaadm.getText().toString());
             objSave.setgaadmdk(chkgaadmDK.isChecked()?"1":(secgaadm.isShown()?"2":""));

             objSave.setplacedeliv((spnplacedeliv.getSelectedItemPosition() == 0 ? "" : Connection.SelectedSpinnerValue(spnplacedeliv.getSelectedItem().toString(), "-")));
             objSave.setplacedelivoth(txtplacedelivoth.getText().toString());
             objSave.setfacnamedeliv(txtfacnamedeliv.getText().toString());
             objSave.setEnDt(Global.DateTimeNowYMDHMS());
             objSave.setStartTime(STARTTIME);
             objSave.setEndTime(g.CurrentTime24());
             objSave.setDeviceID(DEVICEID);
             objSave.setEntryUser(ENTRYUSER); //from data entry user list
             objSave.setmodifyDate(Global.DateTimeNowYMDHMS());
             //objSave.setLat(Double.toString(currentLatitude));
             //objSave.setLon(Double.toString(currentLongitude));

             String status = objSave.SaveUpdateData(this);

             return status;

         }
         catch(Exception  e)
         {
             return e.getMessage();
         }
     }

     private String InfectionPreObs_DataSave()
     {
         try {
             String SQL = "";
             RadioButton rb;
             InfPreObs_DataModel objSave = new InfPreObs_DataModel();
             objSave.setCountryCode(txtCountryCode.getText().toString());
             objSave.setFaciCode(txtFaciCode.getText().toString());
             objSave.setDataID(txtDataID.getText().toString());
             objSave.setInfDelPlace((spnInfDelPlace.getSelectedItemPosition() == 0 ? "" : Connection.SelectedSpinnerValue(spnInfDelPlace.getSelectedItem().toString(), "-")));
             objSave.setInfDelPlaceoth(txtInfDelPlaceoth.getText().toString());
             objSave.setInfDelMod((spnInfDelMod.getSelectedItemPosition() == 0 ? "" : Connection.SelectedSpinnerValue(spnInfDelMod.getSelectedItem().toString(), "-")));
             objSave.setInfMCompa((chkInfMCompa.isChecked() ? "1" : (secInfMComp.isShown() ? "2" : "")));
             objSave.setInfMCompb((chkInfMCompb.isChecked() ? "1" : (secInfMComp.isShown() ? "2" : "")));
             objSave.setInfMCompc((chkInfMCompc.isChecked() ? "1" : (secInfMComp.isShown() ? "2" : "")));
             objSave.setInfMCompd((chkInfMCompd.isChecked() ? "1" : (secInfMComp.isShown() ? "2" : "")));
             objSave.setInfMCompe((chkInfMCompe.isChecked() ? "1" : (secInfMComp.isShown() ? "2" : "")));
             objSave.setInfMCompf((chkInfMCompf.isChecked() ? "1" : (secInfMComp.isShown() ? "2" : "")));
             objSave.setInfMCompg((chkInfMCompg.isChecked() ? "1" : (secInfMComp.isShown() ? "2" : "")));
             objSave.setInfGAge(txtInfGAge.getText().toString());
             objSave.setInfGAgeDK((chkInfGAgeDK.isChecked() ? "1" : (secInfGAge.isShown() ? "2" : "")));
             objSave.setInfBWeight(txtInfBWeight.getText().toString());
             objSave.setInfBWeightDK((chkInfBWeightDK.isChecked() ? "1" : (secInfBWeight.isShown() ? "2" : "")));
             objSave.setEnDt(Global.DateTimeNowYMDHMS());
             objSave.setStartTime(STARTTIME);
             objSave.setEndTime(g.CurrentTime24());
             objSave.setDeviceID(DEVICEID);
             objSave.setEntryUser(ENTRYUSER); //from data entry user list
             objSave.setmodifyDate(Global.DateTimeNowYMDHMS());
             //objSave.setLat(Double.toString(currentLatitude));
             //objSave.setLon(Double.toString(currentLongitude));

             String status = objSave.SaveUpdateData(this);

             return status;
         }
         catch(Exception  e)
         {
             return e.getMessage();
         }
     }


     private void KMCPreObs_DataSearch(String CountryCode, String FaciCode, String DataID)
     {
         try
         {

             RadioButton rb;
             KmcPreObs_DataModel d = new KmcPreObs_DataModel();
             String SQL = "Select * from KMCPreObs  Where CountryCode='"+ CountryCode +"' and FaciCode='"+ FaciCode +"' and DataID='"+ DataID +"'";
             List<KmcPreObs_DataModel> data = d.SelectAll(this, SQL);
             for(KmcPreObs_DataModel item : data){
                 txtCountryCode.setText(item.getCountryCode());
                 txtFaciCode.setText(item.getFaciCode());
                 txtDataID.setText(item.getDataID());
                 String[] d_rdogrpadwghedkmc = new String[] {"1","2","7"};
                 for (int i = 0; i < d_rdogrpadwghedkmc.length; i++)
                 {
                     if (item.getadwghedkmc().equals(String.valueOf(d_rdogrpadwghedkmc[i])))
                     {
                         rb = (RadioButton)rdogrpadwghedkmc.getChildAt(i);
                         rb.setChecked(true);
                     }
                 }
                 txtadwghtkmc.setText(item.getadwghtkmc());
                 if(item.getadwghtkmcdk().equals("1")) chkadwghtkmcDK.setChecked(true); else chkadwghtkmcDK.setChecked(false);

                 txtgaadm.setText(item.getgaadm());
                 if(item.getgaadmdk().equals("1")) chkgaadmDK.setChecked(true); else chkgaadmDK.setChecked(false);

                 spnplacedeliv.setSelection(Global.SpinnerItemPositionAnyLength(spnplacedeliv, item.getplacedeliv()));
                 txtplacedelivoth.setText(item.getplacedelivoth());
                 txtfacnamedeliv.setText(item.getfacnamedeliv());
             }
         }
         catch(Exception  e)
         {
             Connection.MessageBox(Registration.this, e.getMessage());
             return;
         }
     }


     private void InfectionPreObs_DataSearch(String CountryCode, String FaciCode, String DataID)
     {
         try
         {
             RadioButton rb;
             InfPreObs_DataModel d = new InfPreObs_DataModel();
             String SQL = "Select * from InfPreObs Where CountryCode='"+ CountryCode +"' and FaciCode='"+ FaciCode +"' and DataID='"+ DataID +"'";
             List<InfPreObs_DataModel> data = d.SelectAll(this, SQL);
             for(InfPreObs_DataModel item : data){
                 txtCountryCode.setText(item.getCountryCode());
                 txtFaciCode.setText(item.getFaciCode());
                 txtDataID.setText(item.getDataID());
                 spnInfDelPlace.setSelection(Global.SpinnerItemPositionAnyLength(spnInfDelPlace, item.getInfDelPlace()));
                 txtInfDelPlaceoth.setText(item.getInfDelPlaceoth());
                 spnInfDelMod.setSelection(Global.SpinnerItemPositionAnyLength(spnInfDelMod, item.getInfDelMod()));
                 if(item.getInfMCompa().equals("1"))
                 {
                     chkInfMCompa.setChecked(true);
                 }
                 else if(item.getInfMCompa().equals("2"))
                 {
                     chkInfMCompa.setChecked(false);
                 }
                 if(item.getInfMCompb().equals("1"))
                 {
                     chkInfMCompb.setChecked(true);
                 }
                 else if(item.getInfMCompb().equals("2"))
                 {
                     chkInfMCompb.setChecked(false);
                 }
                 if(item.getInfMCompc().equals("1"))
                 {
                     chkInfMCompc.setChecked(true);
                 }
                 else if(item.getInfMCompc().equals("2"))
                 {
                     chkInfMCompc.setChecked(false);
                 }
                 if(item.getInfMCompd().equals("1"))
                 {
                     chkInfMCompd.setChecked(true);
                 }
                 else if(item.getInfMCompd().equals("2"))
                 {
                     chkInfMCompd.setChecked(false);
                 }
                 if(item.getInfMCompe().equals("1"))
                 {
                     chkInfMCompe.setChecked(true);
                 }
                 else if(item.getInfMCompe().equals("2"))
                 {
                     chkInfMCompe.setChecked(false);
                 }
                 if(item.getInfMCompf().equals("1"))
                 {
                     chkInfMCompf.setChecked(true);
                 }
                 else if(item.getInfMCompf().equals("2"))
                 {
                     chkInfMCompf.setChecked(false);
                 }
                 if(item.getInfMCompg().equals("1"))
                 {
                     chkInfMCompg.setChecked(true);
                 }
                 else if(item.getInfMCompg().equals("2"))
                 {
                     chkInfMCompg.setChecked(false);
                 }
                 txtInfGAge.setText(item.getInfGAge());
                 if(item.getInfGAgeDK().equals("1"))
                 {
                     chkInfGAgeDK.setChecked(true);
                 }
                 else if(item.getInfGAgeDK().equals("2"))
                 {
                     chkInfGAgeDK.setChecked(false);
                 }
                 txtInfBWeight.setText(item.getInfBWeight());
                 if(item.getInfBWeightDK().equals("1"))
                 {
                     chkInfBWeightDK.setChecked(true);
                 }
                 else if(item.getInfBWeightDK().equals("2"))
                 {
                     chkInfBWeightDK.setChecked(false);
                 }
             }
         }
         catch(Exception  e)
         {
             Connection.MessageBox(Registration.this, e.getMessage());
             return;
         }
     }


 }