package com.example.last_project.postList.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.last_project.R;
import com.example.last_project.postList.BookmarkEdtVO;

import java.util.ArrayList;

public class EdtBookmarkedPost_deleteAdapter extends RecyclerView.Adapter<EdtBookmarkedPost_deleteAdapter.ViewHolder> {
    LayoutInflater inflater;
//    ArrayList<BookmarkedPostVO> list;
    Context context;
    FragmentActivity fragmentActivity;
    ArrayList<BookmarkEdtVO> edt_list;
//    public EdtBookmarkedPostAdapter(LayoutInflater inflater, ArrayList<BookmarkedPostVO> list, Context context, FragmentActivity fragmentActivity) {
//        this.inflater = inflater;
//        this.list = list;
//        this.context =context;
//        this.fragmentActivity =fragmentActivity;
//    }


    public EdtBookmarkedPost_deleteAdapter(LayoutInflater inflater, ArrayList<BookmarkEdtVO> edt_list, Context context, FragmentActivity fragmentActivity) {
        this.inflater = inflater;
        this.context = context;
        this.fragmentActivity = fragmentActivity;
        this.edt_list = edt_list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.item_edt_bookmarked_post, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(holder,position);
    }

    @Override
    public int getItemCount() {
        return edt_list.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_bookmarked_name,tv_model_code,tv_brand;
        ImageView imgv_modelimg, imgv_edt_handler;
        CheckBox chkbox_edt_bookmark;
        LinearLayout ln_edt_bookmark;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_bookmarked_name= itemView.findViewById(R.id.tv_bookmarked_name);
            tv_model_code=itemView.findViewById(R.id.tv_model_code);
            tv_brand= itemView.findViewById(R.id.tv_brand);
            imgv_modelimg =itemView.findViewById(R.id.imgv_modelimg);
            chkbox_edt_bookmark =itemView.findViewById(R.id.chkbox_edt_bookmark);
            ln_edt_bookmark =itemView.findViewById(R.id.ln_edt_bookmark);
            imgv_edt_handler =itemView.findViewById(R.id.imgv_edt_handler);


        }
        public void bind(@NonNull ViewHolder h, int i){
            if(edt_list.get(i).isChecked()){
                h.ln_edt_bookmark.setVisibility(View.GONE);
            }
            Glide.with(context).load(edt_list.get(i).getVo().getFilepath().replace("localhost","121.147.215.12:3302").replace("192.168.0.33","121.147.215.12:3302")).into(h.imgv_modelimg);
           h.tv_bookmarked_name.setText(edt_list.get(i).getVo().getModel_name()+"");
           h.tv_model_code.setText(edt_list.get(i).getVo().getModel_code()+"");
           h.tv_brand.setText(edt_list.get(i).getVo().getBrand_name()+"");


           h.chkbox_edt_bookmark.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   if(h.chkbox_edt_bookmark.isChecked()){
                       edt_list.get(i).setChecked(true);
                   }else{
                       edt_list.get(i).setChecked(false);
                   }
               }
           });


        }


    }
}
