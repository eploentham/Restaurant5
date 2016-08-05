<?php
include "classes.php";

$objConnect = mysql_connect("localhost","root","");
$objDB = mysql_select_db("restaurant");
mysql_query("SET NAMES UTF8");


$or = new Order();
//$footy = new FoodsType();
//$ord = new Order();
$or->id="order_id";
$or->foodsid="foods_code";
$or->orderdate="order_date";
$or->price="price";
$or->qty="qty";
$or->remark="remark";
$or->lotid="lot_id";
$or->rescode="res_code";
$or->tablecode="table_code";
$or->deviceid="device_id";
$or->areacode="area_code";
$or->statusfoods1="status_foods_1";
$or->statusfoods2="status_foods_2";
$or->statusfoods3="status_foods_3";
$or->statusbill="status_bill";
$or->billcheckdate="bill_check_date";
$or->statuscook="status_cook";
$or->cookreceivedate="cook_receive_date";
$or->cookfinishdate="cook_finish_date";
$or->statusvoid="status_void";
$or->voiddate="void_date";
$or->active="active";

$or->table="t_order";

//$sql = "Insert into ".$foo->table."(".$foo->id.",".$foo->code.",".$foo->name.",".$foo->active.",".$foo->foodstypeid.",".$foo->remark.")".
//" value ('".$f->id."','".$f->code."','".$f->name."','".$f->active."','".$f->foodstypeid."','".$f->remark."')";
//$sql = "Insert into ".$or->table."(".$or->id.",".$or->foodsid.",".$or->orderdate.",".$or->price.",".$or->qty.",".$or->remark.")".
//" value ('".$_POST['order_id']."','".$_POST['foods_code']."',now(),'1','".$_POST['qty']."','".$_POST['remark']."')";
$sql = "Insert into ".$or->table."(".$or->id.",".$or->foodsid.",".$or->orderdate.",".$or->price.",".$or->qty.",".$or->lotid.",".$or->rescode.",".$or->tablecode.","
.$or->areacode.",".$or->statusfoods1.",".$or->statusfoods2.",".$or->statusfoods3.",".$or->active.",".$or->statusvoid.",".$or->statusbill.",".$or->statuscook.")".
" value ('".$_POST['order_id']."','".$_POST['foods_code']."',now(),'1','".$_POST['qty']."','".$_POST['lot_id']."','".$_POST['res_code']."','".$_POST['table_code']."','"
.$_POST['area_code']."','".$_POST['status_foods_1']."','".$_POST['status_foods_2']."','".$_POST['status_foods_3']."','1','0','0','0')";
$objQuery = mysql_query($sql);
$response = array();
$resultArray = array();
$response["success"] = 1;
$response["message"] = "insert Order success";
array_push($resultArray,$response);
echo json_encode($resultArray);


?>