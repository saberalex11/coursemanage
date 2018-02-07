layui.config({
    version: '1509633239420' //为了更新 js 缓存，可忽略
});
var vm = new Vue({
    el:'#newProductApp',
    data : {
    },
    methods:{
        addDetail:function(){
            layui.layer.open({
                type: 1,
                offset: '50px',
                skin: 'layui-layer-molv',
                title: "添加商品明细",
                area: ['700px', '350px'],
                closeBtn: 1,
                shadeClose: true,
                content: $('#productDetail') //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
            });
        }
    }
});
layui.use(['form', 'laypage', 'layer', 'table', 'jquery', 'upload', 'element','laydate'], function(){
    var layer = layui.layer //弹层
        ,form = layui.form//表单
        ,$ = layui.jquery
        ,laydate = layui.laydate;

    //初始化时间空控件
    laydate.render({
        elem: '#purchaseDate', //指定元素
        type:'datetime'
    });

    //加载供货商
    $.post(baseURL+"/suppiler/queryAllSupplier.do",null,function(data){
        var supplierData = data.data;
        var htmlStr="";
        $.each(supplierData, function(idx, obj) {
            htmlStr += "<option value=\""+obj.supplierId+"\">"+obj.supplierSimpleName+"</option>"
        });
        $("[name='supplier']").html(htmlStr);
        layui.form.render('select');
    });

    //加载商品
    $.post(baseURL+"/product/queryAllProduct.do",null,function(data){
        var htmlStr="";
        $.each(data, function(idx, obj) {
            htmlStr += "<option name='productDetailOption' value=\""+obj.id+"\" data-suggestBuyPrice=\""+obj.suggestBuyPrice+"\">"+obj.productName+"</option>"
            if(idx === 0){
                $("[name='suggestBuyPrice']").val(obj.suggestBuyPrice);
                $("[name='productId']").val(obj.id);
            }
        });
        $("[name='productName']").html(htmlStr);
        layui.form.render('select');
    });

    //监听商品明细变动,改变值
    form.on('select(productSelect)', function(data){
        var selectedOp = $("option[name='productDetailOption']:selected");
        $("[name='suggestBuyPrice']").val(selectedOp.attr("data-suggestBuyPrice"));
        $("[name='productId']").val(selectedOp.val());
    });

    form.on('submit(productSubmit)', function(data){
        $.post(baseURL+"/product/addProduct.do",data.field,function (data){
            layer.alert('保存成功', function(index){
                //do something
                layer.close(index);
                window.location.href="productManage.jsp";
            });
        });
    });
});

