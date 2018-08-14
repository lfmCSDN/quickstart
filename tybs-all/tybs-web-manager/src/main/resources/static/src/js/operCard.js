layui.use(['table', 'form', 'jquery'], function () {
    var table = layui.table;
    var form = layui.form;
    var $ = layui.$;

    form.on('submit(formDemo)', function (data) {
        //第一个实例
        table.render({
            elem: '#freezeuser',
            height: 300,
            width: 1053,
            url: '/operator/getUser', //数据接口,
            // page: true, //开启分页
            where: data.field,
            cols: [[
                //表头
                {field: 'userName', title: '姓名', width: 83, edit: 'text'}
                , {field: 'userCardId', title: '身份证号', width: 172, edit: 'text'}
                , {field: 'cardId', title: '卡号', width: 182, edit: 'text'}
                , {field: 'userTel', title: '手机号', width: 118, edit: 'text'}
                , {field: 'cardType', title: '卡类型', width: 120, edit: 'text'}
                , {field: 'stat', title: '卡状态', width: 77, edit: 'text'}
                , {fixed: 'right', width: 305, title: '操作', toolbar: '#freeze'}
            ]]
        });
        return false;
    });
    table.on('tool', function (obj) {
        var info = obj.data; //获得当前行数据
        var layEvent = obj.event; //获得 lay-event 对应的值
        var tr = obj.tr; //获得当前行 tr 的DOM对象

        if (layEvent === 'edit1') {
            layer.confirm('确定冻结该银行卡？', function (index) {
                $.ajax({
                    url: "/operator/freezeUser",
                    type: "post",
                    data: info,
                    success: function (result) {
                        layer.msg(result, {
                            offset: ["240px", "430px"],
                            time: 4000
                        });
                    },
                    error: function (result) {
                        layer.open({
                            title: '提示',
                            content: '操作失败'
                        })
                    }
                });
                return false;
                layer.close(index);
            })
        }
        else if (layEvent === 'edit2') {
            layer.confirm('确定激活该银行卡？', function (index) {
                $.ajax({
                    url: "/operator/upFreezeUser",
                    type: "post",
                    data: info,
                    success: function (result) {
                        layer.msg(result, {
                            offset: ["240px", "430px"],
                            time: 4000
                        });
                    },
                    error: function (result) {
                        layer.open({
                            title: '提示',
                            content: '操作错误！'
                        })
                    }
                });
                return false;
                layer.close(index);
            })
        }
        else if (layEvent === 'edit3') {
            layer.confirm('确定挂失该银行卡？', function (index) {
                $.ajax({
                    url: "/operator/lostUser",
                    type: "post",
                    data: info,
                    success: function (result) {
                        layer.msg(result, {
                            offset: ["240px", "430px"],
                            time: 4000
                        });
                    },
                    error: function (result) {
                        layer.open({
                            title: '提示',
                            content: '操作失败'
                        })
                    }
                });
                return false;
                layer.close(index);
            })
        }
        else if (layEvent === 'edit4') {
            layer.confirm('确定激活该银行卡？', function (index) {
                $.ajax({
                    url: "/operator/upLostUser",
                    type: "post",
                    data: info,
                    success: function (result) {
                        layer.msg(result, {
                            offset: ["240px", "430px"],
                            time: 4000
                        });
                    },
                    error: function (result) {
                        layer.open({
                            title: '提示',
                            content: '操作错误！'
                        })
                    }
                });
                return false;
                layer.close(index);
            })
        }
        else if (layEvent === 'del') {
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
        }
    })
});
