package com.android.forge.contacts2;

import java.sql.SQLException;

import com.android.forge.Provider;

public class CallProvider implements Provider {
	private int _id;
	private String number;
	private long date;
	private int duration;
	private int type;
	private int newFlag;
	private String name;
	private int numbertype;
	private String numberlabel;
	
	private static final boolean CREATE = false;
	private static final boolean UPDATE = true;

	public CallProvider() {}
	
	public CallProvider(int _id, String number, long date, int duration, int type,
			int newFlag, String name, int numbertype, String numberlabel) {
		this._id = _id;
		this.number = number;
		this.date = date;
		this.duration = duration;
		this.type = type;
		this.newFlag = newFlag;
		this.name = name;
		this.numbertype = numbertype;
		this.numberlabel = numberlabel;
	}
	
	public void commit(boolean update) throws SQLException {
//		Connection androidConn = ContactCallConnection.getInstance();
//		PreparedStatement updateCallLog;
//		int index = 1;
//		
//		if (update) {
//			updateCallLog = androidConn.prepareStatement("UPDATE calls SET number = ?, date = ?, duration = ?, type = ?, new = ?, name = ?, numbertype = ?, numberlabel = ? WHERE _id = ?");
//			updateCallLog.setInt(9, _id);
//		} else {
//			updateCallLog = androidConn.prepareStatement("INSERT INTO calls (_id, number, date, duration, type, new, name, numbertype, numberlabel) VALUES(?,?,?,?,?,?,?,?,?)");
//			updateCallLog.setInt(index++, _id);
//		}
//	
//		updateCallLog.setString(index++, number);
//		updateCallLog.setLong(index++, date);
//		updateCallLog.setInt(index++, duration);
//		updateCallLog.setInt(index++, type);
//		updateCallLog.setInt(index++, newFlag);
//		updateCallLog.setString(index++, name);
//		updateCallLog.setInt(index++, numbertype);
//		updateCallLog.setString(index++, numberlabel);
//		if (updateCallLog.executeUpdate() < 1) {
//			throw new SQLException("INSERT WITH NO ROWS AFFECTED?!");
//		}
	}

	public Provider create() {
//		try {
//			generate();
//			commit(CREATE);
//			return this;
//		} catch (SQLException e) {
//			//TODO Exception handling
//		}
		return null;
	}
	
	public Provider update() {
//		// Store _id before being replaced by generator
//		int id = _id;
//		try {
//			generate();
//			// Restore _id for update to work
//			_id = id;
//			commit(UPDATE);
//			return this;
//		} catch (SQLException e) {
//			//TODO Exception handling
//		}
		return null;
	}

	public Provider delete() {
//		Connection androidConn = ContactCallConnection.getInstance();
//		try {
//			Statement deleteCallLogEntry = androidConn.createStatement();
//			deleteCallLogEntry.executeUpdate("DELETE FROM calls WHERE _id = " + _id);
//			deleteCallLogEntry.close();
//			return this;
//		} catch (SQLException e) {
//			//TODO Exception handling
//		}
		return null;
	}
	
	private void generate() throws SQLException {
//		Random rnd = new Random();
//		Connection namesConn = NamesConnection.getInstance();
//		Connection androidConn = ContactCallConnection.getInstance();
//
//		_id = 0;
//		Statement callLogQuery = androidConn.createStatement();
//		ResultSet callLogInsertId = callLogQuery.executeQuery("SELECT MAX(`_id`) FROM calls LIMIT 1");
//		_id = callLogInsertId.getInt(1) + 1;
//
//		duration = rnd.nextInt(7200);
//
//		date = DataGenerator.startDate + (long)(rnd.nextDouble() * (DataGenerator.endDate-DataGenerator.startDate));
//
//		type = rnd.nextInt(2) + 1;
//		newFlag = rnd.nextInt(1);
//
//
//		number = "";
//		Statement namesQuery = namesConn.createStatement();
//		ResultSet namesResult = namesQuery.executeQuery("SELECT * FROM `fakenames` WHERE ROWID="+(rnd.nextInt(499)+1));
//		number = namesResult.getString("telephonenumber");
//		
//		Statement contactQuery = androidConn.createStatement();
//		ResultSet contactDetails = contactQuery.executeQuery("SELECT raw_contacts.display_name AS name, data.data2 AS numbertype FROM raw_contacts JOIN data ON (data.raw_contact_id = raw_contacts._id) WHERE data.mimetype_id = 5 AND data.data1 = '" + number + "'");
//		try {
//			name = numberlabel = contactDetails.getString("name");
//			numbertype = contactDetails.getInt("numbertype");
//		} catch (SQLException e) {
//			numbertype = 0;
//			numberlabel = "";
//			name = "";
//		}
	}
	
}