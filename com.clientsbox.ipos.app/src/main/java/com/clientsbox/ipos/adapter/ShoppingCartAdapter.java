package com.clientsbox.ipos.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.clientsbox.ipos.R;
import com.clientsbox.ipos.transfer.object.ShoppingCart;

import java.util.List;

public class ShoppingCartAdapter extends BaseAdapter {

    static class ViewHolder {
        TextView name;
        TextView quantity;
        TextView price;
    }

    private Context _context;
    private List<ShoppingCart> _list;
    public ShoppingCartAdapter(Context mContext,  List<ShoppingCart> mList) {
        _context = mContext;
        _list = mList;
    }

    @Override
    public int getCount() {
        return _list.size();
    }

    @Override
    public Object getItem(int position) {
        return _list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;

        // reuse views
        if (rowView == null) {
            LayoutInflater inflater = ((Activity) _context).getLayoutInflater();
            rowView = inflater.inflate(R.layout.shopppingcart_row, null);

            ViewHolder viewHolder = new ViewHolder();
            viewHolder.name = (TextView) rowView.findViewById(R.id.shoppingcart_name);
            viewHolder.quantity = (TextView) rowView.findViewById(R.id.shoppingcart_qty);
            viewHolder.price = (TextView) rowView.findViewById(R.id.shoppingcart_price);
            rowView.setTag(viewHolder);
        }

        ViewHolder holder = (ViewHolder) rowView.getTag();
        holder.name.setText(_list.get(position).getName());
        holder.quantity.setText( String.valueOf(_list.get(position).getQuantity()));
        holder.price.setText(String.valueOf(_list.get(position).getPrice()));

        return rowView;
    }
    public List<ShoppingCart> getList(){
        return _list;
    }
}
