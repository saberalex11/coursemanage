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
                'prodcutName': data.field.prodcutName
            }
        });
    });


        /**监听工具条*/
        table.on('tool(productTable)', function (obj) {
            var data = obj.data; //获得当前行数据
            var layEvent = obj.event; //获得 lay-event 对应的值
            var productId = data.id;
            //修改文章数据
            if (layEvent === 'edit') {
                localStorage.editProductId = productId;
                window.location.href = "../infoManage/editProduct.jsp";
            }else if (layEvent === 'delete') {
                var param = {
                    "productId":productId
                };
                $.post(baseURL+"/product/deleteProduct.do",param,function (data){
                    layer.alert('删除成功', function(index){
                        //do something
                        layer.close(index);
                        prodcutTableRender.reload({
                            where: {
                                'prodcutName': $("input[name='prodcutName']").val()
                            }
                        });
                    });
                });
            }
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
                {field: 'lastDeliveryDate', title: '最后送货日期', width: 200},
                {fixed: 'right', title: '操作', align: 'center', width: 200, toolbar: '#productBar'}
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