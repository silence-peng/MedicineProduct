function hh(table){
	//分页
  table.render({
    elem: '#test'
    ,url:'fenyetwo'
    ,limit:2
    ,method:'post'
    ,cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
    ,cols: [[
		{type:'checkbox'},
    	{field:'did', title: '序号',sort:true}
      ,{field:'customer_address',  title: '维修地址'}
      ,{field:'sid', title: '维修人'}
      ,{field:'createDate', title: '维修时间',sort: true}
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
					content:'AddRepairDispatch.html',
						area: ['700px','600px'],
						title:'维修派单',
						end:function(){
							table.reload('idTest');
						}
				})
	});
	$('#ModifyInstallation').click(function () {
		//修改
			layer.open({
					type:2,
					content:'AddRepairDispatchtwo.html',
						area: ['700px','600px'],
						title:'修改维修派单',
						end:function(){
							table.reload('idTest');
						}
				})
	});
	hh(table);
	
	})