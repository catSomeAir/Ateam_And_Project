package com.example.last_project.model.detail.writng;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.last_project.R;
import com.example.last_project.common.CommonVal;
import com.example.last_project.conn.CommonConn;
import com.example.last_project.search.NotFoundAlertActivity;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class WriteAdapter extends RecyclerView.Adapter<WriteAdapter.ViewHolder>{

    LayoutInflater inflater;
    Context context;
    ArrayList<BoardVO> list;

    public WriteAdapter(LayoutInflater inflater, Context context, ArrayList<BoardVO> list) {
        this.inflater = inflater;
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.item_write_board, parent, false));
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
        RecyclerView recv_coment;
        ImageView imgv_board_profile_img;
        TextView tv_board_nickname, tv_board_type, tv_board_content, tv_board_coment, tv_board_writedate;
        LinearLayout ln_board_type;
        public ViewHolder(@NonNull View v) {
            super(v);
            tv_board_writedate = v.findViewById(R.id.tv_board_writedate);
            recv_coment = v.findViewById(R.id.recv_coment);
            tv_board_nickname = v.findViewById(R.id.tv_board_nickname);
            imgv_board_profile_img = v.findViewById(R.id.imgv_board_profile_img);
            tv_board_type = v.findViewById(R.id.tv_board_type);
            tv_board_content = v.findViewById(R.id.tv_board_content);
            tv_board_coment = v.findViewById(R.id.tv_board_coment);
            ln_board_type = v.findViewById(R.id.ln_board_type);

        }
        public void bind(@NonNull ViewHolder h, int i){
            //글쓴이 이미지
            Glide.with(context).load(list.get(i).getFilepath().replace("localhost","192.168.0.33")).into(h.imgv_board_profile_img);
            //닉네임 -> 그냥 이메일로대체
            h.tv_board_nickname.setText(list.get(i).getEmail());
            if(list.get(i).getCmt_code().equals("o")){
                h.ln_board_type.setBackgroundResource(R.drawable.shape_green_border8);
                h.tv_board_type.setText("의견");
                h.tv_board_type.setTextColor(Color.parseColor("#294A2A"));
            }
            h.tv_board_writedate.setText(list.get(i).getWritedate());
            h.tv_board_content.setText(list.get(i).getContent());
            h.tv_board_coment.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (CommonVal.userInfo == null) {
                        Intent intent = new Intent(context, NotFoundAlertActivity.class);   //이름은 다른데 같은기능이라 그냥씀
                        intent.putExtra("intent_type", "write"); //글쓰기에서 띄운 alert
                        context.startActivity(intent);

                    } else if (CommonVal.userInfo != null) {  //로그인 된 상태에서 입력할 수 있는 엑티비티로 이동
                        Intent intent = new Intent(context, WriteSpaceActivity.class);
                        intent.putExtra("page", "WriteAdapter_reply");
                        intent.putExtra("board_id", list.get(i).getBoard_id()+"");
                        context.startActivity(intent);
                    }

                }
            });
            //댓글 정보
            CommonConn conn = new CommonConn(context, "board_coment_list");
            conn.addParams("board_id", list.get(i).getBoard_id());
            conn.executeConn(new CommonConn.ConnCallback() {
                @Override
                public void onResult(boolean isResult, String data) {
                    if(isResult){
                        ArrayList<ReplyVO> list = new Gson().fromJson(data, new TypeToken<ArrayList<ReplyVO>>(){}.getType());

                        WriteComentAdapter adapter = new WriteComentAdapter(inflater, context, list);
                        RecyclerView.LayoutManager manager = new LinearLayoutManager(context, RecyclerView.VERTICAL, false);
                        h.recv_coment.setLayoutManager(manager);
                        h.recv_coment.setAdapter(adapter);
                    }
                }
            });
        }
    }
}
