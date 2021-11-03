package com.phamngoctruong.laptoppnt.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.phamngoctruong.laptoppnt._enum.EOrderStatus;
import com.phamngoctruong.laptoppnt.model.Cart;
import com.phamngoctruong.laptoppnt.model.Order;
import com.phamngoctruong.laptoppnt.model.Product;
import com.phamngoctruong.laptoppnt.model.Transaction;
import com.phamngoctruong.laptoppnt.repository.IOrderRepository;
import com.phamngoctruong.laptoppnt.utils.StringUtils;
import com.phamngoctruong.laptoppnt.utils.TimeUtlis;

@Service
public class OrderServices {
	@Autowired
	private IOrderRepository iOrderRepository;
	@Autowired
	private StringUtils sku;
	@Autowired
	private TimeUtlis time;
	@Autowired
	private TransactionServices transactionServices;
	@Autowired
	private EntityManager entityManager;

	public List<Order> findAllOrder() {
		return iOrderRepository.findAll();
	}

	public Order saveOrder(Order order) {
		return iOrderRepository.save(order);

	}

	public Order findOrderById(long idU) {
		return iOrderRepository.findById(idU).orElse(null);
	}

	public void proccessOrder(Order order, String proccess) {
		if (proccess.equals("true")) {
			order.setProcesss(false);
			order.setTransaction(null);
			iOrderRepository.save(order);

		} else {
			order.setProcesss(true);
			iOrderRepository.save(order);
			String mvc = sku.getSaltString("MVC_");
			Transaction transaction = new Transaction();
			transaction.setSku_mvc(mvc);
			transaction.setCreatedDate(time.convertToDateViaSqlTimestamp());
			transaction.setUpdatedDate(time.addDayTimeDate(3));
			transaction.setShipper("Giao hàng nhanh");
			transaction.setStatus(EOrderStatus.Shipping);
			transaction.setChecks(false);
			List<Order> list = new ArrayList<Order>();
			transaction.setSumTotalOrder(order.getTotal());
			list.add(order);
			transaction.setOrders(list);
			transaction.setUser(order.getUser());
			Transaction trans= transactionServices.saveTransaction(transaction);
			order.setTransaction(trans);
			iOrderRepository.save(order);
		}
	}

	public void deleteOrderById(long idu) {
		iOrderRepository.deleteById(idu);
	}

	public List<Order> findAllOrderByIdUser(long id) {
		return iOrderRepository.findAllOrderByIdUser(id);

	}

	@Transactional
	public void updateProduct(List<Product> product, Order orderS) {

		for (Product p : product) {
			entityManager.createNativeQuery(
					"INSERT INTO cdwebshoplaptop.orders_products (cdwebshoplaptop.orders_products.orders_id, cdwebshoplaptop.orders_products.products_id)\r\n"
							+ "VALUES (?, ? )")
					.setParameter(1, orderS).setParameter(2, p.getId()).executeUpdate();
		}

	}

	public List<Order> findAllByDate(Date date) {
		// TODO Auto-generated method stub
		return iOrderRepository.findAllByDate(date);
	}

}
