package vn.edu.ntu.dangthikimthuy.ontap;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class dangkyFragment extends Fragment {


    EditText edtten, edtngaysinh, edtsdt, edtdiachi;

    ImageView imglich;

    RadioButton rbtienmat, rbnganhang, rbvidientu;

    Spinner spinner;

    Button btndky;


    NavController navController;


    String ten, ngaysinh, sdt, diachi, dichvu, phuongthuc;
    private EditText mEdtten;
    private EditText mEdtngay;
    private ImageView mImglich;
    private EditText mEdtsdt;
    private EditText mEdtdiachi;
    private RadioButton mRbtienmat;
    private RadioButton mRbnganhang;
    private RadioButton mRbvidientu;
    private Spinner mSpinner;
    private Button mBtndky;


    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,

                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_dangky, container, false);

        addview(view);

        getdata();

        addEvent();

        return view;


    }


    private void addEvent() {

        btndky.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {

                ten = edtten.getText().toString();

                ngaysinh = edtngaysinh.getText().toString();

                sdt = edtsdt.getText().toString();

                diachi = edtdiachi.getText().toString();


                if (rbtienmat.isChecked())

                    phuongthuc = "tiền mặt";

                if (rbnganhang.isChecked())

                    phuongthuc = "Ngân hàng";

                if (rbvidientu.isChecked())

                    phuongthuc = "Ví điện tử";


                dichvu = spinner.getSelectedItem().toString();


                Bundle data = new Bundle();

                data.putString("ten", ten);

                data.putString("ngaysinh", ngaysinh);

                data.putString("diachi", diachi);

                data.putString("sdt", sdt);

                data.putString("dichvu", dichvu);

                data.putString("phuongthuc", phuongthuc);
                navController.navigate(R.id.action_dangkyFragment_to_hienthiFragment, data);

            }

        });

    }


    private void getdata() {

        imglich.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {

                Calendar calendar = Calendar.getInstance();

                DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                        StringBuilder builder = new StringBuilder();

                        builder.append(year)

                                .append("-")

                                .append(++month)

                                .append("-")

                                .append(dayOfMonth);

                        edtngaysinh.setText(builder.toString());

                    }


                };

                DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), listener

                        , calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));

                datePickerDialog.show();

            }

        });


        String[] dichvu = new String[]{"Truyền hình cáp", "Truyền hình số", "FPT"};


//tao adapter cho mang gia tri

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(dangkyFragment.this.getActivity(),

                R.layout.support_simple_spinner_dropdown_item, dichvu);


//gan adapter cho spinner

        spinner.setAdapter(arrayAdapter);

    }


    private void addview(View view) {

        mEdtten = view.findViewById(R.id.edtten);
        mEdtngay = view.findViewById(R.id.edtngay);
        mImglich = view.findViewById(R.id.imglich);
        mEdtsdt = view.findViewById(R.id.edtsdt);
        mEdtdiachi = view.findViewById(R.id.edtdiachi);
        mRbtienmat = view.findViewById(R.id.rbtienmat);
        mRbnganhang = view.findViewById(R.id.rbnganhang);
        mRbvidientu = view.findViewById(R.id.rbvidientu);
        mSpinner = view.findViewById(R.id.spinner);
        mBtndky = view.findViewById(R.id.btndky);


        navController = NavHostFragment.findNavController(dangkyFragment.this);

    }

}