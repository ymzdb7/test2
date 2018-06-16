
var content;
var curWwwPath=window.document.location.href;
var pathName=window.document.location.pathname;
var pos=curWwwPath.indexOf(pathName);
var localhostPath=curWwwPath.substring(0,pos);
$(document).ready(function () {
	
    $("#jqGrid").jqGrid({
        url: baseURL + 'restaurant/order/list',
        datatype: "json",
        colModel: [			
    		{ label: 'id', name: 'id', width: 20, key: true},
			{ label: '订单收货人', name: 'orConsignee', width: 30 },
    		{ label: '电话', name: 'orderPhone', width: 40 }, 
			{ label: '下单时间', name: 'orderTime', width: 50 }, 
			{ label: '属地', name: 'address', width: 50 }, 
			{ label: '订单号', name: 'orderNumber', width: 50 },
			

			{ label: '订单状态', name: 'orderState', width: 30/*,formatter:function(value,options,row){
				if(value==1){
					
					return '<span>预定成功</span>'
				}
				if(value==2){
					
					return '<span>交易成功</span>'
				}
				if(value==3){
					
					return '<span>订单取消</span>'
				}
			}*/},
			
			
			{ label: '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;详情', name: 'id', width: 30, formatter: function(value, options, row){
				var detail="<input type='button' value='查看'  onclick='btn_detail(\""+ value + "\")'>";
                return "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+detail;
			}},
			{ label: '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;操&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;作', name: 'id', width: 70, formatter: function(value, options, row){
				var updateState1="<input type='button' value='交易成功'  onclick='updateState1(\""+ value + "\")'>";
				var updateState2="<input type='button' value='订单取消'  onclick='updateState2(\""+ value + "\")'>";
                return "&nbsp;&nbsp;&nbsp;"+updateState1+"&nbsp;&nbsp;"+updateState2;
			}}
		
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
			typeName: null
		},
		showList: true,
		showListNo:false,
		showListNo1:false,
		showListNo2:false,
		title:null,
		adDishes:{},
		order:{},
		orderList:{},
		adDishesHeeList:{},
		orderState:["预定成功","交易成功","订单取消"]
	},
	methods: {
		query: function () {
			vm.reload();
		},
		hisOrder: function(){
			  vm.showList = false;
			  vm.showListNo=false;
			  vm.showListNo1=true;
			  vm.showListNo2=false;
              vm.title = "历史订单";
			 $.get(baseURL + "restaurant/order/hisOrder", function(r){
	              
	                vm.orderList = r.orderList;
	              });
		},
		
		adDishesAdd:function(){
			
			 /* vm.showList = false;
			  vm.showListNo=false;
			  vm.showListNo1=false;
			  vm.showListNo2=true;
              vm.title = "历史订单";
			 $.get(baseURL + "restaurant/order/adDishesAdd", function(r){
	              
	                vm.adDishesHeeList = r.adDishesHeeList;
	              });*/
			
		  	location.href="/modules/restaurant/adDishesCounts.html?token="+localStorage.getItem("token");
			
		},

		reload: function (event) {
			vm.showList = true;
			vm.showListNo=false;
			vm.showListNo1=false;
			vm.showListNo2=false;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
				postData:{'typeName': vm.q.typeName},
                page:page
            }).trigger("reloadGrid");
		}/*,
		validator: function () {
		  if(isBlank(vm.type.typeName)){
	                alert("菜品类型不能为空");
	                return true;
	       }
        }*/
	}
});


//修改订单状态为交易成功
function updateState1(id){
	
	$.get(baseURL+"restaurant/order/orderState1/"+id,function(r){
		
	if(r.order11.orderState=="交易成功"||r.order11.orderState=="订单取消"){
		alert("只可对订单状态预定成功进行操作!");
		
	}else{
		 if(confirm('确定对方已付款了吗?')) 
		    { 
			 
				$.get(baseURL+"restaurant/order/updateState1/"+id,function(r){
					if(r.code === 0){
						/*alert('操作成功');*/
						 	vm.reload();
					}else{
						alert(r.msg);
					}
				});
		        return true; 
		        vm.reload();
		    } 
		    return false; 
		}
	});

}

//修改订单状态为订单取消
function updateState2(id){
	$.get(baseURL+"restaurant/order/orderState1/"+id,function(r){	
		if(r.order11.orderState=="订单取消"){
			alert("只可对订单状态预定成功、交易成功进行操作!");
		}else{
			 if(confirm('确定取消订单吗?')) 
			    { 
			$.get(baseURL+"restaurant/order/updateState2/"+id,function(r){
				if(r.code === 0){
					alert(r.msg);
						vm.reload();
					
				}else{
					alert(r.msg);
				}
			});
			  return true; 
		        vm.reload();
			
			    } 
			    return false; 
		}
	});
}


function btn_detail(id){	
	$.get(baseURL +"restaurant/order/detail?id="+id,function(r){
		if(r.adDishes!=null){
		vm.showList=false;
		vm.showListNo=true;
		vm.showListNo1=false;
		vm.showListNo2=false;
		vm.adDishes=r.adDishes;
		vm.order=r.order;
		}
	});

}
