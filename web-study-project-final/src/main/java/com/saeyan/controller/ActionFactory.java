package com.saeyan.controller;

import com.saeyan.controller.action.FruitControlAction;
import com.saeyan.controller.action.FruitCheckPassAction;
import com.saeyan.controller.action.FruitCheckPassFormAction;
import com.saeyan.controller.action.FruitDeleteAction;
import com.saeyan.controller.action.FruitEditFormAction;
import com.saeyan.controller.action.FruitJoinAction;
import com.saeyan.controller.action.FruitNDPAction;
import com.saeyan.controller.action.FruitNDPUpdateAction;
import com.saeyan.controller.action.FruitNDPUpdateFormAction;
import com.saeyan.controller.action.FruitNDPformAction;
import com.saeyan.controller.action.FruitNDPwriteAction;
import com.saeyan.controller.action.FruitUDPAction;
import com.saeyan.controller.action.FruitUDPDeleteAction;
import com.saeyan.controller.action.FruitJoinFormAction;
import com.saeyan.controller.action.FruitFindIdAction;
import com.saeyan.controller.action.FruitFindIdFormAction;
import com.saeyan.controller.action.FruitFindPwAction;
import com.saeyan.controller.action.FruitFindPwFormAction;
import com.saeyan.controller.action.FruitUpdateAction;
import com.saeyan.controller.action.Action;
import com.saeyan.controller.action.FruitHomeAction;
import com.saeyan.controller.action.FruitIdCheckAction;
import com.saeyan.controller.action.FruitLoginAction;
import com.saeyan.controller.action.FruitLoginProcessAction;
import com.saeyan.controller.action.FruitLogoutAction;
import com.saeyan.controller.action.ProductDeleteAction;
import com.saeyan.controller.action.ProductListAction;
import com.saeyan.controller.action.ProductUpdateAction;
import com.saeyan.controller.action.ProductUpdateFormAction;
import com.saeyan.controller.action.ProductWriteAction;
import com.saeyan.controller.action.ProductWriteFormAction;
import com.saeyan.controller.action.ProductviewFormAction;

public class ActionFactory {

	private static ActionFactory instance = new ActionFactory();
	
	private ActionFactory() {
				
	}
	
	public static ActionFactory getInstance() {
		return instance;
	}
	
	public Action getAction(String command) {
		Action action = null;
		
		System.out.println("ActionFactory : " + command);
		
		//조건문
		if(command.equals("fruit_home")) {
			action = new FruitHomeAction();
			
		}else if (command.equals("fruit_login")) {
			action = new FruitLoginAction();
		
		
		}else if (command.equals("fruit_Control")) {
			action=new FruitControlAction();
			
		
			
		}else if (command.equals("fruit_Join")) {
		    // 회원가입 화면 표시
		    action = new FruitJoinFormAction();

		}else if (command.equals("fruit_join_action")) {
		    // 회원가입 처리
		    action = new FruitJoinAction();
			
		}else if (command.equals("fruit_NDP")) {
			action=new FruitNDPAction();
			
		}else if (command.equals("fruit_UDP")) {
			action=new FruitUDPAction();
			
		}else if (command.equals("fruit_NDP_form")) {
			action=new FruitNDPformAction();
			
		}else if (command.equals("fruit_write")) {
			action=new FruitNDPwriteAction();
			
		}else if (command.equals("fruit_check_pass_form")) {
			action=new FruitCheckPassFormAction();
			
		}else if (command.equals("fruit_check_pass")) {
			action=new FruitCheckPassAction();
			
		}else if (command.equals("fruit_delete")) {
			action=new FruitDeleteAction();
		}else if (command.equals("fruit_NDPupdate_form")) {
			action=new FruitNDPUpdateFormAction();
			
		}else if (command.equals("fruit_NDPupdate")) {
			action=new FruitNDPUpdateAction();
		}

		
		
		else if (command.equals("fruit_update")) {
			action = new FruitUpdateAction();
		}else if (command.equals("fruit_find_id_form")) {
			action = new FruitFindIdFormAction();
		}else if (command.equals("fruit_find_id_action")) {
			action = new FruitFindIdAction();
		}else if (command.equals("fruit_find_pw_form")) {
			action = new FruitFindPwFormAction();
		}else if (command.equals("fruit_find_pw_action")) {
			action = new FruitFindPwAction();
		}else if (command.equals("fruit_id_check")) {
			action = new FruitIdCheckAction();
		}
		
		else if(command.equals("fruit_edit_form")) {
        action = new FruitEditFormAction(); // ✔ 수정 폼 Action
		}
		else if(command.equals("fruit_logout")) {
	        action = new FruitLogoutAction(); 
			}
		else if(command.equals("fruit_UDP_delete")) {
	        action = new FruitUDPDeleteAction(); 
			}
		
		
		else if(command.equals("fruit_login_process")) {
	        action = new FruitLoginProcessAction(); 
			}
		
		
		//상품
		 else if(command.equals("product_list")) {
		action = new ProductListAction();
		
		} 
		
		 else if(command.equals("product_update_form")) {
				action = new ProductUpdateFormAction();
				
		}
		
		 else if(command.equals("product_update")) {
				action = new ProductUpdateAction();
				
		}
		
		 else if(command.equals("product_delete")) {
				action = new ProductDeleteAction();
				
		}
		
		 else if(command.equals("product_write_form")) {
				action = new ProductWriteFormAction();
				
		}
		
		 else if(command.equals("product_write")) {
				action = new ProductWriteAction();
				
		} else if(command.equals("product_view_form")) {
			action = new ProductviewFormAction();
			
	}
		
		
		
		
		
		
		return action;
		
	}
	
}
 