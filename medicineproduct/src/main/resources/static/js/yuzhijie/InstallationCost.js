

layui.use(['table', 'form', 'layer', 'jquery'], function () {
    var table = layui.table;
    var layer = layui.layer;
    var form = layui.form;
    //分页
    table.render({
        elem: '#test'
        , url: '/yzjs/getCoset'
        , limit: 5
        , method: 'post'
        , cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
        , cols: [[
            {type: 'checkbox'}
            , {field: 'costId', title: '序号', sort: true}
            , {
                field: 'cid', title: '安装地址'
                , templet: function (d) {
                    return d.customer.customerAddress;
                }
            }
            , {
                field: 'sid', title: '安装人/录入人', templet: function (d) {
                    return d.staff.sname;
                }
            }
            , {field: 'cost', title: '费用', sort: true}
            , {field: 'enteredDate', title: '录入时间', sort: true}
        ]]
        , page: true
        , id: 'idTest'
    });
    $('#dianji').click(function () {
        table.reload('idTest', {
            where: { //设定异步数据接口的额外参数，任意设
                customerAddress: $('#customerAddress').val(),
                sname: $('#sname').val()
            }
            , page: {
                curr: 1 //重新从第 1 页开始
            }
        });

    });
    $('#insetDis').click(function () {
        //新增
        layer.open({
            type: 2,
            content: 'yNewInstallation.html',
            area: ['700px', '600px'],
            title: '安装费用录入',
            end: function () {
                table.reload('idTest');
            }
        })
    });
    $('#ModifyInstallation').click(function () {
        //修改
        var checkStatus = table.checkStatus('idTest');
        var data = checkStatus.data;
        var costId=0;
        if (data.length > 1) {
            layer.alert("只能选择一条");
        } else if (data.length > 0) {
            $(data).each(function (i, o) {//o即为表格中一行的数据
                costId=o.costId;
            });
            layer.open({
                type: 2,
                content: '/yzjs/getid',
                area: ['700px', '600px'],
                title: '修改安装费用',
                success: function (layero, index) {
                    var iframe = window['layui-layer-iframe' + index];
                    iframe.getid(costId);
                },
                end: function () {
                    table.reload('idTest');
                }
            })

        } else {
            layer.alert("请先选择，在修改");
        }
    });
    //批量删除
    $("#deleInstallationDispatchs").on("click", function () {
        var checkStatus = table.checkStatus('idTest');
        var data = checkStatus.data;
        var ids = [];
        if (data.length > 0) {
            $(data).each(function (i, o) {//o即为表格中一行的数据
                ids.push(o.costId);
            });
            layer.confirm('确定要删除吗', function (index) {
                $.ajax({
                    url: '/yzjs/deleCost',
                    type: "post",
                    data: JSON.stringify(ids),
                    dataType: "text",
                    contentType: 'application/json;charset=utf-8',
                    success: function (e) {
                        if (e == 'ok') {
                            layer.alert("删除成功");
                            layer.close(index);
                            //删除对应行（tr）的DOM结构，并更新缓存
                            table.reload('idTest', {
                                where: { //设定异步数据接口的额外参数，任意设

                                }
                                , page: {
                                    curr: 1 //重新从第 1 页开始
                                }
                            });
                            //向服务端发送删除指令
                        } else {
                            layer.alert("删除失败");
                        }
                    }
                })
            })
        } else {
            layer.alert("请先选中，在点击删除")
        }
    });

})