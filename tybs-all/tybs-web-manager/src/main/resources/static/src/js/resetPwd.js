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
            where: data.field,
            cols: [[ //表头
                {field: 'userName', title: '姓名', width: 74, edit: 'text'}
                , {field: 'userCardId', title: '身份证号', width: 180, edit: 'text'}
                , {field: 'cardId', title: '卡号', width: 182, edit: 'text'}
                , {field: 'userTel', title: '手机号', width: 123, edit: 'text'}
                , {field: 'cardType', title: '卡类型', width: 86, edit: 'text'}
                , {field: 'stat', title: '卡状态', width: 81, edit: 'text'}
                , {field: 'oveage', title: '账户余额', width: 90, edit: 'text'}
                , {field: 'openDate', title: '开户日期', width: 122, edit: 'text'}
                , {fixed: 'right', width: 101, title: '操作', toolbar: '#reset'}
            ]]
        });
        return false;
    });
    table.on('tool', function (obj) {
        layer.open({
            title:'重置密码窗口',
            type: 2,
            area: ['608px','350px'],
            content: '/operator/jumpInputPwd'
        });
    });

    //监听提交
    form.on('submit(resetPwd)', function (data) {
        $.post("/operator/resetPwd", data.field, function (resp) {
            layer.msg(resp, {
                offset: 'auto',
                time: 3000
            });
        });
        return false;
    });
    layer.close(data);
});



