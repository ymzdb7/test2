
var content;
var curWwwPath=window.document.location.href;
var pathName=window.document.location.pathname;
var pos=curWwwPath.indexOf(pathName);
var localhostPath=curWwwPath.substring(0,pos);
$(document).ready(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'restaurant/carteBank/list',
        datatype: "json",
        colModel: [			
			{ label: 'id&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;菜单标题&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;创建时间&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;操作', name: 'carteBaList', width: 50,formatter:function(value,options,row){
				var str='<table>';
				for(var i=0;i<value.length;i++){
					var deleteOo="<input type='button' value='删除'  onclick='btn_deleteOo(\""+ value[i].id + "\")'>";
					var updateOo="<input type='button' value='修改'  onclick='btn_updateOo(\""+ value[i].id + "\")'>";
					   var date=value[i].createDate;
					   var dateo=date.substring(0,11);
					   
					str=str+'<tr><td width="50"><a href="javascript:void(0);" onclick="carteClick(this)">'+value[i].id+'</a></td>'+
								'<td width="200">'+value[i].title+'</td>'+
								'<td width="150">'+dateo+'</td>'
								+'<td>'+updateOo+'</td>'
								+'<td>'+deleteOo+'</td>'
							+'</tr>';
				}
				
				
				
				return str+'</table>';
				
			}}
			 ],
			 viewrecords: true,
		        height: 385,
		        rowNum: 10,
				rowList : [10,30,50],
		   /*     rownumbers: true, */
		        rownumWidth: 25, 
		        autowidth:true,
		       /* multiselect: true,*/
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

function btn_deleteOo(id){	
	var boo=confirm('确定要删除选中的记录？');
	if(boo==true){
	$.ajax({
		type: "POST",
	    url: baseURL + "restaurant/carteBank/deletee",
        contentType: "application/json",
	    data: JSON.stringify(id),
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
}

function btn_updateOo(id){	
	 $.get(baseURL + "restaurant/carteBank/info/"+id, function(r){
        vm.showList = false;
       vm.showListNo=true,
		vm.showListNoo=false,
        vm.title = "修改";
        vm.carteBank = r.carteBank;
   
    	
 });
}



function carteClick (obj) {  
	var id=$(obj).text();

	location.href="/modules/restaurant/carteBankDishes.html?id="+id+"&token="+localStorage.getItem("token"); //注入id
}  


/*evaluate:function(){
	var id = getSelectedRow();
	if(id == null){
		return ;
	}
	location.href="/modules/restaurant/evaluate.html?id="+id+"&token="+localStorage.getItem("token"); //注入id
},*/




var vm = new Vue({
	el:'#rrapp',
	data:{
		q:{
			carteTime: null
		},
		showList: true,
		showListNo:false,
		showListNoo:false,
		title:null,
		type:{},
		dishes:{},
		carteBank :{}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.showListNo=true,
			vm.showListNoo=true,
			vm.title = "新增";
			vm.carteBank = {};
			getTypeso();
			getDishes();
	},
		
	
		saveOrUpdate: function () {
            if(vm.validator()){
                return ;
            }
		
			var ides=[];
			$('input:checkbox[name=idList]:checked').each(function() {
		
				  if(this.checked) {
					  ides.push($(this).val());
					  }
					});
			
			var url = vm.carteBank.id == null ? "restaurant/carteBank/save/"+ides : "restaurant/carteBank/update";
			var form = new FormData(document.getElementById("carteBankForm"));
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
						/*	location.reload([bForceGet]);*/
						
					}else{
						alert(r.msg);
					}
				}
			});
		},
		reload: function (event) {
			vm.showList = true;
			vm.showListNo =false;
			vm.showListNoo =false;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			vm.dishes={};
			$("#jqGrid").jqGrid('setGridParam',{ 
				postData:{'title': vm.q.title},
                page:page
            }).trigger("reloadGrid");
		},
		validator: function () {
		  if(isBlank(vm.carteBank.title)){
	                alert("菜单标题不能为空");
	                return true;
	       }
        }
	}
});

function getTypeso(){
	var cartType;
    $.ajax({
		url:"/restaurant/type/dishType",
		type:"post",
		success:function(data){
			vm.type=data.type;	 
		}
		});
	};
function getDishes(){				
		 $.post(baseURL + "restaurant/carte/dishlist", function(r){
        		vm.dishes=r.dishList;
        	});						
	};

