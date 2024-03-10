package Java输入输出流;

import java.io.*;

class Student implements Serializable{
    private static final long serialVersionUID=1l;
    int id;
    String name;
    int age;
    public Student(int id,String name,int age){
        super();
        this.id=id;
        this.name=name;
        this.age=age;
    }

    @Override
    public String toString() {
        return "Student[id="+id+",name="+name+",age="+age+"]";
    }
}
public class 引例 {
    public static void main(String[] args){
        FileOutputStream fileOutputStream=null;
        FileInputStream fileInputStream=null;
        ObjectInputStream objectInputStream=null;
        ObjectOutputStream objectOutputStream=null;
        try{
            Student stu1=new Student(10001,"张三",18);
            fileOutputStream=new FileOutputStream("d:/c.text");
            objectOutputStream=new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(stu1);
            objectOutputStream.flush();
            fileInputStream=new FileInputStream("d:/c.txt");
            objectInputStream=new ObjectInputStream(fileInputStream);
            Student stu2=(Student) objectInputStream.readObject();
            System.out.printf(String.valueOf(stu2));
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (objectOutputStream!=null){
                try{
                    objectOutputStream.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            if (fileOutputStream!=null){
                try {
                    fileOutputStream.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            if (objectOutputStream!=null){
                try {
                    objectInputStream.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            if (fileOutputStream!=null){
                try {
                    fileOutputStream.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
