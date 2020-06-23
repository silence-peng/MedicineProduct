layui.use(['jquery','form','element','upload'],function () {
    var $=layui.jquery
        ,form=layui.form
        ,upload = layui.upload
        ,element=layui.element;
    var url = location.search;
    var id = url.match(/\d/g).join("");
    $.post("getSaleInfoById",{id:id},function (res) {
        var data=eval(res);
        console.log(data)
        form.val("data",data);
        $("#staff").val(data.salesman);
        $("#customer").val(data.cid);
        form.render();
    });
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
    })

});