var $;
layui.use(['jquery','form','element','layer'],function () {
     $=layui.jquery;
    var  form=layui.form,
        element=layui.element,
        layer=layui.layer;
    var url = location.search;
    var id = url.match(/\d/g).join("");
    $("#staff").load('loadStaffInfo',function (res) {
        var data=eval(res);
        $.each(data,function (o,j) {
            $("#staff").append("<option value='"+j.sid+"'>"+j.sname+"</option>")
        });

        form.render("select");
    });
    $("#customer").load('loadCustomerInfo',function (res) {
        var data=eval(res);
        $.each(data,function (o,j) {
            $("#customer").append("<option value='"+j.cid+"'>"+j.customerName+"</option>")
        });

        form.render("select");
    });
    $.post("getSaleInfoById",{id:id},function (res) {
        var data=eval(res);
        form.val("data",data);
        // $("#staff").val(data.salesman);
        // $("#customer").val(data.cid);
        form.render("select");
        $.each(data.list,function (o,j) {
            // 0未使用
            // 1使用中
            // 2已维修
            // 3已损坏
            var stateTxt=handleState(j.state);
            $(".orderBOM").append(
                "<div class=\"layui-card-body\">\n" +
                "    <div class=\"layui-form-item\">\n" +
                "        <div class=\"layui-inline\">\n" +
                "            <lable class=\"layui-form-label\">产品编码</lable>\n" +
                "            <div class=\"layui-input-inline\">\n" +
                "                <input type=\"text\" value='"+j.productCode+"' disabled class=\"layui-input layui-disabled\">\n" +
                "                <input type=\"hidden\" value='"+j.pid+"' disabled class=\"layui-input productId layui-disabled\">\n" +
                "                <input type=\"hidden\" value='"+data.orderDetails[o].odid+"' disabled class=\"layui-input odid layui-disabled\">\n" +
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
                "                <input type=\"text\"oninput=\"initSaleInfo()\" value='"+data.orderDetails[o].totalSalesPrice+"' class=\"salePrice layui-input\">\n" +
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
                "                <input type=\"text\" value='"+stateTxt+"' disabled\n" +
                "   class=\"layui-input layui-disabled\"></div>\n" +
                "            </div>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "</div>");
                if (o<data.list.length-1){
                    $(".orderBOM").append("<hr/>")
                }
        });

    });
    $(".add").click(function () {
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
    $(".commit").click(function () {
        var flag=true;
        var order={};
        var odid=[];
        var salePrices=[];

        $.each($(".salePrice"),function (o,j) {
            if ($(this).val()===null || $(this).val()===""){
                flag=false;
            }else{
                odid.push($(".odid:eq("+o+")").val());
                salePrices.push($(this).val());
            }
        });

        if (flag){
            layer.confirm("确认要提交修改内容吗？",function () {
                $.ajaxSettings.traditional = true;
                $.post("updOrder",{salesVolumes:$("#salesVolumes").val(),totalSalesPrice:$("#totalSalesPrice").val(),salesman:$("#staff").val(),cid:$("#customer").val(),oid:id,odid:odid,salePrices:salePrices},function (res) {
                    console.log(res)
                })
            })
        }else{
            layer.alert("销售价格不得为空！")
        }
    });


});
function handleState(state) {
    var stateTxt="";
    if (state===1){
        stateTxt="已投入使用";
    }else if(state===0){
        stateTxt="未投入使用";
    }else if(state===2){
        stateTxt="需要维修";
    }else if(state===3){
        stateTxt="已损坏";
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
    $.each($(".productId"),function (o,y) {
        if (j.pid===parseInt($(this).val())){
            flag=false;
        }
    });
    if (flag){
        var stateTxt=handleState(j.state);
        $(".orderBOM").append("<hr/>"+
            "<div class=\"layui-card-body\">\n" +
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
    "    </div>\n" +
    "</div>");
}else {
    layer.alert("您已添加过改产品了，请选取其他产品进行添加！")
}

}