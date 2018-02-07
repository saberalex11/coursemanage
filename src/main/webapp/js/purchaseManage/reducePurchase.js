layui.config({
    version: '1509633239420' //为了更新 js 缓存，可忽略
});
var vm = new Vue({
    el:'#newProductApp',
    data : {
        product:{
            sortId:'',
            id:'',
            productName:'',
            quantity:'',
            price:'',
            amount:''
        },
        products:[],
        layerWindow:'',
        amount:'0.00'
    },
    methods:{
        addDetail:function(){
            vm.layerWindow = layui.layer.open({
                type: 1,
                offset: '50px',
                skin: 'layui-layer-molv',
                title: "添加商品明细",
                area: ['800px', '450px'],
                closeBtn: 1,
                shadeClose: true,
                content: $('#productDetail') //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
            });
        },
        delDetail:function(product){
            //移除元素
            vm.products.splice(product.sortId, 1);
            var length = vm.products.length;
            //调整后续元素的sortid值
            for( var i = 0; i < length ; i++) {
                if(product.sortId < vm.products[i].sortId) {
                    vm.products[i].sortId -= 1;
                }
            }
            vm.countAmount();
        },
        editDetail:function(product){

        },
        countAmount:function(){
            setTimeout(function(){
                var amount =  parseFloat(0);
                $("input[name=purchaseAmount]").each(function(){
                    amount += parseFloat($(this).val());
                });
                amount = amount.toFixed(2);
                vm.amount = amount;
                },500);
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
        $("[name='supplierId']").html(htmlStr);
        layui.form.render('select');
    });

    //加载商品
    $.post(baseURL+"/product/queryAllProduct.do",null,function(data){
        var htmlStr="";
        $.each(data, function(idx, obj) {
            htmlStr += "<option name='productDetailOption' value=\""+obj.productName+"\" data-id='"+obj.id+"' data-suggestBuyPrice=\""+obj.suggestBuyPrice+"\">"+obj.productName+"</option>"
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
        $("[name='productId']").val(selectedOp.attr("data-id"));
    });

    //提交所有数据
    form.on('submit(productSubmit)', function(data){
        var detailList=[];

        $("div[data-flag='productDetailInfo']").each(function(){
            var detail={};
            detail.productId = $(this).find('input[name="productId"]').val();
            detail.purchaseQuantity = $(this).find('input[name="purchaseQuantity"]').val();
            detail.purchaseUnitPrice = $(this).find('input[name="purchaseUnitPrice"]').val();
            detail.purchaseAmount = $(this).find('input[name="purchaseAmount"]').val();
            detailList.push(detail);
        });
        var param = {
            'purchaseMaster':data.field,
            'purchaseDetail':detailList
        };
        $.ajax({
            type: "POST",
            url: baseURL+"purchase/reducePurchase.do",
            contentType: "application/json", //必须有
            dataType: "json", //表示返回值类型，不必须
            data: JSON.stringify(param),
            success: function (data) {
                if(data.code != 0){
                    layer.msg(data.msg, {icon: 2});
                }else{
                    layer.alert('添加成功', function(index){
                        //do something
                        layer.close(index);
                        window.location.href="reducePurchase.jsp";
                    });
                }
            }
        });
    });

    //明细添加提交
    form.on('submit(purchaseDetailSubmit)', function(data){
        var productData = data.field;
        vm.product={};
        vm.product.sortId = vm.products.length;
        vm.product.id = productData.productId;
        vm.product.productName = productData.productName;
        vm.product.price = productData.purchaseUnitPrice;
        vm.product.quantity = productData.purchaseQuantity;
        vm.product.amount = parseFloat(productData.purchaseUnitPrice * productData.purchaseQuantity).toFixed(2);
        vm.products.push(vm.product);
        vm.product={};
        $("input[name='purchaseQuantity']").val('');
        $("input[name='purchaseUnitPrice']").val('');
        layui.layer.close(vm.layerWindow);
        vm.countAmount();
    });



});

