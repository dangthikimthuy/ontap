package vn.edu.ntu.dangthikimthuy.ontap;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */


public class hienthiFragment extends Fragment {


    NavController navController;


    TextView txthienthi;

    Button btnthoat;
    private TextView mTxthienthi;
    private Button mBtnthoat;

    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,

                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_hienthi, container, false);

        addview(view);

        getdata();

        addEvent();

        return view;


    }


    private void addEvent() {

        btnthoat.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {

                navController.navigate(R.id.action_hienthiFragment_to_dangkyFragment);

            }

        });

    }


    private void getdata() {

        Bundle data = getArguments();

        String str = "Chúc mừng khách hàng: " + data.getString("ten") + "\n Sinh ngày: "

                + data.getString("ngaysinh") + "\n Đã đăng ký dịch vụ: \n" + data.getString("dichvu")

                + "\n Hình thức thanh toán: \n" + data.get("phuongthuc") + "\n Chúng tôi sẽ liên lạc với bạn qua số điện thoại: \n"

                + data.getString("sdt");

        txthienthi.setText(str);

    }


    private void addview(View view) {

        navController = NavHostFragment.findNavController(hienthiFragment.this);



        mTxthienthi = view.findViewById(R.id.txthienthi);
        mBtnthoat = view.findViewById(R.id.btnthoat);

    }

}