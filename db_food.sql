drop table TbAddress;

drop table TbCategory;

drop table TbMenuSummary;

drop table TbMerchant;

drop table TbOrder;

drop table TbOrderDetail;

drop table TbSale;

drop table TbUsers;

/*==============================================================*/
/* Table: TbAddress                                             */
/*==============================================================*/
create table TbAddress (
   aId                  SERIAL not null,
   uId                  INT4                 null,
   address              VARCHAR(50)          null,
   constraint PK_TBADDRESS primary key (aId)
);

/*==============================================================*/
/* Table: TbCategory                                            */
/*==============================================================*/
create table TbCategory (
   cId                  SERIAL not null,
   sCateName            VARCHAR(20)          null,
   parentId             INT4                 null,
   constraint PK_TBCATEGORY primary key (cId)
);

/*==============================================================*/
/* Table: TbMenuSummary                                         */
/*==============================================================*/
create table TbMenuSummary (
   msId                 SERIAL not null,
   mcNum                VARCHAR(20)          null,
   sMenuName            VARCHAR(20)          null,
   mPrice               FLOAT8               null,
   favorStatus          INT4                 null,
   cId                  INT4                 null,
   sMenuNum             VARCHAR(20)          null,
   sMenuPicture         VARCHAR(100)         null,
   constraint PK_TBMENUSUMMARY primary key (msId)
);

/*==============================================================*/
/* Table: TbMerchant                                            */
/*==============================================================*/
create table TbMerchant (
   mcId                 SERIAL not null,
   mcName               VARCHAR(20)          null,
   mcAddres             VARCHAR(50)          null,
   mcNum                VARCHAR(20)          not null,
   constraint PK_TBMERCHANT primary key (mcId),
   constraint AK_UQ_MCNUM_TBMERCHA unique (mcNum)
);

/*==============================================================*/
/* Table: TbOrder                                               */
/*==============================================================*/
create table TbOrder (
   oId                  SERIAL not null,
   Smerchant            VARCHAR(20)          null,
   SuserName            VARCHAR(20)          null,
   MtotalCost           FLOAT8               null,
   TorderTime           TIME                 null,
   IorderStatus         INT4                 null,
   SorderNum            VARCHAR(20)          null,
   TorderRemark         TEXT                 null,
   SorderAddress        VARCHAR(50)          null,
   constraint PK_TBORDER primary key (oId)
);

/*==============================================================*/
/* Table: TbOrderDetail                                         */
/*==============================================================*/
create table TbOrderDetail (
   dId                  SERIAL not null,
   msId                 INT4                 null,
   oId                  INT4                 null,
   iCount               INT4                 null,
   mPrice               FLOAT8               null,
   mTotalMoney          FLOAT8               null,
   constraint PK_TBORDERDETAIL primary key (dId)
);

/*==============================================================*/
/* Table: TbSale                                                */
/*==============================================================*/
create table TbSale (
   sId                  SERIAL not null,
   uId                  INT4                 null,
   mcId                 INT4                 null,
   oId                  INT4                 null,
   mSaleMoney           FLOAT8               null,
   dSaleDate            DATE                 null,
   constraint PK_TBSALE primary key (sId)
);

/*==============================================================*/
/* Table: TbUsers                                               */
/*==============================================================*/
create table TbUsers (
   uId                  SERIAL not null,
   SuserName2           VARCHAR(20)          null,
   sPassword            VARCHAR(20)          null,
   sTel                 CHAR(11)             null,
   dCreatDate           DATE                 null,
   dLastDate            DATE                 null,
   mCostMoney           FLOAT8               null,
   iUserPoint           INT4                 null,
   iRoleLevel           INT4                 null,
   constraint PK_TBUSERS primary key (uId)
);

alter table TbAddress
   add constraint FK_TBADDRES_REFERENCE_TBUSERS foreign key (uId)
      references TbUsers (uId)
      on delete restrict on update restrict;

alter table TbMenuSummary
   add constraint FK_TBMENUSU_REFERENCE_TBMERCHA foreign key (mcNum)
      references TbMerchant (mcNum)
      on delete restrict on update restrict;

alter table TbMenuSummary
   add constraint FK_TBMENUSU_REFERENCE_TBCATEGO foreign key (cId)
      references TbCategory (cId)
      on delete restrict on update restrict;

alter table TbOrderDetail
   add constraint FK_TBORDERD_REFERENCE_TBMENUSU foreign key (msId)
      references TbMenuSummary (msId)
      on delete restrict on update restrict;

alter table TbOrderDetail
   add constraint FK_TBORDERD_REFERENCE_TBORDER foreign key (oId)
      references TbOrder (oId)
      on delete restrict on update restrict;

alter table TbSale
   add constraint FK_TBSALE_REFERENCE_TBUSERS foreign key (uId)
      references TbUsers (uId)
      on delete restrict on update restrict;

alter table TbSale
   add constraint FK_TBSALE_REFERENCE_TBMERCHA foreign key (mcId)
      references TbMerchant (mcId)
      on delete restrict on update restrict;

alter table TbSale
   add constraint FK_TBSALE_REFERENCE_TBORDER foreign key (oId)
      references TbOrder (oId)
      on delete restrict on update restrict;
