package com.softtek.jpa.services;

import java.util.List;

import com.softtek.jpa.domain.Cart;
import com.softtek.jpa.domain.User;

public interface CartService {
	public List<Cart> cartList();
	public Cart cart(Long cart_id);
	public boolean update(Cart cart);
	public boolean newCart(Cart cart);
	public boolean deleteCart(Cart cart);
}
