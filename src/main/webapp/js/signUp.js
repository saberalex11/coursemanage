layui.config({
  base : "js/"
}).use(['jquery','layer','carousel'], function () {
  var $ = layui.jquery,
      layer = layui.layer,
      carousel = layui.carousel;

  /**背景图片轮播*/
  carousel.render({
    elem: '#login_carousel',
    width: '100%',
    height: '100%',
    interval:2000,
    arrow: 'none',
    anim: 'fade',
    indicator:'none'
  });

var vm = new Vue({
  el:'#dqapp',
  data:{
    userAccount: '',
    password: '',
    rePassword: '',
    error: false,
    errorMsg: ''
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
      var data = "userAccount="+vm.userAccount+"&password="+hex_sha256(vm.password);
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
          top.layer.close(loginLoading);
        }
      });
    }
  }
});

});//layui模块加载完毕