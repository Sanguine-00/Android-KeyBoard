package com.mobcb.android.keyboard.demo;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

import com.mobcb.android.keyboard.demo.adapter.KeyBoardAdapter;
import com.mobcb.android.keyboard.demo.util.StrUtils;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends Activity implements KeyBoardAdapter.OperatorCallback, View.OnClickListener {

    private String[] provinces;
    private String[] numbers;
    private int[] rbIds;
    private RadioButton[] radioButtons;
    private RadioButton mAppCarPalateProvince;
    private RadioButton mAppCarPalateChar;
    private RadioButton mAppCarPalate1;
    private RadioButton mAppCarPalate2;
    private RadioButton mAppCarPalate3;
    private RadioButton mAppCarPalate4;
    private RadioButton mAppCarPalate5;
    /**
     * 新能源
     */
    private RadioButton mAppCarPalateNew;
    private RadioGroup mAppCarPalate;
    private RecyclerView mAppCarPalateKeyboard;
    private RelativeLayout mAppCarPalateKeyboardLayout;
    private int currentIndex = 0;
    private GridLayoutManager layoutManager;
    private KeyBoardAdapter adapter;
    private List<String> listProvinces;
    private List<String> listNumbers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {
        provinces = new String[]{"京", "津", "冀", "晋", "蒙", "辽", "吉", "黑", "沪", "苏", "浙", "皖", "闽", "赣", "鲁", "豫", "鄂",
                "湘", "粤", "桂", "琼", "渝", "川", "贵", "云", "藏", "陕", "甘", "青", "宁", "新", "台"
        };
        numbers = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "0",
                "A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
                "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
                "U", "V", "W", "X", "Y", "Z", "港", "澳", "学", "警",
                "delete", "hide"
        };
        rbIds = new int[]{
                R.id.app_car_palate_province,
                R.id.app_car_palate_char,
                R.id.app_car_palate_1,
                R.id.app_car_palate_2,
                R.id.app_car_palate_3,
                R.id.app_car_palate_4,
                R.id.app_car_palate_5,
                R.id.app_car_palate_new,
        };
        listProvinces = Arrays.asList(provinces);
        listNumbers = Arrays.asList(numbers);
        layoutManager = new GridLayoutManager(this, 8);
        adapter = new KeyBoardAdapter(listProvinces, this, this);
        mAppCarPalateKeyboard.setLayoutManager(layoutManager);
        mAppCarPalateKeyboard.setAdapter(adapter);
    }

    private void initView() {
        mAppCarPalateProvince = (RadioButton) findViewById(R.id.app_car_palate_province);
        mAppCarPalateChar = (RadioButton) findViewById(R.id.app_car_palate_char);
        mAppCarPalate1 = (RadioButton) findViewById(R.id.app_car_palate_1);
        mAppCarPalate2 = (RadioButton) findViewById(R.id.app_car_palate_2);
        mAppCarPalate3 = (RadioButton) findViewById(R.id.app_car_palate_3);
        mAppCarPalate4 = (RadioButton) findViewById(R.id.app_car_palate_4);
        mAppCarPalate5 = (RadioButton) findViewById(R.id.app_car_palate_5);
        mAppCarPalateNew = (RadioButton) findViewById(R.id.app_car_palate_new);
        mAppCarPalate = (RadioGroup) findViewById(R.id.app_car_palate);
        mAppCarPalateKeyboard = (RecyclerView) findViewById(R.id.app_car_palate_keyboard);
        mAppCarPalateKeyboardLayout = (RelativeLayout) findViewById(R.id.app_car_palate_keyboard_layout);
        radioButtons = new RadioButton[]{mAppCarPalateProvince, mAppCarPalateChar, mAppCarPalate1, mAppCarPalate2, mAppCarPalate3, mAppCarPalate4, mAppCarPalate5, mAppCarPalateNew};
        mAppCarPalateProvince.setOnClickListener(this);
        mAppCarPalateChar.setOnClickListener(this);
        mAppCarPalate1.setOnClickListener(this);
        mAppCarPalate2.setOnClickListener(this);
        mAppCarPalate3.setOnClickListener(this);
        mAppCarPalate4.setOnClickListener(this);
        mAppCarPalate5.setOnClickListener(this);
        mAppCarPalateNew.setOnClickListener(this);

    }

    @Override
    public void onText(String s) {
        radioButtons[currentIndex].setText(s);
        if (currentIndex == 0) {
            layoutManager.setSpanCount(6);
            if (adapter != null) {
                adapter.resetData(listNumbers);
            }
        }
        if (currentIndex == rbIds.length - 2) {
            mAppCarPalateKeyboardLayout.setVisibility(View.GONE);
            return;
        }
        if (currentIndex < rbIds.length - 1) {
            currentIndex += 1;
            mAppCarPalate.check(rbIds[currentIndex]);
        }
    }

    @Override
    public void onHide() {
        mAppCarPalateKeyboardLayout.setVisibility(View.GONE);
    }

    @Override
    public void onBack() {
        radioButtons[currentIndex].setText("");
        if (currentIndex > 0) {
            currentIndex -= 1;
            mAppCarPalate.check(rbIds[currentIndex]);
        }
        if (currentIndex == 0) {
            layoutManager.setSpanCount(8);
            if (adapter != null) {
                adapter.resetData(listProvinces);
            }
        }
    }

    @Override
    public void onClick(View v) {
        int lastIndex = currentIndex;
        mAppCarPalateKeyboardLayout.setVisibility(View.VISIBLE);
        switch (v.getId()) {
            case R.id.app_car_palate_province:
                currentIndex = 0;
                break;
            case R.id.app_car_palate_char:
                currentIndex = 1;
                break;
            case R.id.app_car_palate_1:
                currentIndex = 2;
                break;
            case R.id.app_car_palate_2:
                currentIndex = 3;
                break;
            case R.id.app_car_palate_3:
                currentIndex = 4;
                break;
            case R.id.app_car_palate_4:
                currentIndex = 5;
                break;
            case R.id.app_car_palate_5:
                currentIndex = 6;
                break;
            case R.id.app_car_palate_new:
                currentIndex = 7;
                break;
        }
        if (currentIndex == 0) {
            layoutManager.setSpanCount(8);
            adapter.resetData(listProvinces);
            currentIndex = 0;
        } else if (currentIndex <= rbIds.length - 1) {
            if (StrUtils.isNotEmpty(radioButtons[currentIndex - 1].getText().toString().trim())) {
                layoutManager.setSpanCount(6);
                adapter.resetData(listNumbers);
            } else {
                currentIndex = lastIndex;
                if (currentIndex == 0) {
                    layoutManager.setSpanCount(8);
                    adapter.resetData(listProvinces);
                } else {
                    layoutManager.setSpanCount(6);
                    adapter.resetData(listNumbers);
                }
                mAppCarPalate.check(rbIds[currentIndex]);
            }
        }
    }
}
