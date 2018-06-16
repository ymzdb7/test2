
var content;
var curWwwPath=window.document.location.href;
var pathName=window.document.location.pathname;
var pos=curWwwPath.indexOf(pathName);
var localhostPath=curWwwPath.substring(0,pos);

function getid(){
	var url = location.search;	
	var theRequest = new Object();   
	   if (url.indexOf("?") != -1) {   
	      var str = url.substr(1);   
	      strs = str.split("&");   
	      for(var i = 0; i < strs.length; i ++) { 
	   
	         theRequest[strs[i].split("=")[0]]=unescape(strs[i].split("=")[1]);  //前边是=前边的, 后边是=号后边的
	      }   
	   }   
	   return theRequest;   
	} ;  
var pamer=getid();
var id=pamer.id;




$(document).ready(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'restaurant/carteBankDishes/list/'+id,
        datatype: "json",
   
        colModel: [			
			{ label: 'id', name: 'id', width: 30, key: true},
			{ label: '菜品id', name: 'dishesId', width: 70 }, 				
			{ label: '菜名', name: 'dishes', width: 150 }
        ],
		viewrecords: true,
        height: 385,
      /*  rowNum: 10,
		rowList : [10,30,50],*/
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
   
    function showPic(cellvalue, options, rowObject){
    	var str = '<img src="'+localhostPath+'/file/read/readImg?filePath='+rowObject.dishesPicPath +'"  width="42" height="42">';
    	return str;
    }
});
var editor = new baidu.editor.ui.Editor(); 
editor.render("myEditor"); 
editor.ready(function(){
     editor.setContent("");
});




var vm = new Vue({
	el:'#rrapp',
	data:{
		q:{
			dishes: null
		},
		showList: true,
		title:null,
		type:{},
		dishes :{}
	},
	methods: {
	
		query: function () {
			vm.reload();
		},
		
		add: function(){
			vm.showList = false;
			vm.title = "修改";
			getTypeso();
			getDishes();
			
		},
		
		del: function () {
			var ids = getSelectedRows();
			if(ids == null){
				return ;
			}
			
		

			/*var boo=confirm('确定要删除选中的记录？');
        	if(boo==true){*/
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "restaurant/carteBankDishes/delete",
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
        	
		});
        	/*}*/
		},
	
		go: function(){
			location.href="/modules/restaurant/carteBank.html?token="+localStorage.getItem("token");
			},
		 //跳转到evaluate.html
     /*   evaluate:function(){
        	var id = getSelectedRow();
        	if(id == null){
				return ;
			}
        	location.href="/modules/restaurant/evaluate.html?id="+id+"&token="+localStorage.getItem("token"); //注入id
        },*/
		saveOrUpdate: function () {
            /*if(vm.validator()){
                return ;
            }*/
			
			
			var url = id != null ? "restaurant/carteBankDishes/save/"+id: "restaurant/dishes/update";
			var ides=[];
			$('input:checkbox[name=idList]:checked').each(function() {
				  if(this.checked) {
					  ides.push($(this).val());
					  }
					});
		
		$.ajax({
			type: "POST",
		    url: baseURL +url,
            contentType: "application/json",
		    data: JSON.stringify(ides),
		    success: function(r){
				if(r.code == 0){
					alert('操作成功');
                        vm.reload();
					
				}else{
					alert(r.msg);
				}
			}
		});
		},
		
		
		
	/*	
		getDishes: function(id){
			$.get(baseURL + "restaurant/dishes/info/"+id, function(r){
				vm.dishes = r.dishes;
			});
		},*/
		
	/*	getTypes:function(){
			$.post(baseURL + "restaurant/type/dishType", function(r){
			
				
				vm.type = r.type;
			});
			
		},
		*/
		
/*		getTypeso:function(){
		var cartType;
        $.ajax({
			url:"/restaurant/type/dishType",
			type:"post",
			success:function(data){
				vm.type=data.type;
				   cartType=data.type;//得到type实体集合
				   var cartStr = '';
				   for(var i=0;i<cartType.length;i++){
			        	var item = '<div>'+cartType[i].typeName+'</div>';
			        	cartStr += item;
			        	var typeName=cartType[i].typeName;
			        	
			        	 $.post(baseURL + "restaurant/carte/dishlist/"+typeName, function(r){
			        		vm.dishes=r.dishList;
			        		alert("___+++kkk"+vm.dishes);
			        
			    			});	
			        	
			        	
			        }
			        $('#cartDiv').html(cartStr); 
			 
			}
			});
			},*/
			
	
				
				
				
				
			
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
				postData:{'dishes': vm.q.dishes},
                page:page
            }).trigger("reloadGrid");
		}/*,
		validator: function () {
		  if(isBlank(vm.dishes.dishes)){
	                alert("菜名不能为空");
	                return true;
	       }
        }*/
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
        		getDishesById();
        	});						
	};
	


function getDishesById(){

    $.ajax({
		url:"/restaurant/carteBankDishes/getDishesByIdinfo/"+id,
		type:"post",
		success:function(data){
				$('input:checkbox[name=idList]').each(function() {
						 for (var i = 0; i < data.carteBankDishes.length; i++) {
						  if($(this).val()==data.carteBankDishes[i].dishesId) {
						  $(this).attr('checked','true');
							}
						 }
					});
				}
		});
	};

