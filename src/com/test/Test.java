package com.test;

import com.mysql.jdbc.Connection;

import db.DataBaseUtil;

public class Test {

	public static void main(String[] args) {
		try {
			Connection conn =(Connection) DataBaseUtil.getConnection();
			System.out.println("conn----------------"+conn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub

	}

}
