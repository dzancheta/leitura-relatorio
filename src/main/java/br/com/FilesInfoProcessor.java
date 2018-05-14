package br.com;

import br.com.dataanalytic.DataAnalytic;
import br.com.file.FileReader;
import br.com.file.FileWatcher;
import br.com.listeners.CustomerFileListener;
import br.com.listeners.FileListener;
import br.com.listeners.SaleFileListener;
import br.com.listeners.SalesmanFileListener;
import org.apache.tomcat.util.http.fileupload.FileUpload;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FilesInfoProcessor {
    private static Path dirsPath = Paths.get("%HOMEPATH%/data/in");
    private FileWatcher fileWatcher = new FileWatcher();
    private FileReader fileReader = new FileReader();
    private DataAnalytic dataAnalytic = new DataAnalytic();
    private Set<FileListener> listeners = new HashSet(Arrays.asList(new CustomerFileListener(), new SalesmanFileListener(), new SaleFileListener()));
    public void processFilesInformations(){
        registerFileListeners();
        readExistentFiles();
        try {
            fileWatcher.watchFiles();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void registerFileListeners(){
        fileWatcher.registerListeners(listeners);
    }

    private void readExistentFiles() {
        List<String> lines = fileReader.read(Arrays.asList(new File(dirsPath.getFileName().toString()).listFiles()));
        if(!lines.isEmpty()) {
            fileWatcher.notifyListeners(lines);
            dataAnalytic.formModel();
        }
    }
}
