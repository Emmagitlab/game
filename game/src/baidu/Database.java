/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baidu;

/**
 *
 * @author T440
 */
import java.util.*;

public class Database {
    
    public static class Table {
        private final String name;
        private final String[] columnNames;
        private final List<List<Object>> data;
        public Table(String name, String[] columnNames, List<List<Object>> data) {
            this.name = name;
            this.columnNames = columnNames;
            this.data = data;
        }
        
        public void insert(Object[] row) {
            data.add(Arrays.asList(row));
        }
        
        public String getName() {
            return name;
        }
        
        public String[] getColumnNames() {
            return columnNames;
        }
        
        public List<List<Object>> getData() {
            return data;
        }
        
        Table result = null;
        
        
        public Table select(String[] projectedColumnNames) {
            // IMPLEMENT ME 
            List<List<Object>> tempData= this.data;
            List<List<Object>> tempSelect = new ArrayList<List<Object>>();
            List<String> colName = new ArrayList<String>();
            List<Integer> colsID = new ArrayList<Integer>();
            for(String col: projectedColumnNames){
                for(int i = 0; i < columnNames.length;i++){
                    if(columnNames[i].equals(col)){
                        colName.add(col);
                        colsID.add(i);
                    }
                }
            }
       
            for(int i = 0; i < tempData.size();i++){
                tempSelect.add(new ArrayList<Object>());
                for( Integer index : colsID){
                    tempSelect.get(i).add(tempData.get(i).get(index));      
                }
            }
           result = new Table(this.name,projectedColumnNames,tempSelect);
           //System.out.println("select:" + result);
           return result;
        }
        
        public Table where(String columnName, Object value) {
            // IMPLEMENT ME
            List<List<Object>> tmpWhere = new ArrayList<List<Object>>();
            int index  = 0;
            for(int i = 0; i < this.columnNames.length;i++){
                if(columnName.equals(this.columnNames[i])){
                    index = i;
                    break;
                }
            }
            for(List<Object> ele: this.data){
                if(ele.get(index).equals(value)){
                   tmpWhere.add(ele);
                }
            }
            result =  new Table(this.name,this.columnNames,tmpWhere);
           // System.out.println("Where:" + result);
            return result;
        }
        
        @Override
        public String toString() {
            StringBuffer sb = new StringBuffer(String.join(", ", columnNames)).append("\n");
            for (List<Object> row : data) {
                if (row.size() != 0) {
                    Object value = row.get(0);
                    sb.append(value == null ? "" : value.toString());
                    for (int i = 1; i < row.size(); i++) {
                        value = row.get(i);
                        sb.append(", ").append(value == null ? "" : value.toString());
                    }
                }
                sb.append("\n");
            }
            return sb.toString();
        }
    }
    
    private final Map<String, Table> tableMap;
    
    public Database() {
        this.tableMap = new HashMap<String, Table>();
    }
    
    public void addTable(Table table) {
        this.tableMap.put(table.getName(), table);
    }
    
    public Table getTable(String tableName) {
        return tableMap.get(tableName);
    }
    
    public Table innerJoin(Table leftTable, String leftTableKeyName, Table rightTable, String rightTableKeyName) {
        // IMPLEMENT ME
        List<List<Object>> leftData = leftTable.data;
        List<List<Object>> rightData = rightTable.data;
        List<String> cols = new ArrayList<String>();
        List<List<Object>> temp = new ArrayList<List<Object>>();
        int indexLeft = 0;
        int indexRight = 0;
        
        for(int i = 0; i < leftTable.getColumnNames().length;i++){
            String name = leftTable.getColumnNames()[i];
            cols.add(leftTable.name+"."+name);
            if(leftTableKeyName.equals(name)){
                indexLeft = i;
            }
        }
        for(int i = 0; i < rightTable.getColumnNames().length;i++){
            String name = rightTable.getColumnNames()[i];
            cols.add(rightTable.name+"."+name);
            if(rightTableKeyName.equals(name)){
                indexRight = i;
            }
        }
        HashMap<Object, List<Object>> map = new HashMap<>();
        for(List<Object> ele: rightData){
            Object key = ele.get(indexRight);
            map.put(key, ele);
        }
        for(List<Object> ele: leftData){
             List<Object> tempRight = new ArrayList<Object>();
             tempRight.addAll(ele);
             List<Object>tempLeft = map.get(tempRight.get(indexLeft));
             tempRight.addAll(tempLeft);
             temp.add(tempRight);  
        }
        String[] colsName = new String[cols.size()];
        int i = 0;
        for(String col: cols){
            colsName[i++] = col;
        }
        Table result = new Table("InnerJoin",colsName , temp);
        //System.out.println("inner:" + result);
        return result;
    }
    
