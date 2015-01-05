package yk.service;

import java.util.List;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;

import yk.bean.Page;
import yk.bean.Product;
import yk.dao.ProductDao;

public class ProductService {
	ProductDao productDao = new ProductDao();
	public void add(String productname, String path,String description,String id) {
		Product product = new Product(id, productname, description, path);
		productDao.addOne(product);
	}
	public Object getAll(String currentPage) {
		Page page = null;
		Object products = null;
		int count = 0;
		ProductDao dao = null;
		List<Product> list = null;
		
		dao = new ProductDao();
		count = dao.getCount();
		if(StringUtils.isBlank(currentPage)){
			page = new Page(1,count);
		}else{
			page = new Page(Integer.parseInt(currentPage),count);
		}
		list = (List<Product>) dao.getPageData(page.getIndex(),page.getSize());
		page.setList(list);
		return page;
	}
	public Object getOne(String id) {
		Object obj = null;
		if(id == null){
			return null;
		}
		obj = productDao.getOne(id);
		return obj;
	}
	public void saveOne(String productname, String path, String description,
			String id) {
		Product product = new Product(id, productname, description, path);
		productDao.saveOne(product);
	}
	public void delOne(String id) {
		productDao.delOne(id);
	}
	public void saveOneNoimg(String productname, String description, String id) {
		productDao.saveNoimg(productname,description,id);
		
	}

}
