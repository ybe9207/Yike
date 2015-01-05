package yk.action;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import yk.bean.Page;
import yk.bean.Product;
import yk.service.ProductService;

public class ProductAction extends ActionSupport{
	private String productname;
	private String description;
	private File file;
	private String fileContentType;
	private String fileFileName;
	ProductService productService = null;
	
	//增加产品
	public String add(){
		String dir =null;//保存路径
		File target = null;
		String img = null;//文件的名字
		String id = null;
		productService = new ProductService();
		try{
			dir = ServletActionContext.getServletContext().getRealPath("/upload");
			id = UUID.randomUUID().toString();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
		    img =sdf.format(new Date());
			target = new File(dir,img+".jpg");
			FileUtils.copyFile(file, target);
			productService.add(productname,img,description,id);
			System.out.println(getFileContentType());
			ServletActionContext.getRequest().setAttribute("message", "添加成功!");
			return "success";
			}catch (Exception e){
				e.printStackTrace();
			return "input";
			}
		}
	
	//查询所有产品信息
	public String getAll(){
		Page page = null;
		String currentPage = null;
		productService = new ProductService();
		currentPage = ServletActionContext.getRequest().getParameter("currentPage");
		page = (Page) productService.getAll(currentPage);
		ServletActionContext.getRequest().setAttribute("page", page);
		return "success";
	}
	
	//编辑产品信息
	public String edit(){
		String id = null;
		Product product = null;
		productService = new ProductService();
		try{	
		id = ServletActionContext.getRequest().getParameter("id");
		product = (Product) productService.getOne(id);
		ServletActionContext.getRequest().setAttribute("product", product);
		}catch (Exception e){
			e.printStackTrace();
		}
		return "success";
	}
	//更新产品信息
	public String saveOne(){
		String dir =null;//保存路径
		File target = null;
		String path = null;//文件的路径
		String id = null;
		String img = null;
		productService = new ProductService();
			System.out.println("名字："+productname+"描述："+description+"文件:"+file);
			if(file == null){
				id = ServletActionContext.getRequest().getParameter("id");
				productService.saveOneNoimg(productname,description,id);
				ServletActionContext.getRequest().setAttribute("message", "更新成功");
				return "success";
			}else{
		try{
			dir = ServletActionContext.getServletContext().getRealPath("/upload");
			id = ServletActionContext.getRequest().getParameter("id");
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
		    img =sdf.format(new Date());
			target = new File(dir,img+".jpg");
			FileUtils.copyFile(file, target);
			productService.saveOne(productname,img,description,id);
			ServletActionContext.getRequest().setAttribute("message", "更新成功!");
			return "success";
			}catch (Exception e){
				e.printStackTrace();
			ServletActionContext.getRequest().setAttribute("message", "更新失败!");
			return "input";
			}
		}
	}

	public String delOne(){
		String id = null;
		productService = new ProductService();
		try{
			id = ServletActionContext.getRequest().getParameter("id");
			productService.delOne(id);
			ServletActionContext.getRequest().setAttribute("message", "删除成功!");
			return "success";
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}

	}
	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}
}
