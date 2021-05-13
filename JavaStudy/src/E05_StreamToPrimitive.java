import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

import org.omg.CORBA.portable.UnknownException;


public class E05_StreamToPrimitive {
	public static void main(String[] args) {
		File file = new File("myData.data");
		try {
			FileOutputStream fout = new FileOutputStream(file);
			DataOutputStream dout = new DataOutputStream(fout);
			OutputStreamWriter writer = new OutputStreamWriter(fout, Charset.forName("UTF-8"));
			
			dout.writeInt(9990);
			dout.writeInt(3000);
			dout.writeInt(850);
			dout.writeFloat(123.123F);
			dout.writeDouble(12345.123456778);
			dout.writeUTF("UTF타입으로 쓰기");
			dout.writeBoolean(false);
			
			//사용한 스트림은 나중에 만든 순서대로 차례대로 닫아줘야 한다.
//			writer.flush();
			
			writer.close();
			dout.close();
//			fout.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		FileInputStream fin;
		DataInputStream din = null;
		InputStreamReader in;
		try {
			fin = new FileInputStream(file);
			din = new DataInputStream(fin);
			System.out.println(din.readInt());//9990
			System.out.println(din.readInt());//3000
			System.out.println(din.readInt());//850
			System.out.println(din.readFloat());//123.123
			System.out.println(din.readDouble());//12345.123456778
			System.out.println(din.readUTF());//UTF타입으로 쓰기
			System.out.println(din.readBoolean());//false
			System.out.println(din.readUTF());//UTF타입으로 쓰기
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Exception e) {
			System.out.println("끝");
		}finally {
			try {
				din.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
