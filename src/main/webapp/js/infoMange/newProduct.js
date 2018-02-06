layui.config({
    version: '1509633239420' //为了更新 js 缓存，可忽略
});
var vm = new Vue({
    el:'#newProductApp',
    data : {
    },
    methods:{
    }
});
layui.use(['form', 'laypage', 'layer', 'table', 'jquery', 'upload', 'element'], function(){
    var layer = layui.layer //弹层
        ,form = layui.form//表单
        ,$ = layui.jquery;


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

