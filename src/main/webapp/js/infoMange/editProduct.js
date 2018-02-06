layui.config({
    version: '1509633239420' //为了更新 js 缓存，可忽略
});
var vm = new Vue({
    el:'#editProductApp',
    data : {
        productName:'',
        suggestBuyPrice:'',
        suggestSalePrice:'',
        safeStock:'',
        quantity:'',
        id:''
    },
    methods:{
    }
});
layui.use(['form', 'laypage', 'layer', 'table', 'jquery', 'upload', 'element'], function(){
    var layer = layui.layer //弹层
        ,form = layui.form//表单
        ,$ = layui.jquery;


    var productId = localStorage.editProductId;
    vm.id = productId;
    var param = {
        "productId":productId
    };
    $.post(baseURL+"/product/queryProductbyId.do",param,function (data) {
        vm.productName = data.data.productName;
        vm.suggestBuyPrice = data.data.suggestBuyPrice;
        vm.suggestSalePrice = data.data.suggestSalePrice;
        vm.safeStock = data.data.safeStock;
        vm.quantity = data.data.quantity;
    });

    form.on('submit(productSubmit)', function(data){
        $.post(baseURL+"/product/saveProduct.do",data.field,function (data){
            layer.alert('保存成功', function(index){
                //do something
                layer.close(index);
                window.location.href="productManage.jsp";
            });
        });
    });
});

