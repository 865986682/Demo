package lzc;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Test {
    public static void main(String[] args) throws IOException {
        byte[] generate = generate();
        Files.write(Paths.get("D:\\HelloWorld.class"), generate);
    }

    private static byte[] generate() throws IOException {
        ClassReader classReader = new ClassReader("lzc/HelloWorld");
        ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_MAXS);
        //处理
        ClassVisitor classVisitor = new MyClassVisitor(classWriter);
        classReader.accept(classVisitor, ClassReader.SKIP_DEBUG);
        // 生成字节数组
        return classWriter.toByteArray();
    }
}
