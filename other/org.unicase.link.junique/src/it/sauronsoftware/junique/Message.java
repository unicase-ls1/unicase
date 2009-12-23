/*
 * JUnique - Helps in preventing multiple instances of the same application Copyright (C) 2008-2009 Carlo Pelliccia
 * (www.sauronsoftware.it) This program is free software: you can redistribute it and/or modify it under the terms of
 * the GNU Lesser General Public License version 2.1, as published by the Free Software Foundation. This program is
 * distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License 2.1 for more details.
 * You should have received a copy of the GNU Lesser General Public License version 2.1 along with this program. If not,
 * see <http://www.gnu.org/licenses/>.
 */
package it.sauronsoftware.junique;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Small bug was fixed. The bug was in conversions of integer-to-byte_array and
 * byte_array-to-integer. The problem occurred when an integer is bigger than
 * 127. For example: if you convert 137 to byte array. it is [0] [0] [0] [-119]. 
 * When you convert this array to integer back, you get -119 as an integer. But,
 * it should be 137. I was added to method to do these conversions.
 */

/**
 * Static methods for encoding/decoding messages.
 * 
 * @author Carlo Pelliccia
 */
class Message {

	/**
	 * It reads a JUnique formatted message from an InputStream.
	 * 
	 * @param inputStream The source stream.
	 * @return The message decoded from the stream.
	 * @throws IOException In an I/O error occurs.
	 */
	public static String read(InputStream inputStream) throws IOException {
		// Message length (4 bytes)
		byte[] b = new byte[4];
		if (inputStream.read(b) != 4) {
			throw new IOException("Unexpected end of stream");
		}
		// Old, wrong code
		// int length = (b[0] << 24) | (b[1] << 16) | (b[2] << 8) | b[3];

		int length = byteArrayToInt(b);

		// Length validation.
		if (length < 0) {
			throw new IOException("Invalid length block");
		} else if (length == 0) {
			return "";
		} else {
			// The message in bytes.
			byte[] message = new byte[length];
			if (inputStream.read(message) != length) {
				throw new IOException("Unexpected end of stream");
			}
			// From bytes to string (utf-8).
			return new String(message, "UTF-8");
		}
	}

	/**
	 * It writes a JUnique formatted message in an OutputStream.
	 * 
	 * @param message The message.
	 * @param outputStream The OutputStream.
	 * @throws IOException In an I/O error occurs.
	 */
	public static void write(String message, OutputStream outputStream) throws IOException {
		// Is this message null?
		if (message == null) {
			// Writes a 0 length block.
			outputStream.write(0);
			outputStream.write(0);
			outputStream.write(0);
			outputStream.write(0);
			outputStream.flush();
		} else {
			// Message length.
			int length = message.length();
			// The length block.
			byte[] l = intToByteArray(length);

			// Old code
			// byte[] l = new byte[4];
			// l[0] = (byte) ((length >> 24) & 0xff);
			// l[1] = (byte) ((length >> 16) & 0xff);
			// l[2] = (byte) ((length >> 8) & 0xff);
			// l[3] = (byte) (length & 0xff);

			outputStream.write(l);
			outputStream.flush();
			// Message block.
			byte[] b = message.getBytes("UTF-8");
			outputStream.write(b);
			outputStream.flush();
		}
	}

	/**
	 * Converts integer to byte array whose length is 4.
	 * 
	 * @param value
	 * @return
	 */
	private static byte[] intToByteArray(int value) {
		byte[] b = new byte[4];
		for (int i = 0; i < 4; i++) {
			int offset = (3 - i) * 8;
			b[i] = (byte) ((value >> offset) & 0xFF);
		}
		return b;
	}

	/**
	 * Converts byte array to integer. Only first 4 indexes are used. For example, if you give an array with 5 bytes,
	 * index 4 byte is ignored.
	 * 
	 * @param b byte array whose length 4
	 * @return
	 */
	private static int byteArrayToInt(byte[] b) {
		int value = 0;
		for (int i = 0; i < 4; i++) {
			int shift = (3 - i) * 8;
			value += (b[i] & 0x000000FF) << shift;
		}
		return value;
	}

}
