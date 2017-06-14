/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baidu;

import java.util.*;

/**
 *
 * @author T440
 */
public class FileSystem {
    class File{
        boolean isFile = false;
        Map<String, File> children = new HashMap<>();
        String content = "";
        
    }
    File root = null;

    public FileSystem() {
        root = new File();
    }
    
    public List<String> ls(String path) {
        String[] dirs = path.split("/");
        File node = root;
        List<String> result = new ArrayList<>();
        String name = "";
        for(String dir: dirs){
            if(dir.length() == 0) continue;
            if(!node.children.containsKey(dir)){
                return result;
            }
            node = node.children.get(dir);
            name = dir;
        }
        if(node.isFile){
            result.add(name);
        }else{
            for(String key: node.children.keySet()){
                result.add(key);
            }
        }
        Collections.sort(result);
        return result;
    }
    
    public void mkdirP(String path) {
        String[] dirs = path.split("/");
        File node = root;
        for(String dir: dirs){
            if(dir.length() == 0) continue;
            if(!node.children.containsKey(dir)){
                File file = new File();
                node.children.put(dir,file);
                
            }
            node = node.children.get(dir);
        }
    }
    
    public void addFileWithContent(String filePath, String content) {
        String[] dirs = filePath.split("/");
        File node = root;
        for(String dir: dirs){
            if(dir.length() == 0) continue;
            if(!node.children.containsKey(dir)){
                File file = new File();
                node.children.put(dir,file);
            }
            node = node.children.get(dir);
        }
        node.isFile = true;
        node.content += content;
    }
    
    public String getFileContent(String filePath) {
        String[] dirs = filePath.split("/");
        File node = root;
        for(String dir: dirs){
            if(dir.length() == 0) continue;
            if(!node.children.containsKey(dir)){
                File file = new File();
                node.children.put(dir,file);
            }
            node = node.children.get(dir);
            
        }
        return node.content;
    }
    
     public static void main(String[] args) {
    // assumption: all path starts with / and do not end with /
		FileSystem fs = new FileSystem();
		
		// should print []
		System.out.println(fs.ls("/"));
		
		fs.mkdirP("/a/b/c");
		
		fs.addFileWithContent("/a/b/c/d", "hello world");
		
		// should print [a]
		System.out.println(fs.ls("/"));
		
		// should print [d]
		System.out.println(fs.ls("/a/b/c"));
//		
//		// should print [d]
		System.out.println(fs.ls("/a/b/c/d"));
//		
//		// should print hello world
		System.out.println(fs.getFileContent("/a/b/c/d"));		
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */
