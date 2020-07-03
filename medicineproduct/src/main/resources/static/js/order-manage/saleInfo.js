layui.use(['jquery','form','table','laydate'],function () {
    var $=layui.jquery
        ,form=layui.form
        ,laydate=layui.laydate
        ,table=layui.table;
    laydate.render({
        elem: "#startDate"
    });
    laydate.render({
        elem:"#endDate"
    });
    $("#staff").load('loadStaffInfo',function (res) {
        var staffInfoData=eval(res);
        $("#staff").append("<option value='0'>请选择</option>");
        $.each(staffInfoData,function (o,j) {
            $("#staff").append("<option value='"+j.sid+"'>"+j.sname+"</option>")
        });
        form.render("select");
    });
    $("#customer").load('loadCustomerInfo',function (res) {
        var customerInfoData=eval(res);
        $("#customer").append("<option value='0'>请选择</option>");
        $.each(customerInfoData,function (o,j) {
            $("#customer").append("<option value='"+j.cid+"'>"+j.customerName+"</option>")
        });
        form.render("select");
    });
    table.render({
            elem: '#saleInfo'
            ,url:'/loadSaleInfoTable'
            ,id:"saleInfo"
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
                ,{field:'orderStatus', title: '订单状态',templet:function (res) {
                    if (res.orderStatus===1){
                        return "代配送"
                    }else if (res.orderStatus===2){
                        return "待安装"
                    }else if (res.orderStatus===3){
                        return "已完成"
                    }
                }}
                ,{field:'orderBom', title: '订单BOM单',templet:function (res) {
                        var str="";
                        for (var i=0;i<res.list.length;i++){
                            str+="<a href=''>"+res.list[i].productCode+"</a>"+" ";
                        }
                        return str;
                    }}
            ]],

        page:true
        });
    var $ = layui.$, active = {
        add: function(){ //获取选中数据
            layer.open({
                type: 2,
                area: [900 + 'px', 600 + 'px'],
                fix: false, //不固定
                width:900,
                height:600,
                maxmin: true,
                shade: 0.4,
                title: "添加销售单",
                content: "saveSaleInfo",
                success:function () {

                },end:function () {
                    table.reload("saleInfo")
                }
            });
        }
        ,upd: function(){ //获取选中数目
            var checkStatus = table.checkStatus('saleInfo')
                ,data = checkStatus.data;
            if (data.length>0){
                layer.open({
                    type: 2,
                    area: [900 + 'px', 600 + 'px'],
                    fix: false, //不固定
                    width:900,
                    height:600,
                    maxmin: true,
                    shade: 0.4,
                    title: "修改销售单",
                    content: "updSaleInfo?id="+data[0].oid,
                    success:function () {

                    },end:function () {
                        table.reload("saleInfo")
                    }
                });
            }else{
                layer.alert("请选择您要修改的数据");
            }

        }
        ,del: function(){ //验证是否全选
            var checkStatus = table.checkStatus('saleInfo')
                ,data = checkStatus.data;
            var delOrder=[];
            for (var i=0;i<data.length;i++){
                if (data[i].orderStatus===1){
                    delOrder.push(data[i].oid);
                }else if (data[i].orderStatus===2){
                    delOrder.push(data[i].oid);
                }
            }
            layer.confirm("您选择的订单中，包含可删除的“代配送、待安装”的共有"+delOrder.length+"条数据,确定要删除吗？",function () {
                if (delOrder.length>0){
                    $.ajaxSettings.traditional = true;
                    $.post("delOrder",{delOrder:delOrder},function (res) {
                        if (res){
                            layer.alert("删除成功！");
                            table.reload("saleInfo")
                        }
                    })
                }
            })
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
                    table.reload("saleInfo")
                }
            });
        }
    };
    $(".find").click(function () {
        $.ajaxSettings.traditional = true;
        table.reload('saleInfo',{
            where:{
                "startDate":$("#startDate").val(),
                "endDate":($("#endDate").val()),
                "cid":($("#customer").val()),
                "salesman":parseInt($("#staff").val()),
                "orderStatus":parseInt($("#state").val())
            }
        });
    });
    $('.btnArr .layui-btn').on('click', function(){
        var type = $(this).data('type');
        active[type] ? active[type].call(this) : '';
    });
});