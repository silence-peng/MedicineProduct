layui.use(['table','form','layer','upload','jquery','laydate'],function(){
	var table = layui.table;
	var layer=layui.layer;
	var form=layui.form;
    upload = layui.upload;
	 var $ = layui.jquery;
	 var laydate = layui.laydate;
	 //时间
	 laydate.render({
	     elem: '#date'
	   });
	
	})