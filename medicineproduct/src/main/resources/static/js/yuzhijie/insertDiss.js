layui.use(['table','form','layer','upload','jquery','laydate'],function(){
	var table = layui.table;
	var layer=layui.layer;
	var form=layui.form;
    upload = layui.upload;
	 var $ = layui.jquery;
	 var laydate = layui.laydate;
	 laydate.render({
	     elem: '#date'
	   });
	 //图片上传
	  var uploadInst = upload.render({
	     elem: '#test1'
	     ,url: 'https://httpbin.org/post' //改成您自己的上传接口
	     ,before: function(obj){
	       //预读本地文件示例，不支持ie8
	       obj.preview(function(index, file, result){
	         $('#demo1').attr('src', result); //图片链接（base64）
	       });
	     }
	     ,done: function(res){
	       //如果上传失败
	       if(res.code > 0){
	         return layer.msg('上传失败');
	       }
	       //上传成功
	     },
	   });
	   var uploadInst = upload.render({
	      elem: '#test2'
	      ,url: 'https://httpbin.org/post' //改成您自己的上传接口
	      ,before: function(obj){
	        //预读本地文件示例，不支持ie8
	        obj.preview(function(index, file, result){
	          $('#demo2').attr('src', result); //图片链接（base64）
	        });
	      }
	      ,done: function(res){
	        //如果上传失败
	        if(res.code > 0){
	          return layer.msg('上传失败');
	        }
	        //上传成功
	      },
	    });
	})