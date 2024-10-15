package com.example.exam02;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.exam02.Model.BaoThuc;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText editTBT, editSLD;
    RadioGroup radioGroup;
    CheckBox chkLL;
    Spinner spinner;
    ListView listview;
    Button btnXoa, btnThem, btnTK;
    String thoigian = "Sáng";
    ArrayList<String> arrayspinner = new ArrayList<>();
    ArrayList<BaoThuc> myList = new ArrayList<BaoThuc>();
    ArrayAdapter adapter;
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
        getWidget();
        getData();
        btnXoa.setOnClickListener(new ProcessButton());
        btnThem.setOnClickListener(new ProcessButton());
        btnTK.setOnClickListener(new ProcessButton());
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rad = findViewById(checkedId);
                thoigian = rad.getText().toString();
            }
        });
        adapter = new ArrayAdapter(MainActivity.this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, myList);
        listview.setAdapter(adapter);

    }

    private class ProcessButton implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            if(v==btnXoa){
                editTBT.setText("");
                RadioButton radSang = findViewById(R.id.radSang);
                radSang.setChecked(true);
                chkLL.setChecked(false);
                spinner.setSelection(0);
                editTBT.requestFocus();
            }
            if(v==btnThem){
                String tenbaothuc = editTBT.getText().toString();
                if(tenbaothuc.length() <=0) return;

                BaoThuc bt = new BaoThuc(tenbaothuc,
                        thoigian,
                        chkLL.isChecked(),
                        spinner.getSelectedItem().toString());
                myList.add(bt);
                editSLD.setText(myList.size()+"");
                adapter.notifyDataSetChanged();

            }
            if(v == btnTK){
                int countSang = 0;
                int countChieu = 0;
                int sll = 0;

                for (BaoThuc bt:  myList) {
                   if(bt.getThoiGian().equals("Sáng")) {
                       countSang++;
                   }
                   else {
                       countChieu++;
                   }
                   if(bt.getLapLai()){
                       sll++;
                   }

                }

                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("Thong bao");
                dialog.setMessage("So lan sang: " + countSang+", So lan chieu: "+countChieu +"," +
                        "So lan lap lai: " + sll);
                dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dialog.show();



            }
        }
    }
    private void getData() {
        arrayspinner.add("Tất cả các ngày");
        arrayspinner.add("Thứ 2");
        arrayspinner.add("Thứ 3");
        arrayspinner.add("Thứ 4");
        arrayspinner.add("Thứ 5");
        arrayspinner.add("Thứ 6");
        arrayspinner.add("Thứ 7");
        arrayspinner.add("Chủ nhật");
        ArrayAdapter spinneradap = new ArrayAdapter(MainActivity.this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
                arrayspinner);
        spinner.setAdapter(spinneradap);

    }

    private void getWidget() {
        editTBT = findViewById(R.id.editTBT);
        editSLD = findViewById(R.id.editSLD);
        radioGroup = findViewById(R.id.radGroup);
        chkLL = findViewById(R.id.chkLL);
        spinner = findViewById(R.id.spinner);
        listview = findViewById(R.id.listview);
        btnXoa = findViewById(R.id.btnXoa);
        btnThem = findViewById(R.id.btnThem);
        btnTK = findViewById(R.id.btnTongKet);
    }


}