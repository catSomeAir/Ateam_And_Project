package com.example.last_project.model.detail.writng;

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
import com.example.last_project.common.CommonVal;

import java.util.ArrayList;

public class WriteComentAdapter extends RecyclerView.Adapter<WriteComentAdapter.ViewHolder> {
    LayoutInflater inflater;
    Context context;
    ArrayList<ReplyVO> list;

    public WriteComentAdapter(LayoutInflater inflater, Context context, ArrayList<ReplyVO> list) {
        this.inflater = inflater;
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.item_write_board_reply, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(holder, position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgv_reply_profile, imgv_write_google, imgv_write_kakao, imgv_write_naver;
        TextView tv_reply_name, tv_reply_writedate, tv_reply_content, tv_reply_update, tv_reply_delete;
        LinearLayout ln_reply_modify;

        public ViewHolder(@NonNull View v) {
            super(v);

            imgv_reply_profile = v.findViewById(R.id.imgv_reply_profile);
            tv_reply_name = v.findViewById(R.id.tv_reply_name);
            tv_reply_writedate = v.findViewById(R.id.tv_reply_writedate);
            tv_reply_content = v.findViewById(R.id.tv_reply_content);

            //수정/삭제 부분
            ln_reply_modify = v.findViewById(R.id.ln_reply_modify);
            tv_reply_update = v.findViewById(R.id.tv_reply_update);
            tv_reply_delete = v.findViewById(R.id.tv_reply_delete);

            //소셜로그인인 경우
            imgv_write_google = v.findViewById(R.id.imgv_write_google);
            imgv_write_kakao = v.findViewById(R.id.imgv_write_kakao);
            imgv_write_naver = v.findViewById(R.id.imgv_write_naver);
        }

        public void bind(@NonNull ViewHolder h, int i) {
            Glide.with(context).load(list.get(i).getFilepath().replace("localhost", "121.147.215.12:3302").replace("192.168.0.33","121.147.215.12:3302")).into(h.imgv_reply_profile);
            h.tv_reply_name.setText(list.get(i).getEmail());
            h.tv_reply_writedate.setText(list.get(i).getWritedate());
            h.tv_reply_content.setText(list.get(i).getContent());
            if (CommonVal.userInfo != null) {
                if (CommonVal.userInfo.getEmail().equals(list.get(i).getEmail())) {
                    h.ln_reply_modify.setVisibility(View.VISIBLE);
                }
            }
            if(list.get(i).getSocial_code().equals("G")){
                h.imgv_write_google.setVisibility(View.VISIBLE);
            }else if(list.get(i).getSocial_code().equals("N")){
                h.imgv_write_naver.setVisibility(View.VISIBLE);
            }else if(list.get(i).getSocial_code().equals("K")){
                h.imgv_write_kakao.setVisibility(View.VISIBLE);
            }

            h.tv_reply_update.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, WriteSpaceActivity.class);
                    intent.putExtra("page", "WriteComentAdapter_update");
                    intent.putExtra("rep_no", list.get(i).getRep_no());
                    intent.putExtra("content", list.get(i).getContent());
                    context.startActivity(intent);


                }
            });

        }
    }
}
