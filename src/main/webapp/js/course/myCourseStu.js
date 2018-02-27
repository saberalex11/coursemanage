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
        courseTableRender.reload({
            where: {
                'courseName': data.field.courseName,
                'teacherName' : data.field.teacherName
            }
        });
    });
    var courseTableRender = table.render({
        elem: '#courseTableList',
        url: baseURL + "/course/queryStudentCourse.do",
        id: 'courseTableId',
        method: 'post',
        height: '500',
        skin: 'row',
        loading: 'true',//是否显示加载条
        even: 'true',
        cols: [[
            {field: 'id', title: '编号', width: 80},
            {field: 'studentName', title: '学生名称', width: 120},
            {field: 'teacherName', title: '教师名称', width: 120},
            {field: 'courseName', title: '课程名称', width: 100},
            {fixed: 'right', title: '操作', width: 150, toolbar: '#courseBar'}
        ]],
        page: true,
        limit: 10//默认显示10条
    });

    /**监听工具条*/
    table.on('tool(courseTable)', function (obj) {
        var data = obj.data; //获得当前行数据
        var layEvent = obj.event; //获得 lay-event 对应的值
        if (layEvent === 'unSelectCourse') {
            var param = {
                'id':data.id
            };
            $.post(baseURL+"/course/unSelectCourse.do",param,function (data){
                var code = data.code;
                if(code === 0){
                    layer.alert('退课成功', function(index){
                        //do something
                        layer.close(index);
                        courseTableRender.reload({
                            where: {
                                'courseName': $("input[name='courseName']").val(),
                                'teacherName' : $("input[name='teacherName']").val()
                            }
                        });
                    })
                }else{
                    layer.alert(data.msg, function(index){
                        //do something
                        layer.close(index);
                    })
                }
            });
        }
    });
});//layui结束
var vm = new Vue({
    el:'#productManageApp',
    data : {
    },
    methods: {
    }
});