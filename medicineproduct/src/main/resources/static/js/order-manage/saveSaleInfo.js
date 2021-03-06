var $;
var index=0;
layui.use(['jquery','form','element','layer'],function () {
    $=layui.jquery;
    var  form=layui.form,
        element=layui.element,
        layer=layui.layer;
    $("#staff").load('loadStaffInfo',function (res) {
        var staffInfoData=eval(res);
        $.each(staffInfoData,function (o,j) {
            $("#staff").append("<option value='"+j.sid+"'>"+j.sname+"</option>")
        });
        form.render("select");
    });
    $("#customer").load('loadCustomerInfo',function (res) {
        var customerInfoData=eval(res);
        $.each(customerInfoData,function (o,j) {
            $("#customer").append("<option value='"+j.cid+"'>"+j.customerName+"</option>")
        });
        form.render("select");
    });

    $(".add").on("click",function () {
        layer.open({
            type: 2,
            area: [600 + 'px', 400 + 'px'],
            fix: false, //不固定
            width:600,
            height:400,
            maxmin: true,
            shadeClose: true,
            shade: 0.4,
            title: "产品页",
            content: "productPage",
            success:function () {

            },end:function () {
            }
        });
    });
    $(".resetForm").click(function () {
        layer.confirm("请问是否重置表单？", {
            btn: ["确定","取消"] //按钮
        }, function(ind){
            for (var i=1;i<=index;i++){
                $("#product"+i).remove();
            }
            index=0;
            layer.close(ind);
        }, function(){

        });

    });
    $(".back").click(function () {
        var index=parent.layer.getFrameIndex(window.name);
        parent.layer.close(index);
    });

    $(".commit").click(function () {
        var flag=true;
        var order={};
        var salePrices=[];
        var pid=[];
        $.each($(".salePrice"),function (o,j) {
            if ($(this).val()===null || $(this).val()===""){
                flag=false;
            }else{
                // odid.push($(".odid:eq("+o+")").val());
                salePrices.push($(this).val());
                pid.push($(".productId:eq("+o+")").val())
            }
        });
        if($("#totalSalesPrice").val()===null || $("#totalSalesPrice").val()===''){
            flag=false;
        }
        if (flag){
            layer.confirm("确认要提交该订单吗？",function () {
                $.ajaxSettings.traditional = true;
                $.post("saveOrder",{salesVolumes:$("#salesVolumes").val(),totalSalesPrice:$("#totalSalesPrice").val(),salesman:$("#staff").val(),cid:$("#customer").val(),salePrices:salePrices,pid:pid},function (res) {
                    if (res){
                        layer.alert("提交成功！即将离开当前页面",function () {
                            var index=parent.layer.getFrameIndex(window.name);
                            parent.layer.close(index);
                        })
                    }
                })
            })
        }else{
            layer.alert("销售价格不得为空！")
        }
    });


});
function handleState(state) {
    var stateTxt="";
    if (state===2){
        stateTxt="已投入使用";
    }else if(state===1){
        stateTxt="未投入使用";
    }else if(state===3){
        stateTxt="需要维修";
    }else if(state===4){
        stateTxt="已损坏";
    }else if(state===5){
        stateTxt="等待安装";
    }
    return stateTxt;
}
function initSaleInfo() {
    var i=0;
    var totalPrice=0;
    $.each($(".salePrice"),function (o,j) {
        i++;
        totalPrice+=parseInt($(this).val())
    });
    $("#salesVolumes").val(i);
    $("#totalSalesPrice").val(totalPrice);


}

