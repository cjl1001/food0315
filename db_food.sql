drop table TbAddress CASCADE;

drop table TbCategory CASCADE;

drop table TbMenuSummary CASCADE;

drop table TbMerchant CASCADE;

drop table TbOrder CASCADE;

drop table TbOrderDetail CASCADE;

drop table TbSale CASCADE;

drop table TbUsers CASCADE;

/*==============================================================*/
/* Table: TbAddress                                             */
/*==============================================================*/
create table TbAddress (
   aId                  SERIAL not null,
   uId                  INT4                 not null,
   address              VARCHAR(50)          not null,
   constraint PK_TBADDRESS primary key (aId)
);

/*==============================================================*/
/* Table: TbCategory                                            */
/*==============================================================*/
create table TbCategory (
   cId                  SERIAL not null,
   sCateName            VARCHAR(20)          not null,
   parentId             INT4                 not null,
   constraint PK_TBCATEGORY primary key (cId)
);

/*==============================================================*/
/* Table: TbMenuSummary                                         */
/*==============================================================*/
create table TbMenuSummary (
   msId                 SERIAL not null,
   mcNum                VARCHAR(20)          not null,
   sMenuName            VARCHAR(20)          not null,
   mPrice               FLOAT8               not null,
   favorStatus          INT4                 not null,
   cId                  INT4                 not null,
   sMenuNum             VARCHAR(20)          not null,
   sMenuPicture         VARCHAR(100)         not null,
   constraint PK_TBMENUSUMMARY primary key (msId)
);

/*==============================================================*/
/* Table: TbMerchant                                            */
/*==============================================================*/
create table TbMerchant (
   mcId                 SERIAL not null,
   mcName               VARCHAR(20)          not null,
   mcAddres             VARCHAR(50)          not null,
   mcNum                VARCHAR(20)          not null,
   constraint PK_TBMERCHANT primary key (mcId),
   constraint AK_UQ_MCNUM_TBMERCHA unique (mcNum)
);

/*==============================================================*/
/* Table: TbOrder                                               */
/*==============================================================*/
create table TbOrder (
   oId                  SERIAL not null,
   Smerchant            VARCHAR(20)          not null,
   SuserName            VARCHAR(20)          not null,
   MtotalCost           FLOAT8               not null,
   TorderTime           timestamp without time zone                   not null,
   IorderStatus         INT4                 not null,
   SorderNum            VARCHAR(20)          not null,
   TorderRemark         TEXT                 not null,
   SorderAddress        VARCHAR(50)          not null,
   constraint PK_TBORDER primary key (oId)
);

/*==============================================================*/
/* Table: TbOrderDetail                                         */
/*==============================================================*/
create table TbOrderDetail (
   dId                  SERIAL not null,
   msId                 INT4                 not null,
   oId                  INT4                 not null,
   iCount               INT4                 not null,
   mPrice               FLOAT8               not null,
   mTotalMoney          FLOAT8               not null,
   constraint PK_TBORDERDETAIL primary key (dId)
);

/*==============================================================*/
/* Table: TbSale                                                */
/*==============================================================*/
create table TbSale (
   sId                  SERIAL not null,
   uId                  INT4                 not null,
   mcId                 INT4                 not null,
   oId                  INT4                 not null,
   mSaleMoney           FLOAT8               not null,
   dSaleDate            timestamp without time zone                 not null,
   constraint PK_TBSALE primary key (sId)
);

/*==============================================================*/
/* Table: TbUsers                                               */
/*==============================================================*/
create table TbUsers (
   uId                  SERIAL not null,
   SuserName2           VARCHAR(20)          not null,
   sPassword            VARCHAR(20)          not null,
   sTel                 CHAR(11)             not null,
   dCreatDate           timestamp without time zone                 not null,
   dLastDate            timestamp without time zone                 null,
   mCostMoney           FLOAT8               not null,
   iUserPoint           INT4                 not null,
   iRoleLevel           INT4                 not null,
   constraint PK_TBUSERS primary key (uId)
);

select * from tbusers;
select * from tbaddress;

/*DROP SEQUENCE public.hibernate_sequence;

CREATE SEQUENCE public.hibernate_sequence
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE public.hibernate_sequence
  OWNER TO postgres;*/


/*
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
*/
