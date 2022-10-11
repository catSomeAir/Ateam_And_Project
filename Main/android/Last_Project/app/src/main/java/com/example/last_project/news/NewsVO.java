package com.example.last_project.news;

import com.example.last_project.model.detail.writng.ReplyVO;
import com.example.last_project.notice.NoticeVO;

public class NewsVO {

    private ReplyVO reply_vo;
    private NoticeVO notice_vo;
    private ReqBoardVO reqboard_vo;

    public ReplyVO getReply_vo() {
        return reply_vo;
    }
    public void setReply_vo(ReplyVO reply_vo) {
        this.reply_vo = reply_vo;
    }
    public NoticeVO getNotice_vo() {
        return notice_vo;
    }
    public void setNotice_vo(NoticeVO notice_vo) {
        this.notice_vo = notice_vo;
    }
    public ReqBoardVO getReqboard_vo() {
        return reqboard_vo;
    }
    public void setReqboard_vo(ReqBoardVO reqboard_vo) {
        this.reqboard_vo = reqboard_vo;
    }


}
