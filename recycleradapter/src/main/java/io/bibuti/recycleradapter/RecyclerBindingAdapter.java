package io.bibuti.recycleradapter;

import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerBindingAdapter {

    @SuppressWarnings("unchecked")
    @androidx.databinding.BindingAdapter(value = {"layoutFile", "listener", "listData", "diffUtil"}, requireAll = false)
    public static <E> void bindAdapter(RecyclerView recyclerView, int id, BaseAdapter.BaseInterface listener, List<E> list, DiffUtil.ItemCallback diffutil) {
        if (recyclerView.getAdapter() == null) {
            recyclerView.setAdapter(new BaseAdapter(list, id, listener));
            ((BaseAdapter) recyclerView.getAdapter()).setUpDiffUtil(diffutil);
            ((BaseAdapter) recyclerView.getAdapter()).setUpDiffer();
            ((BaseAdapter) recyclerView.getAdapter()).setListener(listener);
            ((BaseAdapter) recyclerView.getAdapter()).getDiffer().submitList(list);
        }
    }
}
