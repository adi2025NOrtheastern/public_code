/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aditicompany.MyException;

/**
 *
 * @author aditi
 */
public class EbookstoreException extends Exception {

	public EbookstoreException(String message)
	{
		super(message);
	}
	
	public EbookstoreException(String message, Throwable cause)
	{
		super(message,cause);
	}
}
