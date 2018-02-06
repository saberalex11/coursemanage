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
    form.on('submit(productSearchFilter)', function (data) {
        prodcutTableRender.reload({
            where: {
                'chineseName': data.field.chineseName
            }
        });
    });
        var prodcutTableRender = table.render({
            elem: '#productTableList',
            url: baseURL + "/salesMan/querySalesMan.do",
            id: 'productTableId',
            method: 'post',
            height: '500',
            skin: 'row',
            loading: 'true',//是否显示加载条
            even: 'true',
            cols: [[
                {field: 'salesManId', title: '编号', width: 80},
                {field: 'chineseName', title: '中文名称', width: 120},
                {field: 'englishName', title: '英文名称', width: 100},
                {field: 'telephone', title: '电话', width: 120},
                {field: 'mobilePhone', title: '移动电话', width: 120},
                {field: 'contactAddress', title: '联络地址', width: 100},
                {field: 'email', title: '电子邮件', width: 200}
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