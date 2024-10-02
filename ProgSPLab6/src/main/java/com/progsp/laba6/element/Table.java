package com.progsp.laba6.element;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import lombok.Getter;

public class Table extends JTable{
	@Getter
	private static final DefaultTableModel tableModel = 
			new DefaultTableModel(new String[]{"Фамилия", "Имя", "Отчество"}, 0);
	@Getter
	private static final int TABLE_LIMIT = 10;
	
	Table()
	{
		super(tableModel);
	}
}
