package com.example.emedel.app2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<String> names;

    public MyAdapter(Context context, int layout, List<String> names) {
        this.context = context;
        this.layout = layout;
        this.names = names;
    }

    @Override
    public int getCount() {
        return names.size();
    }

    @Override
    public Object getItem(int position) {
        return names.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;

        if(convertView == null){
            LayoutInflater layoutInflater = LayoutInflater.from(this.context);
            convertView = layoutInflater.inflate(R.layout.linea_item,null);

            holder = new ViewHolder();
            holder.textView = (TextView) convertView.findViewById(R.id.textView);

            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

        String currentName = names.get(position);
        holder.textView.setText(currentName);

        return convertView;
    }

    static class ViewHolder{
        private TextView textView;
    }

}
