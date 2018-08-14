layui.use(['table', 'form', 'jquery'], function () {
    var table = layui.table;
    var form = layui.form;
    var $ = layui.$;

    form.on('submit(formDemo)', function (data) {
        //第一个实例
        table.render({
            elem: '#queryUser',
            height: 400,
            width: 880,
            url: '/admin/getOperator', //数据接口,
            // page: true, //开启分页
            where: data.field,
            cols: [[ //表头
                {field: 'userOperInfoId', title: '操作员号', width: 120}
                , {field: 'operName', title: '姓名', width: 120, edit: 'text'}
                , {field: 'operCardId', title: '身份证号', width: 120, edit: 'text'}
                , {field: 'operMobilPhone', title: '手机号', width: 120, edit: 'text'}
                , {field: 'operEmail', title: '邮箱', width: 120, edit: 'text'}
                , {field: 'operStatu', title: '状态', width: 120, edit: 'text'}
                , {fixed: 'right', width: 160, title: '操作', toolbar: '#oper'}
            ]]
        });
        return false;
    });
    table.on('tool', function (obj) {
        var info = obj.data; //获得当前行数据
        var layEvent = obj.event; //获得 lay-event 对应的值
        // var tr = obj.tr; //获得当前行 tr 的DOM对象

        if (layEvent === 'del') {
            layer.confirm('确定删除？', function (index) {
                $.post("/admin/deleteOperator", info, function (resp) {
                    layer.msg(resp, {
                        offset: "auto",
                        time: 3000
                    });
                    if (resp) {
                        setTimeout(function () {
                            location.reload();
                        }, 3000);
                    }
                });

                return false;
            });
        } else if (layEvent === 'edit') {
            layer.confirm('确定修改？', function (index) {
                $.post("/admin/updateOperator", info, function (resp) {
                    layer.msg(resp, {
                        offset: 'auto',
                        time: 3000
                    });
                    if (resp) {
                        setTimeout(function () {
                            location.reload();
                        }, 3000);
                    }
                });
                return false;
            })
        }
    })
});