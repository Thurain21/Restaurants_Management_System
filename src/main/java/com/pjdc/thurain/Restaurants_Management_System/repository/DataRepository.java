package com.pjdc.thurain.Restaurants_Management_System.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.pjdc.thurain.Restaurants_Management_System.model.DataForOrder;
import com.pjdc.thurain.Restaurants_Management_System.model.Item;
import com.pjdc.thurain.Restaurants_Management_System.model.OrderData;
import com.pjdc.thurain.Restaurants_Management_System.model.Table;

@Repository
public class DataRepository {

	@Autowired
	private JdbcTemplate jdbc;

	private static final String SELECT_TABLE = "SELECT \"tableId\", \"tableName\", \"tableStatus\" FROM public.\"Table\"";
	private static final String UPDATE_STATUS = "UPDATE public.\"Table\" SET \"tableName\"=?, \"tableStatus\"=? WHERE \"tableId\"=?;";
	private static final String SELECT_TABLE_ById = "SELECT \"tableId\", \"tableName\", \"tableStatus\" FROM public.\"Table\" WHERE \"tableId\"=?";
	private static final String SELECT_ORDERS = "SELECT o.\"orderItemId\", t.\"tableName\", i.\"itemName\", o.\"quantity\", o.\"price\", o.\"orderDate\" FROM public.\"OrderItems\" o INNER JOIN public.\"Table\" t ON o.\"tableId\" = t.\"tableId\" INNER JOIN public.\"Items\" i ON o.\"itemId\" = i.\"itemId\";";
	private static final String SELECT_ITEM = "SELECT \"itemId\", \"itemName\", \"itemPrice\" FROM public.\"Items\";";
	private static final String INSERT_ORDERS = "INSERT INTO public.\"OrderItems\" (\"itemId\", quantity, \"orderDate\", price, \"tableId\") VALUES (?, ?, ?, ?, ?);";

	public List<Table> selectTable() {
		return jdbc.query(SELECT_TABLE, new RowMapper<Table>() {

			@Override
			public Table mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new Table(rs.getInt("tableId"), rs.getString("tableName"), rs.getString("tableStatus"));
			}
		});
	}

	public int updateTableStatus(Table table) {
		return jdbc.update(UPDATE_STATUS, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(3, table.getTableId());
				ps.setString(1, table.getTableName());
				ps.setString(2, table.getTableStatus());
			}
		});
	}

	public Table updateTable(int tableId) {
		return jdbc.query(SELECT_TABLE_ById, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, tableId);
			}
		}, new ResultSetExtractor<Table>() {

			@Override
			public Table extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					return new Table(rs.getInt("tableId"), rs.getString("tableName"), rs.getString("tableStatus"));
				}

				return null;
			}
		});
	}

	public List<OrderData> selectOrder() {
		return jdbc.query(SELECT_ORDERS, new RowMapper<OrderData>() {

			@Override
			public OrderData mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new OrderData(rs.getInt("orderItemId"), rs.getString("tableName"), rs.getString("itemName"),
						rs.getInt("quantity"), rs.getString("price"), rs.getString("orderDate"));
			}
		});
	}

	public List<Item> selectItem() {
		return jdbc.query(SELECT_ITEM, new RowMapper<Item>() {

			@Override
			public Item mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new Item(rs.getInt("itemId"), rs.getString("itemName"), rs.getString("itemPrice"));
			}
		});
	}

	public int insertOrderData(List<DataForOrder> items, int tableId, String orderDate) {

        return jdbc.batchUpdate(INSERT_ORDERS, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                DataForOrder item = items.get(i);
                ps.setInt(1, item.getItemId());
                ps.setInt(2, item.getQuantity());
                ps.setString(3, orderDate);
                ps.setString(4, item.getPrice());
                ps.setInt(5, tableId);
            }

            @Override
            public int getBatchSize() {
                return items.size();
            }
        }).length;
    }
}