    public Table leftJoin(Table leftTable, String leftTableKeyName, Table rightTable, String rightTableKeyName) {
        // IMPLEMENT ME
        List<List<Object>> leftData = leftTable.data;
        List<List<Object>> rightData = rightTable.data;
        List<String> cols = new ArrayList<String>();
        List<List<Object>> temp = new ArrayList<List<Object>>();
        List<List<Object>> tempNotMatch = new ArrayList<List<Object>>();
        int indexLeft = 0;
        int indexRight = 0;
        int count = 0;
        for(int i = 0; i < leftTable.getColumnNames().length;i++){
            String name = leftTable.getColumnNames()[i];
            cols.add(leftTable.name+"."+name);
            if(leftTableKeyName.equals(name)){
                indexLeft = i;
            }
        }
        for(int i = 0; i < rightTable.getColumnNames().length;i++){
            String name = rightTable.getColumnNames()[i];
            cols.add(rightTable.name+"."+name);
            if(rightTableKeyName.equals(name)){
                indexRight = i;
            }
        }
        
        
        HashMap<Object, List<List<Object>>> map = new HashMap<>();
        for(List<Object> ele: rightData){
            Object key = ele.get(indexRight);
            //System.out.println("key: "+ key.toString());
            if(!map.containsKey(key)){
                map.put(key,new ArrayList<List<Object>>());
            }
           // System.out.println("rightData:"+ ele.toString());
           map.get(key).add(ele);
           count = ele.size();
        }
        for(List<Object> ele: leftData){
             List<Object> tempRight = new ArrayList<Object>();
             tempRight.addAll(ele);
             List<Object>tempLeft  = null;
             if(map.containsKey(tempRight.get(indexLeft))){
                 int index = 0;
                 while(index < map.get(tempRight.get(indexLeft)).size()){
                    tempLeft = map.get(tempRight.get(indexLeft)).get(index);
                    List<Object> tmp = new ArrayList<Object>();
                    tmp.addAll(tempRight);
                    tmp.addAll(tempLeft);
                    temp.add(tmp); 
                    //tempRight.removeAll(tempLeft);
                    index++;
                 }
                
             } else {
                 List<Object> notMatch = new ArrayList<>();
                 while(count >0){
                     notMatch.add("");
                     count--;
                 }
                 tempLeft = notMatch;
                 tempRight.addAll(tempLeft);
                 tempNotMatch.add(tempRight);
             }
               
        }
        temp.addAll(tempNotMatch);
        String[] colsName = new String[cols.size()];
        int i = 0;
        for(String col: cols){
            colsName[i++] = col;
        }
        
        Table result = new Table("LeftJoin",colsName , temp);
        //System.out.println("leftJoin:" + result);
        return result;

    }
    
    public Table rightJoin(Table leftTable, String leftTableKeyName, Table rightTable, String rightTableKeyName) {
        // IMPLEMENT ME
        List<List<Object>> leftData = leftTable.data;
        List<List<Object>> rightData = rightTable.data;
        List<String> cols = new ArrayList<String>();
        List<List<Object>> temp = new ArrayList<List<Object>>();
        List<List<Object>> tempNotMatch = new ArrayList<List<Object>>();
        int indexLeft = 0;
        int indexRight = 0;
        int count = 0;
        for(int i = 0; i < rightTable.getColumnNames().length;i++){
            String name = rightTable.getColumnNames()[i];
            cols.add(rightTable.name+"."+name);
            if(rightTableKeyName.equals(name)){
                indexRight = i;
            }
        }
        
        for(int i = 0; i < leftTable.getColumnNames().length;i++){
            String name = leftTable.getColumnNames()[i];
            cols.add(leftTable.name+"."+name);
            if(leftTableKeyName.equals(name)){
                indexLeft = i;
            }
        }
        
        HashMap<Object, List<Object>> map = new HashMap<>();
        for(List<Object> ele: leftData){
            Object key = ele.get(indexLeft);
            map.put(key, ele);
            count = ele.size();
        }
        for(List<Object> ele: rightData){
             List<Object> tempRight = new ArrayList<Object>();
             //System.out.println(ele.toString());
             tempRight.addAll(ele);
             List<Object>tempLeft  = null;
             if(map.containsKey(tempRight.get(indexRight))){
                tempLeft = map.get(tempRight.get(indexRight));
             } else {
                 List<Object> notMatch = new ArrayList<>();
                 while(count >0){
                     notMatch.add("");
                     count--;
                 }
                 tempLeft = notMatch;
             }
             tempRight.addAll(tempLeft);
             tempNotMatch.add(tempRight);  
        }
        temp.addAll(tempNotMatch);
        String[] colsName = new String[cols.size()];
        int i = 0;
        for(String col: cols){
            colsName[i++] = col;
        }
        Table result = new Table("RightJoin",colsName , temp);
        //System.out.println("RightJoin:" + result);
        return result;
        
    }
    
