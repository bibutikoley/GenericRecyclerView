package io.bibuti.genericrecyclerview;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import java.util.ArrayList;

import io.bibuti.recycleradapter.BaseAdapter;
import io.bibuti.recycleradapter.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setData(new ArrayList());

        binding.setCallback(new BaseAdapter.BaseInterface() {
            @Override
            public void onItemClicked(Object dataType, View view, int position) {

            }
        });
    }
}
