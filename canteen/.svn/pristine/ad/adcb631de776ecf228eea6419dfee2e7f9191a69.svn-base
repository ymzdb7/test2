
var content;
var curWwwPath=window.document.location.href;
var pathName=window.document.location.pathname;
var pos=curWwwPath.indexOf(pathName);
var localhostPath=curWwwPath.substring(0,pos);
$(document).ready(function () {
	time1();
    $("#jqGrid").jqGrid({
        url: baseURL + 'restaurant/carte/lists',
        datatype: "json",
        colModel: [			
			{ label: '菜单日期', name: 'carteDayList', width: 30,formatter:function(value,options,row){
			    var date=new Date(value[0].carteDate);
			    var dateo=value[0].carteDate;
			    var dateoo=dateo.substring(0,11);
			    var week;
			    	if(date.getDay()==0) week="周日";
			    	if(date.getDay()==1) week="周一";
			    	if(date.getDay()==2) week="周二";
			    	if(date.getDay()==3) week="周三";
			    	if(date.getDay()==4) week="周四";
			    	if(date.getDay()==5) week="周五";
			    	if(date.getDay()==6) week="周六";
			    
				return '<table><tr>'+dateoo+"-"+week+'</tr></table>';
				
			}},
			{ label: 'id&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;标题&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;选餐时间&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;属地&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;操作', name: 'carteDayList', width: 50,formatter:function(value,options,row){
				var str='<table>';
			
				for(var i=0;i<value.length;i++){
					var deleteOo="<input type='button' value='删除'  onclick='btn_deleteOo(\""+ value[i].id + "\")'>";
					var updateOo="<input type='button' value='修改'  onclick='btn_updateOo(\""+ value[i].id + "\")'>";
					str=str+'<tr><td width="50"><a href="javascript:void(0);" onclick="carteClick(this)">'+value[i].id+'</a></td>'+
								'<td width="150">'+value[i].title+'</td>'+
								'<td width="125">'+value[i].sel+'</td>'
								+
								'<td width="100">'+value[i].address+'</td>'
								+'<td>'+updateOo+'</td>'
								+'<td>'+deleteOo+'</td>'
							+'</tr>';
				}
				return str+'</table>';
				
			}}
			 ],
			/* viewrecords: true,*/
		        height: 385,
		      /*  rowNum: 10,*/
				/*rowList : [10,30,50],*/
		        rownumbers: true, 
		        rownumWidth: 25, 
		        autowidth:true,
		      /*  multiselect: true,*/
		        pager: "#jqGridPager",
		        jsonReader : {
		            root: "page.list",
		            page: "page.currPage"
		            /*total: "page.totalPage",*/
		            /*records: "page.totalCount"*/
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
	/*confirm('确定要删除选中的记录？', function(){*/
	$.ajax({
		type: "POST",
	    url: baseURL + "restaurant/carte/deletee",
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
	/*});*/}
}

function btn_updateOo(id){	
	time();
	vm.carte.carteDateStr=$('#carteDateStr').val();
			getAddress();
	 $.get(baseURL + "restaurant/carte/infoo/"+id, function(r){
        vm.showList = false;
        vm.title = "修改";
   
        vm.carte = r.carte;
 
        
 });
}



function carteClick (obj) {  
	var id=$(obj).text();

	location.href="/modules/restaurant/carteTypeDishes.html?id="+id+"&token="+localStorage.getItem("token"); //注入id
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
		title:null,
		addresses:{},
		carte :{
			carteDateStr:null
			},
		selTimes:["早餐","中餐","晚餐"],
		carteBankList:{}
	
		
		
	},
	methods: {
		query: function () {
			vm.q.carteTime=$('#carteTime').val();
			vm.reload();
		},
		add: function(){
			vm.carte.carteDateStr=$('#carteDateStr').val();
		
			vm.showList = false;
			vm.title = "新增";
			vm.carte = {};
			getAddress();
			this.getCarteBank();
			time();
	
			
			
		},
			getCarteBank: function(){
				$.get(baseURL + "restaurant/carteTypeDishes/infooo", function(r){
			vm.carteBankList = r.carteBankList;
			
		});
	},
		
		
		/*update: function () {
			var id = getSelectedRow();
			if(id == null){
				return ;
			}
			
            $.get(baseURL + "restaurant/type/info/"+id, function(r){
                vm.showList = false;
                vm.title = "修改";
                console.log("type:",r.type);
                vm.type = r.type;
              });
		},	*/
		/*del: function () {
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
		*/
	
		saveOrUpdate: function () {
			vm.carte.carteDateStr=$('#carteDateStr').val();
		
            if(vm.validator()){
                return ;
            }
           
			var url = vm.carte.id == null ? "restaurant/carte/save" : "restaurant/carte/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
			    contentType: "application/json",
			    data: JSON.stringify(vm.carte),
			    success: function(r){
			    	if(r.code === 0){
						alert("操作成功！");
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
				postData:{'time': vm.q.carteTime},
                page:page
            }).trigger("reloadGrid");
		},
		
	
		validator: function () {
		  if(isBlank(vm.carte.title)){
	                alert("菜单标题不能为空");
	                return true;
	       }
		  if(isBlank(vm.carte.sel)){
              alert("选餐时间不能为空");
              return true;
		  }
		  if(isBlank(vm.carte.address)){
              alert("属地不能为空");
              return true;
		  }
		  if(isBlank(vm.carte.carteDateStr)){
              alert("菜单时间不能为空");
              return true;
		  }
		  
		  
        }
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
	/*getLoginAddress();*/
}



/*function getLoginAddress(){				
	 $.post(baseURL + "restaurant/carte/getLoginAddress", function(r){
		 
   		vm.addresses=r.addressGet;
   		alert("_____r.addressGet:"+r.addressGet);
   	});						
};*/
function time1(){
	$('#datetimepicker1').datetimepicker({
		 autoclose: 1,
		 language: 'zh-CN',
		 weekStart:1,
		 todayBtn:1,
		 todayHighlight:1,
		 startView:2,
		 minView:2,
		 forceParse:0

	});
}

 function time(){
	$('#datetimepicker').datetimepicker({
		 autoclose: 1,
		 language: 'zh-CN',
		 weekStart:1,
		 todayBtn:1,
		 todayHighlight:1,
		 startView:2,
		 minView:2,
		 forceParse:0

	});
}
