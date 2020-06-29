var $;
var form;
layui.use(['jquery','form','table','element','upload'],function () {
    $=layui.jquery;
    form=layui.form;
    var  upload = layui.upload
        ,element=layui.element
        ,table=layui.table;
    var productData=[];
    var xslxExportData=[];
    var nationalStandardData=[];
    $.post("/loadNationalStandardList",function (res) {
        nationalStandardData=eval(res);
    });
    table.render({
        elem: '#nationalStandard'
        ,url:"loadNationalStandard"
        ,id:"nationalStandard"
        ,cellMinWidth: 120 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
        ,cols: [[
            {field:'departmentId',  title: '科室名'}
            ,{field:'oxygenMaxOutput',  title: '氧气最大需求（L/Min）'}
            ,{field:'oxygenMinOutput',  title: '氧气最小需求（L/Min）'}
            ,{field:'oxygenAvailability', title: '使用率'}
            ,{field:'airMaxOutput',  title: '空气最大需求（L/Min）'}
            ,{field:'airMinOutput',  title: '空气最小需求（L/Min）'}
            ,{field:'airAvailability', title: '使用率'}
            ,{field:'vacuumMaxOutput',  title: '真空最大需求（L/Min）'}
            ,{field:'vacuumMinOutput',  title: '真空最小需求（L/Min）'}
            ,{field:'vacuumAvailability', title: '使用率'}
        ]],
        limits:[5,10,15],
        limit:5,
        page:true,
        done:function (res,curr,count) {
            $.post('loadDepartment',function (res) {
                for (var i=0;i<count;i++){
                    // $('.layui-table-main').find(" td[data-field='long']").children().html();
                    var el=$('.layui-table-main').find("tr[data-index="+i+"] td[data-field='departmentId']").children();
                    if (res.length>0){
                        $.each(res,function (i,o) {
                            if (o.did===parseInt(el.html())){
                                el.html(o.dname);
                            }
                        })
                    }
                }

            })
        }
    });
    upload.render({ //允许上传的文件后缀
        elem: '#templateFile'
        ,url: '/base/upload' //改成您自己的上传接口
        ,accept: 'file' //普通文件
        ,exts: 'xlsx|xls' //只允许上传压缩文件
        ,before: function(obj) {  }
        ,data: {}
        ,done: function(res){
            if (res.code===0){
                layer.msg('上传成功!');
                xslxExportData=res.data;
                table.reload('xslxExportInfo', {
                    data: xslxExportData
                });
                initStandard(xslxExportData,nationalStandardData);
                console.log($("#data").serialize());
                table.reload('productInfo',{
                    page: {
                        curr: 1 //重新从第 1 页开始
                    }
                    ,where: {
                        data:$("#data").serialize()
                    }
                })
            }else{
                layer.msg(res.msg);
            }
        }
    });
    var $ = layui.$, active = {
        reload: function(){
            var demoReload = $('#demoReload');

        }
    };
    table.render({
        elem: '#xslxExportInfo'
        ,id:"xslxExportInfo"
        ,cellMinWidth: 100 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
        ,cols: [[
            {field:'dname',  title: '科室名'}
            ,{field:'rooms',  title: '科室数'}
            ,{field:'deds',  title: '床位数'}
        ]],
        data:xslxExportData,
        limits:[5,10,20],
        limit:5,
        page:true
        ,done:function (res,curr,count) {

        }
    });


    table.render({
        elem: '#productInfo'
        ,url:'/loadProductInfo'
        ,id:"productInfo"
        ,cellMinWidth: 100 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
        ,cols: [[
            {field:'productCode',  title: '产品编码'}
            ,{field:'productName',  title: '产品名'}
            ,{field:'warehousingDate',  title: '入库日期'}
            ,{field:'presalePrice', title: '预售价格',templet:function (res) {
                    return "$"+res.presalePrice;
                }}
            ,{field:'airOutputPower', title: '空气输出功率',templet:function (res) {
                    return res.airOutputPower+"L/Min";
                }}
            ,{field:'oxygenOutputPower', title: '氧气输出功率',templet:function (res) {
                    return res.oxygenOutputPower+"L/Min";
                }}
            ,{field:'vacuumOutputPower', title: '真空输出功率',templet:function (res) {
                    return res.vacuumOutputPower+"L/Min";
                }}
        ]],
        data:productData,
        limits:[5,10,20],
        limit:5,
        page:true
    });
    table.on('rowDouble(productInfo)', function(obj){
        parent.addOrderInfo(obj.data);
        var index=parent.layer.getFrameIndex(window.name);
        parent.layer.close(index);
    });

});
function initStandard(xslxExportData,nationalStaandardData) {
    var airMaxOutPutPower=0;
    var oxygenMaxOutPutPower=0;
    var vacuumMaxOutputPower=0;
    var airMinOutPutPower=0;
    var oxygenMinOutPutPower=0;
    var vacuumMinOutputPower=0;
    for (var i=0;i<xslxExportData.length;i++){
        var calculation=xslxExportData[i].rooms*xslxExportData[i].deds;
        for (var j=0;j<nationalStaandardData.length;j++){
            if (nationalStaandardData[j].departmentId===xslxExportData[i].did){
                airMaxOutPutPower+=(calculation*nationalStaandardData[j].airMaxOutput*nationalStaandardData[j].airAvailability);
                airMinOutPutPower+=(calculation*nationalStaandardData[j].airMinOutput*nationalStaandardData[j].airAvailability);
                oxygenMaxOutPutPower+=(calculation*nationalStaandardData[j].oxygenMaxOutput*nationalStaandardData[j].oxygenAvailability);
                oxygenMinOutPutPower+=(calculation*nationalStaandardData[j].oxygenMinOutput*nationalStaandardData[j].oxygenAvailability);
                vacuumMaxOutputPower+=(calculation*nationalStaandardData[j].vacuumMaxOutput*nationalStaandardData[j].vacuumAvailability);
                vacuumMinOutputPower+=(calculation*nationalStaandardData[j].vacuumMinOutput*nationalStaandardData[j].vacuumAvailability);
            }
        }
    }
    var data={};
    data.airMaxOutputPower=airMaxOutPutPower/100;
    data.airMinOutputPower=airMinOutPutPower/100;
    data.oxygenMaxOutputPower=oxygenMaxOutPutPower/100;
    data.oxygenMinOutputPower=oxygenMinOutPutPower/100;
    data.vacuumMaxOutputPower=vacuumMaxOutputPower/100;
    data.vacuumMinOutputPower=vacuumMinOutputPower/100;
    console.log(data);
    form.val("data",data);
}