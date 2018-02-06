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
                'supplierSimpleName': data.field.supplierSimpleName
            }
        });
    });


        /**监听工具条*/
        table.on('tool(productTable)', function (obj) {
            var data = obj.data; //获得当前行数据
            var layEvent = obj.event; //获得 lay-event 对应的值
            var id = data.supplierId;
            if (layEvent === 'watch') {
                supplierContactTable.reload({
                    where: {
                        'supplierId': id
                    }
                });
                layui.layer.open({
                    type: 1,
                    offset: '50px',
                    skin: 'layui-layer-molv',
                    title: "供货商联系人",
                    area: ['1200px', '300px'],
                    closeBtn: 1,
                    shadeClose: true,
                    content: $('#supplierContactTableDiv') //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
                });
            }
        });

        var prodcutTableRender = table.render({
            elem: '#productTableList',
            url: baseURL + "/suppiler/querySupplier.do",
            id: 'productTableId',
            method: 'post',
            height: '500',
            skin: 'row',
            loading: 'true',//是否显示加载条
            even: 'true',
            cols: [[
                {field: 'supplierId', title: '编号', width: 80},
                {field: 'supplierSimpleName', title: '供应商简称', width: 120},
                {field: 'supplierName', title: '供应商全称', width: 100},
                {field: 'owner', title: '负责人', width: 120},
                {field: 'title', title: '负责人称谓', width: 120},
                {field: 'telephone', title: '电话', width: 100},
                {field: 'mobilePhone', title: '移动电话', width: 200},
                {field: 'fax', title: '传真', width: 200},
                {field: 'companyAddress', title: '公司地址', width: 200},
                {field: 'factoryAddress', title: '工厂地址', width: 200},
                {field: 'lastPurchaseDate', title: '最后进货日期', width: 200},
                {fixed: 'right', title: '查看联系人', align: 'center', width: 200, toolbar: '#productBar'}
            ]],
            page: true,
            limit: 10//默认显示10条
        });



    var supplierContactTable = table.render({
        elem: '#supplierContactTable',
        url: baseURL + "/suppiler/querySupplierContactById.do",
        id: 'supplierTableId',
        method: 'post',
        height: '500',
        skin: 'row',
        loading: 'true',//是否显示加载条
        even: 'true',
        cols: [[
            {field: 'contactId', title: '编号', width: 80},
            {field: 'chineseName', title: '中文名', width: 120},
            {field: 'englishName', title: '英文名', width: 100},
            {field: 'title', title: '称谓', width: 120},
            {field: 'telephone', title: '电话', width: 100},
            {field: 'mobilePhone', title: '移动电话', width: 200},
            {field: 'supplierId', title: '供货商编号', width: 200},
        ]],
        where:{
            "supplierId":-1
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