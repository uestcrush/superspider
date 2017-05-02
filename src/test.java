/**
 * Created by Administrator on 2017/5/1.
 */

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class test {



    public static void main(String[]args){

        String url="https://github.com/uestcrush";
        String result="这就是截取内容：";
        BufferedReader in= null;
        try{
            URL realUrl=new URL(url);
            URLConnection connection=realUrl.openConnection();
            connection.connect();
            in=new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line=in.readLine())!=null){
                result +=line + "/n";
            }





        } catch (MalformedURLException e)
        { System.out.println("发送get请求出现异常！"+e);
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally{
            try{
                if (in!=null)
                    in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(result);
    }
}
