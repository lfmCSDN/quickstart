layui.use(['table','form','jquery','laydate'], function () {
    var table = layui.table;
    var form = layui.form;
    var $ = layui.$;
    var laydate = layui.laydate;

    //时间插件
    laydate.render({
        elem: '#startTime'
        , type: 'date'
    });
    laydate.render({
        elem: '#endTime'
        , type: 'date'
    });

    form.on('submit(formDemo)',function (data) {
        //第一个实例
        table.render({
            elem: '#trans',
            height: 400,
            // width:850,
            cellMinWidth: 100,
            skin: 'row' //行边框风格
            ,even: true //开启隔行背景
            ,url: '/acct/getTransList', //数据接口,
            where:data.field,
            cols: [[ //表头
                {type:'numbers'}
                ,{field: 'serialNumber', title: '交易流水号', width: 140, edit:'text',sort: true}
                ,{field: 'transName', title: '持卡姓名', width: 100, edit:'text'}
                , {field: 'transId', title: '银行卡号', width: 190, edit:'text'}
                , {field: 'transType', title: '交易类型', width: 100, edit:'text'}
                , {field: 'transCardType', title: '交易银行卡类型', width:115, edit:'text'}
                , {field: 'transAmount', title: '交易金额', width:115, edit:'text'}
                , {field: 'transTime', title: '交易时间',width:185, edit:'text'}
            ]]
            // ,page: true
        });
        return false;
    });


    //监听提交
    form.on('submit(exporXls)', function (data) {
        $.post("/acct/exportXls", data.field, function (resp) {
            layer.msg(resp, {
                offset: 'auto',
                time: 3000
            });
        });
        return false;
    });
});