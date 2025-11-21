package com.saeyan.controller;

import com.saeyan.controller.action.Action;
import com.saeyan.controller.action.BoardDeleteAction;
import com.saeyan.controller.action.BoardListAction;
import com.saeyan.controller.action.BoardUpdateAction;
import com.saeyan.controller.action.BoardUpdateFormAction;
import com.saeyan.controller.action.BoardViewAction;
import com.saeyan.controller.action.BoardWriteAction;
import com.saeyan.controller.action.boardCheckAction;
import com.saeyan.controller.action.boardCheckPassFormAction;

public class ActionFactory {
	
	private static ActionFactory instance  = new ActionFactory();
	
	private ActionFactory() {}
	
	public static ActionFactory getInstance() {
		return instance;
	}
	                           //board_list
	public Action getAction(String command) {
		
		Action action  = null;
		
		System.out.println("ActionFactory : " + command);
		
		//조건문
		if(command.equals("board_list")) {
			action =  new BoardListAction();
		}else if(command.equals("board_write_form")) {
			action = new BoardWriteFormAction();
		}else if(command.equals("board_write")) {
			action = new BoardWriteAction();
		}else if(command.equals("board_view")) {
			action = new BoardViewAction();
		}else if(command.equals("board_check_pass_form")) {
			action = new boardCheckPassFormAction();
		}else if(command.equals("board_check_pass")) {
			action = new boardCheckAction();
		}else if(command.equals("board_delete")) {
			action = new BoardDeleteAction();
		}else if(command.equals("board_update_form")) {
			action = new BoardUpdateFormAction();
		}else if(command.equals("board_update")) {
			action = new BoardUpdateAction();
		}
		return action;
	}
	}
