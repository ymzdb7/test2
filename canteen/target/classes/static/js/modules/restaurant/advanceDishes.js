
var content;
var curWwwPath=window.document.location.href;
var pathName=window.document.location.pathname;
var pos=curWwwPath.indexOf(pathName);
var localhostPath=curWwwPath.substring(0,pos);
$(document).ready(function () {
	getAddress();
	getCalculate();
	getTypes();
    $("#jqGrid").jqGrid({
        url: baseURL + 'restaurant/advanceDishes/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', width: 30, key: true},
			{ label: '图片', name: 'advanceDishesPicPath', width: 50 ,formatter:showPic},
			{ label: '菜名', name: 'advanceDishes', width: 50 }, 
			{ label: '菜品单价', name: 'advDishesPrice', width: 50 }, 
		/*	{ label: '种类', name: 'typeName', width: 50 },*/
			{ label: '配料', name: 'batching', width: 70 }, 			
			{ label: '说明', name: 'instruction', width: 150 }
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
   
    function showPic(cellvalue, options, rowObject){
    	var str = '<img src="'+localhostPath+'/file/read/readImg?filePath='+rowObject.advanceDishesPicPath +'"  width="42" height="42">';
    	return str;
    }
});

var vm = new Vue({
	el:'#rrapp',
	data:{
		q:{
			advancedishes: null
		},
		showList: true,
		title:null,
		adType:{},
		calculate:{},
		addresses: {},
		advanceDishes :{}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			adStatus();
			getAddress();
			getCalculate();
			vm.showList = false;
			vm.title = "新增";
			vm.advanceDishes = {};
			var obj = document.getElementById("addImg");
			addImg.innerHTML  = "";
			getTypes();
			
		},
		update: function () {
			
			var obj = document.getElementById("addImg");
			addImg.innerHTML  = "";
			var id = getSelectedRow();
			if(id == null){
				return ;
			}
		
		    $.get(baseURL + "restaurant/advanceDishes/info/"+id, function(r){
		    	
		        vm.showList = false;
		        vm.title = "修改";
		        vm.advanceDishes = r.advanceDishes;
		        var divImg = document.getElementById("addImg");
		        var img = document.createElement("img");
		    　　　　		//设置 img 图片地址
		    　　　　		img.src = localhostPath+'/file/read/readImg?filePath='+r.advanceDishes.advanceDishesPicPath;
		    　　　　		img.width='50';
		    　　　　		img.id = 'dishPic';
		    　　　　		img.height = '50'
		    　　　　		divImg.appendChild(img);
		    　　　　		
		        
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
				    url: baseURL + "restaurant/advanceDishes/delete",
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
		 //跳转到evaluate.html
      /*  evaluate:function(){
        	var id = getSelectedRow();
        	if(id == null){
				return ;
			}
        	location.href="/modules/restaurant/evaluate.html?id="+id+"&token="+localStorage.getItem("token"); //注入id
        },*/
		saveOrUpdate: function () {
            if(vm.validator()){
                return ;
            }
			
          var url = vm.advanceDishes.id == null ? "restaurant/advanceDishes/save" : "restaurant/advanceDishes/update";
			var form = new FormData(document.getElementById("advanceDishForm"));
			$.ajax({
				type: "POST",
			    url: baseURL + url,
			    data:form,
			    contentType: false,
			    processData:false,
			    success: function(r){
			    	if(r.code === 0){
						alert(r.msg);
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
				postData:{'advanceDishes': vm.q.advanceDishes},
                page:page
            }).trigger("reloadGrid");
		},
		validator: function(){
		  if(isBlank(vm.advanceDishes.advanceDishes)){
	                alert("菜名不能为空");
	                return true;
	       }
		  	  if(isBlank(vm.advanceDishes.typeId)){
              alert("菜品类型不能为空");
              return true;
		  }
		 if(isBlank(vm.advanceDishes.advDishesPrice1)){
              alert("菜品价格不能为空");
              return true;
		  }
		  
		  var oInp = document.getElementById('inp');
			 if(isNaN(Number(oInp.value))){  //当输入不是数字的时候，Number后返回的值是NaN;然后用isNaN判断。
			            alert('菜品价格请填入数字！');
			            return true;
			}
		  
		  
		  if(isBlank(vm.advanceDishes.priceCounts)){
              alert("计量单位数量不能为空");
              return true;
		  }
		  var oInp = document.getElementById('inp1');
			 if(isNaN(Number(oInp.value))){  //当输入不是数字的时候，Number后返回的值是NaN;然后用isNaN判断。
			            alert('计量单位数量请填入数字！');
			            return true;
			}	 
		 
		   if(isBlank(vm.advanceDishes.calculateName)){
              alert("计量单位不能为空");
              return true;
		  }
		   
		   
		   
		   var fileVal = document.getElementById("f_file").value;
			  if(!fileVal){
			      alert("请上传图片！");
			      return true;
			  }
		   
			  
		   
		  if(isBlank(vm.advanceDishes.adDishesStatus)){
              alert("菜品状态不能为空");
              return true;
		  }
		  
		  if(isBlank(vm.advanceDishes.address)){
              alert("属地不能为空");
              return true;
		  }
		/*  if(isBlank(vm.advanceDishes.counts)){
              alert("库存数量不能为空");
              return true;
		  }*/
		 }
	}
});


function getTypes(){
	$.post(baseURL + "restaurant/adType/adDishsType", function(r){
		
		vm.adType = r.adType;
	});
	
}

function getCalculate() {
	$.get(baseURL + "restaurant/advanceDishes/infoCalculate", function(r){
		vm.calculate = r.calculate;
	});
}


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

function adStatus(){
	  /*   $("#nno").attr('checked',true);  */
	     $('#nno').prop('checked','true');  
	
}
