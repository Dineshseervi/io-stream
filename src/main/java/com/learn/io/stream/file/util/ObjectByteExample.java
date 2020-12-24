package com.learn.io.stream.file.util;

import com.learn.io.stream.model.Student;

import java.io.*;

/**
 * This example will be help full to write and read byte from http response
 */
public class ObjectByteExample {

    public static void main(String[] args) {
        ObjectByteExample objectByteExample=new ObjectByteExample();
        Student student=new Student("Dinesh",27,4);
        try {
            byte [] byteArray= objectByteExample.getByteFromObject(student);
           Serializable object = objectByteExample.getObjectFromByte(byteArray);
            Student convertedObject=(Student) object;
            System.out.println(convertedObject.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public byte [] getByteFromObject(Serializable serializable) throws IOException {
        ByteArrayOutputStream  byteArrayOutputStream=new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream=null;
                try{
                    objectOutputStream=new ObjectOutputStream(byteArrayOutputStream);
                    objectOutputStream.writeObject(serializable);
                    objectOutputStream.flush();
                    byte[] yourBytes =   byteArrayOutputStream.toByteArray();
                    return yourBytes;
                }
                catch (Exception ex)
                {
                    ex.printStackTrace();
                }
                finally {
                    objectOutputStream.close();
                    byteArrayOutputStream.close();
                }
        return null;
    }

    public Serializable getObjectFromByte(byte [] bytearray)  {
        try(
        ByteArrayInputStream byteArrayInputStream =new ByteArrayInputStream(bytearray);
        ObjectInputStream objectInputStream=new ObjectInputStream(byteArrayInputStream);)
        {
            return (Serializable) objectInputStream.readObject();
        }
        catch (IOException | ClassNotFoundException ex)
        {
            ex.printStackTrace();
        }


        return null;
    }
}
