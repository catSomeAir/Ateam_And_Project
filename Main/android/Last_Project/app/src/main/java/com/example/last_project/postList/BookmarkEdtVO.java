package com.example.last_project.postList;

public class BookmarkEdtVO {
   private BookmarkedPostVO vo ;
   private boolean isChecked;

    public BookmarkEdtVO(BookmarkedPostVO vo, boolean isChecked) {
        this.vo = vo;
        this.isChecked = isChecked;
    }

    public BookmarkedPostVO getVo() {
        return vo;
    }

    public void setVo(BookmarkedPostVO vo) {
        this.vo = vo;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
}
