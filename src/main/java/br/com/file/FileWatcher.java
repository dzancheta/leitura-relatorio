package br.com.file;

import br.com.dataanalytic.DataAnalytic;
import br.com.listeners.FileListener;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
public class FileWatcher {

    private Path dirsPath = Paths.get("%HOMEPATH%/data/in");
    private FileReader fileReader = new FileReader();
    private Set<FileListener> listeners = new HashSet<>();
    private DataAnalytic dataAnalytic = new DataAnalytic();

    public FileWatcher() {
    }

    public void watchFiles() throws IOException, InterruptedException {
        WatchService watchService = FileSystems.getDefault().newWatchService();
        dirsPath.register(
                watchService,
                StandardWatchEventKinds.ENTRY_CREATE
        );

        WatchKey watchKey;
        while ((watchKey = watchService.take()) != null) {
            for (WatchEvent<?> event : watchKey.pollEvents()) {
                if(!event.context().toString().contains("___jb_tmp___") && !event.context().toString().contains("___jb_old___")) {
                    notifyListeners(readFile(event.context().toString()));
                    dataAnalytic.formModel();
                }
            }
            watchKey.reset();
        }

    }


    public List<String> readFile(String fileName){
        return fileReader.read(Arrays.asList(new File(dirsPath + "/" + fileName)));
    }
    public void notifyListeners(List<String> lines){
        listeners.parallelStream()
                .forEach(ls -> ls.proccess(lines));
    }

    public void registerListeners(Set<? extends FileListener> listeners){
        this.listeners.addAll(listeners);
    }
}
