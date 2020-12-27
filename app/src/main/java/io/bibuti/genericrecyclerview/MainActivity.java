package io.bibuti.genericrecyclerview;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DiffUtil;

import java.util.ArrayList;

import io.bibuti.recycleradapter.BaseAdapter;
import io.bibuti.recycleradapter.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    ArrayList<Integer> data = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        for (int i = 0; i < 100; i++) {
            data.add(i + 1);
        }
        binding.setData(data);

        binding.setCallback(new BaseAdapter.BaseInterface() {
            @Override
            public void onItemClicked(Object dataType, View view, int position) {

            }
        });

        binding.setDiffUtil(new DiffUtil.ItemCallback<Integer>() {
            @Override
            public boolean areItemsTheSame(@NonNull Integer oldItem, @NonNull Integer newItem) {
                return false;
            }

            @Override
            public boolean areContentsTheSame(@NonNull Integer oldItem, @NonNull Integer newItem) {
                return false;
            }
        });
    }
}
