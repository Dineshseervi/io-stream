package com.learn.io.stream.file.util;

import com.learn.io.stream.model.Student;
import org.apache.commons.lang3.SerializationUtils;

public class ObjectByteUsignUtil {

    public static void main(String[] args) {

        Student student=new Student("Dinesh",27,4);
        byte[] data = SerializationUtils.serialize(student);

       Student convertedObject= SerializationUtils.deserialize(data);
    }
}
