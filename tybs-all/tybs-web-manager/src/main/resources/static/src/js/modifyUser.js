layui.use(['table', 'form', 'jquery'], function () {
    var table = layui.table;
    var form = layui.form;
    var $ = layui.$;
    form.on('submit(formDemo)', function (data) {
        //第一个实例
        table.render({
            elem: '#table-modifyUser',
            height: 600,
            width: 1053,
            url: '/operator/getAcct', //数据接口,
            // page: true, //开启分页
            where: data.field,
            cols: [[ //表头
                {field: 'userName', title: '姓名', width: 100, edit: 'text',readonly:'readonly'}
                , {field: 'userCardId', title: '省份证号', width: 200, edit: 'text',readonly:'readonly'}
                , {field: 'userTel', title: '手机号', width: 150, edit: 'text'}
                , {field: 'userEmail', title: '邮箱号', width: 150, edit: 'text'}
                , {field: 'userAddress', title: '现住家庭住址', width: 293, edit: 'text'}
                , {fixed: 'right', width: 160, title: '操作', toolbar: '#modify-User'}
            ]]
        });
        return false;
    });
    table.on('tool', function (obj) {
        var info = obj.data; //获得当前行数据
        var layEvent = obj.event; //获得 lay-event 对应的值
        var tr = obj.tr; //获得当前行 tr 的DOM对象
        layer.confirm('确定修改？', function (index) {
            $.post("/operator/modifyUser", info, function (resp) {
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
