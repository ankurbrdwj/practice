package com.sapient.metro.system.helper.api;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import com.sapient.metro.system.SmartCard;

public class SmartCardMapper implements RowMapper<SmartCard> {

	public void processRow(ResultSet arg0) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public SmartCard mapRow(ResultSet arg0, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
