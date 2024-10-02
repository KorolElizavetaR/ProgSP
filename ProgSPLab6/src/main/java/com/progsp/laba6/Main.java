package com.progsp.laba6;

import javax.swing.JFrame;

import com.progsp.laba6.element.Frame;

/*
 * 		Разработать приложение управления тремя списками («Фамилия», «Имя», «Отчество») 
 * 		и строки редактирования (TextField). В строку редактирования вводится информация 
 * 		в формате «Фамилия Имя Отчество». По завершении ввода фамилия должна появиться в 
 * 		списке «Фамилия», имя в списке «Имя», отчество в списке «Отчество». Предусмотреть 
 * 		вывод сообщения в диалогое окно (Dialog), если количество введенных в списки ФИО 
 * 		будет превышать 10.
 */

public class Main {

	public static void main(String[] args) {
		JFrame window = new Frame();
		window.setVisible(true);
	}

}
