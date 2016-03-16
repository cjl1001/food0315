--用户表
drop TABLE if exists TbUsers; 
 CREATE TABLE TbUsers (
        uId serial primary key,
        aId int,
        sUserName varchar(20),
        sPassword varchar(20),
        sTel char(11),
        dCreatDate date,
	dLastDate date,
	mCostMoney money,
	iUserPoint int,
	iRoleLevel int
    );

    --类别表
    drop TABLE if exists TbCategory; 
 CREATE TABLE TbCategory (
        cId serial primary key,
	sCateName varchar(20),
	parentId int
    );
    
    --收货地址表
    drop TABLE if exists TbAddress; 
 CREATE TABLE TbAddress (
        aId serial primary key,
        uId int,
	address varchar(50)
    );
    --商家表
	drop TABLE if exists TbMerchant; 
 CREATE TABLE TbMerchant (
        mcId serial primary key,
        mcName varchar(20),
	mcAddres varchar(50),
	mcNum varchar(20)
    );
    --菜单汇总表
    drop table if exists TbMenuSummary;
 create table TbMenuSummary(
	msId serial primary key,
	mcNum varchar(20),
	sMenuName varchar(20),
	mPrice money,
	favorStatus int,
	cId int,
	sMenuNum varchar(20),
	sMenuPicture varchar(100)
    ); 
    --订单表
   drop table if exists TbOrder;
 create table TbOrder(
	oId serial primary key,
	uId int,
	mcId int,
	aId int,
	mTotalCost money,
	orderTime time,
	orderStatus int,
	orderNum varchar(20),
	orderRemark text
    ); 
    --订单详情表
    drop table if exists TbOrderDetail;
 create table TbOrderDetail(
	dId serial primary key,
	msId int,
	oId int,
	iCount int,
	mPrice money,
	mTotalMoney money
    ); 
    --销量表
    drop table if exists TbSale;
 create table TbSale(
	sId serial primary key,
	uId int,
	mcId int,
	oId int,
	mSaleMoney money,
	dSaleDate date
    ); 
