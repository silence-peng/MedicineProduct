layui.use(['table','form','layer','jquery'],function(){
	var table = layui.table;
	var layer=layui.layer;
	var form=layui.form;
	$.post("/yzj/getstaff", function(result){
		$(result).each(function(){
			$("#sid").append("<option value='"+this.sid+"'>"+this.sname+"</option>");
		});
		form.render('select'); //刷新select选择框渲染
	});
	form.on('submit(tij)', function(data){
		$.ajax({
			url:'/yzj/insert',
			type:'post',
			data:$("#form").serialize(),
			dataType:'text',
			success:function(e){
				if(e=='ok'){
					layer.msg("新增成功！",{time:500,icon:6},function(){
						var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
						parent.layer.close(index);
					});
				}
			}
		})
		return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
	});
	})