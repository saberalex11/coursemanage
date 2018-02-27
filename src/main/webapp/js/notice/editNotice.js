layui.config({
    version: '1509633239420' //为了更新 js 缓存，可忽略
});
var vm = new Vue({
    el:'#editApp',
    data : {
        noticeTitle:'',
        noticeDesc:'',
        id:''
    },
    methods:{
    }
});
layui.use(['form', 'laypage', 'layer', 'table', 'jquery', 'upload', 'element'], function(){
    var layer = layui.layer //弹层
        ,form = layui.form//表单
        ,$ = layui.jquery;


    var noticeId = localStorage.editNoticeId;
    vm.id = noticeId;
    var param = {
        "id":noticeId
    };
    $.post(baseURL+"/notice/queryNoticeDetail.do",param,function (data) {
        vm.noticeTitle = data.noticeTitle;
        vm.noticeDesc = data.noticeDesc;
    });

    form.on('submit(submit)', function(data){
        $.post(baseURL+"/notice/updateNotice.do",data.field,function (data){
            layer.alert('保存成功', function(index){
                //do something
                layer.close(index);
                window.location.href="noticeManage.jsp";
            });
        });
    });
});

