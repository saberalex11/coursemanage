package com.wyq.service;

import com.wyq.bean.Notice;
import com.wyq.utils.R;

public interface NoticeService extends BasicService<Notice> {
    R queryAllNotice(String noticeTitle,Integer page, Integer limit);

    R queryMyNotice(String noticeTitle,int createId,Integer page, Integer limit);
}
