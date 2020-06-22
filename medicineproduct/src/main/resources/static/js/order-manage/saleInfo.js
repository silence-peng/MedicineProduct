layui.use(['jquery','form','table'],function () {
    var $=layui.jquery
        ,form=layui.form
        ,table=layui.table;
    table.render({
            elem: '#saleInfo'
            ,url:'/loadSaleInfoTable'
            ,cellMinWidth: 100 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
            ,cols: [[
                {type:'checkbox'}
                ,{field:'oid',  title: '订单ID'}
                ,{field:'salesman',  title: '销售员',templet:function (res) {
                        return res.staff.sname;
                    }}
                ,{field:'totalSalesPrice',  title: '销售总价', sort: true}
                ,{field:'saleDate',  title: '销售日期'}
                ,{field:'customerName', title: '客户',templet:function (res) {
                    return res.customer.customerName;
                }}
                ,{field:'corporateName', title: '公司名称',templet:function (res) {
                    return res.customer.corporateName;
                }}
                ,{field:'customerAddress', title: '公司详细地址',templet:function (res) {
                    return res.customer.customerAddress;
                }}
                ,{field:'customerPhone', title: '联系电话',templet:function (res) {
                    return res.customer.customerPhone;
                }}
                ,{field:'salesVolumes', title: '销售产品数', sort: true}
                ,{field:'orderStatus', title: '订单状态'}
                ,{field:'orderBom', title: '订单BOM单',templet:function (res) {
                        var str="";
                        for (var i=0;i<res.list.length;i++){
                            str+="<a href=''>"+res.list[i].productCode+"</a>"+",";
                        }
                        return str;
                    }}
            ]],
        done:function (res,curr,count) {
            console.log(res)
        }
        });
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
                area: [900 + 'px', 600 + 'px'],
                fix: false, //不固定
                width:900,
                height:600,
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