package kebbiter.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

class TcpSocket {

	private OutputStream write;
	private final String vbCrLf = System.getProperty("line.separator");
	private InputStream read;

	private void write(byte[] buff) {
		try {
			write.write(buff, 0, buff.length);
		} catch (Exception ignored) {

		}
	}

	private int readAvailable() {
		try {
			return read.available();
		} catch (Exception e) {
			return 0;
		}
	}

	private byte[] read() {
		try {
			byte[] buff = new byte[read.available()];
			read.read(buff, 0, buff.length);
			return buff;
		} catch (Exception e) {
			return new byte[0];
		}
	}

	public String requestData(String ip, String req) {
		Socket tcpComm;
		try {
			tcpComm = new Socket(ip, 80);
			write = tcpComm.getOutputStream();
			read = tcpComm.getInputStream();
		} catch (Exception e) {
			return "";
		}

		byte[] buff = genHeader(req, ip).getBytes();

		write(buff);

		boolean ready = false;
		int quit = 0;
		while (!ready) {
			sleep(50);
			quit++;
			if (readAvailable() > 10) {
				ready = true;
			}
			if (quit > 100) {
				ready = true;
			}
		}

		byte[] buffBack = read();
		String back = new String(buffBack);
		sleep(200);
		quit = 0;
		while (readAvailable() > 0) {
			byte[] buf = read();
			String addon = new String(buf);
			back = back + addon;
			sleep(200);
			quit++;
			if (quit > 20) {
				try {
					tcpComm.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return back;
			}
		}
		try {
			tcpComm.close();
		} catch (Exception ignored) {
		}
		return back;

	}

	private void sleep(int time) {
		try {
			Thread.sleep(time);
		} catch (Exception ignored) {

		}
	}

	private String genHeader(String req, String ip) {
		String out;
		out = "GET " + req + " HTTP/1.1" + vbCrLf;
		out = out + "Host: " + ip + vbCrLf;
		out = out + "Connection: keep-alive" + vbCrLf;
		out = out
				+ "Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8"
				+ vbCrLf;
		out = out + "Accept-Encoding: gzip,deflate,sdch" + vbCrLf;
		out = out + "Accept-Language: en-US,en;q=0.8" + vbCrLf;
		out = out + "Accept-Charset: ISO-8859-1,utf-8;q=0.7,*;q=0.3" + vbCrLf;
		out = out
				+ "User-Agent: Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.7 (KHTML, like Gecko) Chrome/16.0.912.77 Safari/535.7"
				+ vbCrLf + vbCrLf;
		return out;

	}

}