    public Table outerJoin(Table leftTable, String leftTableKeyName, Table rightTable, String rightTableKeyName) {
        // IMPLEMENT ME
        Table right = rightJoin(leftTable, leftTableKeyName,  rightTable,  rightTableKeyName);
        //System.out.println(right);
        Table left = leftJoin(leftTable, leftTableKeyName,  rightTable, rightTableKeyName);
       // System.out.println(right);
        String[] rightNames = right.getColumnNames();
        String[] leftNames = left.getColumnNames();
        HashMap<String, Integer> map = new HashMap<>();
        List<Integer> order = new ArrayList<Integer>();
        List<List<Object>> res = new ArrayList<List<Object>>();
        List<List<Object>> notMatch = new ArrayList<List<Object>>();
        for(int i = 0; i < rightNames.length;i++){
            map.put(rightNames[i], i);
        }
        for(String leftName : leftNames){
            order.add(map.get(leftName));
            //System.out.print("order: " + map.get(leftName) );
        }
        for(List<Object> ele: left.data){
            List<Object> temp = new ArrayList<Object>();
            for(int i = 0; i < order.size();i++){
                temp.add(ele.get(order.get(i)));  
            }
           // System.out.println("left change order :" + temp.toString());
            res.add(temp);
        }
//        for(List<Object> ele: right.data){
//          System.out.println("right data: "+ ele.toString());
//        }
        int index = 0;
        HashMap<String,List<Object>> hashmapT = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        for(List<Object> ele:res){
            //System.out.println("right :"+ele.toString());
            //System.out.println("new :"+res.get(index).toString());
            hashmapT.put(ele.toString(), ele);
            
        }
        List<List<Object>> test = new ArrayList<List<Object>>();
        for(List<Object> ele: right.data){
           if(!hashmapT.containsKey(ele.toString())){
              // System.out.println("notMatch: " + ele.toString());
               notMatch.add(ele);
           }
        }
        res.addAll(notMatch);
        
        
        return new Table("OuterJoin", rightNames, res);
    }
    
    public static void main(String[] args) {
        Table departmentTable = new Table("departments", new String[]{"id", "name"}, new ArrayList<List<Object>>());
        departmentTable.insert(new Object[] {0, "engineering"});
        departmentTable.insert(new Object[] {1, "finance"});
        
        Table userTable = new Table("users", new String[]{"id", "department_id", "name"}, new ArrayList<List<Object>>());
        userTable.insert(new Object[] {0, 0, "Ian"});
        userTable.insert(new Object[] {1, 0, "John"});
        userTable.insert(new Object[] {2, 1, "Eddie"});
        userTable.insert(new Object[] {3, 1, "Mark"});
        
        Table salaryTable = new Table("salaries", new String[]{"id", "user_id", "amount"}, new ArrayList<List<Object>>());
        salaryTable.insert(new Object[] {0, 0, 100});
        salaryTable.insert(new Object[] {1, 1, 150});
        salaryTable.insert(new Object[] {2, 1, 200});
        salaryTable.insert(new Object[] {3, 3, 200});
        salaryTable.insert(new Object[] {4, 3, 300});
        salaryTable.insert(new Object[] {5, 4, 400});
        
        Database db = new Database();
        db.addTable(departmentTable);
        db.addTable(userTable);
        db.addTable(salaryTable);
        
        // should print
        // id, department_id, name
        // 1, 0, John
        System.out.println(db.getTable("users").where("id", 1).select(new String[] {"id", "department_id", "name"}));
       // System.out.println(db.getTable("users").select(new String[] {"department_id", "name"}));
        
        // should print
        // users.name, departments.name
        // Ian, engineering
        // John, engineering
        
        System.out.println(
                           db.innerJoin(db.getTable("users"), "department_id", db.getTable("departments"), "id")
                           .where("departments.name", "engineering")
                           .select(new String[]{"users.name", "departments.name"}));
        
        // should print
        // users.name, salaries.amount
        // Ian, 100
        // John, 150
        // John, 200
        // Mark, 200
        // Mark, 300
        // Eddie,
        
         System.out.println(
         db.leftJoin(db.getTable("users"), "id", db.getTable("salaries"), "user_id")
         .select(new String[]{"users.name", "salaries.amount"}));
        
        // should print
        // users.name, salaries.amount
        // Ian, 100
        // John, 150
        // John, 200
        // Mark, 200
        // Mark, 300
        //     , 400
        System.out.println(
         db.rightJoin(db.getTable("users"), "id", db.getTable("salaries"), "user_id")
         .select(new String[]{"users.name", "salaries.amount"}));
        
        // should print
        // users.name, salaries.amount
        // Ian, 100
        // John, 150
        // John, 200
        // Mark, 200
        // Mark, 300
        // Eddie,
        // , 400
        System.out.println(
         db.outerJoin(db.getTable("users"), "id", db.getTable("salaries"), "user_id")
         .select(new String[] {"users.name", "salaries.amount"}));
    }
}
