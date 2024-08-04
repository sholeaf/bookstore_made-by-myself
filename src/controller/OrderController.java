package controller;

import java.util.ArrayList;

import model.dao.OrderDAO;
import model.dto.OrderDTO;

public class OrderController {

	public boolean addOrderList(String user_id,int book_id,String order_address) {
		OrderDAO orderDao = new OrderDAO();
		return orderDao.addOrderList(user_id,book_id,order_address);
	}

	public ArrayList<OrderDTO> getOrderList(String user_id) {
		OrderDAO orderDao =new OrderDAO();
		return orderDao.getOrderList(user_id);
	}
	public boolean deleteOrder(String user_id) {
		OrderDAO orderDao = new OrderDAO();
		return orderDao.deleteOrder(user_id);
	}
}
