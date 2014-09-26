package com.example.todolist;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

public class ListItemsAdapter extends ArrayAdapter<ListItems> {
	Context context; 
    int layoutResourceId;    
    ListItems data[] = null;
    
    public ListItemsAdapter(Context context, int layoutResourceId, ListItems[] data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;	
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ListItemsHolder holder = null;
        
        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);
            
            holder = new ListItemsHolder();
            holder.checkBox1 = (CheckBox)row.findViewById(R.id.checkBox1);	
            holder.txtTitle = (TextView)row.findViewById(R.id.txtTitle);
            
            row.setTag(holder);
        }
        else
        {
            holder = (ListItemsHolder)row.getTag();
        }
        
        ListItems ListItems = data[position];
        holder.txtTitle.setText(ListItems.title);
        holder.checkBox1.setSelected(false);

        return row;
    }
    
    static class ListItemsHolder
    {
        public CheckBox checkBox1;
		TextView txtTitle;
    }
}
