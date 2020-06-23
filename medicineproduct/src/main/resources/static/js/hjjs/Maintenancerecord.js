layui.use(['laydate', 'jquery','table'], function() {
    var laydate = layui.laydate,
        $ = layui.jquery,
        table=layui.table;
	  table.render({
	    elem: '#test'
	    ,url:'/demo/table/user/'
	    ,cols: [[
	      {field:'id',title: '序号'}
	      ,{field:'username',title: '保养人员名称'}
	      ,{field:'sex',title: '保养地址'}
	      ,{field:'classify',title: '保养前的图片'}
		   ,{field:'classify',title: '保养后的图片'}
		    ,{field:'classify',title: '保养日期'}
	     ,{fixed: 'right', title:'操作', toolbar: '#barDemo'}
	    ]]
	    ,page: true
	  });
	  table.on('tool(test)', function(obj){
	      var data = obj.data;
	      //console.log(obj)
	      if(obj.event === 'del'){
	        layer.confirm('真的删除行么', function(index){
	          obj.del();
	          layer.close(index);
	        });
	      } else if(obj.event === 'edit'){
	        layer.prompt({
	          formType: 2
	          ,value: data.email
	        }, function(value, index){
	          obj.update({
	            email: value
	          });
	          layer.close(index);
	        });
	      }
		  });
	  //跳新增页面
	  $("#dianji").click(function(){
	      layer.open({
	          type: 2,
	          content: 'updateMaintenanceevaluation.html', //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
	          title:'修改',
			  area: ['650px', '500px']
	      });
	  });
	  $("#dianji1").click(function(){
	      layer.open({
	          type: 2,
	          content: 'Maintenanceevaluation.html', //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
	         title:'评估',
			  area: ['650px', '500px']
	      });
	  });
	});	