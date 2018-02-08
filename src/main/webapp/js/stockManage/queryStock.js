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
                'prodcutName': data.field.prodcutName,
                'stockStart' : data.field.stockStart,
                'stockEnd' : data.field.stockEnd
            }
        });
    });
        var prodcutTableRender = table.render({
            elem: '#productTableList',
            url: baseURL + "/product/queryProduct.do",
            id: 'productTableId',
            method: 'post',
            height: '500',
            skin: 'row',
            loading: 'true',//是否显示加载条
            even: 'true',
            cols: [[
                {field: 'id', title: '编号', width: 80},
                {field: 'productName', title: '产品名称', width: 120},
                {field: 'safeStock', title: '安全存量', width: 100},
                {field: 'suggestBuyPrice', title: '建议购买价', width: 120},
                {field: 'suggestSalePrice', title: '建议销售价', width: 120},
                {field: 'quantity', title: '库存', width: 100},
                {field: 'lastPurchaseDate', title: '最后进货时间', width: 200},
                {field: 'lastDeliveryDate', title: '最后送货日期', width: 200}
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