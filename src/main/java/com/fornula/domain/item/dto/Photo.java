package com.fornula.domain.item.dto;
/*
이름            널?       유형            
------------- -------- ------------- 
PHOTO_IDX     NOT NULL NUMBER        
ITEM_IDX      NOT NULL NUMBER        
ITEMFILE_NAME          VARCHAR2(100) 
*/
public class Photo {
	private int photoIdx;
	private int itemIdx;
	private String itemfileName;
}