function addOrderInfo(j) {
    var flag=true;
    if ($(".productId")!==null){
        $.each($(".productId"),function (o,y) {
            if (j.pid===parseInt($(this).val())){
                flag=false;
            }
        });
    }

    if (flag){
        index++;
        var stateTxt=handleState(j.state);
        $(".orderBOM").append(
            "<div class=\"layui-card-body\" id='product"+index+"'>\n" +
            "<hr/>"+
            "    <div class=\"layui-form-item\">\n" +
            "        <div class=\"layui-inline\">\n" +
            "            <lable class=\"layui-form-label\">产品编码</lable>\n" +
            "            <div class=\"layui-input-inline\">\n" +
            "                <input type=\"text\" value='"+j.productCode+"' disabled class=\"layui-input layui-disabled\">\n" +
            "                <input type=\"hidden\" value='"+j.pid+"' disabled class=\"layui-input productId layui-disabled\">\n" +
            "                <input type=\"hidden\" value='' disabled class=\"layui-input odid layui-disabled\">\n" +
            "            </div>\n" +
            "        </div>\n" +
            "        <div class=\"layui-inline\">\n" +
            "            <lable class=\"layui-form-label\">产品名</lable>\n" +
            "            <div class=\"layui-input-inline\">\n" +
            "                <input type=\"text\" disabled value='"+j.productName+"' class=\"layui-input layui-disabled\">\n" +
            "            </div>\n" +
            "        </div>\n" +
            "        <div class=\"layui-inline\">\n" +
            "            <lable class=\"layui-form-label\">预售价格($)</lable>\n" +
            "            <div class=\"layui-input-inline\">\n" +
            "                <input type=\"text\" disabled value='"+j.presalePrice+"' class=\"layui-input layui-disabled\">\n" +
            "            </div>\n" +
            "        </div>\n" +
            "        <div class=\"layui-inline\">\n" +
            "            <lable class=\"layui-form-label\">销售价格($)</lable>\n" +
            "            <div class=\"layui-input-inline\">\n" +
            "                <input type=\"text\" oninput=\"initSaleInfo()\" value='"+j.presalePrice+"' class=\"layui-input salePrice\">\n" +
            "            </div>\n" +
            "        </div>\n" +
            "    </div>\n" +
            "    <div class=\"layui-form-item\">\n" +
            "        <div class=\"layui-inline\">\n" +
            "            <label class=\"layui-form-label\">空气输出功率</label>\n" +
            "            <div class=\"layui-input-inline\"><input type=\"text\"  value='"+j.airOutputPower+"L/Min' disabled\n" +
            "   class=\"layui-input layui-disabled\"></div>\n" +
            "        </div>\n" +
            "        <div class=\"layui-inline\">\n" +
            "            <label class=\"layui-form-label\">真空输出功率</label>\n" +
            "            <div class=\"layui-input-inline\"><input type=\"text\"  value='"+j.vacuumOutputPower+"L/Min' disabled\n" +
            "   class=\"layui-input layui-disabled\"></div>\n" +
            "        </div>\n" +
            "        <div class=\"layui-inline\">\n" +
            "            <label class=\"layui-form-label\">氧气输出功率</label>\n" +
            "            <div class=\"layui-input-inline\"><input type=\"text\" value='"+j.oxygenOutputPower+"L/Min' disabled\n" +
            "   class=\"layui-input layui-disabled\"></div>\n" +
            "        </div>\n" +
            "        <div class=\"layui-inline\">\n" +
            "            <lable class=\"layui-form-label\">产品状态</lable>\n" +
            "            <div class=\"layui-input-inline\">\n" +
            "                <input type=\"text\"  value='"+stateTxt+"' disabled\n" +
            "   class=\"layui-input layui-disabled\"></div>\n" +
            "            </div>\n" +
            "        </div>\n" +
            "<div class='btnArr'  style='display:inline-block;margin: 0 42%'><button onclick='removeProduct("+index+")' type='button' data-type=\"remove\" class='layui-btn layui-btn-danger'>移除</button></div>"+
            "    </div>\n" );

        initSaleInfo();
    }else {
        layer.alert("您已添加过改产品了，请选取其他产品进行添加！")
    }

}
function removeProduct(i) {
    layer.confirm("请问是否确定删除？", {
        btn: ["确定","取消"] //按钮
    }, function(ind){
        $("#product"+i).remove();
        layer.close(ind);
    }, function(){

    });
initSaleInfo();
}