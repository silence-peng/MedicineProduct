layui.use(['jquery','form','table'],function () {
    var $=layui.jquery
        ,form=layui.form
        ,table=layui.table;
    table.render(
        {
            elem: '#saleInfo'
            ,url:'/demo/table/user/'
            ,cellMinWidth: 100 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
            ,cols: [[
                {field:'id', width:80, title: 'ID', sort: true}
                ,{field:'username', width:80, title: '用户名'}
                ,{field:'sex', width:80, title: '性别', sort: true}
                ,{field:'city', width:80, title: '城市'}
                ,{field:'sign', title: '签名', width: '30%', minWidth: 100} //minWidth：局部定义当前单元格的最小宽度，layui 2.2.1 新增
                ,{field:'experience', title: '积分', sort: true}
                ,{field:'score', title: '评分', sort: true}
                ,{field:'classify', title: '职业'}
                ,{field:'wealth', width:137, title: '财富', sort: true}
            ]]
        }
    );
    var $ = layui.$, active = {
        add: function(){ //获取选中数据
            layer.open({
                type: 2,
                area: [600 + 'px', 400 + 'px'],
                fix: false, //不固定
                width:600,
                height:400,
                maxmin: true,
                shadeClose: true,
                shade: 0.4,
                title: "添加销售单",
                content: "saveSaleInfo",
                success:function () {

                },end:function () {
                }
            });
        }
        ,upd: function(){ //获取选中数目
            var checkStatus = table.checkStatus('idTest')
                ,data = checkStatus.data;
            layer.msg('选中了：'+ data.length + ' 个');
        }
        ,del: function(){ //验证是否全选
            var checkStatus = table.checkStatus('idTest');
            layer.msg(checkStatus.isAll ? '全选': '未全选')
        }
        ,export: function(){ //验证是否全选
            layer.open({
                type: 2,
                area: [600 + 'px', 400 + 'px'],
                fix: false, //不固定
                width:600,
                height:400,
                maxmin: true,
                shadeClose: true,
                shade: 0.4,
                title: "销售单导入",
                content: "exportSaleInfo",
                success:function () {

                },end:function () {
                }
            });
        }
    };

    $('.btnArr .layui-btn').on('click', function(){
        var type = $(this).data('type');
        active[type] ? active[type].call(this) : '';
    });
});