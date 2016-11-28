/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;
import java.io.*;
import java.util.*;
/**
 *
 * @author T440
 */

//如果都是sparse vectors,那思路就是把每个vector都表示成(index, non-zero value) pairs:
//A =[0,2,0,2,0,0,3,0,0,4] ==> A={(1,2), (3,2), (6,3), (9,4)}
//B=[0,0,0,0,5,0,2,0,0,8]  ==> B={(4,5), (6,2), (9,8)}


/*小哥说既然你有machine learning经验，那来你应该知道很多特征vector/matrix都是稀疏的，
这题我见过啊！！！感谢地里！！先问我sparse vector 怎么表示比较好，
然后让写代码求两个sparse vector dot product。再follow up， 如果一个vector 比另一个大很多怎么办，
答对于小的vector里每一个（index， value），在大的里binary search。然后问了复杂度。
*/

/*一开始说连个hashmap，小哥说hashmap会浪费掉多余空间，
我说那如果一个特别大的话就扫小一点的那个array，
然后在特别大的array中用binary search，他说写代码。
写完代码接着说，那如果差不多大，我说那就两个指针按照merge sort那么扫。
然后我觉得基本都行了，他最后说那有没有O(Math.min(m, n))的方法。我鼓捣半天，
最后说了个那就输入直接是一个tuple，第一个elem是位置（这个位置在两个array中必须都不是0），
然后扫一遍就行了。其实我感觉他的意思是再用HashMap。不过他忘了之前和我说太浪费空间了。。。

/*于是第一个优化的想法是将向量变为这样的模式
向量A:{<x1',loc1'>,<x2',loc2'>...<xn',locn'>}
向量B:{<y1',loc1'>,<y2',loc2'>...<yn',locn'>},这里locx表示元素的位置信
息。
每个向量都不含零元素，或者接近于零的浮点数。显然向量数量远小于n，且向
量A，B的长度取决于各自的非零元，不妨设向量A长度为m，向量B长度为n.
那么计算A*B，可以采用在向量A中循环，在向量B中二分的方法，例如找到向量A
的首原素，<x1',loc1'>,将其位置loc1'在向量B中折半查找，直到找到，或者失
败。
这样计算代价为mlogn + min(m,n),前部为查找代价，后部为加法代价，加法代
价必然比min(m,n)还要小,最大情况下为min(m,n)-1。*/

/*是要保存两个arraylist 一个是存index，一个存value吗？为什么这个比较省空间呢？
用hashmap 存index，value，比两个arraylist的性能差在哪里？
第一题我是用的arraylist来存的，比较省空间，然后能保持index有序性，
hashtable存的话follow up就不能二分法了吧。
因为你只保存了非0元素呀，vector是稀疏的，这样就只需要保存很少。 
hashmap存的话算dot product是没问题的，但Follow up里(index, value)表示后的向量一个很长，
一个很短的话，就不能用二分查找了。我觉得是这样
*/

public class SparseVectorDotProduct {
    // method1
    public int multiply(int[] A, int[] B){ 
        HashMap<Integer,Integer> mapA = new HashMap<>();
        HashMap<Integer,Integer> mapB = new HashMap<>();
        int result =0;
        for(int i = 0; i < A.length; i++){
            if(A[i] != 0){
                mapA.put(i, A[i]); }
        }
        for(int i = 0; i < B.length; i++){
            if(B[i] != 0){
                mapB.put(i, B[i]); }
        }
        int len = A.length < B.length? A.length:B.length;
        for(int i = 0; i < len; i++){
            if(mapA.containsKey(i)&& mapB.containsKey(i)){
                result += mapA.get(i)*mapB.get(i);}
        }
        return result;
    }
    public static void main(String[] args){
        int[] A = {0,2,0,2,0,0,3,0,0,4};
        int[] B = {0,0,0,0,5,0,2,0,0,8};
        SparseVectorDotProduct svd = new SparseVectorDotProduct();
        System.out.print(""+svd.multiply(A, B));
    }
    
    
}
