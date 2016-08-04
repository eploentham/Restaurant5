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

$or->table="t_order";

//$sql = "Insert into ".$foo->table."(".$foo->id.",".$foo->code.",".$foo->name.",".$foo->active.",".$foo->foodstypeid.",".$foo->remark.")".
//" value ('".$f->id."','".$f->code."','".$f->name."','".$f->active."','".$f->foodstypeid."','".$f->remark."')";
//$sql = "Insert into ".$or->table."(".$or->id.",".$or->foodsid.",".$or->orderdate.",".$or->price.",".$or->qty.",".$or->remark.")".
//" value ('".$_POST['order_id']."','".$_POST['foods_code']."',now(),'1','".$_POST['qty']."','".$_POST['remark']."')";
$sql = "Insert into ".$or->table."(".$or->id.",".$or->foodsid.",".$or->orderdate.",".$or->price.",".$or->qty.",".$or->lotid.",".$or->rescode.",".$or->tablecode.",".$or->areacode.")".
" value ('".$_POST['order_id']."','".$_POST['foods_code']."',now(),'1','".$_POST['qty']."','".$_POST['lot_id']."','".$_POST['res_code']."','".$_POST['table_code']."','".$_POST['area_code']."')";
$objQuery = mysql_query($sql);
$response = array();
$response["success"] = 1;
$response["message"] = "insert Order success";
echo json_encode($response);


?>