package com.wyq.controller;

import com.wyq.bean.Account;
import com.wyq.bean.Notice;
import com.wyq.service.NoticeService;
import com.wyq.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("notice")
public class NoticeController extends BaseController {

    @Autowired
    private NoticeService noticeService;

    @RequestMapping("addNotice")
    public R addNotice(HttpServletRequest request,Notice notice){
        Account current = this.getCurrent(request);
        notice.setCreateId(current.getId());
        notice.setCreateName(current.getName());
        noticeService.add(notice);
        return R.ok();
    }

    @RequestMapping("deleteNotice")
    public R deleteNotice(Notice notice){
        noticeService.delete(notice);
        return R.ok();
    }

    @RequestMapping("updateNotice")
    public R updateNotice(Notice notice){
        noticeService.updateByPrimaryKeySelective(notice);
        return R.ok();
    }

    @RequestMapping("queryAllNotice")
    public R queryAllNotice(String noticeTitle,Integer page, Integer limit){
        return noticeService.queryAllNotice(noticeTitle,page,limit);
    }

    @RequestMapping("queryMyNotice")
    public R queryMyNotice(HttpServletRequest request,String noticeTitle,Integer page, Integer limit){
        Account current = this.getCurrent(request);
        return noticeService.queryMyNotice(noticeTitle,current.getId(),page,limit);
    }

    @RequestMapping("queryNoticeDetail")
    public Notice queryNoticeDetail(Notice notice){
        return noticeService.queryOne(notice);
    }
}
