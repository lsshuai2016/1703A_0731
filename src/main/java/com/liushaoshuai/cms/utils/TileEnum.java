package com.liushaoshuai.cms.utils;

public enum TileEnum {
	COLOR_RED("color:red","标红"),FONTWEIGHT("font-weight:800","加粗"),
	FONTSTYLE("font-style:italic","斜体"),STYLE_NONE("text-decoration:none;color:inherit","无样式");
	
	
	private String code;
	private String value;
	TileEnum(String code, String value) {
		this.code = code;
		this.value = value;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	public static void main(String[] args) {
		TileEnum[] enums = TileEnum.values();
		for(TileEnum e : enums) {
			System.out.println(e.getCode()+":"+e.getValue());
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
