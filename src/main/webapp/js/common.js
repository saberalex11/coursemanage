layui.config({
  base: "../../js/"
}).use(['layer','jquery'],function() {
  var layer = parent.layer === undefined ? layui.layer : parent.layer,
      $ = layui.jquery;

  //重写alert
  window.alert = function(msg, callback){
    layer.alert(msg, function(index){
      layer.close(index);
      if(typeof(callback) === "function"){
        callback("ok");
      }
    });
  }

//重写confirm式样框
  window.confirm = function (msg, callback) {
    layer.confirm(msg, {btn: ['确定','取消']},
        function(){//确定事件
          if(typeof(callback) === "function"){
            callback("ok");
          }
    });
  }

  //工具集合Tools
  window.T = {};

// 获取请求参数
// 使用示例
// location.href = http://localhost/index.html?id=123
// T.p('id') --> 123;
  var url = function(name) {
    var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if(r!=null)return  unescape(r[2]); return null;
  };
  T.p = url;

//jquery全局配置
  $.ajaxSetup({
    dataType: "json",
    cache: false,
    complete: function(xhr) {
      //token过期，则跳转到登录页面
      //   console.log("xhr=="+JSON.stringify(xhr));
      if(xhr.responseJSON !== undefined){
        // parent.location.href = 'login.jsp';
      }
    }
  });

//权限判断
  window.hasPermission =function (permission) {
    if (window.parent.permissions.indexOf(permission) > -1) {
      return true;
    } else {
      return false;
    }
  }

  //角色判断
  window.hasRole = function (role) {
    return window.parent.roles.includes(role);
  }

  // 校验手机号码
  $.checkPhone = function (tel) {
    if (tel == "") {
      return false;
    }
    if (!(/^1[34578]\d{9}$/.test(tel))) {
      return false;
    }
    return true;
  };

  // 校验邮件地址
  $.checkEmail = function(email) {
    if (email == "") {
      return false;
    }
    if (!email.match(/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/)) {
      return false;
    }
    return true;
  };

});

//请求前缀
//var baseURL = "http://www.geec.com/";
//var baseURL = "/context/";
var baseURL = location.pathname.substr(0, location.pathname.indexOf('/', 1))+"/";
//登录token
var token = localStorage.getItem("token");
if(token == 'null'){
  parent.location.href = baseURL + 'login.html';
}

/**获取 格式化日期  例如：yyyy-MM-dd hh:mm:ss**/
Date.prototype.format = function(format) {
  var date = {
    "M+": this.getMonth() + 1,
    "d+": this.getDate(),
    "h+": this.getHours(),
    "m+": this.getMinutes(),
    "s+": this.getSeconds(),
    "q+": Math.floor((this.getMonth() + 3) / 3),
    "S+": this.getMilliseconds()
  };
  if (/(y+)/i.test(format)) {
    format = format.replace(RegExp.$1, (this.getFullYear() + '').substr(4 - RegExp.$1.length));
  }
  for (var k in date) {
    if (new RegExp("(" + k + ")").test(format)) {
      format = format.replace(RegExp.$1, RegExp.$1.length == 1
          ? date[k] : ("00" + date[k]).substr(("" + date[k]).length));
    }
  }
  return format;
}