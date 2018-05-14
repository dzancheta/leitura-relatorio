package br.com.listeners;

import java.util.List;

@FunctionalInterface
public interface FileListener {
    public void proccess(List<String> lines);
}
