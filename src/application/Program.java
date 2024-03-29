package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.Db;
import db.DbException;
import db.DbIntegrityExeption;

public class Program {

	public static void main(String[] args) {
		Connection conn = null;

		PreparedStatement st = null;

		try {
			conn = Db.getConnection();

			st = conn.prepareStatement("DELETE FROM department " + "WHERE " + "Id = ?");

			st.setInt(1, 2);

			int rowAffect = st.executeUpdate();

			System.out.println("Done! Rows affect: " + rowAffect);

		} catch (SQLException e) {
			throw new DbIntegrityExeption(e.getMessage());
			// TODO: handle exception
		} finally {
			Db.closeStatement(st);
			Db.closeConnection();
		}

	}

}
