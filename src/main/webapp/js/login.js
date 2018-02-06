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
    error: false,
    errorMsg: '',
    src: 'captcha.jpg'
  },
  beforeCreate: function(){
    if(self != top){
      top.location.href = self.location.href;
    }
  },
  methods: {
    signUp: function () {
        parent.location.href ='signUp.jsp';
    },
    login: function () {
      var data = "userAccount="+vm.userAccount+"&password="+hex_sha256(vm.password);
      var loginLoading = top.layer.msg('登录中...请稍候',{icon: 16,time:false,shade:0.8});
      $.ajax({
        type: "POST",
        url: "sys/login.do",
        data: data,
        dataType: "json",
        success: function(r){
          top.layer.close(loginLoading);
          if(r.code === 0){//登录成功
              console.log("ddddd");
            parent.location.href ='index.jsp';
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