package xtu.bit.learner;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;

/**
 * Created by zhangdi21 on 2019/5/23.
 */
public class LearnerClassloader extends ClassLoader{

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            byte[] bytes = getBytesByPath(name);
            Class<?> aClass = defineClass(null, bytes, 0, bytes.length);
            return aClass;
        }catch (Exception e){
            System.out.println("IOException");
        }
        return super.findClass(name);
    }

    /**
     * 获取指定路径的字节码
     * @param name
     * @return
     * @throws IOException
     */
    public byte[] getBytesByPath(String name) throws IOException{
        FileInputStream fileInputStream = new FileInputStream(name);
        FileChannel channel = fileInputStream.getChannel();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        WritableByteChannel byteChannel = Channels.newChannel(outputStream);
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        try {
            int flag;
            while ((flag = channel.read(buffer)) != -1) {
                if (flag == 0) break;
                buffer.flip();
                byteChannel.write(buffer);
                buffer.clear();
            }
        }catch ( IOException e ){
            System.out.println("can't read!");
            throw e;
        }
        fileInputStream.close();
        channel.close();
        byteChannel.close();
        System.out.println("class binay length:"+outputStream.toByteArray().length);
        return outputStream.toByteArray();
    }

}
