package com.app.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.model.Product;
import com.app.model.productType;
import com.app.repository.JdbcProductRepository;
import com.app.repository.ProductRepository;

@WebServlet(urlPatterns = { "/products", "/products/delete", "/products/new" })
public class ProductController extends HttpServlet {

	private ProductRepository productRepository;

	@Override
	public void init(ServletConfig config) throws ServletException {
		// System.out.println("ProductController :: init()");
		// only 1 time create
		productRepository = new JdbcProductRepository();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// System.out.println("ProductController :: doGet()");

		String reqURI = req.getRequestURI();
		if (reqURI.equals("/PM/products")) {
			List<Product> products = productRepository.findAll();
			req.setAttribute("products", products);
			req.getRequestDispatcher("/products-view.jsp").forward(req, resp);
		}
		
		if (reqURI.equals("/PM/products/delete")) {
			String id = req.getParameter("id");
			productRepository.delete(Integer.parseInt(id));
			resp.sendRedirect("/PM/products");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name = req.getParameter("name");
		String price = req.getParameter("price");
		String type = req.getParameter("type");
		// validation & conversion
		Product product=new Product();
		product.setName(name);
		product.setPrice(Double.parseDouble(price));
		product.setType(productType.valueOf(type));
		productRepository.save(product);
		resp.sendRedirect("/PM/products");
	}

	
	@Override
	public void destroy() {
		// System.out.println("ProductController :: destroy()");
	}

}
