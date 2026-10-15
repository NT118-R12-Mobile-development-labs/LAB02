package com.example.case04;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText edtMA;
    EditText edtTen;
    RadioGroup rgLoai;
    Button btnNhap;
    ListView lvNhanVien;
    ArrayList<Employee> employees;
    ArrayAdapter<Employee> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        edtMA = findViewById(R.id.edtMa);
        edtTen = findViewById(R.id.edtTen);
        rgLoai = findViewById(R.id.rgLoai);
        btnNhap = findViewById(R.id.btnNhap);
        employees = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, employees);
        lvNhanVien = findViewById(R.id.lvNhanVien);
        lvNhanVien.setAdapter(adapter);

        btnNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = edtMA.getText().toString();
                String name = edtTen.getText().toString();
                Employee employee;
                if (rgLoai.getCheckedRadioButtonId() == R.id.radChinhThuc)
                    employee = new EmployeeFulltime(id, name);
                else
                    employee = new EmployeeParttime(id, name);
                employees.add(employee);
                adapter.notifyDataSetChanged();
            }
        });
    }
}