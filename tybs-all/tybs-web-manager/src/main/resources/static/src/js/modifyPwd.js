layui.use(["jquery", "form", "layer"], function () {
    var $ = layui.$;
    var form = layui.form;
    var layer = layui.layer;

    form.on("submit", function (data) {
        $.post("/operator/modifyPwd", data.field, function (resp) {
            layer.msg(resp, {
                offset: ["120px", "430px"],
                time: 2000

            });
            if (resp == '密码修改成功') {
                setTimeout(function () {
                    location.reload();
                }, 2000);
            }
        });

        return false;
    });
});