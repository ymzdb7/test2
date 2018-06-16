
var content;
var curWwwPath=window.document.location.href;
var pathName=window.document.location.pathname;
var pos=curWwwPath.indexOf(pathName);
var localhostPath=curWwwPath.substring(0,pos);
$(document).ready(function () {
	getAddress();
    $("#jqGrid").jqGrid({
        url: baseURL + 'restaurant/enviroTalk/list',
        datatype: "json",//为local时初始化不加载，支持json，xml等 
        colModel: [			
			{ label: 'id', name: 'id', width: 20, key: true},
			{ label: '用户名', name: 'userName', width: 35 },
			{ label: '评论内容', name: 'content', width: 160 },
			{ label: '星数', name: 'startNum', width: 20 },
			{ label: '星评', name: 'startEvaluate', width: 105 },
			{ label: '属地', name: 'address', width: 20 },
			{ label: '评论时间', name: 'createTime', width: 50 }
			
	   ],
		viewrecords: true,//是否在浏览导航栏显示记录总数
        height: 385,
        rowNum: 10,//每页显示记录数
		rowList : [10,30,50],//用于改变显示行数的下拉列表框的元素数组。
        rownumbers: true, //设置列表显示序号,需要注意在colModel中不能使用rn作为index
        rownumWidth: 25, //设置显示序号的宽度，默认为25 
        autowidth:true,// 如果为ture时，则当表格在首次被创建时会根据父元素比例重新调整表格宽度。如果父元素宽度改变，为了使表格宽度能够自动调整则需要实现函数：setGridWidth
        multiselect: true,//是否多选
        pager: "#jqGridPager",//分页标签divID  
        jsonReader : {//server返回Json解析设定  
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames : { //如当前查询实体为ware，这些可以在查询对象的superObject中设定  
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
			typeName: null
		},
		showList: true,
		title:null,
		type :{},
		addresses:[]
	},
	methods: {
		query: function () {
			vm.reload();
		
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
				    url: baseURL + "restaurant/enviroTalk/delete",
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
		
/*	
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
						alert('操作成功', function(){
							vm.reload();
						});
					}else{
						alert(r.msg);
					}
				}
			});
		},*/
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
				postData:{'address': vm.q.address},
                page:page
            }).trigger("reloadGrid");
		}
	/*	validator: function () {
		  if(isBlank(vm.type.typeName)){
	                alert("菜品类型不能为空");
	                return true;
	       }
        }*/
	}
});



function getAddress(){
	$.ajax({
		type: "GET",
	    url: "http://211.149.174.103:8080/wash/notice/address/list",
	    dataType:'jsonp',  
        jsonp:"callback",
        data:{"token":localStorage.getItem("token")},
	    success: function(r){
	    	if(r.code === 0){
	    		vm.addresses= r.addressList;
			}else{
				alert(r.msg);
			}
		}
	});

}
