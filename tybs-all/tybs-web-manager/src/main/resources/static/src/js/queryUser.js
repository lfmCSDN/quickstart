layui.use(['table', 'form', 'jquery'], function () {
    var table = layui.table;
    var form = layui.form;
    var $ = layui.$;

    form.on('submit(formDemo)', function (data) {
        //第一个实例
        table.render({
            elem: '#User',
            height: 600,
            width: 1053,
            url: '/operator/getUser', //数据接口,
            // page: true, //开启分页
            where: data.field,
            cols: [[ //表头
                {field: 'userName', title: '姓名', width: 100, edit: 'text'}
                , {field: 'userCardId', title: '身份证号', width: 200, edit: 'text'}
                , {field: 'cardId', title: '卡号', width: 200, edit: 'text'}
                , {field: 'userTel', title: '手机号', width: 103, edit: 'text'}
                , {field: 'cardType', title: '卡类型', width: 100, edit: 'text'}
                , {field: 'stat', title: '卡状态', width: 100, edit: 'text'}
                , {field: 'oveage', title: '账户余额', width: 100, edit: 'text'}
                , {field: 'openDate', title: '开户日期', width: 130, edit: 'text'}
            ]]
        });
        return false;
    });
    table.on('tool', function (obj) {
        var info = obj.data; //获得当前行数据
        var layEvent = obj.event; //获得 lay-event 对应的值
        var tr = obj.tr; //获得当前行 tr 的DOM对象
            layer.confirm('确定注销？', function (index) {
                // obj.del();
                $.post("/operator/deleteUser", info, function (resp) {
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
    })
});