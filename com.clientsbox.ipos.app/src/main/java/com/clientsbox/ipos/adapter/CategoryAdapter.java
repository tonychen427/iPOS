package com.clientsbox.ipos.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.clientsbox.ipos.R;
import com.clientsbox.ipos.transfer.object.InventoryCategory;
import com.clientsbox.ipos.transfer.object.InventoryItem;

import java.util.List;

/**
 * Created by ttran on 10/21/15.
 */
public class CategoryAdapter extends BaseAdapter {
    private Context mContext;
    private final List<InventoryItem> _inventoryItem;
    private final int[] Imageid;

    public CategoryAdapter(Context c, List<InventoryItem> inventoryItem, int[] Imageid ) {
        mContext = c;
        this.Imageid = Imageid;
        this._inventoryItem = inventoryItem;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return _inventoryItem.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        View grid;
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {

            grid = new View(mContext);
            grid = inflater.inflate(R.layout.grid_single, null);
            TextView textView = (TextView) grid.findViewById(R.id.grid_text);
            ImageView imageView = (ImageView)grid.findViewById(R.id.grid_image);
            textView.setText(_inventoryItem.get(position).getTitle());
            imageView.setImageResource(Imageid[position]);
        } else {
            grid = (View) convertView;
        }

        return grid;
    }
}