layui.use(["jquery", "element", "table", "layer", "form", "laydate"], function () {
    var $ = layui.$;
    var element = layui.element
    var table = layui.table;
    var layer = layui.layer;
    var form = layui.form;
    var laydate = layui.laydate;

    //时间插件
    laydate.render({
        elem: '#open'
        , type: 'date'
    });

    /*表单验证*/
    form.verify({
        userName: function (value, item) { //value：表单的值、item：表单的DOM对象
            if (!new RegExp("^[a-zA-Z0-9_\u4e00-\u9fa5\\s·]+$").test(value)) {
                return '持卡人姓名不能有特殊字符';
            }
            if (/(^\_)|(\__)|(\_+$)/.test(value)) {
                return '持卡人姓名首尾不能出现下划线\'_\'';
            }
            if (/^\d+\d+\d$/.test(value)) {
                return '持卡人姓名不能全为数字';
            }
        },
        userAddress: function (value, item) { //value：表单的值、item：表单的DOM对象
            if (!new RegExp("^[a-zA-Z0-9_\u4e00-\u9fa5\\s·]+$").test(value)) {
                return '家庭地址不能含有特殊字符';
            }
            if (/(^\_)|(\__)|(\_+$)/.test(value)) {
                return '家庭地址首尾不能出现下划线\'_\'';
            }
            if (/^\d+\d+\d$/.test(value)) {
                return '家庭地址不能全为数字';
            }
        },
        cardId: [
            /^([\d]{4})([\d]{4})([\d]{4})([\d]{4})([\d]{3})$/
            , '银行卡号必须是19位，格式不正确'
        ]
        //我们既支持上述函数式的方式，也支持下述数组的形式
        //数组的两个值分别代表：[正则匹配、匹配不符时的提示文字]
        , transPwd: [
            /^[\S]{6,12}$/
            , '密码必须6到12位，且不能出现空格'
        ]
    });


    //监听提交
    form.on('submit(formDemo)', function (data) {
        $.post("/operator/addUser", data.field, function (resp) {
            layer.msg(resp, {
                offset: ["240px", "430px"],
                time: 3000
            });
            // if (resp) {
            //     setTimeout(function () {
            //         location.reload();
            //     }, 3000);
            // }
        });
        return false;
    });
});