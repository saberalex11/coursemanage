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
        accountTableRender.reload({
            where: {
                'account': data.field.account,
                'name': data.field.name
            }
        });
    });


        /**监听工具条*/
        table.on('tool(accountTable)', function (obj) {
            var data = obj.data; //获得当前行数据
            var layEvent = obj.event; //获得 lay-event 对应的值
            var id = data.id;
            if (layEvent === 'edit') {
                var param = {
                    "id":id
                };
                layui.layer.open({
                    type: 1,
                    offset: '50px',
                    skin: 'layui-layer-molv',
                    title: "修改名称",
                    area: ['500px', '180px'],
                    closeBtn: 1,
                    shadeClose: true,
                    content: $('#editNameDiv'), //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
                    btn: ['确认', '取消'],
                    yes: function(index,layero){
                        var param = {
                            'id':id,
                            'name':vm1.name
                        };
                        $.post(baseURL+"sys/user/updateAccount.do",param,function (data){
                            layer.msg('修改成功', {
                                icon: 1,
                                time: 2000 //2秒关闭（如果不配置，默认是3秒）
                            },function(){
                                window.layer.closeAll();
                                parent.layer.closeAll();
                                parent.layui.layer.closeAll();
                                layui.layer.closeAll();
                                accountTableRender.reload({
                                    where: {
                                        'account': $("input[name=account]").val(),
                                        'name': $("input[name=name]").val()
                                    }
                                });
                            });
                        });
                    },
                    btn2: function(index,layero){
                        // window.layer.close(index);
                    }
                });
            }else if (layEvent === 'delete') {
                var param = {
                    "id":id
                };
                $.post(baseURL+"sys/user/deleteAccount.do",param,function (data){
                    layer.alert('删除成功', function(index){
                        //do something
                        layer.close(index);
                        accountTableRender.reload({
                            where: {
                                'account': $("input[name='account']").val(),
                                'name': $("input[name='name']").val()
                            }
                        });
                    });
                });
            }else if(layEvent === 'reset'){
                var param = {
                    "id":id
                };
                layui.layer.open({
                    type: 1,
                    offset: '50px',
                    skin: 'layui-layer-molv',
                    title: "修改密码",
                    area: ['500px', '180px'],
                    closeBtn: 1,
                    shadeClose: true,
                    content: $('#resetDiv'), //这里content是一个DOM，注意：最好该元素要存放在body最外层，否则可能被其它的相对元素所影响
                    btn: ['确认', '取消'],
                    yes: function(index,layero){

                        if(vm.password.length <6  || vm.password.length > 20){
                            layer.msg("密码长度为6-20");
                            return;
                        }

                        var param = {
                           'id':id,
                           'password':hex_sha256(vm.password)
                        };
                        $.post(baseURL+"sys/user/resetPassword.do",param,function (data){
                            layer.msg('重置成功', {
                                icon: 1,
                                time: 2000 //2秒关闭（如果不配置，默认是3秒）
                            },function(){
                                window.layer.closeAll();
                                parent.layer.closeAll();
                                parent.layui.layer.closeAll();
                                layui.layer.closeAll();
                                accountTableRender.reload({
                                    where: {
                                        'account': $("input[name=account]").val(),
                                        'name': $("input[name=name]").val()
                                    }
                                });
                            });
                        });
                    },
                    btn2: function(index,layero){
                        // window.layer.close(index);
                    }
                });
            }
        });

        var accountTableRender = table.render({
            elem: '#accountTableList',
            url: baseURL + "sys/user/listAccount.do",
            id: 'accountTableId',
            method: 'post',
            height: '500',
            skin: 'row',
            loading: 'true',//是否显示加载条
            even: 'true',
            cols: [[
                {field: 'id', title: '编号', width: 80},
                {field: 'account', title: '账号', width: 100},
                {field: 'name', title: '名称', width: 100},
                {field: 'accountType', title: '类型', width: 100,templet: '#TypeTpl'},
                {field: 'createTime', title: '时间', width: 250},
                {fixed: 'right', title: '操作', width: 300, toolbar: '#accountBar'}
            ]],
            page: true,
            limit: 10//默认显示10条
        });
});//layui结束
var vm = new Vue({
  el:'#resetDiv',
    data : {
        password:''
    },
    methods: {
    }
});

var vm1 = new Vue({
    el:'#editNameDiv',
    data : {
        name:''
    },
    methods: {
    }
});