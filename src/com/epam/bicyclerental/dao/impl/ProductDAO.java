package com.epam.bicyclerental.dao.impl;

import com.epam.bicyclerental.bean.entity.Category;
import com.epam.bicyclerental.bean.entity.Product;
import com.epam.bicyclerental.bean.entity.ReportNode;
import com.epam.bicyclerental.constants.DBConstant;
import com.epam.bicyclerental.constants.ExceptionConstant;
import com.epam.bicyclerental.constants.SQLQueryConstant;
import com.epam.bicyclerental.dao.BicycleRentalDAO;
import com.epam.bicyclerental.dao.exception.DAOException;
import org.apache.log4j.Logger;

import java.sql.*;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements BicycleRentalDAO {

	public final static Logger LOGGER = Logger.getRootLogger();

	public Connection getConnection() throws DAOException{// почему метод public?
		Connection connection = null;
		try {
			Class.forName(DBConstant.DB_DRIVER);
			connection = DriverManager.getConnection(DBConstant.DB_URL, DBConstant.DB_LOGIN, DBConstant.DB_PASSWORD);

			LOGGER.info("get connection is success");
		} catch (ClassNotFoundException e) {

			throw new DAOException(ExceptionConstant.DB_DRIVER_CLASS_ERROR, e);

		} catch (SQLException e) {

			throw new DAOException(ExceptionConstant.DB_CONNECT_ERROR, e);
		}

		return connection;
	}

	@Override
	public void addProduct(Product product) throws DAOException {
		PreparedStatement preparedStatement = null;
		Connection connection = getConnection();
		try{
			preparedStatement = connection.prepareStatement(SQLQueryConstant.INSERT_QUERY);

			preparedStatement.setInt(1, product.getCategory().getId());
			preparedStatement.setString(2, product.getName());
			preparedStatement.setDouble(3, product.getPrice());
			preparedStatement.setString(4, product.getDescription());

			preparedStatement.executeUpdate();
		} catch (SQLException e){
			throw new DAOException(ExceptionConstant.SQL_FAIL, e);
		} finally {
			closeStatement(preparedStatement);
			closeConnection(connection);
		}
	}

	@Override
	public List<Product> findProductsByCategory(Category category) throws DAOException {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<Product> products = new ArrayList<>();
		Connection connection = getConnection();
		try{
			preparedStatement = connection.prepareStatement(SQLQueryConstant.SELECT_BY_CATEGORY_QUERY);

			preparedStatement.setInt(1, category.getId());

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()){
				products.add(createProduct(resultSet));
			}

			return products;
		} catch (SQLException e){
			throw new DAOException(ExceptionConstant.SQL_FAIL, e);
		} finally {
			closeResultSet(resultSet);
			closeStatement(preparedStatement);
			closeConnection(connection);
		}
	}

	@Override
	public void deleteProduct(Product product) throws DAOException {
		PreparedStatement preparedStatement = null;
		Connection connection = getConnection();
		try{
			preparedStatement = connection.prepareStatement(SQLQueryConstant.DELETE_QUERY);

			preparedStatement.setInt(1, product.getId());

			preparedStatement.executeUpdate();
		} catch (SQLException e){
			throw new DAOException(ExceptionConstant.SQL_FAIL, e);
		} finally {
			closeStatement(preparedStatement);
			closeConnection(connection);
		}
	}

	@Override
	public void updateProduct(Product product) throws DAOException {
		PreparedStatement preparedStatement = null;
		Connection connection = getConnection();

		try{
			preparedStatement = connection.prepareStatement(SQLQueryConstant.UPDATE_QUERY);

			preparedStatement.setInt(1, product.getCategory().getId());
			preparedStatement.setString(2, product.getName());
			preparedStatement.setDouble(3, product.getPrice());
			preparedStatement.setString(4, product.getDescription());
			preparedStatement.setInt(5, product.getId());

			preparedStatement.executeUpdate();
		} catch (SQLException e){
			throw new DAOException(ExceptionConstant.SQL_FAIL, e);
		} finally {
			closeStatement(preparedStatement);
			closeConnection(connection);
		}
	}


	@Override
	public List<Product> findAllProducts() throws DAOException {
		Statement statement = null;
		ResultSet resultSet = null;
		List<Product> products = new ArrayList<>();
		Connection connection = getConnection();

		try{
			statement = connection.createStatement();

			resultSet = statement.executeQuery(SQLQueryConstant.SELECT_ALL_QUERY);

			while (resultSet.next()){
				products.add(createProduct(resultSet));
			}

			return products;
		} catch (SQLException e){
			throw new DAOException(ExceptionConstant.SQL_FAIL, e);
		} finally {
			closeResultSet(resultSet);
			closeStatement(statement);
			closeConnection(connection);
		}
	}

	@Override
	public List<ReportNode> makeReport() throws DAOException {
		Statement statement = null;
		ResultSet resultSet = null;
		List<ReportNode> reports = new ArrayList<>();
		Connection connection = getConnection();

		try{
			statement = connection.createStatement();

			resultSet = statement.executeQuery(SQLQueryConstant.MAKE_REPORT_QUERY);

			while (resultSet.next()){
				ReportNode reportNode = new ReportNode();
				reportNode.setCategory(resultSet.getString(1));
				reportNode.setCount(resultSet.getInt(2));
				reportNode.setMaxPrice(resultSet.getDouble(3));
				reportNode.setMinPrice(resultSet.getDouble(4));
				reports.add(reportNode);
			}

			return reports;
		} catch (SQLException e){
			throw new DAOException(ExceptionConstant.SQL_FAIL, e);
		} finally {
			closeResultSet(resultSet);
			closeStatement(statement);
			closeConnection(connection);
		}
	}


	public void closeConnection(Connection connection) throws DAOException{// public? где же ты его вызывать-то собираешься?
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			LOGGER.error("can`t close connection");
		}
	}

	private Product createProduct(ResultSet resultSet) throws SQLException{
		Product product = new Product();
		Category Category = new Category();

		product.setId(resultSet.getInt(1));
		Category.setId(resultSet.getInt(5));
		Category.setName(resultSet.getString(6));
		product.setCategory(Category);
		product.setName(resultSet.getString(2));
		product.setPrice(resultSet.getDouble(3));
		product.setDescription(resultSet.getString(4));

		return product;
	}

	private void closeStatement(Statement statement){
		try {
			if (statement != null) {
				statement.close();
			}
		} catch (SQLException e){
			LOGGER.error("can`t close statement");
		}
	}

	private void closeResultSet(ResultSet resultSet){
		try {
			if (resultSet != null) {
				resultSet.close();
			}
		} catch (SQLException e){
			LOGGER.error("can`t close result set");
		}
	}
}
