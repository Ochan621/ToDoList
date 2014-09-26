package com.example.todolist;

import android.widget.CheckBox;

public class ListItems {
	public String title;
	public CheckBox cbox;
	public ListItems(){
		super();
	}
	
	public ListItems(CheckBox cbox, String title)
	{
		super();
		this.cbox = cbox;
		this.title = title;
	}

}
