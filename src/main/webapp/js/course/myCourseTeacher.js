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
                'studentName': data.field.studentName
            }
        });
    });
    var courseTableRender = table.render({
        elem: '#courseTableList',
        url: baseURL + "/course/queryTeacherCourse.do",
        id: 'courseTableId',
        method: 'post',
        height: '500',
        skin: 'row',
        loading: 'true',//是否显示加载条
        even: 'true',
        cols: [[
            {field: 'id', title: '编号', width: 80},
            {field: 'teacherName', title: '教师名称', width: 120},
            {field: 'studentName', title: '学生名称', width: 120},
            {field: 'courseName', title: '课程名称', width: 100}
        ]],
        page: true,
        limit: 10//默认显示10条
    });
});//layui结束
var vm = new Vue({
    el:'#productManageApp',
    data : {
    },
    methods: {
    }
});