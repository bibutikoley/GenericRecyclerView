package io.bibuti.recycleradapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BaseAdapter<T> extends RecyclerView.Adapter<BaseAdapter.ViewHolder> {

    private List<? extends T> mList;
    private int mLayoutId;
    private BaseInterface mBaseInterface;


    private AsyncListDiffer differ;
    private DiffUtil.ItemCallback diffUtil;

    /******* Constructor ****************************************************************************************/

    public BaseAdapter(List<? extends T> list, int layoutId, BaseInterface baseInterface) {
        this.mList = list;
        this.mLayoutId = layoutId;
        this.mBaseInterface = baseInterface;
    }

    /******* Recycler view Methods ****************************************************************************/

    @NonNull
    @Override
    public BaseAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewDataBinding binding = DataBindingUtil.bind(LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false));
        return new ViewHolder<>(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseAdapter.ViewHolder holder, int position) {

        T model = mList.get(position);

        holder.getBinding().setVariable(BR.data, model);
        holder.getBinding().setVariable(BR.position, position);
        holder.getBinding().executePendingBindings();

    }


    @Override
    public int getItemCount() {
        return differ.getCurrentList().size();
    }


    @Override
    public int getItemViewType(int position) {
        //return super.getItemViewType(position);
        return mLayoutId;
    }

    /******* Other Methods to perform actions in Recycler view ************************************************/

    public void setListener(BaseInterface baseInterface) {
        this.mBaseInterface = baseInterface;
    }

    public List<? extends T> getListInAdapter() {
        return mList;
    }

    public void setUpDiffer() {
        differ = new AsyncListDiffer(this, diffUtil);
    }

    public AsyncListDiffer getDiffer() {
        return differ;
    }

    public void setUpDiffUtil(DiffUtil.ItemCallback diffUtil) {
        this.diffUtil = diffUtil;
    }

    /******* Generic Interface for Click Events ****************************************************************/

    public interface BaseInterface {
        void onItemClicked(Object dataType, View view, int position);
    }

    /******* Generic ViewHolder *********************************************************************************/

    public class ViewHolder<V extends ViewDataBinding> extends RecyclerView.ViewHolder {

        private V v;

        public ViewHolder(@NonNull V itemView) {
            super(itemView.getRoot());
            this.v = itemView;
            v.setVariable(BR.callback, mBaseInterface); //This is item Click Listener...
        }

        public V getBinding() {
            return v;
        }

    }

}