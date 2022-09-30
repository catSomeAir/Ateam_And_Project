package com.example.last_project.main.market;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.last_project.R;

import java.util.ArrayList;

public class Market_Grid_Adapter extends BaseAdapter {
    private ArrayList<GridVO> grid_list;
    private LayoutInflater inflater;
    private View convertview;

    public Market_Grid_Adapter(ArrayList<GridVO> grid_list, LayoutInflater inflater) {
        this.grid_list = grid_list;
        this.inflater = inflater;
    }

    @Override
    public int getCount() {
        return grid_list.size();

    }

    @Override
    public Object getItem(int position) {
        return grid_list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        this.convertview = convertView;
        convertView = inflater.inflate(R.layout.item_market_gridv, parent, false);
        GridViewHolder viewHolder = new GridViewHolder(convertView);
        viewHolder.bind(grid_list.get(position));
        return convertView;
    }

    public class GridViewHolder {
        //
        ImageView market_imgv_item;
        TextView market_tv_menu_brand_name, market_tv_menu_name
                , market_tv_menu_price1;

        public GridViewHolder(View v){
            market_imgv_item = v.findViewById(R.id.market_imgv_item);
            market_tv_menu_brand_name = v.findViewById(R.id.market_tv_menu_brand_name);
            market_tv_menu_name = v.findViewById(R.id.market_tv_menu_name);
            market_tv_menu_price1 = v.findViewById(R.id.market_tv_menu_price1);

        }
        public  void bind(GridVO vo ) {
            market_imgv_item.setImageResource(vo.getMarket_imgv_item());
            market_tv_menu_brand_name.setText(vo.getMarket_tv_menu_brand_name());
            market_tv_menu_name.setText(vo.getMarket_tv_menu_name());
            market_tv_menu_price1.setText(vo.getMarket_tv_menu_price1());

        }
    }
}
