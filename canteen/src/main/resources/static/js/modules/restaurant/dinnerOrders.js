var content;
var curWwwPath=window.document.location.href;
var pathName=window.document.location.pathname;
var pos=curWwwPath.indexOf(pathName);
var localhostPath=curWwwPath.substring(0,pos);
$(document).ready(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'restaurant/dinnerOrders/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', width: 30, key: true},
			{ label: '姓名', name: 'userName', width: 50 }, 	
			{ label: '部门', name: 'department', width: 50 }, 	
			{ label: '属地', name: 'address', width: 70 }, 
			{ label: '下单时间', name: 'createTime', width: 150 },
			{ label: '状态', name: 'status', width: 50 }

        ],
		viewrecords: true,
        height: 385,
        rowNum: 10,
		rowList : [10,30,50],
        rownumbers: true, 
        rownumWidth: 25, 
        autowidth:true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader : {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames : {
            page:"page", 
            rows:"limit", 
            order: "order"
        },
        gridComplete:function(){
        	//隐藏grid底部滚动条
        	$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" }); 
        }
    });
   
 /*   function showPic(cellvalue, options, rowObject){
    	var str = '<img src="'+localhostPath+'/file/read/readImg?filePath='+rowObject.dishesPicPath +'"  width="42" height="42">';
    	return str;
    }*/


  /*  function operate(cellvalue, options, rowObject){
    	var str = '<button type="button">评价管理</button> ';
    	return str;
    }*/
});
/*var editor = new baidu.editor.ui.Editor(); 
editor.render("myEditor"); 
editor.ready(function(){
     editor.setContent("");
});
*/
var vm = new Vue({
	el:'#rrapp',
	data:{
		/*q:{
			userName: null
		
		},*/
		q1:{
			
			time:null
		},
		showList: true,
		title:null,
		userName :{}
		
		
	},
	methods: {
		query: function () {
			vm.reload();
		},
		
		poiExpExcel: function () {
		
			var boo=confirm('确定要导出Excel？');
			if(boo==true){
			/*confirm('确定要导出Excel？', function(){*/
				$.ajax({
					type: "POST",
				    url: baseURL + "restaurant/dinnerOrders/poiExpExcel?time="+vm.q1.time,
                    contentType: "application/json",
				    /*data: JSON.stringify(vm.q1.time),*/
                    success: function(r){
						if(r.code == 0){
							alert('操作成功');
                                vm.reload();
							
						}else{
							alert(r.msg);
						}
					}
				});
			/*});*/}
		},
	
		del: function () {
			var ids = getSelectedRows();
			if(ids == null){
				return ;
			}
			
			var boo=confirm('确定要删除选中的记录？');
        	if(boo==true){
			
		/*	confirm('确定要删除选中的记录？', function(){*/
				$.ajax({
					type: "POST",
				    url: baseURL + "restaurant/dinnerOrders/delete",
                    contentType: "application/json",
				    data: JSON.stringify(ids),
				    success: function(r){
						if(r.code == 0){
							alert('操作成功');
                                vm.reload();
							
						}else{
							alert(r.msg);
						}
					}
				});
        	}
		},
		saveOrUpdate: function () {
            if(vm.validator()){
                return ;
            }
          
			var url = vm.dishes.id == null ;
			var form = new FormData(document.getElementById("dishForm"));
			$.ajax({
				type: "POST",
			    url: baseURL + url,
			    data:form,
			    contentType: false,
			    processData:false,
			    success: function(r){
			    	if(r.code === 0){
						alert('操作成功', function(){
							vm.reload();
						});
					}else{
						alert(r.msg);
					}
				}
			});
		},
		
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
				/*postData:{'userName': vm.q.userName},*/
				postData:{'time': vm.q1.time},
				
				page:page
            }).trigger("reloadGrid");
		},
		
		/*validator: function () {
		  if(isBlank(vm.dishes.dishes)){
	                alert("菜名不能为空");
	                return true;
	       }
        }*/
	}
});

