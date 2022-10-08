package com.example.last_project.model.detail.as;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.last_project.R;
import com.example.last_project.conn.CommonConn;
import com.example.last_project.map.Documents;
import com.example.last_project.search.category_search.CategorySearchVO;

import java.util.List;

// 2022-10-07 KYM 수정
// 생성자 추가 -> List<Documents> data
// distance 메소드 추가
public class AfterServiceAdapter extends RecyclerView.Adapter<AfterServiceAdapter.ViewHolder>{
    CategorySearchVO model_info;
    LayoutInflater inflater;    //* list 필드에 추가해야함
    Context context;
    List<Documents> data;

    public AfterServiceAdapter(LayoutInflater inflater, Context context, List<Documents> data, CategorySearchVO model_info) {
        this.inflater = inflater;
        this.context = context;
        this.data = data;
        this.model_info = model_info;
    }

    //* list 생성자 추가 수정해야함!! --
    public AfterServiceAdapter(LayoutInflater inflater, Context context) {
        this.inflater = inflater;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.item_search_as, parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(holder,position);
    }

    @Override
    public int getItemCount() {
        return 10;  //list로 수정해야함
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_as_name, tv_as_category, tv_as_open, tv_as_close_time, tv_as_distance, tv_as_address;
        LinearLayout ln_as_link;
        ImageView imgv_as_logo;
        public ViewHolder(@NonNull View v) {
            super(v);
            tv_as_name = v.findViewById(R.id.tv_as_name);
            tv_as_category = v.findViewById(R.id.tv_as_category);
            tv_as_open = v.findViewById(R.id.tv_as_open);
            tv_as_close_time = v.findViewById(R.id.tv_as_close_time);
            tv_as_distance = v.findViewById(R.id.tv_as_distance);
            tv_as_address = v.findViewById(R.id.tv_as_address);
            ln_as_link = v.findViewById(R.id.ln_as_link);
            imgv_as_logo = v.findViewById(R.id.imgv_as_logo);
        }

        public void bind(@NonNull ViewHolder h, int i){
            h.tv_as_name.setText(data.get(i).getPlace_name());
            h.tv_as_category.setText(data.get(i).getCategory_name());
            h.tv_as_address.setText(data.get(i).getAddress_name() + data.get(i).getPlace_name());
            tv_as_distance.setText(distance(Double.parseDouble(data.get(i).getY()) ,Double.parseDouble(data.get(i).getX())   , 35.1535583 ,126.8879957 ,"kilometer")+"km");
            //35.1535583,126.8879957,
            //data.get(i).getPlace_url() http://place.map.kakao.com/1235329

            //브랜드로고띄우기
            CommonConn conn = new CommonConn(context, "brand_logo");
            conn.addParams("brand_name", model_info.getBrand_name());
            conn.executeConn_no_dialog(new CommonConn.ConnCallback() {
                @Override
                public void onResult(boolean isResult, String data) {
                    if(isResult){
                        Glide.with(context).load(data.replace("localhost","121.147.215.12:3302").replace("192.168.0.33","121.147.215.12:3302")).into(h.imgv_as_logo);
                    }
                }
            });


            h.ln_as_link.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, AfterServiceActivity.class  );
                    intent.putExtra("data", data.get(i));
                    context.startActivity(intent);
                }
            });
        }
    }

    private static int distance(double lat1, double lon1, double lat2, double lon2, String unit) {

        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));

        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;

        if (unit == "kilometer") {
            dist = dist * 1.609344;
        } else if(unit == "meter"){
            dist = dist * 1609.344;
        }
        int tempInt = (int) dist;
        return tempInt;
    }


    private static double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }


    private static double rad2deg(double rad) {
        return (rad * 180 / Math.PI);
    }

}
