<?php

/**

*/
class Foods
{
	var $id;
	var $code;
	var $name;
	var $active;
	var $foodstypeid;
	var $remark;
	function __construct()
	{
		# code...
		$id="";
		$code="";
		$name="";
		$active="";
		$foodstypeid="";
		$remark="";
		$table="";
		$pkfield="";
	}
}


/**
* ประเภทอาหาร เช่น อาหาร เครื่องดื่ม 
*/
class FoodsType 
{
	var $id,$code,$typename,$active,$remark;
	function __construct()
	{
		# code...
		$id="";
		$code="";
		$typename="";
		$active="";
		$remark="";
		$table="";
		$pkfield="";
	}
}
/**
* 
*/
class Order 
{
	var $id, $foodsid, $orderdate, $price,$qty,$remark;
	function __construct()
	{
		# code...
		$id="";
		$foodsid="";
		$orderdate="";
		$price="";
		$qty="";
		$remark="";
		$lotid="";
		$rescode="";
		$tablecode="";
		$deviceid="";
		$areacode="";
		$active="";
		$statusfoods1="";
		$statusfoods2="";
		$statusfoods3="";
		$statusbill="";
		$billcheckdate="";
		$statuscook="";
		$cookreceivedate="";
		$cookfinishdate="";
		$statusvoid="";
		$voiddate="";

		$table="";
		$pkfield="";
	}
}

?>