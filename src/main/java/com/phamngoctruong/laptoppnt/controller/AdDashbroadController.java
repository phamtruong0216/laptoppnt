package com.phamngoctruong.laptoppnt.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.phamngoctruong.laptoppnt.model.Notify;
import com.phamngoctruong.laptoppnt.model.Order;
import com.phamngoctruong.laptoppnt.model.Review;
import com.phamngoctruong.laptoppnt.model.Transaction;
import com.phamngoctruong.laptoppnt.model.User;
import com.phamngoctruong.laptoppnt.repository.INotifyResponsitory;
import com.phamngoctruong.laptoppnt.services.NotifyServices;
import com.phamngoctruong.laptoppnt.services.OrderServices;
import com.phamngoctruong.laptoppnt.services.ReviewServices;
import com.phamngoctruong.laptoppnt.services.TransactionServices;
import com.phamngoctruong.laptoppnt.services.UserServiceImpl;
import com.phamngoctruong.laptoppnt.utils.TimeUtlis;

@Controller
@RequestMapping("/admin/dashbroad/")
public class AdDashbroadController {
	@Autowired
	private ReviewServices reviewS;
	@Autowired
	private UserServiceImpl userS;
	@Autowired
	private OrderServices orderS;
	@Autowired
	private TimeUtlis time;
	@Autowired
	private TransactionServices transactionS;
	@Autowired
	private NotifyServices notifyServicer;

	@RequestMapping(value = "statistics", method = RequestMethod.GET)
	public String statisticsDashbroad(Model model,HttpServletRequest request) {
		String title="Thông kế website";
		model.addAttribute("title",title);
		List<Review> list = reviewS.findAllbyDate(time.convertToDateViaSqlTimestamp());
		model.addAttribute("listR", list);
		List<User> listU = userS.findAllByDate(time.convertToDateViaSqlTimestamp());
		model.addAttribute("listU", listU);
		List<Order> listOrders = orderS.findAllOrder();
		model.addAttribute("listOrders", listOrders);
		List<Transaction> listT = transactionS.findAllByDateDESC();
		model.addAttribute("listT", listT);
		HttpSession notify= request.getSession();
		List<Notify> listNoify = notifyServicer.getAllListNotifyNew();
		notify.setAttribute("listnoify", listNoify);
		return "/admin/index";

	}
}
