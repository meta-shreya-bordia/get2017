package com.metacube.shoppingcart.dao.product;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

import com.metacube.shoppingcart.dao.GenericJdbcDao;
import com.metacube.shoppingcart.modal.Product;

@Component("productDao")
public class JdbcProductDao extends GenericJdbcDao<Product, Integer> implements ProductDao {

	private String tableName = "product";

	public void setTableName(final String tableName)
	{
		this.tableName = tableName;
	}

	@Override public String getTableName()
	{
		return tableName;
	}

	@Override
	protected Product extractResultSetRow(ResultSet resultSet) {
		// TODO Auto-generated method stub
		Product product = new Product();
		try {
			product.setName(resultSet.getString("name"));
			product.setId(resultSet.getInt("id"));
			product.setPrice(resultSet.getDouble("price"));
			product.setImageUrl(resultSet.getString("imageUrl"));
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return product;
	}

	@Override
	protected String getPrimaryKeyColoumnName() {
		// TODO Auto-generated method stub
		return "id";
	}


}
