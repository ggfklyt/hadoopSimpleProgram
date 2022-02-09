import com.jcraft.jsch.IO;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.FsUrlStreamHandlerFactory;
import org.apache.hadoop.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class SimpleLocalLs {

    static {
        URL.setURLStreamHandlerFactory(new FsUrlStreamHandlerFactory());
    }

    public static void main(String[] args) throws IOException {
        InputStream in = null;
        try {
            in = new URL(args[0]).openStream();
            IOUtils.copyBytes(in, System.out, 4096, false);
        } finally {
            IOUtils.closeStream(in);
        }
//        DlsistributedFileSystem
//        Path path = new Path("hdfs://localhost:9000/new_dir/");
//        if (args.length == 1) {
//            path = new Path(args[0]);
//        }

//        Configuration conf = new Configuration();
//        FileSystem fs = FileSystem.get(conf);

//        FileStatus[] files = fs.listStatus(path);
//        for (FileStatus file : files) {
//            System.out.println(file.getPath().getName());
//        }
    }
}
