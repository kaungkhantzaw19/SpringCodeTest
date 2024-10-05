package com.Spring.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Spring.model.ProductBean;

public class ProductRepo {
	DataBaseConnection dbc=new DataBaseConnection();
	public int addProductRepo(ProductBean pb) {
		Connection con=dbc.getConnection();
		int i=0;
		String query="insert into codetest.product (product_name,brand,price) values(?,?,?);";
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1,pb.getProduct_name() );
			ps.setString(2,pb.getBrand() );
			ps.setDouble(3, pb.getPrice());
			i=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	
	}
	public List<ProductBean> showProductRepo(){
		Connection con=dbc.getConnection();
		List<ProductBean>list=new ArrayList<ProductBean>();
		ProductBean pb=null;
		String query="SELECT * FROM codetest.product where status=1;";
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				pb=new ProductBean();
				pb.setId(rs.getInt(1));
				pb.setProduct_name(rs.getString(2));
				pb.setBrand(rs.getString(3));
				pb.setPrice(rs.getDouble(4));
				list.add(pb);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}
	public int updateRepo(ProductBean pb ) {
		Connection con=dbc.getConnection();
		int i=0;
		String query="UPDATE product SET product_name=?,brand=?,price=? where id=? ";
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, pb.getProduct_name());
			ps.setString(2, pb.getBrand());
			ps.setDouble(3, pb.getPrice());
			ps.setInt(4, pb.getId());
			i=ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
		
	}
	public int deleteRepo(int id) {
		Connection con=dbc.getConnection();
		int i=0;
		String query="UPDATE product SET status=0 where id=?";
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, id);
			i=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

}
