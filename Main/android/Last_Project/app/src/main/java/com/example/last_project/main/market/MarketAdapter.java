package com.example.last_project.main.market;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.last_project.R;

import java.util.ArrayList;

public class MarketAdapter  extends BaseAdapter {
    private ArrayList<GridVO> grid_list;
    private ArrayList<GiftVO> gift_list;
    private LayoutInflater inflater;
    private View convertview;

    public MarketAdapter( ArrayList<GiftVO> gift_list, ArrayList<GridVO> grid_list,LayoutInflater inflater) {
        this.grid_list = grid_list;
        this.gift_list = gift_list;
        this.inflater = inflater;
    }

    public MarketAdapter(ArrayList<GridVO> grid_list, LayoutInflater inflater) {
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
//        ImageView market_imgv_item; //item 안에 이미지파일 처리 아직 정하지않아 주석처리함
        TextView market_tv_menu_brand_name, market_tv_menu_name
                , market_tv_menu_price1;

        public GridViewHolder(View v){
//            market_imgv_item = v.findViewById(R.id.market_imgv_item); // 파일처리 관련 의논되지않아 주석처리함
            market_tv_menu_brand_name = v.findViewById(R.id.market_tv_menu_brand_name);
            market_tv_menu_name = v.findViewById(R.id.market_tv_menu_name);
            market_tv_menu_price1 = v.findViewById(R.id.market_tv_menu_price1);

        }
        public  void bind(GiftVO vo ) {
//            market_imgv_item.setImageResource(vo.getImg_id());// 파일처리 관련 의논되지않아 주석처리함
            market_tv_menu_brand_name.setText(vo.getGift_name()+"");
            market_tv_menu_price1.setText(vo.getGift_point());
        }
        public  void bind(GridVO vo ) {

        }
    }
}
