/**
 * Created by hanpeng on 2017-09-25.
 */
layui.config({
  base: "../../js/"
}).use(['form', 'layer','element', 'jquery', 'table','laydate','upload'], function () {
    window.form = layui.form,
        window.layer = parent.layer === undefined ? layui.layer : parent.layer,
        window.table = layui.table,
        window.$ = layui.jquery;

    /**监听查询提交*/
    form.on('submit(searchFilter)', function (data) {
        noticeTableRender.reload({
            where: {
                'noticeTitle': data.field.noticeTitle
            }
        });
    });


        /**监听工具条*/
        table.on('tool(noticeTable)', function (obj) {
            var data = obj.data; //获得当前行数据
            var layEvent = obj.event; //获得 lay-event 对应的值
            var noticeId = data.id;
            if(layEvent === 'watch'){
                var param = {
                    "id":noticeId
                };
                $.post(baseURL+"/notice/queryNoticeDetail.do",param,function (data){
                    vm.noticeTitle = data.noticeTitle;
                    vm.noticeDesc = data.noticeDesc;
                    layui.layer.open({
                        type: 1,
                        offset: '50px',
                        skin: 'layui-layer-molv',
                        title: "公告详情",
                        area: ['500px', '300px'],
                        closeBtn: 1,
                        shadeClose: true,
                        content: $('#noticeDetailDiv') //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
                    });
                });
            }
        });

        var noticeTableRender = table.render({
            elem: '#noticeTableList',
            url: baseURL + "/notice/queryAllNotice.do",
            id: 'noticeTableId',
            method: 'post',
            height: '500',
            skin: 'row',
            loading: 'true',//是否显示加载条
            even: 'true',
            cols: [[
                {field: 'id', title: '编号', width: 80},
                {field: 'noticeTitle', title: '标题', width: 200},
                {field: 'createName', title: '创建人', width: 100},
                {field: 'createTime', title: '时间', width: 250},
                {fixed: 'right', title: '操作', width: 200, toolbar: '#noticeBar'}
            ]],
            page: true,
            limit: 10//默认显示10条
        });
});//layui结束
var vm = new Vue({
  el:'#noticeDetailDiv',
    data : {
      noticeTitle:'',
      noticeDesc:''
    },
    methods: {
    }
});