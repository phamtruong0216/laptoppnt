package com.phamngoctruong.laptoppnt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.phamngoctruong.laptoppnt.model.Notify;
import com.phamngoctruong.laptoppnt.model.Order;
import com.phamngoctruong.laptoppnt.security.AuthenticationFacade;
import com.phamngoctruong.laptoppnt.services.NotifyServices;
import com.phamngoctruong.laptoppnt.services.OrderServices;
import com.phamngoctruong.laptoppnt.utils.TimeUtlis;

@Controller
@RequestMapping("/tai-khoan/don-hang")
public class OrderController {
	@Autowired
	private OrderServices orderServer;
	@Autowired
	private AuthenticationFacade authentication;
	@Autowired
	private NotifyServices notifyServices;
	@Autowired
	private TimeUtlis time;
	@GetMapping("/danh-sach-dat-hang")
	public String orderView(Model model) {
		List<Order> list= orderServer.findAllOrderByIdUser(authentication.getIdUser());
		model.addAttribute("listOder", list);
		return "/account/order";

	}
	@GetMapping("/xoa")
	public ResponseEntity<Boolean> deleteReviewById(Model model,@RequestParam("id") String idR){
		try {
			long id= Long.parseLong(idR);		
			System.out.println(id);
			Order order=orderServer.findOrderById(id);
			orderServer.deleteOrderById(id);
			Notify senduser= new Notify();senduser.setUser(order.getUser());
			senduser.setContent("Đơn hàng đã hủy bởi khách hàng");senduser.setKeyword(order.getUser().getAccountDto().getEmail()+"hủy đơn hàng");senduser.setTime(time.convertToDateViaSqlTimestamp());
			notifyServices.Save(senduser);
			return new ResponseEntity<Boolean>(true,HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Boolean>(false,HttpStatus.BAD_REQUEST);
		}
		
	}
}
