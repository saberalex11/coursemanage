<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>采购入库</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta http-equiv="Access-Control-Allow-Origin" content="*">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="shortcut icon" href="favicon.ico">
    <link rel="stylesheet" href="../layui/css/layui.css">
    <link rel="stylesheet" href="../css/table-header.css">
    <link rel="stylesheet" href="../css/global.css">
</head>
<body>
<div class="layui-container" id="newProductApp">
    <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
        <legend>采购入库</legend>
    </fieldset>

    <form class="layui-form" action="">
        <div class="layui-form-item">
            <label class="layui-form-label"><em class="require">*</em>供货商</label>
            <div class="layui-input-block">
                <select name="supplierId" lay-verify="required" lay-search="">
                </select>
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label"><em class="require">*</em>采购日期</label>
            <div class="layui-input-block">
                <input type="text" id="purchaseDate" name="purchaseDate" lay-verify="required" autocomplete="off" placeholder="采购日期" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">总金额</label>
            <div class="layui-input-block">
                <input v-model="amount" readonly type="text" name="amount" lay-verify="required|number" autocomplete="off" placeholder="总金额" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item" pane="">
            <label class="layui-form-label"><em class="require">*</em>采购明细</label>
            <div class="layui-input-block">
                <button type="button" class="layui-btn layui-btn-normal" @click="addDetail">增加</button>
            </div>
        </div>

        <div class="layui-row" style="padding-top:10px;padding-bottom:20px" v-for="product in products">
                <div class="layui-col-md9" data-flag="productDetailInfo">
                    <div class="layui-form-item" pane="">
                        <label class="layui-form-label">商品编号</label>
                        <div class="layui-input-block">
                            <input name="productId" type="text" readonly lay-verify="title" v-model="product.id" class="layui-input"/>
                        </div>
                    </div>
                    <div class="layui-form-item" pane="">
                        <label class="layui-form-label">商品名称</label>
                        <div class="layui-input-block">
                            <input type="text" readonly lay-verify="title" v-model="product.productName" class="layui-input"/>
                        </div>
                    </div>
                    <div class="layui-form-item" pane="">
                        <label class="layui-form-label">单价</label>
                        <div class="layui-input-block">
                            <input name="purchaseUnitPrice" type="text" readonly lay-verify="title" v-model="product.price" class="layui-input"/>
                        </div>
                    </div>
                    <div class="layui-form-item" pane="">
                        <label class="layui-form-label">数量</label>
                        <div class="layui-input-block">
                            <input name="purchaseQuantity" type="text" readonly lay-verify="title" v-model="product.quantity" class="layui-input"/>
                        </div>
                    </div>
                    <div class="layui-form-item" pane="">
                        <label class="layui-form-label">金额</label>
                        <div class="layui-input-block">
                            <input name="purchaseAmount"  type="text" readonly lay-verify="title" v-model="product.amount" class="layui-input"/>
                        </div>
                    </div>
                    <div class="layui-form-item" pane="">
                        <div class="layui-input-block">
                            <%--<button type="button" class="layui-btn layui-btn-small"  @click="editDetail(product)">修改本条</button>--%>
                            <button type="button" class="layui-btn layui-btn-danger layui-btn-small"  @click="delDetail(product)">删除本条</button>
                        </div>
                    </div>
                </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-input-block">
                <button type="button" class="layui-btn" lay-submit="" lay-filter="productSubmit">提交</button>
            </div>
        </div>
    </form>
</div>

<div id="productDetail" style="display: none">
    <div class="layui-container" style="width: 700px;padding-top: 25px">
        <form class="layui-form" action="">
            <input type="hidden" name="productId"/>
            <div class="layui-form-item">
                <label class="layui-form-label"><em class="require">*</em>商品</label>
                <div class="layui-input-block">
                    <select name="productName" lay-verify="required" lay-search="" lay-filter="productSelect">
                    </select>
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">建议购买价</label>
                <div class="layui-input-block">
                    <input readonly type="text" name="suggestBuyPrice" lay-verify="number" autocomplete="off" placeholder="建议购买价" class="layui-input">
                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label"><em class="require">*</em>单价</label>
                <div class="layui-input-block">
                    <input  type="text" name="purchaseUnitPrice" lay-verify="required|number" autocomplete="off" placeholder="单价" class="layui-input">
                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label"><em class="require">*</em>数量</label>
                <div class="layui-input-block">
                    <input  type="text" name="purchaseQuantity" lay-verify="required|number" autocomplete="off" placeholder="数量" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button type="button" class="layui-btn" lay-submit="" lay-filter="purchaseDetailSubmit">提交</button>
                </div>
            </div>
        </form>
    </div>
</div>

</body>
<script type="text/javascript" src="../layui/layui.js"></script>
<script type="text/javascript" src="../libs/jquery.min.js"></script>
<script type="text/javascript" src="../libs/vue.js"></script>
<script type="text/javascript" src="../js/common.js"></script>
<script type="text/javascript" src="../js/purchaseManage/addPurchase.js"></script>
</html>
