package com.example.multipleactivity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import org.joda.time.Period;
import org.joda.time.PeriodType;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AgeCalculatorActivity extends AppCompatActivity {
    private CardView fromDateBtn, toDateBtn;
    private Button calculateBtn;
    private TextView birthTv, todayTv;
    private TextView yearTv, monthTv, dayTv;

    DatePickerDialog.OnDateSetListener dateSetListenerFromDate, dateSetListenerToDate;

    String birthDateLocal = "";
    String todayDateLocal = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age_calculator);

        getSupportActionBar().setTitle("Age calculator");

        fromDateBtn = findViewById(R.id.fromAgeBtn);
        toDateBtn = findViewById(R.id.toAgeBtn);
        calculateBtn = findViewById(R.id.calcuateBtn);
        birthTv = findViewById(R.id.birthTv);
        todayTv = findViewById(R.id.todayTv);
        yearTv = findViewById(R.id.yearTv);
        monthTv = findViewById(R.id.monthTv);
        dayTv = findViewById(R.id.dayTv);

        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String todayDate = simpleDateFormat.format(calendar.getTime());
        birthTv.setText(todayDate);
        todayTv.setText(todayDate);

        birthDateLocal = todayDate;
        todayDateLocal = todayDate;

        setupBirthDate(year, month, day);

        setupTodayDateCalendar(year, month, day);

        calculateAge();
    }

    private void setupBirthDate(int year, int month, int day) {
        fromDateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(AgeCalculatorActivity.this, dateSetListenerFromDate, year, month, day);
                datePickerDialog.show();
            }
        });

        dateSetListenerFromDate = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int selectedYear, int selectedMonth, int selectedDay) {
                selectedMonth = selectedMonth + 1;
                String birthDate = selectedDay + "/" + selectedMonth + "/" + selectedYear;
                birthTv.setText(birthDate);
                birthDateLocal = birthDate;
            }
        };
    }

    private void setupTodayDateCalendar(int year, int month, int day) {
        toDateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(AgeCalculatorActivity.this, dateSetListenerToDate, year, month, day);
                datePickerDialog.show();
            }
        });

        dateSetListenerToDate = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int selectedYear, int selectedMonth, int selectedDay) {
                selectedMonth = selectedMonth + 1;
                String todayDate = selectedDay + "/" + selectedMonth + "/" + selectedYear;
                todayTv.setText(todayDate);
                todayDateLocal = todayDate;
            }
        };
    }

    private void calculateAge() {
        calculateBtn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                yearTv.setText("0");
                monthTv.setText("0");
                dayTv.setText("0");

                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

                try {
                    Date date1 = simpleDateFormat.parse(birthDateLocal);
                    Date date2 = simpleDateFormat.parse(todayDateLocal);

                    long startDate = date1.getTime();
                    long endDate = date2.getTime();

                    if (startDate <= endDate) {
                        Period period = new Period(startDate, endDate, PeriodType.yearMonthDay());
                        yearTv.setText(Integer.toString(period.getYears()));
                        monthTv.setText(Integer.toString(period.getMonths()));
                        dayTv.setText(Integer.toString(period.getDays()));
                    } else {
                        Snackbar.make(view, "Birthdate should be not be larger that today's date.", Snackbar.LENGTH_LONG).show();
                    }
                } catch (Exception e) {
                    Log.e("error: ", e.toString());
                }
            }
        });
    }
}