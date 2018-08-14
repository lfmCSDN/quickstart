layui.use(["jquery","form","layer"],function () {
    var $ = layui.$;
    var form = layui.form;
    var layer = layui.layer;

    form.on("submit",function (data) {
        $.post("/acct/transferByMoney",data.field,function (resp) {
            layer.msg(resp,{
                offset:["120px","430px"],
                time:2000
            });
            if (resp == '转账成功') {
                setTimeout(function () {
                    location.reload();
                }, 2000);
            }
        });

        return false;
    });
});