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

    $.post(baseURL+"course/queryAllCourse.do",null,function(data){
        var courseData = data.data;
        var htmlStr='';
        $.each(courseData,function(idx,obj){
            htmlStr += "<option  value=\""+obj.id+"\">"+obj.courseName+"</option>"
        });
        $("select[name=courseId]").html(htmlStr);
        form.render('select');
    });


    /**监听查询提交*/
    form.on('submit(searchFilter)', function (data) {
        accountTableRender.reload({
            where: {
                'account': data.field.account,
                'name': data.field.name
            }
        });
    });


        /**监听工具条*/
        table.on('tool(accountTable)', function (obj) {
            var data = obj.data; //获得当前行数据
            var layEvent = obj.event; //获得 lay-event 对应的值
            var id = data.id;
            if (layEvent === 'edit') {
                layui.layer.open({
                    type: 1,
                    offset: '50px',
                    skin: 'layui-layer-molv',
                    title: "修改课程",
                    area: ['500px', '400px'],
                    closeBtn: 1,
                    shadeClose: true,
                    content: $('#editCourseDiv'), //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
                    btn: ['确认', '取消'],
                    yes: function(index,layero){
                        var param = {
                            'teacherId':id,
                            'courseId':$("select[name=courseId]").val()
                        };
                        $.post(baseURL+"course/updateTeacherCourse.do",param,function (data){
                            layer.msg('修改成功', {
                                icon: 1,
                                time: 2000 //2秒关闭（如果不配置，默认是3秒）
                            },function(){
                                window.layer.closeAll();
                                parent.layer.closeAll();
                                parent.layui.layer.closeAll();
                                layui.layer.closeAll();
                                accountTableRender.reload({
                                    where: {
                                        'account': $("input[name=account]").val(),
                                        'name': $("input[name=name]").val()
                                    }
                                });
                            });
                        });
                    },
                    btn2: function(index,layero){
                        // window.layer.close(index);
                    }
                });
            }
        });

        var accountTableRender = table.render({
            elem: '#accountTableList',
            url: baseURL + "sys/user/listTeacherAccount.do",
            id: 'accountTableId',
            method: 'post',
            height: '500',
            skin: 'row',
            loading: 'true',//是否显示加载条
            even: 'true',
            cols: [[
                {field: 'id', title: '编号', width: 80},
                {field: 'account', title: '账号', width: 100},
                {field: 'name', title: '名称', width: 100},
                {field: 'courseName', title: '课程名称', width: 100},
                {field: 'createTime', title: '时间', width: 250},
                {fixed: 'right', title: '操作', width: 300, toolbar: '#accountBar'}
            ]],
            page: true,
            limit: 10//默认显示10条
        });
});//layui结束

var vm1 = new Vue({
    el:'#editCourseDiv',
    data : {
        name:''
    },
    methods: {
    }
});