CREATE TABLE IF NOT EXISTS API(
	Api_Id INT NOT NULL ,
	Api_Name VARCHAR(500) NOT NULL UNIQUE,
	Fk_Api_Env_Id INT NOT NULL,
	Fk_Api_Data_Src_Id INT NOT NULL,
	Api_Status BOOLEAN NOT NULL,
	Api_Description VARCHAR(1000) NOT NULL,

	constraint pk_api primary key(Api_id)

);
ALTER TABLE API ALTER COLUMN API_ID INT NOT NULL AUTO_INCREMENT;


CREATE TABLE IF NOT EXISTS API_TABLE(
	Api_Table_Id INT NOT NULL ,
	Fk_Api_Id INT NOT NULL,
	Instance_Name VARCHAR(500) NOT NULL,
	Column_Name VARCHAR(500) NOT NULL,

	constraint pk_api_table primary key(Api_Table_Id)
);
ALTER TABLE API_TABLE  ALTER COLUMN API_TABLE_ID  INT NOT NULL AUTO_INCREMENT;

CREATE TABLE IF NOT EXISTS AUDIT_TRACE(
	Audit_Id INT NOT NULL ,
	Fk_Api_Id INT NOT NULL,
	Fk_Event_Id INT NOT NULL,
	Event_Message VARCHAR(500) NOT NULL,
	Event_Date DATETIME DEFAULT CURRENT_TIMESTAMP,

	constraint pk_audit_trace primary key(Audit_Id)
);
ALTER TABLE AUDIT_TRACE  ALTER COLUMN AUDIT_ID  INT NOT NULL AUTO_INCREMENT;

CREATE TABLE API_HIVE_TABLE(
	Api_Hive_Table_Id INT NOT NULL,
	Fk_Api_Id INT NOT NULL,
	Db_Name VARCHAR(100) NOT NULL,
	Query VARCHAR(10000) NOT NULL,
	Data_Aggr_Key VARCHAR(200) NOT NULL,
	Json_Schema VARCHAR(MAX) NOT NULL,

  constraint pk_api_hive_table primary key(Api_Hive_Table_Id)
);
ALTER TABLE API_HIVE_TABLE  ALTER COLUMN API_HIVE_TABLE_ID  INT NOT NULL AUTO_INCREMENT;

CREATE TABLE API_SCHEDULER(
	Api_Scheduler_Id INT NOT NULL,
	Fk_Api_Id INT NOT NULL,
	Scheduler_Name VARCHAR(100) NOT NULL,
	Schedule_Date DATE NOT NULL,
	Schedule_Time TIME NOT NULL,
	Recur_Value INTEGER,
	Fk_Recur_Type VARCHAR(2),
	Schedule_Added BOOLEAN NOT NULL,

	constraint pk_api_scheduler primary key(Api_Scheduler_Id)
);
ALTER TABLE API_SCHEDULER  ALTER COLUMN API_SCHEDULER_ID  INT NOT NULL AUTO_INCREMENT;

CREATE TABLE IF NOT EXISTS API_EVENT(
	Event_Id INT NOT NULL,
	Event_Code VARCHAR(20) NOT NULL,

	constraint pk_event primary key(Event_id)
);
insert into api_event values(1,'API_CREATED');
insert into api_event values(2,'API_DELETED');
insert into api_event values(3,'API_ACTIVATED');
insert into api_event values(4,'API_DEACTIVATED');
insert into api_event values(5,'DESC_MODIFIED');
insert into api_event values(6,'TABLE_MODIFIED');
insert into api_event values(7,'COLUMN_MODIFIED');
insert into api_event values(8,'ENVIRONMENT_MODIFIED');
insert into api_event values(9,'HIVE_DTLS_MODIFIED');

CREATE TABLE IF NOT EXISTS API_ENV(
	Env_Id INT NOT NULL,
	Env_Name VARCHAR(200) NOT NULL,
	Env_Value VARCHAR(200) NOT NULL,
	constraint pk_api_env primary key(Env_Id)
);
insert into api_env values(1,'Dev','dev_');
insert into api_env values(2,'QA','qa_');
insert into api_env values(3,'Stress','uat_');
insert into api_env values(4,'Prod','prod_');
insert into api_env values(5,'Any','all');


CREATE TABLE IF NOT EXISTS API_DATA_SOURCE(
	Api_Data_Src_Id INT NOT NULL,
	Api_Data_Src_Name VARCHAR(200) NOT NULL,

	constraint pk_api_data_src primary key(Api_Data_Src_Id)
);

insert into api_data_source values(1,'HBase');
insert into api_data_source values(2,'Hive');

CREATE TABLE IF NOT EXISTS SCHEDULE_RECUR_TYPE(
	Schedule_Recur_Type_Id VARCHAR(2) NOT NULL,
	Schedule_Recur_Type_Name VARCHAR(10) NOT NULL,

	constraint pk_sch_recur_type primary key(Schedule_Recur_Type_Id)
);

insert into schedule_recur_type values('h','Hours');
insert into schedule_recur_type values('d','Days');
insert into schedule_recur_type values('w','Weeks');
insert into schedule_recur_type values('M','Months');