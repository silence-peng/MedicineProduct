layui.use(['laydate', 'jquery','table'], function() {
    var laydate = layui.laydate,
        $ = layui.jquery,
        table=layui.table;
	  table.render({
	    elem: '#test'
	    ,url:'/hj/getRecord'
	    ,cols: [[
			  {type: 'checkbox'}
	      ,{field:'mid',title: '序号'}
	      ,{field:'sname',title: '保养人员名称', templet: '<span>{{d.staff.sname}}</span>'}
	      ,{field:'productName',title: '产品', templet: '<span>{{d.product.productName}}</span>'}
	      ,{field:'customerName',title: '客户', templet: '<span>{{d.customer.customerName}}</span>'}
	      ,{field:'prePhotos',title: '保养前的图片',templet:'<div><img src="/images/{{d.prePhotos}}" class="layui-table-link"></div>'}
		   ,{field:'sufPhotos',title: '保养后的图片',templet:'<div><img src="/images/{{d.sufPhotos}}" class="layui-table-link"></div>'}
		    ,{field:'repairDate',title: '保养日期'}
	    ]]
		  , page: true
		  , limit: 3
		  , id: 'testReload'
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