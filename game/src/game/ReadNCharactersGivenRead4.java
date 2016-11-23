/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

/**
 *
 * @author T440
 */

//The API: int read4(char *buf) reads 4 characters at a time from a file.
//
//The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.
//
//By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.
//
//Note: The read function may be called multiple times.

//
//复杂度
//时间 O(N) 空间 O(1)
//
//思路
//用一个临时数组，存放每次read4读到字符，再用一个指针标记buf数组目前存储到的位置，然后将这个临时数组的内容存到buf相应的位置就行了。
//这里需要注意两个corner case：
//
//如果本次读到多个字符，但是我们只需要其中一部分就能完成读取任务时，我们要拷贝的长度是本次读到的个数和剩余所需个数中较小的
//如果read4没有读满4个，说明数据已经读完，这时候对于读到的数据长度，因为也可能存在我们只需要其中一部分的情况，
//所以要返回总所需长度和目前已经读到的长度的较小的

public class ReadNCharactersGivenRead4 {
    public int read(char[] buf, int n) {
        for(int i = 0; i < n; i += 4){
            char[] tmp = new char[4];
            // 将数据读入临时数组
            int len = read4(tmp);
            // 将临时数组拷贝至buf数组，这里拷贝的长度是本次读到的个数和剩余所需个数中较小的
            System.arraycopy(tmp, 0, buf, i, Math.min(len, n - i));
            // 如果读不满4个，说明已经读完了，返回总所需长度和目前已经读到的长度的较小的
            if(len < 4) return Math.min(i + len, n);
        }
        // 如果循环内没有返回，说明读取的字符是4的倍数
        return n;
    }
}
