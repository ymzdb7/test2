
var content;
var curWwwPath=window.document.location.href;
var pathName=window.document.location.pathname;
var pos=curWwwPath.indexOf(pathName);
var localhostPath=curWwwPath.substring(0,pos);
$(document).ready(function () {
	time();
    $("#jqGrid").jqGrid({
        url: baseURL + 'restaurant/cardDevice/exCoulist',
        datatype: "json",
        colModel: [			
			{ label: '卡号', name: 'cardNo', width: 50, },
			{ label: '部门', name: 'department', width: 50 },
			{ label: '消费总计', name: 'transMoneyCounts', width: 50, }
		
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
});


var vm = new Vue({
	el:'#rrapp',
	data:{
		q:{
			transTime: null
		},
		showList: true,
		title:null,
		type :{}
	},
	methods: {
		query: function () {
			vm.q.transTime=$('#transTime').val();
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.type = {};
	},
		update: function () {
			var id = getSelectedRow();
			if(id == null){
				return ;
			}
			
            $.get(baseURL + "restaurant/type/info/"+id, function(r){
                vm.showList = false;
                vm.title = "修改";
                vm.type = r.type;
              });
		},	
		del: function () {
			var ids = getSelectedRows();
			if(ids == null){
				return ;
			}
			
			var boo=confirm('确定要删除选中的记录？');
        	if(boo==true){
				$.ajax({
					type: "POST",
				    url: baseURL + "restaurant/type/delete",
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
          
			var url = vm.type.id == null ? "restaurant/type/save" : "restaurant/type/update";
			var form = new FormData(document.getElementById("typeForm"));
			$.ajax({
				type: "POST",
			    url: baseURL + url,
			    data:form,
			    contentType: false,
			    processData:false,
			    success: function(r){
			    	if(r.code === 0){
						alert('操作成功');
							vm.reload();
						
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
				postData:{'transTime': vm.q.transTime},
                page:page
            }).trigger("reloadGrid");
		},
		validator: function () {
		  if(isBlank(vm.type.typeName)){
	                alert("菜品类型不能为空");
	                return true;
	       }
        }
	}
});


function time(){
	$('#datetimepicker').datetimepicker({
		 autoclose: 1,
		 language: 'zh-CN',
		 /*weekStart:1,*/
		 /*todayBtn:1,*/
		 
		/* todayHighlight:1,*/
		 startView:3,
		 minView:3,
		 forceParse:0

	});
}

