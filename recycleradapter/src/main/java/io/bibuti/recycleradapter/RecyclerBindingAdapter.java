package io.bibuti.recycleradapter;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerBindingAdapter {

    @SuppressWarnings("unchecked")
    @androidx.databinding.BindingAdapter(value = {"layoutFile", "listener", "listData"}, requireAll = false)
    public static <E> void bindAdapter(RecyclerView recyclerView, int id, BaseAdapter.BaseInterface listener, List<E> list) {
        if (recyclerView.getAdapter() == null) {
            recyclerView.setAdapter(new BaseAdapter(list, id, listener));
        } else {
            ((BaseAdapter) recyclerView.getAdapter()).setListener(listener);
            ((BaseAdapter) recyclerView.getAdapter()).setData(list);
        }
    }
}
