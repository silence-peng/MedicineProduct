function hh(table){
	//分页
  table.render({
    elem: '#test'
    ,url:'fenyetwo'
    ,limit:2
    ,method:'post'
    ,cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
    ,cols: [[
    	{field:'', title: '序号'}
      ,{field:'',  title: '保养人'}
      ,{field:'', title: '保养地址'}
      ,{field:'', title: '费用',sort: true}
	  ,{field:'', title: '录入时间',sort: true}
	  ,{field:'', title: '录入人'}
	  ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:150}
    ]]
  ,page: true
  });
}
layui.use(['table','form','layer','jquery'],function(){
	var table = layui.table;
	var layer=layui.layer;
	var form=layui.form;
	$('#insetDis').click(function () {
		//新增
			layer.open({
					type:2,
					content:'addMaintenancecosts.html',
						area: ['700px','600px'],
						title:'新增保养费用',
						end:function(){
							table.reload('idTest');
						}
				})
	});
	$('#ModifyInstallation').click(function () {
		//修改
			layer.open({
					type:2,
					content:'updateMaintenancecosts.html',
						area: ['700px','600px'],
						title:'修改保养费用',
						end:function(){
							table.reload('idTest');
						}
				})
	});
	hh(table);
	
	})