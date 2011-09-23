BEGIN TRANSACTION;
CREATE TABLE help_bu_items (
	id INTEGER PRIMARY KEY, 
	kind_of_item NUMERIC, 
	description TEXT, 
	measure_bu TEXT, 
	measure_wt TEXT);
COMMIT;

CREATE TABLE insulin_items (
	id INTEGER PRIMARY KEY, 
	description 	TEXT, 
	time_start 	REAL, 
	time_end   	REAL, 
	time_max_start 	REAL, 
	time_max_end 	REAL,
	color  		TEXT 
);
COMMIT;

CREATE TABLE profiles (
	id INTEGER PRIMARY KEY, 
	code	 	TEXT, 
	name	 	TEXT, 
	sex 		INT, 
	age	   	INT, 
	height 		INT, 
	weigth	 	REAL,
	picture		TEXT, 
	color  		TEXT 
);
COMMIT;


INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt)
VALUES(1,"���� � ������������� �������","1 �� =","...")                   ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt)
VALUES(2,"����� ����","1 �����","20 �")                                   ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt)
VALUES(2,"������ ����","1 �����","25 �")                                  ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt)
VALUES(2,"����������� ����","1 �����","25 �")                             ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt)
VALUES(2,"�������","1/2 ���������","20 �")                                ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt)
VALUES(2,"������� (����� �������)","5 ����","15 �")                       ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt)
VALUES(2,"������ (�� �������)","2 �����","15 �")                          ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt)
VALUES(2,"������������ ������","1 ��. �����","15 �")                      ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt)
VALUES(2,"��������� ������","2 �����","25 �")                             ;

INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt)
VALUES(1,"���������� �������","1 �� =","...")                             ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt)
VALUES(2,"���������, �����, �����, ���������","1�2 ��. �����  ����������� �� ����� �������","15 �");
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt)
VALUES(2,"� ����� �������; ���� 2�4 ��. ����� ��������� ���������� ������� � ����������� �� ����� �������",".",".");
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt)
VALUES(1,"�����, �����, ����","1 �� =","...")                             ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt)
VALUES(2,"���������","1 ��. �����","15 �")                                ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt)
VALUES(2,"��������","1/2 �������","100 �")                                ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt)
VALUES(2,"���������� ������","1 ��. �����","15 �")                        ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt)
VALUES(2,"������","1 ��. �����","15 �")                                   ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt)
VALUES(2,"���� (�����)","1 ��. �����","15 �")                             ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt)
VALUES(2,"�������","1 ��. �����","15 �")                                  ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt)
VALUES(2,"������� ������","1 ��. �����","15 �")                           ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt)
VALUES(2,"��������","1 ��. �����","15 �")                                 ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt)
VALUES(2,"�����","1 ��. �����","15 �")                                    ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt)
VALUES(2,"���","1 ��. �����","15 �")                                      ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt)
VALUES(2,"� ������� � ���� 1 ��. ����� ����� �����; � ������ ���� (����) 1 �� ���������� � 2 ��. ������ ��������. ����, 2 ��. ����� ����� ���� = 1 ��!",".",".");
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt)
VALUES(1,"���������","1 �� =","...")                                      ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt)
VALUES(2,"���������","1 ������� ��������� � ������� ������� ����","65 �") ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt)
VALUES(2,"������������ ����","2 ��. ����� (� ������)","75 �")             ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt)
VALUES(2,"������� ���������","2 ��. ����� � ������","35 �")               ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt)
VALUES(2,"����� ���������","","25 �")                                     ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt) 
VALUES(1,"������ � �����","1 �� =","...")                                 ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt) 
VALUES(2,"��������","2�3 �����","110 �")                                  ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt) 
VALUES(2,"����","1 �����, �������","140 �")                               ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt)
VALUES(2,"������","1 ����� (���������� ����)","140 �")                    ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt) 
VALUES(2,"�����","1 �����","270 �")                                       ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt) 
VALUES(2,"��������","1 �����, �������","150 �")                           ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt) 
VALUES(2,"�����","1/2 �����, �������","70 �")                             ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt)
VALUES(2,"��������","7 ��. �����","140 �")                                ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt) 
VALUES(2,"��������","12 ����, ���������","70 �")                          ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt) 
VALUES(2,"�����","15 ����","90 �")                                        ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt) 
VALUES(2,"������","1 �����, �������","170 �")                             ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt)
VALUES(2,"���������","1/2 �����, �������","170 �")                        ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt) 
VALUES(2,"�����","1 �����, �������","90 �")                               ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt) 
VALUES(2,"����","1 �����","100 �")                                        ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt) 
VALUES(2,"�������","8 ��. �����","140 �")                                 ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt)
VALUES(2,"�����","1 �����","80 �")                                        ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt) 
VALUES(2,"����","1 �����, �������","110 �")                               ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt) 
VALUES(2,"��������","10 ����, �������","160 �")                           ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt) 
VALUES(2,"���������","6 ��. �����","120 �")                               ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt)
VALUES(2,"������","8 ��. �����","150 �")                                  ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt) 
VALUES(2,"�����","1 �����, ���������","110 �")                            ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt) 
VALUES(2,"���������","2-3 �����, �������","150 �")                        ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt) 
VALUES(2,"������","1 �����, �������","120 �")                             ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt)
VALUES(2,"�����","4 �����, �������","90 �")                               ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt) 
VALUES(2,"���������","7 ��. �����","140 �")                               ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt) 
VALUES(2,"�����","1 �����, �������","70 �")                               ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt) 
VALUES(2,"�������, ������ ���������","7 ��. �����","140 �")               ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt)
VALUES(2,"������","1 �����, �������","90 �")                              ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt)
VALUES(1,"� � ���������� � �������. ������������������� ��������� ���� �������������� ��� ��������������� ����� �������. ����� 100 �� ���� (��� ���������� ������, 100% ����������� ���) �������� �������� 1 ��. 6 � 8 ����� ���� (������, ��������� � ��� �����), � �������, ������������� 1 ���������� (1 ������ �����) ���� ����. ����� 20 � ����������� (������, ���������, ����, �����) �������� �������� 1 ��.",".",".");
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt)
VALUES(1,"������ � ������ �������� ��������","1 �� =","...")              ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt) 
VALUES(2,"������","1 ������","200 ��")                                    ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt) 
VALUES(2,"�����","1 ������","200 ��")                                     ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt) 
VALUES(2,"������","1 ������","200 ��")                                    ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt)
VALUES(1,"������ ��������","1 �� =","...")                                ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt) 
VALUES(2,"����","1 ������","200 ��")                                      ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt) 
VALUES(2,"����-����","1/2 �������","100 ��")                              ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt) 
VALUES(2,"���������","1 ������ (��� ����������)","65 �")                  ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt)
VALUES(2,"�����-�����","1 ��. ����� ��� �����","10 �")                    ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt)
VALUES(2,"����� �������","1 �����","10 �")                                ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt)
VALUES(2,"������ �������","7 ��. �����","100 �")                         ;
INSERT 	INTO help_bu_items(kind_of_item,description,measure_bu,measure_wt)
VALUES(1,"����������:","��������, �����, ������, �������, �������, ��������, ������� ����� �������� ��������, �� ���������� �� ������� �� ������� � ������� �������������.��������� ����� (�������, �����, ���������, ���) ����������� �� �� ��� ������������ ����� 200 �.��� ����������� ����� �������� �������� �������� �� ����� �������� � ���������, �� ���������� ��.","");
