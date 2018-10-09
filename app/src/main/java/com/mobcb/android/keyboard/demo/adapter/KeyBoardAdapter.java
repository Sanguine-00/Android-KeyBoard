package com.mobcb.android.keyboard.demo.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mobcb.android.keyboard.demo.R;
import com.mobcb.android.keyboard.demo.util.ListUtils;

import java.util.List;

public class KeyBoardAdapter extends RecyclerView.Adapter<KeyBoardAdapter.ViewHolder> {
    private List<String> list;
    private Context context;
    private OperatorCallback callback;

    public KeyBoardAdapter(List<String> list, Context context, OperatorCallback callback) {
        this.list = list;
        this.context = context;
        this.callback = callback;
    }

    public KeyBoardAdapter(List<String> list, Context context) {
        this.list = list;
        this.context = context;
    }

    public void resetData(List<String> list) {
        if (ListUtils.isNotEmpty(list)) {
            this.list = list;
            notifyDataSetChanged();
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.app_layout_car_plate_keyboard_item, null, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final String s = list.get(position);
        if ("delete".equals(s)) {
            holder.mAppCarPalateKeyboardItemImage.setImageResource(R.mipmap.icon_del);
            holder.mAppCarPalateKeyboardItemBtn.setVisibility(View.GONE);
            holder.mAppCarPalateKeyboardItemImage.setVisibility(View.VISIBLE);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (callback != null) {
                        callback.onBack();
                    }
                }
            });
        } else if ("hide".equals(s)) {
            holder.mAppCarPalateKeyboardItemImage.setImageResource(R.mipmap.icon_hide);
            holder.mAppCarPalateKeyboardItemBtn.setVisibility(View.GONE);
            holder.mAppCarPalateKeyboardItemImage.setVisibility(View.VISIBLE);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (callback != null) {
                        callback.onHide();
                    }
                }
            });
        } else {
            holder.mAppCarPalateKeyboardItemBtn.setText(s);
            holder.mAppCarPalateKeyboardItemImage.setImageDrawable(null);
            holder.mAppCarPalateKeyboardItemImage.setVisibility(View.GONE);
            holder.mAppCarPalateKeyboardItemBtn.setVisibility(View.VISIBLE);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (callback != null) {
                        callback.onText(s);
                    }
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    public interface OperatorCallback {
        /**
         * 输入文本
         *
         * @param s
         */
        void onText(String s);

        /**
         * 隐藏键盘
         */
        void onHide();

        /**
         * 退格
         */
        void onBack();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView mAppCarPalateKeyboardItemBtn;
        ImageView mAppCarPalateKeyboardItemImage;

        ViewHolder(View view) {
            super(view);
            this.mAppCarPalateKeyboardItemBtn = (TextView) view.findViewById(R.id.app_car_palate_keyboard_item_btn);
            this.mAppCarPalateKeyboardItemImage = (ImageView) view.findViewById(R.id.app_car_palate_keyboard_item_image);
        }
    }
}
