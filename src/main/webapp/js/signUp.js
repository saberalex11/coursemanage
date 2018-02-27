layui.config({
  base : "js/"
});
var vm = new Vue({
    el:'#dqapp',
    data:{
        userAccount: '',
        password: '',
        rePassword: '',
        error: false,
        errorMsg: '',
        name: '',
        course:{
            courseId:'',
            courseName:''
        },
        courses:[]
    },
    beforeCreate: function(){
        if(self != top){
            top.location.href = self.location.href;
        }
    },
    methods: {
        signUp: function () {
            if(vm.userAccount.length <2  || vm.userAccount.length > 8){
                layer.msg("用户名长度为2-8");
                return;
            }
            if(vm.password.length <6  || vm.password.length > 20){
                layer.msg("密码长度为6-20");
                return;
            }
            if(vm.password !== vm.rePassword){
                layer.msg("两次密码不一致");
                return;
            }
            var accountType = $("select[name=accountType]").val();
            var data = "account="+vm.userAccount+"&password="+hex_sha256(vm.password)+"&accountType="+accountType+"&name="+vm.name;
            if(accountType == "1"){
                data += "&courseId="+$("select[name=courseId]").val();
            }
            var loading = top.layer.msg('注册中...请稍候',{icon: 16,time:false,shade:0.8});
            $.ajax({
                type: "POST",
                url: "sys/signUp.do",
                data: data,
                dataType: "json",
                success: function(r){
                    top.layer.close(loading);
                    if(r.code === 0){//成功
                        layer.alert('注册成功', function(index){
                            layer.close(index);
                            parent.location.href ='login.jsp';
                        });
                    }else{
                        layer.msg(r.msg);
                    }
                },
                error: function(){
                    top.layer.close(loading);
                }
            });
        }
    }
});
layui.use(['jquery','form'], function () {
  var $ = layui.jquery,
      form = layui.form;

    form.render('select');

    $.post(baseURL+"course/queryAllCourse.do",null,function(data){
        var courseData = data.data;
        var htmlStr='';
        $.each(courseData,function(idx,obj){
           // vm.course = {};
           // vm.course.courseId = obj.id;
           // vm.course.courseName = obj.courseName;
           // vm.courses.push(vm.course);
           // vm.course = {};
            htmlStr += "<option  value=\""+obj.id+"\">"+obj.courseName+"</option>"
        });
        $("select[name=courseId]").html(htmlStr);
        form.render('select');
    });

    form.on('select(typeFilter)', function(data){
        if(data.value == "1"){
            $("#courseSelect").removeClass("layui-hide");
        }else{
            $("#courseSelect").addClass("layui-hide");
        }
    });
});//layui模块加载完毕
