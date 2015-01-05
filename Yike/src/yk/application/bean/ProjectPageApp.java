package yk.application.bean;

import java.util.List;

import yk.bean.Project;

public class ProjectPageApp {
	//存储分页数据的集合
		private List<Project> list = null;
		//指定一页数据的开始位置
		private int index;
		//一页显示的数据数
		private int size = 16;
		//存储总页数
		private int allPage;
		//存储总记录数
		private int allCount;
		//存储当前页
		private int currentPage;
		//定义循环分页的宽度
		private int width = 5;
		//定义循环分页的开始位置
		private int begin = 0;
		//定义循环分页的结束位置
		private int end = 0;
		
		//定义构造函数进行初始化参数
		public ProjectPageApp(int currentPage, int allCount) {
			this.currentPage = currentPage;
			this.allCount = allCount;

			// 计算总页数 100/10=10 101/10 + 1=11
			if (this.allCount % this.size == 0) {
				this.allPage = this.allCount / this.size;
			} else {
				this.allPage = (this.allCount / this.size) + 1;
			}

			// 计算指定页数据的开始位置
			this.index = (this.currentPage - 1) * this.size;
			
			// 初始化循环的开始和结束变量
			if(this.allPage <= this.width){  // 5  10   100
				this.begin = 1;
				this.end = this.allPage;
			}else{ 
				// 2 3 4 
				this.begin = this.currentPage - 4;
				// 100 + 5  = 105  100
				this.end = this.currentPage + 5;
				
				// 判断参数是否越界
				if(this.begin <= 0){
					this.begin = 1;
					this.end = 10;
				}
				if(this.end > this.allPage){
					this.end = this.allPage;
					this.begin = this.allPage - 9;
				}
			}
		}
		
		
		public List<Project> getList() {
			return list;
		}
		public void setList(List<Project> list) {
			this.list = list;
		}
		public int getIndex() {
			return index;
		}
		public void setIndex(int index) {
			this.index = index;
		}
		public int getSize() {
			return size;
		}
		public void setSize(int size) {
			this.size = size;
		}
		public int getAllPage() {
			return allPage;
		}
		public void setAllPage(int allPage) {
			this.allPage = allPage;
		}
		public int getAllCount() {
			return allCount;
		}
		public void setAllCount(int allCount) {
			this.allCount = allCount;
		}
		public int getCurrentPage() {
			return currentPage;
		}
		public void setCurrentPage(int currentPage) {
			this.currentPage = currentPage;
		}
		public int getWidth() {
			return width;
		}
		public void setWidth(int width) {
			this.width = width;
		}
		public int getBegin() {
			return begin;
		}
		public void setBegin(int begin) {
			this.begin = begin;
		}
		public int getEnd() {
			return end;
		}
		public void setEnd(int end) {
			this.end = end;
		}
		
}
